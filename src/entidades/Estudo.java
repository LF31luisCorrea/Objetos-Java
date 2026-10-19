package entidades;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.sql.*; 
import persistência.BD; 

public class Estudo {

    public enum Tipo_lição { DóMaior , SiBemol , MiBemol };
    public enum Dificuldade { Fácil , Médio , Difícil };
    private String nome, autor;
    private int duração, quantidade_aulas;
    private Dificuldade dificuldade;
    private Tipo_lição tipo_lição;
    
    public Estudo(String nome, String autor, Dificuldade dificuldade, Tipo_lição tipo_lição, int duração, int quantidade_aulas) {
        this.nome = nome;
        this.autor = autor;
        this.tipo_lição = tipo_lição;
        this.dificuldade = dificuldade;
        this.duração = duração;
        this.quantidade_aulas = quantidade_aulas;
    }
    
    public Estudo getVisão() { return new Estudo(nome, autor, dificuldade, tipo_lição, duração, quantidade_aulas);}

    public String getNome() {
        return nome;
    }
    
    public String getAutor() {
        return autor;
    }

    public Tipo_lição getTipo_lição() {
        return tipo_lição;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public int getDuração() {
        return duração;
    }
    
    public int getQuantidade_aulas() {
        return quantidade_aulas;
    }

    public Estudo getVisao() {
        return new Estudo(nome, autor, dificuldade, tipo_lição, duração, quantidade_aulas);
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Estudo(String nome, String autor) { 
        this.nome = nome; 
        this.autor = autor; 
    }  
    
    public String toString() {
        return nome + " [" + autor + "]";
    }
    
    public String toStringFull() {
        String str = nome;
        if (quantidade_aulas > -1) str +=  " - quantidade de aulas: " + quantidade_aulas;
        return str;
    }
    
    public static Estudo[] getVisões() {
        String sql = "SELECT Nome, Autor FROM Estudos";
        ResultSet lista_resultados = null;
        ArrayList<Estudo> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                String autor = lista_resultados.getString("Autor");
                visões.add(new Estudo(nome, autor));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões.toArray(new Estudo[visões.size()]);
    }
 
    public static Estudo buscarEstudo (String nome) {
        String sql = "SELECT * FROM Estudos WHERE Nome = ?";
        ResultSet lista_resultados = null;
        Estudo estudo = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                estudo = new Estudo(nome,
                    lista_resultados.getString("Autor"),
                    Dificuldade.values()[lista_resultados.getInt("Dificuldade")],
                    Tipo_lição.values()[lista_resultados.getInt("Tipo_lição")],    
                    lista_resultados.getInt("Duração"),
                    lista_resultados.getInt("Quantidade_aulas"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            estudo = null;
        }
        return estudo;
    }
    
    public static String inserirEstudo(Estudo estudo) {
        String sql = "INSERT INTO Estudos (Nome, Autor, Dificuldade, Tipo_lição, Duração, Quantidade_aulas) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, estudo.getNome());            
            comando.setString(2, estudo.getAutor());            
            comando.setInt(3, estudo.getTipo_lição().ordinal());
            comando.setInt(4, estudo.getDificuldade().ordinal());
            comando.setInt(5, estudo.getDuração());
            comando.setInt(6, estudo.getQuantidade_aulas());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Inserção do Estudo no BD";
        }
    }
    
    
    public static String alterarEstudo(Estudo estudo) {
        String sql = "UPDATE Estudos SET Autor = ?,  Tipo_lição = ?, Dificuldade = ?,Duração = ?, Quantidade_aulas = ? WHERE Nome = ? ";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, estudo.getAutor());            
            comando.setInt(2, estudo.getTipo_lição().ordinal());
            comando.setInt(3, estudo.getDificuldade().ordinal());
            comando.setInt(4, estudo.getDuração());
            comando.setInt(5, estudo.getQuantidade_aulas());
            comando.setString(6, estudo.getNome());            

            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Alteração do Estudo no BD";
        }
    }
    
     public static String removerEstudo (String nome) {
        String sql = "DELETE FROM Estudos WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Remoção do Estudo no BD";
        }
    }
}

