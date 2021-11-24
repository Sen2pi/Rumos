package com.RDB.repository;

import java.util.Arrays;
import java.util.List;

import com.RDB.model.Account;

public class AccountRepositoryImpl implements AccountRepository {
	private Account[] accounts = new Account[10];
	private static int id;

	@Override
	public Account save(Account account) throws Exception {
		checkIfNibIsUnique(account);
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				account.setId(id);
				id++;
				accounts[i] = account;
				return accounts[i];
			}
		}
		throw new Exception("DATABASE IS FULL");
	}


	@Override
	public List<Account> findAll() {
		return Arrays.asList(accounts);
	}

	@Override
	public Account findById(Integer id) throws Exception {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				continue;
			}
			if (accounts[i].getId().equals(id)) {
				return accounts[i];
			}
		}
		throw new Exception("ACCOUNT WITH THIS ID: "+ id +" NOT FOUND");
	}

	@Override
	public Account findByNib(Integer nib) throws Exception {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				continue;
			}
			if (accounts[i].getNib().equals(nib)) {
				return accounts[i];
			}
		}
		throw new Exception("ACCOUNT WITH NIB: "+ nib +"NOT FOUND");
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				continue;
			}
			if (accounts[i].getId().equals(id)) {
				accounts[i] = null;
			}
		}
	}
	
	private void checkIfNibIsUnique(Account account) throws Exception {
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i] == null) {
				continue;}
			if (accounts[i].getNib().equals(account.getNib())) {
				throw new Exception("NIB: " + account.getNib() +"Already Exists" );
			}
		}
	}



	@Override
	public void checkBalance(Double balance) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				continue;
			}
			if (accounts[i].getBalance().equals(balance)) {
				System.out.println(balance);

			}
		}
		
	}


}
