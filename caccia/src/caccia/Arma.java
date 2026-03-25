/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author ruben
 */
public class Arma extends Oggetto {
    
    private int danno; 
    
    public Arma(String n,String c,int d){
        super(n,c);
        this.danno=d;
    }
    
    public int getDanno(){
        return danno;
    }
    
    @Override
    public String toString(){
        return nome;
    }
}
