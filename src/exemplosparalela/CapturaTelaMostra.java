package exemplosparalela;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class CapturaTelaMostra extends javax.swing.JFrame {

    private BufferedImage image = null;
    private Boolean desenha = false;

    public CapturaTelaMostra() {
        initComponents();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (desenha) {
            g.drawImage(image, 10, 10, this);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btMostra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btMostra.setText("Mostra");
        btMostra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(646, Short.MAX_VALUE)
                .addComponent(btMostra)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(419, Short.MAX_VALUE)
                .addComponent(btMostra)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMostraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostraActionPerformed
        desenha = true;
        repaint();
    }//GEN-LAST:event_btMostraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMostra;
    // End of variables declaration//GEN-END:variables
}
