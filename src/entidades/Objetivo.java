package entidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import persistência.BD;

public class Objetivo {
    private int sequencial;
    private Meta meta;
    private Estudo estudo;
    
    public Objetivo(int sequencial, Meta meta, Estudo estudo) {
        this.sequencial = sequencial;
        this.meta = meta;
        this.estudo = estudo;
    }
    
     public Objetivo(int sequencial) {
       this.sequencial = sequencial;
    }
    
    public Objetivo getVisão() {
        return new Objetivo(sequencial, meta, estudo);
    }

    public int getSequencial() {
        return sequencial;
    }

    public Meta getMeta() {
        return meta;
    }
    
    public Estudo getEstudo() {
        return estudo;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
   
    public void  setMeta(Meta meta) {
        this.meta = meta;
    }
   
    public void  setEstudo(Estudo estudo) {
        this.estudo = estudo;
    } 
    
    public String toString() {
        return estudo.getNome() + "["+ estudo.getAutor()+"]";
    }
     
     public static boolean existeObjetivo(int chave_meta, String chave_estudo) {
        String sql = "SELECT Sequencial FROM Objetivos WHERE MetaId = ? AND EstudoId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, chave_meta);
            comando.setString(2, chave_estudo);

            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }

            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        return existe;
    }
     
     public static int últimoSequencial() {
        String sql = "SELECT MAX(Sequencial) FROM Objetivos";
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
     
    public static String inserirObjetivo(Objetivo objetivo) {
        String sql = "INSERT INTO Objetivos (Sequencial, MetaId, EstudoId) VALUES (?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, objetivo.getSequencial());
            comando.setInt(2, objetivo.meta.getSequencial());
            comando.setString(3, objetivo.estudo.getNome());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção do Objetivo no BD";
        }
    }
    
    public static Objetivo[] buscarObjetivos(int sequencial_meta) {
        String sql = "SELECT * FROM Objetivos WHERE MetaId = ?";
        ArrayList<Objetivo> composições = new ArrayList<>();
        try (PreparedStatement comando = BD.conexão.prepareStatement(sql)) {
            comando.setInt(1, sequencial_meta);
            try (ResultSet lista_resultados = comando.executeQuery()) {
                while (lista_resultados.next()) {
                    Objetivo aplicação = new Objetivo(
                            lista_resultados.getInt("Sequencial"),
                            Meta.buscarMeta(lista_resultados.getInt("MetaId")),
                            Estudo.buscarEstudo(lista_resultados.getString("EstudoId"))
                    );
                    composições.add(aplicação);
                }
            }
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return new Objetivo[0];
        }
        return composições.toArray(new Objetivo[0]);
    }
    
    public static boolean existeObjetivo(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) FROM Objetivos WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();

            while (lista_resultados.next()) 
                existe = true;

            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        return existe;
    }
 
    public static String removerObjetivo(int sequencial) {
        String sql = "DELETE FROM Objetivos WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoção do Objetivo no BD";
        }
    }
    
    public static Objetivo[] getVisões() {
        String sql = "SELECT Sequencial, MetaId, EstudoId from Objetivos";
        ResultSet lista_resultados = null;
        ArrayList<Objetivo> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new Objetivo(lista_resultados.getInt("Sequencial"),
                        Meta.buscarMeta(lista_resultados.getInt("MetaId")).getVisão(),
                        Estudo.buscarEstudo(lista_resultados.getString("EstudoId")).getVisão()));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Objetivo[visões.size()]);
    }
    
     public static Estudo[] buscarEstudosMeta (int sequencial_meta) {
        String sql = "SELECT Sequencial, EstudoId FROM Objetivos WHERE MetaId = ?";
        ResultSet lista_resultados = null;
        ArrayList<Estudo> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial_meta);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(Estudo.buscarEstudo(lista_resultados.getString("EstudoId")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões.toArray(new Estudo[visões.size()]);
    }

}
