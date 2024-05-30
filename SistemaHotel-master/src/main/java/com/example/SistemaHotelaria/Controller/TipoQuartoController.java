package com.example.SistemaHotelaria.Controller;

import java.util.List;

import com.example.SistemaHotelaria.Model.DAO.IDAO;
import com.example.SistemaHotelaria.Model.entity.TipoQuarto;

public class TipoQuartoController {
    
    private final IDAO<TipoQuarto> tipoQuartoDAO;

    public TipoQuartoController(IDAO<TipoQuarto> tipoQuartoDAO) {
        this.tipoQuartoDAO = tipoQuartoDAO;
    }
       
    // Cadastradar Tipos de Quarto
    public String cadastrarTipoQuarto(TipoQuarto tipoQuarto){
        tipoQuartoDAO.cadastrar(tipoQuarto);
        return "Cadastrado com sucesso!";
    }
  
    // Atualizar Tipos de Quarto
    public String atualizarTipoQuarto(TipoQuarto tipoQuarto){
        tipoQuartoDAO.atualizar(tipoQuarto);
        return "Atualizado com sucesso!";
    };
   
    // Excluir Tipos de Quarto
    public String excluirTipoQuarto(int id){
        tipoQuartoDAO.excluir(id);
        return "Excluído com sucesso!";
    };
    
    // Listar Tipos de Quarto
    public List<TipoQuarto> listarTipoQuarto() {
        return tipoQuartoDAO.listar();
    }
}
