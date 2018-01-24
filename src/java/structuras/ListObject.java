package structuras;




import dao.DaoGeneric;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Estado;



public class ListObject {
    
    public String getObjectStringJson(Object objectType, String stringObject) {
   
     String json = null;
     Class objectClass = objectType.getClass();
     Field[] array = objectClass.getFields(); 
     int height = array.length;

      try { 
          
            DaoGeneric daoGeneric = new DaoGeneric();  
          
            
            DataTableObject dataTableObject = new DataTableObject();
            
            List<Object> objects = (List<Object>) daoGeneric.listAll(stringObject);
            
            //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
            //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
            List<Object> objectList = new ArrayList();
            
            objectList= this.getListArrayObject(objectType, stringObject);
            
            dataTableObject.setAaData(objectList);     

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
 
            
            json = gson.toJson(dataTableObject);
            
            System.out.println(json);
            System.out.println("\n");
            
   
    
    } catch (SecurityException e) {
      System.out.println(e);
    } catch (IllegalArgumentException ex) {
          Logger.getLogger(ListObject.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          Logger.getLogger(ListObject.class.getName()).log(Level.SEVERE, null, ex);
      } 
        return json;
      
  }
    
    public List<Object> getListArrayObject(Object objectType, String stringObject) throws IllegalArgumentException, IllegalAccessException{
       String json = null;
     Class objectClass = objectType.getClass();
     Field[] array = objectClass.getFields(); 
     int height = array.length;
     
    DaoGeneric daoGeneric = new DaoGeneric(); 
    List<Object> objects = (List<Object>) daoGeneric.listAll(stringObject);
            
            //Se crea nueva Lista de objetos "objectSeguimientos" para solo incluir las propiedades Id, Fecha y Descripcion, 
            //ya que Gson no reconoce la lista de seguimientos por tener la propiedad de <Tickets> en su clase
            List<Object> objectList = new ArrayList();
            
            for (Iterator estadoIterator = objects.iterator(); 
                 estadoIterator.hasNext();
                )
            {
                Object baseObject = estadoIterator.next(); 
                Class classObject = baseObject.getClass();
                Field[] arrayClass = classObject.getFields(); 
                
                List<Object> objectListGeneric = new ArrayList();    
                
                for(int i=0;i<height;i++){
                    try {
                        objectListGeneric.add(classObject.getField(arrayClass[i].getName()).get(baseObject));
                    } catch (NoSuchFieldException ex) {
                        Logger.getLogger(ListObject.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SecurityException ex) {
                        Logger.getLogger(ListObject.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                objectList.add(objectListGeneric);
            }
    
    return objectList;
    }
    
    
  
}
