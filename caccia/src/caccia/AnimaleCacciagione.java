/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author ruben
 */
public class AnimaleCacciagione extends Animale {
    private int vita,carne,pelle;
    public AnimaleCacciagione(String n,int v,int c,int p){
        super(n,v);
        
        this.carne=c;
        this.pelle=p;
        
    }
    
    public int getCarne(){
        return carne;
    }
    
    public int getPelle(){
        return pelle;
    }

}
