package com.example.SistemaHotelaria.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Funcionario;
import com.example.SistemaHotelaria.config.DB;

public class FuncionarioDAO implements IDAO<Funcionario> {

    
    @Override
    public void cadastrar(Funcionario entidade) {

        Connection conn = this.conexao();

            try {
                String sql = "INSERT INTO Funcionario (id, nome, cargo, email) VALUES ( nextval('seq_funcionario') , ?, ? , ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, entidade.getNome());
                statement.setString(2, entidade.getCargo());
                statement.setString(3, entidade.getEmail());
                statement.executeUpdate();
                //System.out.println("Funcionario Criado!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


     @Override
    public void atualizar(Funcionario entidade) {

        Connection conn = this.conexao();

        try {
            String sql = "UPDATE Funcionario SET nome = ?, cargo = ?, email = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, entidade.getNome());
            statement.setString(2, entidade.getCargo());
            statement.setString(3, entidade.getEmail());
            statement.setInt(4, entidade.getId());
            statement.executeUpdate();
            //System.out.println("Funcionário Alterado!");
            //verificar alteração pois comando apaga toda linha 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {

        Connection conn = this.conexao();

        try {
            String sql = "DELETE FROM Funcionario WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            //System.out.println("Funcionário excluido!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario buscar(int id) {

        Connection conn = this.conexao();

        Funcionario retorno = new Funcionario();
        try {
            String sql = "SELECT id, nome, cargo, email FROM Funcionario WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("Detalhes:");
                retorno.setId(result.getInt("id"));
                retorno.setNome(result.getString("nome"));
                retorno.setCargo(result.getString("cargo"));
                retorno.setEmail(result.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Funcionario> listar() {

        Connection conn = this.conexao();
        
        List<Funcionario> retorno = new ArrayList();
        try {
            String sql = "SELECT id, nome, cargo, email FROM Funcionario";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setEmail(result.getString("email"));
                //Listando todos os preenchimentos 
                retorno.add(funcionario);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    private Connection conexao(){
        
        DB db = new DB();
        Connection conn = null;

        try {
            conn = db.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
