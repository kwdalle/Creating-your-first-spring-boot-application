package com.pluralsight.conferencedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
    @Value("${DB_URL}")
    private String dbURL;

    @Value("${DB_PASSWORD}")
    private String dbPassword;

    @Value("${DB_USERNAME}")
    private String dbUsername;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(this.dbURL);
        builder.password(this.dbPassword);
        builder.username(this.dbUsername);
        System.out.println("My custom datasource bean has been initialized with " + this.dbURL);

        return builder.build();
    }
}
