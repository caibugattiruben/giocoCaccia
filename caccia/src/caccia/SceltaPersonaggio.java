/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ruben
 */
public class SceltaPersonaggio extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SceltaPersonaggio.class.getName());
    
    gestoreForm gest;
    SceltaPersonaggio gioco;
    int numCacciatore;
    JButton scegli ;

    public SceltaPersonaggio(gestoreForm g,int w,int h) {
        initComponents();
        
        this.setSize(w,h);
        
        this.gest=g;
        gioco=this;
        
        ArrayList<JButton> cacciatori = new ArrayList();
        ArrayList<String> dAbilita = new ArrayList();
        
        dAbilita.add("La mia abilità mi fa scappare dal nemico");
        dAbilita.add("La mia abilità riporta la vita al massimo");
        dAbilita.add("La mia abilità one shotta l'animale");
        dAbilita.add("La mia abilità para il prossimo attacco dell'animale");

        for (int i = 0; i < 4; i++) {
            Image immagine=new ImageIcon("immagini/g"+(i+1)+".png").getImage();
            
            JButton b=creoBottone(immagine,cacciatori);
            cacciatori.add(b);
        }

        JPanel panel = new JPanel() {
            Image imgSfondo = new ImageIcon("immagini/sceltaPersonaggio.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgSfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //panel in alto
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel panelUpp = new JPanel();
        panelUpp.setOpaque(false);
        panel.add(panelUpp, gbc);

        
        //panel con bottoni
        JPanel panelPiccolo = new JPanel();
        panelPiccolo.setLayout(new GridLayout(1, 4, 20, 20));
        panelPiccolo.setOpaque(false);
        for (JButton b : cacciatori) {
            JPanel p=new JPanel();
            p.setLayout(new BorderLayout());
            p.add(b,BorderLayout.CENTER );
            JButton info=new JButton("INFO ABILITA'");
            info.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, dAbilita.get(cacciatori.indexOf(b)), "ABILITA'", JOptionPane.INFORMATION_MESSAGE);
            }); 
            p.add(info,BorderLayout.SOUTH );
            p.setOpaque(false);
            panelPiccolo.add(p);
        }
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;   
        panel.add(panelPiccolo, gbc);

        //panel in fondo
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel panelDown = new JPanel();
        panelDown.setLayout(new GridLayout(1, 3, 20, 20));
        panelDown.setOpaque(false);
        panelDown.add(new JLabel(""));
        scegli= new JButton("Scegli cacciatore");
        scegli.setEnabled(false);
        scegli.addActionListener(e -> {
            gest.setNumero(numCacciatore);
            gest.sceltaPersonaggioCliccata();
            gest.creoGioco(gioco.getWidth(), gioco.getHeight());
        });
        panelDown.add(scegli);
        panelDown.add(new JLabel(""));
        panel.add(panelDown, gbc);
        
        
        this.setLayout(new BorderLayout());
        this.add(panel);
        
    }

    public JButton creoBottone(Image immagine,ArrayList<JButton> cacciatori){
        JButton b = new JButton(){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
            };
        
        b.addActionListener(e -> {
                numCacciatore=cacciatori.indexOf(b);
                scegli.setEnabled(true);
        }); 
        
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setFocusPainted(false);
        b.setOpaque(false);
        
        aggiungiListener(b,cacciatori);
        return b;
    }
    public void aggiungiListener(JButton b,ArrayList<JButton> cacciatori){
        b.addActionListener(e -> {
                for (JButton btn : cacciatori) {
                    btn.setBorder(null);
                }
                b.setBorderPainted(true);
                b.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        });  
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
            .addGap(0, 872, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
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
