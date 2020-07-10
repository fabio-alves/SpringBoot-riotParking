package com.dale.riotparker.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import lombok.val;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dale.riotparker.dto.VeiculoDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.dale.riotparker.model.Cliente;
import com.dale.riotparker.repository.ClienteRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ClienteRepository repo;

    @Test
    public void getVeiculos() throws Exception{
        mvc.perform(get("/veiculo/123")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    public void getAllVeiculos() throws Exception{
        mvc.perform(get("/veiculo")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }
    @Test
    public void postVeiculo() throws Exception{
        mvc.perform(post("/veiculo")
        .content(mapper.writeValueAsString(dto()))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    private VeiculoDto dto(){
        val cliente = new Cliente();
        cliente.setNome("Fabio");

        repo.save(cliente);

        val dto = new VeiculoDto();
        dto.setPlaca("XDZ-3484");
        dto.setCor("Vermelho");
        dto.setModelo("BMW Z3");
        dto.setClienteId(cliente.getId());

        return dto;
    }
}