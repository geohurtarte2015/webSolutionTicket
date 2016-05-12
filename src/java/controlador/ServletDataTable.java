/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoSeguimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Seguimiento;


/**
 *
 * @author Giovanni
 */
public class ServletDataTable extends HttpServlet {

    public ServletDataTable() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();           
            DaoSeguimiento daoSeguimiento = new DaoSeguimiento();
            List<Seguimiento> seguimiento = daoSeguimiento.listAll();
            List<Student> students = StudentDataService.getStudentList();


            DataTableObject dataTableObject = new DataTableObject();
            dataTableObject.setAaData(students);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            out.print(json);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             doGet(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
