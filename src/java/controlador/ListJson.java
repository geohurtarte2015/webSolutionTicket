/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoAnalista;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import pojo.Analista;
import structuras.DataTableObject;

/**
 *
 * @author Giovanni
 */
public class ListJson {
    
    
    public String listAll() throws IOException
        {
            DaoAnalista daoAnalista = new DaoAnalista();  
          
            List<Analista> analistas = daoAnalista.listAll();
            DataTableObject dataTableObject = new DataTableObject();
            
            //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
            //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
            List<Object> objectAnalistas = new ArrayList<>();
            
            for (Iterator analistaIterator = analistas.iterator(); 
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
            //System.out.println(json);
            return json;
        }
    
}
