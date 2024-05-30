package com.example.SistemaHotelaria;


import java.util.List;
import java.util.Scanner;

import com.example.SistemaHotelaria.Controller.FuncionarioController;
import com.example.SistemaHotelaria.Controller.HospedeController;
import com.example.SistemaHotelaria.Controller.QuartoController;
import com.example.SistemaHotelaria.Controller.ReservaController;
import com.example.SistemaHotelaria.Model.entity.Funcionario;
import com.example.SistemaHotelaria.Model.entity.Hospede;
import com.example.SistemaHotelaria.Model.entity.Quarto;
import com.example.SistemaHotelaria.Model.entity.Reserva;
import com.example.SistemaHotelaria.View.FuncionarioView;
import com.example.SistemaHotelaria.View.HospedeView;
import com.example.SistemaHotelaria.View.QuartoView;
import com.example.SistemaHotelaria.View.ReservaView;

public class SistemaHotel {

    private FuncionarioController funcionarioController;
    private FuncionarioView funcionarioView;

    private HospedeController hospedeController;
    private HospedeView hospedeView;

    private QuartoController quartoController;
    private QuartoView quartoView;

    private ReservaController reservaController;
    private ReservaView reservaView;

    private Scanner scanner;

    public SistemaHotel(FuncionarioController funcionarioController, FuncionarioView funcionarioView, Scanner scanner) {
        this.funcionarioController = funcionarioController;
        this.funcionarioView = funcionarioView;
        this.scanner = scanner;
    }

    public SistemaHotel(HospedeController hospedeController, HospedeView hospedeView, Scanner scanner) {
        this.hospedeController = hospedeController;
        this.hospedeView = hospedeView;
        this.scanner = scanner;
    }

    public SistemaHotel(QuartoController quartoController, QuartoView quartoView, Scanner scanner) {
        this.quartoController = quartoController;
        this.quartoView = quartoView;
        this.scanner = scanner;
    }
    
    public SistemaHotel(ReservaController reservaController, ReservaView reservaView, Scanner scanner) {
        this.reservaController = reservaController;
        this.reservaView = reservaView;
        this.scanner = scanner;
    }

