package com.example.fundamentosspring.fundamentos.configuration;

import com.example.fundamentosspring.fundamentos.Bean.MyBeanPropeties;
import com.example.fundamentosspring.fundamentos.Bean.MyBeanPropetiesImplement;
import com.example.fundamentosspring.fundamentos.Bean.MyBeanWithProperties;
import com.example.fundamentosspring.fundamentos.Bean.MyBeanWithPropertiesImplement;
import com.example.fundamentosspring.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String nombre;

    @Value("${value.lastName}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public MyBeanPropeties showMe(){
        return new MyBeanPropetiesImplement(nombre,apellido);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}
