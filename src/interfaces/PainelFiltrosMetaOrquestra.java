package interfaces;

import entidades.MetaOrquestra;

public class PainelFiltrosMetaOrquestra extends javax.swing.JPanel {


    public PainelFiltrosMetaOrquestra() {
        initComponents();
    }
    
    public MetaOrquestra.Nível getSelectedNível() {
        MetaOrquestra.Nível nível = null;
        if (nívelbuttonGroup.getSelection() != null)
        nível = MetaOrquestra.Nível.values()[nívelbuttonGroup.getSelection().getMnemonic()];
        return nível;
    }
    public void limparFiltros() {
        nívelbuttonGroup.clearSelection();
    }  
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nívelbuttonGroup = new javax.swing.ButtonGroup();
        aRadioButton = new javax.swing.JRadioButton();
        bRadioButton = new javax.swing.JRadioButton();
        cRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        nívelbuttonGroup.add(aRadioButton);
        aRadioButton.setText("A");

        nívelbuttonGroup.add(bRadioButton);
        bRadioButton.setMnemonic('\u0001');
        bRadioButton.setText("B");

        nívelbuttonGroup.add(cRadioButton);
        cRadioButton.setMnemonic('\u0002');
        cRadioButton.setText("C");

        jLabel1.setText("Nível");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(aRadioButton)
                .addGap(18, 18, 18)
                .addComponent(bRadioButton)
                .addGap(10, 10, 10)
                .addComponent(cRadioButton)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aRadioButton)
                    .addComponent(bRadioButton)
                    .addComponent(cRadioButton)
                    .addComponent(jLabel1))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aRadioButton;
    private javax.swing.JRadioButton bRadioButton;
    private javax.swing.JRadioButton cRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.ButtonGroup nívelbuttonGroup;
    // End of variables declaration//GEN-END:variables
}
