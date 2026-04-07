/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author ruben
 */
public class Inventario implements Serializable{
    ArrayList<Oggetto> oggetti;
    
    public Inventario(Arma a,Cura c) {
        oggetti = new ArrayList<>();
        aggiungiOggetto(a);
        if(c!=null){
            aggiungiOggetto(c);
        }
    }

    public void aggiungiOggetto(Oggetto o) {
        if(oggetti.size()!=4){
            oggetti.add(o);
        }else{
            System.out.println("inventario pieno");
        }
        
    }
    public void rimuoviOggetto(Oggetto o) {
        if(oggetti.size()!=0){
            oggetti.remove(o);
        }else{
            System.out.println("inventario vuoto");
        }
        
    }
    
    public int getDanno(){
        return ((Arma) oggetti.get(0)).getDanno();
    }
    
    public String getCollegamento(Oggetto o){
        return o.getCollegamento();
    }
    
    public Arma getArma() {
        return ((Arma) oggetti.get(0));
    }
    
    public void setArma(Oggetto o){
        oggetti.set(0,(Arma) o);
        
    }
    
    public ArrayList<Oggetto> getOggetti(){
        return oggetti;
    }
    
    public Oggetto getOggAllaPos(int pos){
        return oggetti.get(pos);
    }
}
