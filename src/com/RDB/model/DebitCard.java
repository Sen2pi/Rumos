package com.RDB.model;

public class DebitCard extends Card{
	private Double dailyWithdraw;

	

	public DebitCard(Integer pin, Long cardNumber) {
		this.pin = pin;
		this.cardNumber = cardNumber;
		
	}
	public DebitCard(Client owner, Account account, Integer pin, Long cardNumber) {
		super();
		this.owner = owner;
		this.account = account;
		this.pin = pin;
		this.cardNumber = cardNumber;
	}

	public Double getMaxDailyWithdraw() {
		return dailyWithdraw;
	}

	public void setMaxDailyWithdraw(Double dailyWithdraw) {
		this.dailyWithdraw = dailyWithdraw;
	}
	@Override
	public String toString() {
	return "\n Debit Card ID " + id + " | Owner: " + owner.getName() + " |  Account NIB " + account.getNib() + " | pin: " + pin + " | Daily Withdraw: " + dailyWithdraw + " Card Number: "+ cardNumber;
	}
}
