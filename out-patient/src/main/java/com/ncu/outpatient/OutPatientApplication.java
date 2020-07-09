package com.ncu.outpatient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(basePackages = "com.ncu.outpatient.mapper")
@EnableEurekaClient
public class OutPatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutPatientApplication.class, args);
    }

}
