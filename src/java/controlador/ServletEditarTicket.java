
package controlador;

import structuras.DataTableObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoSeguimiento;
import dao.DaoTicket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Seguimiento;
import pojo.Ticket;


public class ServletEditarTicket extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            int idTicket = Integer.parseInt(request.getParameter("idTicket"));
            
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();           
            DaoTicket daoTicket = new DaoTicket();  
            
            
            
            Ticket ticket = daoTicket.getByIdObject(idTicket);
            

            DataTableObject dataTableObject = new DataTableObject();
            dataTableObject.setAaData((List<Object>) ticket);
     

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
