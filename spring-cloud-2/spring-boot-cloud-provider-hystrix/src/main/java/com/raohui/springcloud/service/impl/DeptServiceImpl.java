package com.raohui.springcloud.service.impl;

import com.raohui.springcloud.Dao.DeptDao;
import com.raohui.springcloud.bean.Dept;
import com.raohui.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean insertDept(Dept dept) {
        return deptDao.insertDept(dept);
    }

    @Override
    public Dept findDept(Integer deptId) {
        Dept dept = deptDao.findDept(deptId);
        return dept;
    }

    @Override
    public List<Dept> findAll() {
        List<Dept> depts = deptDao.findAll();
        return depts;
    }
}
