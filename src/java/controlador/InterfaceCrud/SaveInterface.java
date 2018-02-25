/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.InterfaceCrud;

import controlador.Fecha;
import dao.DaoInterfaz;
import dao.DaoTicket;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Interfaz;
import pojo.Seguimiento;

/**
 *
 * @author Giovanni
 */
public class SaveInterface extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String[] parametersRequest = request.getParameterValues("array[]");       
            int idAgencia = Integer.parseInt(parametersRequest[0]);     
            DaoInterfaz daoInterfaz = new DaoInterfaz();                         
            Interfaz interfazAgencia = new Interfaz(parametersRequest[1],parametersRequest[2]);
            //VALIDA SI SEGUIMIENTO ESTA EN BLANCO O NO
            if (!interfazAgencia.getDescripcion().trim().isEmpty() && interfazAgencia.getDescripcion()!=null){
            //agrega seguimientos despues de haber guardado un ticket
                daoInterfaz.addInterfaz(idAgencia, interfazAgencia);  
            }
      
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
