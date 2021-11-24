package com.RDB.repository;

import java.util.List;

import com.RDB.model.Account;

public interface AccountRepository {
	//CRUD - create - retrieve (read/get) 3 methods - update (PUT / PATCH) - Delete.
	//PUT - SAVE AND UPDATE ALL DATA.
	//PATCH - SAVE AND UPDATE A SINGLE ITEM.
	
	Account save(Account account) throws Exception;
	
	List<Account> findAll();
	
	Account findById(Integer id) throws Exception;
	
	Account findByNib(Integer nib) throws Exception;
	
	void deleteById(Integer id) throws Exception;

	void checkBalance(Double balance);
	
	

}
