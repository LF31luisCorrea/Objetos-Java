package interfaces;
import entidades.MetaSolo;

public class PainelFiltrosMetaSolo extends javax.swing.JPanel {

    public PainelFiltrosMetaSolo() {
        initComponents();
    }

    public MetaSolo.Tipo_aprendizado getSelectedTipo_aprendizado() {
        MetaSolo.Tipo_aprendizado tipo_aprendizado = null;
        if (tipo_aprendizadobuttonGroup.getSelection() != null)
        tipo_aprendizado = MetaSolo.Tipo_aprendizado.values()[tipo_aprendizadobuttonGroup.getSelection().getMnemonic()];
        return tipo_aprendizado;
    }
    public void limparFiltros() {
        tipo_aprendizadobuttonGroup.clearSelection();
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_aprendizadobuttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        aprendizado_próprioRadioButton = new javax.swing.JRadioButton();
        profissionalRadioButton = new javax.swing.JRadioButton();
        didáticoRadioButton = new javax.swing.JRadioButton();

        jLabel1.setText("Tipo de aprendizado");

        tipo_aprendizadobuttonGroup.add(aprendizado_próprioRadioButton);
        aprendizado_próprioRadioButton.setText("aprendizado próprio");

        tipo_aprendizadobuttonGroup.add(profissionalRadioButton);
        profissionalRadioButton.setMnemonic('\u0001');
        profissionalRadioButton.setText("profissional");
        profissionalRadioButton.setAutoscrolls(true);

        tipo_aprendizadobuttonGroup.add(didáticoRadioButton);
        didáticoRadioButton.setMnemonic('\u0002');
        didáticoRadioButton.setText("didático");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aprendizado_próprioRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profissionalRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(didáticoRadioButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aprendizado_próprioRadioButton)
                    .addComponent(profissionalRadioButton)
                    .addComponent(jLabel1)
                    .addComponent(didáticoRadioButton))
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aprendizado_próprioRadioButton;
    private javax.swing.JRadioButton didáticoRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton profissionalRadioButton;
    private javax.swing.ButtonGroup tipo_aprendizadobuttonGroup;
    // End of variables declaration//GEN-END:variables
}
