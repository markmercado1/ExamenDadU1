package com.pe.clinica.memmsregistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer

@SpringBootApplication
public class MemMsRegistryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemMsRegistryServerApplication.class, args);
    }

}
