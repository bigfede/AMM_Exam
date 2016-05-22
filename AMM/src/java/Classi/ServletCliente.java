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
        session.setAttribute("oggetti", OggettiFactory.getInstance().getObjectList());
        if(request.getParameter("Compra") != null)
        {
            
             Cliente u = (Cliente) session.getAttribute("cliente");
             Oggetti o = OggettiFactory.getInstance().findObject(Integer.parseInt(request.getParameter("id")));
             String feedback = OggettiFactory.getInstance().makeAcquisto(o, u);
             /*float saldo = u.getSaldo();
             String prezzo_string = request.getParameter("prezzo");
             Float prezzo = Float.parseFloat(prezzo_string);*/
             if (feedback != null)
             {
                if (feedback == "ok"){
                    Cliente c = (Cliente)UtentiFactory.getInstance().findClient(u.getId());
                    
                    session.setAttribute("cliente", c);
                    request.setAttribute("Pagina", "Acquisto");
                    request.setAttribute("Appoggio", "Cliente");
                    request.getRequestDispatcher("/M3/home.jsp").forward(request, response); 
                }
                else if (feedback == "errore")
                {
                    request.setAttribute("Pagina", "Errore");
                    request.setAttribute("Appoggio", "Cliente");
                    request.getRequestDispatcher("/M3/home.jsp").forward(request, response); 
                }
                else if (feedback == "saldo")
                {
                    request.setAttribute("Pagina", "Saldo");
                    request.setAttribute("Appoggio", "Cliente");
                    request.getRequestDispatcher("/M3/home.jsp").forward(request, response); 
                }
             }
             else 
             {
                request.setAttribute("Pagina", "Errore");
                request.setAttribute("Appoggio", "Cliente");
                request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
             }
        }
        
        
        if(request.getParameter("Carrello") != null){
        
            //recupera l'oggetto tramite l'id
            Oggetti obj = OggettiFactory.getInstance().findObject(Integer.parseInt(request.getParameter("id"))); //modificare con medoto ricerca db
            //modo visualizzazione pagina, rende disponibile l'oggetto come attributo
            request.setAttribute("oggetto_comprato", obj);
            request.setAttribute("Pagina", "Riepilogo");
            request.setAttribute("Appoggio", "Cliente");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
                
            
        }
        // controllo sessione: se agià attiva visualizza la pagina cliente
        if(session.getAttribute("sessione").equals("cliente"))
        {       
            request.setAttribute("Appoggio", "Cliente");
            request.setAttribute("Pagina", "Tabella");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);     
        }
        else 
        //altrimenti accesso negato
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
