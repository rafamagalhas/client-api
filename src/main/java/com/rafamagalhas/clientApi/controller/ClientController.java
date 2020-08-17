package com.rafamagalhas.clientApi.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafamagalhas.clientApi.dto.ClientDto;
import com.rafamagalhas.clientApi.entity.Client;
import com.rafamagalhas.clientApi.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClientDto> get(@PathVariable int id) {
		var response = clientService.find(id).clientDto();
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<ClientDto>> getAll() {
		var response = clientService.findAll().stream().map(Client::clientDto).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> post(@Valid @RequestBody ClientDto objDTO) {
		clientService.insert(objDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody ClientDto objDto, @PathVariable Integer id) {
		var response = clientService.update(id, objDto);
		return ResponseEntity.ok(response.clientDto());
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		clientService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
