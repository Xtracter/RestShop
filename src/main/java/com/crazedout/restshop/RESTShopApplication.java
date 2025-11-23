package com.crazedout.restshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * REST Spring-Boot/Thymeleaf App - "Rest Shop".
 * @author Fredrik Roos
 */

@SpringBootApplication
public class RESTShopApplication {
    private static final Logger logger = LoggerFactory.getLogger(RESTShopApplication.class);
    public static void main(String[] args) {
        logger.info("Application starting");
        SpringApplication.run(RESTShopApplication.class, args);
    }
}
