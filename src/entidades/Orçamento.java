package entidades;

import entidades.Aluno.Instrumento;
import entidades.Meta.Dia_aula;
import entidades.MetaOrquestra.Nível;
import entidades.MetaSolo.Tipo_aprendizado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import persistência.BD;

public class Orçamento {

    public enum Pagamento {
        semanal, mensal, à_vista
    };
    private int sequencial;
    private Aluno aluno;
    private Meta meta;
    private float valor_aula;
    private Pagamento pagamento; 
    private boolean promoção;

    public Orçamento(int sequencial, Aluno aluno, Meta meta, float valor_aula,
            Pagamento pagamento, boolean promoção) {
        this.sequencial = sequencial;
        this.aluno = aluno;
        this.meta = meta;
        this.valor_aula = valor_aula;
        this.pagamento = pagamento;
        this.promoção = promoção;
    }

    public Orçamento getVisão() {
        return new Orçamento(sequencial, aluno, meta, valor_aula, pagamento, promoção);
    }

    public Orçamento(int sequencial, Aluno aluno, Meta meta) {
        this.sequencial = sequencial;
        this.aluno = aluno;
        this.meta = meta;
    }

    public Orçamento(int sequencial) {
        this.sequencial = sequencial;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public float getValor_aula() {
        return valor_aula;
    }

    public void setValor_aula(float valor_aula) {
        this.valor_aula = valor_aula;
    }

    public String toString() {
        return "[" + sequencial + "] - Aluno: " + aluno.getVisão() + ", Meta: "
                + meta.getVisão();
    }
    
    public boolean isConsideradoPromoção(){
        return promoção;
    }

    public String toStringFull() {
        String str = "\n" + aluno.toStringFull() + " --- " + meta.toStringFull() + "\n  ";           
Estudo[] estudos_meta = Objetivo.buscarEstudosMeta(meta.getSequencial());
        for (Estudo estudo : estudos_meta) {
            str += " -- " + estudo.toStringFull();
        }
        if (promoção) str +=  " - aula com promoção."; 
        return str;
    }

    public static Orçamento[] getVisões() {
  

        String sql = "SELECT Sequencial, MetaId, AlunoId FROM Orçamentos";
        ResultSet lista_resultados = null;
        ArrayList<Orçamento> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new Orçamento(lista_resultados.getInt("Sequencial"),
                        Aluno.buscarAluno(lista_resultados.getString("AlunoId")).getVisão(),
                        Meta.buscarMeta(lista_resultados.getInt("MetaId")).getVisão()));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Orçamento[visões.size()]);
    }

    public static String inserirOrçamento(Orçamento orçamento) {
        String sql = "INSERT INTO Orçamentos(AlunoId, MetaId, Valor_aula,"
                + " Pagamento, Promoção) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, orçamento.getAluno().getNome());
            comando.setInt(2, orçamento.getMeta().getSequencial());
            comando.setFloat(3, orçamento.getValor_aula());
            comando.setInt(4, orçamento.getPagamento().ordinal());
            comando.setBoolean(5, orçamento.isConsideradoPromoção());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na inserção do Orçamento no BD";
        }
    }

    public static int últimoSequencial() {
        String sql = "SELECT MAX(Sequencial)FROM Orçamentos";
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
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return sequencial;
    }

    public static boolean existeOrçamento(String chave_aluno, int chave_meta) {
        String sql = "SELECT Sequencial FROM Orçamentos WHERE AlunoId = ? AND MetaId =  ?"; 
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_aluno);
            comando.setInt(2, chave_meta);
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

    public static Orçamento buscarOrçamento(int sequencial) {
        String sql = "SELECT * FROM Orçamentos WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        Orçamento orçamento = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                orçamento = new Orçamento(sequencial,
                        Aluno.buscarAluno(lista_resultados.getString("AlunoId")),
                        Meta.buscarMeta(lista_resultados.getInt("MetaId")),
                        lista_resultados.getFloat("Valor_aula"),
                        Pagamento.values()[lista_resultados.getInt("Pagamento")],
                        lista_resultados.getBoolean("Promoção"));

            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            orçamento = null;
        }
        return orçamento;
    }

    public static boolean existeOrçamento(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) FROM Orçamentos WHERE Sequencial =  ?"; 
ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return existe;

    }

    public static String alterarOrçamento(Orçamento orçamento) {
        String sql = "UPDATE Orçamentos SET AlunoId = ?, MetaId = ?, Valor_aula = ?," 
                + "Pagamento = ?, Promoção = ? WHERE Sequencial = ?"; 
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, orçamento.getAluno().getNome());
            comando.setInt(2, orçamento.getMeta().getSequencial());
            comando.setFloat(3, orçamento.getValor_aula());
            comando.setInt(4, orçamento.getPagamento().ordinal());
            comando.setBoolean(5, orçamento.isConsideradoPromoção());
            comando.setInt(6, orçamento.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na Alteração do Orçamento no BD";
        }
    }

    public static String removerOrçamento(int sequencial) {
        String sql = "DELETE FROM Orçamentos WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoção do Orçamento no BD";
        }
        return null;
    }

    public static ArrayList<Orçamento> pesquisarOrçamentos(Instrumento instrumento_aluno, int quantidade_aula_máxima_estudo, Dia_aula dia_aula_meta, Tipo_aprendizado tipo_aprendizado_meta_solo,
            Nível nível_meta_orquestra, boolean todos_estudos_meta, char promoção_orçamento) throws SQLException {

        String sql = "SELECT Al.Nome, Al.Instrumento, M.Dia_aula,"
                + " M.Sequencial, O.Promoção, O.Sequencial"
                + " FROM Alunos Al, Metas M, Orçamentos O"
                + " WHERE O.AlunoId = Al.Nome AND O.MetaId = M.Sequencial";
        if (instrumento_aluno != null) {
            sql += " AND Al.Instrumento = ?";
        }
        if (dia_aula_meta != null) {
            sql += " AND M.Dia_aula = ?";
        }
        if (promoção_orçamento != 'X') {
            sql += " AND O.Promoção = ?";
        }
  
        sql += " ORDER BY O.Sequencial";

        int sequencial_meta = -1;

        ResultSet lista_resultados = null;
        ArrayList<Orçamento> orçamentos_selecionados = new ArrayList();
        int index = 0;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);

            if (instrumento_aluno != null) {
                comando.setInt(++index, instrumento_aluno.ordinal());
            }

            if (dia_aula_meta != null) {
                comando.setInt(++index, dia_aula_meta.ordinal());
            }

            boolean promoção = true;
            if (promoção_orçamento == 'T') {
                promoção = true;
            } else if (promoção_orçamento == 'F') {
                promoção = false;
            }
            if (promoção_orçamento != 'X') {
                comando.setBoolean(++index, promoção);
            }


            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                Orçamento orçamento_pesquisado
                        = Orçamento.buscarOrçamento(lista_resultados.getInt(6));

                sequencial_meta = lista_resultados.getInt(4);
                if (!estudosMetaAtendemFiltros(sequencial_meta,
                        quantidade_aula_máxima_estudo, todos_estudos_meta)) {
                    continue;
                }
                if (tipo_aprendizado_meta_solo != null) {
                    if (isOkPesquisaEmMetasSolo(sequencial_meta,
                            tipo_aprendizado_meta_solo)) {
                        orçamentos_selecionados.add(orçamento_pesquisado);
                    }
                } else if (nível_meta_orquestra != null) {
                    if (isOkPesquisaEmMetasOrquestra(sequencial_meta,
                            nível_meta_orquestra)) {
                        orçamentos_selecionados.add(orçamento_pesquisado);
                    }
                } else {
                    orçamentos_selecionados.add(orçamento_pesquisado);
                }
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return orçamentos_selecionados;
    }

    private static boolean estudosMetaAtendemFiltros(int sequencial_meta, int quantidade_aula_máxima_estudo, boolean todos_estudos_meta) {
        Estudo[] estudos_meta = Objetivo.buscarEstudosMeta(sequencial_meta);
        if (estudos_meta == null || estudos_meta.length == 0) {
            return false;
        }
        int total_estudos_não_atendem_filtros = 0;
        for (Estudo estudo : estudos_meta) {
            if (quantidade_aula_máxima_estudo > -1) {
                int quantidade_aulas = estudo.getQuantidade_aulas();
                if (quantidade_aulas > quantidade_aula_máxima_estudo) {
                    total_estudos_não_atendem_filtros++;
                    if (todos_estudos_meta) {
                        return false;
                    }
                }
            }
        }
        if (total_estudos_não_atendem_filtros == 0) {
            return true;
        }
        if ((todos_estudos_meta) || (total_estudos_não_atendem_filtros
                == estudos_meta.length)) {
            return false;
        }
        return true;
    }

    private static boolean isOkPesquisaEmMetasSolo(int sequencial_meta,
            Tipo_aprendizado tipo_aprendizado_meta_solo) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM MetasSolo WHERE MetaId = ?";
        if (tipo_aprendizado_meta_solo != null) {
            sql += " AND Tipo_aprendizado=?";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial_meta);
            if (tipo_aprendizado_meta_solo != null) {
                comando.setInt(++index,
                        tipo_aprendizado_meta_solo.ordinal());
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                pesquisa_ok = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return pesquisa_ok;
    }

    private static boolean isOkPesquisaEmMetasOrquestra(int sequencial_meta,
            Nível nível_meta_orquestra) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM MetasOrquestra WHERE MetaId= ?";
        if (nível_meta_orquestra != null) {
            sql += " AND Nível = ?";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial_meta);
            if (nível_meta_orquestra != null) {
                comando.setInt(++index,
                        nível_meta_orquestra.ordinal());
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                pesquisa_ok = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return pesquisa_ok;
    }

}