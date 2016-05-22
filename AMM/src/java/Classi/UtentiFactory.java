
package Classi;

import java.util.ArrayList;
import java.sql.*;


public class UtentiFactory {

    private static UtentiFactory singleton;
    private String connectionString;
    
    
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }

    /* Costruttore */
    private UtentiFactory() {

    }


        public Utente getUtente(String username, String password)
    {
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "fede", "fede");
            //Cliente, sql command
            String query = "select * from clienti where password = ? and username = ? ";
                    
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Cliente cliente_1 = new Cliente();
                cliente_1.id = set.getInt("id");
                cliente_1.nome = set.getString("nome");
                cliente_1.cognome = set.getString("cognome");
                cliente_1.username = set.getString("username");
                cliente_1.password = set.getString("password");
                cliente_1.email = set.getString("email");
                cliente_1.indirizzo = set.getString("indirizzo");
                cliente_1.saldocliente = set.getFloat("saldo_cliente");
                stmt.close();
                conn.close();              
                return cliente_1;
            }
            
            // Venditore
            // sql command
            query = "select * from venditori where password = ? and username = ? ";
            stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            set = stmt.executeQuery();
            
            if(set.next())
            {
                Venditore venditore_1 = new Venditore();
                venditore_1.id = set.getInt("id");
                venditore_1.nome = set.getString("nome");
                venditore_1.cognome = set.getString("cognome");
                venditore_1.username = set.getString("username");
                venditore_1.password = set.getString("password");
                venditore_1.email = set.getString("email");
                venditore_1.indirizzo = set.getString("indirizzo");
                venditore_1.saldovenditore = set.getFloat("saldo_venditore");
                set.close();
                stmt.close();
                conn.close();
                return venditore_1;
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
        return null;
    }
       public Venditore findSeller(int id) //passato l'id del venditore restituisce un oggetto venditore
    { 
        
        
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fede", "fede");
            Statement stmt = conn.createStatement();
            String query = "select * from venditori where id = "+id+"";
            ResultSet set = stmt.executeQuery(query);
                // ciclo sulle righe restituite
            if (set.next()) 
            {
                Venditore venditore_1 = new Venditore();
                venditore_1.id = set.getInt("id");
                venditore_1.nome = set.getString("nome");
                venditore_1.cognome = set.getString("cognome");
                venditore_1.username = set.getString("username");
                venditore_1.password = set.getString("password");
                venditore_1.email = set.getString("email");
                venditore_1.indirizzo = set.getString("indirizzo");
                venditore_1.saldovenditore = set.getFloat("saldo_venditore");
                set.close();
                stmt.close();
                conn.close();
                return venditore_1;
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
           public Cliente findClient(int id) //passato l'id del cliente restituisce un oggetto cliente
    { 
        
        
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fede", "fede");
            Statement stmt = conn.createStatement();
            String query = "select * from clienti where id = "+id+"";
            ResultSet set = stmt.executeQuery(query);
                // ciclo sulle righe restituite
            if (set.next()) 
            {
               Cliente cliente_1 = new Cliente();
                cliente_1.id = set.getInt("id");
                cliente_1.nome = set.getString("nome");
                cliente_1.cognome = set.getString("cognome");
                cliente_1.username = set.getString("username");
                cliente_1.password = set.getString("password");
                cliente_1.email = set.getString("email");
                cliente_1.indirizzo = set.getString("indirizzo");
                cliente_1.saldocliente = set.getFloat("saldo_cliente");
                set.close();
                stmt.close();
                conn.close();              
                return cliente_1;
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
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}