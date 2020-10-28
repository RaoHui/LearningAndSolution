package com.raohui.springcloud.Dao;

import com.raohui.springcloud.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DeptDao {

     boolean insertDept(Dept dept);

     Dept findDept(Integer deptId);

     List<Dept> findAll();
}
