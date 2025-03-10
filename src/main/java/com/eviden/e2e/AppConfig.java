package com.eviden.e2e;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.yourpackage") // Change this to your actual package
@PropertySource("classpath:application.properties") // Or application.yml
public class AppConfig {
}
