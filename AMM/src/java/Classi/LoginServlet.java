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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.html"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();        
            

        if(request.getParameter("Submit") != null)
        {
            // Preleva i dati inviati
            
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            
            ArrayList<Utente> listaUtenti = UtentiFactory.getInstance().getUserList();
            for(Utente u : listaUtenti)
            {
                if(u.getUsername().equals(username) &&
                   u.getPassword().equals(password))
                {
                    
                
                    
                    if (u instanceof Cliente) 
                    {
                        
                        
                        
                        
                        
                        session.setAttribute("sessione", "cliente");
                        request.setAttribute("Appoggio", "Cliente");
                        request.setAttribute("Pagina", "Tabella");
                        session.setAttribute("cliente",u);
                        session.setAttribute("oggetti", UtentiFactory.getInstance().getObjectList());
                        request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
                   
                        
                        
                    }
                    else
                    {
                        
                        session.setAttribute("sessione", "venditore");
                        request.setAttribute("Appoggio", "Venditore");
                        request.setAttribute("Pagina", "Form");
                        session.setAttribute("venditore", u);

                        request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
                         
                        
                    }                    
                }
                else {request.setAttribute("errore", "Username o Password errati");}
            }
        }
        if(session.getAttribute("sessione") == "venditore"){
        
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Form");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
            
        
        }
        
        if(session.getAttribute("sessione") == "cliente"){
        
            
            request.setAttribute("Pagina", "Tabella");
            request.setAttribute("Appoggio", "Cliente");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
            
        }
       if(request.getParameter("Invalidate") != null)
            {
                session.invalidate();
                request.setAttribute("Appoggio", "Login");
                request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
            }
       else {
       request.setAttribute("Appoggio", "Login");
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
