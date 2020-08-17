package com.rafamagalhas.clientApi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafamagalhas.clientApi.dto.ClientDto;
import com.rafamagalhas.clientApi.entity.Client;
import com.rafamagalhas.clientApi.exceptions.type.DataIntegrationException;
import com.rafamagalhas.clientApi.repository.ClientRepository;
import com.rafamagalhas.clientApi.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public Client insert(ClientDto client) {
		var clientEmailCheck = clientRepository.findByEmail(client.getEmail());
		
		if (clientEmailCheck.isPresent()) {
			throw new DataIntegrationException("Email já cadastrado!");
		}
		
		return clientRepository.save( Client.builder()
				.name(client.getName())
				.email(client.getEmail())
				.build());
	}
	
	public Client find(int id) {
		var client = clientRepository.findById(id);
		
		if (!client.isPresent()) {
			throw new DataIntegrationException("Cliente não existe!");
		}
		
		return client.get();
	}
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client update(int id, ClientDto client) {
		var clientCheckExists = clientRepository.findById(id);
		
		if (!clientCheckExists.isPresent()) {
			throw new DataIntegrationException("Cliente não existe!");
		}
		
		var clientToChange = this.find(id);
		clientToChange.setName(client.getName());
		clientToChange.setEmail(client.getEmail());
		
		return clientRepository.save(clientToChange);
	}
	
	public void delete(int id) {
		var client = this.find(id);
		clientRepository.delete(client);
	}
}
