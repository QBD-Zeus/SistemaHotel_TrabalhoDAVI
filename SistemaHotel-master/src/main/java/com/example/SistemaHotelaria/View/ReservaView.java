package com.example.SistemaHotelaria.View;

import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Reserva;

public class ReservaView {

  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }

  public void mostrarListaReserva(List<Reserva> reservas) {
    System.out.println("Reservas Feitas:");
    for (Reserva reserva : reservas) {
      System.out.println("ID: " + reserva.getId() + ", Numero: " + reserva.getResponsavel());
    }
  }

  public void mostrarDetalhesReserva(Reserva reserva) {
    System.out.println("ID: " + reserva.getId());
    System.out.println("Responsável pela Reserva: " + reserva.getResponsavel());
    System.out.println("Check-in: " + reserva.getCheckinDate());
    System.out.println("Check-out: " + reserva.getCheckoutDate());
    System.out.println("Hospedes: " + reserva.getQtdPessoas());
  }

}
