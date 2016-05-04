<%-- 
    Document   : test
    Created on : 4/05/2016, 03:03:01 AM
    Author     : Giovanni
--%>

<%@page import="pojo.Ticket"%>
<%@page import="dao.DaoTicket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="center-block">
                                <table id="table_ticket" class="display">         
                                <thead>
                                <tr>
                                <th>Id Ticket</th>
                                <th>Titulo</th>
                                <th>Analista</th>
                                <th>Causa</th>
                                <th>Fecha</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    DaoTicket daoTicket= new DaoTicket();
                                    for(Ticket ticket: daoTicket.listAll()){
                                %>    
                                <tr>
                                    <td id="idTicket" align="center"><%= ticket.getId() %></td>
                                    
                                    <td id="titulo"  align="center"><%= ticket.getTitulo() %></td>
                                    
                                    <td id="titulo"  align="center"><%= ticket.getAnalista().getNombre() %></td>
                                       
                                    <td id="titulo"  align="center"><%= ticket.getCausa() %></td>
                                          
                                    <td id="titulo"  align="center"><%= ticket.getFecha() %></td>
                                     
                                </tr>
                                <%}%>
                                </tbody>  
                               </table>
                            </div>
    </body>
</html>
