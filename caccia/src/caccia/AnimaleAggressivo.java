/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author ruben
 */
public class AnimaleAggressivo extends Animale {
    
    private int vita,danno,velocita;
    
    public AnimaleAggressivo(String n,int v,int d,int vel){
        super(n);
        
        this.vita=v;
        this.danno=d;
        this.velocita=v;
    }
    
    public void attacca(){
        
    }
    
    public void subitoColpo(int v){
        this.vita=vita-v;
        if(vita<0){
            vita=0;
        }
    }
}
