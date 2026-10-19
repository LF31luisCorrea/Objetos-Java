package interfaces;
import javax.swing.JOptionPane;
import controles.ControladorCadastroEstudos;
import entidades.Estudo;
import entidades.Estudo.Tipo_lição;
import entidades.Estudo.Dificuldade;
import javax.swing.DefaultComboBoxModel;
import java.sql.*; 
import persistência.BD;

public class JanelaCadastroEstudos extends javax.swing.JFrame {

    public void selecionarTipo_liçãoRadioButton(int índice_tipo_lição) {
        switch(índice_tipo_lição){
            case 0:
                dó_maiorRadioButton.setSelected(true);
                break;
            case 1:
                mi_bemolRadioButton.setSelected(true);
                break;
            case 2:
                si_bemolRadioButton.setSelected(true);
                break;
        }
    }
    
    public void selecionarDificuldadeRadioButton(int índice_dificuldade){
        switch(índice_dificuldade){
            case 0:
                difícilRadioButton.setSelected(true);

                break;
            case 1:
                médioRadioButton.setSelected(true);
                break;
            case 2:
                fácilRadioButton.setSelected(true);
                break;
        }
    }
    
    ControladorCadastroEstudos controlador;
    Estudo[] estudos_cadastrados;
    
    public JanelaCadastroEstudos(ControladorCadastroEstudos controlador) {
        this.controlador = controlador;
        estudos_cadastrados = Estudo.getVisões();
        initComponents();
        limparCampos(null);
    }

 
    private Estudo obterEstudoInformado() {
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) return null;
        
        String autor = autorTextField.getText();
        if (autor.isEmpty()) return null;
        
        Tipo_lição tipo_lição = null;
        if (tipo_liçãobuttonGroup.getSelection() != null){
           tipo_lição = Tipo_lição.values()[tipo_liçãobuttonGroup.getSelection().getMnemonic()];
        } else {
            return null;
        }
        
        Dificuldade dificuldade = null;
        if (dificuldadebuttonGroup.getSelection() != null){
           dificuldade = Dificuldade.values()[dificuldadebuttonGroup.getSelection().getMnemonic()];
        } else {
            return null;
        }
        
        String duração_str = duraçãoTextField.getText(); 
        if (duração_str.isEmpty()) return null;
        int duração = Integer.parseInt(duração_str); 
        
        String quantidade_aulas_str = quantidade_aulasTextField.getText();
        if (quantidade_aulas_str.isEmpty()) return null;
        int quantidade_aulas = Integer.parseInt(quantidade_aulas_str); 

        
        return new Estudo(nome, autor, dificuldade, tipo_lição, duração, quantidade_aulas);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        tipo_liçãobuttonGroup = new javax.swing.ButtonGroup();
        dificuldadebuttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        nomeTextField = new javax.swing.JTextField();
        estudos_cadastradosComboBox = new javax.swing.JComboBox();
        duraçãoTextField = new javax.swing.JTextField();
        quantidade_aulasTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        tipo_licaoLabel = new javax.swing.JLabel();
        dificuldadeLabel = new javax.swing.JLabel();
        duracaoLabel = new javax.swing.JLabel();
        quantidadeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inserirEstudo = new javax.swing.JButton();
        consultarEstudo = new javax.swing.JButton();
        alterarEstudo = new javax.swing.JButton();
        removerEstudo = new javax.swing.JButton();
        limparCampos = new javax.swing.JButton();
        autorTextField = new javax.swing.JTextField();
        autorLabel = new javax.swing.JLabel();
        estudos_cadastradosLabel = new javax.swing.JLabel();
        dó_maiorRadioButton = new javax.swing.JRadioButton();
        si_bemolRadioButton = new javax.swing.JRadioButton();
        mi_bemolRadioButton = new javax.swing.JRadioButton();
        difícilRadioButton = new javax.swing.JRadioButton();
        médioRadioButton = new javax.swing.JRadioButton();
        fácilRadioButton = new javax.swing.JRadioButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        jButton1.setText("jButton1");

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Estudos");
        setFocusCycleRoot(false);

