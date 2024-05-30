package com.example.SistemaHotelaria.View;

import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Quarto;

public class QuartoView {

        public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarListaQuarto(List<Quarto> quartos) {
    System.out.println("Quartos:");
    for (Quarto quarto : quartos) {
      boolean disponivel = quarto.isDisponivel();
      String status;
      if ( disponivel  = true ) {
          status = "Disponível"; } else { 
          status = "Ocupado"; }
      System.out.println("ID: " + quarto.getId() + "   | Numero: " + quarto.getNumero() + "    | Status:" + status );
    }
  }

  public void mostrarDetalhesQuarto(Quarto quarto) {
    System.out.println("ID: " + quarto.getId());
    System.out.println("Numero: " + quarto.getNumero());
    System.out.println("Andar: " + quarto.getAndar());
    System.out.println("Categoria: " + quarto.getCategoria());
    System.out.println("Capacidade de Hospedes: " + quarto.getmaxPessoas());
  }

  public void mostrarListaDisponivel(List<Quarto> quartos) {
    System.out.println("Quartos Disponiveis:");
    for (Quarto quarto : quartos) {
      boolean disponivel = quarto.isDisponivel();
      String status;

      if (disponivel = true) {
        status = "Disponível";
        System.out.println("ID: " + quarto.getId() + "   | Numero: " + quarto.getNumero() + "    | Status:" + status);
      }
    }
  }
    
}
