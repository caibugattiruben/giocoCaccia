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
    private String log,path;
    public Salvataggio(Cacciatore c,int t,String[] dati){
        this.c=c;
        this.turno=t;
        this.log=dati[0];
        this.path=dati[1];
    }
    
    public Cacciatore getCacciatore(){
        return c;
    }
    
    public int getTurno(){
        return turno;
    }
    
    public String[] getDati(){
        String[] rit={log,path};
        return rit;
    }
}
