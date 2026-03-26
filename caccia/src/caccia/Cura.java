/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author ruben
 */
public class Cura extends Oggetto {
    
    private int valore;
    
    public Cura(String n,String c,int val){
        super(n,c);
        this.valore=val;
    }
    
    @Override
    public String toString(){
        return nome;
    }
}
