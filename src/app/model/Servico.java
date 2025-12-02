package app.model;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import app.excecoes.NegocioException;

public class Servico {
    private Paciente paciente;
    private Profissional profissional;
    private List<Procedimento> procedimentos;
    private LocalDateTime dataHoraAtendimento;


    public Servico(Paciente paciente, Profissional profissional, Procedimento procedimentoInicial) {
        if(paciente == null) {
            throw new NegocioException("O paciente é obrigatório");
        } 
        if(profissional == null) {
            throw new NegocioException("O profissional é obrigatório");
        }
        this.paciente = paciente;
        this.profissional = profissional;
        if(procedimentoInicial == null) {
            throw new NegocioException("O procedimento não pode ser null, deve ser informado");
        } else if(procedimentoInicial.getValor() < 0) {
            throw new NegocioException("O valor do procedimento não pode ser negativo");
        } 

        procedimentos = new ArrayList<>();
        procedimentos.add(procedimentoInicial); 
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void addProcedimento(Procedimento novoProcedimento) {
        if(novoProcedimento == null) {
            throw new NegocioException("O novo procedimento não pode null");
        } else if(novoProcedimento.getValor() < 0) {
            throw new NegocioException("O valor do novo procedimento não pode ser negativo");
        } 

        procedimentos.add(novoProcedimento);
    }

    public double getValorTotal() {
        // Operação de agregação com stream
        return procedimentos.stream().mapToDouble(procedimento -> procedimento.getValor()).sum();
    }

    public int getQuantidade() {
        return procedimentos.size();
    }

    public void setDataHoraAtendimento(LocalDateTime novaData) {
        LocalDateTime agora = LocalDateTime.now();
        if(novaData.isBefore(agora)) {
            throw new NegocioException("A data do serviço não pode ser anterior a data atual");
        } 
        
        dataHoraAtendimento = novaData;
    }

    public LocalDateTime getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }
}
