package com.example.resilience;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@EnableAutoConfiguration

	@FeignClient("status")
	public interface StatusClient {
	  
	    @RequestMapping(method = RequestMethod.PUT, value = "/status", consumes = "application/json")
	    String update(@RequestParam(value="status", defaultValue="Este es el default") String estado);
	}
	
    
