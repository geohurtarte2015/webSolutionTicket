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
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Seguimiento;
import pojo.Ticket;
import structuras.DataTableObject;



public class ServletGuardarTicket extends HttpServlet {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //TRAE LOS PARAMETROS ENVIADOS POR AJAX DESDE EL SERVLET
            String titulo = String.valueOf(request.getParameter("titulo"));
            String idModulo = String.valueOf(request.getParameter("modulo"));
            String idServicio = String.valueOf(request.getParameter("servicio"));
            String idEstado = String.valueOf(request.getParameter("estado"));
            String idServicioModulo = String.valueOf(request.getParameter("servicioModulo"));
            String idServidor  = String.valueOf(request.getParameter("nombreServidor"));
            String idImpacto = String.valueOf(request.getParameter("impacto"));
            String idRaiz="1";
            String idAnalista = String.valueOf(request.getParameter("analista"));
            String fechaInicio = String.valueOf(request.getParameter("fechaInicio"));
            String fechaFin = String.valueOf(request.getParameter("fechaFin"));
            String descripcion = String.valueOf(request.getParameter("descripcion"));
            String causa = String.valueOf(request.getParameter("causa"));
            String solucion = String.valueOf(request.getParameter("solucion"));   
            
            
            
            //Instancia de DAO
            DaoTicket daoTicket = new DaoTicket();  
            
            //Guarda ticket
            Ticket newTicket= new Ticket( titulo,  fechaInicio,  fechaFin,  descripcion,  causa,  solucion);
            
            daoTicket.save(Integer.parseInt(idServidor), Integer.parseInt(idEstado), Integer.parseInt(idImpacto),Integer.parseInt(idRaiz), Integer.parseInt(idAnalista),Integer.parseInt(idServicioModulo),Integer.parseInt(idModulo),Integer.parseInt(idServicio),newTicket);
            
            response.sendRedirect("principal.jsp");
            
            
               
            
                        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          doGet(request, response);
        
    }
    

    
  

}
