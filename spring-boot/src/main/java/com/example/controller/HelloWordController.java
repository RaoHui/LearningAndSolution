package com.example.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.CusCustomer;
import com.example.service.cusCustomerService;

@RestController
public class HelloWordController {

	@Resource
	private cusCustomerService cusCustomerService;
	
	@GetMapping(value = "/hello")
	public String helloWrod() {
		JSONObject json = new JSONObject();
		json.put("name", "a");
		json.put("mobile", "阿斯顿bbbb撒撒");
		json.put("age", 19);
		return json.toJSONString();
	}
	
	@GetMapping(value = "/getCustomer")
	public String getCustomer() {
		CusCustomer customer = cusCustomerService.findCustomerBycusId(20);
		String data = JSON.toJSONString(customer);
		return data;
	}
}
