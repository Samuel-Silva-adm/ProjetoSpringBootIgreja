package com.membrosapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipoOportunidade;
    private LocalDate dataCulto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoOportunidade() {
        return tipoOportunidade;
    }

    public void setTipoOportunidade(String tipoOportunidade) {
        this.tipoOportunidade = tipoOportunidade;
    }

    public LocalDate getDataCulto() {
        return dataCulto;
    }

    public void setDataCulto(LocalDate dataCulto) {
        this.dataCulto = dataCulto;
    }
}
