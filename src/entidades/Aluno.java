package entidades;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.sql.*; 
import persistência.BD;  

public class Aluno {
    public enum Instrumento { Violino, Clarinete, Eufônio };
    private String nome, cpf, telefone, endereço;
    private Instrumento instrumento;
    
    public Aluno(String nome, String cpf, Instrumento instrumento, String telefone, String endereço) {
        this.nome = nome;
        this.cpf = cpf;
        this.instrumento = instrumento;
        this.telefone = telefone;
        this.endereço = endereço;
    }
    
    public String getNome() {
        return nome;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getEndereço() {
        return endereço;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    
    }   
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Aluno(String nome, String cpf) { 
        this.nome = nome; 
        this.cpf = cpf; 
     }  
    
    public String toString() {
        return nome + " [CPF: "+cpf+"]"; 
    }
    
    public String toStringFull() {
        String str = nome;
        if (instrumento != null) str += "[ " + instrumento + " ]";
        return str;
    }
    
    public Aluno getVisão() { 
        return new Aluno(nome, cpf, instrumento, telefone,  endereço);
    }
    
    public static Aluno[] getVisões() {
        String sql = "SELECT Nome, Cpf FROM Alunos";
        ResultSet lista_resultados = null;
        ArrayList<Aluno> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                String cpf = lista_resultados.getString("Cpf");
                visões.add(new Aluno(nome, cpf));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões.toArray(new Aluno[visões.size()]);
    }
      
    
    public static Aluno buscarAluno (String nome) {
        String sql = "SELECT * FROM Alunos WHERE Nome = ?";
        ResultSet lista_resultados = null;
        Aluno aluno = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                aluno = new Aluno (nome,
                    lista_resultados.getString("Cpf"),
                    Instrumento.values()[lista_resultados.getInt("Instrumento")],    
                    lista_resultados.getString("Telefone"),
                    lista_resultados.getString("Endereço"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            aluno = null;
        }
        return aluno;
    }
    
    public static String inserirAluno(Aluno aluno) {
        String sql = "INSERT INTO Alunos (Nome, Cpf, Instrumento, Telefone, Endereço) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, aluno.getNome()); 
            comando.setString(2, aluno.getCpf());
            comando.setInt(3, aluno.getInstrumento().ordinal());
            comando.setString(4, aluno.getTelefone());
            comando.setString(5, aluno.getEndereço());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Inserção do Aluno no BD";
        }
    }
    
    
    public static String alterarAluno(Aluno aluno) {
        String sql = "UPDATE Alunos SET Cpf = ?, Instrumento = ?, Telefone = ?, Endereço = ? WHERE Nome = ? ";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, aluno.getCpf());
            comando.setInt(2, aluno.getInstrumento().ordinal());;
            comando.setString(3, aluno.getTelefone());
            comando.setString(4, aluno.getEndereço());
            comando.setString(5, aluno.getNome());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Alteração do Aluno no BD";
        }
    }
    
     public static String removerAluno (String nome) {
        String sql = "DELETE FROM Alunos WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Remoção do Aluno no BD";
        }
    }
}