        nomeTextField.setColumns(50);
        nomeTextField.setPreferredSize(new java.awt.Dimension(456, 20));

        estudos_cadastradosComboBox.setModel(new DefaultComboBoxModel(estudos_cadastrados));
        estudos_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estudos_cadastradosComboBox(evt);
            }
        });

        duraçãoTextField.setColumns(50);
        duraçãoTextField.setPreferredSize(new java.awt.Dimension(456, 20));

        quantidade_aulasTextField.setColumns(50);
        quantidade_aulasTextField.setPreferredSize(new java.awt.Dimension(456, 20));

        nomeLabel.setText("Nome ");

        tipo_licaoLabel.setText("Tipo da lição");

        dificuldadeLabel.setText("Dificuldade");

        duracaoLabel.setText("Duração das aulas");

        quantidadeLabel.setText("Quantidade de aulas");

        inserirEstudo.setText("Inserir");
        inserirEstudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirEstudo(evt);
            }
        });

        consultarEstudo.setText("Consultar");
        consultarEstudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarEstudo(evt);
            }
        });

        alterarEstudo.setText("Alterar");
        alterarEstudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarEstudo(evt);
            }
        });

        removerEstudo.setText("Remover");
        removerEstudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerEstudo(evt);
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
                .addComponent(inserirEstudo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarEstudo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alterarEstudo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerEstudo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserirEstudo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarEstudo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterarEstudo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerEstudo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        autorTextField.setColumns(50);
        autorTextField.setPreferredSize(new java.awt.Dimension(456, 20));

        autorLabel.setText("Autor");

        estudos_cadastradosLabel.setText("Estudos cadastrados");

        tipo_liçãobuttonGroup.add(dó_maiorRadioButton);
        dó_maiorRadioButton.setText("Dó Maior");

        tipo_liçãobuttonGroup.add(si_bemolRadioButton);
        si_bemolRadioButton.setMnemonic('\u0001');
        si_bemolRadioButton.setText("Si bemol");

        tipo_liçãobuttonGroup.add(mi_bemolRadioButton);
        mi_bemolRadioButton.setMnemonic('\u0002');
        mi_bemolRadioButton.setText("Mi bemol");

        dificuldadebuttonGroup.add(difícilRadioButton);
        difícilRadioButton.setText("Difícil");

        dificuldadebuttonGroup.add(médioRadioButton);
        médioRadioButton.setMnemonic('\u0001');
        médioRadioButton.setText("Médio");

        dificuldadebuttonGroup.add(fácilRadioButton);
        fácilRadioButton.setMnemonic('\u0002');
        fácilRadioButton.setText("Fácil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(estudos_cadastradosLabel)
                .addGap(18, 18, 18)
                .addComponent(estudos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dificuldadeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(quantidadeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tipo_licaoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(duracaoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(autorLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(difícilRadioButton)
                            .addComponent(dó_maiorRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(si_bemolRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mi_bemolRadioButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(médioRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(fácilRadioButton))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(quantidade_aulasTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addComponent(duraçãoTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estudos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estudos_cadastradosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(autorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo_licaoLabel)
                    .addComponent(dó_maiorRadioButton)
                    .addComponent(si_bemolRadioButton)
                    .addComponent(mi_bemolRadioButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dificuldadeLabel)
                    .addComponent(difícilRadioButton)
                    .addComponent(médioRadioButton)
                    .addComponent(fácilRadioButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duraçãoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duracaoLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidade_aulasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantidadeLabel))
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirEstudo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirEstudo
        Estudo estudo = obterEstudoInformado();
        String mensagem_erro = null;
        if (estudo != null) mensagem_erro = controlador.inserirEstudo(estudo);
        else mensagem_erro = "Algum atributo do estudo não foi informado";
        if (mensagem_erro == null) {
            Estudo visão = estudo.getVisão();
            estudos_cadastradosComboBox.addItem(visão);
            estudos_cadastradosComboBox.setSelectedItem(visão);            
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_inserirEstudo

    private void consultarEstudo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarEstudo
        Estudo visão = (Estudo) estudos_cadastradosComboBox.getSelectedItem ();
        Estudo estudo = null;
        String mensagem_erro = null;
        if (visão != null) {
            estudo = Estudo.buscarEstudo(visão.getNome());
            if (estudo == null) mensagem_erro = "Estudo não cadastrado";
        } else mensagem_erro = "Nenhum estudo selecionado";
        if (mensagem_erro == null) {
            nomeTextField.setText(estudo.getNome());
            autorTextField.setText(estudo.getAutor());
            selecionarTipo_liçãoRadioButton(estudo.getTipo_lição().ordinal());
            selecionarDificuldadeRadioButton(estudo.getDificuldade().ordinal());
            duraçãoTextField.setText(Integer.toString((estudo.getDuração())));
            quantidade_aulasTextField.setText(Integer.toString((estudo.getQuantidade_aulas())));
                            
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_consultarEstudo

    private void alterarEstudo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarEstudo
        Estudo estudo = obterEstudoInformado(); 
        String mensagem_erro = null; 
        if (estudo != null) mensagem_erro = controlador.alterarEstudo(estudo); 
        else mensagem_erro = "Algum atributo do estudo não foi informado"; 
        if (mensagem_erro == null) { 
            Estudo visão = getVisãoAlterada(estudo.getNome());
            if (visão != null) {
                visão.setAutor(estudo.getAutor());
                estudos_cadastradosComboBox.updateUI();
                estudos_cadastradosComboBox.setSelectedItem(visão); 
            }
        } else informarErro(mensagem_erro); 
    }//GEN-LAST:event_alterarEstudo

    private void removerEstudo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerEstudo
        Estudo visão = (Estudo) estudos_cadastradosComboBox.getSelectedItem ();
        String mensagem_erro = null;
        if (visão != null) mensagem_erro = controlador.removerEstudo(visão.getNome());
        else mensagem_erro = "Nenhum estudo selecionado";
        if (mensagem_erro == null) {
            estudos_cadastradosComboBox.removeItem(visão);
            limparCampos(evt);
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_removerEstudo

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        nomeTextField.setText("");
        autorTextField.setText("");
        tipo_liçãobuttonGroup.clearSelection();
        dificuldadebuttonGroup.clearSelection();
        duraçãoTextField.setText("");
        quantidade_aulasTextField.setText("");
    }//GEN-LAST:event_limparCampos

    private void estudos_cadastradosComboBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudos_cadastradosComboBox
        toString();
    }//GEN-LAST:event_estudos_cadastradosComboBox

    private void informarErro (String mensagem) {
        JOptionPane.showMessageDialog (this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private Estudo getVisãoAlterada(String nome) {
        for (Estudo visão : estudos_cadastrados) {
            if (visão.getNome().equals(nome)) return visão;
        }
        return null;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarEstudo;
    private javax.swing.JLabel autorLabel;
    private javax.swing.JTextField autorTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton consultarEstudo;
    private javax.swing.JLabel dificuldadeLabel;
    private javax.swing.ButtonGroup dificuldadebuttonGroup;
    private javax.swing.JRadioButton difícilRadioButton;
    private javax.swing.JLabel duracaoLabel;
    private javax.swing.JTextField duraçãoTextField;
    private javax.swing.JRadioButton dó_maiorRadioButton;
    private javax.swing.JComboBox estudos_cadastradosComboBox;
    private javax.swing.JLabel estudos_cadastradosLabel;
    private javax.swing.JRadioButton fácilRadioButton;
    private javax.swing.JButton inserirEstudo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton limparCampos;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JRadioButton mi_bemolRadioButton;
    private javax.swing.JRadioButton médioRadioButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel quantidadeLabel;
    private javax.swing.JTextField quantidade_aulasTextField;
    private javax.swing.JButton removerEstudo;
    private javax.swing.JRadioButton si_bemolRadioButton;
    private javax.swing.JLabel tipo_licaoLabel;
    private javax.swing.ButtonGroup tipo_liçãobuttonGroup;
    // End of variables declaration//GEN-END:variables
}
