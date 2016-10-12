
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
import pojo.Seguimiento;
import pojo.Ticket;
import structuras.DataTableObject;


public class ServletVerAnalista extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();           
            DaoAnalista daoAnalista = new DaoAnalista();  
          
            List<Analista> seguimientos = daoAnalista.listAll();
            DataTableObject dataTableObject = new DataTableObject();
            
            //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
            //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
            List<Object> objectAnalistas = new ArrayList<>();
            
            for (Iterator analistaIterator = seguimientos.iterator(); 
                 analistaIterator.hasNext();
                )
            {
            Analista analista = (Analista) analistaIterator.next(); 
            List<Object> object = new ArrayList<>();            
            object.add(analista.getIdAnalista());
            object.add(analista.getApellido());
            object.add(analista.getNombre());
            object.add(analista.getUsuario());
            object.add(analista.getPassword());
            objectAnalistas.add(object);
            }
            
            dataTableObject.setAaData(objectAnalistas);     

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            out.print(json);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
