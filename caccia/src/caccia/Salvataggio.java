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
public class Salvataggio implements Serializable{
    
    private Cacciatore c;
    private int turno;
    public Salvataggio(Cacciatore c,int t){
        this.c=c;
        this.turno=t;
    }
    
    public Cacciatore getCacciatore(){
        return c;
    }
    
    public int getTurno(){
        return turno;
    }
}
