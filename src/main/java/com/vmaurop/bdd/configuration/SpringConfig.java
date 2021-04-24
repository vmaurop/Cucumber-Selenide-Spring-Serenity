package com.vmaurop.bdd.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        GoogleConfig.class
})
@ComponentScan({"com.vmaurop.bdd", "com.vmaurop"})
public class SpringConfig {
}
