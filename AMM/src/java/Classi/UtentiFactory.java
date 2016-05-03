
package Classi;

import java.util.ArrayList;


public class UtentiFactory {

    private static UtentiFactory singleton;

    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }

    /* Costruttore */
    private UtentiFactory() {

    }

    public ArrayList<Utente> getUserList() {
        ArrayList<Utente> listaUtenti = new ArrayList<>();
       
        // Cliente 1
        Cliente client_1 = new Cliente();
        client_1.setUsername("FedericoPorra");
        client_1.setPassword("fed3");
        client_1.setNome("Federico");
        client_1.setCognome("Porrà");
        client_1.setId(0);
        client_1.setSaldo(1000);
        ArrayList<Integer> arrayOggettiComprati_1 = new ArrayList<>();
        arrayOggettiComprati_1.add(1);
        arrayOggettiComprati_1.add(0);
        client_1.setOggettiComprati(arrayOggettiComprati_1);
        listaUtenti.add(client_1);

       

        // Venditore 1
        Venditore venditore_1 = new Venditore();
        venditore_1.setUsername("FabioPerra");
        venditore_1.setPassword("fabi0");
        venditore_1.setNome("Fabio");
        venditore_1.setCognome("Perra");
        venditore_1.setId(2);
        venditore_1.setSaldo(200);
        ArrayList<Integer> arrayOggettiVenduti_1 = new ArrayList<>();
        arrayOggettiVenduti_1.add(2);
        arrayOggettiVenduti_1.add(1);
        venditore_1.setOggettiVenduti(arrayOggettiVenduti_1);
        listaUtenti.add(venditore_1);
        
        return listaUtenti;
    }
}
