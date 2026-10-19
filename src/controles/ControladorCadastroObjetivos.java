package controles;
import entidades.Objetivo;
import interfaces.JanelaCadastroObjetivos;
import interfaces.JanelaCadastroMetas;

public class ControladorCadastroObjetivos {
    public ControladorCadastroObjetivos(JanelaCadastroMetas janela_cadastro_metas, int sequencial_meta){
        new JanelaCadastroObjetivos(this, janela_cadastro_metas, sequencial_meta).setVisible(true);   
    }
    
    public String inserirObjetivo(Objetivo objetivo) {
        boolean existe_objetivo = Objetivo.existeObjetivo
            (objetivo.getMeta().getSequencial(), objetivo.getEstudo().getNome());
        if (!existe_objetivo) return Objetivo.inserirObjetivo (objetivo);
        else return "Sequencial de objetivo já cadastrado";
    }
  
    public String removerObjetivo(int sequencial) {
        boolean existe_objetivo = Objetivo.existeObjetivo (sequencial);
        if (existe_objetivo) return Objetivo.removerObjetivo (sequencial);
        else return "Não existe objetivo com este sequencial";
    }

}
