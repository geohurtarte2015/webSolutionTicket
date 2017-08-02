
package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoAnalista;
import dao.DaoEstado;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Analista;
import pojo.Estado;
import structuras.DataTableObject;


public class ServletEstado extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String tipoTransaccion= String.valueOf(request.getParameter("transaccion"));
        
        if(tipoTransaccion.equals("inicializar")){
            PrintWriter outInitial = response.getWriter();  
            String json = this.listAll(response);
            outInitial.println(json);
        }
        
        
        if(tipoTransaccion.equals("eliminar")){            
            
            String idEstado = String.valueOf(request.getParameter("idEstado"));
            this.delete(response, idEstado);
            String json = this.listAll(response);
            out.print(json);  
        }
        
        if (tipoTransaccion.equals("guardar")){
            
            String descripcion = String.valueOf(request.getParameter("estadoNombre"));
            
            this.save(response,descripcion);
            this.listAll(response);
            String json = this.listAll(response);
            out.print(json);
           
        }
        
    }
    
     private void save(HttpServletResponse response, String descripcion) throws IOException{
        DaoEstado daoEstado = new DaoEstado();
        Estado estado = new Estado(descripcion);
        daoEstado.save(estado);
        PrintWriter outHtml = response.getWriter(); 
        outHtml.println("Guardado");
        outHtml.close();
        
    }
    
    private void delete(HttpServletResponse response,String idEstado) throws IOException{
    
        String resp=null;    
        int idEstadoInteger = Integer.parseInt(idEstado);
                  
        DaoEstado daoEstado = new DaoEstado();  
        resp= daoEstado.delete(idEstadoInteger);
        
        PrintWriter outHtml = response.getWriter(); 
        if(!resp.contains("ok")){
            response.setContentType("text/html;charset=UTF-8");
            
            if(resp.contains("org.hibernate.exception.ConstraintViolationException: could not execute statement")){
            outHtml.println("Error datos con dependencia");
            }else{
            outHtml.println("Error al eliminar");
            }
            
        }else{
            outHtml.println("Eliminado");
        }
            outHtml.close();
            
    }
    
    private String listAll(HttpServletResponse response) throws IOException
        {
            
      response.setContentType("application/json");
                      
            DaoEstado daoEstado = new DaoEstado();  
          
            List<Estado> estados = daoEstado.listAll();
            DataTableObject dataTableObject = new DataTableObject();
            
            //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
            //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
            List<Object> objectEstados = new ArrayList<>();
            
            for (Iterator estadoIterator = estados.iterator(); 
                 estadoIterator.hasNext();
                )
            {
            Estado estado = (Estado) estadoIterator.next(); 
            List<Object> object = new ArrayList<>();            
            object.add(estado.getIdEstado());
            object.add(estado.getDescripcion());           
            objectEstados.add(object);
            }
            
            dataTableObject.setAaData(objectEstados);     

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            return json;
        }
    
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Error al eliminar";
    }

 
   
}
