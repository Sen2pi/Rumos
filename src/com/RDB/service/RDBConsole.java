package com.RDB.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.RDB.model.Account;
import com.RDB.model.Client;
import com.RDB.model.CreditCard;
import com.RDB.model.DebitCard;

public class RDBConsole {
	private CardService cardService;
	private ClientService clientService;
	private AccountService accountService;
	private AutomatedTellerMachine atm;
	private ATMConsole atmConsole;
	private Scanner in = new Scanner(System.in);
	
	public RDBConsole(CardService cardService, ClientService clientService, AccountService accountService, AutomatedTellerMachine atm) {
		this.cardService = cardService;
		this.clientService = clientService;
		this.accountService = accountService;
		this.atm = atm;
		this.atmConsole = new ATMConsole(cardService, accountService, atm, clientService);
		
	}
	Account account;
	Client client;
	
	public void runRDB() throws Exception {
		loginMenu();
		boolean exit = false;
		welcome();
		do {
			menu();
			System.out.println("Enter Option: ");
			int option = in.nextInt();
			in.nextLine();

			switch (option) {
			case 1:
				addClient();
				break;
			case 2:
				addSecondaryClient();
				break;
			case 3:
				updateClient();
				break;
			case 4:
				updateAccount();
				break;
			case 5:
				addDebitCard();
				break;
			case 6:
				addCreditCard();
				break;
			case 7:
				listAll();
				break;
			case 8:
				atmConsole.runATM();
				exit = true;
				break;
			}
		} while (!exit);	
	}



	private void addSecondaryClient() throws Exception {
		System.out.println("*************** ADD NEW CLIENT **************");
		System.out.println("Enter the account id you want to add the client: ");
		System.out.println(accountService.getAll());
		int id = in.nextInt();
		in.nextLine();
		System.out.print("Enter Client's NIF: ");
		String nif = in.next();
		in.nextLine();
		System.out.println("Enter Client's Name: ");
		String name = in.next();
		in.nextLine();
		System.out.println("Enter Client's Password: ");
		String password = in.next();
		in.nextLine();
		System.out.println("Enter Client's BirthDate (yyyy-mm-dd): ");
		LocalDate birthDate = LocalDate.parse(in.next());
		in.nextLine();
		System.out.println("Enter Client's phone: ");
		Integer phone = in.nextInt();
		in.nextLine();
		System.out.println("Enter Client's mobile phone: ");
		Integer mobile = in.nextInt();
		in.nextLine();
		System.out.println("Enter Client's email: ");
		String email = in.next();
		in.nextLine();
		System.out.println("Enter Client's profession: ");
		String profession = in.next();
		in.nextLine();

		Client client = new Client(nif, name, password, birthDate, phone, mobile, email, profession);
		clientService.save(client);
		account = accountService.getById(id);
		account.setSecondary(Arrays.asList(client));
		System.out.println(account);
		
		back();

	}

	private void listAll() {
		System.out.println(accountService.getAll());

	}

	private void addCreditCard() throws Exception {
		cardService.getAll();
		System.out.println("Insert the client id you want to add the card :  ");
		Integer clientId = in.nextInt();
		in.nextLine();
		Client client = clientService.getdById(clientId);
		System.out.println("Insert the client nib you want to add the card :  ");
		Integer accountNib = in.nextInt();
		in.nextLine();
		accountService.getByNib(accountNib);
		if (account.getPrimary().equals(client)) {
			System.out.println("Enter Card pin max 6 characters:  ");
			Integer pin = in.nextInt();
			Long min = 1232_0183_0030_3883L;
			Long max = 4999_0000_3999_3883L;
			Long cardNumber = ThreadLocalRandom.current().nextLong(min, max + 615739993883L);
			System.out.println("Enter the Plafond amount , maximum 1000: ");
			Double plafond = in.nextDouble();
			CreditCard creditCard = new CreditCard(client, account, pin, cardNumber, plafond);
			cardService.save(creditCard);
			System.out.println("Credit card saved successfully" + creditCard.toString());
		} else {
			System.out.println("Client must be linked to that account to create the cards , please try again: ");
			addCreditCard();
		}
		back();

	}

