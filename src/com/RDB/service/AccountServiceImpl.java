package com.RDB.service;

import java.util.List;

import com.RDB.model.Account;
import com.RDB.repository.AccountRepository;
import com.RDB.repository.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {
	private AccountRepository accountRepository = new AccountRepositoryImpl();

	@Override
	public Account save(Account account) throws Exception {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account getById(Integer id) throws Exception {
		return accountRepository.findById(id);
	}

	@Override
	public Account getByNib(Integer nib) throws Exception {
		return accountRepository.findByNib(nib);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		accountRepository.deleteById(id);
	}

	@Override
	public void getBalance(Double balance) {
		accountRepository.checkBalance(balance);	
	}

}
