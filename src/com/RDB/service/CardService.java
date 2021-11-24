package com.RDB.service;


import java.util.List;

import com.RDB.model.Account;
import com.RDB.model.Card;
import com.RDB.model.Client;

public interface CardService {
	
	Card save(Card card) throws Exception;
	
	void login(Long cardNumber, Integer pin) throws Exception;
	
	List<Card> getAll();
	
	Card getById(Integer id) throws Exception;
	
	Card getByCardNumber(Long cardNumber) throws Exception;
	
	Card getByClient(Client owner) throws Exception;
	
	Card getByPin (Integer pin) throws Exception;
	
	Card getByAccount(Account account) throws Exception;
	
	Card getByClientAndPin(Client client, Integer pin) throws Exception;
	
	Card getByCardNumberAndPin(Long cardNumber, Integer pin) throws Exception;
	
	void deleteById(Integer id) throws Exception;

}
