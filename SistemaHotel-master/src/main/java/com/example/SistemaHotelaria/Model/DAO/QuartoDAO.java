package com.example.SistemaHotelaria.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Quarto;
import com.example.SistemaHotelaria.config.DB;

public class QuartoDAO implements IDAO<Quarto>{

public QuartoDAO() {
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
    public void cadastrar(Quarto entidade) {

        Connection conn = this.conexao();

        try {
            String sql = "INSERT INTO Quarto (id, numero, disponivel, maxPessoas, andar) VALUES ( nextval('seq_quarto') , ?, ?,?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, entidade.getNumero());
            statement.setBoolean(2, entidade.isDisponivel());
            statement.setInt(3, entidade.getmaxPessoas());
            statement.setInt(4, entidade.getAndar());
            statement.executeUpdate();
            System.out.println("Quarto Criado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Quarto entidade) {

        Connection conn = this.conexao();

        try {
            String sql = "UPDATE quarto SET numero = ?, disponivel = ?, maxPessoas = ? , andar = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, entidade.getNumero());
            statement.setBoolean(2, entidade.isDisponivel());
            statement.setInt(3, entidade.getmaxPessoas());
            statement.setInt(4, entidade.getAndar());
            statement.setInt(5, entidade.getId());
            statement.executeUpdate();
            System.out.println("Quarto Alterado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {

        Connection conn = this.conexao();

        try {
            String sql = "DELETE FROM Quarto WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Reserva excluida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Quarto buscar(int id) {

        Connection conn = this.conexao();

        Quarto retorno = new Quarto();
        try {
            String sql = "SELECT id, numero, disponivel, maxPessoas, andar FROM Quarto WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("Detalhes:");
                retorno.setId(result.getInt("id"));
                retorno.setNumero(result.getInt("numero"));
                retorno.setDisponivel(result.getBoolean("disponivel"));
                retorno.setmaxPessoas(result.getInt("maxPessoas"));
                retorno.setAndar(result.getInt("andar"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    @Override
    public List<Quarto> listar() {

        Connection conn = this.conexao();
        
        List<Quarto> retorno = new ArrayList();
        try {

            String sql = "SELECT id, numero, disponivel, maxPessoas, andar FROM Quarto";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Quarto quarto = new Quarto();
                // conexao com a classe Quarto
                quarto.setId(result.getInt("id"));
                quarto.setNumero(result.getInt("numero"));
                quarto.setDisponivel(result.getBoolean("disponivel"));
                quarto.setmaxPessoas(result.getInt("maxPessoas"));
                quarto.setAndar(result.getInt("andar"));
                //Listando todos os preenchimentos 
                retorno.add(quarto);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public void inserir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

  

}



