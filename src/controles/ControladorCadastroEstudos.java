package controles;
import entidades.Estudo;
import interfaces.JanelaCadastroEstudos;

public class ControladorCadastroEstudos {

    public ControladorCadastroEstudos() {
        new JanelaCadastroEstudos(this).setVisible(true);
    }
    
    public String inserirEstudo (Estudo estudo) {
        Estudo estudo1 = Estudo.buscarEstudo(estudo.getNome());
        if (estudo1 == null) return Estudo.inserirEstudo(estudo);
        else return "Nome de estudo já cadastrado";
    }
    
    public String alterarEstudo(Estudo estudo) {
        Estudo estudo1 = Estudo.buscarEstudo(estudo.getNome());
        if (estudo1 != null) return Estudo.alterarEstudo(estudo);
        else return "Nome de estudo não cadastrado";
    }
    
     public String removerEstudo(String nome) {
        Estudo estudo1 = Estudo.buscarEstudo(nome);
        if (estudo1 != null) return Estudo.removerEstudo(nome);
        else return "Nome de estudo não cadastrado";
    }
}
