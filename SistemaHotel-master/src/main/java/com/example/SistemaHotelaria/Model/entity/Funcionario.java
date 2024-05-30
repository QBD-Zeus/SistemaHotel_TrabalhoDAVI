package com.example.SistemaHotelaria.Model.entity;

public class Funcionario extends Abstrata {
    
    private String nome;
    private String cargo;
    private String email;

    
    public Funcionario(String nome, String cargo, String email) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
    }

    public Funcionario(){};


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
