package me.myProjects.microservice.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by chendong on 2016/7/8
 */
public class PropertiesHolder {

    private static final Logger log = LoggerFactory.getLogger(PropertiesHolder.class);

    private static Map<String, Properties> props = new HashMap<>();

    private static PropertiesHolder instance;

    private PropertiesHolder() {
    }

    public static PropertiesHolder getInstance() {
        if (instance == null) {
            synchronized (PropertiesHolder.class) {
                if (instance == null) {
                    instance = new PropertiesHolder();
                }
            }
        }
        return instance;
    }

    public static <T> T getProperty(String propertyName, T defaultValue, String property) {
        if (props == null || props.get(property) == null) {
            log.warn("配置文件未读取成功," + propertyName + "使用默认值");
            return defaultValue;
        }
        String valueStr = props.get(property).getProperty(propertyName);
        if (valueStr == null || "".equals(valueStr)) {
            log.warn("配置" + propertyName + "为空,使用默认值");
            return defaultValue;
        } else {
            T result = null;
            try {
                if (defaultValue instanceof Integer)
                    result = (T) Integer.valueOf(valueStr);
                else if (defaultValue instanceof Long)
                    result = (T) Long.valueOf(valueStr);
                else if (defaultValue instanceof Boolean) {
                    if ("true".equals(valueStr))
                        result = (T) Boolean.TRUE;
                    else
                        result = (T) Boolean.FALSE;
                } else if (defaultValue instanceof String)
                    result = (T) valueStr;
                else if (defaultValue instanceof Set) {
                    Set<String> set = new HashSet<>();
                    Collections.addAll(set, valueStr.split(","));
                    result = (T) set;
                } else if (defaultValue instanceof String[])
                    result = (T) (valueStr.split(","));
            } catch (Exception e) {
                log.error("配置" + propertyName + "转换类型失败,使用默认值", e);
                return defaultValue;
            }
            return result;
        }
    }

    public static void readPropertis(String fileName, String filePath, boolean isPathCanBeGot) {
        Properties properties = props.get(fileName);
        if (properties == null)
            properties = new Properties();
        try {
            if (isPathCanBeGot) {
                if (props.get(fileName) == null) {
                    synchronized (PropertiesHolder.class) {
                        if (props.get(fileName) == null) {
                            log.info("使用文件路径读取文件");
                            FileInputStream fs = new FileInputStream(filePath);
                            properties.load(fs);
                            props.put(fileName, properties);
                        }
                    }
                }
            } else {
                if (props.get(fileName) == null) {
                    log.info("使用类加载器读取方式读取文件");
                    InputStream in = PropertiesHolder.class.getClassLoader().getResourceAsStream(fileName);
                    properties.load(in);
                    props.put(fileName, properties);
                }
            }
        } catch (IOException e) {
            log.error("读取配置文件错误！", e.getMessage());
        }
    }

    public static void readPropertis(String filePath, String fileName) {
        readPropertis(fileName, filePath, true);
    }

    public static void readPropertisByClassLoader(String fileName) {
        readPropertis(fileName, "", false);
    }
}
