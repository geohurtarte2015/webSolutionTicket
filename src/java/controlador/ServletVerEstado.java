/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoAnalista;
import dao.DaoEstado;
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
import pojo.Estado;
import structuras.DataTableObject;

/**
 *
 * @author Giovanni
 */
public class ServletVerEstado extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();           
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
            out.print(json);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
