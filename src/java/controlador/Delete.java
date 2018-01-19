/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import dao.DaoGeneric;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Delete extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                processRequest(request, response);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));        

        DaoGeneric daoGeneric = new DaoGeneric();
        daoGeneric.delete(id, Analista.class);
        ListObjectJson listObject = new ListObjectJson();        
        out.print(listObject.objectStringJson(new Analista(),"Analista"));
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
