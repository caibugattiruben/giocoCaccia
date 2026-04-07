/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author caibugatti.ruben
 */
public class CacciatoreForte extends Cacciatore {
    
    public CacciatoreForte(Inventario inv,int v,int s){
        super(inv,v,s);
    }
    
    @Override
    public String usaAbilita(Animale nemico) {
        if (getCooldown() > 0){
            return "Ricarica: " + getCooldown() + " turni";
        }
        
        nemico.setVita(0); 
        setCooldown(6);
        return "COLPO CRITICO! Hai abbattuto il " + nemico.getNome() + " in un colpo!";
    }
}
