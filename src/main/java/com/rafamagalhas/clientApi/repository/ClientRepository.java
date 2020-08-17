package com.rafamagalhas.clientApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafamagalhas.clientApi.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	Optional<Client> findByEmail(String email);
}
