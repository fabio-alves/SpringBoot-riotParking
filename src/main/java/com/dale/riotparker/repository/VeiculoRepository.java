package com.dale.riotparker.repository;

import java.util.List;

import com.dale.riotparker.model.Veiculo;

import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
    
    List<Veiculo> findByPlaca(String placa);
    List<Veiculo> findAll();
    Veiculo save(Veiculo veiculo);
}