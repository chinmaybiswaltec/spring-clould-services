package com.chinmaybiswaltec.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinmaybiswaltec.currencyexchangeservice.models.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
   public CurrencyExchange findByFromAndTo(String from, String to);
}
