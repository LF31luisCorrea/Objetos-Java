package controles;

import entidades.Orçamento;
import interfaces.JanelaCadastroOrçamentos;

public class ControladorCadastroOrçamentos {
    
    public ControladorCadastroOrçamentos() {
        new JanelaCadastroOrçamentos(this).setVisible(true);
    }
    
    public String inserirOrçamento (Orçamento orçamento) {
        if (!Orçamento.existeOrçamento(orçamento.getAluno().getNome(), orçamento.getMeta().getSequencial())) {
            return Orçamento.inserirOrçamento(orçamento);
        } else return "Orçamento já cadastrado";
    }

    public String alterarOrçamento(Orçamento orçamento_informado) {
        Orçamento orçamento_cadastrados = Orçamento.buscarOrçamento(orçamento_informado.getSequencial());
        if ((orçamento_informado.getAluno().getNome().equals(orçamento_cadastrados.getAluno().getNome()))
            && (orçamento_informado.getMeta().getSequencial() == orçamento_cadastrados.getMeta().getSequencial())) {
            return Orçamento.alterarOrçamento(orçamento_informado);
        } else return "Alteração não permitida : chave do aluno e/ou do meta foram alteradas";
    }
    
     public String removerOrçamento(int sequencial) {
        if (Orçamento.existeOrçamento(sequencial)) return Orçamento.removerOrçamento (sequencial);
        else return "Sequencial não corresponde a nenhuma reserva cadastrada";
    }
    
}
