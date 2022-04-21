package com.yyq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.yyq.doormanage1.mapper"})
public class DoormanageApplication{
//public class DoormanageApplication extends SpringBootServletInitializer {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
//        return application.sources(DoormanageApplication.class);
//    }

    public static void main(String[] args) {

        SpringApplication.run(DoormanageApplication.class, args);

    }

}