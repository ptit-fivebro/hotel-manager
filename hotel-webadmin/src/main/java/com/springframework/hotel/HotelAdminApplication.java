package com.springframework.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class HotelAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelAdminApplication.class, args);
    }
}
