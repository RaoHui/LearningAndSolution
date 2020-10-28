package com.raohui.springcloud.service;

import com.raohui.springcloud.bean.Dept;

import java.util.List;

public interface DeptService {
    boolean insertDept(Dept dept);

    Dept findDept(Integer deptId);

    List<Dept> findAll();
}
