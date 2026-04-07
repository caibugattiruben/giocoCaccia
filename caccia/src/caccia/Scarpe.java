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
public class Scarpe extends Oggetto implements Serializable{
    
    int valocita;
    public Scarpe(String n,String c,int v,int cc,int cp){
        super(n,c,cc,cp);
        this.valocita=v;
    }
    
    public int getVelocita(){
        return valocita;
    }
}
