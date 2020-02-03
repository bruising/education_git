package com.ka10.democon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoConApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConApplication.class, args);
    }

}
