package com.analista.desarrollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.analista.desarrollo")
public class AnalistaDesarrolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalistaDesarrolloApplication.class, args);
    }

}
