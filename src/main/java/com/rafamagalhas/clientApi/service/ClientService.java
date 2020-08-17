package com.rafamagalhas.clientApi.service;

import java.util.List;

import com.rafamagalhas.clientApi.dto.ClientDto;
import com.rafamagalhas.clientApi.entity.Client;

public interface ClientService {
	Client find(int id);
	List<Client> findAll();
	Client update(int idClient, ClientDto client);
	Client insert(ClientDto client);
	void delete (int idClient);
}
