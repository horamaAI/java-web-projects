package com.myapplications.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// @Configuration
public class PersistenceConfiguration {
    // @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/conference_scheduling_db");
        return builder.build();// build the datasource before returning
        // since defined with @Bean, spring will look for the bean in the spring context, and replace the data source definition with the new that was implemented
    }
}
