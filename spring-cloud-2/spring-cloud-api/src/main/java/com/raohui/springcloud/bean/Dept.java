package com.raohui.springcloud.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data //自动构造get\set\hashcode\equals
@NoArgsConstructor //无参构造器
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {

    private Integer deptId;

    private String deptName;

    private String dbSource;

}
