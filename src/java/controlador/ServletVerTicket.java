/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoTicket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
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
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try 
        {
            String valTicket = String.valueOf(request.getParameter("id"));
            
            int idTicket = Integer.parseInt(valTicket);              
            
            DaoTicket daoTicket = new DaoTicket(); 
                    
            response.setContentType("application/json");
            
            Ticket ticket = daoTicket.getByIdObject(idTicket);
            
            JSONObject json = new JSONObject();
            json.put("titulo", ticket.getTitulo());
            json.put("servicio", ticket.getServicio().getIdServicioModulo());
            json.put("modulo", ticket.getModulo().getIdModulo());
            json.put("servicio_modulo", ticket.getServicioModulo().getIdServicioModulo());
            json.put("servidor",ticket.getServidor().getIdServidor());      
            json.put("impacto", ticket.getImpacto().getIdImpacto());
            json.put("inicio", ticket.getFechaInicio());
            json.put("final", ticket.getFechaFin());
            json.put("estado", ticket.getEstado().getIdEstado());
            json.put("descripcion", ticket.getDescripcion());
            json.put("causa", ticket.getCausa());
            json.put("solucion", ticket.getSolucion());
            
            
            response.setContentType("application/json");
            response.getWriter().write(json.toString());
            
            //out.println(name + " " + text);
        } catch (JSONException ex) {
            Logger.getLogger(ServletVerTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
