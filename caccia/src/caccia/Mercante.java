/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caccia;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author caibugatti.ruben
 */
public class Mercante extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Mercante.class.getName());
    gestoreForm g;
    JPanel oggettoInt;
    JLabel carne,pelle;
    Oggetto[] oggMercante;
    ArrayList<JButton> bottoni=new ArrayList();
    /**
     * Creates new form Mercante
     */
    public Mercante(gestoreForm g,int w,int h) {
        initComponents();

        this.setSize(w, h);
        this.g=g;
        
        
        oggMercante=oggettiMercante();
        
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
        vuotoSX.add(new JLabel(" "));
        gbcSopra.gridx = 0;
        gbcSopra.weightx = 0.90;
        
        
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
        
        btnFreccia.addActionListener(e -> {
            g.chiudoMercante();
        });
        
        JPanel contenitoreDestra = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contenitoreDestra.setOpaque(false);
        contenitoreDestra.add(btnFreccia);
        
        
        vuotoSX.add(contenitoreDestra);
        sopra.add(vuotoSX, gbcSopra);
       

        // Pannello info a destra
        JPanel info = new JPanel();
        info.setLayout(new GridBagLayout());
        info.setOpaque(false);
        
        GridBagConstraints gbcInfo = new GridBagConstraints();
        gbcInfo.insets = new Insets(5,0,0,5);
        gbcInfo.gridy = 0;

        // -------- RIGA 1 --------
        
        
        // pannellino
        gbcInfo.gridx = 0;
        gbcInfo.weightx = 0;
        gbcInfo.fill = GridBagConstraints.NONE;
        gbcInfo.anchor = GridBagConstraints.WEST;

        JPanel piccolo1 = new JPanel(){
            Image immagine = new ImageIcon("immagini/carne.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        };
        piccolo1.setOpaque(false);
        info.add(piccolo1, gbcInfo);

        // label 1
        gbcInfo.gridx = 1;
        gbcInfo.weightx = 0.5;
        gbcInfo.fill = GridBagConstraints.HORIZONTAL;

        info.add(new JLabel("CARNE"), gbcInfo);

        // label 2
        gbcInfo.gridx = 2;
        gbcInfo.weightx = 0.5;
        
        carne=new JLabel("");
        info.add(carne, gbcInfo);

        // -------- RIGA 2 --------
        gbcInfo.gridy = 1;

        // pannellino
        gbcInfo.gridx = 0;
        gbcInfo.weightx = 0;
        gbcInfo.fill = GridBagConstraints.NONE;

        JPanel piccolo2 = new JPanel(){
            Image immagine = new ImageIcon("immagini/pelle.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        };
        piccolo2.setOpaque(false);
        info.add(piccolo2, gbcInfo);

        // label 3
        gbcInfo.gridx = 1;
        gbcInfo.weightx = 0.5;
        gbcInfo.fill = GridBagConstraints.HORIZONTAL;

        info.add(new JLabel("PELLE"), gbcInfo);

        // label 4
        gbcInfo.gridx = 2;
        gbcInfo.weightx = 0.5;

        pelle=new JLabel("");
        info.add(pelle, gbcInfo);


        gbcSopra.gridx = 1;
        gbcSopra.weightx = 0.1;
        gbcSopra.insets=new Insets(30,0,0,20);
        sopra.add(info, gbcSopra);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.1; 
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
        ogg1.setOpaque(false);
        creoOggInt(ogg1,0);
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
        ogg2.setOpaque(false);
        creoOggInt(ogg2,1);
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
        ogg3.setOpaque(false);
        creoOggInt(ogg3,2);
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
        
        
        setRisorse();

        
        
        this.setLayout(new BorderLayout());
        this.add(panel);
        
        
        
    }
    
    public void creoOggInt(JPanel p,int pos){
        p.setLayout(new BorderLayout());
        oggettoInt=new JPanel(){
            Image immagine = new ImageIcon(oggMercante[pos].getCollegamento()).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        };
        oggettoInt.setLayout(new BorderLayout());
        int[] prezzi=aggPrezzo(oggettoInt,oggMercante[pos]);
        oggettoInt.setOpaque(false);
        p.add(oggettoInt);
        JButton btncompra=new JButton("COMPRA");
        bottoni.add(btncompra);
        btncompra.addActionListener(e -> {
            if(controlloInvenatarioPieno(g.getCacciatore())==true){
            JOptionPane.showMessageDialog(null, "INVENTARIO PIENO", "INVENTARIO", JOptionPane.WARNING_MESSAGE);
        }
        else{
            compra(oggMercante[pos]);
            btncompra.setEnabled(false);
            }
        });
        
        p.add(btncompra,BorderLayout.SOUTH); 
        
        controlloAttivo(btncompra,prezzi);
        JPanel info=new JPanel();
        info.setOpaque(false);
        info.setLayout(new BorderLayout());
        JButton info1=new JButton();
        info1.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, getMessaggio(oggMercante[pos]), "Info Oggetto", JOptionPane.INFORMATION_MESSAGE);
        });
        info.add(info1,BorderLayout.WEST);
        p.add(info,BorderLayout.NORTH);
    }
    
    public int[] aggPrezzo(JPanel chi,Oggetto o){
        JPanel contPrezzo=new JPanel();
        contPrezzo.setLayout(new GridLayout(1,3,0,0));
        
        contPrezzo.add(new JLabel(""));
        JPanel prezzo=new JPanel();
        prezzo.setOpaque(false);
        prezzo.setLayout(new GridLayout(1,4,0,0));
        
        int[] prezzoCCC=o.getCosto();
        JLabel prezzoC=new JLabel(prezzoCCC[0]+"");
        JLabel prezzoP=new JLabel(prezzoCCC[1]+"");
        
        prezzo.add(prezzoC);
        JPanel simbCarne=new JPanel(){
            Image immagine = new ImageIcon("immagini/carne.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        };
        simbCarne.setOpaque(false);
        prezzo.add(simbCarne);
        
        prezzo.add(prezzoP);
        JPanel simPelle=new JPanel(){
            Image immagine = new ImageIcon("immagini/pelle.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        };
        simPelle.setOpaque(false);
        prezzo.add(simPelle);
        
        contPrezzo.add(prezzo);
        contPrezzo.add(new JLabel(""));
        
        chi.add(contPrezzo,BorderLayout.SOUTH);
        chi.revalidate();
        chi.repaint();
        
        return prezzoCCC;
    }
    
    public String getMessaggio(Oggetto o){
        String messaggio="";
        
        if (o instanceof Arma) {
            Arma a = (Arma) o;
            messaggio = "Arma: " + a.getNome() + "\nDanno: " + a.getDanno();
        } 
        else if (o instanceof Cura) {
            Cura c = (Cura) o;
            messaggio = "Cura: " + c.getNome() + "\nVita aggiunta: " + c.getValore();
        } 
        else if (o instanceof Scarpe) {
            Scarpe s = (Scarpe) o;
            messaggio = "Scarpe: " + s.getNome() + "\nVelocità: " + s.getVelocita();
        } 
        else if (o instanceof Vestito) {
            Vestito v = (Vestito) o;
            messaggio = "Vestito: " + v.getNome() + "\nDifesa: " + v.getDifesa();
        } 
        return messaggio;
    }
    
    public Oggetto[] oggettiMercante(){
        Oggetto[] oggMerc=new Oggetto[3];
        Random rdn=new Random();
        
        int oggMigl= rdn.nextInt(0,4);
        int pos= rdn.nextInt(0,3);
            
        switch (oggMigl) {
            case 0: oggMerc[pos] = new Arma("Carabina","immagini/carabina.png",100,10,10); break;
            case 1: oggMerc[pos] = new Cura("Ampolla magica","immagini/ampollaMagica.png",100,10,10); break;
            case 2: oggMerc[pos] = new Scarpe("Scarpe veloci","immagini/scarpe1.png",100,10,10); break;
            case 3: oggMerc[pos] = new Vestito("Vestito pesante","immagini/vestito1.png",100,10,10); break;
        }

        for (int i = 0; i < oggMerc.length; i++) {
            if (oggMerc[i] == null) {
                int ogg = rdn.nextInt(0,4);
                int oggQuale;

                switch (ogg) {
                    case 0: 
                        oggQuale = rdn.nextInt(0,3);
                        switch (oggQuale) {
                            case 0: oggMerc[i] = new Arma("Doppietta","immagini/doppietta.png",80,5,7); break;
                            case 1: oggMerc[i] = new Arma("Automatico","immagini/automatico.png",50,4,2); break;
                            case 2: oggMerc[i] = new Arma("Pistola","immagini/pistola.png",20,2,2); break;
                        }
                        break;

                    case 1: 
                        oggQuale = rdn.nextInt(0,2);
                        switch (oggQuale) {
                            case 0: oggMerc[i] = new Cura("Kit di pronto soccorso","immagini/prontoSoccorso.png",50,6,5); break;
                            case 1: oggMerc[i] = new Cura("Benda","immagini/benda.png",15,3,2); break;
                        }
                        break;

                    case 2: 
                        oggQuale = rdn.nextInt(0,2);
                        switch (oggQuale) {
                            case 0: oggMerc[i] = new Scarpe("Scarpe classiche","immagini/scarpe2.png",30,3,5); break;
                            case 1: oggMerc[i] = new Scarpe("Scarpe lente","immagini/scarpe3.png",15,2,1); break;
                        }
                        break;

                    case 3: 
                        oggQuale = rdn.nextInt(0,2);
                        switch (oggQuale) {
                            case 0: oggMerc[i] = new Vestito("Vestito classico","immagini/vestito2.png",30,6,7); break;
                            case 1: oggMerc[i] = new Vestito("Vestito leggero","immagini/vestito3.png",15,4,2); break;
                        }
                        break;
                }
            }
        }
        return oggMerc;
    }
    
    public void setRisorse(){
        int[] risCacciatore=g.getRisorse();
        
        carne.setText(String.valueOf(risCacciatore[0]));
        pelle.setText(String.valueOf(risCacciatore[1]));        
    }
    
    public void compra(Oggetto o){
        
        g.compraOgg(o);

        for(JButton JB:bottoni){
            int[] prezzo= oggMercante[(bottoni.indexOf(JB))].getCosto();
            controlloAttivo(JB,prezzo);
        }
        
        
    }
    
    public void controlloAttivo(JButton b,int[] p){
        int[] ris=g.getCacciatore().getRisorse();
        
        int pc=p[0];
        int pp=p[1];
        
        int carne=ris[0];
        int pelle=ris[1];
        
        if(carne<pc||pelle<pp){
            b.setEnabled(false);
        }
    }
    
    public boolean controlloInvenatarioPieno(Cacciatore cacciatore){
        if(cacciatore.inventario.oggetti.size()==4){
            return true;
        }
        else{
            return false;
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
            .addGap(0, 607, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
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
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
