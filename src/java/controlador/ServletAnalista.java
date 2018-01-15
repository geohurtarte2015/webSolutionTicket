/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoAnalista;
import dao.DaoTicket;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Analista;
import pojo.Seguimiento;
import pojo.Ticket;
import structuras.DataTableObject;

/**
 *
 * @author edgar.hurtarte
 */
public class ServletAnalista extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("application/json");
        String tipoTransaccion= String.valueOf(request.getParameter("transaccion"));
        PrintWriter outInitial = response.getWriter();
        
        if(tipoTransaccion.equals("inicializar")){
        ListJson listJson = new ListJson();                
        String json = listJson.listAll();
        System.out.println("Resultado despues de inicializar "+json);
        outInitial.print(json);
        ServletAnalista.super.destroy();
        }
        
        
        if(tipoTransaccion.equals("eliminar")){            
            
            String idAnalista = String.valueOf(request.getParameter("idAnalista"));
            this.delete(response, idAnalista);
            ListJson listJson = new ListJson();                
            String json = listJson.listAll();
            System.out.println("Resultado despues de eliminar "+json);
            outInitial.print(json);  
            ServletAnalista.super.destroy();
        }
        
        if (tipoTransaccion.equals("guardar")){
            String apellido = String.valueOf(request.getParameter("analistaApellido"));
            String nombre = String.valueOf(request.getParameter("analistaNombre"));
            String usuario = String.valueOf(request.getParameter("analistaUsuario"));
            String password = String.valueOf(request.getParameter("analistaPassword"));
            this.save(response, apellido, nombre, usuario, password);
            ServletAnalista.super.destroy();
            //this.listAll(response);
            //String json = this.listAll(response);
            //System.out.println("Resultado despues de guardar "+json);
            //outInitial.print(json);
           
        }
        
    }
    
     private void save(HttpServletResponse response, String apellido, String nombre, String usuario, String password) throws IOException{
 
         
        DaoAnalista daoAnalista = new DaoAnalista();
        Analista analista = new Analista(nombre,apellido,usuario,password);
        daoAnalista.save(analista);
        ListJson listJson = new ListJson();
        listJson.listAll();
        
    }
    
    private void delete(HttpServletResponse response,String idAnalista) throws IOException{
    
        String resp=null;    
        int idAnalistaInteger = Integer.parseInt(idAnalista);
                  
        DaoAnalista daoAnalista = new DaoAnalista();  
        resp= daoAnalista.delete(idAnalistaInteger);
        
        PrintWriter outHtml = response.getWriter(); 
        if(!resp.contains("ok")){
            response.setContentType("text/html;charset=UTF-8");
            
            if(resp.contains("org.hibernate.exception.ConstraintViolationException: could not execute statement")){
            outHtml.println("Error datos con dependencia");
            }else{
            outHtml.println("Error al eliminar");
            }
            
        }else{
            System.out.println("Eliminado");
            //outHtml.println("Eliminado");
        }
            outHtml.close();
            
    }
    

    
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Error al eliminar";
    }

}
