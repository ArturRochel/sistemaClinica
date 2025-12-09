package app.main;

import app.excecoes.NegocioException;
import app.model.Lista;
import app.model.Paciente;
import app.model.Procedimento;
import app.model.Profissional;
import app.model.Servico;
import app.annotations.InfoAutor;

import java.util.Scanner;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        //@ Listas da clínica
        Lista<Paciente> listaDePacientes = new Lista<>("Lista de pacientes cadastrados");
        Lista<Profissional> listaDeProfissionais = new Lista<>("Lista de médicos e profissionais da clínica");
        Lista<Procedimento> listaDeProcedimentos = new Lista<>("Lista de procedimentos da clínica");
        Lista<Servico> listaDeServicos = new Lista<>("Lista de serviços da clínica");

        //@ Criação de pacientes
        Paciente artur = new Paciente("707.857.274-26", "Artur Rochel", 24, "Hapvida");
        Paciente gil = new Paciente("123.456.789-21", "José Gildenilson", 21, "Amil");
        Paciente bia = new Paciente("707.234.786-18", "Ana Beatriz", 21, "Hapvida");

        //@ Criação dos médicos
        Profissional ricardo = new Profissional("112.564.345-34", "Ricardo Monteiro", 50, "Ortopedista", "MAT202502");
        Profissional ana = new Profissional("457.234.098-34", "Ana Paula", 76, "Enfermagem", "MAT202503");
        Profissional beatriz = new Profissional("707.874.323-34", "Ana Beatriz", 21, "Terapeuta Ocupacional", "MAT202501");

        //@ Criação dos procedimentos
        Procedimento consulta = new Procedimento("Consulta clínica geral", 150.00);
        Procedimento exameDeSangue = new Procedimento("Hemográma total", 45.00);
        Procedimento raioX = new Procedimento("Raio-X", 250.00);
        Procedimento terapia = new Procedimento("Terapia Ocupacional", 750.00);

        //@ Criação dos serviços
        Servico serv01 = new Servico(gil, ricardo, raioX);
        Servico serv02 = new Servico(artur, beatriz, terapia);
        Servico serv03 = new Servico(bia, beatriz, terapia);


        //@ Adicionar elementos as suas respectivas listas
        try {
            listaDePacientes.adicionar(artur);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar Artur: " + e.getMessage());
        }

        try {
            listaDePacientes.adicionar(gil);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar Gil: " + e.getMessage());
        }

        try {
            listaDePacientes.adicionar(bia);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar Bia: " + e.getMessage());
        }

        try {
            listaDeProfissionais.adicionar(ricardo);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar Ricardo: " + e.getMessage());
        }

        try {
            listaDeProfissionais.adicionar(ana);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar Ana: " + e.getMessage());
        }

        try {
            listaDeProfissionais.adicionar(beatriz);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar Beatriz: " + e.getMessage());
        }

        try {
            listaDeProcedimentos.adicionar(exameDeSangue);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar exame de sangue: " + e.getMessage());
        }

        try {
            listaDeProcedimentos.adicionar(consulta);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar consulta: " + e.getMessage());
        }

        try {
            listaDeProcedimentos.adicionar(raioX);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar Raio-x: " + e.getMessage());
        }

        try {
            listaDeProcedimentos.adicionar(terapia);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar terapia ocupacional: " + e.getMessage());
        }

        try {
            listaDeServicos.adicionar(serv01);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar o primeiro serviço: " + e.getMessage());
        }

        try {
            listaDeServicos.adicionar(serv02);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar o segundo serviço: " + e.getMessage());
        }

        try {
            listaDeServicos.adicionar(serv03);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar o terceiro serviço: " + e.getMessage());
        }

        //@ Impressão das notations
        imprimirInfoAutor(Paciente.class);
        imprimirInfoAutor(Profissional.class);
        imprimirInfoAutor(Procedimento.class);
        imprimirInfoAutor(Servico.class);
        imprimirInfoAutor(Lista.class);

        menuPrincipal(listaDePacientes, listaDeProfissionais, listaDeProcedimentos, listaDeServicos);
    }

    //@ Métodos Menu
    private static void menuPrincipal(Lista<Paciente> listaPacientes, Lista<Profissional> listaProfissionais, Lista<Procedimento> listaProcedimentos, Lista<Servico> listaServicos) {
        Scanner entradaSistema = new Scanner(System.in);
        int opcao = -1;

        System.out.println("Bem vindo ao sistema da Clínica Pro");
        System.out.println("Escolha uma das opções a baixo para contiar: ");


        while (opcao != 0) {
            System.out.println("""
                    --- MENU PRINCIPAL ---
                    1 - Pacientes
                    2 - Profssionais
                    3 - Procedimentos
                    4 - Serviços
                    0 - Sair
                    """);

            opcao = entradaSistema.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Entrando no modulo de pacientes...");
                    // chama menuPacientes(listaPacientes);
                    break;
                case 2:
                    System.out.println("Entrando no modulo de profissionais...");
                    // chama menuProfissionais(listaProfissionais);
                    break;
                case 3:
                    System.out.println("Entrando no modulo de procedimentos...");
                    // chama menuProcedimentos(listaProcedimentos);
                    break;
                case 4:
                    System.out.println("Entrando no modulo de serviços...");
                    // chama menuServicos(listaServicos);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Digite um dos número abaixo.");
            }
        }
    }

    private static void menuPacientes(Lista<Paciente> listaPacientes) {
        Scanner entradaPaciente = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                        --- Menu Pacientes ---
                        1 - Listar
                        2 - Buscar
                        3 - Adicionar
                        4 - Remover
                        0 - Voltar
                    """);

            opcao = entradaPaciente.nextInt();
            entradaPaciente.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println(listaPacientes.listarTodos(Comparator.comparing(Paciente::getNome)));
                    break;
                case 2:
                    System.out.println("Digite o CPF do paciente: ");
                    break;
                case 3:
                    System.out.println("Adicione um paciente com NOME, CPF, ...");
                    break;
                case 4:
                    System.out.println("Digite o cpf do paciente que deseja remover");
                    break;
                case 0:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println("Digite umas das opções listadas");
            }
        }
    }

    private static void menuProfissionais() {
    }

    private static void menuProcedimentos() {
    }

    private static void menuServicos() {
    }

    //@ Annotation Autor
    private static void imprimirInfoAutor(Class<?> clazz) {
        InfoAutor info = clazz.getAnnotation(InfoAutor.class);
        if (info != null) {
            System.out.println("Classe: " + clazz.getSimpleName());
            System.out.println("Autor: " + info.nome() + " - Data: " + info.data());
            System.out.println();
        }
    }
}
