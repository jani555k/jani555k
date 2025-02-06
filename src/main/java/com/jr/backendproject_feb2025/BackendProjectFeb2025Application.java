package com.jr.backendproject_feb2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BackendProjectFeb2025Application {

    public static void main(String[] args) {
        SpringApplication.run(BackendProjectFeb2025Application.class, args);
    }

}
