/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author ruben
 */
public class statPlayer extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(statPlayer.class.getName());

    
    gestoreForm g;
    Cacciatore c;
            
    /**
     * Creates new form statPlayer
     */
   public statPlayer(int w, int h, gestoreForm g, Cacciatore c, int nC) {
    initComponents();
    
    this.setSize(w,h);
    
    this.g = g;
    this.c = c;

    // --- PANEL PRINCIPALE CON SFONDO ---
    JPanel mainPanel = new JPanel(new GridBagLayout()) {
        Image sfondo = new ImageIcon("immagini/sfondoStat.png").getImage();
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create(); 
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        }
    };
    mainPanel.setOpaque(false); 

    GridBagConstraints gbc = new GridBagConstraints();

    // --- COLONNA SINISTRA ---
    JPanel leftPanel = new JPanel(new GridBagLayout());
    leftPanel.setOpaque(false);
    GridBagConstraints gbcLeft = new GridBagConstraints();

    ImageIcon iconaFreccia = new ImageIcon("immagini/freccia.png");
    Image imgFreccia = iconaFreccia.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    
    JButton backArrow = new JButton(new ImageIcon(imgFreccia)) {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paintComponent(g2d);
            g2d.dispose();
        }
    };
    backArrow.setContentAreaFilled(false);
    backArrow.setBorderPainted(false);
    backArrow.setFocusPainted(false);
    backArrow.addActionListener(e -> g.chiudoStat());

    gbcLeft.gridx = 0;
    gbcLeft.gridy = 0;
    gbcLeft.anchor = GridBagConstraints.NORTHWEST;
    gbcLeft.insets = new Insets(10, 10, 0, 0);
    leftPanel.add(backArrow, gbcLeft);

    // Pannello Personaggio
    JPanel personaggioPanel = new JPanel() {
        Image img = new ImageIcon("immagini/g" + (nC + 1) + ".png").getImage();
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (img != null) {
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
            g2d.dispose();
        }
    };
    personaggioPanel.setOpaque(false);

    gbcLeft.gridy = 1;
    gbcLeft.weightx = 1.0;
    gbcLeft.weighty = 1.0; 
    gbcLeft.fill = GridBagConstraints.BOTH;
    leftPanel.add(personaggioPanel, gbcLeft);

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0.3; 
    gbc.weighty = 1.0;
    mainPanel.add(leftPanel, gbc);

    // --- COLONNA DESTRA ---
    JPanel rightPanel = new JPanel(new GridBagLayout());
    rightPanel.setOpaque(false);
    GridBagConstraints gbcRight = new GridBagConstraints();

    // 1. Stats 
    JPanel statsPanel = new JPanel(){ 
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            super.paintComponent(g);
            
            int[] parametro= new int[c.getStat().length+2];
            for (int i = 0; i < c.getStat().length; i++) {
                parametro[i] = c.getStat()[i];
            }
            parametro[4]=c.getRisorse()[0];
            parametro[5]=c.getRisorse()[1];
            scriviStat(parametro,g2d);
        };
    };
    statsPanel.setOpaque(false);
    statsPanel.setBorder(BorderFactory.createTitledBorder(null, "Stats Player", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.WHITE));
    
    gbcRight.gridx = 0;
    gbcRight.gridy = 0;
    gbcRight.weightx = 1.0;
    gbcRight.weighty = 0.2;
    gbcRight.fill = GridBagConstraints.BOTH;
    rightPanel.add(statsPanel, gbcRight);

    // 2. Backpack 
    JPanel backpackPanel = new JPanel(new GridLayout(1, 3, 10, 10));
    backpackPanel.setOpaque(false);
    backpackPanel.setBorder(BorderFactory.createTitledBorder(null, "BackPack", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.WHITE));

    for (int i = 1; i < 4; i++) {
        final int index = i; 
        JPanel slot = new JPanel(new BorderLayout()) {
            Image sf = new ImageIcon("immagini/sfondoSlotInv.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                
                g2d.drawImage(sf, 0, 0, getWidth(), getHeight(), this);
                
                if (index < c.getInventario().oggetti.size() && c.getInventario().oggetti.get(index) != null) {
                    Image imgObj = new ImageIcon(c.getInventario().oggetti.get(index).getCollegamento()).getImage();
                    g2d.drawImage(imgObj, 5, 5, getWidth()-10, getHeight()-10, this);
                }
                g2d.dispose();
            }
        };
        slot.setOpaque(false);
        backpackPanel.add(slot);
    }

    gbcRight.gridy = 1;
    gbcRight.weighty = 0.3;
    rightPanel.add(backpackPanel, gbcRight);

    // 3. Arma
    JPanel weaponPanel = new JPanel() {
        Image img = new ImageIcon(c.getArma().getCollegamento()).getImage();
        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int w = getWidth();
                int h = getHeight();


                int imgW = img.getWidth(null);
                int imgH = img.getHeight(null);

                double scale = Math.min((double)w / imgW, (double)h / imgH) * 1.2;
                int drawW = (int)(imgW * scale);
                int drawH = (int)(imgH * scale);

                int x = (w - drawW) / 2;
                int y = (h - drawH) / 2;

                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);


                g2d.drawImage(img, x, y, drawW, drawH, this);
                g2d.dispose();
        }
    };
    weaponPanel.setOpaque(false);

    gbcRight.gridy = 2;
    gbcRight.weighty = 0.5;
    gbcRight.insets=new Insets(20,5,5,5);
    rightPanel.add(weaponPanel, gbcRight);

    // Finalizzazione mainPanel
    gbc.gridx = 1;
    gbc.weightx = 0.7; 
    mainPanel.add(rightPanel, gbc);
    
    this.setLayout(new BorderLayout());
    this.add(mainPanel); 
}

    public void scriviStat(int[] stats,Graphics2D g2d){
        String[] nomi = {"Vita","Attacco","Difesa","Velocità","Carne","Pelle"};
        int spazioSopra=30,distanzaRighe=20;
        
        for (int i = 0; i < stats.length; i++) {
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            g2d.setColor(Color.WHITE);
            g2d.drawString(nomi[i] + ": " + stats[i], 20, spazioSopra + i * distanzaRighe);
        }
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
