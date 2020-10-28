package com.raohui.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCircuitBreaker //添加对熔断的支持
@EnableEurekaClient
public class SpringCloudProviderHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderHystrixApplication.class,args);
    }

    @Bean
    public ServletRegistrationBean hystrix(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
}
