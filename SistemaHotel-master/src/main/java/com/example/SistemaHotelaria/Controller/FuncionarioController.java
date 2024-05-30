package com.example.SistemaHotelaria.Controller;

import java.util.List;


import com.example.SistemaHotelaria.Model.DAO.IDAO;
import com.example.SistemaHotelaria.Model.entity.Funcionario;


public class FuncionarioController {

        private final IDAO<Funcionario> funcionarioDAO;

        public FuncionarioController(IDAO<Funcionario> funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
        }

        // Cadastrar Funcionario
        public String cadastrarFuncionario(Funcionario funcionario) {
                funcionarioDAO.cadastrar(funcionario);
                return "Cadastrado com sucesso!";
        };

        // Atualizar Funcionario
        public String atualizarFuncionario(Funcionario funcionario) {
                funcionarioDAO.atualizar(funcionario);
                return "Atualizado com sucesso!";
        };

        // Excluir Funcionario
        public String excluirFuncionario(int id) {
                funcionarioDAO.excluir(id);
                return "Excluido com sucesso!";
        };
        
        // Buscar Funcionario
        public Funcionario buscarFuncionario(int id) {
                return (Funcionario) funcionarioDAO.buscar(id);
        }

        public List<Funcionario> listarFuncionarios() {
                return funcionarioDAO.listar();
        }
}
