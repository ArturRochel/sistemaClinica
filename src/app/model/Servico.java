package app.model;
import java.util.ArrayList;
import java.util.List;

public class Servico {
    Paciente paciente;
    Profissional profissional;
    List<Procedimento> procedimentos;

    public Servico(Paciente novoPaciente, Profissional novoProfissional, Procedimento novoProcedimento) {
        paciente = novoPaciente;
        profissional = novoProfissional;
        procedimentos = new ArrayList<>();
        procedimentos.add(novoProcedimento);
    }

    public double getValorTotal() {
        double valorInterno = 0;
        //procedimentos.forEach(elemento -> valorInterno += elemento.getValor());
        return valorInterno;
    }
}
