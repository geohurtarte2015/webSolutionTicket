/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import structuras.DataTableObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoTicket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Seguimiento;
import pojo.Ticket;


public class ServletVerTicket extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          String valTicket = String.valueOf(request.getParameter("idTicket"));
            
          int idTicket = Integer.parseInt(valTicket);
        
            //int idTicket = Integer.parseInt(request.getParameter("idTicketSel"));
            //temporal
            //int idTicket = 2;
            
            
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();           
            DaoTicket daoTicket = new DaoTicket();  
            
            Ticket ticket = daoTicket.getByIdObject(idTicket);
            List<Seguimiento> seguimientos = ticket.getSeguimientos(); 
            DataTableObject dataTableObject = new DataTableObject();
            
            //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
            //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
            List<Object> objectSeguimientos = new ArrayList<>();
            
            for (Iterator seguimientoIterator = seguimientos.iterator(); 
                 seguimientoIterator.hasNext();
                )
            {
            Seguimiento seguimiento = (Seguimiento) seguimientoIterator.next(); 
            List<Object> object = new ArrayList<>();            
            object.add(seguimiento.getId());
            object.add(seguimiento.getFecha());
            object.add(seguimiento.getDescripcion());
            objectSeguimientos.add(object);
            }
            
            dataTableObject.setAaData(objectSeguimientos);     

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            out.print(json);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          doGet(request, response);
    }


}
