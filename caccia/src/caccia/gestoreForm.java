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
    GestoreCaccia gestore;
    AvvioGioco formAvvio=new AvvioGioco(this);
    SceltaPersonaggio formPersonaggio;
    Mercante formMercante;
    
    private int nCacciatore;
    
    public gestoreForm(GestoreCaccia g){
        this.gestore=g;
    }
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
    
    public void sceltaPersonaggioCliccata(){
        gestore.sceltaPersonaggio();
    }
    public Cacciatore sceltaPersonaggio(){
        switch (nCacciatore){
                case 1:
                    return new CacciatoreVeloce();
                case 2:
                    return new CacciatoreMedico();
                case 3:
                    return new CacciatoreForte();
                case 4:
                    return new CacciatoreProtetto();
        }
        return new CacciatoreVeloce();
    }
    
    public void setNumero(int n){
        this.nCacciatore=n;
    }
}
