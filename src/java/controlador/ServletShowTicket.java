
package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoAnalista;
import dao.DaoTicket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Analista;
import pojo.Ticket;
import structuras.DataTableObject;

public class ServletShowTicket extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private String listAll(HttpServletResponse response) throws IOException
        {
            
        DaoAnalista daoAnalista = new DaoAnalista();      
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter(); 
        
        DaoTicket daoTicket= new DaoTicket();
        
        List<Ticket> tickets = daoTicket.listAll();
        
        DataTableObject dataTableObject = new DataTableObject();
        
        List<Object> objectTickets = new ArrayList<>();
        
        for (Iterator ticketIterator = tickets.iterator(); 
                 ticketIterator.hasNext();
                )
         {
             
         Ticket ticketObject = (Ticket) ticketIterator.next(); 
         List<Object> object = new ArrayList<>();            
            object.add(ticketObject.getId());
            object.add(ticketObject.getTitulo());
            object.add(ticketObject.getAnalista());
            object.add(ticketObject.getFecha());
       
         objectTickets.add(object);
         }
            
            dataTableObject.setAaData(objectTickets);     

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            
        return json;
        }




}
