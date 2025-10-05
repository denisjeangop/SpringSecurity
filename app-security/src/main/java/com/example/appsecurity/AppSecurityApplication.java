package com.example.appsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.repository")
@EntityScan(basePackages = "com.example.model")
public class AppSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSecurityApplication.class, args);
    }

}