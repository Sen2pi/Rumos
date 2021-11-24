package com.RDB.PresetData;

import java.time.LocalDate;

import com.RDB.model.Account;
import com.RDB.model.Client;
import com.RDB.model.CreditCard;
import com.RDB.model.DebitCard;
import com.RDB.service.AccountService;
import com.RDB.service.AccountServiceImpl;
import com.RDB.service.AutomatedTellerMachine;
import com.RDB.service.AutomatedTellerMachineImpl;
import com.RDB.service.CardService;
import com.RDB.service.CardServiceImpl;
import com.RDB.service.ClientService;
import com.RDB.service.ClientServiceImpl;

public class PresetData {
	private ClientService clientService = new ClientServiceImpl();
	private AccountService accountService = new AccountServiceImpl();
	private CardService cardService = new CardServiceImpl();
	private AutomatedTellerMachine atm;
	
	public PresetData() {
		this.atm = new AutomatedTellerMachineImpl(cardService, accountService);
	}

	public AutomatedTellerMachine getAtm() {
		return atm;
	}

	public void setAtm(AutomatedTellerMachine atm) {
		this.atm = atm;
	}

	public void presetClientOne() throws Exception {
		String nif = "admin";
		String name = "Karim Patatas";
		String password = "admin";
		LocalDate birthDate = LocalDate.of(1990, 1, 4);
		Integer phone = 937111111;
		Integer mobile = 937111113;
		String email = "senpatatas@gmail.com";
		String profession = "Manager";
		Client c1 = new Client(nif, name, password, birthDate, phone, mobile, email, profession);
		Integer nib = 1231231;
		Double balance = 123.0;
		Account ac1 = new Account(nib, c1, balance);
		Integer pin1 = 9090;
		Long cardNumber1 = 1007723523250000L;
		Double plafond = 500.00;
		CreditCard cC1 = new CreditCard(c1, ac1, pin1, cardNumber1, plafond);

		clientService.save(c1);
		accountService.save(ac1);
		cardService.save(cC1);
	}

	public void presetClientTwo() throws Exception {
		String nif = "PT200322324";
		String name = "Hussen Patatas";
		String password = "2324242";
		LocalDate birthDate = LocalDate.of(1992, 1, 4);
		Integer phone = 937100001;
		Integer mobile = 937000003;
		String email = "seas@gmail.com";
		String profession = "Manager";
		Client c2 = new Client(nif, name, password, birthDate, phone, mobile, email, profession);
		Integer nib = 1231232;
		Double balance = 123.0;
		Account ac2 = new Account(nib, c2, balance);
		Integer pin2 = 9191;
		Long cardNumber2 = 1007_7232_5323_0003L;
		DebitCard dC2 = new DebitCard(c2, ac2, pin2, cardNumber2);
		clientService.save(c2);
		accountService.save(ac2);
		cardService.save(dC2);

	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

}
