/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author caibugatti.ruben
 */
public class Mercante extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Mercante.class.getName());
    gestoreForm g;
    JPanel oggettoInt;
    /**
     * Creates new form Mercante
     */
    public Mercante(gestoreForm g,int w,int h) {
        initComponents();

        this.setSize(w, h);
        this.g=g;
        
        JPanel panel = new JPanel() {
            Image immagineSfondoGioco = new ImageIcon("immagini/sfondoMercante.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagineSfondoGioco, 0, 0, getWidth(), getHeight(), this);
            }
        };
 
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // -------------------------------------------- SOPRA --------------------------------------------
        JPanel sopra = new JPanel(new GridBagLayout());
        sopra.setOpaque(false); 

        GridBagConstraints gbcSopra = new GridBagConstraints();
        gbcSopra.fill = GridBagConstraints.BOTH;
        gbcSopra.gridy = 0; 
        gbcSopra.weighty = 1; 

        // Pannello vuoto a sinistra
        JPanel vuotoSX = new JPanel();
        vuotoSX.setOpaque(false);
        gbcSopra.gridx = 0;
        gbcSopra.weightx = 0.90;
        sopra.add(vuotoSX, gbcSopra);

        // Pannello info a destra
        JPanel info = new JPanel();
        info.setBackground(Color.GREEN);
        gbcSopra.gridx = 1;
        gbcSopra.weightx = 0.1;
        gbcSopra.insets=new Insets(30,0,0,20);
        sopra.add(info, gbcSopra);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.2; 
        panel.add(sopra, gbc);

        // -------------------------------------------- VUOTO1 -------------------------------------------
        JPanel vuoto1 = new JPanel();
        vuoto1.setOpaque(false);
        gbc.gridy = 1;
        gbc.weighty = 0.27; 
        panel.add(vuoto1, gbc);

        // -------------------------------------------- OGGETTI --------------------------------------------
        JPanel oggetti = new JPanel();
        oggetti.setLayout(new GridBagLayout());
        
        GridBagConstraints gbcOgg = new GridBagConstraints();
        gbcOgg.gridy = 0;
        gbcOgg.weighty = 1; 
        gbcOgg.fill = GridBagConstraints.BOTH;
        
        //-----------------vuoto1-----------------
        gbcOgg.gridx=0;
        gbcOgg.weightx = 0.19; 
        
        JPanel vuotosx=new JPanel();
        vuotosx.setOpaque(false);
        oggetti.add(vuotosx,gbcOgg);
        
        //-----------------ogg1-----------------
        gbcOgg.gridx=1;
        gbcOgg.weightx = 0.23; 
        
        JPanel ogg1=new JPanel();
        ogg1.setBackground(Color.BLUE);
        creoOggInt(ogg1);
        oggetti.add(ogg1,gbcOgg);
        
        //-----------------vuoto1PICCOLO-----------------
        gbcOgg.gridx=2;
        gbcOgg.weightx = 0.02; 
        
        JPanel vuoto1Piccolo=new JPanel();
        vuoto1Piccolo.setOpaque(false);
        oggetti.add(vuoto1Piccolo,gbcOgg);
        
        //-----------------ogg2-----------------
        gbcOgg.gridx=3;
        gbcOgg.weightx = 0.23; 
        
        JPanel ogg2=new JPanel();
        ogg2.setBackground(Color.BLUE);
        creoOggInt(ogg2);
        oggetti.add(ogg2,gbcOgg);
        
        //-----------------vuoto2PICCOLO-----------------
        gbcOgg.gridx=4;
        gbcOgg.weightx = 0.02; 
        
        JPanel vuoto1Piccolo2=new JPanel();
        vuoto1Piccolo2.setOpaque(false);
        oggetti.add(vuoto1Piccolo2,gbcOgg);
        
        //-----------------ogg2-----------------
        gbcOgg.gridx=5;
        gbcOgg.weightx = 0.22; 
        
        JPanel ogg3=new JPanel();
        ogg3.setBackground(Color.BLUE);
        creoOggInt(ogg3);
        oggetti.add(ogg3,gbcOgg);
        
        //-----------------vuotofinale-----------------
        gbcOgg.gridx=6;
        gbcOgg.weightx = 0.21; 
        
        JPanel vuotodx=new JPanel();
        vuotodx.setOpaque(false);
        oggetti.add(vuotodx,gbcOgg);
        
        oggetti.setOpaque(false);
        gbc.gridy = 2;
        gbc.weighty = 0.33; 
        panel.add(oggetti, gbc);
        
        // -------------------------------------------- VUOTO2 --------------------------------------------
        JPanel vuoto2 = new JPanel();
        vuoto2.setOpaque(false);
        gbc.gridy = 3;
        gbc.weighty = 0.20; 
        panel.add(vuoto2, gbc);
        
        
        
        this.setLayout(new BorderLayout());
        this.add(panel);
        
    }
    
    public void creoOggInt(JPanel p){
        p.setLayout(new BorderLayout());
        oggettoInt=new JPanel();
        oggettoInt.setOpaque(false);
        p.add(oggettoInt);
        p.add(new JButton("COMPRA"),BorderLayout.SOUTH);  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
