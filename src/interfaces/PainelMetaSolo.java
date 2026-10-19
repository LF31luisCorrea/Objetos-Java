package interfaces;
import entidades.MetaSolo;
import entidades.MetaSolo.Tipo_aprendizado;

public class PainelMetaSolo extends javax.swing.JPanel {

    
    public PainelMetaSolo() {
        initComponents();
    }

    public Tipo_aprendizado getSelectedTipo_aprendizado() {
        Tipo_aprendizado tipo_aprendizado = null;
        if (tipo_aprendizadobuttonGroup.getSelection() != null)
            tipo_aprendizado = Tipo_aprendizado.values()[tipo_aprendizadobuttonGroup.getSelection().getMnemonic()];
        return tipo_aprendizado;
    }

    public void setSelectedTipo_aprendizado(int índice_tipo_aprendizado) {
        switch (índice_tipo_aprendizado) {
            case 0:
                aprendizado_próprioRadioButton.setSelected(true);
                break;
            case 1:
                profissionalRadioButton.setSelected(true);
                break;
            case 2:
                didáticoRadioButton.setSelected(true);
                break;
        }
    }

    public int getTempo(){
        String tempo_str = tempoTextField.getText(); 
        if (!tempo_str.isEmpty())
            return Integer.parseInt(tempo_str); 
        else 
            return -1;
    }

    public void setTempo(int tempo) {
        tempoTextField.setText(tempo + "");
    }

    public void limparCampos() {
        tipo_aprendizadobuttonGroup.clearSelection();
        tempoTextField.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_aprendizadobuttonGroup = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        tempoTextField = new javax.swing.JTextField();
        tempoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        aprendizado_próprioRadioButton = new javax.swing.JRadioButton();
        profissionalRadioButton = new javax.swing.JRadioButton();
        didáticoRadioButton = new javax.swing.JRadioButton();

        tempoLabel.setText("Tempo");

        jLabel1.setText("Tipo de aprendizado");

        tipo_aprendizadobuttonGroup.add(aprendizado_próprioRadioButton);
        aprendizado_próprioRadioButton.setText("aprendizado próprio");

        tipo_aprendizadobuttonGroup.add(profissionalRadioButton);
        profissionalRadioButton.setMnemonic('\u0001');
        profissionalRadioButton.setText("profissional");

        tipo_aprendizadobuttonGroup.add(didáticoRadioButton);
        didáticoRadioButton.setMnemonic('\u0002');
        didáticoRadioButton.setText("didático");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(tempoLabel)
                        .addGap(36, 36, 36)
                        .addComponent(tempoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(aprendizado_próprioRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profissionalRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(didáticoRadioButton)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(aprendizado_próprioRadioButton)
                    .addComponent(profissionalRadioButton)
                    .addComponent(didáticoRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempoLabel))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aprendizado_próprioRadioButton;
    private javax.swing.JRadioButton didáticoRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton profissionalRadioButton;
    private javax.swing.JLabel tempoLabel;
    private javax.swing.JTextField tempoTextField;
    private javax.swing.ButtonGroup tipo_aprendizadobuttonGroup;
    // End of variables declaration//GEN-END:variables
}
