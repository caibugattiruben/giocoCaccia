/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author ruben
 */
public class Vestito extends Oggetto {
    
    int scudo;
    public Vestito(String n,String c,int s,int cc,int cp){
        super(n,c,cc,cp);
        this.scudo=s;
    }
    
    public int getDifesa(){
        return scudo;
    }
}
