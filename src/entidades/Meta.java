package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import entidades.MetaSolo;
import entidades.MetaSolo.Tipo_aprendizado;
import entidades.MetaOrquestra;
import entidades.MetaOrquestra.Tipo_orquestra;
import entidades.MetaOrquestra.Nível;
import persistência.BD;

public class Meta {

    public enum Dia_aula{Segunda, Terça, Quarta, Quinta, Sexta, Sábado}
    
    protected int sequencial;
    protected String nome;
    protected Dia_aula dia_aula;
    protected boolean aula_especial;
    
    public Meta(int sequencial, String nome, Dia_aula dia_aula, boolean aula_especial){  
        this.sequencial = sequencial;
        this.nome = nome;
        this.dia_aula = dia_aula;
        this.aula_especial = aula_especial;
    }
    
    public Meta(int sequencial, String nome){
        this.sequencial = sequencial;
        this.nome = nome;
    }
    
    public Meta getVisão() {
        return new Meta(sequencial, nome, dia_aula, aula_especial);
    }

    public int getSequencial() {
        return sequencial;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Dia_aula getDia_aula(){
        return dia_aula;
    }
    
    public boolean isConsideradoAula_especial () {
        return aula_especial;
    }
    
    public String toString() {
        return sequencial + " [" + nome + "]";
    }
    
    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
   
    public void  setNome(String nome) {
        this.nome = nome;
    }
    
    public String toStringFull() {
        String str = nome + " - Dia da Aula: " + dia_aula;
        return str;
    }
    public static int últimoSequencial() {
        String sql = "SELECT MAX(Sequencial) FROM Metas";
        ResultSet lista_resultados = null;
        int sequencial = 0;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();

            while (lista_resultados.next()) {
                sequencial = lista_resultados.getInt(1);
            }

            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        return sequencial;
    }
    
    public static boolean existeMetaMesmosAtributos(Meta meta) {
        String sql = "SELECT COUNT(Sequencial) FROM Metas"
                   + " WHERE Nome = ? AND Dia_aula = ? AND Aula_especial = ?";
        ResultSet lista_resultados = null;
        int n_metas_mesmos_atributos = 0;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, meta.getNome());
            comando.setInt(2, meta.getDia_aula().ordinal());
            comando.setBoolean(3, meta.isConsideradoAula_especial());
            lista_resultados = comando.executeQuery();

            while (lista_resultados.next()) {
                n_metas_mesmos_atributos = lista_resultados.getInt(1);
            }

            lista_resultados.close();
            comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
            }

