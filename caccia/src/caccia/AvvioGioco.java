/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caccia;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author caibugatti.ruben
 */
public class AvvioGioco extends javax.swing.JFrame {
    
    gestoreForm g;
    AvvioGioco gioco;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AvvioGioco.class.getName());

    /**
     * Creates new form AvvioGioco
     */
    public AvvioGioco(gestoreForm g) {
        initComponents();
        
        this.g=g;
        gioco=this;
        
        riproduciSottofondo();
        Image immagineIngr=new ImageIcon("immagini/ingranaggio.png").getImage();
        
        JPanel panel = new JPanel() {
            Image immagineSfondoGioco=new ImageIcon("immagini/sfondo.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagineSfondoGioco, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        
        //panel vuoto
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.5 ;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel vuoto1=new JPanel();
        vuoto1.setOpaque(false);
        panel.add(vuoto1,gbc);
                
        
        
        //bottoniCentro
        gbc.gridx =  0;
        gbc.gridy = 1;
        gbc.weightx = -0.7;
        gbc.weighty = 0.5;
        gbc.insets=new Insets(50,150,100,150);
        JPanel tasti=new JPanel();
        tasti.setLayout(new GridLayout(3,1,20,20));
        JButton newGame=new JButton(){
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    
                    Image img=new ImageIcon("immagini/newGame.png").getImage();
                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setFocusPainted(false);
        newGame.setOpaque(false);
        JButton loadGame=new JButton(){
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    Image img=new ImageIcon("immagini/loadGame.png").getImage();
                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        loadGame.setBorderPainted(false);
        loadGame.setContentAreaFilled(false);
        loadGame.setFocusPainted(false);
        loadGame.setOpaque(false);
        JButton exit=new JButton(){
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    Image img=new ImageIcon("immagini/exit.png").getImage();
                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                    
                    g2d.dispose();
                }
        };
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setFocusPainted(false);
        exit.setOpaque(false);
        
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int w = gioco.getWidth();
                int h = gioco.getHeight();
                g.newGameScelto(w,h);
            }
        });
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int w = gioco.getWidth();
                int h = gioco.getHeight();
                g.aproSalvataggio(w,h,gioco,false);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        tasti.setOpaque(false);
        tasti.add(newGame);
        tasti.add(loadGame);
        tasti.add(exit);
        panel.add(tasti,gbc);
        
        gbc.insets=new Insets(0,0,0,0);
        
        //destra
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.6;
        gbc.weighty = 0.5;
        
        JPanel vuoto3=new JPanel();
        vuoto3.setOpaque(false);
        panel.add(vuoto3,gbc);
        
        
        //destrapiccolo
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.3;
        
        JPanel vuoto4=new JPanel();
        vuoto4.setOpaque(false);
        vuoto4.setLayout(new GridLayout(2,1,20,20));
        JPanel imp=new JPanel();
        imp.setOpaque(false);
        imp.setLayout(new GridLayout(3,3,20,20));
        JButton impostazioni=new JButton(){
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(immagineIngr, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        impostazioni.setBorderPainted(false);
        impostazioni.setContentAreaFilled(false);
        impostazioni.setFocusPainted(false);
        impostazioni.setOpaque(false);
        impostazioni.addActionListener(e -> {
            String manuale = "--- GUIDA COMPLETA DI CACCIA ---\n\n" +
                "1. OBIETTIVO E PROGRESSIONE\n" +
                "   Il tuo scopo è percorrere 50 KM nella foresta.\n" +
                "   Ogni chilometro può nascondere un'insidia o un'opportunità.\n\n" +
                "2. STATISTICHE PERSONAGGIO\n" +
                "   - VITA: La tua salute. Se scende a 0, la partita termina.\n" +
                "   - SCUDO: Protegge la vita assorbendo i danni nemici.\n" +
                "   - VELOCITÀ: Influenza la tua capacità di fuggire.\n" +
                "   - DANNO: La potenza dei tuoi attacchi contro le prede.\n" +
                "   - CURE: Usa gli oggetti medici per ripristinare la salute.\n\n" +
                "3. IL MERCANTE E LE RISORSE\n" +
                "   Incontra il Mercante durante il viaggio per scambiare Carne e Pelle.\n" +
                "   - ACQUISTA: Armi migliori (come la Carabina), kit di cura, scarpe per aumentare la velocità oppure giacconi che ti faranno da scudo contro gli animali.\n"+
                "4. EVENTI CASUALI E BESTIARIO:\n" +
                "   Ogni KM può attivare imboscate, ritrovamenti o meteo avverso.\n" +
                "   Animali:\n" +
                "   - PACIFICI: Inoffensivi (es. Scoiattolo, Gatto).\n" +
                "   - CACCIAGIONE: Offrono risorse ma scappano (es. Cervo, Cinghiale).\n" +
                "   - AGGRESSIVI: Ti attaccano direttamente (es. Lupo, Orso).\n" +
                "5. SALVATAGGIO:\n" +
                "   Usa il menu di salvataggio per salvare i progressi.\n";

            JOptionPane.showMessageDialog(null, manuale, "Manuale del Cacciatore", JOptionPane.INFORMATION_MESSAGE);
        });
        
        for(int i=0;i<9;i++){
            if(i==8){
                imp.add(impostazioni);
            }
            else{
                imp.add(new JLabel(""));
            }
        }
        JPanel ciao=new JPanel();
        ciao.setOpaque(false);
        vuoto4.add(ciao);
        vuoto4.add(imp);
        panel.add(vuoto4,gbc);

        
        
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(panel);
        this.setBounds(0, 0, 830, 650);
    }
    public void riproduciSottofondo() {
        try {
            File fileAudio = new File("suoni/sottofondo.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);

            Clip musica = AudioSystem.getClip();
            musica.open(audioStream);

            musica.loop(Clip.LOOP_CONTINUOUSLY);

            musica.start();

        } catch (Exception ex) {
         
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
