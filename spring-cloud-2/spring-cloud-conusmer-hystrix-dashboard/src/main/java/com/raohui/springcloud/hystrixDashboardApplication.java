package com.raohui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启hystrix监控
public class hystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(hystrixDashboardApplication.class,args);
    }
}
