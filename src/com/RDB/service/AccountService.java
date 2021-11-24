package com.RDB.service;

import java.util.List;

import com.RDB.model.Account;

public interface AccountService {
	Account save(Account account) throws Exception;
	
	List<Account> getAll();
	
	Account getById(Integer id) throws Exception;
	
	Account getByNib(Integer nib) throws Exception;
	
	void deleteById(Integer id) throws Exception;
	
	void getBalance(Double balance );
	

}
