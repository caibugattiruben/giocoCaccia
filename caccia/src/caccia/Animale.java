/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author ruben
 */
public class Animale {
    private String nome,path;
    
    public Animale (String n){
        this.nome=n;
        this.path="immagini/"+n+".png";
    }
    
    public String getPath(){
        return this.path;
    }
}
