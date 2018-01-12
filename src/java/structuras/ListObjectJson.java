package structuras;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dao.DaoGeneric;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Estado;


public class ListObjectJson {
    
    public String objectStringJson(Object objectType, String stringObject) {
   
    String json = null;
    Class c = objectType.getClass();
    Field[] array = c.getFields(); 
    int heightValue = array.length;

      try {        
            DaoGeneric daoGeneric = new DaoGeneric();  
          
            List<Object> objects = (List<Object>) daoGeneric.listAll(stringObject);
            DataTableObject dataTableObject = new DataTableObject();
            
            //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
            //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
            List<Object> objectList = new ArrayList<>();
            
            for (Iterator estadoIterator = objects.iterator(); 
                 estadoIterator.hasNext();
                )
            {
                Object baseObject = estadoIterator.next(); 
                Class classObject = baseObject.getClass();
                Field[] arrayClass = classObject.getFields(); 
                
                List<Object> objectListGeneric = new ArrayList<>();    
                
                for(int i=0;i<heightValue;i++){
                    try {
                        objectListGeneric.add(classObject.getField(arrayClass[i].getName()).get(baseObject));
                    } catch (NoSuchFieldException ex) {
                        Logger.getLogger(ListObjectJson.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SecurityException ex) {
                        Logger.getLogger(ListObjectJson.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                objectList.add(objectListGeneric);
            }
            
            dataTableObject.setAaData(objectList);     

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
 
            
            json = gson.toJson(dataTableObject);
            
   
    
    } catch (SecurityException e) {
      System.out.println(e);
    } catch (IllegalArgumentException ex) {
          Logger.getLogger(ListObjectJson.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          Logger.getLogger(ListObjectJson.class.getName()).log(Level.SEVERE, null, ex);
      } 
        return json;
      
  }
  
}
