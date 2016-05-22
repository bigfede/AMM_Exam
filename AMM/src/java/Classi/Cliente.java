/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.ArrayList;


public class Cliente extends Utente {
    /* Attributi */
     
    protected float saldocliente;

    /* Costruttore */
    public Cliente()
    {
        super();
        
    }
    /* Metodi */

    
   
    public float getSaldo(){

    return saldocliente;
}
public void setSaldo(float saldo){
    
    this.saldocliente = saldo;
}


}
