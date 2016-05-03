/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.ArrayList;


public class Cliente extends Utente {
    /* Attributi */
    private ArrayList<Integer> oggettiComprati = new ArrayList<>(); 
    private int saldo_cliente;
    private boolean stato;
    /* Costruttore */
    public Cliente()
    {
        super();
    }
    /* Metodi */

    
    public ArrayList<Integer> getOggettiComprati() {
        return oggettiComprati;
    }

    
    public void setOggettiComprati(ArrayList<Integer> oggettiComprati) {
        this.oggettiComprati = oggettiComprati;
    }
    public int getSaldo(){

    return saldo_cliente;
}
public void setSaldo(int saldo){
    
    this.saldo_cliente = saldo;
}


}
