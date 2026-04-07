/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import java.io.Serializable;

/**
 *
 * @author ruben
 */
public class Cura extends Oggetto implements Serializable{
    
    private int valore;
    
    public Cura(String n,String c,int val,int cc,int cp){
        super(n,c,cc,cp);
        this.valore=val;
    }
    
    
    public int getValore(){
        return valore;
    }
    
    public void usa(Cacciatore c){
        c.setVita(valore);
    }
    
    @Override
    public String toString(){
        return nome;
    }
}
