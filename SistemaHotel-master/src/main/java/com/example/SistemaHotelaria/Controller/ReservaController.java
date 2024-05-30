//Controla os dados da view
package com.example.SistemaHotelaria.Controller;

import java.util.List;

import com.example.SistemaHotelaria.Model.DAO.IDAO;
import com.example.SistemaHotelaria.Model.entity.Reserva;


public class ReservaController {

    private final IDAO<Reserva> reservaDAO;

    public ReservaController(IDAO<Reserva> reservaDAO) {
        this.reservaDAO = reservaDAO;
    }
   
    
    // Cadastradar Reserva
    public String cadastrarReserva(Reserva reserva){
        reservaDAO.cadastrar(reserva);
        return "Cadastrado com sucesso!";
    }
  
    // Atualizar Reserva
    public String atualizarReserva(Reserva reserva){
        reservaDAO.atualizar(reserva);
        return "Atualizado com sucesso!";
    };
   
    // Excluir Reserva
    public String excluirReserva(int id){
        reservaDAO.excluir(id);
        return "Excluído com sucesso!";
    };
    
    
    public List<Reserva> listarReserva() {
        return reservaDAO.listar();
    }


    public Reserva buscarReserva(int id) {
        return (Reserva) reservaDAO.buscar(id);
    }

}