    public void iniciar() {

        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    // Gerenciar Hospede (Cadastrar Hospede, Atualizar Hospede, Excluir Hospede)
                    // mostrar sub menu
                    menuGerenciarHospede();
                    while (opcao != 5) {
                        opcao = scanner.nextInt();
                        switch (opcao) {
                            case 1:
                                // Cadastrar Hospede
                                cadastrarHospede();
                                break;
                            case 2:
                                // Atualizar Hospede
                                atualizarHospede();
                                break;
                            case 3:
                                // Excluir Hospede
                                listarHospede();
                                break;
                            case 4:
                                // Excluir Hospede
                                excluirHospede();
                                break;
                            case 5:
                                // Excluir Hospede
                                mostrarMenu();
                                break;

                            default:
                                mostrarMenu();
                                break;
                        }
                    }
                    break;
                case 2:
                    // Gerenciar Funcionários (Cadastrar Funcionario, Atualizar Funcionario, Excluir
                    // Funcionario)
                    menuGerenciarFuncionario();
                    while (opcao != 5) {
                        opcao = scanner.nextInt();
                        switch (opcao) {
                            case 1:
                                // Cadastrar Funcionario
                                cadastrarFuncionario();
                                break;
                            case 2:
                                // Atualizar Funcionario
                                atualizarFuncionario();
                                break;
                            case 3:
                                listarFuncionario();
                                break;
                            case 4:
                                excluirFuncionario();
                                break;
                            case 5:
                                mostrarMenu();
                                break;
                        }
                    }
                    break;
                case 3:
                    // Gerenciar Reserva (inserir reservas, atualizar status e excluir reservas)
                    menuGerenciarReserva();
                    while (opcao != 5) {
                        opcao = scanner.nextInt();
                        switch (opcao) {
                            case 1:
                                // inserir reservas
                                cadastrarReserva();
                                break;
                            case 2:
                                // Atualizar Status
                                atualizarReserva();
                                break;
                            case 3:
                                // Listar reservas
                                listarReserva();
                                break;
                            case 4:
                                // Excluir reservas
                                excluirReserva();
                                break;
                            case 5:
                                mostrarMenu();
                                break;
                            default:
                                mostrarMenu();
                                break;
                        }
                    }
                    break;
                case 4:
                    // Gerenciar Tipos de Quarto (inserir, atualizar e excluir tipos de quarto)
                    menuQuartos();
                    while (opcao != 5) {
                        opcao = scanner.nextInt();
                        switch (opcao) {
                            case 1:
                                // Inserir Quartos
                                cadastrarQuarto();
                                break;
                            case 2:
                                // Atualizar Quartos
                                atualizarQuarto();
                                break;
                            case 3:
                                // Excluir tipos de quarto)
                                excluirQuarto();
                                break;
                            default:
                                mostrarMenu();
                                break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    // SUB MENUS PARA ESPECIFICAR AS AÇÕES
    public static void mostrarMenu() {
        System.out.println("MENU");
        System.out.println("1 - Gerenciar Hospede");
        System.out.println("2 - Gerenciar Funcionario");
        System.out.println("3 - Gerenciar Reserva");
        System.out.println("4 - Tipos de Quarto");
    }

    public static void menuGerenciarFuncionario() {
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Atualizar Funcionário");
        System.out.println("3 - Listar Funcionário");
        System.out.println("4 - Excluir Funcionário");
        System.out.println("5 - Voltar");
    }

    public static void menuGerenciarHospede() {
        System.out.println("1 - Cadastrar Hospede");
        System.out.println("2 - Atualizar Hospede");
        System.out.println("3 - Listar Hospede");
        System.out.println("4 - Excluir Hospede");
        System.out.println("5 - Voltar");
    }

    public static void menuGerenciarReserva() {
        System.out.println("1 - Inserir Reserva");
        System.out.println("2 - Atualizar Status");
        System.out.println("3 - Listar Status");
        System.out.println("4 - Excluir Reserva");
        System.out.println("5 - Voltar");
    }

    public static void menuQuartos() {
        System.out.println("1 - Inserir Quarto");
        System.out.println("2 - Atualizar Quarto");
        System.out.println("3 - Listar Tipo de Quarto");
        System.out.println("3 - Excluir Tipo de Quarto");
        System.out.println("4 - Voltar");
    }

    // FUNÇÕES PARA OBTER OS DADOS VIA TERMINAL - FUNCIONÁRIO
    private void cadastrarFuncionario() {

        scanner.nextLine(); // Limpar o buffer do scanner

        funcionarioView.mostrarMensagem("Digite o nome do funcionario:");
        String nome = scanner.nextLine();

        funcionarioView.mostrarMensagem("Digite o cargo do funcionário:");
        String cargo = scanner.nextLine();

        funcionarioView.mostrarMensagem("Digite o e-mail corporativo:");
        String email = scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, cargo, email);
        String retorno = funcionarioController.cadastrarFuncionario(novoFuncionario);
        funcionarioView.mostrarMensagem(retorno);
    }

    private void listarFuncionario() {

        funcionarioView.mostrarMensagem("** Funcionarios Cadastrados **");
        List<Funcionario> funcionario = funcionarioController.listarFuncionarios();
        funcionarioView.mostrarListaFuncionarios(funcionario);
        funcionarioView.mostrarMensagem("******************************");

    }

    private void atualizarFuncionario() {

        funcionarioView.mostrarMensagem("Digite o ID do funcionário a ser atualizado:");
        int id = scanner.nextInt();

        Funcionario funcionario = funcionarioController.buscarFuncionario(id);

        if (funcionario != null) {

            scanner.nextLine(); // Limpar o buffer do scanner

            funcionarioView.mostrarMensagem("Digite o novo nome do funcionário:");
            String nome = scanner.nextLine();
            funcionario.setNome(nome);

            funcionarioView.mostrarMensagem("Digite o novo cargo do funcionário:");
            String cargo = scanner.nextLine();
            funcionario.setCargo(cargo);

            funcionarioView.mostrarMensagem("Digite o novo e-mail do funcinário:");
            String email = scanner.nextLine();
            funcionario.setEmail(email);

            String retorno = funcionarioController.atualizarFuncionario(funcionario);
            funcionarioView.mostrarMensagem(retorno);
        } else {
            funcionarioView.mostrarMensagem("Colaborador não encontrado!");
        }
    }

    private void excluirFuncionario() {

        funcionarioView.mostrarMensagem("Digite o ID do funcionário a ser excluído:");
        int id = scanner.nextInt();
        String retorno = funcionarioController.excluirFuncionario(id);
        funcionarioView.mostrarMensagem(retorno);
    }

    private void buscarFuncionario() {

        funcionarioView.mostrarMensagem("Digite o ID do funcionário a ser buscado:");
        int id = scanner.nextInt();
        Funcionario funcionario = funcionarioController.buscarFuncionario(id);

        if (funcionario != null) {
            funcionarioView.mostrarDetalhesFuncionario(funcionario);
        } else {
            funcionarioView.mostrarMensagem("Livro não encontrado!");
        }
    }

// FUNÇÕES PARA OBTER OS DADOS VIA TERMINAL - HOSPEDE

    private void cadastrarHospede() {

        System.out.println("Cadastro de Hospede");

        scanner.nextLine(); // Limpar o buffer do scanner

        hospedeView.mostrarMensagem("Digite o nome do Hospede:");
        String nome = scanner.nextLine();

        hospedeView.mostrarMensagem("Digite o CPF:");
        String cpf = scanner.nextLine();

        Hospede novoHospede = new Hospede(nome, cpf);
        String retorno = hospedeController.cadastrarHospede(novoHospede);
        hospedeView.mostrarMensagem(retorno);
    }

    private void listarHospede() {

        hospedeView.mostrarMensagem("** Hospede Cadastrados **");
        List<Hospede> hospede = hospedeController.listarHospede();
        hospedeView.mostrarListaHospedes(hospede);
        hospedeView.mostrarMensagem("******************************");

    }

    private void atualizarHospede() {

        System.out.println("Atualizar Hospede");

        hospedeView.mostrarMensagem("Digite o ID do Hospede a ser atualizado:");
        int id = scanner.nextInt();

        Hospede hospede = hospedeController.buscarHospede(id);

        if (hospede != null) {

            scanner.nextLine(); // Limpar o buffer do scanner

            hospedeView.mostrarMensagem("Digite o novo nome do Hospede:");
            String nome = scanner.nextLine();
            hospede.setNome(nome);

            hospedeView.mostrarMensagem("Digite o cpf atualizado do Hospede:");
            String cpf = scanner.nextLine();
            hospede.setCpf(cpf);

            String retorno = hospedeController.atualizarHospede(hospede);
            hospedeView.mostrarMensagem(retorno);
        } else {
            hospedeView.mostrarMensagem("Hospede não encontrado!");
        }
    }

    private void excluirHospede() {

        System.out.println("Excluir Hospede");

        hospedeView.mostrarMensagem("Digite o ID do Hospede a ser excluído:");
        int id = scanner.nextInt();
        String retorno = hospedeController.excluirHospede(id);
        hospedeView.mostrarMensagem(retorno);
    }

    private void buscarHospede() {

        System.out.println("Busca de Hospede");

        hospedeView.mostrarMensagem("Digite o ID do Hospede a ser buscado:");
        int id = scanner.nextInt();
        Hospede hospede = hospedeController.buscarHospede(id);

        if (hospede != null) {
            hospedeView.mostrarDetalhesHospede(hospede);
        } else {
            hospedeView.mostrarMensagem("Hospede não encontrado!");
        }
    }

    // FUNÇÕES PARA OBTER OS DADOS VIA TERMINAL - QUARTO
    private void cadastrarQuarto() {

        System.out.println("Cadastro de Quarto");

        scanner.nextLine(); // Limpar o buffer do scanner

        quartoView.mostrarMensagem("Digite o numero do Quarto:");
        int numero = scanner.nextInt();

        Boolean disponivel = true;

        quartoView.mostrarMensagem("Digite a capacidade máxima de pessoas:");
        int maxPessoas = scanner.nextInt();

        quartoView.mostrarMensagem("Digite o andar do quarto:");
        int andar = scanner.nextInt();

        Quarto novoQuarto = new Quarto(numero, disponivel, maxPessoas, andar);
        String retorno = quartoController.cadastrarQuarto(novoQuarto);
        quartoView.mostrarMensagem(retorno);
    }

    private void listarQuarto() {

        quartoView.mostrarMensagem("** Quartos**");
        List<Quarto> quarto = quartoController.listarQuarto();
        quartoView.mostrarListaQuarto(quarto);
        quartoView.mostrarMensagem("******************************");

    }

    private void atualizarQuarto() {

        System.out.println("Atualizar Quarto");

        quartoView.mostrarMensagem("Digite o ID do Hospede a ser atualizado:");
        int id = scanner.nextInt();

        Quarto quarto = quartoController.buscarQuarto(id);

        if (quarto != null) {

            scanner.nextLine(); // Limpar o buffer do scanner

            quartoView.mostrarMensagem("Digite o novo numero do quarto:");
            int numero = scanner.nextInt();
            quarto.setNumero(numero);

            quartoView.mostrarMensagem("Digite a nova capacidade máxima do quarto:");
            int maxPessoas = scanner.nextInt();
            quarto.setmaxPessoas(maxPessoas);

            quartoView.mostrarMensagem("Digite o novo andar do quarto:");
            int andar = scanner.nextInt();
            quarto.setAndar(andar);

            String retorno = quartoController.atualizarQuarto(quarto);
            quartoView.mostrarMensagem(retorno);
        } else {
            quartoView.mostrarMensagem("Quarto não encontrado!");
        }
    }

    private void excluirQuarto() {

        System.out.println("Excluir Quarto");

        quartoView.mostrarMensagem("Digite o ID do Quarto a ser excluído:");
        int id = scanner.nextInt();
        String retorno = quartoController.excluirQuarto(id);
        quartoView.mostrarMensagem(retorno);
    }

    private void buscarQuarto() {

        System.out.println("Busca de Quarto");

        quartoView.mostrarMensagem("Digite o ID do Quarto a ser buscado:");
        int id = scanner.nextInt();
        Quarto quarto = quartoController.buscarQuarto(id);

        if (quarto != null) {
            quartoView.mostrarDetalhesQuarto(quarto);
        } else {
            quartoView.mostrarMensagem("Quarto não encontrado!");
        }
    }

    // FUNÇÕES PARA OBTER OS DADOS VIA TERMINAL - RESERVA

    private void incluirQuartoReserva() {

        System.out.println("Reservar Quarto");

        quartoView.mostrarMensagem("Digite o ID do Quarto a ser reservado:");
        int id = scanner.nextInt();

        Quarto quarto = quartoController.buscarQuarto(id);

        if (quarto != null) {

            scanner.nextLine(); // Limpar o buffer do scanner
            boolean disponivel = false;
            quarto.setDisponivel(disponivel);
            String retorno = quartoController.atualizarQuarto(quarto);
            quartoView.mostrarMensagem(retorno);
        } else {
            quartoView.mostrarMensagem("Quarto não encontrado!");
        }
    }

    private void cadastrarReserva(){
        listarQuarto();

        scanner.nextLine(); // Limpar o buffer do scanner

        reservaView.mostrarMensagem("Digite o nome do responsável pela reserva:");
        String nome = scanner.nextLine();

        reservaView.mostrarMensagem("Digite a data de Check-in:");
        String checkinDate = scanner.nextLine();

        reservaView.mostrarMensagem("Digite a data de Check-out:");
        String checkoutDate = scanner.nextLine();

        reservaView.mostrarMensagem("Digite a quantidade de pessoas:");
        int qtdPessoas = scanner.nextInt();

        Reserva novoReserva = new Reserva(nome, checkinDate, checkoutDate,qtdPessoas );
        String retorno = reservaController.cadastrarReserva(novoReserva);
        reservaView.mostrarMensagem(retorno);

        incluirQuartoReserva();
    }

    private void atualizarReserva(){

        System.out.println("Atualizar Reserva");

        reservaView.mostrarMensagem("Digite o ID da reserva a ser alterada:");
        int id = scanner.nextInt();

        Reserva reserva = reservaController.buscarReserva(id);

        if (reserva != null) {

            scanner.nextLine(); // Limpar o buffer do scanner
            
            reservaView.mostrarMensagem("Digite o novo Responsável:");
            String responsavel = scanner.nextLine();

            reservaView.mostrarMensagem("Digite a nova data de Check-In:");
            int getCheckinDate = scanner.nextInt();

            reservaView.mostrarMensagem("Digite a nova data de Check-Out:");
            int getCheckoutDate = scanner.nextInt();

            reservaView.mostrarMensagem("Digite a nova quantidade de pessoas:");
            int qtdPessoas = scanner.nextInt();

            String retorno = reservaController.atualizarReserva(reserva);
            reservaView.mostrarMensagem(retorno);
        } else {
            reservaView.mostrarMensagem("Reserva não encontradao!");
        }

    }

    private void excluirReserva(){

        System.out.println("Excluir Reserva");

        reservaView.mostrarMensagem("Digite o ID da Reserva a ser excluída:");
        int id = scanner.nextInt();
        String retorno = reservaController.excluirReserva(id);
        quartoView.mostrarMensagem(retorno);

    };

    private void ListarQuartoDisponivel() {

        reservaView.mostrarMensagem("** Quartos**");
        List<Reserva> reserva = reservaController.listarReserva();

        List<Quarto> quarto = quartoController.listarQuarto();
        quartoView.mostrarListaDisponivel(quarto);
        reservaView.mostrarMensagem("******************************");

    }

    private void listarReserva() {

        reservaView.mostrarMensagem("** Reservas **");
        List<Reserva> reserva = reservaController.listarReserva();
        reservaView.mostrarListaReserva(reserva);
        reservaView.mostrarMensagem("******************************");

    }

}
