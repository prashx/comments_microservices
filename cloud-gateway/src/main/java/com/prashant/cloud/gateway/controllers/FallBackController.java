package com.prashant.cloud.gateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	
	
	  @GetMapping("/commentServiceFallBack")
	    public String commentServiceFallBackMethod() {

	        return "Comment service is not available at the moment.";
	    }
}
