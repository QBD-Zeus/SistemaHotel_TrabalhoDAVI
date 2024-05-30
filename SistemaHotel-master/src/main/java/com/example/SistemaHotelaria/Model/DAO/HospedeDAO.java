package com.example.SistemaHotelaria.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Hospede;
import com.example.SistemaHotelaria.config.DB;

public class HospedeDAO implements IDAO<Hospede> {

    public HospedeDAO() {
    }      

     @Override
    public void cadastrar(Hospede entidade) {
 
        Connection conn = this.conexao();

        try {
            String sql = "INSERT INTO Hospede (id, nome, cpf) VALUES ( nextval('seq_Hospede') , ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, entidade.getNome());
            statement.setString(2, entidade.getCpf());
            statement.executeUpdate();
            //System.out.println("Hospede Criado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
        public void atualizar(Hospede entidade) {
 
            Connection conn = this.conexao(); 

            try {
                String sql = "UPDATE hospede SET nome = ?, cpf = ? WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, entidade.getNome());
                statement.setString(2, entidade.getCpf());
                statement.setInt(3, entidade.getId());
                statement.executeUpdate();
                //System.out.println("Hospede Atualizado."); 

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void excluir(int id) {
 
        Connection conn = this.conexao();

        try {
            String sql = "DELETE FROM Hospede WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            //statement.setInt(1, entidade.getId());
            statement.executeUpdate();
            //System.out.println("Hospede Deletado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hospede buscar(int id) {
 
        Connection conn = this.conexao();

        Hospede retorno = new Hospede();
        try {
            String sql = "SELECT id, nome, cpf FROM Hospede WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            //statement.setInt(1, entidade.getId());
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                retorno.setId(result.getInt("id"));
                retorno.setNome(result.getString("nome"));
                retorno.setCpf(result.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    @Override
    public List<Hospede> listar() {

        Connection conn = this.conexao();
        
        List<Hospede> retorno = new ArrayList();
        try {
            String sql = "SELECT id, nome, cpf FROM Hospede";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Hospede hospede = new Hospede();
                hospede.setId(result.getInt("id"));
                hospede.setNome(result.getString("nome"));
                hospede.setCpf(result.getString("cpf"));
                //Listando todos os preenchimentos 
                retorno.add(hospede);
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
