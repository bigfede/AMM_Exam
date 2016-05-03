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
@WebServlet(name = "VenditoreServlet", urlPatterns = {"/venditore.html"})
public class VenditoreServlet extends HttpServlet {

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
        
        
        if(request.getParameter("Submit") != null)
        {
            String nome = request.getParameter("nome_prodotto");
            String url = request.getParameter("url_immagine");
            String descrizione = request.getParameter("descrizione");
            String quantita = request.getParameter("quantity");
            int qty = Integer.parseInt(quantita);
            String prezzo = request.getParameter("price");
            int price = Integer.parseInt(prezzo);
            Oggetti obj = new Oggetti();
            obj.setNome(nome);
            obj.setImmagine(url);
            obj.setDescrizione(descrizione);
            obj.setQuantita(qty);
            obj.setPrezzo(price);
            
            request.setAttribute("oggetto", obj);
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Display");
            
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
        }
        if(session.getAttribute("sessione") == "venditore")
        {
            
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Form");
            session.getAttribute("venditore");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
            
              
        }
        else 
        {
        
            request.setAttribute("Appoggio", "Negato");
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
