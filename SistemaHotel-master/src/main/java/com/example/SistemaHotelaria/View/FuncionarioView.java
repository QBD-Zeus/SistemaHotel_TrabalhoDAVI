package com.example.SistemaHotelaria.View;

import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Funcionario;

public class FuncionarioView {

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarListaFuncionarios(List<Funcionario> funcionarios) {
    System.out.println("Funcionarios:");
    for (Funcionario funcionario : funcionarios) {
      System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome());
    }
  }
  
  public void mostrarDetalhesFuncionario(Funcionario funcionario) {
    System.out.println("ID: " + funcionario.getId());
    System.out.println("Nome: " + funcionario.getNome());
    System.out.println("Cargo: " + funcionario.getCargo());
    System.out.println("E-mail: " + funcionario.getEmail());
  }
    
}
