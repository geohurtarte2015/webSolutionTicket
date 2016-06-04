<%-- 
    Document   : DataTable
    Created on : 02-jun-2016, 2:49:13
    Author     : ehurtarte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojo.Ticket"%>
<%@page import="dao.DaoTicket"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap Core CSS -->
        <link href="plantilla/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="plantilla/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="plantilla/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="plantilla/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="plantilla/dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="plantilla/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        
        <!-- jQuery -->
        <script src="plantilla/bower_components/jquery/dist/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="plantilla/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="plantilla/bower_components/metisMenu/dist/metisMenu.min.js"></script>

        <!-- DataTables JavaScript -->
        <script src="plantilla/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
        <script src="plantilla/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="plantilla/dist/js/sb-admin-2.js"></script>
        
        <script>
          $(document).ready(function() {
              
             $('#example').DataTable({           

             "bFilter": false,
              "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
                    if ( aData[0] == "2" )
                    {
                        $('td', nRow).css('background-color', '#d9534f');
                    }
                    else if ( aData[0] == "11" )
                    {
                        $('td', nRow).css('background-color', '#f0ad4e');
                    }
                }
           
            
            });
                
                
                
            } );
        </script>    
        
    </head>
    <body>
       
       <table id="example" class="table table-striped table-bordered table-hover">  
        <thead>
            <tr>
               <th>Id</th>
               <th>Titulo</th>
               <th>Analista</th>
                <th>Causa</th>
                <th>Fecha</th>
                <th></th>
                
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Id</th>
               <th>Titulo</th>
               <th>Analista</th>
                <th>Causa</th>
                <th>Fecha</th>
                <th></th>
            </tr>
        </tfoot>
        <tbody>
            <%
                                        DaoTicket daoTicket= new DaoTicket();
                                        for(Ticket ticket: daoTicket.listAll()){
            %> 
            <tr>
                <td id="idTicket" align="center"><%= ticket.getId() %></td>

                <td id="titulo"  align="center"><%= ticket.getTitulo() %></td>

                <td id="analista"  align="center"><%= ticket.getAnalista().getNombre() %></td>

                <td id="causa"  align="center"><%= ticket.getCausa() %></td>

                <td id="fecha"  align="center"><%= ticket.getFecha() %></td>
                
                <td   id="test" style="width: 25px; text-align: center;">
                       <a href="#dialog" name="<%= ticket.getId()%>"  id="linkFunction" data-toggle="modal" data-target="#myModal">
                                          
                        <img  src="img/lupa.png" width="16" height="16"  border="0" />       
                        </a>                            
                 </td>
              
            </tr>
            <%}%>
        </tbody>
    </table>
    </body>
</html>
