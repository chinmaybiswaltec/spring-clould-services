package com.chinmaybiswaltec.currencyexchangeservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chinmaybiswaltec.currencyexchangeservice.models.CurrencyExchange;
import com.chinmaybiswaltec.currencyexchangeservice.repositories.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeCotroller {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeCotroller.class);
	
	@Autowired
	private Environment env;

	@Autowired
	private CurrencyExchangeRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		logger.info("getCurrencyExchange called from {} to {}",from,to);
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("Not able to find data for from " + from + " to " + to);
		}
		currencyExchange.setEnvironment(env.getProperty("local.server.port"));
		return currencyExchange;
		// return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(80),
		// env.getProperty("local.server.port"));
	}

}
