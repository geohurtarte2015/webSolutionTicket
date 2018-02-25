/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.InterfaceCrud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoInterfaz;
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
import pojo.Agencia;
import pojo.Interfaz;
import pojo.Seguimiento;
import pojo.Ticket;
import structuras.DataTableObject;

/**
 *
 * @author Giovanni
 */
public class FindInterface extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valAgencia = String.valueOf(request.getParameter("agencia"));
          
        
      if(valAgencia.equals("null")|| valAgencia.equals(null)|| valAgencia==null){
          valAgencia="0";
        }
          int idAgencia = Integer.parseInt(valAgencia);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();           
            DaoInterfaz daoInterfaz = new DaoInterfaz();  
            
            Agencia agencia = daoInterfaz.getByIdObject(idAgencia);
            List<Interfaz> interfaces = agencia.getInterfaces();
            DataTableObject dataTableObject = new DataTableObject();
            
            //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
            //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
            List<Object> objectSeguimientos = new ArrayList<>();
            
            for (Iterator interfaceIterator = interfaces.iterator(); 
                 interfaceIterator.hasNext();
                )
            {
            Interfaz interfaz = (Interfaz) interfaceIterator.next(); 
            List<Object> object = new ArrayList<>();            
            object.add(interfaz.getId());
            object.add(interfaz.getDescripcion());
            object.add(interfaz.getIp());
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
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
