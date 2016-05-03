
package Classi;


public class Cassa {

    private int saldo;
    private int prezzo;

    
    



public void Acquisto(Oggetti oggetto_acquistato, Cliente cliente){
    
        prezzo = oggetto_acquistato.getPrezzo();
        saldo = cliente.getSaldo();
        if (prezzo == saldo)
            {cliente.setSaldo(0);}
            else if (prezzo < saldo)
            {saldo = saldo - prezzo;
            cliente.setSaldo(saldo);}
            
        }
}
    

