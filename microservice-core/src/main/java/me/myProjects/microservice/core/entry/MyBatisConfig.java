package me.myProjects.microservice.core.entry;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by chendong on 2017/4/24.
 * <p>
 * myBatis config beans
 * <p>
 * spring 会自动替换成 自己声明的 dataSource
 */
@Configuration
public class MyBatisConfig {

    private final Environment env;

    @Autowired
    public MyBatisConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource getDataSource() { // 这里可以设置 dataSource pool 等
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

}
