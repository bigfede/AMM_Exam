/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.ArrayList;


public class Cliente extends Utente {
    /* Attributi */
    private ArrayList<Oggetti> oggettiComprati = new ArrayList<>(); 
    private int saldo_cliente;
    private boolean stato;
    /* Costruttore */
    public Cliente()
    {
        super();
    }
    /* Metodi */

    
    public ArrayList<Oggetti> getOggettiComprati() {
        return oggettiComprati;
    }

    
    public void setOggettiComprati(ArrayList<Oggetti> oggettiComprati) {
        this.oggettiComprati = oggettiComprati;
    }
    public int getSaldo(){

    return saldo_cliente;
}
public void setSaldo(int saldo){
    
    this.saldo_cliente = saldo;
}


}
