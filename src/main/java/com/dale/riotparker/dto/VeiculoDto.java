package com.dale.riotparker.dto;

import lombok.Data;

@Data
public class VeiculoDto {

    private Long id;
    private String placa;
    private String cor;
    private String modelo;
    private Long clienteId;
    
}