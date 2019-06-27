package com.rokib.springApiDocumentationWithSwagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppProfilingConfig {

    @Profile("local")
    @Bean
    public String localBean() {
        return "local";
    }

    @Profile("dev")
    @Bean
    public String devBean() {
        return "dev";
    }

}
