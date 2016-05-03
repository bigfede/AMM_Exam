/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.ArrayList;

/**
 *
 * @author bigfe
 */
public class OggettiFactory {
   

    private static OggettiFactory singleton;

    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }

    /* Costruttore */
    private OggettiFactory() {

    }

    public ArrayList<Oggetti> getObjectList() {
        ArrayList<Oggetti> listaOggetti = new ArrayList<>();
        // Oggett1         
        Oggetti oggetto_1 = new Oggetti();
        oggetto_1.setId(1);
        oggetto_1.setNome("Resistenza");
        oggetto_1.setPrezzo(10);
        oggetto_1.setDescrizione("Resistenza da 10kOhm");
        oggetto_1.setImmagine("/M3/imgs/Resistenza.jpg");
        // Oggett2
        Oggetti oggetto_2 = new Oggetti();
        oggetto_2.setId(2);
        oggetto_2.setNome("Ventola");
        oggetto_2.setPrezzo(15);
        oggetto_2.setDescrizione("Ventola 10x10cm, 12V - 250mA");
        oggetto_2.setImmagine("/M3/imgs/Ventola.jpg");
        // Oggett3
        Oggetti oggetto_3 = new Oggetti();
        oggetto_3.setId(3);
        oggetto_3.setNome("Mouse");
        oggetto_3.setPrezzo(49);
        oggetto_3.setDescrizione("Microsoft Mouse");
        oggetto_3.setImmagine("/M3/imgs/Mouse.jpg");

        
        
        return listaOggetti;
    }
}
    

