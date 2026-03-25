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
    FormGioco formGioco;
    FormInventario formInventario;
    
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
        //manca chiusura gioco
        (formMercante=new Mercante(this,w,h)).setVisible(true);
    }
    
    public void aproGioco(int w,int h,int nCac){
        formPersonaggio.dispose();
        formGioco=new FormGioco(this,nCac);
        apriGioco(w,h);
    }
    
    public void sceltaPersonaggioCliccata(){
        gestore.sceltaPersonaggio();
    }
    public Cacciatore sceltaPersonaggio(){
        switch (nCacciatore){
                case 1:
                    return new CacciatoreVeloce(100,10,20,10);
                case 2:
                    return new CacciatoreMedico(100,10,20,10);
                case 3:
                    return new CacciatoreForte(100,10,20,10);
                case 4:
                    return new CacciatoreProtetto(100,10,20,10);
        }
        return new CacciatoreVeloce(100,10,20,10);
    }
    
    public void setNumero(int n){
        this.nCacciatore=n;
    }
    
    public void aperturaInventario(int w,int h){
        formInventario=new FormInventario(this,w,h);
        formGioco.setVisible(false);
        formInventario.setVisible(true);
        
    }
    
    public void chiusuraInventario(int w,int h){
        formGioco.setVisible(true);
        formInventario.dispose();
        
    }
    
    public void apriGioco(int w,int h){
        formGioco.setSize(w,h);
        formGioco.setVisible(true);
    }
}
