package com.sysgears.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Jsr330ScopeMetadataResolver
import org.springframework.core.env.Environment

import javax.inject.Inject

/**
 * IoC configuration of application.
 */
@Configuration
@ComponentScan(basePackages = "com.sysgears.example",
        scopeResolver = Jsr330ScopeMetadataResolver.class)
class AppConfig {

    private @Inject Environment env
    
    public @Bean GreetInfo createGreetInfo() {
        env.getProperty("greetInfo", GreetInfo.class)
    }
}
