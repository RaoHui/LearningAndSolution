package com.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.CusCustomer;

public interface cusCustomerMapper {

	@Select("select cus_id,cus_mobile,cus_name,cus_info from cus_customer where cus_id = #{cusId}")
	CusCustomer findCustomerByCusId(@Param("cusId") Integer cusId);
}
