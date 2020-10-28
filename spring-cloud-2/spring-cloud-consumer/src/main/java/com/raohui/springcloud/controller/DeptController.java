package com.raohui.springcloud.controller;

import com.raohui.springcloud.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX="http://SPRING-CLOUD-PROVIDER-HYSTRIX";

    @RequestMapping("/consume/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Integer id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @RequestMapping("/consume/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consume/dept/list")
    public List<Dept> getDepts(){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/list",null,List.class);
    }
}
