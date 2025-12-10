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
    private static void menuPrincipal(Lista<Paciente> listaPacientes,
                                      Lista<Profissional> listaProfissionais,
                                      Lista<Procedimento> listaProcedimentos,
                                      Lista<Servico> listaServicos) {
        Scanner entradaSistema = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                --- MENU PRINCIPAL ---
                1 - Pacientes
                2 - Profissionais
                3 - Procedimentos
                4 - Serviços
                5 - Info do Autor (@InfoAutor)
                0 - Sair
                """);

            opcao = entradaSistema.nextInt();
            entradaSistema.nextLine();

            switch (opcao) {
                case 1 -> menuPacientes(listaPacientes);
                case 2 -> menuProfissionais(listaProfissionais);
                case 3 -> menuProcedimentos(listaProcedimentos);
                case 4 -> menuServicos(listaServicos, listaPacientes,
                        listaProfissionais, listaProcedimentos);
                case 5 -> menuInfoAutor();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida! Digite um dos números abaixo.");
            }
        }
    }

    private static void menuPacientes(Lista<Paciente> listaPacientes) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                --- MENU PACIENTES ---
                1 - Listar
                2 - Buscar por CPF
                3 - Adicionar
                4 - Remover por CPF
                0 - Voltar
                """);

            opcao = sc.nextInt();
            sc.nextLine(); // consumir \n

            switch (opcao) {
                case 1 -> {
                    var pacientesOrdenados = listaPacientes
                            .listarTodos(Comparator.comparing(Paciente::getNome));
                    System.out.println(pacientesOrdenados);
                }
                case 2 -> {
                    System.out.print("CPF do paciente: ");
                    String cpf = sc.nextLine();
                    try {
                        Paciente p = listaPacientes.buscarPorId(cpf);
                        System.out.println("Encontrado: " + p);
                    } catch (NegocioException e) {
                        System.out.println("Erro ao buscar paciente: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine(); // consumir \n
                    System.out.print("Convênio: ");
                    String convenio = sc.nextLine();

                    Paciente novo = new Paciente(cpf, nome, idade, convenio);
                    try {
                        boolean ok = listaPacientes.adicionar(novo);
                        if (ok) {
                            System.out.println("Paciente cadastrado com sucesso!");
                        } else {
                            System.out.println("Paciente não pôde ser cadastrado (ID duplicado?).");
                        }
                    } catch (NegocioException e) {
                        System.out.println("Erro ao cadastrar paciente: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("CPF do paciente a remover: ");
                    String cpfRemover = sc.nextLine();
                    try {
                        listaPacientes.removerPorId(cpfRemover);
                        System.out.println("Paciente removido com sucesso.");
                    } catch (NegocioException e) {
                        System.out.println("Erro ao remover paciente: " + e.getMessage());
                    }
                }
                case 0 -> System.out.println("Voltando para o menu principal...");
                default -> System.out.println("Digite uma das opções listadas.");
            }
        }
    }


    private static void menuProfissionais(Lista<Profissional> listaProfissionais) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                --- MENU PROFISSIONAIS ---
                1 - Listar
                2 - Buscar por matrícula
                3 - Adicionar
                4 - Remover por matrícula
                0 - Voltar
                """);

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    var profissionaisOrdenados = listaProfissionais
                            .listarTodos(Comparator.comparing(Profissional::getNome));
                    System.out.println(profissionaisOrdenados);
                }
                case 2 -> {
                    System.out.print("Matrícula do profissional: ");
                    String matricula = sc.nextLine();
                    try {
                        Profissional p = listaProfissionais.buscarPorId(matricula);
                        System.out.println("Encontrado: " + p);
                    } catch (NegocioException e) {
                        System.out.println("Erro ao buscar profissional: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Formação: ");
                    String formacao = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    Profissional novo = new Profissional(cpf, nome, idade, formacao, matricula);
                    try {
                        boolean ok = listaProfissionais.adicionar(novo);
                        if (ok) {
                            System.out.println("Profissional cadastrado com sucesso!");
                        } else {
                            System.out.println("Profissional não pôde ser cadastrado (ID duplicado?).");
                        }
                    } catch (NegocioException e) {
                        System.out.println("Erro ao cadastrar profissional: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Matrícula do profissional a remover: ");
                    String matriculaRemover = sc.nextLine();
                    try {
                        listaProfissionais.removerPorId(matriculaRemover);
                        System.out.println("Profissional removido com sucesso.");
                    } catch (NegocioException e) {
                        System.out.println("Erro ao remover profissional: " + e.getMessage());
                    }
                }
                case 0 -> System.out.println("Voltando para o menu principal...");
                default -> System.out.println("Digite uma das opções listadas.");
            }
        }
    }


    private static void menuProcedimentos(Lista<Procedimento> listaProcedimentos) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                --- MENU PROCEDIMENTOS ---
                1 - Listar
                2 - Buscar por código
                3 - Adicionar
                4 - Remover por código
                0 - Voltar
                """);

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    var procedimentosOrdenados = listaProcedimentos
                            .listarTodos(Comparator.comparing(Procedimento::getValor));
                    System.out.println(procedimentosOrdenados);
                }
                case 2 -> {
                    System.out.print("Código do procedimento: ");
                    String codigo = sc.nextLine();
                    try {
                        Procedimento p = listaProcedimentos.buscarPorId(codigo);
                        System.out.println("Encontrado: " + p);
                    } catch (NegocioException e) {
                        System.out.println("Erro ao buscar procedimento: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Nome do procedimento: ");
                    String nome = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    Procedimento novo = new Procedimento(nome, valor);
                    try {
                        boolean ok = listaProcedimentos.adicionar(novo);
                        if (ok) {
                            System.out.println("Procedimento cadastrado com sucesso!");
                        } else {
                            System.out.println("Procedimento não pôde ser cadastrado (ID duplicado?).");
                        }
                    } catch (NegocioException e) {
                        System.out.println("Erro ao cadastrar procedimento: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Código do procedimento a remover: ");
                    String codigoRemover = sc.nextLine();
                    try {
                        listaProcedimentos.removerPorId(codigoRemover);
                        System.out.println("Procedimento removido com sucesso.");
                    } catch (NegocioException e) {
                        System.out.println("Erro ao remover procedimento: " + e.getMessage());
                    }
                }
                case 0 -> System.out.println("Voltando para o menu principal...");
                default -> System.out.println("Digite uma das opções listadas.");
            }
        }
    }


    private static void menuServicos(Lista<Servico> listaServicos,
                                     Lista<Paciente> listaPacientes,
                                     Lista<Profissional> listaProfissionais,
                                     Lista<Procedimento> listaProcedimentos) {
        Scanner entradaServico = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                --- MENU SERVIÇOS ---
                1 - Listar
                2 - Buscar
                3 - Adicionar
                4 - Remover
                0 - Voltar
                """);

            opcao = entradaServico.nextInt();
            entradaServico.nextLine(); // consumir \n

            switch (opcao) {
                case 1 -> {
                    var servicosOrdenados = listaServicos
                            .listarTodos(Comparator.comparing(Servico::getValorTotal));
                    System.out.println(servicosOrdenados);
                }
                case 2 -> {
                    System.out.print("Digite o código do serviço (SERV..): ");
                    String codigo = entradaServico.nextLine();
                    try {
                        Servico s = listaServicos.buscarPorId(codigo);
                        System.out.println("Serviço encontrado: " + s);
                    } catch (NegocioException e) {
                        System.out.println("Erro ao buscar serviço: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        // escolher paciente
                        System.out.print("CPF do paciente: ");
                        String cpfPaciente = entradaServico.nextLine();
                        Paciente paciente = listaPacientes.buscarPorId(cpfPaciente);

                        // escolher profissional
                        System.out.print("Matrícula do profissional: ");
                        String matProf = entradaServico.nextLine();
                        Profissional profissional = listaProfissionais.buscarPorId(matProf);

                        // escolher procedimento
                        System.out.print("Código do procedimento (PROC..): ");
                        String codProc = entradaServico.nextLine();
                        Procedimento procedimento = listaProcedimentos.buscarPorId(codProc);

                        // criar serviço
                        Servico novoServico = new Servico(paciente, profissional, procedimento);

                        boolean ok = listaServicos.adicionar(novoServico);
                        if (ok) {
                            System.out.println("Serviço cadastrado com sucesso! Código: " + novoServico.getId());
                        } else {
                            System.out.println("Serviço não pôde ser cadastrado (ID duplicado?).");
                        }

                    } catch (NegocioException e) {
                        System.out.println("Erro ao cadastrar serviço: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Dados inválidos ao criar o serviço: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Digite o código do serviço que deseja remover: ");
                    String codigoRemover = entradaServico.nextLine();
                    try {
                        listaServicos.removerPorId(codigoRemover);
                        System.out.println("Serviço removido com sucesso.");
                    } catch (NegocioException e) {
                        System.out.println("Erro ao remover serviço: " + e.getMessage());
                    }
                }
                case 0 -> System.out.println("Voltando para o menu principal...");
                default -> System.out.println("Digite uma das opções listadas.");
            }
        }
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

    private static void menuInfoAutor() {
        System.out.println("--- Informações de Autor (@InfoAutor) ---");
        imprimirInfoAutor(Paciente.class);
        imprimirInfoAutor(Profissional.class);
        imprimirInfoAutor(Procedimento.class);
        imprimirInfoAutor(Servico.class);
        imprimirInfoAutor(Lista.class);
    }

}
