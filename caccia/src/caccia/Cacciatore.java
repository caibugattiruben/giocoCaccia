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
public class Cacciatore implements Serializable{
    
    private int vita,danno,velocità,scudo,carne=5,pelle=5,cooldown;
    protected Inventario inventario;
    
    public Cacciatore(Inventario inv,int v,int s){
        this.inventario=inv;
        this.velocità=v;
        this.scudo=s;
    }
    
    public void formaCacciatore(){
        vita=100;
        danno=inventario.getDanno();
    }
    
    public int getVita(){
        return vita;
    }
    
    
    public int getScudo(){
        return scudo;
    }
    public int getVelocità(){
        return velocità;
    }
    public int getDanno(){
        return danno;
    }
    
    public void setDanno(){
        Arma a=(Arma) inventario.oggetti.get(0);
        danno=a.getDanno();
    }
    
    public int[] getStat(){
        int[] stat={vita,danno,scudo,velocità};
        return stat;
    }
    
    public void setVita(int v){
        this.vita=vita+v;
        if(vita>100){
            vita=100;
        }
        else if(vita<0){
            vita=0;
        }
    }
    
    public void setArma(Oggetto o){
        inventario.setArma(o);
        setDanno();
    }
    
    public void setVelocità(int v){
        this.velocità+=v;
        
        if(velocità<0){
            velocità=0;
        }
        else if(velocità>100){
            velocità=100;
        }
    }
    public void setScudo(int s){
        this.scudo=s;
    }
    
    public String getCollegamento(Oggetto o){
        return inventario.getCollegamento(o);
    }
    
    public void aggOggetto(Oggetto o){
        inventario.aggiungiOggetto(o);
    }
    

    public Oggetto creaOggettoDaNome(String nome) {
        switch (nome) {
            // --- ARMI ---
            case "Carabina": 
                return new Arma("Carabina", "immagini/carabina.png", 70, 10, 10);
            case "Doppietta": 
                return new Arma("Doppietta", "immagini/doppietta.png", 50, 5, 7);
            case "Automatico": 
                return new Arma("Automatico", "immagini/automatico.png", 30, 4, 2);
            case "Pistola": 
                return new Arma("Pistola", "immagini/pistola.png", 20, 2, 2);

            // --- CURE ---
            case "Ampolla magica": 
                return new Cura("Ampolla magica", "immagini/ampollaMagica.png", 100, 10, 10);
            case "Kit di pronto soccorso": 
                return new Cura("Kit di Pronto Soccorso", "immagini/prontoSoccorso.png", 50, 6, 5);
            case "Benda": 
                return new Cura("Benda", "immagini/benda.png", 15, 3, 2);

            default:
                return null;
        }
    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public Arma getArma(){
        return inventario.getArma();
    } 
    
    
    
    public int[] getRisorse(){
        int[] ris={carne,pelle};
        return ris;
    }
    
    public void oggettoComprato(int cc,int cp){
        this.carne=carne-cc;
        this.pelle=pelle-cp; 
    }
    
    public void setRisorse(int[] ris){
        carne+=ris[0];
        pelle+=ris[1];
    }
    
    public String usaAbilita(Animale nemico) {
        return "Questo cacciatore non ha un'abilità speciale definita.";
    }

    public void ricaricaAbilita() {
        if (cooldown > 0) cooldown--;
    }
    
    public int getCooldown(){ 
        return cooldown; 
    }
    public void setCooldown(int cooldown) { 
        this.cooldown = cooldown; 
    }
    
    public String desrizioneAbilita(){
        return "";
    }
}
