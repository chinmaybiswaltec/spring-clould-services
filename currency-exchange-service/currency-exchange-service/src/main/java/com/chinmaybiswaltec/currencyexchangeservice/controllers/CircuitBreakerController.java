package com.chinmaybiswaltec.currencyexchangeservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	//@Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
	//@CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
	//@RateLimiter(name="default")
	@Bulkhead(name="default")
	@GetMapping("/sample-api")
	public String sampleAPI() {
		logger.info("***********Sample api call received");
		/*
		 * ResponseEntity<String> responseEntity = new RestTemplate()
		 * .getForEntity("localhost:8080/someurl", String.class);
		 */
		//return responseEntity.getBody();
		return "Sample Response";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "Fallback circuit breaker response";
	}

}
