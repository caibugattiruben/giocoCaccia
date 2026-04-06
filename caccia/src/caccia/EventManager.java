/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caccia;

import java.util.Random;

/**
 *
 * @author ruben
 */
public class EventManager {
    
    
    public static EVENTI estraiEvento(){
        Random rdn=new Random();

        int val=rdn.nextInt(1,101);

        if(val<=10){
            return EVENTI.TRAPPOLA;
        }
        else if(val<=20){
            return EVENTI.TEMPESTA;
        }
        else if(val<=40){
            return EVENTI.MERCANTE;
        }
        else if(val<=50){
            return EVENTI.TESORO;
        }
        else{
            return EVENTI.ANIMALE;
        }
    }
}
