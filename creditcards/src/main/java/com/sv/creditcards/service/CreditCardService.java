package com.sv.creditcards.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.creditcards.bean.CardDetails;

@Service
public class CreditCardService {
	
	@Autowired
	private CreditDetailsRepository cardDetailsRepo;
	
	public Optional<CardDetails> getByCardNumber(int cardNumber){
		return cardDetailsRepo.findById(cardNumber);	
	}
	
	public void SaveOrUpdate(CardDetails cardDetails) {
		cardDetailsRepo.save(cardDetails);
	}

}
