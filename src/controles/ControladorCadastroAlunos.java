package controles;
import entidades.Aluno;
import interfaces.JanelaCadastroAlunos;

public class ControladorCadastroAlunos {
    
    public ControladorCadastroAlunos() {
        new JanelaCadastroAlunos(this).setVisible(true);
    }
    
    public String inserirAluno (Aluno aluno) {
        Aluno aluno1 = Aluno.buscarAluno(aluno.getNome());
        if (aluno1 == null) return Aluno.inserirAluno(aluno);
        else return "Nome de aluno já cadastrado";
    }
    
    public String alterarAluno(Aluno aluno) {
        Aluno aluno1 = Aluno.buscarAluno(aluno.getNome());
        if (aluno1 != null) return Aluno.alterarAluno(aluno);
        else return "Nome de aluno não cadastrado";
    }
    
     public String removerAluno (String nome) {
        Aluno aluno1 = Aluno.buscarAluno(nome);
        if (aluno1 != null) return Aluno.removerAluno(nome);
        else return "Nome de aluno não cadastrado";
    }
}
