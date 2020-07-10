package com.dale.riotparker.repository;

import com.dale.riotparker.model.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}