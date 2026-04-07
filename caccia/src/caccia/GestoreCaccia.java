/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import java.io.Serializable;

/**
 *
 * @author caibugatti.ruben
 */
public class GestoreCaccia implements Serializable{
    gestoreForm gForm=new gestoreForm(this);
    Cacciatore cacciatore;
    private int turnoAttuale = 0;
    private int turnoFine = 50;
    
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
                Animale a=FileManager.estraiAnimale();
                setImmagine(a.getPath());
                eventoAnimale(a);
                
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
        int[] ris={20,20};
        cacciatore.setRisorse(ris);

    }
    
    public void eventoAnimale(Animale a){
        if (a instanceof AnimalePacifico) {
            gForm.scriviMess("Hai trovato un animale pacifico nel bosco. vai tranquillo.");
        } 
        else if (a instanceof AnimaleCacciagione) {
            gForm.scriviMess("Hai trovato un animale da cacciare nel bosco. decidi se sparargli.");
            gForm.lottaAnimale(true,a);
        } 
        else {
           gForm.scriviMess("Hai trovato un animale aggressivo. ATTENTO.");    
           gForm.lottaAnimale(false,a);
                
        }
            
    }
    
    
    
    public void setImmagine(String path){
        gForm.setImmagineEvento(path);
    }
    
    public void incrementaTurno() {
        this.turnoAttuale++;
    }

    public int getTurnoAttuale() { 
        return turnoAttuale; 
    }
    public int getTurnoMax() {
        return turnoFine; 
    }
    
    public boolean controllaVittoria() {
        return turnoAttuale >= turnoFine;
    }
    
    public void salvaDati(String path){
        FileManager.salvaSalvataggio(path,new Salvataggio(cacciatore,turnoAttuale));
    }
    
    public void caricaDati(String path) throws ClassNotFoundException{
         Salvataggio s=FileManager.loadSalvataggio(path);
         
         turnoAttuale=s.getTurno();
         cacciatore=s.getCacciatore();
         
         gForm.caricaPersonaggio(cacciatore);
        

    }
    
}
