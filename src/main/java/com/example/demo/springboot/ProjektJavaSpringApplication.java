package com.example.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo")
public class ProjektJavaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjektJavaSpringApplication.class, args);
    }
}
