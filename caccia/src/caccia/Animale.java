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
    int vita;
    
    public Animale (String n, int v){
        this.nome=n;
        this.path="immagini/"+n+".png";
        this.vita=v;
    }
    
    public String getPath(){
        return this.path;
    }
    
    public int getVita(){
        return vita;
    }
    
    public void setVita(int v){
        this.vita=v;
    }
    
    public String getNome(){
        return nome;
    }
    
}
