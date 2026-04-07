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
public class CacciatoreMedico extends Cacciatore implements Serializable{
    
    public CacciatoreMedico(Inventario inv,int v,int s){
        super(inv,v,s);
    }
    
    @Override
    public String usaAbilita(Animale nemico) {
        if (getCooldown() > 0){
            return "Ricarica: " + getCooldown() + " turni";
        }
            
        
        setVita(100); 
        setCooldown(8);
        return "Hai usato il Medikit Avanzato: Vita al 100%!";
    }
}
