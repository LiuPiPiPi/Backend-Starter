package com.lpxz.cmsserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lpxz.**")
@MapperScan("com.lpxz.**")
public class CmsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsServerApplication.class, args);
    }

}
