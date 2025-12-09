package app.main;
import app.excecoes.NegocioException;
import app.model.Lista;
import app.model.Paciente;
import app.model.Procedimento;
import app.model.Profissional;
import app.model.Servico;

public class Main {
    public static void main(String[] args) {
        // Listas da clínica
        Lista<Paciente> listaDePacientes = new Lista<>("Lista de pacientes cadastrados");
        Lista<Profissional> listaDeProfissionais = new Lista<>("Lista de médicos e profissionais da clínica");
        Lista<Procedimento> listaDeProcedimentos = new Lista<>("Lista de procedimentos da clínica");
        Lista<Servico> listaDeServicos = new Lista<>("Lista de serviços da clínica");

        // Criação de pacientes
        Paciente artur = new Paciente("707.857.274-26", "Artur Rochel", 24, "Hapvida");
        Paciente gil = new Paciente("123.456.789-21", "José Gildenilson", 21, "Amil");
        Paciente bia = new Paciente("707.234.786-18", "Ana Beatriz", 21, "Hapvida");

        // Criação dos médicos
        Profissional ricardo = new Profissional("112.564.345-34", "Ricardo Monteiro", 50, "Ortopedista", "MAT202502");
        Profissional ana = new Profissional("457.234.098-34", "Ana Paula", 76, "Enfermage", "MAT202503");
        Profissional beatriz = new Profissional("707.874.323-34", "Ana Beatriz", 21, "Terapeuta Ocupacional", "MAT202501");

        // Criação dos procedimentos
        Procedimento consulta = new Procedimento("Consulta clínica geral", 150.00);
        Procedimento exameDeSangue = new Procedimento("Hemográma total", 45.00);
        Procedimento raioX = new Procedimento("Raio-X", 250.00);
        Procedimento terapia = new Procedimento("Terapia Ocupacional", 750.00);

        // Criação dos serviços
        try {
            Servico serv01 = new Servico(gil, ricardo, raioX);
        } catch (NegocioException e) {
            System.out.println("Erro ao tentar criar o serviço 01: " + e.getMessage());
        }

        try {
            Servico serv02 = new Servico(artur, beatriz, terapia);
        } catch (NegocioException e) {
            System.out.println("Erro ao tentar criar o serviço 02: " + e.getMessage());
        }

        try {
            Servico serv03 = new Servico(bia, beatriz, terapia);
        } catch (NegocioException e) {
            System.out.println("Erro ao adicionar o serviço 03: " + e.getMessage());
        }

        // Adicionar elementos as suas respectivas listas
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
    }
}
