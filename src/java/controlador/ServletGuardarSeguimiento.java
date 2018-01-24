/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoTicket;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Seguimiento;
import pojo.Ticket;
import structuras.DataTableObject;

/**
 *
 * @author Giovanni
 */
@WebServlet(name = "ServletGuardarSeguimiento", urlPatterns = {"/ServletGuardarSeguimiento"})
public class ServletGuardarSeguimiento extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String valTicket = String.valueOf(request.getParameter("ticket"));
            
            int idTicket = Integer.parseInt(valTicket);              
            
            DaoTicket daoTicket = new DaoTicket(); 
            
            //Instancia para fecha actual
            Fecha newFecha = new Fecha();
                        
            //Guarda ticket
            Seguimiento seguimientoTicket= new Seguimiento(request.getParameter("descripcionSeguimiento"),newFecha.fechaHoy());    
            
                       
            //VALIDA SI SEGUIMIENTO ESTA EN BLANCO O NO
            if (!seguimientoTicket.getDescripcion().trim().isEmpty() && seguimientoTicket.getDescripcion()!=null){
            //agrega seguimientos despues de haber guardado un ticket
                daoTicket.addSeguimiento(idTicket, seguimientoTicket);  
            }
    
            response.setContentType("application/json");
            
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
