package com.gft.productapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @CNPJ
    @NotBlank
    private String cnpj;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos;
}
