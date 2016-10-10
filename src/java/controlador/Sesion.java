/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoAnalista;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.Analista;

/**
 *
 * @author Giovanni
 */
public class Sesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            boolean valUsuario = false;
            boolean valPassword = false;
            
            String usuario = request.getParameter("name");
            String password = request.getParameter("pass");    
            
            DaoAnalista daoAnalista = new DaoAnalista();
            List<Analista> nombreAnalista = daoAnalista.getByCondition("usuario", usuario);
            List<Analista> passwordAnalista = daoAnalista.getByCondition("password", password);
            
            valUsuario = (nombreAnalista.size()!=0);
            valPassword = (passwordAnalista.size()!=0);
            
            if (valUsuario && valPassword){
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("id", nombreAnalista.get(0).getIdAnalista());
                httpSession.setAttribute("user", nombreAnalista.get(0).getUsuario());
                httpSession.setAttribute("password", nombreAnalista.get(0).getPassword());
                httpSession.setAttribute("nombre", nombreAnalista.get(0).getNombre());
                httpSession.setAttribute("apellido", nombreAnalista.get(0).getApellido());
                response.sendRedirect("principal.jsp");
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Sesion</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> password o usuario no valido</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            
//            if (valPassword){
//            String usuarioAnalista = nombreAnalista.get(0).getUsuario();
//            System.out.println(usuarioAnalista);
//            }else{
//            System.out.println("Password no valida!");
//            }
            
         
            
            
            
            
            
        } finally{        
            out.close();        
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
