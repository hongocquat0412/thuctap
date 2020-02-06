package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

@RestController
public class HomeController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "helloword")
	public String helloword() {
		Map<String, ?> params = new HashMap<>();
//		String response = restTemplate.exchange("http://hello-service/hello",
//                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},params).getBody();
		String response = restTemplate.exchange("http://hello-service/hello", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, params);
//		return response + "word";
		return "a";
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
