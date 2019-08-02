package com.yqzl.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final RestTemplate restTemplate;

	@GetMapping("/say/{str}")
	public String sayHello(@PathVariable("str") String str) {
		logger.info("you are calling " + str);
		return restTemplate.getForObject("http://nacos-provider/" + str, String.class);
	}

	public ConsumerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
}
