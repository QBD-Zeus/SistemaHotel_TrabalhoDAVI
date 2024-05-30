package com.example.SistemaHotelaria;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SistemaHotelaria.Controller.FuncionarioController;
import com.example.SistemaHotelaria.Controller.HospedeController;
import com.example.SistemaHotelaria.Controller.QuartoController;
import com.example.SistemaHotelaria.Controller.ReservaController;
import com.example.SistemaHotelaria.Model.DAO.FuncionarioDAO;
import com.example.SistemaHotelaria.Model.DAO.HospedeDAO;
import com.example.SistemaHotelaria.Model.DAO.QuartoDAO;
import com.example.SistemaHotelaria.Model.DAO.ReservaDAO;
import com.example.SistemaHotelaria.View.FuncionarioView;
import com.example.SistemaHotelaria.View.HospedeView;
import com.example.SistemaHotelaria.View.QuartoView;
import com.example.SistemaHotelaria.View.ReservaView;
import com.example.SistemaHotelaria.config.DB;

@SpringBootApplication
public class Application implements CommandLineRunner {

        public static void main(String[] args) {
                SpringApplication.run(Application.class, args);
        }
        
        @Override
        public void run(String... args) throws Exception {

        // Inicialização das dependências - Funcionario
	    FuncionarioView funcionarioView = new FuncionarioView();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioController funcionarioController = new FuncionarioController(funcionarioDAO);
		
		// Inicialização das dependências - Hospede
	    HospedeView hospedeView = new HospedeView();
		HospedeDAO hospedeDAO = new HospedeDAO();
		HospedeController hospedeController = new HospedeController(hospedeDAO);   

		// Inicialização das dependências - Quarto
	    QuartoView quartoView = new QuartoView();
		QuartoDAO quartoDAO = new QuartoDAO();
		QuartoController quartoController = new QuartoController(quartoDAO); 

		// Inicialização das dependências - Reserva
	    ReservaView reservaView = new ReservaView();
		ReservaDAO reservaDAO = new ReservaDAO();
		ReservaController reservaController = new ReservaController(reservaDAO); 

		
		// Inicialização do Banco de Dados
		DB.createTables();
		
		// Inicialização da CLI
		Scanner scanner = new Scanner(System.in);

		SistemaHotel sistemaFuncionario = new SistemaHotel(funcionarioController, funcionarioView, scanner);

		SistemaHotel sistemaHospede = new SistemaHotel(hospedeController, hospedeView, scanner);

		SistemaHotel sistemaQuarto = new SistemaHotel(quartoController, quartoView, scanner);

		SistemaHotel sistemaReserva = new SistemaHotel(reservaController, reservaView, scanner);


		
		// Inicialização do sistema
		sistemaFuncionario.iniciar();
		sistemaQuarto.iniciar();
		sistemaHospede.iniciar();
		sistemaReserva.iniciar();
		
		
                
        }
}
