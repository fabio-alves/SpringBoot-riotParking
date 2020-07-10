package com.dale.riotparker.repository;

import java.util.List;

import com.dale.riotparker.model.Funcionario;
import com.dale.riotparker.model.Veiculo;

import org.springframework.data.repository.CrudRepository;

public interface  FuncionarioRepository extends CrudRepository<Funcionario, Long>{

  
}