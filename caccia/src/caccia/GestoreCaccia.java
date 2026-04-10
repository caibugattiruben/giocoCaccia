/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

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
            cacciatore.setVelocità(((Scarpe) o).getVelocita());
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
        cacciatore.setVelocità(-20);
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
        FileManager.salvaSalvataggio(path,new Salvataggio(cacciatore,turnoAttuale,gForm.getDati()));
    }
    
    public void caricaDati(String path) throws ClassNotFoundException{
         Salvataggio s=FileManager.loadSalvataggio(path);
         
         loadDati(s);
         turnoAttuale=s.getTurno();
         cacciatore=s.getCacciatore();
         
         gForm.caricaPersonaggio(cacciatore);
        

    }
    
    public void loadDati(Salvataggio s){
        gForm.setDati(s.getDati());
    }
     
    public String[] caricaCSV(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); 
            String riga = br.readLine();
            if (riga == null || riga.isEmpty()) return null;

            riga = riga.replace("\r", "").replace("\n", "");
            String[] d = riga.split(";", -1);

            int tipo = Integer.parseInt(d[0].trim());
            switch(tipo) {
                case 2: this.cacciatore = new CacciatoreMedico(new Inventario(null, null), 0, 0); break;
                case 3: this.cacciatore = new CacciatoreForte(new Inventario(null, null), 0, 0); break;
                case 4: this.cacciatore = new CacciatoreProtetto(new Inventario(null, null), 0, 0); break;
                default: this.cacciatore = new CacciatoreVeloce(new Inventario(null, null), 0, 0); break;
            }

            // 2. Carica i dati
            this.turnoAttuale = Integer.parseInt(d[1].trim());
            this.cacciatore.setRisorse(new int[]{Integer.parseInt(d[2].trim()), Integer.parseInt(d[3].trim())});
            this.cacciatore.setVita(Integer.parseInt(d[4].trim()));
            this.cacciatore.setScudo(Integer.parseInt(d[5].trim()));
            this.cacciatore.setVelocità(Integer.parseInt(d[7].trim()));

            // Arma
            Oggetto o = cacciatore.creaOggettoDaNome(d[8].trim());
            if (o instanceof Arma){
                this.cacciatore.setArma((Arma) o);
            }
            this.cacciatore.setDanno();

            // Log e Immagine
            String logCaricato = d[9].replace("|", "\n");
            String imgCaricata = d[10].trim();

            // Inventario
            this.cacciatore.getInventario().getOggetti().clear(); 
            if (d.length > 11 && !d[11].trim().isEmpty() && !d[11].equals("VUOTO")) {
                String[] nomi = d[11].split(","); 

                for (String n : nomi) {
                    String nomePulito = n.trim();
                    Oggetto ogg = cacciatore.creaOggettoDaNome(nomePulito);

                    if (ogg != null) {
                        this.cacciatore.aggOggetto(ogg);
                    } else {
                        System.out.println("Attenzione: non riconosco l'oggetto: " + nomePulito);
                    }
                }
            }

            return new String[]{logCaricato, imgCaricata};

        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaCSV(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            String[] datiExtra = gForm.getDati();

            int tipo = 1;
            if (cacciatore instanceof CacciatoreMedico){
                tipo = 2;
            }
            else if (cacciatore instanceof CacciatoreForte){
                tipo = 3;
            }
            else if (cacciatore instanceof CacciatoreProtetto){
                tipo = 4;
            }

            String inventarioFinale = "";
            ArrayList<Oggetto> lista = cacciatore.getInventario().getOggetti();
            for (int i = 0; i < lista.size(); i++) {
                inventarioFinale += lista.get(i).getNome();
                if (i < lista.size() - 1) inventarioFinale += ",";
            }
            if (inventarioFinale.isEmpty()) {
                inventarioFinale = "VUOTO";
            }

            bw.write("Tipo;Turno;Carne;Pelle;Vita;Scudo;Danno;Velocità;Arma;Log;Immagine;Inventario");
            bw.newLine();

            String logPerCSV = datiExtra[0].replace(";", ",").replace("\n", "|").replace("\r", "");
            String riga = tipo + ";" + turnoAttuale + ";" + cacciatore.getRisorse()[0] + ";" + cacciatore.getRisorse()[1] + ";" + cacciatore.getVita() + ";" + cacciatore.getScudo() + ";" + cacciatore.getDanno() + ";" + cacciatore.getVelocità() + ";" + cacciatore.getArma().getNome() + ";" + logPerCSV + ";" + datiExtra[1] + ";" + inventarioFinale;

            bw.write(riga);
        } catch (IOException e) {
        }
    }
    
}
