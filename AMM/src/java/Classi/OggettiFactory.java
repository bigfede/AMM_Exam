
package Classi;

import java.util.ArrayList;


public class OggettiFactory {

    private static OggettiFactory singleton;
    
    private ArrayList<Oggetti> arrayOggettiComprati_cliente = new ArrayList<>();
    private ArrayList<Oggetti> arrayOggettiVenduti_venditore = new ArrayList<>();
    
    
    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }

    /* Costruttore */
    private OggettiFactory() {

    }

    
    
    
    public ArrayList<Oggetti> getOggettiVendutiList(){
        
        return arrayOggettiVenduti_venditore;
    
    }
        
    public ArrayList<Oggetti> getOggettiCompratiList(){
        
        return arrayOggettiComprati_cliente;
    
    }
    
    public void addOggettoVenditore(Oggetti object)
    {
        arrayOggettiVenduti_venditore.add(object);
    
    }
    
    public ArrayList<Oggetti> getObjectList() {
        ArrayList<Oggetti> listaOggetti = new ArrayList<>();
       
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
        

       
        
        
       

      
        
       
        
        return listaOggetti;
    }
    
}
