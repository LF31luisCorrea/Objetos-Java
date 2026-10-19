package entidades;
import entidades.Meta.Dia_aula;

public class MetaSolo extends Meta{

    public enum Tipo_aprendizado { aprendizado_próprio, profissional, didático }
    private int tempo;
    private Tipo_aprendizado tipo_aprendizado;


    public MetaSolo(int sequencial, String nome, Dia_aula dia_aula, boolean aula_especial,Tipo_aprendizado tipo_aprendizado, int tempo) {
        super(sequencial, nome, dia_aula, aula_especial);
        this.tipo_aprendizado = tipo_aprendizado;
        this.tempo = tempo;
    }
    

    public MetaSolo getVisão() {
        return new MetaSolo(sequencial, nome, dia_aula, aula_especial, tipo_aprendizado, tempo);
    }
    
    
    public Tipo_aprendizado getTipo_aprendizado() {
        return tipo_aprendizado;
    }
    
    
     public int getTempo() {
        return tempo;
    }
    
   
     public void  setTipo_aprendizado(Tipo_aprendizado tipo_aprendizado) {
         this.tipo_aprendizado = tipo_aprendizado;
    }

     public void  setTempo(int tempo) {
         this.tempo = tempo;
    }
     
     public String toString() {
        String str = "[" + sequencial + "] " +  nome + " --- MetaSolo - " + " ( " + tipo_aprendizado + " - Tempo: " + tempo + ") " + dia_aula;
        return str;
    }
     
     public String toStringFull() {
        return "Meta: " + super.toStringFull() + " \nMeta Solo: Tipo de aprendizado: " + tipo_aprendizado;
    }
}

