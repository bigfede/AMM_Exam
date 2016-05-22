/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bigfe
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/cliente.html"})
public class ServletCliente extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("oggetti", OggettiFactory.getInstance().getObjectList());//ricarica ogni volta la lista degli oggetti per la sessione
        
        if(request.getParameter("Compra") != null)//usato per effettuare l'acquisto vero e proprio
        {
             Cliente u = (Cliente) session.getAttribute("cliente");//recuper l'utente dalla sessione
             Oggetti o = OggettiFactory.getInstance().findObject(Integer.parseInt(request.getParameter("id")));//prende l'oggetto inserito nel carrello
             String feedback = OggettiFactory.getInstance().makeAcquisto(o, u); //metodo per effettuare l'acquisto, restituisce una stringa di controllo, premde in ingresso l'acquirente e l'oggetto da comprare
             if (feedback != null)//se makeAcquisto restituisce qualcosa valuta cosa restituisce
             {
                if (feedback == "ok")//acquisto avvenuto correttamente
                {
                    Cliente c = (Cliente)UtentiFactory.getInstance().findClient(u.getId());//rende disponibile alla sessione l'utente corrente con i dati aggiornati (saldo)
                    session.setAttribute("cliente", c);
                    request.setAttribute("Pagina", "Acquisto");
                    request.setAttribute("Appoggio", "Cliente");
                    request.getRequestDispatcher("/M3/home.jsp").forward(request, response); 
                }
                else if (feedback == "errore")//errore nelle query, le 3 query hanno restituo più di una riga
                {
                    request.setAttribute("Pagina", "Errore");
                    request.setAttribute("Appoggio", "Cliente");
                    request.getRequestDispatcher("/M3/home.jsp").forward(request, response); 
                }
                else if (feedback == "saldo")//errore saldo insufficiente
                {
                    request.setAttribute("Pagina", "Saldo");
                    request.setAttribute("Appoggio", "Cliente");
                    request.getRequestDispatcher("/M3/home.jsp").forward(request, response); 
                }
             }
             else //la stringa è di tipo null, errore nella transazione
             {
                request.setAttribute("Pagina", "Errore");
                request.setAttribute("Appoggio", "Cliente");
                request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
             }
        }
        
        
        if(request.getParameter("Carrello") != null)//aggiungi l'oggetto desiderato al carrello per confermare l'acquisto
        {
            
            Oggetti obj = OggettiFactory.getInstance().findObject(Integer.parseInt(request.getParameter("id")));//recupera l'oggetto tramite l'id
            request.setAttribute("oggetto_comprato", obj);//modo visualizzazione pagina, rende disponibile l'oggetto come attributo
            request.setAttribute("Pagina", "Riepilogo");
            request.setAttribute("Appoggio", "Cliente");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
                
            
        }
        
        if(session.getAttribute("sessione").equals("cliente"))// controllo sessione: se agià attiva visualizza la pagina cliente
        {       
            request.setAttribute("Appoggio", "Cliente");
            request.setAttribute("Pagina", "Tabella");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);     
        }
        else //altrimenti accesso negato
        
        {
            request.setAttribute("Appoggio", "Negato");
            request.setAttribute("Tipo", "cliente");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
