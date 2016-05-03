/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;


public class Oggetti {
    /* Attributi */
    private int id;
    private String nome;
    private int prezzo;
    private String descrizione;
    private String immagine;
    private int quantity;

    
    
    public Oggetti()
    {
        id = 0;
        nome = "";
        prezzo = 0;
        descrizione = "";
        immagine = "";
        quantity =0;
        
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    public int getPrezzo(){
        return prezzo;
    }
    
    public void setPrezzo(int prezzo){
        
        this.prezzo = prezzo;
    }
    public void setDescrizione(String descrizione){
    
        this.descrizione = descrizione;
        
    }
    public String getDescrizione(){
    
        return descrizione;
            
    }
    public String getImmagine(){

        return immagine;
    }
    
    public void setImmagine(String immagine){
    
        this.immagine = immagine;
    
    }
    public void setQuantita(int quantity)
    {
        this.quantity = quantity;
    
    }
    public int getQuantita()
    {
        return quantity;
    
    }
    
}
