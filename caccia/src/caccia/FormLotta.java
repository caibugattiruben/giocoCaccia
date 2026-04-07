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
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author ruben
 */
public class FormLotta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormLotta.class.getName());

    gestoreForm gestore;
    Animale animale;
    JTextArea statAnim;
    JProgressBar pbNem,pbPers;
    JLabel statPlayer;
    
    /**
     * Creates new form FormLotta
     */
    public FormLotta(gestoreForm g,int w,int h,int nc,Animale a) {
        initComponents();
        
        this.setSize(w,h);
        
        this.gestore=g;
        this.animale=a;
        
        this.setSize(w, h);
        this.setLayout(new BorderLayout());

        // --- PANEL ---
        JPanel panel = new JPanel(new GridBagLayout()){
            Image img = new ImageIcon("immagini/sfondoGIoco.JPG").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.fill = GridBagConstraints.BOTH;
        gbcMain.weightx = 1.0;

        // --- P1 ---
        JPanel pnlP1 = new JPanel(new GridLayout(1, 2, 40, 0));
        pnlP1.setOpaque(false);
        pnlP1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //COLONNA PERSONAGGIO
        JPanel pnlP3 = new JPanel(new GridBagLayout());
        pnlP3.setOpaque(false);
        GridBagConstraints gbcP3 = new GridBagConstraints();
        gbcP3.fill = GridBagConstraints.BOTH;
        gbcP3.weightx = 1.0;

        // Vita e Danno
        JPanel pnlVitaPers = new JPanel(new GridLayout(2, 1, 0, 5));
        pnlVitaPers.setOpaque(false);
        pbPers = new JProgressBar(){
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
        pbPers.setValue(g.getCacciatore().getVita());
        pbPers.setMinimum(0);
        pbPers.setMaximum(100);
        pbPers.setString("VITA " + pbPers.getValue() + "%");
        pbPers.setForeground(new Color(206,48,24));
        pbPers.setBackground(new Color(170,0,0));
        pbPers.setStringPainted(true);
        pnlVitaPers.add(pbPers);
        statPlayer=new JLabel();
        pnlVitaPers.add(statPlayer);

        gbcP3.gridy = 0;
        gbcP3.weighty = 0.3;
        gbcP3.insets = new Insets(20, 0, 10, 0); 
        pnlP3.add(pnlVitaPers, gbcP3);

        // Foto Personaggio 
        JPanel fotoPers = new JPanel(){
            Image img = new ImageIcon("immagini/g"+(nc+1)+".png").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        fotoPers.setOpaque(false);
        fotoPers.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        gbcP3.gridy = 1;
        gbcP3.weighty = 0.7;
        gbcP3.insets = new Insets(0, 0, 0, 0); 
        pnlP3.add(fotoPers, gbcP3);
        pnlP1.add(pnlP3);

        // COLONNA ANIMALE
        JPanel pnlP4 = new JPanel(new GridBagLayout());
        pnlP4.setOpaque(false);
        GridBagConstraints gbcP4 = new GridBagConstraints();
        gbcP4.fill = GridBagConstraints.BOTH;
        gbcP4.weightx = 1.0;

        // Stats Nemico 
        JPanel pnlStatsNem = new JPanel(new GridLayout(2, 1, 0, 5));
        pnlStatsNem.setOpaque(false);
        pbNem = new JProgressBar(){
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
        if(animale instanceof AnimaleCacciagione ){
            AnimaleCacciagione a1=(AnimaleCacciagione) animale;
            pbNem.setValue(a1.getVita());
        }
        else if(animale instanceof AnimaleAggressivo){
            AnimaleAggressivo a1=(AnimaleAggressivo) animale;
            pbNem.setValue(a1.getVita());
        }
        
        pbNem.setMinimum(0);
        pbNem.setMaximum(100);
        pbNem.setString("VITA " + pbNem.getValue() + "%");
        pbNem.setForeground(new Color(206,48,24));
        pbNem.setBackground(new Color(170,0,0));
        pbNem.setStringPainted(true);
        pnlStatsNem.add(pbNem);
        
        statAnim=new JTextArea();
        statAnim.setEditable(false);    
        statAnim.setOpaque(false);     
        statAnim.setFocusable(false);
        statAnim.setLineWrap(true);
        statAnim.setFont(new Font("Arial", Font.BOLD, 15));
        statAnim.setForeground(Color.WHITE);
        pnlStatsNem.add(statAnim);

        gbcP4.gridy = 0;
        gbcP4.weighty = 0.3;
        gbcP4.insets = new Insets(20, 0, 10, 0); 
        pnlP4.add(pnlStatsNem, gbcP4);

        // Foto Animale
        JPanel fotoAnim = new JPanel(){
            Image img = new ImageIcon(animale.getPath()).getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        fotoAnim.setOpaque(false);
        fotoAnim.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        gbcP4.gridy = 1;
        gbcP4.weighty = 0.7;
        gbcP4.insets = new Insets(0, 0, 0, 0);
        pnlP4.add(fotoAnim, gbcP4);
        pnlP1.add(pnlP4);

        gbcMain.gridy = 0;
        gbcMain.weighty = 0.8;
        panel.add(pnlP1, gbcMain);

        // --- P2 ---
        JPanel pnlP2 = new JPanel(new GridLayout(1, 3, 30, 0)); 
        pnlP2.setOpaque(false);
        pnlP2.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton attacco=new JButton("ATTACCO");
        attacco.addActionListener(e -> {
            riproduciSparo();
            lotta();
            
        });
        JButton abilità=new JButton("ABILITA'");
        abilità.addActionListener(e ->{
            Cacciatore c = gestore.getCacciatore();
            String msg = c.usaAbilita(animale);

            if (msg.equals("SCATTO FELINO")) {
                JOptionPane.showMessageDialog(this, "Velocità massima! Sei scappato dalla lotta!");
                this.dispose();
                gestore.aproGioco(this.getWidth(),this.getHeight());
            } 
            else {
                JOptionPane.showMessageDialog(this, msg);
                aggiornaBarre();

                if (animale.getVita() <= 0) {
                    concludiBattagliaVittoria();
                }
            }
        });
        JButton inventario=new JButton("INVENTARIO");
        inventario.addActionListener(e -> g.aperturaInventario(this.getWidth(),this.getHeight(),this));
        
        pnlP2.add(attacco);
        pnlP2.add(abilità);
        pnlP2.add(inventario);

        gbcMain.gridy = 1;
        gbcMain.weighty = 0.2;
        panel.add(pnlP2, gbcMain);

        this.add(panel, BorderLayout.CENTER);
        
        loadStat(animale,g.getCacciatore(),statPlayer);
        
        this.setVisible(true);
    }
        
    public void loadStatAnimale(Animale anim){
        String info = "--- INFO NEMICO ---\n";

        if (anim instanceof AnimaleCacciagione) {
            AnimaleCacciagione c = (AnimaleCacciagione) anim;
            info += "Tipo: Cacciagione\n";
            info += "Pelle: " + c.getPelle() + "\n";
            info += "Carne: " + c.getCarne() + " kg";
        } 
        else if (anim instanceof AnimaleAggressivo) {
            AnimaleAggressivo a = (AnimaleAggressivo) anim;
            info += "Tipo: Aggressivo\n";
            info += "Attacco: " + a.getAttacco() + "\n";
            info += "Velocità: " + a.getVel();
        }

        statAnim.setText(info);
    }
    
    public void loadStatPers(Cacciatore c, JLabel label){
        label.setText("Danno: "+c.getDanno());
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
    }
    
    public void loadStat(Animale a,Cacciatore c,JLabel l){
        loadStatAnimale(a);
        loadStatPers(c,l);
    }
    
    public void lotta(){
        attaccoGiocatore();

        if (animale.getVita() <= 0) {
            concludiBattagliaVittoria();
            return;
        }

        if (animale instanceof AnimaleAggressivo) {
            rispostaNemica();
        }
        
        
    }
    
    public void attaccoGiocatore(){
        int danno = gestore.getCacciatore().getDanno();
        animale.setVita(Math.max(0, animale.getVita() - danno));

        pbNem.setValue(animale.getVita());
        pbNem.setString("VITA: " + animale.getVita() + "%");

        loadStatAnimale(animale);
    }
    
    public void rispostaNemica() {
        AnimaleAggressivo nemico = (AnimaleAggressivo) animale;
        int dannoBase = nemico.getAttacco(); 
        int scudo = gestore.getCacciatore().getScudo();

        double riduzione = 100.0 / (100.0 + scudo);
        int dannoEffettivo = (int) (dannoBase * riduzione);

        if (dannoEffettivo < 1) dannoEffettivo = 1;

        gestore.getCacciatore().setVita(-dannoEffettivo);

        pbPers.setValue(gestore.getCacciatore().getVita());
        pbPers.setString("VITA: " + pbPers.getValue() + "%");


        if (gestore.getCacciatore().getVita() <= 0) {
            JOptionPane.showMessageDialog(this, "Sei stato sconfitto!");
            System.exit(0);
        }
    }
    
    public void concludiBattagliaVittoria() {
        String msg = "VITTORIA! Hai sconfitto il " + animale.getNome();

        if (animale instanceof AnimaleCacciagione) {
            AnimaleCacciagione c = (AnimaleCacciagione) animale;
            msg += "\nRisorse ottenute: Carne (" + c.getCarne() + "), Pelle (" + c.getPelle() + ")";
            int[] ris={c.getCarne(),c.getPelle()};
            gestore.getCacciatore().setRisorse(ris);
        }

        JOptionPane.showMessageDialog(this, msg);

        this.dispose();
        gestore.aproGioco(this.getWidth(),this.getHeight());
    }
    
    public void aggiornaBarre() {
        int vitaCacciatore = gestore.getCacciatore().getVita();
        int vitaAnimale = animale.getVita();

        pbPers.setValue(vitaCacciatore);
        pbPers.setString("VITA: " + vitaCacciatore + "%");

        int vitaGraficaNemico = Math.max(0, vitaAnimale);
        pbNem.setValue(vitaGraficaNemico);
        pbNem.setString(animale.getNome().toUpperCase() + ": " + vitaGraficaNemico + " HP");

    }
    public void riproduciSparo() {
        try {
            File fileAudio = new File("suoni/sparo.wav"); 
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);

            Clip clip = AudioSystem.getClip();

            clip.open(audioStream);

            clip.start();

        } catch (Exception ex) {
        }
    }
    
   public void refreshDati() {
        Cacciatore c = gestore.getCacciatore();

        pbPers.setValue(c.getVita());
        pbPers.setString("VITA " + c.getVita() + "%");

        loadStatAnimale(animale); 

        loadStatPers(c, statPlayer);

        this.revalidate();
        this.repaint();
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
