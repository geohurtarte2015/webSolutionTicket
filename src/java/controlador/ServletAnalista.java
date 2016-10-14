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
        
        String tipoTransaccion= String.valueOf(request.getParameter("transaccion"));
        
        if(tipoTransaccion.equals("eliminar")){
            String json=null;
            String idAnalista = String.valueOf(request.getParameter("idAnalista"));
            this.delete(response, idAnalista);
            json = this.listAll(response);
            out.print(json);  
        }
        
        if (tipoTransaccion.equals("guardar")){
            String json=null;
            String apellido = String.valueOf(request.getParameter("analistaApellido"));
            String nombre = String.valueOf(request.getParameter("analistaNombre"));
            String usuario = String.valueOf(request.getParameter("analistaUsuario"));
            String password = String.valueOf(request.getParameter("analistaPassword"));
            this.save(response, apellido, nombre, usuario, password);
            this.listAll(response);
            json = this.listAll(response);
            out.print(json);
        }
        
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
            outHtml.println("Eliminado");
        }
            outHtml.close();
            
    }
    
    private String listAll(HttpServletResponse response) throws IOException
        {
            
        DaoAnalista daoAnalista = new DaoAnalista();      
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter(); 
        //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
        //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
        List<Analista> analistas = daoAnalista.listAll();
        DataTableObject dataTableObject = new DataTableObject();
        
        List<Object> objectAnalistas = new ArrayList<>();
        
        for (Iterator analistaIterator = analistas.iterator(); 
                 analistaIterator.hasNext();
                )
         {
             
         Analista analistaObject = (Analista) analistaIterator.next(); 
         List<Object> object = new ArrayList<>();            
            object.add(analistaObject.getIdAnalista());
            object.add(analistaObject.getApellido());
            object.add(analistaObject.getNombre());
            object.add(analistaObject.getUsuario());
            object.add(analistaObject.getPassword());
         objectAnalistas.add(object);
         }
            
            dataTableObject.setAaData(objectAnalistas);     

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            
        return json;
        }
    
    private void save(HttpServletResponse response, String apellido, String nombre, String usuario, String password){
    DaoAnalista daoAnalista = new DaoAnalista();
    Analista analista = new Analista(nombre,apellido,usuario,password);
    daoAnalista.save(analista);
    
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
