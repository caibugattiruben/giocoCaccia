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
    
    private int vita,danno,velocità,scudo;
    protected Inventario inventario;
    
    public Cacciatore(Inventario inv){
        this.inventario=inv;
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
    
    public String getCollegamento(Oggetto o){
        return inventario.getCollegamento(o);
    }
}
