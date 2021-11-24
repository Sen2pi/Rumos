package com.RDB.service;

import com.RDB.model.Account;
import com.RDB.model.CreditCard;
import com.RDB.model.DebitCard;

public interface AutomatedTellerMachine {
	
	void withdraw(Account account, Double amount) throws Exception;
	
	void transfert( Account account, Integer nib, Double amount) throws Exception;
	
	void newCreditCard(CreditCard creditCard) throws Exception; // only one per owner
	
	void newDebitCard(DebitCard debitCard) throws Exception; // only one per owner

	void deposit(Account account, Double amount) throws Exception;


}
