package interfaces;
import controles.ControladorCadastroOrçamentos;
import entidades.Aluno;
import entidades.Meta;
import entidades.Orçamento;
import entidades.Orçamento.Pagamento;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaCadastroOrçamentos extends javax.swing.JFrame {

    public void selecionarPagamentoRadioButton(int índice_pagamento) {
        switch(índice_pagamento){
            case 0:
                semanalRadioButton.setSelected(true);
                break;
            case 1:
                mensalRadioButton.setSelected(true);
                break;
            case 2:
                à_vistaRadioButton.setSelected(true);
                break;
        }
    }
    
    public JanelaCadastroOrçamentos() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pagamentobuttonGroup = new javax.swing.ButtonGroup();
        sequencialTextField = new javax.swing.JTextField();
        alunos_cadastradosComboBox = new javax.swing.JComboBox();
        metas_cadastradosComboBox = new javax.swing.JComboBox<>();
        valor_aulaTextField = new javax.swing.JTextField();
        semanalRadioButton = new javax.swing.JRadioButton();
        mensalRadioButton = new javax.swing.JRadioButton();
        à_vistaRadioButton = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        inserirOrçamento = new javax.swing.JButton();
        consultarOrçamento = new javax.swing.JButton();
        alterarOrçamento = new javax.swing.JButton();
        removerOrçamento = new javax.swing.JButton();
        limparCampos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orçamentos_cadastradosList = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        promoçãoCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Orçamentos");

        sequencialTextField.setEditable(false);

        alunos_cadastradosComboBox.setModel(new DefaultComboBoxModel(alunos_cadastrados));

        metas_cadastradosComboBox.setModel(new DefaultComboBoxModel(metas_cadastrados));

        pagamentobuttonGroup.add(semanalRadioButton);
        semanalRadioButton.setText("Semanal");

        pagamentobuttonGroup.add(mensalRadioButton);
        mensalRadioButton.setMnemonic('\u0001');
        mensalRadioButton.setText("Mensal");

        pagamentobuttonGroup.add(à_vistaRadioButton);
        à_vistaRadioButton.setMnemonic('\u0002');
        à_vistaRadioButton.setText("À vista");

        inserirOrçamento.setText("Inserir");
        inserirOrçamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirOrçamento(evt);
            }
        });

        consultarOrçamento.setText("Consultar");
        consultarOrçamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarOrçamento(evt);
            }
        });

        alterarOrçamento.setText("Alterar");
        alterarOrçamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarOrçamento(evt);
            }
        });

        removerOrçamento.setText("Remover");
        removerOrçamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerOrçamento(evt);
            }
        });

        limparCampos.setText("Limpar");
        limparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(inserirOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alterarOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserirOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterarOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Orçamentos cadastrados");

        jLabel2.setText("Sequencial");

        jLabel3.setText("Alunos Cadastrados");

        jLabel4.setText("Metas cadastradas");

        jLabel5.setText("Valor da Aula");

        jLabel6.setText("Pagamento");

        orçamentos_cadastradosList.setModel(new DefaultListModel());
        orçamentos_cadastradosList.setVisibleRowCount(4);
        jScrollPane1.setViewportView(orçamentos_cadastradosList);

        jLabel7.setText("Promoção");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(semanalRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mensalRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(à_vistaRadioButton))
                            .addComponent(valor_aulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(alunos_cadastradosComboBox, 0, 354, Short.MAX_VALUE)
                                .addComponent(metas_cadastradosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(promoçãoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alunos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metas_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valor_aulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semanalRadioButton)
                    .addComponent(mensalRadioButton)
                    .addComponent(à_vistaRadioButton)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(promoçãoCheckBox))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
    }
    
    ControladorCadastroOrçamentos controlador;
    DefaultListModel modelo_lista_orçamentos;
    Aluno[] alunos_cadastrados;
    Meta[] metas_cadastrados;
    public JanelaCadastroOrçamentos(ControladorCadastroOrçamentos controlador) {
        this.controlador = controlador;
        alunos_cadastrados = Aluno.getVisões();
        metas_cadastrados = Meta.getVisões();
        initComponents();
        inicializarListaOrçamentos();
        limparCampos(null);
    }
    
    private void inicializarListaOrçamentos() {
        modelo_lista_orçamentos = (DefaultListModel) orçamentos_cadastradosList.getModel();
        Orçamento[] visões = Orçamento.getVisões();
        for (Orçamento visão : visões) {
            modelo_lista_orçamentos.addElement(visão);
        }
    }
    
    private Orçamento obterOrçamentoInformado() {
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) sequencial = Integer.parseInt(sequencial_str);
        
        Aluno visão_aluno = (Aluno) alunos_cadastradosComboBox.getSelectedItem();
        if (visão_aluno == null) return null;
        
        Meta visão_meta = (Meta) metas_cadastradosComboBox.getSelectedItem();
        if (visão_meta == null) return null;
        
        String valor_aula_str = valor_aulaTextField.getText(); 
        if (valor_aula_str.isEmpty()) return null;
        float valor_aula = Float.parseFloat(valor_aula_str); 
        
        Pagamento pagamento = null;
        if (pagamentobuttonGroup.getSelection() != null){
           pagamento = Pagamento.values()[pagamentobuttonGroup.getSelection().getMnemonic()];
        } else {
            return null;
        }
        
        boolean promoção = promoçãoCheckBox.isSelected();

        return new Orçamento(sequencial, visão_aluno, visão_meta, valor_aula, pagamento, promoção);
    }
    
     private Aluno getVisãoAlunoSelecionado(Orçamento orçamento) {
        String chave_aluno = orçamento.getAluno().getNome();
        for(Aluno visão_aluno : alunos_cadastrados){
            if(visão_aluno.getNome().equals(chave_aluno))
                return visão_aluno;
        }
        return null;
    }
    
    private Meta getVisãoMetaSelecionado(Orçamento orçamento){
        Integer chave_meta = orçamento.getMeta().getSequencial();
        for(Meta visão_meta : metas_cadastrados){
            if(visão_meta.getSequencial() == chave_meta)
                return visão_meta;
        }
        return null;
    }
    
    
    private void inserirOrçamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirOrçamento
        Orçamento orçamento = obterOrçamentoInformado();
        String mensagem_erro = null;
        if (orçamento != null) mensagem_erro = controlador.inserirOrçamento(orçamento);
        else mensagem_erro = "Algum atributo da orçamento não foi informado";
        if (mensagem_erro == null) {
            int sequencial = Orçamento.últimoSequencial();
            orçamento.setSequencial(sequencial);
            modelo_lista_orçamentos.addElement(orçamento.getVisão());
            orçamentos_cadastradosList.setSelectedIndex(modelo_lista_orçamentos.size() - 1);
            sequencialTextField.setText("" + sequencial);
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_inserirOrçamento

    private void consultarOrçamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarOrçamento
        Orçamento visão_orçamento = (Orçamento) orçamentos_cadastradosList.getSelectedValue();
        Orçamento orçamento = null;
        String mensagem_erro = null;
        if (visão_orçamento != null) {
            orçamento = Orçamento.buscarOrçamento(visão_orçamento.getSequencial());
            if (orçamento == null) mensagem_erro = "Avaliação não cadastrada";
        } else mensagem_erro = "Nenhuma avaliação selecionada";
        if (mensagem_erro == null) {
            sequencialTextField.setText(orçamento.getSequencial() + "");
            alunos_cadastradosComboBox.setSelectedItem(getVisãoAlunoSelecionado(orçamento));
            metas_cadastradosComboBox.setSelectedItem(getVisãoMetaSelecionado(orçamento));
            valor_aulaTextField.setText(Float.toString((orçamento.getValor_aula())));
            promoçãoCheckBox.setSelected(orçamento.isConsideradoPromoção());
            selecionarPagamentoRadioButton(orçamento.getPagamento().ordinal());
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_consultarOrçamento

    private void alterarOrçamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarOrçamento
            Orçamento orçamento = obterOrçamentoInformado();
            String mensagem_erro = null;
            if (orçamento != null) mensagem_erro = controlador.alterarOrçamento(orçamento);
            else mensagem_erro = "Algum atributo da orçamento não foi informado";
            if (mensagem_erro != null) informarErro(mensagem_erro);
    }//GEN-LAST:event_alterarOrçamento

    private void removerOrçamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerOrçamento
        Orçamento visão = (Orçamento) orçamentos_cadastradosList.getSelectedValue();
        String mensagem_erro = null;
        if (visão != null) {
            mensagem_erro = controlador.removerOrçamento(visão.getSequencial());
        } else {
            mensagem_erro = "Nenhum Jogo selecionado";
        }
        if (mensagem_erro == null) {
            modelo_lista_orçamentos.removeElement(visão);
        } else {
            informarErro(mensagem_erro);
        }

    }//GEN-LAST:event_removerOrçamento

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        sequencialTextField.setText("");
        alunos_cadastradosComboBox.setSelectedIndex(-1);
        metas_cadastradosComboBox.setSelectedIndex(-1);
        valor_aulaTextField.setText("");
        pagamentobuttonGroup.clearSelection();
        promoçãoCheckBox.setSelected(false);
    }//GEN-LAST:event_limparCampos

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarOrçamento;
    private javax.swing.JComboBox alunos_cadastradosComboBox;
    private javax.swing.JButton consultarOrçamento;
    private javax.swing.JButton inserirOrçamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparCampos;
    private javax.swing.JRadioButton mensalRadioButton;
    private javax.swing.JComboBox<String> metas_cadastradosComboBox;
    private javax.swing.JList orçamentos_cadastradosList;
    private javax.swing.ButtonGroup pagamentobuttonGroup;
    private javax.swing.JCheckBox promoçãoCheckBox;
    private javax.swing.JButton removerOrçamento;
    private javax.swing.JRadioButton semanalRadioButton;
    private javax.swing.JTextField sequencialTextField;
    private javax.swing.JTextField valor_aulaTextField;
    private javax.swing.JRadioButton à_vistaRadioButton;
    // End of variables declaration//GEN-END:variables
}
