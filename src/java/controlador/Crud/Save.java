/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Crud;


import dao.DaoGeneric;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Analista;
import pojo.Grupo;
import structuras.ListObject;


/**
 *
 * @author Giovanni
 */
public class Save extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
   
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            DaoGeneric daoGeneric = new DaoGeneric();
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            Constructor<?> constructorRelation = null;
            Object newObjectRelation = null; 
            Class<?> classObjectRelationObject = null;
            boolean result=false;

            String className = String.valueOf(request.getParameter("className"));
            String classNameRelation = String.valueOf(request.getParameter("classNameRelation"));
            boolean undefined = "undefined".matches(classNameRelation);
            String[] parametersRequest = request.getParameterValues("array[]");
            int sizeParametersRequest = parametersRequest.length;

            Class<?> classObject = Class.forName("pojo." + className);

            
            Constructor<?> constructor = classObject.getConstructor();
            Object newObject = constructor.newInstance();
            
            if(!undefined){
            classObjectRelationObject = Class.forName("pojo." + classNameRelation);
            constructorRelation = classObjectRelationObject.getConstructor();
            newObjectRelation = constructorRelation.newInstance();
            }
            
            Field[] arrayObject = classObject.getFields();


            for (int index = 1; index <= sizeParametersRequest; index++) {
                if(!undefined){
                     result = classNameRelation.matches(arrayObject[index].getType().getSimpleName());
                }
                if(result){              
                    newObjectRelation = daoGeneric.getByIdObject(Integer.parseInt(parametersRequest[index-1]), classObjectRelationObject);
                    arrayObject[index].set(newObject, newObjectRelation);  
                }else{
                    arrayObject[index].set(newObject, parametersRequest[index-1]);  
                }
            }

            daoGeneric.save(newObject);   

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
