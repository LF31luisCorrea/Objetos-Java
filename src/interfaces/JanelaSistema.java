package interfaces;
import javax.swing.JOptionPane;
import persistência.BD;
import controles.ControladorCadastroAlunos;
import controles.ControladorCadastroEstudos;
import controles.ControladorCadastroMetas;
import controles.ControladorCadastroOrçamentos;

public class JanelaSistema extends javax.swing.JFrame {

    public JanelaSistema() {
        BD.criaConexão();
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Orcamento_estudo_musicalMenuBar = new javax.swing.JMenuBar();
        aluno = new javax.swing.JMenu();
        cadastrar_alunoMenuItem = new javax.swing.JMenuItem();
        Estudo = new javax.swing.JMenu();
        cadastrar_estudoMenuItem = new javax.swing.JMenuItem();
        Meta = new javax.swing.JMenu();
        cadastrar_metaMenuItem = new javax.swing.JMenuItem();
        Orçamento = new javax.swing.JMenu();
        cadastrar_orçamentoMenuItem = new javax.swing.JMenuItem();
        pesquisar_orçamentoMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de orçamento musical");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                terminarSistema(evt);
            }
        });

        aluno.setText("Aluno");

        cadastrar_alunoMenuItem.setText("Cadastrar");
        cadastrar_alunoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_alunoMenuItem(evt);
            }
        });
        aluno.add(cadastrar_alunoMenuItem);

        Orcamento_estudo_musicalMenuBar.add(aluno);

        Estudo.setText("Estudo");

        cadastrar_estudoMenuItem.setText("Cadastrar");
        cadastrar_estudoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_estudoMenuItem(evt);
            }
        });
        Estudo.add(cadastrar_estudoMenuItem);

        Orcamento_estudo_musicalMenuBar.add(Estudo);

        Meta.setText("Meta");

        cadastrar_metaMenuItem.setText("Cadastrar");
        cadastrar_metaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_metaMenuItem(evt);
            }
        });
        Meta.add(cadastrar_metaMenuItem);

        Orcamento_estudo_musicalMenuBar.add(Meta);

        Orçamento.setText("Orçamento");

        cadastrar_orçamentoMenuItem.setText("Cadastrar");
        cadastrar_orçamentoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_orçamentoMenuItem(evt);
            }
        });
        Orçamento.add(cadastrar_orçamentoMenuItem);

        pesquisar_orçamentoMenuItem.setText("Pesquisar");
        pesquisar_orçamentoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarOrçamento(evt);
            }
        });
        Orçamento.add(pesquisar_orçamentoMenuItem);

        Orcamento_estudo_musicalMenuBar.add(Orçamento);

        setJMenuBar(Orcamento_estudo_musicalMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrar_alunoMenuItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_alunoMenuItem
         new ControladorCadastroAlunos();
        
    }//GEN-LAST:event_cadastrar_alunoMenuItem

    private void terminarSistema(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_terminarSistema
        BD.fechaConexão();
        System.exit(0);
    }//GEN-LAST:event_terminarSistema

    private void pesquisarOrçamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarOrçamento
        new JanelaPesquisaOrçamentos().setVisible(true);
    }//GEN-LAST:event_pesquisarOrçamento

    private void cadastrar_estudoMenuItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_estudoMenuItem
        new ControladorCadastroEstudos();
        
    }//GEN-LAST:event_cadastrar_estudoMenuItem

    private void cadastrar_orçamentoMenuItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_orçamentoMenuItem
        new ControladorCadastroOrçamentos();

    }//GEN-LAST:event_cadastrar_orçamentoMenuItem

    private void cadastrar_metaMenuItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_metaMenuItem
        new ControladorCadastroMetas();

    }//GEN-LAST:event_cadastrar_metaMenuItem
    
    private void informarServiçoIndisponível() {
        JOptionPane.showMessageDialog (this, "Serviço Indisponível", "Informação",
            JOptionPane.INFORMATION_MESSAGE);
    }
  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Estudo;
    private javax.swing.JMenu Meta;
    private javax.swing.JMenuBar Orcamento_estudo_musicalMenuBar;
    private javax.swing.JMenu Orçamento;
    private javax.swing.JMenu aluno;
    private javax.swing.JMenuItem cadastrar_alunoMenuItem;
    private javax.swing.JMenuItem cadastrar_estudoMenuItem;
    private javax.swing.JMenuItem cadastrar_metaMenuItem;
    private javax.swing.JMenuItem cadastrar_orçamentoMenuItem;
    private javax.swing.JMenuItem pesquisar_orçamentoMenuItem;
    // End of variables declaration//GEN-END:variables
}
