/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;



import dao.DaoAnalista;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Analista;

/**
 *
 * @author Giovanni
 */
public class SaveAnalist extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
    
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("application/json");
        PrintWriter outInitial = response.getWriter();
        String apellido = String.valueOf(request.getParameter("analistaApellido"));
        String nombre = String.valueOf(request.getParameter("analistaNombre"));
        String usuario = String.valueOf(request.getParameter("analistaUsuario"));
        String password = String.valueOf(request.getParameter("analistaPassword"));
        
        DaoAnalista daoAnalista = new DaoAnalista();
        Analista analista = new Analista(nombre,apellido,usuario,password);
        daoAnalista.save(analista);
        ListJson listJson = new ListJson();
        String json = listJson.listAll();
        System.out.println("Resultado despues de guardar "+json);
        outInitial.print(json);
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
