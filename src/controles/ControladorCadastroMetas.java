package controles;
import entidades.Meta;
import interfaces.JanelaCadastroMetas;

public class ControladorCadastroMetas {
    
    public ControladorCadastroMetas() {
        new JanelaCadastroMetas(this).setVisible(true);
    }

    public String removerMeta(int sequencial) {
        Meta meta1 = Meta.buscarMeta(sequencial);
        if (meta1 != null) {
            return Meta.removerMeta(meta1);
        } else {
            return "Sequencial do Meta não cadastrado";
        }    }

    public String alterarMeta(Meta meta) {
        Meta meta1 = Meta.buscarMeta(meta.getSequencial());
        if (meta1 != null) {
            return Meta.alterarMeta(meta);
        } else {
            return "Sequencial do Meta não cadastrado";
        }
    }

    public String inserirMeta(Meta meta) {
        if (!Meta.existeMetaMesmosAtributos(meta)) {
             return Meta.inserirMeta(meta);
         } else {
             return "Já existe uma meta com os mesmos atributos";
         }    
    }
       
    
}