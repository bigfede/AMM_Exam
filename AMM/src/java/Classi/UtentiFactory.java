
package Classi;

import java.util.ArrayList;


public class UtentiFactory {

    private static UtentiFactory singleton;
    private ArrayList<Oggetti> listaOggetti = new ArrayList<>();
    private ArrayList<Oggetti> arrayOggettiComprati_cliente = new ArrayList<>();
    private ArrayList<Oggetti> arrayOggettiVenduti_venditore = new ArrayList<>();
    
    
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }

    /* Costruttore */
    private UtentiFactory() {

    }

    public ArrayList<Oggetti> getObjectList(){
    
    return listaOggetti;
    
    }
        public ArrayList<Oggetti> getClienteList(){
        
        return arrayOggettiVenduti_venditore;
    
    }
        
    public ArrayList<Oggetti> getVenditoreList(){
        
        return arrayOggettiComprati_cliente;
    
    }
    
    public ArrayList<Utente> getUserList() {
        ArrayList<Utente> listaUtenti = new ArrayList<>();
       
        // Oggett1
        Oggetti oggetto_1 = new Oggetti();
        oggetto_1.setId(1);
        oggetto_1.setNome("Condensatore");
        oggetto_1.setPrezzo(15);
        oggetto_1.setDescrizione("Condensatore 10uF - 15v");
        oggetto_1.setImmagine("/Amministratore_di_Sistema/M3/imgs/Condensatore.jpg");
        oggetto_1.setQuantita(3);
        listaOggetti.add(oggetto_1);
        // Oggett2
        Oggetti oggetto_2 = new Oggetti();
        oggetto_2.setId(2);
        oggetto_2.setNome("Ventola");
        oggetto_2.setPrezzo(15);
        oggetto_2.setDescrizione("Ventola 10x10cm, 12V - 250mA");
        oggetto_2.setImmagine("/Amministratore_di_Sistema/M3/imgs/Ventola.jpg");
        oggetto_2.setQuantita(10);
        listaOggetti.add(oggetto_2);
        // Oggett3
        Oggetti oggetto_3 = new Oggetti();
        oggetto_3.setId(3);
        oggetto_3.setNome("Mouse");
        oggetto_3.setPrezzo(49);
        oggetto_3.setDescrizione("Microsoft Mouse");
        oggetto_3.setImmagine("/Amministratore_di_Sistema/M3/imgs/Mouse.jpg");
        oggetto_3.setQuantita(23);
        listaOggetti.add(oggetto_3);
        

        // Cliente 1
        Cliente client_1 = new Cliente();
        client_1.setUsername("FedericoPorra");
        client_1.setPassword("fed3");
        client_1.setNome("Federico");
        client_1.setCognome("Porrà");
        client_1.setId(0);
        client_1.setSaldo(1);
        
        arrayOggettiComprati_cliente.add(oggetto_3);
        arrayOggettiComprati_cliente.add(oggetto_1);
        client_1.setOggettiComprati(arrayOggettiComprati_cliente);
        listaUtenti.add(client_1);

       

        // Venditore 1
        Venditore venditore_1 = new Venditore();
        venditore_1.setUsername("FabioPerra");
        venditore_1.setPassword("fabi0");
        venditore_1.setNome("Fabio");
        venditore_1.setCognome("Perra");
        venditore_1.setId(2);
        venditore_1.setSaldo(200);
        
        arrayOggettiVenduti_venditore.add(oggetto_1);
        arrayOggettiVenduti_venditore.add(oggetto_2);
        venditore_1.setOggettiVenduti(arrayOggettiVenduti_venditore);
        listaUtenti.add(venditore_1);
        
        
       
        
        return listaUtenti;
    }
    
}
