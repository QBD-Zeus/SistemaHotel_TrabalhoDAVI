package com.example.SistemaHotelaria.Controller;

import java.util.List;

import com.example.SistemaHotelaria.Model.DAO.IDAO;
import com.example.SistemaHotelaria.Model.entity.Hospede;

public class HospedeController {

    private final IDAO<Hospede> hospedeDAO;

    public HospedeController(IDAO<Hospede> hospedeDAO) {
        this.hospedeDAO = hospedeDAO;
    }
    
    // Cadastradar hospede
    public String cadastrarHospede(Hospede hospede){
        hospedeDAO.cadastrar(hospede);
        return "Cadastrado com sucesso!";
    }
  
    // Atualizar Hospede
    public String atualizarHospede(Hospede hospede){
        hospedeDAO.atualizar(hospede);
        return "Atualizado com sucesso!";
    };
   
    // Excluir Hospede
    public String excluirHospede(int id){
        hospedeDAO.excluir(id);
        return "Excluído com sucesso!";
    };
    
    // Listar Hospede
    public List<Hospede> listarHospede() {
        return hospedeDAO.listar();
    }

    // Buscar Hospede
    public Hospede buscarHospede(int id) {
        return (Hospede) hospedeDAO.buscar(id);
    }



}
