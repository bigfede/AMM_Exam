
package Classi;

public abstract class Utente { /*prima era di tipo abstract*/
    /* Attributi */
    protected int id;
    protected String nome;
    protected String cognome;
    protected String username;
    protected String password;
    protected String email;
    protected String indirizzo;
    

    /**
     *
     */
    
    
    
    /* Costruttore */
    public Utente()
    {
        id = 0;
        nome = "";
        cognome = "";
        username="";
        password="";
        email="";
        indirizzo="";
        
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
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public void setIndirizzo(String indirizzo)
    {
        this.indirizzo = indirizzo;
    
    }
    public void setEmail(String email)
    {
        this.email = email;
    
    }
    public String getIndirizzo()
    {
      return indirizzo;  
    }
    
    public String getEmail()
    {
      return email;  
    }
}
