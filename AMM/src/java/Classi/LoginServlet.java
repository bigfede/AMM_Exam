
package Classi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class LoginServlet extends HttpServlet {
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();        
            

        if(request.getParameter("Submit") != null)
        {
            // Preleva i dati inseriti dall'utente, chiama un metodo per cercare l'utente
            
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            Utente u = UtentiFactory.getInstance().getUtente(username, password); 
                if(u != null)//se l'utente è presente nel db sarà diverso da null
                {             
                    if (u instanceof Cliente) 
                    {
                        session.setAttribute("sessione", "cliente");//imposta la sessione di tipo cliente
                        request.setAttribute("Appoggio", "Cliente");//imposta la home.jsp in cliente
                        request.setAttribute("Pagina", "Tabella");//dentro form_cliente.jsp visualizza la tabella
                        session.setAttribute("cliente", u);//imposta il cliente come oggetto di sessione
                        session.setAttribute("oggetti", OggettiFactory.getInstance().getObjectList());//imposta la lista oggetti come oggetto di sessione
                        request.getRequestDispatcher("/M3/home.jsp").forward(request, response);    
                    }
                    else
                    {   //se non è cliente può essere solo venditore!
                        session.setAttribute("sessione", "venditore");//imposta la sessione di tipo venditore
                        request.setAttribute("Appoggio", "Venditore");//imposta la home.jsp in venditore
                        request.setAttribute("Pagina", "Form");//imposta la tabella in form_venditore.jsp 
                        session.setAttribute("venditore", u);//imposta il venditore come oggetto di sessione
                        request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
                    }                    
                }
                else {request.setAttribute("errore", "Username o Password errati");}//se non trova nessun utente fa visualizzare un errore
            
        }
        if(request.getParameter("Invalidate") != null)//per invalidare la sessione, ricarica il form login nella home.jsp
            {
                session.invalidate();
                request.setAttribute("Appoggio", "Login");
                request.getRequestDispatcher("/M3/home.jsp").forward(request, response);     
            }
        if(session.getAttribute("sessione") == "venditore")//se è già presente una sessione attiva di tipo venditore
        {
            request.setAttribute("Appoggio", "Venditore");
            request.setAttribute("Pagina", "Form");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
        }
        
        if(session.getAttribute("sessione") == "cliente")//se è già presente una sessione attiva di  tipo cliente
        {
        
            request.setAttribute("Pagina", "Tabella");
            request.setAttribute("Appoggio", "Cliente");
            request.getRequestDispatcher("/M3/home.jsp").forward(request, response);
        }
       
       else //se non c'è una sessione attiva visualizza il form di login attraverso la home.jsp
       {
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
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        UtentiFactory.getInstance().setConnectionString(dbConnection);
        OggettiFactory.getInstance().setConnectionString(dbConnection);
    }
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
