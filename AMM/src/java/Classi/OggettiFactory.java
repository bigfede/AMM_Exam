
package Classi;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OggettiFactory {

    private static OggettiFactory singleton;
    private String connectionString;
    
    
    
    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }

    /* Costruttore */
    private OggettiFactory() {

    }

    
    
    public ArrayList<Oggetti> getObjectListUser(int id) {
        ArrayList<Oggetti> listaOggetti = new ArrayList<>();
        
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fede", "fede");
            Statement stmt = conn.createStatement();
            String query = "select * from oggetti where id_venditore = "+ id +"";
            ResultSet set = stmt.executeQuery(query);
                // ciclo sulle righe restituite
            while (set.next()) 
            {
                Oggetti current = new Oggetti();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setDescrizione(set.getString("descrizione"));
                current.setQuantita(set.getInt("quantita"));
                current.setCategoria(set.getString("categoria"));
                current.setImmagine(set.getString("url_immagine"));
                current.setPrezzo(set.getFloat("prezzo"));
                current.setIdVenditore(set.getInt("id_venditore"));
                listaOggetti.add(current);
            }
           
            stmt.close();
            conn.close();
            } 
        catch (SQLException e) 
            {
                e.printStackTrace();
            }
        return listaOggetti;
    } //passatogli l'id del venditore resistuisce la lista degli oggetti venduti SOLO da quel venditore
    
    
    public ArrayList<Oggetti> getObjectList() {
        ArrayList<Oggetti> listaOggetti = new ArrayList<>();
        
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fede", "fede");
            Statement stmt = conn.createStatement();
            String query = "select * from oggetti";
            ResultSet set = stmt.executeQuery(query);
                // ciclo sulle righe restituite
            while (set.next()) 
            {
                Oggetti current = new Oggetti();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setDescrizione(set.getString("descrizione"));
                current.setQuantita(set.getInt("quantita"));
                current.setCategoria(set.getString("categoria"));
                current.setImmagine(set.getString("url_immagine"));
                current.setPrezzo(set.getFloat("prezzo"));
                current.setIdVenditore(set.getInt("id_venditore"));
                listaOggetti.add(current);
            }
           
            stmt.close();
            conn.close();
            } 
        catch (SQLException e) 
            {
                e.printStackTrace();
            }
        return listaOggetti;
    } //restituisce la lista di tutti gli oggetti in vendita dal db
    
    
    public void addOggettoInVendita(Oggetti obj) //passandogli un oggetto di classe Oggetti e l'id del venditore provvede ad aggiungerlo al DB
    {
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "fede", "fede");
            //sql query per l'inserimento
            String query = "insert into oggetti (id, nome, descrizione, categoria, quantita, url_immagine, prezzo, id_venditore) values (default,?,?,?,?,?,?,? ) ";
                    
            PreparedStatement stmt = conn.prepareStatement(query);
           
             
            
            // dati
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDescrizione());
            stmt.setString(3, obj.getCategoria());
            stmt.setInt(4, obj.getQuantita());
            stmt.setString(5, obj.getImmagine());
            stmt.setFloat(6, obj.getPrezzo());
            stmt.setInt(7, obj.getIdVenditore());
            int set = stmt.executeUpdate();
            stmt.close();
            conn.close();              

        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
       
    }
    
    public void delOggetto(int id) //passato l'id dell'oggetto provvede a cancellarlo dal db
    {
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "fede", "fede");
            //sql query per l'inserimento
            String query = "delete from oggetti where id = "+id+" ";
                    
            PreparedStatement stmt = conn.prepareStatement(query);
            int set = stmt.executeUpdate();
            stmt.close();
            conn.close();              

        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
       
    }
    public Oggetti findObject(int id) //passato l'id del oggetto recupera tutti i dati dell'oggetto
    { 
        
        
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fede", "fede");
            Statement stmt = conn.createStatement();
            String query = "select * from oggetti where id = "+id+"";
            ResultSet set = stmt.executeQuery(query);
                // ciclo sulle righe restituite
            if (set.next()) 
            {
                Oggetti current = new Oggetti();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setDescrizione(set.getString("descrizione"));
                current.setQuantita(set.getInt("quantita"));
                current.setCategoria(set.getString("categoria"));
                current.setImmagine(set.getString("url_immagine"));
                current.setPrezzo(set.getFloat("prezzo"));
                current.setIdVenditore(set.getInt("id_venditore"));
                set.close();
                stmt.close();
                conn.close();
                return current;
            }
            set.close();
            stmt.close();
            conn.close();
            } 
        catch (SQLException e) 
            {
                e.printStackTrace();
            }
        return null;
    }
    public boolean modObject(Oggetti o) // passato l'id di un oggetto provvede a modificare i valori, se restituisce true ok, se false qualcosa è andato male
    { 
        
        try {
            Connection conn = DriverManager
                    .getConnection(connectionString, "fede", "fede");
            String query = "update oggetti set nome = ?, descrizione = ?, categoria = ?, quantita = ?, url_immagine = ?, prezzo = ? where id = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
                
            
            stmt.setString(1, o.getNome());
            stmt.setString(2, o.getDescrizione());
            stmt.setString(3, o.getCategoria());
            stmt.setInt(4, o.getQuantita());
            stmt.setString(5, o.getImmagine());
            stmt.setFloat(6, o.getPrezzo());
            stmt.setInt(7, o.getId());
            stmt.executeUpdate();    
            
            stmt.close();
            conn.close();
            return true;
            
            } 
        catch (SQLException ex) 
            {
               Logger.getLogger(OggettiFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return false;
        
    } 
    
    public String makeAcquisto(Oggetti obj_to_buy, Cliente compratore)throws SQLException //metodo per effettuare un acquisto, passato l'oggetto da comprare e l'utente che lo compra
    {//restituisce tre stringhe possibili, null, ok, saldo
        
        int id_obj = obj_to_buy.getId();//recupera id oggetto da comprare
        int id_seller = obj_to_buy.getIdVenditore();//recupero id venditore dell'oggetto
        int quantita = obj_to_buy.getQuantita();//recupera quantita oggetti disponibili
        int new_quantita = 0;//nuova quantita
        float prezzo = obj_to_buy.getPrezzo();//recupera prezzo oggetto
        int id_cliente = compratore.getId();//recupera id cliente
        float saldo = compratore.getSaldo();//recupera saldo cliente
        Venditore v = UtentiFactory.getInstance().findSeller(id_seller);//questo metodo effettua una connessione al db, va eseguito prima della Connection
        Connection conn = DriverManager.getConnection(connectionString,"fede","fede");//si colega al DB dopo che ha richiesto il venditore
        PreparedStatement aggiornaOggetto = null;
        PreparedStatement cancellaOggetto = null;
        PreparedStatement aggiornaSaldoCliente = null;
        PreparedStatement aggiornaSaldoVenditore = null;
        
        

        // Sql 
        String updateObjQuantity = "update oggetti set quantita = ? where id = "+id_obj+" ";//per aggiornare la quantita di oggetti disponibili
        String deleteObject = "delete from oggetti where id = ? ";//cancellare l'oggetto se disponibili = 1
        String updateClientBalance = "update clienti set saldo_cliente = ? where id="+id_cliente+" "; // aggiorna il saldo del cliente
        String updateSellerBalance = "update venditori set saldo_venditore = ? where id="+id_seller+""; //aggiorna il saldo del venditore
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        try
        {
           conn.setAutoCommit(false);
           aggiornaOggetto = conn.prepareStatement(updateObjQuantity);
           cancellaOggetto = conn.prepareStatement(deleteObject);
           aggiornaSaldoCliente = conn.prepareStatement(updateClientBalance);
           aggiornaSaldoVenditore = conn.prepareStatement(updateSellerBalance);
           // in questo caso non viene gestita l'occasione di oggetti con quantita = 0, si presuppone che un oggetto con tale disponibilità non sia messo in vendita
           if(quantita > 1 && saldo > prezzo) // se il num di oggetti è maggiore di uno aggiorna il numero disponibili. 
           {
                new_quantita = quantita - 1;//calcola la nuova quantita
                float newsaldocliente = saldo - prezzo;
                float newsaldovenditore = v.getSaldo() + prezzo;
                aggiornaOggetto.setInt(1, new_quantita);
                aggiornaSaldoCliente.setFloat(1, newsaldocliente);//calcola saldo cliente
                aggiornaSaldoVenditore.setFloat(1, newsaldovenditore );//calcola saldo venditore
                c1 = aggiornaOggetto.executeUpdate();
                c2 = aggiornaSaldoCliente.executeUpdate();
                c3 = aggiornaSaldoVenditore.executeUpdate();
           }
           else if (quantita == 1 && saldo > prezzo)
           {
                float newsaldocliente = saldo - prezzo;
                float newsaldovenditore = v.getSaldo() + prezzo;
                cancellaOggetto.setInt(1, id_obj);
                aggiornaSaldoCliente.setFloat(1, newsaldocliente);//calcola saldo cliente
                aggiornaSaldoVenditore.setFloat(1, newsaldovenditore );//calcola saldo venditore
                c1 = cancellaOggetto.executeUpdate();
                c2 = aggiornaSaldoCliente.executeUpdate();
                c3 = aggiornaSaldoVenditore.executeUpdate();
           }
           else 
           {
               conn.rollback();
               return "saldo";//se è arrivato in questa else è perchè il saldo disponibile non è sufficiente
           }

           if(c1 != 1 || c2 != 1 || c3 != 1) //controlla che le 3 quey ritornino SOLO 1 come risultato
           {
               conn.rollback(); //se non ritornano 1 rollback
               return "error"; 
           }
           
           conn.commit(); //altrimenti commit e return ok, acquisto avvenuto correttamente
           return "ok";
        }
        catch(SQLException e)
        {
            try
            {
                conn.rollback();
            }
            catch(SQLException e2)
            {
                
            }
        }
        finally
        {
            if(aggiornaOggetto != null)
                aggiornaOggetto.close();
            if(aggiornaSaldoCliente != null)
                aggiornaSaldoCliente.close();
            if(aggiornaSaldoVenditore != null)
                aggiornaSaldoVenditore.close();
            
            conn.setAutoCommit(true);
            conn.close();
        } 
        return null;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
}
    public String getConnectionString(){
	return this.connectionString;
} 
}
