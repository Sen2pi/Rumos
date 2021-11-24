package com.RDB.repository;

import java.util.List;

import com.RDB.model.Client;

public interface ClientRepository {
	Client save(Client client) throws Exception;
	
	List<Client> findAll();
	
	Client findById(Integer id) throws Exception;
	
	Client findByNif(String nif) throws Exception;
	
	Client findByNifAndPassword(String nif, String password) throws Exception;
	
	void deleteById(Integer id);

}
