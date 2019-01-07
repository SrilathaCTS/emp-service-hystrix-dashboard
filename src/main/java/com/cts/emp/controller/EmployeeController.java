package com.cts.emp.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.emp.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest/emp")
public class EmployeeController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${client.url}")
	private String url; 
	
	/*if server url is down are any problem then automatically fallback method will be called*/
	@HystrixCommand(fallbackMethod="hystrixFallBack")
	@GetMapping(value="/hystrix")
	public List<Employee> hystrix()
	{
		LOGGER.info("Inside the hystrix method URL is :"+url);
		return restTemplate.getForObject(url, List.class);
	}
	
	@GetMapping(value="")
	public List<Employee> getEmployee()
	{
		LOGGER.info("Inside the getEmployee method URL is :"+url);
		return restTemplate.getForObject(url, List.class);
	}
	
	public List<Employee> hystrixFallBack()
	{
		LOGGER.info("Inside the hystrix fall back method");
		return Collections.emptyList();
	}
	
	@HystrixCommand(fallbackMethod = "reliable")
	@GetMapping(value="/reliable")
	  public String readingList() {
		LOGGER.info("Inside the readingList method");
		
	    URI uri = URI.create("http://localhost:8080/employee/getLearningList");

	    return this.restTemplate.getForObject(uri, String.class);
	  }

	  public String reliable() {
		  LOGGER.info("Inside the reliable fallback method");
	    return "Cloud Native Java (O'Reilly)";
	  }

	
}
