/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.SeguimientoCrud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controlador.Fecha;
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
public class SaveSeguimiento extends HttpServlet {


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
                            
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          doGet(request, response);
        
    }
    
        
}
