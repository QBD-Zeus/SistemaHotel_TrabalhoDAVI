package com.example.SistemaHotelaria.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.SistemaHotelaria.Model.entity.TipoQuarto;
import com.example.SistemaHotelaria.config.DB;

public class TipoQuartoDAO implements IDAO<TipoQuarto> {


public TipoQuartoDAO() {
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


     @Override
    public void cadastrar(TipoQuarto entidade) {

        Connection conn = this.conexao();

        try {
            String sql = "INSERT INTO TipoQuarto (id, idTipoQuarto, categoria) VALUES ( nextval('seq_reserva') , ?, ? )";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, entidade.getIdTipoQuarto());
            statement.setString(2, entidade.getCategoria());
            statement.executeUpdate();
            System.out.println("Tipo do Quarto Criado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(TipoQuarto entidade) {
        
        Connection conn = this.conexao();

        try {
            String sql = "UPDATE TipoQuarto SET idTipoQuarto = ?, categoria = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, entidade.getIdTipoQuarto());
            statement.setString(2, entidade.getCategoria());
            statement.setInt(3, entidade.getId());
            statement.executeUpdate();
            System.out.println("Tipo do Quarto Alterado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
    }

    @Override
    public void excluir(int id) {

        Connection conn = this.conexao();

        try {
            String sql = "DELETE FROM TipoQuarto WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Tipo excluido!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TipoQuarto buscar(int id) {

        Connection conn = this.conexao();

        TipoQuarto retorno = new TipoQuarto();
        try {
            String sql = "SELECT id, idTipoQuarto, categoria FROM TipoQuarto WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("Detalhes:");
                retorno.setId(result.getInt("id"));
                retorno.setIdTipoQuarto(result.getInt("idTipoQuarto"));
                retorno.setCategoria(result.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    @Override
    public List<TipoQuarto> listar() {

        Connection conn = this.conexao();
        
        List<TipoQuarto> retorno = new ArrayList();
        try {
            String sql = "SELECT id FROM TipoQuarto";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                TipoQuarto tipoquarto = new TipoQuarto();

                tipoquarto.setId(result.getInt("id"));
                tipoquarto.setIdTipoQuarto(result.getInt("idTipoQuarto"));
                tipoquarto.setCategoria(result.getString("categoria"));
                //Listando todos os preenchimentos 
                retorno.add(tipoquarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public void inserir(TipoQuarto entidade) {
        
        Connection conn = this.conexao();

        try {
            String sql = "UPDATE TipoQuarto SET idTipoCategoria = ?, categoria = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, entidade.getIdTipoQuarto());
            statement.setString(2, entidade.getCategoria());
            statement.setInt(5, entidade.getId());
            statement.executeUpdate();
            System.out.println("Reserva Alterado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}

