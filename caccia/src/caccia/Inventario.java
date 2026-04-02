/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import java.util.ArrayList;


/**
 *
 * @author ruben
 */
public class Inventario {
    ArrayList<Oggetto> oggetti;
    
    public Inventario(Arma a,Cura c) {
        oggetti = new ArrayList<>();
        aggiungiOggetto(a);
        if(c!=null){
            aggiungiOggetto(c);
        }
    }

    public void aggiungiOggetto(Oggetto o) {
        oggetti.add(o);
    }
    
    public int getDanno(){
        return ((Arma) oggetti.get(0)).getDanno();
    }
    
    public String getCollegamento(Oggetto o){
        return o.getCollegamento();
    }
    
    public void cosaHo(){
        for(Oggetto o:oggetti){
            System.out.println(o);
        }
    }
    
    public Arma getArma() {
        return ((Arma) oggetti.get(0));
    }
    
    public ArrayList<Oggetto> getOggetti(){
        return oggetti;
    }
}
