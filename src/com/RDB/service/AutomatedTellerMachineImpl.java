package com.RDB.service;


import com.RDB.model.Account;
import com.RDB.model.CreditCard;
import com.RDB.model.DebitCard;

public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {
	private CardService cardService;
	private AccountService accountService;
	
	public AutomatedTellerMachineImpl(CardService cardService, AccountService accountService ) {
		this.cardService = cardService;
		this.accountService = accountService;

	}

	@Override
	public void withdraw(Account account, Double amount) throws Exception {
		if (amount <= 1) {
			throw new Exception("Cannot withdraw specified amount " + amount + ". Please specify an amount above 1");
		}
		if (account.getBalance() < amount) {
			throw new Exception("Insuficient Funds");
		}
		Double newBalance = account.getBalance() - amount;
		account.setBalance(newBalance);
		System.out.println(account.getBalance());
	}

	@Override
	public void deposit(Account account, Double amount) throws Exception {
		Double newBalance = amount + account.getBalance();
		account.setBalance(newBalance);
		System.out.println(account.getBalance());
	}


	@Override
	public void transfert(Account account, Integer nib, Double amount) throws Exception {
		if (amount <= 1) {
			throw new Exception("Cannot Transfert specified amount: " + amount + ". Please specify an amount above 1");
		}
		if (account.getBalance() < amount) {
			throw new Exception("Insuficient Funds");
		}
		if (nib.equals(accountService.getByNib(nib))) {
			Double newBalance = account.getBalance() + amount;
			account.setBalance(newBalance);
		}

		Double newBalance = account.getBalance() - amount;
		account.setBalance(newBalance);

	}

	@Override
	public void newCreditCard(CreditCard creditCard) throws Exception {
		cardService.save(creditCard);

	}

	@Override
	public void newDebitCard(DebitCard debitCard) throws Exception {
		cardService.save(debitCard);

	}

}
