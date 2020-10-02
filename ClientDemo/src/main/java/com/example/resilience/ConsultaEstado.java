package com.example.resilience;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
	
	@FeignClient("ConsultaStatus")
	@EnableCircuitBreaker
	public interface ConsultaEstado {
	   
	    @RequestMapping(method = RequestMethod.GET, value = "/greetings", consumes = "application/json")
	    String consulta(@RequestParam(value="name", defaultValue="World") String name);
	}
	
    
