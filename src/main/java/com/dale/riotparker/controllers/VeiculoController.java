package com.dale.riotparker.controllers;

import java.util.List;
import java.util.Optional;

import com.dale.riotparker.dto.VeiculoDto;
import com.dale.riotparker.model.Cliente;
import com.dale.riotparker.model.Veiculo;
import com.dale.riotparker.repository.ClienteRepository;
import com.dale.riotparker.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.val;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private ClienteRepository clienteRepository;
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{placa}")
    public List<Veiculo> getVeiculos(@PathVariable ("placa") String placa){

        val lista = repo.findByPlaca(placa);
    
        return lista;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Veiculo> getAllVeiculos(){
        val lista = repo.findAll();
        return lista;
    }
    
    @ResponseStatus(HttpStatus.OK)
    public Veiculo postVeiculo(VeiculoDto dto){
        Optional<Cliente> cliente = clienteRepository.findById(dto.getClienteId());

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setCor(dto.getCor());
        veiculo.setCliente(cliente.get());

        return repo.save(veiculo);
    }
}