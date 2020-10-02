package com.example.resilience;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





	@FeignClient("AemetClient")

public interface AemetClient {
		@RequestMapping(method = RequestMethod.GET, value = "/opendata/api/prediccion/especifica/monta%C3%B1a/pasada/area/peu1", consumes = "application/json")
		//String consulta(@RequestParam(value="api_key", defaultValue="peu1") String area);
	    String consulta(@RequestParam(value="api_key", defaultValue="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcGJyYXZvQGdtYWlsLmNvbSIsImp0aSI6IjgyNGM1Y2UzLWFmNzYtNDk0NS1hZDBmLTdhMDk1ZTIyMzJkZCIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNTA5NTU2OTY5LCJ1c2VySWQiOiI4MjRjNWNlMy1hZjc2LTQ5NDUtYWQwZi03YTA5NWUyMjMyZGQiLCJyb2xlIjoiIn0.XAEUT7p_9sXrkavMunL9CtQySwUWOicCIbGfsYxdVZk") String apiKey);

}