	private void addDebitCard() throws Exception {
		System.out.println(clientService.getAll());
		System.out.println("Insert the client id you want to add the card :  ");
		Integer id = in.nextInt();
		Client client = clientService.getdById(id);
		System.out.println("Insert the client nib you want to add the card :  ");
		Integer accountNib = in.nextInt();
		accountService.getByNib(accountNib);
		if (account.getPrimary().equals(client) || account.getSecondary().equals(client)) {
			System.out.println("Enter Card pin max 6 characters:  ");
			Integer pin = in.nextInt();
			Long min = 1232_0183_0030_3883L;
			Long max = 4999_0000_3999_3883L;
			Long cardNumber = ThreadLocalRandom.current().nextLong(min, max + 615739993883L);

			DebitCard debitCard = new DebitCard(client, account, pin, cardNumber);
			cardService.save(debitCard);
			debitCard.setOwner(client);
			debitCard.setAccount(account);
			System.out.println("debit card saved successfully" + debitCard);
		} else {
			System.out.println("Client must be linked to that account to create the cards , please try again: ");
			addDebitCard();
		}
		back();

	}

	private void updateAccount() throws Exception {
		header();
		System.out.println("*************** UPDATE ACCOUNT **************");
		System.out.println("Enter account id to Update: ");
		Integer id = in.nextInt();
		in.nextLine();
		accountService.getById(id);
		updateAcountMenu();
		System.out.println("Enter option for wath you want to update: ");
		Integer option = in.nextInt();
		in.nextLine();
		switch (option) {
		case 1:
			System.out.println("*************** ADD SECONDARY CLIENT **************");
			System.out.print("Enter Client's NIF: ");
			String nif = in.next();
			in.nextLine();
			System.out.println("Enter Client's Name: ");
			String name = in.next();
			in.nextLine();
			System.out.println("Enter Client's Password: ");
			String password = in.next();
			in.nextLine();
			System.out.println("Enter Client's BirthDate (yyyy-mm-dd): ");
			LocalDate birthDate = LocalDate.parse(in.next());
			in.nextLine();
			System.out.println("Enter Client's phone: ");
			Integer phone = in.nextInt();
			in.nextLine();
			System.out.println("Enter Client's mobile phone: ");
			Integer mobile = in.nextInt();
			in.nextLine();
			System.out.println("Enter Client's email: ");
			String email = in.next();
			in.nextLine();
			System.out.println("Enter Client's profession: ");
			String profession = in.next();
			in.nextLine();

			Client secondary = new Client(nif, name, password, birthDate, phone, mobile, email, profession);
			clientService.save((Client) secondary);
			account.setSecondary(Arrays.asList(secondary));
			break;
		case 2:
			System.out.println("*************** UPDATE BALACE **************");
			System.out.println("Enter the initial balance to Update: ");
			Double balance = in.nextDouble();
			in.nextLine();
			account.setBalance(balance);
			break;
		case 3:
			break;
		}
	}

