package com.RDB.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.RDB.model.Account;
import com.RDB.model.Card;
import com.RDB.model.Client;
import com.RDB.model.CreditCard;
import com.RDB.model.DebitCard;

public class ATMConsole {
	private CardService cardService;
	private AccountService accountService;
	private ClientService clientService;
	private AutomatedTellerMachine atm;


	public ATMConsole(CardService cardService, AccountService accountService, AutomatedTellerMachine atm, ClientService clientService) {
		this.cardService = cardService;
		this.accountService = accountService;
		this.clientService = clientService;
		this.atm = atm;

	}

	Scanner in = new Scanner(System.in);
	Account account;
	Client client;
	Card card;

	public void runATM() throws Exception {
		loginMenu();
		boolean exit = false;
		header();
		do {
			menu();
			System.out.println("Enter Option: ");
			int option = in.nextInt();
			in.nextLine();

			switch (option) {
			case 1:
				depositAmount();
				break;
			case 2:
				transfertAmount();
				break;
			case 3:
				withdrawAmount();
				break;
			case 4:
				newCreditCard();
				break;
			case 5:
				newDebitCard();
				break;
			case 6:
				movements();
				break;
			case 7:
				quitApp();
				exit = true;
				break;
			}
		} while (!exit);

	}

	ArrayList<String> movements = new ArrayList<String>();

	private void movements() {
	      for (int i = 0; i < movements.size();i++) 
	      { 		      
	          System.out.println(movements.get(i) + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 		
	      } 
	}

	private void setMovements(String operation, LocalDateTime now, Double amount) {
		if (operation.equals("withdraw")) {
			operation = "withdrawed";
		} else if (operation.equals( "deposit" )) {
			operation = "deposited";
		} else if (operation.equals("transfert")) {
			operation =  "transfert";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format = now.format(formatter) +" | Account Nib: "+ account.getPrimary() + " Has " + operation + " the amount "+ amount + "€ | Balance after operation is: "+ account.getBalance() + "€";
		account.setHistoryOfOperations(format);
		movements.add(format);

	}

	private void newDebitCard() throws Exception {
		header();
		System.out.println(cardService.getAll());
		long smallest = 1291_1277_0031_2304L;
		long biggest = 4291_9999_9999_9999L;
		long cardNumber = ThreadLocalRandom.current().nextLong(smallest, biggest + 623572537273L);
		System.out.println("Here is your new card number: " + cardNumber);

		System.out.println("Create a pin code for your card six digits max: ");
		int pin = in.nextInt();
		if (pin <= 0 && pin >= 999999) {
			System.out.println("pin must be greater than 0 and have 6 digits");
		}
		System.out.println("Pin was accepted");

		DebitCard debitCard = new DebitCard(pin, cardNumber);
		cardService.save(debitCard);

	}

	private void newCreditCard() throws Exception {
		header();
		System.out.println(cardService.getAll());
		long smallest = 1291_1277_0031_2304L;
		long biggest = 4291_9999_9999_9999L;
		long cardNumber = ThreadLocalRandom.current().nextLong(smallest, biggest + 623572537273L);
		System.out.println("Here is your new card number: " + cardNumber);

		System.out.println("Create a pin code for your card six digits max: ");
		int pin = in.nextInt();
		if (pin <= 0 && pin >= 999999) {
			System.out.println("pin must be greater than 0 and have 6 digits");
		}
		System.out.println("Pin was accepted");

		System.out.println("Insert the wanted Plafond on the card (limit 1000): ");
		int plafond = in.nextInt();
		if (plafond <= 0 || plafond >= 1000) {
			System.out.println("plafond must be positive and max of a 1000");
		}
		System.out.println("Plafond was accepted");

		CreditCard creditCard = new CreditCard(cardNumber, pin, plafond);
		cardService.save(creditCard);

	}

	private void withdrawAmount() throws Exception {
		System.out.println("dailyWithdraw was accepted");
		header();
		System.out.print("Enter the amount you want to withdraw: ");
		Double amount = in.nextDouble();
		if (amount >= 600) {
			throw new Exception("Daily Withdraw must be less than 600 per day");
		}
		in.nextLine();
		atm.withdraw(account, amount);
		String operation = "withdraw";
		LocalDateTime now = LocalDateTime.now();
		setMovements(operation, now, amount);

	}

	private void transfertAmount() throws Exception {
		header();
		System.out.println("Enter the nib number: ");
		int nib = in.nextInt();
		System.out.print("Enter the amount you want to Transfert: ");
		double amount = in.nextDouble();

		in.nextLine();
		atm.transfert(account, nib, amount);
		String operation = "transfert";
		LocalDateTime now = LocalDateTime.now(); 
		setMovements(operation, now, amount);

	}

	private void depositAmount() throws Exception {
		header();
		System.out.print("Enter the amount you want to deposit: ");
		Double amount = in.nextDouble();
		in.nextLine();
		atm.deposit(account, amount);
		String operation = "deposit";
		LocalDateTime now = LocalDateTime.now();
		setMovements(operation, now, amount);

	}

	private void menu() {
		header();
		System.out.println("**************************************");
		System.out.println("**                                  **");
		System.out.println("**         1. Deposit               **");
		System.out.println("**         2. Transfert             **");
		System.out.println("**         3. Withdraw              **");
		System.out.println("**         4. New Credit Card       **");
		System.out.println("**         5. New Debit Card        **");
		System.out.println("**         6. Movements             **");
		System.out.println("**         7. Quit App              **");
		System.out.println("**                                  **");
		System.out.println("**************************************");

	}

	public void header() {

		System.out.println("******************************************************************************");
		System.out.println("**                        AUTOMATED TELLER MACHINE                          **");
		System.out.println("******************************************************************************");

	}

	public void footer() {
		System.out.println("\n \n \n \n \n \n \n \n \n  ");
		System.out.println("******************************************************************************");
		System.out.println("**         THIS IS AN ATM MADE BY KARIM PATATAS IN A RUMOS PROJECT          **");
		System.out.println("******************************************************************************");

	}

	public void loginMenu() throws Exception {
		System.out.println("*********************************** LOGIN ************************************");
		int attempts = 0;
		boolean exit = false;
		do {
			System.out.print("Enter the Card Number to login: ");
			Long cardNumber = in.nextLong();
			in.nextLine();
			System.out.print("Enter The pin code to login: ");
			Integer pin = in.nextInt();
			in.nextLine();
			Card card = cardService.getByCardNumberAndPin(cardNumber, pin);
			if (attempts >= 3) {
				System.out.println("YOU EXCEEDED YOUR ATTEMPTS " + attempts);
				exit = true;
			}
			if (cardNumber.equals(card.getCardNumber()) && pin.equals(card.getPin())) {
				System.out.println("Login Succefully");
				account = card.getAccount();
				exit = true;
			} else {
				attempts++;
				System.out.println("Wrong Card Number or Pin , Please Enter a valid credentials for login!");
				System.out.println("You have " + (3 - attempts) + " Attempts left");
			}

		} while (!exit);
	}

	private void quitApp() {
		header();

		System.out.println("*****************************************************");
		System.out.println("** GOODBYE WAS A PLEASURE TO HAVE YOU AT OUR STORE **");
		System.out.println("*****************************************************");

		footer();
	}

}
