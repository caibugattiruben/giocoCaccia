/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

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
    private int w,h;
    private int numCacciatore;
    JProgressBar scudo,vita;
    JPanel arma;
    
    public FormGioco(gestoreForm gi,int nC) {
        initComponents();
        
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
        
        //------------------------------------ SX ------------------------------------
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
        panelStats.setLayout(new GridLayout(3,1,40,40));
        panelStats.setOpaque(false);
        gbcSinistra.gridy = 1;
        gbcSinistra.gridheight = 1;
        gbcSinistra.weighty = 0.1;
        
        panelStats.add(new JLabel(""));//per farle piu basse e fine
        
        //VITA
        vita=new JProgressBar(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

                int arc = getHeight();
                int width = getWidth();
                int height = getHeight();

                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, width, height, arc, arc);

                int progress = (int) (width * getPercentComplete());
                g2.setPaint(new GradientPaint(0, 0, getForeground().brighter(),getWidth(), 0, getForeground().darker()));
                g2.fillRoundRect(0, 0, progress, height, arc, arc);

                if (isStringPainted()) {
                    String text = getString();
                    FontMetrics fm = g2.getFontMetrics();

                    int x = (width - fm.stringWidth(text)) / 2;
                    int y = (height - fm.getHeight()) / 2 + fm.getAscent();

                    g2.setColor(Color.WHITE);
                    g2.drawString(text, x, y);
                }
                
                g2.dispose();
            }
        };
        vita.setMinimum(0);
        vita.setMaximum(100);
        vita.setString("VITA " + vita.getValue() + "%");
        vita.setForeground(new Color(206,48,24));
        vita.setBackground(new Color(170,0,0));
        vita.setStringPainted(true);
        panelStats.add(vita);
        
        //SCUDO
        scudo=new JProgressBar(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

                int arc = getHeight();
                int width = getWidth();
                int height = getHeight();

                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, width, height, arc, arc);

                int progress = (int) (width * getPercentComplete());
                g2.setColor(getForeground());
                g2.fillRoundRect(0, 0, progress, height, arc, arc);

                if (isStringPainted()) {
                    String text = getString();
                    FontMetrics fm = g2.getFontMetrics();

                    int x = (width - fm.stringWidth(text)) / 2;
                    int y = (height - fm.getHeight()) / 2 + fm.getAscent();

                    g2.setColor(Color.WHITE);
                    g2.drawString(text, x, y);
                }
                
                g2.dispose();
            }
        };
        scudo.setMinimum(0);
        scudo.setMaximum(100);
        scudo.setString("SCUDO " + vita.getValue() + "%");
        scudo.setForeground(new Color(30,144,255));
        scudo.setBackground(new Color(65,105,225));
        scudo.setStringPainted(true);
        panelStats.add(scudo);
        
        panelSX.add(panelStats, gbcSinistra);
        

        // --- SPAZIO VUOTO ---
        JPanel vuotoSX = new JPanel();
        vuotoSX.setOpaque(false);
        gbcSinistra.gridy = 2;
        gbcSinistra.gridheight = 1;
        gbcSinistra.weighty = 0.4;
        panelSX.add(vuotoSX, gbcSinistra);

        // --- INVENTARIO ---
        JPanel panelInventario = new JPanel();
        JButton zaino=new JButton(){
            Image immagineZaino = new ImageIcon("immagini/zaino.png").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(immagineZaino, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        zaino.addActionListener(e -> {
            aggiornaGrandezze();
            g.aperturaInventario(w,h);
        }); 
        panelInventario.setLayout(new BorderLayout());
        panelInventario.add(zaino);
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
        
        //------------------------------------ CX ------------------------------------
        panelCX.setLayout(new GridBagLayout());
        GridBagConstraints gbcCentro = new GridBagConstraints();
        
        gbcCentro.gridx = 1;
        gbcCentro.fill = GridBagConstraints.BOTH;
        gbcCentro.weightx = 1.0;

        //KM
        gbcCentro.gridy = 0;
        gbcCentro.weighty = 0.2;

        JPanel panelKm=new JPanel();
        panelKm.setOpaque(false);
        panelCX.add(panelKm, gbcCentro);
        
        //ANIMALE
        gbcCentro.gridy = 1;
        gbcCentro.weighty = 0.4;
        JPanel panelAnimale=new JPanel();
        panelAnimale.setOpaque(false);
        panelCX.add(panelAnimale, gbcCentro);
        
        //VUOTO
        gbcCentro.gridy = 2;
        gbcCentro.weighty = 0.2;

        JPanel panelVuoto=new JPanel();
        panelVuoto.setOpaque(false);
        panelCX.add(panelVuoto, gbcCentro);
        
        //AVANZA
        gbcCentro.gridy = 3;
        gbcCentro.weighty = 0.2;

        JPanel panelAvanza=new JPanel();
        JButton avanza=new JButton("AVANZA");
        panelAvanza.setLayout(new GridLayout(3,3,20,20));
        for(int i=0;i<4;i++){
            panelAvanza.add(new JLabel(""));
        }
        panelAvanza.add(avanza);
        for(int i=0;i<4;i++){
            panelAvanza.add(new JLabel(""));
        }
        panelAvanza.setOpaque(false);
        panelCX.add(panelAvanza, gbcCentro);
        
        // --- AGGIUNGO PANEL CX AL PANEL PRINCIPALE ---
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        panelCX.setOpaque(false);
        
        panel.add(panelCX, gbc);
        
        
        gbc = new GridBagConstraints();
        //------------------------------------ DX ------------------------------------
        panelDX.setLayout(new GridBagLayout());
        GridBagConstraints gbcDestra = new GridBagConstraints();
        
        gbcDestra.gridx = 2;
        gbcDestra.fill = GridBagConstraints.BOTH;
        gbcDestra.weightx = 1.0;
        
        //IMPOSTAZIONI
        gbcDestra.gridy = 0;
        gbcDestra.weighty = 0.1;
        
        JPanel panelImpostazioni=new JPanel();
        panelImpostazioni.setLayout(new GridLayout(3,3,20,20));
        for(int i=0;i<2;i++){
            panelImpostazioni.add(new JLabel(""));
        }
        JButton impostazioni=new JButton(){
            Image immagineIngr=new ImageIcon("immagini/ingranaggio.png").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(immagineIngr, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        panelImpostazioni.add(impostazioni);
        for(int i=0;i<6;i++){
            panelImpostazioni.add(new JLabel(""));
        }
        
        panelDX.add(panelImpostazioni,gbcDestra);
        
        //TEXT AREA
        gbcDestra.gridy = 1;
        gbcDestra.weighty = 0.3;
        
        JPanel panelTextArea=new JPanel();
        JTextArea textArea=new JTextArea();
        //mettere che non è modificabile
        panelTextArea.add(textArea);
        
        panelDX.add(panelTextArea,gbcDestra);
        
        //VUOTO
        gbcDestra.gridy = 2;
        gbcDestra.weighty = 0.1;
        
        JPanel vuotoDX=new JPanel();
        
        panelDX.add(vuotoDX,gbcDestra);
        
        //ARMA
        gbcDestra.gridy = 3;
        gbcDestra.weighty = 0.5;
        
        arma = new JPanel(){
            Image immagine=new ImageIcon("immagini/sfondoArma.jpg").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };;
        arma.setLayout(new BorderLayout());
        
        panelDX.add(arma,gbcDestra);
        
        // --- AGGIUNGO PANEL DX AL PANEL PRINCIPALE ---
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.25;
        gbc.weighty = 1.0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        panelDX.setOpaque(false);
        
        panel.add(panelDX, gbc);
        
        
        //AGGIUNGO PANEL CON TUTTO AL FORM
        this.setLayout(new BorderLayout());
        this.add(panel);
        
        
    }
    
    public void aggiornaGrandezze(){
        this.w=this.getWidth();
        this.h=this.getHeight();
    }
    
    public void caricaPersonaggio(Cacciatore c){
        vita.setValue(c.getVita());
        vita.setString("VITA " + c.getVita() + "%");
        vita.repaint();

        scudo.setValue(c.getScudo());
        scudo.setString("SCUDO " + c.getScudo() + "%");
        scudo.repaint();

        JPanel arma1 = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int w = getWidth();
            int h = getHeight();

            Image img = new ImageIcon(c.getCollegamento(c.inventario.oggetti.get(0))).getImage();

            int imgW = img.getWidth(null);
            int imgH = img.getHeight(null);

            double scale = Math.min((double)w / imgW, (double)h / imgH) * 1.2;
            int drawW = (int)(imgW * scale);
            int drawH = (int)(imgH * scale);

            int x = (w - drawW) / 2;
            int y = (h - drawH) / 2;

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g2d.rotate(Math.toRadians(-90), w / 2.0, h / 2.0);

            g2d.drawImage(img, x, y, drawW, drawH, null);
            g2d.dispose();
        }
    };

        arma1.setOpaque(false);
        arma.add(arma1);
        arma.revalidate();
        arma.repaint();
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
