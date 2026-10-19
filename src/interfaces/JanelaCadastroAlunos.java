package interfaces;
import javax.swing.JOptionPane;
import controles.ControladorCadastroAlunos;
import entidades.Aluno;
import entidades.Aluno.Instrumento;
import javax.swing.DefaultComboBoxModel;
import java.sql.*; 

public class JanelaCadastroAlunos extends javax.swing.JFrame {
    
    private void selecionarInstrumentoRadioButton(int índice_instrumento) {
        switch(índice_instrumento){
            case 0:
                violinoRadioButton.setSelected(true);
                break;
            case 1:
                clarineteRadioButton.setSelected(true);
                break;
            case 2:
                eufônioRadioButton.setSelected(true);
                break;
        }
    }
    
    ControladorCadastroAlunos controlador;
    Aluno[] alunos_cadastrados;

    public JanelaCadastroAlunos(ControladorCadastroAlunos controlador) {
        this.controlador = controlador;
        alunos_cadastrados = Aluno.getVisões();
        initComponents();
        limparCampos(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instrumentobuttonGroup = new javax.swing.ButtonGroup();
        cpfTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        inserirAluno = new javax.swing.JButton();
        consultarAluno = new javax.swing.JButton();
        alterarAluno = new javax.swing.JButton();
        removerAluno = new javax.swing.JButton();
        limparCampos = new javax.swing.JButton();
        endereçoTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        telefoneLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        enderecoLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        alunos_cadastradosComboBox = new javax.swing.JComboBox();
        telefoneTextField = new javax.swing.JTextField();
        alunos_cadastradosLabel = new javax.swing.JLabel();
        instrumentoLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        eufônioRadioButton = new javax.swing.JRadioButton();
        clarineteRadioButton = new javax.swing.JRadioButton();
        violinoRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Alunos");

        cpfTextField.setColumns(50);
        cpfTextField.setPreferredSize(new java.awt.Dimension(456, 20));

        inserirAluno.setText("Inserir");
        inserirAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirAluno(evt);
            }
        });

        consultarAluno.setText("Consultar");
        consultarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarAluno(evt);
            }
        });

        alterarAluno.setText("Alterar");
        alterarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarAluno(evt);
            }
        });

        removerAluno.setText("Remover");
        removerAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerAluno(evt);
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
                .addComponent(inserirAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alterarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserirAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        endereçoTextField.setColumns(50);
        endereçoTextField.setPreferredSize(new java.awt.Dimension(599, 460));

        nomeLabel.setText("Nome");

        telefoneLabel.setText("Telefone");

        cpfLabel.setText("Cpf");

        enderecoLabel.setText("Endereço");

        nomeTextField.setColumns(50);
        nomeTextField.setPreferredSize(new java.awt.Dimension(456, 20));

        alunos_cadastradosComboBox.setModel(new DefaultComboBoxModel(alunos_cadastrados));
        alunos_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alunos_cadastradosComboBox(evt);
            }
        });

        telefoneTextField.setColumns(50);
        telefoneTextField.setPreferredSize(new java.awt.Dimension(456, 20));

        alunos_cadastradosLabel.setText("Alunos cadastrados");

        instrumentoLabel.setText("Instrumento");

        instrumentobuttonGroup.add(eufônioRadioButton);
        eufônioRadioButton.setMnemonic('\u0002');
        eufônioRadioButton.setText("Eufônio");

        instrumentobuttonGroup.add(clarineteRadioButton);
        clarineteRadioButton.setMnemonic('\u0001');
        clarineteRadioButton.setText("Clarinete");

        instrumentobuttonGroup.add(violinoRadioButton);
        violinoRadioButton.setText("Violino");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(violinoRadioButton)
                .addGap(26, 26, 26)
                .addComponent(clarineteRadioButton)
                .addGap(18, 18, 18)
                .addComponent(eufônioRadioButton)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eufônioRadioButton)
                    .addComponent(clarineteRadioButton)
                    .addComponent(violinoRadioButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(alunos_cadastradosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alunos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefoneLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(enderecoLabel)))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endereçoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telefoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(instrumentoLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cpfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(alunos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alunos_cadastradosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpfTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(instrumentoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(telefoneLabel)
                    .addComponent(telefoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endereçoTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enderecoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Aluno obterAlunoInformado() {
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) return null;
        
        String cpf = cpfTextField.getText();
        if (cpf.isEmpty()) return null;
        
        Instrumento instrumento = null;
        if (instrumentobuttonGroup.getSelection() != null){
           instrumento = Instrumento.values()[instrumentobuttonGroup.getSelection().getMnemonic()];
        } else {
            return null;
        }
        
        String telefone = telefoneTextField.getText();
        if (telefone.isEmpty()) return null;
        
        String endereço = endereçoTextField.getText();
        if (endereço.isEmpty()) return null;
        
        return new Aluno(nome, cpf, instrumento, telefone, endereço);
    }
    
    private void inserirAluno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirAluno
        Aluno aluno = obterAlunoInformado();
        String mensagem_erro = null;
        if (aluno != null) mensagem_erro = controlador.inserirAluno(aluno);
        else mensagem_erro = "Algum atributo do aluno não foi informado";
        if (mensagem_erro == null) {
            Aluno visão = aluno.getVisão();
            alunos_cadastradosComboBox.addItem(visão);
            alunos_cadastradosComboBox.setSelectedItem(visão);            
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_inserirAluno

    private void consultarAluno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarAluno
        Aluno visão = (Aluno) alunos_cadastradosComboBox.getSelectedItem ();
        Aluno aluno = null;
        String mensagem_erro = null;
        if (visão != null) {
            aluno = Aluno.buscarAluno (visão.getNome());
            if (aluno == null) mensagem_erro = "Aluno não cadastrado";
        } else mensagem_erro = "Nenhum aluno selecionado";
        if (mensagem_erro == null) {
            nomeTextField.setText(aluno.getNome());
            cpfTextField.setText(aluno.getCpf());
            selecionarInstrumentoRadioButton(aluno.getInstrumento().ordinal());
            telefoneTextField.setText(aluno.getTelefone());
            endereçoTextField.setText(aluno.getEndereço());
                            
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_consultarAluno

    private void alterarAluno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarAluno
        Aluno aluno = obterAlunoInformado();
        String mensagem_erro = null;
        if (aluno != null) mensagem_erro = controlador.alterarAluno(aluno);
        else mensagem_erro = "Algum atributo do aluno não foi informado";
        if (mensagem_erro == null) {
            Aluno visão = getVisãoAlterada(aluno.getNome());
            if (visão != null) {
                visão.setCpf(aluno.getCpf());
                alunos_cadastradosComboBox.updateUI();
                alunos_cadastradosComboBox.setSelectedItem(visão);
            }
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_alterarAluno

    private void removerAluno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerAluno
        Aluno visão = (Aluno) alunos_cadastradosComboBox.getSelectedItem ();
        String mensagem_erro = null;
        if (visão != null) mensagem_erro = controlador.removerAluno(visão.getNome());
        else mensagem_erro = "Nenhum aluno selecionado";
        if (mensagem_erro == null) {
        alunos_cadastradosComboBox.removeItem(visão);
        nomeTextField.setText("");
        cpfTextField.setText("");
        instrumentobuttonGroup.clearSelection();
        telefoneTextField.setText("");
        endereçoTextField.setText("");        
        } 
        else informarErro (mensagem_erro);
    }//GEN-LAST:event_removerAluno

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        nomeTextField.setText("");
        cpfTextField.setText("");
        instrumentobuttonGroup.clearSelection();
        telefoneTextField.setText("");
        endereçoTextField.setText("");        endereçoTextField.setText("");    }//GEN-LAST:event_limparCampos

    private void alunos_cadastradosComboBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alunos_cadastradosComboBox
        toString();
    }//GEN-LAST:event_alunos_cadastradosComboBox
    
    private void informarErro (String mensagem) {
        JOptionPane.showMessageDialog (this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private Aluno getVisãoAlterada(String nome) {
        for (Aluno visão : alunos_cadastrados) {
            if (visão.getNome().equals(nome)) {
                return visão;
            }
        }
        return null;
    }
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarAluno;
    private javax.swing.JComboBox alunos_cadastradosComboBox;
    private javax.swing.JLabel alunos_cadastradosLabel;
    private javax.swing.JRadioButton clarineteRadioButton;
    private javax.swing.JButton consultarAluno;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JLabel enderecoLabel;
    private javax.swing.JTextField endereçoTextField;
    private javax.swing.JRadioButton eufônioRadioButton;
    private javax.swing.JButton inserirAluno;
    private javax.swing.JLabel instrumentoLabel;
    private javax.swing.ButtonGroup instrumentobuttonGroup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton limparCampos;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton removerAluno;
    private javax.swing.JLabel telefoneLabel;
    private javax.swing.JTextField telefoneTextField;
    private javax.swing.JRadioButton violinoRadioButton;
    // End of variables declaration//GEN-END:variables

}
