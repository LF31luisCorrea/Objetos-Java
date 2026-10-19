package interfaces;

import javax.swing.JOptionPane;
import controles.ControladorCadastroObjetivos;
import entidades.Meta;
import entidades.Objetivo;
import entidades.Estudo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;


public class JanelaCadastroObjetivos extends javax.swing.JFrame {
    
    ControladorCadastroObjetivos controlador;
    JanelaCadastroMetas janela_mãe;
    int sequencial_meta;
    Estudo[] estudos_cadastrados;
    DefaultListModel modelo_lista_objetivos;
    
    public JanelaCadastroObjetivos(ControladorCadastroObjetivos controlador, JanelaCadastroMetas janela_mãe, int sequencial_meta) {
        this.controlador = controlador;
        this.janela_mãe = janela_mãe;
        this.sequencial_meta = sequencial_meta; 
        estudos_cadastrados = Estudo.getVisões();
        initComponents();
        atualizarNomeMeta();
        atualizarListaObjetivos();
    }
    
    private void atualizarNomeMeta() {
        Meta meta = Meta.buscarMeta(sequencial_meta);
        metaLabel.setText("Meta : " + meta.getNome());
    }

    private void atualizarListaObjetivos() {
        modelo_lista_objetivos = (DefaultListModel) objetivosList.getModel();
        Objetivo[] objetivos = Objetivo.buscarObjetivos(sequencial_meta);
        for (Objetivo objetivo : objetivos) {
            modelo_lista_objetivos.addElement(objetivo);
        }
    }

    private void atualizarJanelaCadastroMetas(java.awt.event.WindowEvent evt) {
    janela_mãe.atualizarListaObjetivos(sequencial_meta); }
    
     private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public JanelaCadastroObjetivos() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estudos_cadastradosComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        objetivosList = new javax.swing.JList();
        metaLabel = new javax.swing.JLabel();
        inserirObjetivo = new javax.swing.JButton();
        removerObjetivo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Objetivo");

        estudos_cadastradosComboBox.setModel(new DefaultComboBoxModel (estudos_cadastrados));

        objetivosList.setModel(new DefaultListModel());
        objetivosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        objetivosList.setVisibleRowCount(4);
        jScrollPane1.setViewportView(objetivosList);

        metaLabel.setText("Meta ");

        inserirObjetivo.setText("Inserir");
        inserirObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirObjetivo(evt);
            }
        });

        removerObjetivo.setText("Remover");
        removerObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerObjetivo(evt);
            }
        });

        jLabel2.setText("Estudos Cadastrados ");

        jLabel3.setText("Estudos na meta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(111, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(estudos_cadastradosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(metaLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(inserirObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(removerObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(metaLabel)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estudos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserirObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removerObjetivo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerObjetivo
        // TODO add your handling code here:
        Objetivo objetivo = (Objetivo) objetivosList.getSelectedValue();
        String mensagem_erro = null;
        if (objetivo != null) mensagem_erro = controlador.removerObjetivo(objetivo.getSequencial());
        else mensagem_erro = "Nenhum estudo foi selecionado";
        if (mensagem_erro == null) modelo_lista_objetivos.removeElement(objetivo);
        else informarErro (mensagem_erro);

    }//GEN-LAST:event_removerObjetivo

    private void inserirObjetivo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirObjetivo
        // TODO add your handling code here:
        Estudo visão_estudo = (Estudo) estudos_cadastradosComboBox.getSelectedItem();
        String mensagem_erro = null;
        Objetivo objetivo = null;

        if (visão_estudo != null) {
            Meta visão_meta = Meta.buscarMeta(sequencial_meta);
            objetivo = new Objetivo(0, visão_meta, visão_estudo);
            mensagem_erro = controlador.inserirObjetivo(objetivo);
        } else {
            mensagem_erro = "Nenhum estudo foi selecionado";
        }

        if (mensagem_erro == null) {
            int sequencial = Objetivo.últimoSequencial();
            objetivo.setSequencial(sequencial);
            modelo_lista_objetivos.addElement(objetivo);
        } else {
            informarErro(mensagem_erro);
        }

    }//GEN-LAST:event_inserirObjetivo


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox estudos_cadastradosComboBox;
    private javax.swing.JButton inserirObjetivo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel metaLabel;
    private javax.swing.JList objetivosList;
    private javax.swing.JButton removerObjetivo;
    // End of variables declaration//GEN-END:variables
}
