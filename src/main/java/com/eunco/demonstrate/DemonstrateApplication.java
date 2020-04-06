package com.eunco.demonstrate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author ennu
 */
@SpringBootApplication
@MapperScan("com.eunco.demonstrate.dao")
public class DemonstrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonstrateApplication.class, args);
    }

}
