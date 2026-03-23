/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author caibugatti.ruben
 */
public class GestoreCaccia {
    gestoreForm gForm=new gestoreForm(this);
    Cacciatore cacciatore;
    
    public void avvio(){
        gForm.avvio();
    }
    
    public void sceltaPersonaggio(){
        cacciatore=gForm.sceltaPersonaggio();
    }
    
    
}
