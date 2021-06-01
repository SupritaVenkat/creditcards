package com.sv.creditcards.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sv.creditcards.Configuration;
import com.sv.creditcards.bean.CardDetails;
import com.sv.creditcards.bean.CreditCards;
import com.sv.creditcards.service.CreditCardService;

public class CreditCardController {
	@Autowired
	private CreditCards creditcard;
	
	@Autowired
	private Configuration config;
	
	@Autowired 
	private CreditCardService creditCardservice;
	@GetMapping("/cards")
	public CreditCards getCards() {
		creditcard.setCreditScore(config.getCreditScore());
		return creditcard;
	}
	
	@GetMapping("/cards/{id}")
	public Optional<CardDetails> getCreditCard(@PathVariable("id") int id){
		return creditCardservice.getByCardNumber(id);
	}
	
	@PostMapping("/create-card")
	public void createCreditCards(@RequestBody CardDetails card) {
		creditCardservice.SaveOrUpdate(card);
	}
}
