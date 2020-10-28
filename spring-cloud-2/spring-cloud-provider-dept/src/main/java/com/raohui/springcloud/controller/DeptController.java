package com.raohui.springcloud.controller;

import com.raohui.springcloud.bean.Dept;
import com.raohui.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        System.out.println(dept);
        return deptService.insertDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept findDept(@PathVariable("id") Integer id){
        return deptService.findDept(id);
    }

    @PostMapping("/dept/list")
    public List<Dept> findAllDept(){
        return deptService.findAll();
    }
}
