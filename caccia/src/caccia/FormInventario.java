/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caccia;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ruben
 */
public class FormInventario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormInventario.class.getName());
    
    gestoreForm g;

    /**
     * Creates new form FormInventario
     */
    public FormInventario(gestoreForm ge,int w,int h,JFrame formProv) {
        initComponents();
        
        this.setSize(w, h);
        
        this.g=ge;
        
        JPanel panel = new JPanel() {
            Image immagineZaino=new ImageIcon("immagini/zainoApero.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagineZaino, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new GridLayout(2,1,10,10));
        
        //-----------------------------------------SOPRA-----------------------------------------
        JPanel panelSopra=new JPanel();
        panelSopra.setLayout(new GridBagLayout());
        panelSopra.setOpaque(false);

        GridBagConstraints gbcSopra = new GridBagConstraints();
        gbcSopra.gridx = 0;
        gbcSopra.fill = GridBagConstraints.BOTH;
        gbcSopra.weightx = 1;

       // RIGA 0 
        gbcSopra.gridy = 0;
        gbcSopra.weighty = 0.4; 
        
        JPanel vuotoSopra = new JPanel();
        vuotoSopra.setOpaque(false);
        vuotoSopra.setLayout(new BorderLayout()); 

        JButton btnFreccia = new JButton(){
            Image immagine=new ImageIcon("immagini/freccia.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        };
        btnFreccia.setFocusPainted(false);
        btnFreccia.setContentAreaFilled(false); 
        btnFreccia.setBorderPainted(false); 
        
        JPanel contenitoreDestra = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contenitoreDestra.setOpaque(false);
        contenitoreDestra.add(btnFreccia);

        btnFreccia.addActionListener(e -> {
            g.chiusuraInventario(formProv);
        });

        vuotoSopra.add(contenitoreDestra, BorderLayout.NORTH);
        
        panelSopra.add(vuotoSopra, gbcSopra);

        // RIGA 1 
        gbcSopra.gridy = 1;
        gbcSopra.weighty = 0.6; 
        
        JPanel bottoni = new JPanel();
        bottoni.setLayout(new GridBagLayout());

        GridBagConstraints gbcBottoni = new GridBagConstraints();
        gbcBottoni.fill = GridBagConstraints.BOTH;
        gbcBottoni.weightx = 1;
        gbcBottoni.weighty = 1;

        // spazio tra gli oggetti
        gbcBottoni.insets = new Insets(20, 50, 20, 50);

        // OGGETTO 1 
        gbcBottoni.gridx = 0;
        gbcBottoni.gridy = 0;
        JPanel oggetto1 = new JPanel(){
            Image immagine=new ImageIcon("immagini/sfondoSlotInv.png").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        JPanel ogg1=new JPanel();
        ogg1.setOpaque(false);
        oggetto1.setLayout(new BorderLayout());
        oggetto1.add(ogg1);
        JButton btn1=new JButton("USA");
        oggetto1.add(btn1, BorderLayout.SOUTH);
        bottoni.add(oggetto1, gbcBottoni);

        // OGGETTO 2
        gbcBottoni.gridx = 1;
        JPanel oggetto2 = new JPanel(){
            Image immagine=new ImageIcon("immagini/sfondoSlotInv.png").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        JPanel ogg2=new JPanel();
        ogg2.setOpaque(false);
        oggetto2.setLayout(new BorderLayout());
        oggetto2.add(ogg2);
        JButton btn2=new JButton("USA");
        oggetto2.add(btn2, BorderLayout.SOUTH);
        bottoni.add(oggetto2, gbcBottoni);

        // OGGETTO 3 
        gbcBottoni.gridx = 2;
        JPanel oggetto3 = new JPanel(){
            Image immagine=new ImageIcon("immagini/sfondoSlotInv.png").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g); 
                    Graphics2D g2d = (Graphics2D) g.create();

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2d.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);

                    g2d.dispose();
                }
        };
        JPanel ogg3=new JPanel();
        ogg3.setOpaque(false);
        oggetto3.setLayout(new BorderLayout());
        oggetto3.add(ogg3);
        JButton btn3=new JButton("USA");
        oggetto3.add(btn3, BorderLayout.SOUTH);
        bottoni.add(oggetto3, gbcBottoni);
        
        bottoni.setOpaque(false);
        
        panelSopra.add(bottoni,gbcSopra);
        
        panel.add(panelSopra);
        
        //-----------------------------------------SOTTO-----------------------------------------
        JPanel panelSotto = new JPanel();
        panelSotto.setOpaque(false);
        panelSotto.setLayout(new GridBagLayout());

        GridBagConstraints gbcSotto = new GridBagConstraints();
        gbcSotto.gridx = 0;
        gbcSotto.gridy = 0;

        gbcSotto.weightx = 1;
        gbcSotto.weighty = 1;
        gbcSotto.fill = GridBagConstraints.BOTH;

        gbcSotto.insets = new Insets(40, 100, 40, 100);

        JPanel arma=new JPanel(){
            Image immagine=new ImageIcon("immagini/"+g.getArma()+".png").getImage();
            @Override
                protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int w = getWidth();
                int h = getHeight();


                int imgW = immagine.getWidth(null);
                int imgH = immagine.getHeight(null);

                double scale = Math.min((double)w / imgW, (double)h / imgH) * 1.2;
                int drawW = (int)(imgW * scale);
                int drawH = (int)(imgH * scale);

                int x = (w - drawW) / 2;
                int y = (h - drawH) / 2;

                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);


                g2d.drawImage(immagine, x, y, drawW, drawH, this);
                g2d.dispose();
        }
        };
        arma.setOpaque(false);

        panelSotto.add(arma, gbcSotto);

        panel.add(panelSotto);
        caricaBackpack( ogg1,ogg2,ogg3,g.getCacciatore(),btn1,btn2,btn3);
        this.setLayout(new BorderLayout());
        this.add(panel);
        
        
        
    }

    public void caricaBackpack(JPanel a1,JPanel a2,JPanel a3,Cacciatore c,JButton b1,JButton b2,JButton b3){
        
       Inventario inv=c.getInventario();
       JPanel[] panel={a1,a2,a3};
       JButton[] bottoni={b1,b2,b3};
       boolean[] accesi={false,false,false};
       
        for (Oggetto o : inv.getOggetti()) {
            if (!(o instanceof Arma)) {
                int index = inv.getOggetti().indexOf(o) - 1; 

                JPanel provv = new JPanel() {
                    Image immagine = new ImageIcon(o.getCollegamento()).getImage();
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g); 
                        Graphics2D g2d = (Graphics2D) g.create();
                        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        g2d.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
                        g2d.dispose();
                    }
                };

                provv.setOpaque(false);
                panel[index].setOpaque(false);
                panel[index].setLayout(new BorderLayout());
                panel[index].add(provv);
                accesi[index]=true;

                bottoni[index].addActionListener(e -> {
                    g.usoOggInv(o);
                    bottoni[index].setEnabled(false);

                    panel[index].removeAll();
                    panel[index].revalidate();
                    panel[index].repaint();
                });
            }
        }
        
        for(int i=0;i<accesi.length;i++){
            if(accesi[i]==false){
                bottoni[i].setEnabled(false);
            }
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
