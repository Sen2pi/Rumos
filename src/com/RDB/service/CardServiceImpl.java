package com.RDB.service;

import java.util.HashMap;
import java.util.List;

import com.RDB.model.Account;
import com.RDB.model.Card;
import com.RDB.model.Client;
import com.RDB.repository.CardRepository;
import com.RDB.repository.CardRepositoryImpl;

public class CardServiceImpl implements CardService {
	private CardRepository cardRepository = new CardRepositoryImpl();
	HashMap<Long, Integer> loginInfo = new HashMap<Long, Integer>();

	@Override
	public Card save(Card card) throws Exception {
		return cardRepository.save(card);
	}

	@Override
	public List<Card> getAll() {
		return cardRepository.findAll();

	}

	@Override
	public Card getById(Integer id) throws Exception {
		return cardRepository.findById(id);
	}

	@Override
	public Card getByClient(Client owner) throws Exception {
		return cardRepository.findByClient(owner);
	}

	@Override
	public Card getByAccount(Account account) throws Exception {
		return cardRepository.findByAccount(account);
	}

	@Override
	public Card getByClientAndPin(Client client, Integer pin) throws Exception {
		return cardRepository.findByClientAndPin(client, pin);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		cardRepository.deleteById(id);

	}

	@Override
	public Card getByCardNumber(Long cardNumber) throws Exception {
		return cardRepository.findByCardNumber(cardNumber);
	}

	@Override
	public Card getByPin(Integer pin) throws Exception {
		return cardRepository.findByPin(pin);
	}

	@Override
	public void login(Long cardNumber, Integer pin) throws Exception {
		cardRepository.login(cardNumber, pin);
	}

	@Override
	public Card getByCardNumberAndPin(Long cardNumber, Integer pin) throws Exception {
		return cardRepository.findByCardNumberAndPin(cardNumber, pin);
	}

}
