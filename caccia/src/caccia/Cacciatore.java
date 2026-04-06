/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author caibugatti.ruben
 */
public class Cacciatore {
    
    private int vita,danno,velocità,scudo,carne=100,pelle=100;
    protected Inventario inventario;
    
    public Cacciatore(Inventario inv,int v,int s){
        this.inventario=inv;
        this.velocità=v;
        this.scudo=s;
    }
    
    public void formaCacciatore(){
        vita=20;
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
    public int[] getStat(){
        int[] stat={vita,danno,scudo,velocità};
        return stat;
    }
    
    public void setVita(int v){
        this.vita=vita+v;
        if(vita>100){
            vita=100;
        }
    }
    
    public void setArma(Oggetto o){
        inventario.setArma(o);
    }
    
    public void setVelocita(int v){
        this.velocità=v;
    }
    public void setScudo(int s){
        this.scudo=s;
    }
    
    public String getCollegamento(Oggetto o){
        return inventario.getCollegamento(o);
    }
    
    public void contenutiInv(){
        inventario.cosaHo();
    }
    
    public void aggOggetto(Oggetto o){
        inventario.aggiungiOggetto(o);
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
}
