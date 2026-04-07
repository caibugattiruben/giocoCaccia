/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author caibugatti.ruben
 */
public class FileManager {
   
    private static String pathAnimali="animali.txt";
    
    
    public static Animale estraiAnimale(){
        ArrayList<String> animali= new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader(pathAnimali))){
            
            String line;
            
            while((line=br.readLine())!=null){
                animali.add(line);
            }
            return creoAnimale(animali);
        }
        catch(IOException e){
            
        }
        return null;
    }
    
    public static Animale creoAnimale(ArrayList<String> animali){
        Random rdn=new Random();
        
        int ani=rdn.nextInt(0,animali.size());
        
        String[] animale=animali.get(ani).split(";");
        
        if(animale[animale.length - 1].equals("PACIFICO")){
            return new AnimalePacifico(animale[0],Integer.parseInt(animale[1]));
        }
        else if(animale[animale.length - 1].equals("CACCIAGIONE")){
            return new AnimaleCacciagione(animale[0],Integer.parseInt(animale[1]),Integer.parseInt(animale[2]),Integer.parseInt(animale[3]));
        }
        else{
            return new AnimaleAggressivo(animale[0],Integer.parseInt(animale[1]),Integer.parseInt(animale[2]),Integer.parseInt(animale[3]));
        }
    }
    
    public static void salvaSalvataggio(String path,Salvataggio s){
        try(ObjectOutputStream oss=new ObjectOutputStream(new FileOutputStream(path))){
            oss.writeObject(s);
        }
        catch(IOException e){
            
        }
                
    }
    
    public static Salvataggio loadSalvataggio(String path) throws ClassNotFoundException{
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path))){
           return (Salvataggio) ois.readObject();
        }
        catch(IOException e){
            
        }
         return null;       
    }
        
}
