package com.gft.productapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @CNPJ
    @NotBlank
    private String cnpj;

    private List<Produto> produtos;
}
