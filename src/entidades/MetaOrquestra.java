package entidades;
import entidades.Meta.Dia_aula;

public class MetaOrquestra extends Meta{
    public enum Tipo_orquestra {Cordas, Metais, Palhetas, Misto}
    public enum Nível { A, B, C }


    private Tipo_orquestra tipo_orquestra;
    private Nível nível;

    public MetaOrquestra(int sequencial, String nome, Dia_aula dia_aula, boolean aula_especial,Tipo_orquestra tipo_orquestra, Nível nível) {
        super(sequencial, nome, dia_aula, aula_especial);
        this.tipo_orquestra = tipo_orquestra;
        this.nível = nível;
    }
     

    public MetaOrquestra getVisão() {
        return new MetaOrquestra (sequencial, nome, dia_aula, aula_especial, tipo_orquestra, nível);
    }
    
    
    public Tipo_orquestra getTipo_orquestra() {
        return tipo_orquestra;
    }
    
    
     public Nível getNível() {
        return nível;
    }
    
   
     public void  setTipo_orquestra(Tipo_orquestra tipo_orquestra) {
         this.tipo_orquestra = tipo_orquestra;
    }

     public void  setNível(Nível nível) {
         this.nível = nível;
    }
     
    public String toString() {
        String str = "[" + sequencial + "] " + nome + " --- MetaOrquestra - " + " (" + tipo_orquestra + " Nível:" + nível + ") " + dia_aula;
        return str;
    }
    
    public String toStringFull() {
        String str = super.toStringFull() + " - Meta Orquestra: Nível: " + nível;
        return str;
    }
    
}
