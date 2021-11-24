package com.RDB.repository;

import java.util.Arrays;
import java.util.List;

import com.RDB.model.Card;
import com.RDB.model.Client;

public class ClientRepositoryImpl implements ClientRepository{
	private Client[] clients = new Client[10];
	private static int id;

	@Override
	public Client save(Client client) throws Exception {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				id++;
				client.setId(id);
				clients[i] = client;
				return clients[i];
			} if (clients[i].getId().equals(client.getId())) {
				clients[i] = client;
				return clients[i];
			}
		}
		throw new Exception("DATABASE FULL");
	}

	@Override
	public List<Client> findAll() {
		return Arrays.asList(clients);
	}

	@Override
	public Client findById(Integer id) throws Exception {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				continue;
			}
			if (clients[i].getId().equals(id)) {
				return clients[i];
			}
		}
		throw new Exception("ACCOUNT WITH THIS ID: "+ id +" NOT FOUND");
	}

	@Override
	public Client findByNif(String nif) throws Exception {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				continue;
			}
			if (clients[i].getNif().equals(nif)) {
				return clients[i];
			}
		}
		throw new Exception("ACCOUNT WITH THIS NIF: "+ nif +" NOT FOUND");
	}
	

	@Override
	public void deleteById(Integer id) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				continue;
			}
			if (clients[i].getId().equals(id)) {
				clients[i] = null;
			}
		}
		
	}

	@Override
	public Client findByNifAndPassword(String nif, String password) throws Exception {
			for (int i = 0; i < clients.length; i++) {
				if (clients[i] == null) {
					continue;
				}
				if (clients[i].getNif().equals(nif) && clients[i].getPassword().equals(password)) {
					return clients[i];
				}
			}
			throw new Exception("CARD WITH THIS CLIENT: " + nif + "And Password NOT FOUND");
			
	}

}
