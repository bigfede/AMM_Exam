/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bigfe
 */
@WebServlet(name = "ServletVenditore", urlPatterns = {"/venditore.html"})
public class ServletVenditore extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        
        
        if(request.getParameter("Submit") != null)//inizio aggiunta oggetto in vendita al db
        {
            Oggetti obj = new Oggetti();
            Venditore u = (Venditore) session.getAttribute("venditore"); //recupero l'utente per poter impostare id_venditore all'oggetto
            obj.setNome(request.getParameter("nome_prodotto"));
            obj.setImmagine(request.getParameter("url_immagine"));
            obj.setDescrizione(request.getParameter("descrizione"));
            obj.setQuantita(Integer.parseInt(request.getParameter("quantity")));
            obj.setPrezzo(Float.parseFloat(request.getParameter("price")));
            obj.setCategoria(request.getParameter("categoria"));
            obj.setIdVenditore(u.getId());
            OggettiFactory.getInstance().addOggettoInVendita(obj); //metodo per aggiungere l'oggetto al db.  
            request.setAttribute("oggetto", obj);//oggetto come attributo
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Display"); 
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
        }
        
        else if(request.getParameter("Lista") != null)//visualizza lista oggetti in vendita dal venditore corrente
        {
            Venditore u = (Venditore) session.getAttribute("venditore");//recupera il venditore dalla sessione
            session.setAttribute("oggetti", OggettiFactory.getInstance().getObjectListUser(u.getId())); //passato l'id del venditore restituisce la lista degli oggetti in vendita da lui
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Tabella");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
        }
        
        else if(request.getParameter("Elimina") != null)//per eliminare un oggetto in vendita
        {
            OggettiFactory.getInstance().delOggetto(Integer.parseInt(request.getParameter("id")));//passato l'id dell'oggetto tramite hidden field, cancella l'oggetto
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Rimosso");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
        }
        
        else if(request.getParameter("Modifica") != null)//per modificare l'oggetto in vendita
        {
            Oggetti o = OggettiFactory.getInstance().findObject(Integer.parseInt(request.getParameter("id")));//dato l'id dell'oggetto tramite hidden field recupera tutti gli attributi
            request.setAttribute("oggetto", o);
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Form_modifica");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
        }
        
        else if(request.getParameter("ConfermaModifica")!= null)//per inviare al db le modifiche sul oggetto
        {
            Oggetti oggetto_nuovo = new Oggetti();
            oggetto_nuovo.setId(Integer.parseInt(request.getParameter("id")));
            oggetto_nuovo.setNome(request.getParameter("nome_prodotto"));
            oggetto_nuovo.setDescrizione(request.getParameter("descrizione"));
            oggetto_nuovo.setCategoria(request.getParameter("categoria"));
            oggetto_nuovo.setQuantita(Integer.parseInt(request.getParameter("quantita")));
            oggetto_nuovo.setImmagine(request.getParameter("immagine"));
            oggetto_nuovo.setPrezzo(Float.parseFloat(request.getParameter("prezzo")));
            boolean controllo = OggettiFactory.getInstance().modObject(oggetto_nuovo);//metodo per modificare l'oggetto, se è true tutto ok
            if (controllo == true)
            {
            Venditore u = (Venditore) session.getAttribute("venditore");

            session.setAttribute("oggetti", OggettiFactory.getInstance().getObjectListUser(u.getId()));
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Tabella");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
            }   
            else//se errore fa visualizzare nuovamente l'oggetto da modificare senza effettuare cambiamenti
            {
            Oggetti o = OggettiFactory.getInstance().findObject(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("oggetto", o);
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Errore", "Modifica");
            request.setAttribute("Pagina", "Form_modifica");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
            }
        }//richiama il metodo modObject della classe factory passandogli l'oggetto da modificare, se il risultato è true fa vedere la tabella aggionata altrimenti, errore.
        
        else if(session.getAttribute("sessione").equals("venditore")) //controlla che la sessione attiva sia di tipo venditore
        { 
            request.setAttribute("Appoggio", "Venditore"); // imposta alla chiave Appoggio il valore Venditore, così da visualizzare correttamente la home
            request.setAttribute("Pagina", "Form");         // imposta alla chiave Pagina il valore Form per visualizzare il form inserimento dati
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
   
        }
        else //se non c'è sessione attiva mostra un messaggio di accesso negato
        {
        
            request.setAttribute("Appoggio", "Negato");
            request.setAttribute("Tipo", "venditore");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
