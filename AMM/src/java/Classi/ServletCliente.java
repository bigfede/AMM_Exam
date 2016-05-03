/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        if(request.getParameter("Compra") != null)
        {
            
             Cliente u = (Cliente) session.getAttribute("cliente");
             int saldo = u.getSaldo();
             String prezzo_string = request.getParameter("prezzo");
             int prezzo = Integer.parseInt(prezzo_string);
             if (saldo > prezzo){
                request.setAttribute("Pagina", "Acquisto");
                request.setAttribute("Appoggio", "Cliente");
                request.getRequestDispatcher("/M3/home.jsp").forward(request, response); 
             }
             else
             {
                request.setAttribute("Pagina", "Errore");
                request.setAttribute("Appoggio", "Cliente");
                request.getRequestDispatcher("/M3/home.jsp").forward(request, response); 
             }
             }
        
        
        if(request.getParameter("Submit") != null){
        
        String codice = request.getParameter("id");
        int code = Integer.parseInt(codice);
        ArrayList<Oggetti> listaOggetti = UtentiFactory.getInstance().getObjectList();
            for(Oggetti o : listaOggetti){
                if (code == o.getId()){
                request.setAttribute("oggetto_comprato", o);
                request.setAttribute("Pagina", "Riepilogo");
                request.setAttribute("Appoggio", "Cliente");
                request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
                }
            }
        }
        
        if(session.getAttribute("sessione") == "cliente")
        {       
            request.setAttribute("Appoggio", "Cliente");
            session.getAttribute("venditore");
            request.setAttribute("Pagina", "Tabella");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
            
              
        }
        else 
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
