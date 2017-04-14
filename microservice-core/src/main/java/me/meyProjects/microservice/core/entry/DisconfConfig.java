package me.meyProjects.microservice.core.entry;

import com.baidu.disconf.client.DisconfMgrBean;
import com.baidu.disconf.client.DisconfMgrBeanSecond;
import com.baidu.disconf.client.addons.properties.ReloadablePropertiesFactoryBean;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.util.List;

/**
 * Created by chendong on 2017/4/14.
 * <p>
 * init disconf
 */
@PropertySource(value = "classpath:disconf.properties")
public class DisconfConfig {

    private static List properties = Lists.newArrayList("application.properties");

    @Bean(destroyMethod = "destroy")
    public static DisconfMgrBean disconfMgrBean() {
        DisconfMgrBean bean = new DisconfMgrBean();
        bean.setScanPackage("uyun.octopus.openApi.core.bean");
        return bean;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public static DisconfMgrBeanSecond disconfMgrBeanSecond() {
        return new DisconfMgrBeanSecond();
    }

    @Bean
    public static ReloadablePropertiesFactoryBean reloadablePropertiesFactoryBean() throws IOException {
        ReloadablePropertiesFactoryBean bean = new ReloadablePropertiesFactoryBean();
        bean.setLocations(properties);
        bean.afterPropertiesSet();
        return bean;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
        bean.setIgnoreResourceNotFound(true);
        bean.setIgnoreUnresolvablePlaceholders(true);
        bean.setProperties(reloadablePropertiesFactoryBean().getObject());
        return bean;
    }

}
