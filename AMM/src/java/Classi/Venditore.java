

package Classi;

import java.util.ArrayList;


public class Venditore extends Utente{
    /* Attributi */
    private ArrayList<Oggetti> oggettiVenduti = new ArrayList<>();
    private int saldo_venditore;
    /* Costruttore */
    public Venditore()
    {
        super();
    }
            
    /* Metodi */
   
    public ArrayList<Oggetti> getOggettiVenduti() {
        return oggettiVenduti;
    }

   
    public void setOggettiVenduti(ArrayList<Oggetti> oggettiVenduti) {
        this.oggettiVenduti = oggettiVenduti;
    }
    public int getSaldo(){

    return saldo_venditore;
}
public void setSaldo(int saldo){
    
    this.saldo_venditore = saldo;
}

}
