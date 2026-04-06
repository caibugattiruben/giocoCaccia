/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author caibugatti.ruben
 */
public class GestoreCaccia {
    gestoreForm gForm=new gestoreForm(this);
    Cacciatore cacciatore;
    
    public void avvio() {
        gForm.avvio();
    }

    public void setPersonaggio(Cacciatore c) {
        cacciatore = c;
        cacciatore.formaCacciatore();
    }

    public void caricaPersonaggio() {
        if (cacciatore != null) {
            gForm.caricaPersonaggio(cacciatore);
        }
        cacciatore.contenutiInv();
    }
    
    public Arma getArma(){
        return cacciatore.getArma();
    }
    
    public Cacciatore getCacciatore(){
        return cacciatore;
    }
    
    public int[] getRisorse(){
        return cacciatore.getRisorse();
    }
    
    public void oggettoComprato(Oggetto o){
        cacciatore.oggettoComprato(o.getCosto()[0], o.getCosto()[1]);
        
        if (o instanceof Arma) {
            cacciatore.setArma(o);
            gForm.caricaPersonaggio(cacciatore);
        } 
        else if (o instanceof Cura) {
            cacciatore.aggOggetto(o);
        } 
        else if (o instanceof Scarpe) {
            cacciatore.setVelocita(((Scarpe) o).getVelocita());
        } 
        else if (o instanceof Vestito) {
            cacciatore.setScudo(((Vestito) o).getDifesa());
            gForm.caricaPersonaggio(cacciatore);
        } 
        
        gForm.refreshDatiMercato();
    }
    
    public void usoOgg(Oggetto o){
        Cura ogg=(Cura)o;
        cacciatore.inventario.rimuoviOggetto(o);
        ogg.usa(cacciatore);
        caricaPersonaggio();
    }
    
    public void estraiEvento(){
        
        switch (EventManager.estraiEvento()){
            case EVENTI.TRAPPOLA:
                eventoTrappola();
                setImmagine("immagini/trappola.png");
                break;
            case EVENTI.TEMPESTA:
                eventoTempesta();
                setImmagine("immagini/tempesta.png");
                break;
            case EVENTI.MERCANTE:
                setImmagine("immagini/negozio.png");
                eventoMercante();
                break;
            case EVENTI.TESORO:
                eventoTesoro();
                setImmagine("immagini/tesoro.png");
                break;
            case EVENTI.ANIMALE:
                eventoAnimale();
                break;
        }
    }
    
    public void eventoTrappola(){
        cacciatore.setVita(-20);
        gForm.scriviMess("OH NO HAI COLPITO UNA TRAPPOLA, PERDI 20 DI VITA");
        caricaPersonaggio();
    }
    
    public void eventoTempesta(){
        cacciatore.setVelocita(-20);
        gForm.scriviMess("OH NO E' ARRIVATA UNA TEMPESTA PERDI 20 DI VELOCITA'");
    }
    
    public void eventoMercante(){
        gForm.scriviMess("HAI TROVATO UN MERCANTE DEL BOSCO");
        gForm.aproMercante();
    }
    
    public void eventoTesoro(){
        gForm.scriviMess("HAI TROVATO UN TESSORO DEL BOSCO");

    }
    
    public void eventoAnimale(){
        gForm.scriviMess("HAI TROVATO UN ANIMALE DEL BOSCO");

    }
    
    
    
    public void setImmagine(String path){
        gForm.setImmagineEvento(path);
    }
}
