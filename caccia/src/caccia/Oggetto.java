/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

/**
 *
 * @author ruben
 */
public class Oggetto {
    
    protected String nome;
    private String collegamentoFoto;
    
    public Oggetto(String n,String c){
        this.nome=n;
        this.collegamentoFoto=c;
    }
    
    public String getCollegamento(){
        return collegamentoFoto;
    }
}
