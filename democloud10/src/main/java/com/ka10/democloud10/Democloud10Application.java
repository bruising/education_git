package com.ka10.democloud10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Democloud10Application {

    public static void main(String[] args) {
        SpringApplication.run(Democloud10Application.class, args);
    }

}
