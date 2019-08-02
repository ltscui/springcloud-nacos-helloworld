package com.yqzl.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/hello")
	public String hello() {
		
		return "hello world! i am a provider, my port is " + port;
	}
}
