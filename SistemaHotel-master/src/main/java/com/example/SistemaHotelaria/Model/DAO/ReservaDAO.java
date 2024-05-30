package com.example.SistemaHotelaria.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Reserva;
import com.example.SistemaHotelaria.config.DB;

public class ReservaDAO implements IDAO<Reserva> {


public ReservaDAO() {
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
    public void cadastrar(Reserva entidade) {

        Connection conn = this.conexao();

        try {
            String sql = "INSERT INTO Reserva (id, responsavel, checkinDate, checkoutdate, qtdpessoas) VALUES ( nextval('seq_reserva') , ?, ? , ? ,? )";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, entidade.getResponsavel());
            statement.setDate(2, entidade.getCheckinDate());
            statement.setDate(3, entidade.getCheckoutDate());
            statement.setInt(4, entidade.getQtdPessoas());
            statement.executeUpdate();
            System.out.println("Reserva Criado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Reserva entidade) {
        
        Connection conn = this.conexao();

        try {
            String sql = "UPDATE Reserva SET responsavel = ?, checkinDate = ?, checkoutDate = ? qtdPessoas = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, entidade.getResponsavel());
            statement.setDate(2, entidade.getCheckinDate());
            statement.setDate(3, entidade.getCheckoutDate());
            statement.setInt(4, entidade.getQtdPessoas());
            statement.setInt(5, entidade.getId());
            statement.executeUpdate();
            System.out.println("Reserva Alterado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void excluir(int id) {

        Connection conn = this.conexao();

        try {
            String sql = "DELETE FROM Reserva WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Reserva excluido!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reserva buscar(int id) {

        Connection conn = this.conexao();

        Reserva retorno = new Reserva();
        try {
            String sql = "SELECT id, responsavel, checkinDate, checkoutDate, qtdPessoas FROM Reserva WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("Detalhes:");
                retorno.setId(result.getInt("id"));
                retorno.setResponsavel(result.getString("responsavel"));
                retorno.setCheckinDate(result.getDate("checkinDate"));
                retorno.setCheckoutDate(result.getDate("checkoutDate"));
                retorno.setQtdPessoas(result.getInt("qtdPessoas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    @Override
    public List<Reserva> listar() {

        Connection conn = this.conexao();
        
        List<Reserva> retorno = new ArrayList();
        try {
            String sql = "SELECT id, responsavel, checkinDate, checkoutDate, qtdPessoas FROM Reserva";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Reserva reserva = new Reserva();

                reserva.setId(result.getInt("id"));
                reserva.setResponsavel(result.getString("responsavel"));
                reserva.setCheckinDate(result.getDate("checkinDate"));
                reserva.setCheckoutDate(result.getDate("checkoutDate"));
                reserva.setQtdPessoas(result.getInt("qtdPessoas"));
                //Listando todos os preenchimentos 
                retorno.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public void inserir(Reserva entidade) {
        
        Connection conn = this.conexao();

        try {
            String sql = "UPDATE Reserva SET responsavel = ?, checkinDate = ?, checkoutDate = ? qtdPessoas = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, entidade.getResponsavel());
            statement.setDate(2, entidade.getCheckinDate());
            statement.setDate(3, entidade.getCheckoutDate());
            statement.setInt(4, entidade.getQtdPessoas());
            statement.setInt(5, entidade.getId());
            statement.executeUpdate();
            System.out.println("Reserva Alterado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}

