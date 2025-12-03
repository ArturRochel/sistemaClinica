package app.model;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import app.excecoes.NegocioException;
import app.interfaces.Identificavel;

public class Servico implements Identificavel {
    private Paciente paciente;
    private Profissional profissional;
    private List<Procedimento> procedimentos;
    private LocalDateTime dataHoraAtendimento;

    private static int proximoId = 1;

    private final String codigoServico;

    public Servico(Paciente paciente, Profissional profissional, Procedimento procedimentoInicial) {
        if(paciente == null || paciente.getNome().isBlank()) {
            throw new NegocioException("O paciente é obrigatório");
        } 
        if(profissional == null || profissional.getNome().isBlank()) {
            throw new NegocioException("O profissional é obrigatório");
        }
        if(procedimentoInicial == null || procedimentoInicial.getNomeProcedimento().isBlank()) {
            throw new NegocioException("O procedimento não pode ser null, deve ser informado");
        } else if(procedimentoInicial.getValor() < 0) {
            throw new NegocioException("O valor do procedimento não pode ser negativo");
        } 

        this.paciente = paciente;
        this.profissional = profissional;
        this.codigoServico = "SERV" + String.format("%02d", proximoId);
        procedimentos = new ArrayList<>();
        procedimentos.add(procedimentoInicial); 

        
        proximoId++;
    }

    @Override
    public String getId() {
        return this.codigoServico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void addProcedimento(Procedimento novoProcedimento) {
        if(novoProcedimento == null) {
            throw new NegocioException("O novo procedimento não pode ser null");
        } else if(novoProcedimento.getValor() < 0) {
            throw new NegocioException("O valor do novo procedimento não pode ser negativo");
        } 

        procedimentos.add(novoProcedimento);
    }

    public double getValorTotal() {
        // Operação de agregação com stream
        return procedimentos.stream().mapToDouble(Procedimento::getValor).sum();
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