            if (n_metas_mesmos_atributos > 0) {
                return true;
            } else {
                return false;
        }
    }
    
    public static Meta buscarMeta(int sequencial) {
        String sql = null;
        ResultSet lista_resultados = null;
        sql = "SELECT Nome, Dia_aula, Aula_especial FROM Metas WHERE Sequencial = ?";
        String nome = null;
        Dia_aula dia_aula = null;
        boolean aula_especial = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                nome = lista_resultados.getString("Nome");
                dia_aula = Dia_aula.values()[lista_resultados.getInt("Dia_aula")];
                aula_especial = lista_resultados.getBoolean("Aula_especial");
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace (); }
        if (nome == null) return null;
        sql = "SELECT Tipo_aprendizado, Tempo"
            + " FROM MetasSolo WHERE MetaId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new MetaSolo (sequencial, nome, dia_aula, aula_especial,
                    Tipo_aprendizado.values()[lista_resultados.getInt("Tipo_aprendizado")],
                    lista_resultados.getInt("Tempo"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace (); }
        sql = "SELECT Tipo_orquestra, Nível FROM MetasOrquestra"
            + " WHERE MetaId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return (new MetaOrquestra (sequencial, nome, dia_aula, aula_especial,
                Tipo_orquestra.values()[lista_resultados.getInt("Tipo_orquestra")],
                Nível.values()[lista_resultados.getInt("Nível")]));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace (); }    
        return null;
       
    }
    
    public static String inserirMeta(Meta meta) {
        String sql = "INSERT INTO Metas (Nome, Dia_aula, Aula_especial) VALUES (?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, meta.getNome());
            comando.setInt(2, meta.getDia_aula().ordinal());
            comando.setBoolean(3, meta.isConsideradoAula_especial());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção da Meta no BD";
        }
        
        int sequencial = últimoSequencial();
        if(meta instanceof MetaSolo) {
            MetaSolo meta_solo = (MetaSolo) meta;
            sql = "INSERT INTO MetasSolo"
                + " (Tipo_aprendizado, Tempo, MetaId) VALUES (?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, meta_solo.getTipo_aprendizado().ordinal());
                comando.setInt(2, meta_solo.getTempo());
                comando.setInt(3, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Inserção da MetaSolo no BD";
            }
        } else if(meta instanceof MetaOrquestra) {
            MetaOrquestra meta_orquestra = (MetaOrquestra) meta;
            sql = "INSERT INTO MetasOrquestra"
                + " (Tipo_orquestra, Nível,"
                + " MetaId) VALUES (?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, meta_orquestra.getTipo_orquestra().ordinal());            
                comando.setInt(2, meta_orquestra.getNível().ordinal());
                comando.setInt(3, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Inserção da MetaOrquestra no BD";
            }
        }
        return null;
    }
    
    public static String alterarMeta(Meta meta) {
        String sql = "UPDATE Metas SET Nome = ?, Dia_aula = ?, Aula_especial = ? WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, meta.getNome());
            comando.setInt(2, meta.getDia_aula().ordinal());
            comando.setBoolean(3, meta.isConsideradoAula_especial());
            comando.setInt(4, meta.getSequencial());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Alteração do Meta no BD";
        }
        if(meta instanceof MetaSolo){
            MetaSolo meta_solo = (MetaSolo) meta;
            sql = "UPDATE MetasSolo" + " SET Tipo_aprendizado = ?,Tempo = ? WHERE MetaId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, meta_solo.getTipo_aprendizado().ordinal());
                comando.setInt(2, meta_solo.getTempo());
                comando.setInt(3, meta_solo.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Inserção do MetaSolo no BD";
            }
        } else if(meta instanceof MetaOrquestra) {
            MetaOrquestra meta_orquestra = (MetaOrquestra) meta;
            sql = "UPDATE MetasOrquestra SET Tipo_orquestra = ?, Nível = ? WHERE MetaId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, meta_orquestra.getTipo_orquestra().ordinal());
                comando.setInt(2, meta_orquestra.getNível().ordinal());            
                comando.setInt(3, meta_orquestra.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Alteração do MetaOrquestra no BD";
            }
        }
        return null;
    }
    
    public static String removerMeta(Meta meta) {        
        int sequencial = meta.getSequencial();
        Objetivo.removerObjetivo(sequencial);
        if (meta instanceof MetaSolo) {
            String sql = "DELETE FROM MetasSolo WHERE MetaId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Remoção da MetaSolo no BD";
            }
        } else if (meta instanceof MetaOrquestra) {
            String sql = "DELETE FROM MetasOrquestra WHERE MetaId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Remoção da MetaOrquestra no BD";
            }
        }
        String sql = "DELETE FROM Metas WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Remoção da Meta no BD";
        }
        return null;
    }
    
    public static Meta[] getVisões() {
        String sql = "SELECT Sequencial FROM Metas";
        ResultSet lista_resultados = null;
        ArrayList<Meta> visões = new ArrayList<>();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();

            while (lista_resultados.next()) {
                int sequencial = lista_resultados.getInt("Sequencial");
                Meta meta = buscarMeta(sequencial);

                if (meta != null) {
                    visões.add(meta.getVisão());
                }
            }

            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        return visões.toArray(new Meta[visões.size()]);
    }

}
