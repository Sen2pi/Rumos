package com.RDB.repository;



import java.util.Arrays;
import java.util.List;

import com.RDB.model.Account;
import com.RDB.model.Card;
import com.RDB.model.Client;

public class CardRepositoryImpl implements CardRepository {
	private Card[] cards = new Card[10];
	private static int id;

	@Override
	public Card save(Card card) throws Exception {
		checkOwnerCards(card);
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				id++;
				card.setId(id);
				cards[i] = card;
				return cards[i];
			} if (cards[i].getId().equals(card.getId())) {
				cards[i] = card;
				return cards[i];
			}
		}
		throw new Exception("DATABASE FULL");
	}

	@Override
	public List<Card> findAll() {
		return Arrays.asList(cards);
	}

	@Override
	public Card findById(Integer id) throws Exception {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getId().equals(id)) {
				return cards[i];
			}
		}
		throw new Exception("CARD WITH THIS ID: " + id + " NOT FOUND");
	}

	@Override
	public Card findByClient(Client owner) throws Exception {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getOwner().equals(owner)) {
				return cards[i];
			}
		}
		throw new Exception("CARD WITH THIS OWNER: " + owner + " NOT FOUND");
	}

	@Override
	public Card findByAccount(Account account) throws Exception {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getAccount().equals(account)) {
				return cards[i];
			}
		}
		throw new Exception("CARD WITH THIS ACCOUNT: " + account + " NOT FOUND");
	}

	@Override
	public Card findByClientAndPin(Client client, Integer pin) throws Exception {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getOwner().equals(client) && cards[i].getPin().equals(pin)) {
				return cards[i];
			}
		}
		throw new Exception("CARD WITH THIS CLIENT: " + client + "And Pin: " + pin + " NOT FOUND");

	}

	@Override
	public void deleteById(Integer id) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getId().equals(id)) {
				cards[i] = null;
			}
		}

	}

	@Override
	public Card findByCardNumber(Long cardNumber) throws Exception {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getCardNumber().equals(cardNumber)) {
				return cards[i];
			}
		}
		throw new Exception("CARD WITH THIS CARD NUMBER : " + cardNumber + " NOT FOUND");
	}

	@Override
	public Card login(Long cardNumber, Integer pin) throws Exception {
		int attempts = 0;
			if (attempts >= 3) {
				System.out.println("YOU EXCEEDED YOUR ATTEMPTS " + attempts);
			} else if (cardNumber.equals(pin)) {
				System.out.println("You are logged in");
			} else {
				attempts++;
				System.out.println("Wrong Card Number or Pin , Please Enter a valid credentials for login!");
				System.out.println("You have " + (3 - attempts) + " Attempts left");
			}

		throw new Exception("COULD NOT LOGIN WITH THE CARD : " + cardNumber + " THE PIN IS INCORRECT!!");
	}

	@Override
	public Card findByPin(Integer pin) throws Exception {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getPin().equals(pin)) {
				return cards[i];
			}
		}
		throw new Exception("CARD WITH THIS PIN : " + pin + " NOT FOUND");

	}

	public void checkOwnerCards(Card card) throws Exception {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getOwner().equals(card.getOwner())) {
				throw new Exception("Owner: " + card.getOwner() + "Already Have a Card");
			}
		}
	}

	@Override
	public Card findByCardNumberAndPin(Long cardNumber, Integer pin) throws Exception {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				continue;
			}
			if (cards[i].getCardNumber().equals(cardNumber) && cards[i].getPin().equals(pin)) {
				return cards[i];
			}
		}
		throw new Exception("CARD WITH THIS CLIENT: " + cardNumber + "And Pin: " + pin + " NOT FOUND");

	}

}