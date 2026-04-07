/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import javax.swing.JFrame;

/**
 *
 * @author caibugatti.ruben
 */
public class gestoreForm {
    GestoreCaccia gestore;
    AvvioGioco formAvvio;
    SceltaPersonaggio formPersonaggio;
    Mercante formMercante;
    FormGioco formGioco;
    FormInventario formInventario;
    statPlayer formStat;
    FormLotta formLotta;
    
    private int nCacciatore;
    
    public gestoreForm(GestoreCaccia g){
        this.gestore = g;
    }

    public void avvio() {
        formAvvio=new AvvioGioco(this);
        formAvvio.setVisible(true);
    }

    public void newGameScelto(int w, int h){
        formPersonaggio = new SceltaPersonaggio(this, w, h);
        formPersonaggio.setVisible(true);
        formAvvio.dispose();
    }

    public void aproMercante(){
        if(formGioco.sceltaAccessoMerc()==true){
            formGioco.setVisible(false);
            formMercante = new Mercante(this, formGioco.getWidth(),formGioco.getHeight());
            formMercante.setVisible(true);
        }
        
    }
    
    public void chiudoMercante(){
        formMercante.setVisible(false);
        formGioco.setVisible(true);
    }

    public void creoGioco(int w, int h, int nCac){
        if (formPersonaggio != null) {
            formPersonaggio.dispose();
        }
        
        formGioco = new FormGioco(this, nCac);
        
        aproGioco(w,h);
        
    }
    
    public void aproGioco(int w, int h){
        formGioco.setVisible(true);
        formGioco.setSize(w, h);
        gestore.caricaPersonaggio();
    }

    public void sceltaPersonaggioCliccata(){
        gestore.setPersonaggio(sceltaPersonaggio());
    }

    public Cacciatore sceltaPersonaggio(){
        switch (nCacciatore){
            case 0: return new CacciatoreVeloce(new Inventario(new Arma("Pistola","immagini/pistola.png",20,0,0), null),100,50);
            case 1: return new CacciatoreMedico(new Inventario(new Arma("Pistola","immagini/pistola.png",20,0,0), new Cura("Kit di Pronto Soccorso","immagini/prontoSoccorso.png",50,0,0)),20,40);
            case 2: return new CacciatoreForte(new Inventario(new Arma("Carabina","immagini/carabina.png",70,0,0), null),45,40);
            case 3: return new CacciatoreProtetto(new Inventario(new Arma("Pistola","immagini/pistola.png",20,0,0), null),10,100);
        }
        return null;
    }

    public void setNumero(int n){
        this.nCacciatore = n;
    }

    public void aperturaInventario(int w, int h, JFrame formChiama) {
        if (formChiama != null) formChiama.setVisible(false);

        formInventario = new FormInventario(this, w, h, formChiama);
        formInventario.setVisible(true);
    }

    public void chiusuraInventario(JFrame formChiama) {
        if (formChiama != null) {
            formChiama.setVisible(true);
        }

        if (formInventario != null) {
            formInventario.dispose();
        }
    }

    public void caricoGioco(int w, int h){
        if (formGioco != null) {
            formGioco.setSize(w, h);
            formGioco.setVisible(true);
            gestore.caricaPersonaggio();
        }
    }

    public void caricaPersonaggio(Cacciatore c){
        if (formGioco != null) {
            formGioco.caricaPersonaggio(c);
        }
    }

    public Arma getArma(){
        return gestore.getArma();
    }
    
    public Cacciatore getCacciatore(){
        return gestore.getCacciatore();
    }
    
    public int[] getRisorse(){
        return gestore.getRisorse();
    }
    
    public void compraOgg(Oggetto o){
        gestore.oggettoComprato(o);
    }
    
    public void refreshDatiMercato(){
        formMercante.setRisorse();
    }
    
    public void aproStat(int w,int h){
        formStat=new statPlayer(w,h,this,gestore.getCacciatore(),nCacciatore);
        formGioco.setVisible(false);
        formStat.setVisible(true);
    }
    
    public void chiudoStat(){
        formStat.dispose();
        formGioco.setVisible(true);
    }
    
    public void usoOggInv(Oggetto o){
        gestore.usoOgg(o);
    }
    
    
    
    
    
    public void evento(){
        gestore.estraiEvento();
    }
    
    public void setImmagineEvento(String path){
        formGioco.setImmagineEvento(path);
    }
    
    public void scriviMess(String mess){
        formGioco.scriviMess(mess);
    }
    
    public void lottaAnimale(boolean quale,Animale a){
        //SE TRUE ANIMALE CACC SE FALSE ANIMALE AGG
        if(quale==true){
            formGioco.sceltaLottaAnimale(a);
        }
        else{
            formGioco.sceltaLottaAnimaleAgg(a);
        }
        
    }
    
    public void apriLotta(int w,int h,Animale a){
        formLotta=new FormLotta(this,w,h,nCacciatore,a);
        
        formLotta.setVisible(true);
        formGioco.setVisible(false);
        
    }
    
    public void fineLotta(int w,int h){
        formLotta.dispose();
        formGioco.setVisible(true);
    }
    
    public void incrementaTurno() {
        gestore.incrementaTurno();
    }
    
    public int getTurnoAttuale(){
        return gestore.getTurnoAttuale();
    }
    
    public int getTurnoMax(){
        return gestore.getTurnoMax();
    }
    
    public boolean controllaVittoria(){
        return gestore.controllaVittoria();
    }
}
