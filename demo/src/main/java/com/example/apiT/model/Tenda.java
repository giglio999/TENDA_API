package com.example.apiT.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tendas")  
public class Tenda {

    @Id 
    private String id;
    private String nome;
    private String tamanho;
    private double precoDiaria;
    private boolean disponivel;

 
    public Tenda(String nome, String tamanho, double precoDiaria, boolean disponivel) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.precoDiaria = precoDiaria;
        this.disponivel = disponivel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}