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
    int costoCarne,costoPelle;
    
    public Oggetto(String n,String c,int cc,int cp){
        this.nome=n;
        this.collegamentoFoto=c;
        this.costoCarne=cc;
        this.costoPelle=cp;
    }
    
    public String getCollegamento(){
        return collegamentoFoto;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int[] getCosto(){
        int[] costo={costoCarne,costoPelle};
        return costo;
    }
    
    public int[] getPrezzo(){
        int[] prezzo={costoCarne,costoPelle};
        return prezzo;
    }
}
