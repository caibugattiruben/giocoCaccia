/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
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
    JProgressBar scudo,vita;
    JPanel arma, panelAnimale,panel,mainPanel, panelKm;
    JTextArea textArea;
    JLabel lblTurni;
    
    public FormGioco(gestoreForm gi,int nC) {
        initComponents();
        
        this.g=gi;
        mainPanel=new JPanel();
        panel = new JPanel() {
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
        gbcSinistra.weightx=1.0;
        gbcSinistra.fill = GridBagConstraints.BOTH;
        gbcSinistra.insets = new Insets(5,5,5,5);

        // --- IMMAGINE CACCIATORE ---
        JButton immagineCacciatore = new JButton() {
            Image immagine = new ImageIcon("immagini/g"+nC+"Face.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        immagineCacciatore.addActionListener(e -> {
            this.w=this.getWidth();
            this.h=this.getHeight();
            g.aproStat(w,h);
        }); 
        immagineCacciatore.setContentAreaFilled(false);
        immagineCacciatore.setBorderPainted(false);
        immagineCacciatore.setOpaque(false);
        gbcSinistra.gridy = 0;
        gbcSinistra.gridheight = 1;
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
        
        panelStats.add(new JLabel(""));
        
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
            g.aperturaInventario(w,h,this);
        }); 
        zaino.setContentAreaFilled(false);
        zaino.setBorderPainted(false);
        panelInventario.setLayout(new BorderLayout());
        panelInventario.add(zaino);
        panelInventario.setOpaque(false);
        gbcSinistra.gridy = 3;
        gbcSinistra.gridheight = 1;
        gbcSinistra.weighty = 0.2;
        panelSX.add(panelInventario, gbcSinistra);

        // --- AGGIUNGO PANEL SX AL PANEL PRINCIPALE ---
        gbc = new GridBagConstraints(); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.20;
        gbc.weighty = 1.0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panelSX.setOpaque(false);
        panel.add(panelSX, gbc);
        
        
        //------------------------------------ CX ------------------------------------
        panelCX.setLayout(new GridBagLayout());
        GridBagConstraints gbcCentro = new GridBagConstraints();
        
        gbcCentro.gridx = 0;
        gbcCentro.fill = GridBagConstraints.BOTH;
        gbcCentro.weightx = 1.0;

        //KM
        gbcCentro.gridy = 0;
        gbcCentro.weighty = 0.2;

        lblTurni=new JLabel("PROGRESSO: 0/50 KM");
        panelKm=new JPanel();
        panelKm.setLayout(new BorderLayout());
        lblTurni.setFont(new Font("Arial", Font.BOLD, 20));
        lblTurni.setForeground(Color.WHITE);
        panelKm.add(lblTurni, BorderLayout.CENTER);
        panelKm.setOpaque(false);
        panelCX.add(panelKm, gbcCentro);
        
        //ANIMALE
        gbcCentro.gridy = 1;
        gbcCentro.weighty = 0.4;
        gbcCentro.insets = new Insets(50,70,5,70);
        panelAnimale=new JPanel();
        panelAnimale.setOpaque(false);
        panelAnimale.setLayout(new BorderLayout());
        panelCX.add(panelAnimale, gbcCentro);
        
        //VUOTO
        gbcCentro.insets = new Insets(0,0,0,0);
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
        avanza.addActionListener(e -> {
            g.incrementaTurno();
            aggiornaInterfacciaTurni();
            g.getCacciatore().ricaricaAbilita();
            g.evento();
        }); 
        panelCX.add(panelAvanza, gbcCentro);
        
        // --- AGGIUNGO PANEL CX AL PANEL PRINCIPALE ---
        gbc = new GridBagConstraints(); 
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.60; 
        gbc.weighty = 1.0;
        gbc.gridheight = 1; 
        gbc.fill = GridBagConstraints.BOTH;
        panelCX.setOpaque(false);
        panel.add(panelCX, gbc);
        
        


        //------------------------------------ DX (DESTRA) ------------------------------------
        panelDX.setLayout(new GridBagLayout());
        GridBagConstraints gbcDestra = new GridBagConstraints();

        gbcDestra.gridx = 0;
        gbcDestra.fill = GridBagConstraints.BOTH;
        gbcDestra.weightx = 1.0;
        gbcDestra.insets = new Insets(5, 5, 5, 5); 

        // --- IMPOSTAZIONI ---
        gbcDestra.gridy = 0;
        gbcDestra.weighty = 0.15; 

        JPanel panelImpostazioni = new JPanel(new GridLayout(3, 3, 10, 10));
        panelImpostazioni.setOpaque(false);

        for (int i = 0; i < 2; i++){
            panelImpostazioni.add(new JLabel(""));
        }

        JButton impostazioni = new JButton() {
            Image immagineIngr = new ImageIcon("immagini/ingranaggio.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(immagineIngr, 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        };
        impostazioni.setContentAreaFilled(false);
        impostazioni.setBorderPainted(false);
        impostazioni.addActionListener(e -> g.aproMercante());

        panelImpostazioni.add(impostazioni);
        for (int i = 0; i < 6; i++) panelImpostazioni.add(new JLabel("")); 

        panelDX.add(panelImpostazioni, gbcDestra);

        // --- TEXT AREA ---
        gbcDestra.gridy = 1;
        gbcDestra.weighty = 0.35; 

        textArea = new JTextArea(5,1);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(135,169,107)); 
        textArea.setForeground(Color.WHITE);

        JScrollPane scrollTextArea = new JScrollPane(textArea);
        scrollTextArea.setOpaque(false);
        scrollTextArea.getViewport().setOpaque(false);
        scrollTextArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0,40,36)), "LOG DI GIOCO", 0, 0, null, Color.WHITE));

        panelDX.add(scrollTextArea, gbcDestra);

        // --- 3. SPAZIO VUOTO (SEPARATOR) ---
        gbcDestra.gridy = 2;
        gbcDestra.weighty = 0.05;
        JPanel vuotoDX = new JPanel();
        vuotoDX.setOpaque(false);
        panelDX.add(vuotoDX, gbcDestra);

        // --- 4. SLOT ARMA EQUIPAGGIATA ---
        gbcDestra.gridy = 3;
        gbcDestra.weighty = 0.45; 

        arma = new JPanel() {
            Image immagineSfondoArma = new ImageIcon("immagini/sfondoArma.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(immagineSfondoArma, 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        };
        arma.setLayout(new BorderLayout());
        arma.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2)); 

        panelDX.add(arma, gbcDestra);

        // --- AGGIUNGO PANEL DX AL PANEL PRINCIPALE ---
        gbc = new GridBagConstraints(); 
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.20;
        gbc.weighty = 1.0;
        gbc.gridheight = 1; 
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        panelDX.setOpaque(false);
        panel.add(panelDX, gbc);
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel);
        //AGGIUNGO PANEL CON TUTTO AL FORM
        this.setLayout(new BorderLayout());
        this.add(mainPanel);
        
        
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
        
        arma.removeAll();

        JPanel arma1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image img = new ImageIcon(c.getCollegamento(c.getArma())).getImage();

                int panelW = getWidth();
                int panelH = getHeight();
                int imgW = img.getWidth(null);
                int imgH = img.getHeight(null);

                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.translate(panelW / 2.0, panelH / 2.0);

                g2d.rotate(Math.toRadians(-90));

                double scale = Math.min((double) panelH / imgW, (double) panelW / imgH);

                int drawW = (int) (imgW * scale);
                int drawH = (int) (imgH * scale);

                g2d.drawImage(img, -drawW / 2, -drawH / 2, drawW, drawH, this);

                g2d.dispose();
            }
        };

        arma1.setOpaque(false);
        arma.setLayout(new BorderLayout());
        arma.add(arma1, BorderLayout.CENTER);
        arma.revalidate();
        arma.repaint();
    }
    
    
    public void scriviMess(String mess){
        textArea.append(mess+"\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    public void setImmagineEvento(String path) {
        panelAnimale.removeAll(); 

        panelAnimale.setLayout(new BorderLayout()); 

        JPanel prov = new JPanel() {
            Image img = new ImageIcon(path).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (img != null) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                    g2d.dispose();
                }
            }
        };

        prov.setOpaque(false);


        panelAnimale.add(prov, BorderLayout.CENTER);
        
        

        panelAnimale.revalidate();
        panelAnimale.repaint();   
    }
    
    public boolean sceltaAccessoMerc(){
        while (true) {
            int scelta = JOptionPane.showConfirmDialog(null, "Vuoi accedere al mercante?", "Mercante", JOptionPane.YES_NO_OPTION);

            if (scelta == JOptionPane.YES_OPTION) {
                return true;
            } 
            else if (scelta == JOptionPane.NO_OPTION || scelta == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Non sei andato dal mercante", "Mercante", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
    }
    
    public void sceltaLottaAnimale(Animale a){
        boolean continua=true;
        while (continua) {
            int scelta = JOptionPane.showConfirmDialog(null, "Vuoi sparare all'animale?", "Animale", JOptionPane.YES_NO_OPTION);

            if (scelta == JOptionPane.YES_OPTION) {
                g.apriLotta(this.getWidth(),this.getHeight(),a);
                continua = false; 
            } 
            else if (scelta == JOptionPane.NO_OPTION || scelta == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Non hai sparato all'animale , lui scappa", "Animale", JOptionPane.INFORMATION_MESSAGE);
                continua = false; 
            }
        }
    }
    
    public void sceltaLottaAnimaleAgg(Animale a){
        Object[] opzioni = {"Lotta", "Scappa"};
        boolean continua=true;
        while (continua) {
            int scelta = JOptionPane.showOptionDialog(null, "Vuoi lottare o scappare?", "Animale Aggressivo", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opzioni, opzioni[0]);

            if (scelta == 0) {
                g.apriLotta(this.getWidth(),this.getHeight(),a);
                continua = false; 
            } 
            else{
                tentaFuga(a);
                continua = false; 
            } 
            
        }
    }
    
    private void tentaFuga(Animale anim) {
        int velCacciatore = g.getCacciatore().getVelocità();
        int velAnimale = ((AnimaleAggressivo) anim).getVel(); 

        double probabilita = Math.max(0.10, Math.min(0.80, 0.5 + (velCacciatore - velAnimale) * 0.05));

        if (Math.random() <= probabilita) {
            JOptionPane.showMessageDialog(this, "Fuga riuscita! Hai seminato il " + anim.getNome());
        } else {
            JOptionPane.showMessageDialog(this, "Fuga fallita! Il " + anim.getNome() + " ti ha raggiunto. Preparati a combattere!");
            g.apriLotta(this.getWidth(), this.getHeight(), anim);
        }
    }
    
    public void aggiornaInterfacciaTurni() {
        int attuale = g.getTurnoAttuale();
        int massimo = g.getTurnoMax();

        lblTurni.setText("PROGRESSO: " + attuale + " / " + massimo+" KM");

        panelKm.revalidate();
        panelKm.repaint();
        
        if (g.controllaVittoria()==true) {
            JOptionPane.showMessageDialog(this, "HAI VINTO! Sei sopravvissuto a 50 KM nella foresta!");
            System.exit(0);
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

