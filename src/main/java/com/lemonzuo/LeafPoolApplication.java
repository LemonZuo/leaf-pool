package com.lemonzuo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.lemonzuo.mapper")
public class LeafPoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeafPoolApplication.class, args);
    }

}