	public void updateClient() throws Exception {
		header();
		System.out.println("*************** UPDATE CLIENT **************");
		System.out.println(clientService.getAll());
		System.out.println("Enter the Client's id to update client: ");
		Integer id = in.nextInt();
		clientService.getdById(id);
		updateClientMenu();
		boolean exit = false;

		do {
			System.out.println("Enter option for wath you want to update: ");
			int option = in.nextInt();
		switch (option) {
		case 1:
			System.out.println("*************** NIF **************");
			System.out.println("Enter new nif: ");
			String nif = in.next();
			client.setNif(nif);
			System.out.println("The new nif is : " + nif + " UPDATED WITH SUCCESS!!");
			System.out.println("Client saved successfully " + client.toString());
			exit = true;
			break;
		case 2:
			System.out.println("*************** NAME **************");
			System.out.println("Enter new name: ");
			String name = in.next();
			in.nextLine();
			client.setName(name);
			System.out.println("The new name is : " + name + " UPDATED WITH SUCCESS!!");
			System.out.println("Client saved successfully " + client.toString());
			exit = true;
			break;
		case 3:
			System.out.println("*************** PASSWORD **************");
			System.out.println("Enter new password: ");
			String password = in.next();
			in.nextLine();
			client.setPassword(password);
			System.out.println("The new password is : " + password + " UPDATED WITH SUCCESS!!");
			System.out.println("Client saved successfully " + client.toString());
			exit = true;
			break;
		case 4:
			System.out.println("*************** BIRTH DATE **************");
			System.out.println("Enter new birth date (yyyy-mm-dd): ");
			LocalDate birthDate = LocalDate.parse(in.nextLine());
			client.setBirthDate(birthDate);
			System.out.println("The new birth date is : " + birthDate + " UPDATED WITH SUCCESS!!");
			System.out.println("Client saved successfully " + client.toString());
			exit = true;
			break;
		case 5:
			System.out.println("*************** PHONE **************");
			System.out.println("Enter new phone: ");
			Integer phone = in.nextInt();
			in.nextLine();
			client.setPhone(phone);
			System.out.println("The new Phone is : " + phone + " UPDATED WITH SUCCESS!!");
			System.out.println("Client saved successfully " + client.toString());
			exit = true;
			break;
		case 6:
			System.out.println("*************** MOBILE **************");
			System.out.println("Enter new mobile: ");
			Integer mobile = in.nextInt();
			in.nextLine();
			client.setMobile(mobile);
			System.out.println("The new Mobile is : " + mobile + " UPDATED WITH SUCCESS!!");
			System.out.println("Client saved successfully " + client.toString());
			exit = true;
			break;

		case 7:
			System.out.println("*************** EMAIL **************");
			System.out.println("Enter new email: ");
			String email = in.next();
			in.nextLine();
			client.setEmail(email);
			System.out.println("The new Email is : " + email + " UPDATED WITH SUCCESS!!");
			System.out.println("Client saved successfully " + client.toString());
			exit = true;
			break;
		case 8:
			System.out.println("*************** PROFESSION **************");
			System.out.println("Enter new profession: ");
			String profession = in.next();
			in.nextLine();
			client.setProfession(profession);
			System.out.println("The new profession is : " + profession + " UPDATED WITH SUCCESS!!");
			System.out.println("Client saved successfully " + client.toString());
			exit = true;
			break;
		case 9:
			exit = true;
			break;
			
			}
		}while(!exit);
	}

	private void addClient() throws Exception {
		header();
		System.out.println("*************** ADD NEW CLIENT **************");
		System.out.print("Enter Client's NIF: ");
		String nif = in.nextLine();
		System.out.println("Enter Client's Name: ");
		String name = in.nextLine();
		System.out.println("Enter Client's Password: ");
		String password = in.nextLine();
		System.out.println("Enter Client's BirthDate (yyyy-mm-dd): ");
		LocalDate birthDate = LocalDate.parse(in.next());
		System.out.println("Enter Client's phone: ");
		Integer phone = in.nextInt();
		in.nextLine();
		System.out.println("Enter Client's mobile phone: ");
		Integer mobile = in.nextInt();
		in.nextLine();
		System.out.println("Enter Client's email: ");
		String email = in.nextLine();
		System.out.println("Enter Client's profession: ");
		String profession = in.nextLine();
		Client client = new Client(nif, name, password, birthDate, phone, mobile, email, profession);
		clientService.save(client);

		Integer smallest = 0_032_000;
		Integer biggest = 1_000_999;
		Integer nib = ThreadLocalRandom.current().nextInt(smallest, biggest + 56573);
		Double balance = 0.00;
		Account account = new Account(nib, client, balance);
		accountService.save(account);
	
		System.out.println("Client wants a debit or credit card ? ");
		String option = in.nextLine();
		if (option.equals("debit")) {
			System.out.println("Enter Card pin max 6 characters:  ");
			Integer pin = in.nextInt();
			Long min = 1232_0183_0030_3883L;
			Long max = 4999_0000_3999_3883L;
			Long cardNumber = ThreadLocalRandom.current().nextLong(min, max + 615739993883L);
			DebitCard debitCard = new DebitCard(client, account, pin, cardNumber);
			cardService.save(debitCard);
			System.out.println("Client saved successfully " + client.toString());
			System.out.println("Account saved successfully " + account.toString());
			System.out.println("Debit card saved successfully " + debitCard.toString());
		}
		if (option.equals("credit")) {
			System.out.println("Enter Card pin max 6 characters:  ");
			Integer pin = in.nextInt();
			Long min = 1232_0183_0030_3883L;
			Long max = 4999_0000_3999_3883L;
			System.out.println("Enter the Plafond amount , maximum 1000: ");
			Double plafond = in.nextDouble();
			Long cardNumber = ThreadLocalRandom.current().nextLong(min, max + 615739993883L);
			CreditCard creditCard = new CreditCard(client, account, pin, cardNumber, plafond);
			cardService.save(creditCard);
			System.out.println("Client saved successfully " + client.toString());
			System.out.println("Account saved successfully " + account.toString());
			System.out.println("Credit card saved successfully" + creditCard.toString());
		}

		footer();
	}

