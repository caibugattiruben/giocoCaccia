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
    
    private int vita,danno,velocità,scudo,carne=0,pelle=0;
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
    
    public void setArma(Oggetto o){
        inventario.setArma(o);
    }
    
    public int[] getRisorse(){
        int[] ris={carne,pelle};
        return ris;
    }
}
