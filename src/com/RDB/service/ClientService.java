package com.RDB.service;

import java.util.List;

import com.RDB.model.Client;

public interface ClientService {
	
	Client save(Client client) throws Exception;
	
	List<Client> getAll();
	
	Client getdById(Integer id) throws Exception;
	
	Client getByNif(String nif) throws Exception;
	
	Client getByNifAndPassword(String nif, String password) throws Exception;
	
	void deleteById(Integer id) throws Exception;
	
	

}
