package com.redash;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dancoder
 */
@MapperScan("com.redash.mapper")
@SpringBootApplication
public class RedashApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedashApplication.class, args);
    }
}
