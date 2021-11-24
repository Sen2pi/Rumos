package com.RDB.service;

import java.util.List;

import com.RDB.model.Client;
import com.RDB.repository.ClientRepository;
import com.RDB.repository.ClientRepositoryImpl;

public class ClientServiceImpl implements ClientService {
	private ClientRepository clientRepository = new ClientRepositoryImpl();

	@Override
	public Client save(Client client) throws Exception {
		if (client.getName() == null) {
			throw new Exception("Client must have a Name");
		}
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getAll() {

		return clientRepository.findAll();
	}

	@Override
	public Client getdById(Integer id) throws Exception{

		return clientRepository.findById(id);
	}

	@Override
	public Client getByNif(String nif) throws Exception {

		return clientRepository.findByNif(nif);
	}

	@Override
	public void deleteById(Integer id) {
		clientRepository.deleteById(id);

	}

	@Override
	public Client getByNifAndPassword(String nif, String password) throws Exception {
		return clientRepository.findByNifAndPassword(nif, password);
	}

}
