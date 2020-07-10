package com.dale.riotparker.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.dale.riotparker.model.Cliente;

@NoArgsConstructor
@Data
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String cor;
    private String modelo;

    @ManyToOne
    private Cliente cliente;
}