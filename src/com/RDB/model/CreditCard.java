package com.RDB.model;

public class CreditCard extends Card{
	private Double plafond;
	
	public CreditCard(Client owner, Account account, Integer pin, Long cardNumber, Double plafond) {
		super();
		this.owner = owner;
		this.account = account;
		this.pin = pin;
		this.cardNumber = cardNumber;
		this.plafond = plafond;
	}

	public CreditCard(long cardNumber, int pin, int plafond2) {
		// TODO Auto-generated constructor stub
	}

	public Double getPlafond() {
		return plafond;
	}

	public void setPlafond(Double plafond) {
		this.plafond = plafond;
	}
	
	@Override
	public String toString() {
		return "\n Credit Card ID " + id + " | Owner: " + owner.getName() + " |  Account " + account + " | pin: " + pin + " | Plafond: " + plafond + "| Card Number: "+ cardNumber ;
}
}