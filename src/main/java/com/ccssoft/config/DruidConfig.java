package com.ccssoft.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    /*
     *@ConfigurationProperties告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
     *prefix = "xxx"：配置文件中哪个下面的所有属性进行一一映射
     * @Value 注解可以从配置文件读取一个配置
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(destroyMethod = "close",initMethod = "init")
    public DataSource druid () {
        return new DruidDataSource();
    }
}
