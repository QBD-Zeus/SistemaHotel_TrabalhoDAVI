package com.example.SistemaHotelaria.View;

import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Hospede;

public class HospedeView {

  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }

  public void mostrarListaHospedes(List<Hospede> hospedes) {
    for (Hospede hospede : hospedes) {
      System.out.println("ID: " + hospede.getId() + ", Nome: " + hospede.getNome());
    }
  }

  public void mostrarDetalhesHospede(Hospede hospede) {
    System.out.println("ID: " + hospede.getId());
    System.out.println("Nome: " + hospede.getNome());
    System.out.println("CPF: " + hospede.getCpf());
  }
}
