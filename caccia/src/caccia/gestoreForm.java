/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author caibugatti.ruben
 */
public class gestoreForm {
    AvvioGioco formAvvio=new AvvioGioco(this);
    SceltaPersonaggio formPersonaggio=new SceltaPersonaggio(this);
    Mercante formMercante=new Mercante(this);
    
    public void avvio(){
        formMercante.setVisible(true);
    }
    
    public void newGameScelto(){
        formAvvio.setVisible(false);
        formPersonaggio.setVisible(true);
    }
}
