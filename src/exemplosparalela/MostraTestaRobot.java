package exemplosparalela;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class MostraTestaRobot extends JFrame {

    private Color matColor[][] = null;
    private BufferedImage image = null;

    private boolean setado = false;

    private int scale = 2;
    private int offsetX = 100;
    private int offsetY = 100;

    public MostraTestaRobot() {
        initComponents();
    }

    public void setaImagem(Color matColor[][]) {
        this.matColor = matColor;
    }

    public void setaCaptura(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        if (setado) {

            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    g.setColor(new Color(image.getRGB(x, y)));
                    g.drawRect(offsetX + x * scale, offsetY + y * scale, scale, scale);
                }
            }

            //g.drawImage(image, offsetX, offsetY, this);

            /*
            for (int y = 0; y < matColor.length; y++) {
                for (int x = 0; x < matColor[y].length; x++) {
                    g.setColor(matColor[x][y]);
                    g.drawRect(offsetX + x * scale, offsetY + y * scale, scale, scale);
                }
            }
             */
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btFecha = new javax.swing.JButton();
        btMostra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btFecha.setText("Fecha");
        btFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFechaActionPerformed(evt);
            }
        });

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
                .addContainerGap(565, Short.MAX_VALUE)
                .addComponent(btMostra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFecha)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 448, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFecha)
                    .addComponent(btMostra)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMostraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostraActionPerformed
        setado = true;
        repaint();
    }//GEN-LAST:event_btMostraActionPerformed

    private void btFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFechaActionPerformed
        dispose();
    }//GEN-LAST:event_btFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFecha;
    private javax.swing.JButton btMostra;
    // End of variables declaration//GEN-END:variables
}
