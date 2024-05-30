package com.example.SistemaHotelaria.Controller;

import java.util.List;

import com.example.SistemaHotelaria.Model.DAO.IDAO;
import com.example.SistemaHotelaria.Model.entity.Quarto;

public class QuartoController {
    
   private final IDAO<Quarto> quartoDAO;

    public QuartoController(IDAO<Quarto> quartoDAO) {
        this.quartoDAO = quartoDAO;
    }
    
    // Cadastradar Quarto
    public String cadastrarQuarto(Quarto quarto){
        quartoDAO.cadastrar(quarto);
        return "Cadastrado com sucesso!";
    }
  
    // Atualizar Quarto
    public String atualizarQuarto(Quarto quarto){
        quartoDAO.atualizar(quarto);
        return "Atualizado com sucesso!";
    };
   
    // Excluir Quarto
    public String excluirQuarto(int id){
        quartoDAO.excluir(id);
        return "Excluído com sucesso!";
    };
    
    
    public List<Quarto> listarQuarto() {
        return quartoDAO.listar();
    }

     // Buscar Hospede
    public Quarto buscarQuarto(int id) {
        return (Quarto) quartoDAO.buscar(id);
    }

    public void inserirQuarto(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }
}
