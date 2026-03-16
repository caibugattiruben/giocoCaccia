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
    SceltaPersonaggio formPersonaggio;
    Mercante formMercante;
    
    public void avvio(){
        formAvvio.setVisible(true);
    }
    
    public void newGameScelto(int w,int h){
        formAvvio.setVisible(false);
        (formPersonaggio=new SceltaPersonaggio(this,w,h)).setVisible(true);
    }
    
    public void aproMercante(int w,int h){
        formPersonaggio.setVisible(false);
        (formMercante=new Mercante(this,w,h)).setVisible(true);
    }
}
