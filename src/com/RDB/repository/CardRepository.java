package com.RDB.repository;


import java.util.List;

import com.RDB.model.Account;
import com.RDB.model.Card;
import com.RDB.model.Client;

public interface CardRepository {

	Card save(Card card) throws Exception;

	List<Card> findAll();

	Card findById(Integer id) throws Exception;

	Card findByClient(Client owner) throws Exception;

	Card findByAccount(Account account) throws Exception;

	Card findByPin(Integer pin) throws Exception;

	Card findByCardNumber(Long cardNumber) throws Exception;

	Card findByClientAndPin(Client client, Integer pin) throws Exception;
	
	Card findByCardNumberAndPin(Long cardNumber, Integer pin) throws Exception;

	void deleteById(Integer id);

	Card login(Long cardNumber, Integer pin) throws Exception;

}
