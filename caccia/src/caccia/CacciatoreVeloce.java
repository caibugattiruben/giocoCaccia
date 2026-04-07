/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import java.io.Serializable;

/**
 *
 * @author caibugatti.ruben
 */
public class CacciatoreVeloce extends Cacciatore implements Serializable{
    
    public CacciatoreVeloce(Inventario inv,int v,int s){
        super(inv,v,s);
    }

    @Override
    public String usaAbilita(Animale nemico) {
        if (this.getCooldown() > 0) {
            return "Ricarica: " + this.getCooldown() + " turni";
        }
        
        this.setCooldown(5);
        
        return "SCATTO FELINO"; 
    }
}
