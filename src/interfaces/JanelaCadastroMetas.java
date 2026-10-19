package interfaces;

import javax.swing.JOptionPane;
import controles.ControladorCadastroMetas;
import controles.ControladorCadastroObjetivos;
import entidades.Meta;
import entidades.Meta.Dia_aula;
import entidades.MetaSolo;
import entidades.MetaSolo.Tipo_aprendizado;
import entidades.MetaOrquestra;
import entidades.MetaOrquestra.Tipo_orquestra;
import entidades.MetaOrquestra.Nível;
import entidades.Objetivo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class JanelaCadastroMetas extends javax.swing.JFrame {

    public static Dia_aula converteStringParaDia_aula(String nome_str) {
        switch (nome_str) {
            case "Sg": return Dia_aula.Segunda;
            case "T": return Dia_aula.Terça;
            case "Qa": return Dia_aula.Quarta;
            case "Qi": return Dia_aula.Quinta;
            case "Sx": return Dia_aula.Sexta;
            case "Sa": return Dia_aula.Sábado;
            default: return null;
        }
    }
 
    ControladorCadastroMetas controlador;
    Meta[] metas_cadastrados;
    PainelMetaSolo meta_soloPainel;
    PainelMetaOrquestra meta_orquestraPainel;
    DefaultListModel modelo_objetivos;
    private int sequencial;


    public JanelaCadastroMetas(ControladorCadastroMetas controlador) {
        this.controlador = controlador;
        metas_cadastrados = Meta.getVisões();
        initComponents();
        meta_soloPainel = new PainelMetaSolo();
        meta_orquestraPainel = new PainelMetaOrquestra();
        especialização_metaTabbedPane.addTab("Meta Solo", meta_soloPainel);
        especialização_metaTabbedPane.addTab("Meta Orquestra", meta_orquestraPainel);
        modelo_objetivos = (DefaultListModel) estudosList.getModel();
        limparCampos(null);    
    }
    
    private Meta obterMetaInformado() {
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;

        if (!sequencial_str.isEmpty()) {
            sequencial = Integer.parseInt(sequencial_str);
        }

        String nome = nomeTextField.getText();
        if (nome.isEmpty()) return null;

        Dia_aula dia_aula = null;
        if (dia_aulaComboBox.getSelectedItem() != null) {
            dia_aula = (Dia_aula) dia_aulaComboBox.getSelectedItem();
        } else {
            return null;
        }
    
        boolean aula_especial = aula_especialCheckBox.isSelected();

        Meta meta = null;
        int índice_aba_selecionada = especialização_metaTabbedPane.getSelectedIndex();
        
        switch (índice_aba_selecionada) {
                case 0:
                
                   Tipo_aprendizado tipo_aprendizado = meta_soloPainel.getSelectedTipo_aprendizado();
                   if (tipo_aprendizado == null)
                       return null;

                   int tempo = meta_soloPainel.getTempo();
                   if (tempo == -1.0)
                       return null;

                   meta = new MetaSolo(
                       sequencial,
                       nome,
                       dia_aula,
                       aula_especial,
                       tipo_aprendizado,
                       tempo
                   );
                   break;
                
                case 1:

                    Tipo_orquestra tipo_orquestra = meta_orquestraPainel.getSelectedTipo_orquestra();
                    if (tipo_orquestra == null)
                        return null;

                    Nível nível = meta_orquestraPainel.getSelectedNível();
                    if (nível == null)
                        return null;

                    meta = new MetaOrquestra(
                       sequencial,
                       nome,
                       dia_aula,
                       aula_especial,
                       tipo_orquestra,
                       nível
                    );
                break;   
                   
        }
        return meta;
        
    }
    
    private Meta getVisãoAlterada(int sequencial) { 
        for (Meta visão : metas_cadastrados) { 
            if (visão.getSequencial() == sequencial) { 
                return visão; 
            } 
        } 
        return null; 
    } 

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        estudosList = new javax.swing.JList();
        metas_cadastradosComboBox = new javax.swing.JComboBox();
        nomeTextField = new javax.swing.JTextField();
        dia_aulaComboBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        inserirMeta = new javax.swing.JButton();
        consultarMeta = new javax.swing.JButton();
        alterarMeta = new javax.swing.JButton();
        removerMeta = new javax.swing.JButton();
        limparCampos = new javax.swing.JButton();
        inserirEstudos = new javax.swing.JButton();
        aula_especialCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sequencialTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        especialização_metaTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Meta");

        estudosList.setModel(new DefaultListModel());
        estudosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        estudosList.setVisibleRowCount(4);
        jScrollPane1.setViewportView(estudosList);

        metas_cadastradosComboBox.setModel(new DefaultComboBoxModel(metas_cadastrados));

        dia_aulaComboBox.setModel(new DefaultComboBoxModel (Dia_aula.values()));

        inserirMeta.setText("Inserir");
        inserirMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirMeta(evt);
            }
        });

        consultarMeta.setText("Consultar");
        consultarMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarMeta(evt);
            }
        });

        alterarMeta.setText("Alterar");
        alterarMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarMeta(evt);
            }
        });

        removerMeta.setText("Remover");
        removerMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerMeta(evt);
            }
        });

        limparCampos.setText("Limpar");
        limparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        inserirEstudos.setText("Estudos");
        inserirEstudos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEstudos(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inserirMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alterarMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removerMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inserirEstudos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inserirMeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removerMeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alterarMeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inserirEstudos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(limparCampos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(consultarMeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        aula_especialCheckBox.setToolTipText("");

        jLabel1.setText("Metas cadastradas");

        jLabel2.setText("Estudos na meta");

        jLabel3.setText("Dia da aula");

        jLabel4.setText("Nome");

        jLabel5.setText("Aula especial");

        sequencialTextField.setEditable(false);

        jLabel6.setText("Identificador Sequencial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(metas_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dia_aulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(aula_especialCheckBox)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(especialização_metaTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metas_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dia_aulaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aula_especialCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(especialização_metaTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirMeta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirMeta
        Meta meta = obterMetaInformado();
        String mensagem_erro = null;
        if (meta != null) mensagem_erro = controlador.inserirMeta(meta);
        else mensagem_erro = "Algum atributo de meta não foi informado";

        if (mensagem_erro == null) {
            int sequencial = Meta.últimoSequencial();
            meta.setSequencial(sequencial);
            Meta visão = meta.getVisão();
            metas_cadastradosComboBox.addItem(visão);
            metas_cadastradosComboBox.setSelectedItem(visão);
            sequencialTextField.setText ("" + sequencial);
        } else informarErro(mensagem_erro);
    }//GEN-LAST:event_inserirMeta

    private void consultarMeta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarMeta
        Meta visão = (Meta) metas_cadastradosComboBox.getSelectedItem();
        Meta meta = null;
        String mensagem_erro = null;
        int sequencial = -1;

        if (visão != null) {
            sequencial = visão.getSequencial();
            meta = Meta.buscarMeta(sequencial);

            if (meta == null) {
                mensagem_erro = "Meta não cadastrado";
            }
        } else {
            mensagem_erro = "Nenhuma meta selecionado";
        }

        if (mensagem_erro == null) {
            sequencialTextField.setText(sequencial + "");
            nomeTextField.setText(meta.getNome());
            dia_aulaComboBox.setSelectedItem(meta.getDia_aula());
            aula_especialCheckBox.setSelected(meta.isConsideradoAula_especial());
            atualizarListaObjetivos(sequencial);
            if (meta instanceof MetaSolo) {
                especialização_metaTabbedPane.setSelectedIndex(0);
                MetaSolo meta_solo = (MetaSolo) meta;

                meta_soloPainel.setSelectedTipo_aprendizado(
                    meta_solo.getTipo_aprendizado().ordinal()
                );
                meta_soloPainel.setTempo(
                    meta_solo.getTempo()
                );

            } else if (meta instanceof MetaOrquestra) {
                especialização_metaTabbedPane.setSelectedIndex(1);
                MetaOrquestra meta_orquestra = (MetaOrquestra) meta;
                
                meta_orquestraPainel.setSelectedTipo_orquestra(
                    meta_orquestra.getTipo_orquestra().ordinal()
                );
                meta_orquestraPainel.setSelectedNível(
                    meta_orquestra.getNível().ordinal()
                );
            }
            
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarMeta

    private void alterarMeta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarMeta
        Meta meta = obterMetaInformado();
        String mensagem_erro = null;
        if (meta != null) mensagem_erro = controlador.alterarMeta(meta);
        else mensagem_erro = "Algum atributo de Meta não foi informado";

        if (mensagem_erro == null) {
            Meta visão = (Meta) metas_cadastradosComboBox.getSelectedItem();
            if (visão != null) {
                visão.setNome(meta.getNome());   
            }
            
            metas_cadastradosComboBox.updateUI();
            if (meta instanceof MetaSolo) {
                    MetaSolo meta_solo = (MetaSolo) meta;
                    MetaSolo visão_solo = (MetaSolo) visão;

                    visão_solo.setTipo_aprendizado(meta_solo.getTipo_aprendizado());
                    visão_solo.setTempo(meta_solo.getTempo());

                } else if (meta instanceof MetaOrquestra) {
                    MetaOrquestra meta_orquestra = (MetaOrquestra) meta;
                    MetaOrquestra visão_orquestra = (MetaOrquestra) visão;

                    visão_orquestra.setTipo_orquestra(meta_orquestra.getTipo_orquestra());
                    visão_orquestra.setNível(meta_orquestra.getNível());
                }


            metas_cadastradosComboBox.setSelectedItem(visão);
        } else informarErro(mensagem_erro);

    }//GEN-LAST:event_alterarMeta

    private void removerMeta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerMeta
        Meta visão = (Meta) metas_cadastradosComboBox.getSelectedItem();
        String mensagem_erro = null;

        if (visão != null) mensagem_erro = controlador.removerMeta(visão.getSequencial());
        else mensagem_erro = "Nenhum meta selecionada";

        if (mensagem_erro == null) {
            metas_cadastradosComboBox.removeItem(visão);
            limparCampos(null);
        } else informarErro(mensagem_erro);
    }//GEN-LAST:event_removerMeta

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        sequencialTextField.setText("");
        nomeTextField.setText("");        
        dia_aulaComboBox.setSelectedIndex(-1);
        aula_especialCheckBox.setSelected(false);
        modelo_objetivos.clear();
        meta_soloPainel.limparCampos();
        meta_orquestraPainel.limparCampos();
    }//GEN-LAST:event_limparCampos

    private void cadastrarEstudos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEstudos
       String sequencial_str = sequencialTextField.getText();
       int sequencial = 0;
       if (!sequencial_str.isEmpty()) sequencial = Integer.parseInt(sequencial_str);
       if (sequencial > 0) new ControladorCadastroObjetivos(this, sequencial);
       else informarErro ("Nenhuma meta selecionada");
    }//GEN-LAST:event_cadastrarEstudos


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarMeta;
    private javax.swing.JCheckBox aula_especialCheckBox;
    private javax.swing.JButton consultarMeta;
    private javax.swing.JComboBox dia_aulaComboBox;
    private javax.swing.JTabbedPane especialização_metaTabbedPane;
    private javax.swing.JList estudosList;
    private javax.swing.JButton inserirEstudos;
    private javax.swing.JButton inserirMeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparCampos;
    private javax.swing.JComboBox metas_cadastradosComboBox;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton removerMeta;
    private javax.swing.JTextField sequencialTextField;
    // End of variables declaration//GEN-END:variables


    void atualizarListaObjetivos(int sequencial) {
        modelo_objetivos.clear();
        Objetivo[] objetivos = Objetivo.buscarObjetivos(sequencial);
        for (Objetivo objetivo : objetivos) modelo_objetivos.addElement(objetivo);    
    }
}
