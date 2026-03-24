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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author caibugatti.ruben
 */
public class FormGioco extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormGioco.class.getName());

    /**
     * Creates new form FormGioco
     */
    gestoreForm g;
    private int numCacciatore;
    
    public FormGioco(gestoreForm gi,int w,int h,int nC) {
        initComponents();
        
        this.setSize(w, h);
        this.g=gi;
        this.numCacciatore=nC;
        
        JPanel panel = new JPanel() {
            Image immagineSfondoGioco=new ImageIcon("immagini/sfondoGioco.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagineSfondoGioco, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel panelDX=new JPanel();
        JPanel panelCX=new JPanel();
        JPanel panelSX=new JPanel();
        
        //--- SX ---
        panelSX.setLayout(new GridBagLayout());
        GridBagConstraints gbcSinistra = new GridBagConstraints();
        
        gbcSinistra.gridx = 0;
        gbcSinistra.fill = GridBagConstraints.BOTH;
        gbcSinistra.insets = new Insets(5,5,5,5);

        // --- IMMAGINE CACCIATORE ---
        JPanel immagineCacciatore = new JPanel() {
            Image immagine = new ImageIcon("immagini/g"+nC+"Face.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        };
        immagineCacciatore.setOpaque(false);
        gbcSinistra.gridy = 0;
        gbcSinistra.gridheight = 1;
        gbcSinistra.weightx = 1.0;
        gbcSinistra.weighty = 0.3;
        gbcSinistra.fill = GridBagConstraints.BOTH;
        panelSX.add(immagineCacciatore, gbcSinistra);

        // --- STATS ---
        JPanel panelStats = new JPanel();
        panelStats.setLayout(new GridLayout(2,1,10,10));
        panelStats.setOpaque(false);
        gbcSinistra.gridy = 1;
        gbcSinistra.gridheight = 1;
        gbcSinistra.weighty = 0.1;
        
        JProgressBar vita=new JProgressBar();
        vita.setMinimum(0);
        vita.setMaximum(100);
        vita.setString("VITA");
        vita.setForeground(new Color(206,48,24));
        vita.setBackground(new Color(170,0,0));
        panelStats.add(vita);
        
        panelSX.add(panelStats, gbcSinistra);
        

        // --- SPAZIO VUOTO ---
        JPanel vuotoSX = new JPanel();
        vuotoSX.setOpaque(false);
        gbcSinistra.gridy = 2;
        gbcSinistra.gridheight = 1;
        gbcSinistra.weighty = 0.4;
        panelSX.add(vuotoSX, gbcSinistra);

        // --- INVENTARIO ---
        JPanel panelInventario = new JPanel() {
            Image immagineZaino = new ImageIcon("immagini/zaino.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagineZaino, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelInventario.setOpaque(false);
        gbcSinistra.gridy = 3;
        gbcSinistra.gridheight = 1;
        gbcSinistra.weighty = 0.2;
        panelSX.add(panelInventario, gbcSinistra);

        // --- AGGIUNGO PANEL SX AL PANEL PRINCIPALE ---
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.15;
        gbc.weighty = 1.0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        panelSX.setOpaque(false);
        panel.add(panelSX, gbc);
        
        gbc = new GridBagConstraints();//azzero gbc
        
        //--- CX ---
        panelCX.setLayout(new GridBagLayout());
        GridBagConstraints gbcCentro = new GridBagConstraints();
        
        //KM
        gbcCentro.gridx = 1;
        gbcCentro.gridy = 0;
        gbcCentro.weightx = 0.6;
        gbcCentro.weighty = 0.1; 

        JPanel panelKm=new JPanel();
        panelCX.add(panelKm, gbcCentro);
        
        //ANIMALE
        gbcCentro.gridx = 1;
        gbcCentro.gridy = 0;
        gbcCentro.weighty = 0.3;
        JPanel panelAnimale=new JPanel();
        panelAnimale.setBackground(Color.GREEN);
        panelCX.add(panelAnimale, gbcCentro);
        
        //VUOTO
        gbcCentro.gridx = 1;
        gbcCentro.gridy = 0;
        gbcCentro.weighty = 0.3;

        JPanel panelVuoto=new JPanel();
        panelCX.add(panelVuoto, gbcCentro);
        
        //AVANZA
        gbcCentro.gridx = 1;
        gbcCentro.gridy = 0;
        gbcCentro.weighty = 0.3;

        JPanel panelAvanza=new JPanel();
        panelAvanza.setBackground(Color.GREEN);
        panelCX.add(panelAvanza, gbcCentro);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        
        panel.add(panelCX, gbc);
        
        
        gbc = new GridBagConstraints();
        //DX
        //ARMA
        
        
        this.setLayout(new BorderLayout());
        this.add(panel);
        
        
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
