package com.example.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.CusCustomer;
import com.example.mapper.cusCustomerMapper;
import com.example.service.cusCustomerService;

@Service
public class cusCustomerServiceImpl implements cusCustomerService {

	@Autowired
	private cusCustomerMapper cusCustomerMapper;
	
	@Override
	public CusCustomer findCustomerBycusId(Integer cusId) {
		CusCustomer customer = cusCustomerMapper.findCustomerByCusId(cusId);
		return customer;
	}

}
