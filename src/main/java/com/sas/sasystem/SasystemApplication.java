package com.sas.sasystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SasystemApplication {

    private static final Logger log = LoggerFactory.getLogger(SasystemApplication.class);


    public static void main(String[] args) {
        log.info("123");
        SpringApplication.run(SasystemApplication.class, args);
    }

}
