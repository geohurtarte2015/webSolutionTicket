/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import dao.DaoGeneric;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Analista;
import structuras.ListObjectJson;


/**
 *
 * @author Giovanni
 */
public class Save extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
   
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();   
        
        String apellido = String.valueOf(request.getParameter("apellido"));
        String nombre = String.valueOf(request.getParameter("nombre"));
        String usuario = String.valueOf(request.getParameter("user"));
        String password = String.valueOf(request.getParameter("password"));
      
        
        Analista analista = new Analista();
        analista.setNombre(nombre);
        analista.setApellido(apellido);
        analista.setPassword(password);
        analista.setUsuario(usuario);
        DaoGeneric daoGeneric = new DaoGeneric();
        daoGeneric.save(analista);
        ListObjectJson listObject = new ListObjectJson();
        out.print(listObject.objectStringJson(analista,"Analista"));
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
