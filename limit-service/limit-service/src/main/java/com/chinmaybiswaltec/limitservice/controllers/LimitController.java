package com.chinmaybiswaltec.limitservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinmaybiswaltec.limitservice.configs.Configuration;
import com.chinmaybiswaltec.limitservice.models.Limits;

@RestController
public class LimitController {
	
	@Autowired
	private Configuration limitConfigs;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		
		return new Limits(limitConfigs.getMin(),limitConfigs.getMax());
		//return new Limits(1,100);
	}

}
