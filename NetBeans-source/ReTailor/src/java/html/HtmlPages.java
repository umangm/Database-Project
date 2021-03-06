/*
 * This file handles the login and session details
 */

/**
 *
 * @author
 * ReTailor
 */

package html;

import database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "HtmlPages", urlPatterns = {"/HtmlPages"})
public class HtmlPages extends HttpServlet {
    DatabaseConnection cc=new DatabaseConnection();
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HtmlPages</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HtmlPages at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flag = null;
        String username=null,password=null;
        try{
            flag = request.getParameter("logoutflag");
        }catch(Exception e){flag = null;}
        
        HttpSession session = request.getSession();
        if(flag!=null){
            session.setAttribute("userid", -1);
            session.setAttribute("name", null);
        }
        else{
            username = request.getParameter("username").toString();
            password = request.getParameter("password").toString();
            try{
                ResultSet rs = cc.loginCheck(username, password);
                if(rs.next()){
                    session.setAttribute("userid", rs.getInt(1));
                    session.setAttribute("name", rs.getString(2));
                }
                else{
                    session.setAttribute("userid", -1);
                    session.setAttribute("name", null);
                }
            }catch(Exception e){}
        }
        response.sendRedirect("index.jsp");
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
