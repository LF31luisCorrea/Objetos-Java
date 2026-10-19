package interfaces;
import entidades.MetaOrquestra;
import entidades.MetaOrquestra.Tipo_orquestra;
import entidades.MetaOrquestra.Nível;

public class PainelMetaOrquestra extends javax.swing.JPanel {

    
    public PainelMetaOrquestra() {
        initComponents();
    }

    public Tipo_orquestra getSelectedTipo_orquestra() {
        Tipo_orquestra tipo_orquestra = null;
        if (tipo_orquestrabuttonGroup.getSelection() != null)
            tipo_orquestra = Tipo_orquestra.values()[tipo_orquestrabuttonGroup.getSelection().getMnemonic()];
        return tipo_orquestra;
    }

    public void setSelectedTipo_orquestra(int índice_tipo_orquestra) {
        switch (índice_tipo_orquestra) {
            case 0:
                cordasRadioButton.setSelected(true);
                break;
            case 1:
                metaisRadioButton.setSelected(true);
                break;
            case 2:
                palhetasRadioButton.setSelected(true);
                break;
            case 3:
                mistoRadioButton.setSelected(true);
                break;    
            
        }
    }

    public Nível getSelectedNível() {
        Nível nível = null;
        if (nívelbuttonGroup.getSelection() != null)
            nível = Nível.values()[nívelbuttonGroup.getSelection().getMnemonic()];
        return nível;
    }

    public void setSelectedNível(int índice_nível) {
        switch (índice_nível) {
            case 0:
                aRadioButton.setSelected(true);
                break;
            case 1:
                bRadioButton.setSelected(true);
                break;
            case 2:
                cRadioButton.setSelected(true);
                break; 
        }
    }

    public void limparCampos() {
        tipo_orquestrabuttonGroup.clearSelection();
        nívelbuttonGroup.clearSelection();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_orquestrabuttonGroup = new javax.swing.ButtonGroup();
        nívelbuttonGroup = new javax.swing.ButtonGroup();
        cordasRadioButton = new javax.swing.JRadioButton();
        metaisRadioButton = new javax.swing.JRadioButton();
        aRadioButton = new javax.swing.JRadioButton();
        bRadioButton = new javax.swing.JRadioButton();
        cRadioButton = new javax.swing.JRadioButton();
        tipo_orquestraLabel = new javax.swing.JLabel();
        nívelLabel = new javax.swing.JLabel();
        palhetasRadioButton = new javax.swing.JRadioButton();
        mistoRadioButton = new javax.swing.JRadioButton();

        tipo_orquestrabuttonGroup.add(cordasRadioButton);
        cordasRadioButton.setText("Cordas");

        tipo_orquestrabuttonGroup.add(metaisRadioButton);
        metaisRadioButton.setMnemonic('\u0001');
        metaisRadioButton.setText("Metais");

        nívelbuttonGroup.add(aRadioButton);
        aRadioButton.setText("A");

        nívelbuttonGroup.add(bRadioButton);
        bRadioButton.setMnemonic('\u0001');
        bRadioButton.setText("B");

        nívelbuttonGroup.add(cRadioButton);
        cRadioButton.setMnemonic('\u0002');
        cRadioButton.setText("C");

        tipo_orquestraLabel.setText("Tipo de orquestra");

        nívelLabel.setText("Nível");

        tipo_orquestrabuttonGroup.add(palhetasRadioButton);
        palhetasRadioButton.setMnemonic('\u0002');
        palhetasRadioButton.setText("Palhetas");

        tipo_orquestrabuttonGroup.add(mistoRadioButton);
        mistoRadioButton.setMnemonic('\u0003');
        mistoRadioButton.setText("Misto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(tipo_orquestraLabel)
                        .addGap(18, 18, 18)
                        .addComponent(cordasRadioButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nívelLabel)
                        .addGap(18, 18, 18)
                        .addComponent(aRadioButton)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(cRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(metaisRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(palhetasRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mistoRadioButton)))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cordasRadioButton)
                    .addComponent(metaisRadioButton)
                    .addComponent(tipo_orquestraLabel)
                    .addComponent(palhetasRadioButton)
                    .addComponent(mistoRadioButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nívelLabel)
                    .addComponent(aRadioButton)
                    .addComponent(bRadioButton)
                    .addComponent(cRadioButton))
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aRadioButton;
    private javax.swing.JRadioButton bRadioButton;
    private javax.swing.JRadioButton cRadioButton;
    private javax.swing.JRadioButton cordasRadioButton;
    private javax.swing.JRadioButton metaisRadioButton;
    private javax.swing.JRadioButton mistoRadioButton;
    private javax.swing.JLabel nívelLabel;
    private javax.swing.ButtonGroup nívelbuttonGroup;
    private javax.swing.JRadioButton palhetasRadioButton;
    private javax.swing.JLabel tipo_orquestraLabel;
    private javax.swing.ButtonGroup tipo_orquestrabuttonGroup;
    // End of variables declaration//GEN-END:variables
}
