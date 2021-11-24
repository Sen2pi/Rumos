package com.RDB.service;

import java.util.Scanner;

import com.RDB.PresetData.PresetData;

public class PreConsole {
	ATMConsole atmConsole;
	RDBConsole rdbConsole;
	PresetData data = new PresetData();

	Scanner in = new Scanner(System.in);
	public PreConsole() throws Exception {
		data.presetClientTwo();
		data.presetClientOne();
		
		this.rdbConsole = new RDBConsole(data.getCardService(), data.getClientService(), data.getAccountService(), data.getAtm());
		this.atmConsole = new ATMConsole(data.getCardService(), data.getAccountService(), data.getAtm(), data.getClientService());
	}

	public void welcome() {
		System.out.println("******************************************************************************");
		System.out.println("**                                 WELCOME                                  **");
		System.out.println("******************************************************************************");

	}

	public void selector() throws Exception {
		Boolean exit = false;
		do {
			welcome();
			System.out.println("1. ATM");
			System.out.println("2. Rumos Digital Bank");
			System.out.println("3. Quit Application");
			System.out.println("Enter an Option:");
			footerInit();
			int option = in.nextInt();
			if (option < 1 || option > 3) {
				throw new Exception(" The " + option + " Is not a valid option. Please try again");
			}
			footerInit();
			switch (option) {
			case 1:
				atmConsole.runATM();
				exit = true;
				break;
			case 2:
				rdbConsole.runRDB();
				exit = true;
				break;
			case 3:
				quitApp();
				exit = true;
				break;
			}

		} while (!exit);
	}

	private void quitApp() {
		headerInit();
		System.out.println("\n \n \n \n \n \n \n \n \n  ");
		System.out.println("********************************** GOODBYE ***********************************");
		System.out.println("\n \n \n \n \n \n \n \n \n  ");
		footerInit();

	}

	public void headerInit() {
		System.out.println("******************************************************************************");
		System.out.println("**                                 WELCOME                                  **");
		System.out.println("******************************************************************************");
	}

	public void footerInit() {
		System.out.println("******************************************************************************");
		System.out.println("**       THIS IS A PROJECT MADE BY KARIM PATATAS IN A RUMOS PROJECT         **");
		System.out.println("******************************************************************************");
	}
}