	private void menu() {
		header();
		System.out.println("**************************************");
		System.out.println("**                                  **");
		System.out.println("**         1. Add Client            **");
		System.out.println("**         2. Add Secondary Client  **");
		System.out.println("**         3. Update Client         **");
		System.out.println("**         4. Update Account        **");
		System.out.println("**         5. New Debit Card        **");
		System.out.println("**         6. New Credit Card       **");
		System.out.println("**         7. List All              **");
		System.out.println("**         8. ATM                   **");
		System.out.println("**         9. back                  **");
		System.out.println("**                                  **");
		System.out.println("**************************************");
	}

	private void welcome() {

		System.out.println("******************************************************************************");
		System.out.println("**                               WELCOME                                    **");
		System.out.println("******************************************************************************");

	}

	private void updateClientMenu() {
		header();
		System.out.println("**************************************");
		System.out.println("**                                  **");
		System.out.println("**         1. Update nif            **");
		System.out.println("**         2. Update name           **");
		System.out.println("**         3. Update password       **");
		System.out.println("**         4. Update Birth Date     **");
		System.out.println("**         5. Update phone          **");
		System.out.println("**         6. Update mobile         **");
		System.out.println("**         7. Update email          **");
		System.out.println("**         8. Update profession     **");
		System.out.println("**         9. Back                  **");
		System.out.println("**                                  **");
		System.out.println("**************************************");
	}

	private void updateAcountMenu() {
		header();
		System.out.println("**************************************");
		System.out.println("**                                  **");
		System.out.println("**         1. Add Secondary Client  **");
		System.out.println("**         2. Update Balance        **");
		System.out.println("**         3. Back                  **");
		System.out.println("**                                  **");
		System.out.println("**************************************");
	}

	private void header() {

		System.out.println("******************************************************************************");
		System.out.println("**                            RUMOS DIGITAL BANK                            **");
		System.out.println("******************************************************************************");
		System.out.println("\n \n \n \n \n ");
	}

	private void footer() {
		System.out.println("\n \n \n \n \n ");
		System.out.println("******************************************************************************");
		System.out.println("**         THIS IS AN RDB MADE BY KARIM PATATAS IN A RUMOS PROJECT          **");
		System.out.println("******************************************************************************");

	}
	
	public void loginMenu() throws Exception  {
		System.out.println("*********************************** LOGIN ************************************");
		int attempts = 0;
		boolean exit = false;
		do {			
			System.out.print("Enter the nif to login: ");
			String nif = in.next();
			in.nextLine();
			System.out.print("Enter The password code to login: ");
			String password = in.next();
			in.nextLine();
			Client client = clientService.getByNifAndPassword(nif, password);			
		if(attempts >= 3) {
			System.out.println("YOU EXCEEDED YOUR ATTEMPTS " + attempts);
			exit = true;
		}
		if (nif.equals(client.getNif()) && password.equals(client.getPassword())) {
			System.out.println("Login Succefully");
			exit = true;
		} else {
			attempts++;
			System.out.println("Wrong Card Number or Pin , Please Enter a valid credentials for login!");
			System.out.println("You have " + (3 - attempts) + " Attempts left");
		}
		
		}while(!exit);	
	}

	private void back() throws Exception {
		header();
		runRDB();
	}
	

}
