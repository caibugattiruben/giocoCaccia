/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author caibugatti.ruben
 */
public class gestoreForm {
    GestoreCaccia gestore;
    AvvioGioco formAvvio=new AvvioGioco(this);
    SceltaPersonaggio formPersonaggio;
    Mercante formMercante;
    FormGioco formGioco;
    FormInventario formInventario;
    
    private int nCacciatore;
    
    public gestoreForm(GestoreCaccia g){
        this.gestore = g;
    }

    public void avvio() {
        new AvvioGioco(this).setVisible(true);
    }

    public void newGameScelto(int w, int h){
        formPersonaggio = new SceltaPersonaggio(this, w, h);
        formPersonaggio.setVisible(true);
    }

    public void aproMercante(int w, int h){
        formMercante = new Mercante(this, w, h);
        formMercante.setVisible(true);
    }

    public void aproGioco(int w, int h, int nCac){
        if (formPersonaggio != null) {
            formPersonaggio.dispose();
        }
        formGioco = new FormGioco(this, nCac);
        formGioco.setSize(w, h);
        formGioco.setVisible(true);
        gestore.caricaPersonaggio();
    }

    public void sceltaPersonaggioCliccata(){
        gestore.sceltaPersonaggio();
    }

    public Cacciatore sceltaPersonaggio(){
        switch (nCacciatore){
            case 0: return new CacciatoreVeloce(new Inventario(new Arma("Pistola","immagini/pistola.png",20), null));
            case 1: return new CacciatoreMedico(new Inventario(new Arma("Pistola","immagini/pistola.png",20), null));
            case 2: return new CacciatoreForte(new Inventario(new Arma("Carabina","immagini/carabina.png",100), null));
            case 3: return new CacciatoreProtetto(new Inventario(new Arma("Pistola","immagini/pistola.png",20), null));
        }
        return null;
    }

    public void setNumero(int n){
        this.nCacciatore = n;
    }

    public void aperturaInventario(int w, int h){
        formInventario = new FormInventario(this, w, h);
        if (formGioco != null) formGioco.setVisible(false);
        formInventario.setVisible(true);
    }

    public void chiusuraInventario(int w, int h){
        if (formGioco != null) formGioco.setVisible(true);
        if (formInventario != null) formInventario.dispose();
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
}
