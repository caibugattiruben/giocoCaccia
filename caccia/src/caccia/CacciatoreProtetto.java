/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author caibugatti.ruben
 */
public class CacciatoreProtetto extends Cacciatore {
    private boolean scudoAttivo = false;
    public CacciatoreProtetto(Inventario inv,int v,int s){
        super(inv,v,s);
    }
    
    @Override
    public String usaAbilita(Animale nemico) {
        if (this.getCooldown() > 0) {
            return "Ricarica: " + this.getCooldown() + " turni";
        }

        this.scudoAttivo = true;
        this.setCooldown(5);
        return "IMMUNITA': Il prossimo attacco non ti farà danni!";
    }

    public boolean isScudoAttivo(){ 
        return scudoAttivo; 
    }
    public void setScudoAttivo(boolean stato) {
        this.scudoAttivo = stato;
    }
}
