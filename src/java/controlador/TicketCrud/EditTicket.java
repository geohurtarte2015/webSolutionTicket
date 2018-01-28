
package controlador.TicketCrud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static java.lang.System.out;
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
import pojo.Ticket;
import structuras.DataTableObject;


public class EditTicket extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String json=null;
            
            this.edit(response, request);
            
            json = this.listAll(response);
            out.print(json);  
           
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          doGet(request, response);
        
    }
    
     private String listAll(HttpServletResponse response) throws IOException
        {
            
        DaoTicket daoTicket = new DaoTicket();      
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter(); 
        //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
        //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
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
            object.add(ticketObject.getAnalista().getNombre()+" ");
            object.add(ticketObject.getFecha());
       
         objectTickets.add(object);
         }
            
            dataTableObject.setAaData(objectTickets);     

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            
        return json;
        }
     
     
     private void edit(HttpServletResponse response,HttpServletRequest request) throws IOException{
        //TRAE LOS PARAMETROS ENVIADOS POR AJAX DESDE EL SERVLET
            String idTicket = String.valueOf(request.getParameter("idTicket"));
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
            
            String resp=null;  
            
        //Guarda ticket
         Ticket newTicket= new Ticket( titulo,  fechaInicio,  fechaFin,  descripcion,  causa,  solucion);    
        //Instancia de DAO
        DaoTicket daoTicket = new DaoTicket();  
        Ticket ticket = new Ticket();
        ticket=daoTicket.update(Integer.parseInt(idTicket),Integer.parseInt(idServidor), Integer.parseInt(idEstado), Integer.parseInt(idImpacto),Integer.parseInt(idRaiz), Integer.parseInt(idAnalista),Integer.parseInt(idServicioModulo),Integer.parseInt(idModulo),Integer.parseInt(idServicio),causa,descripcion,fechaFin,fechaInicio,solucion,titulo); 
        
        PrintWriter outHtml = response.getWriter(); 
        if(!resp.contains("ok")){
            response.setContentType("text/html;charset=UTF-8");
            
            if(resp.contains("org.hibernate.exception.ConstraintViolationException: could not execute statement")){
            outHtml.println("Error al tratar de guardar");
            }else{
            outHtml.println("Error al guardar");
            }
            
        }else{
            outHtml.println("Modificado");
        }
            outHtml.close();
            
    }
    

    
  

}
