package interfaces;
import entidades.Aluno.Instrumento;
import entidades.Meta.Dia_aula;
import entidades.MetaOrquestra.Nível;
import entidades.MetaSolo.Tipo_aprendizado;
import entidades.Orçamento;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JanelaPesquisaOrçamentos extends javax.swing.JFrame {

    PainelFiltrosMetaSolo filtros_meta_solo_Painel;
    PainelFiltrosMetaOrquestra filtros_meta_orquestra_Painel;
    
    public JanelaPesquisaOrçamentos() {
        initComponents();
        filtros_meta_solo_Painel = new PainelFiltrosMetaSolo();
        filtros_meta_orquestra_Painel = new PainelFiltrosMetaOrquestra();
        filtros_específicos_metaTabbedPane.addTab ("Filtros da Meta Solo", filtros_meta_solo_Painel);
        filtros_específicos_metaTabbedPane.addTab("Filtros da Meta Orquestra", filtros_meta_orquestra_Painel);
        limparFiltros(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        promoçãobuttonGroup = new javax.swing.ButtonGroup();
        instrumentobuttonGroup = new javax.swing.ButtonGroup();
        comandosPanel = new javax.swing.JPanel();
        pesquisarOrçamentos = new javax.swing.JButton();
        limpar_filtros = new javax.swing.JButton();
        limpar_pesquisa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        violinoRadioButton = new javax.swing.JRadioButton();
        clarineteRadioButton = new javax.swing.JRadioButton();
        eufônioRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        quantidade_máxima_aulasTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        todos_estudos_metaCheckBox = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dia_aulaComboBox = new javax.swing.JComboBox();
        filtros_específicos_metaTabbedPane = new javax.swing.JTabbedPane();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        simRadioButton = new javax.swing.JRadioButton();
        nãoRadioButton = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        pesquisasTextArea = new java.awt.TextArea();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Janela pesquisa ");

        pesquisarOrçamentos.setText("Pesquisar");
        pesquisarOrçamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarOrçamentos(evt);
            }
        });

        limpar_filtros.setText("Limpar Filtros");
        limpar_filtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFiltros(evt);
            }
        });

        limpar_pesquisa.setText("Limpar Pesquisa");
        limpar_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparPesquisa(evt);
            }
        });

        javax.swing.GroupLayout comandosPanelLayout = new javax.swing.GroupLayout(comandosPanel);
        comandosPanel.setLayout(comandosPanelLayout);
        comandosPanelLayout.setHorizontalGroup(
            comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comandosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisarOrçamentos)
                .addGap(18, 18, 18)
                .addComponent(limpar_filtros)
                .addGap(18, 18, 18)
                .addComponent(limpar_pesquisa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        comandosPanelLayout.setVerticalGroup(
            comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comandosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarOrçamentos)
                    .addComponent(limpar_filtros)
                    .addComponent(limpar_pesquisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aluno"));
        jPanel1.setToolTipText("");

        jLabel1.setText("Instrumento");

        instrumentobuttonGroup.add(violinoRadioButton);
        violinoRadioButton.setText("Violino");

        instrumentobuttonGroup.add(clarineteRadioButton);
        clarineteRadioButton.setMnemonic('\u0001');
        clarineteRadioButton.setText("Clarinete");

        instrumentobuttonGroup.add(eufônioRadioButton);
        eufônioRadioButton.setMnemonic('\u0002');
        eufônioRadioButton.setText("Eufônio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(violinoRadioButton)
                .addGap(18, 18, 18)
                .addComponent(clarineteRadioButton)
                .addGap(18, 18, 18)
                .addComponent(eufônioRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(violinoRadioButton)
                    .addComponent(clarineteRadioButton)
                    .addComponent(eufônioRadioButton))
                .addGap(24, 24, 24))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudo"));

        jLabel2.setText("Quantidade máxima de aulas");

        todos_estudos_metaCheckBox.setText("Todos os estudos da meta");

        jLabel6.setText("Abragência de filtros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(quantidade_máxima_aulasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(todos_estudos_metaCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidade_máxima_aulasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(todos_estudos_metaCheckBox)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Meta"));

        dia_aulaComboBox.setModel(new DefaultComboBoxModel (Dia_aula.values()));

        jLabel5.setText("Dia da aula");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(dia_aulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(filtros_específicos_metaTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(115, 115, 115))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dia_aulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(53, 53, 53))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtros_específicos_metaTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Orçamento"));

        jLabel4.setText("Promoção");

        promoçãobuttonGroup.add(simRadioButton);
        simRadioButton.setMnemonic('\u0001');
        simRadioButton.setText("Sim");

        promoçãobuttonGroup.add(nãoRadioButton);
        nãoRadioButton.setText("Não");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(simRadioButton)
                .addGap(18, 18, 18)
                .addComponent(nãoRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(simRadioButton)
                    .addComponent(nãoRadioButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(pesquisasTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisasTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarOrçamentos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarOrçamentos
            Instrumento instrumento_aluno = null;
            if (instrumentobuttonGroup.getSelection() != null)
                instrumento_aluno = Instrumento.values()[instrumentobuttonGroup.getSelection().getMnemonic()];
            int quantidade_aula_máxima_estudo = -1;
            if (!quantidade_máxima_aulasTextField.getText().isEmpty())
                quantidade_aula_máxima_estudo = Integer.parseInt(quantidade_máxima_aulasTextField.getText());
            boolean todos_estudos_meta = todos_estudos_metaCheckBox.isSelected();
            Dia_aula dia_aula_meta = null;
            if (dia_aulaComboBox.getSelectedItem() != null)
                dia_aula_meta = (Dia_aula) dia_aulaComboBox.getSelectedItem();
            Tipo_aprendizado tipo_aprendizado_meta_solo = null;
            Nível nível_meta_orquestra = null;
            int índice_aba_secionada = filtros_específicos_metaTabbedPane.getSelectedIndex();
            if (índice_aba_secionada == 0)
                tipo_aprendizado_meta_solo = filtros_meta_solo_Painel.getSelectedTipo_aprendizado();
            else if (índice_aba_secionada == 1)
                nível_meta_orquestra = filtros_meta_orquestra_Painel.getSelectedNível();
            char promoção_orçamento = getOrçamentoPromoção();
            
            ArrayList<Orçamento>
                    orçamentos = null;
        try {
            orçamentos = Orçamento.pesquisarOrçamentos
                                                   (instrumento_aluno, quantidade_aula_máxima_estudo,
                                                           dia_aula_meta, tipo_aprendizado_meta_solo, nível_meta_orquestra, todos_estudos_meta,
                                                           promoção_orçamento);
        } catch (SQLException ex) {
            Logger.getLogger(JanelaPesquisaOrçamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
            mostrarOrçamentosSelecionados(orçamentos);
       
    }//GEN-LAST:event_pesquisarOrçamentos

     private void mostrarOrçamentosSelecionados(ArrayList<Orçamento> orçamentos) {
        boolean primeiro_orçamento = true;
        for (Orçamento orçamento : orçamentos) {
            if (primeiro_orçamento) {
                pesquisasTextArea.append(orçamento.toStringFull());
                primeiro_orçamento = false;
            } else pesquisasTextArea.append("\n" + orçamento.toStringFull());
        }        
    }
    
    private void limparFiltros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFiltros
        instrumentobuttonGroup.clearSelection();
        quantidade_máxima_aulasTextField.setText("");
        promoçãobuttonGroup.clearSelection();
        todos_estudos_metaCheckBox.setSelected(false);
        dia_aulaComboBox.setSelectedIndex(-1);
        filtros_meta_solo_Painel.limparFiltros();
        filtros_meta_orquestra_Painel.limparFiltros();
    }//GEN-LAST:event_limparFiltros

    private void limparPesquisa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparPesquisa
        pesquisasTextArea.setText(""); 
    }//GEN-LAST:event_limparPesquisa

     public char getOrçamentoPromoção() {
        char promoção_orçamento = 'X';
        if (promoçãobuttonGroup.getSelection() != null) {
            switch(promoçãobuttonGroup.getSelection().getMnemonic()) {
                case 0: promoção_orçamento = 'F'; break;
                case 1: promoção_orçamento = 'T'; break;
            }
        }
        return promoção_orçamento;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton clarineteRadioButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JComboBox dia_aulaComboBox;
    private javax.swing.JRadioButton eufônioRadioButton;
    private javax.swing.JTabbedPane filtros_específicos_metaTabbedPane;
    private javax.swing.ButtonGroup instrumentobuttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpar_filtros;
    private javax.swing.JButton limpar_pesquisa;
    private javax.swing.JRadioButton nãoRadioButton;
    private javax.swing.JButton pesquisarOrçamentos;
    private java.awt.TextArea pesquisasTextArea;
    private javax.swing.ButtonGroup promoçãobuttonGroup;
    private javax.swing.JTextField quantidade_máxima_aulasTextField;
    private javax.swing.JRadioButton simRadioButton;
    private javax.swing.JCheckBox todos_estudos_metaCheckBox;
    private javax.swing.JRadioButton violinoRadioButton;
    // End of variables declaration//GEN-END:variables
}
