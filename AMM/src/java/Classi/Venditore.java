

package Classi;

import java.util.ArrayList;


public class Venditore extends Utente{
    /* Attributi */
    
    protected float saldovenditore;
    /* Costruttore */
    public Venditore()
    {
        super();
    }
            
    /* Metodi */
   
    
    public float getSaldo(){

    return saldovenditore;
}
public void setSaldo(float saldo){
    
    this.saldovenditore = saldo;
}

}
