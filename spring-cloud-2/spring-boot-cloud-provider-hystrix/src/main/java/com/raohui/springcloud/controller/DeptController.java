package com.raohui.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.raohui.springcloud.bean.Dept;
import com.raohui.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGetDept")
    public Dept findDept(@PathVariable("id") Integer id){
        Dept dept = deptService.findDept(id);
        if (dept == null) {
            throw new RuntimeException("出错了");
        }
        return dept;
    }

    public Dept hystrixGetDept(@PathVariable("id") Integer id){
        return new Dept().setDeptId(id)
                .setDeptName("id=>" + id + "没有对应的信息")
                .setDbSource("no this database");
    }
}
