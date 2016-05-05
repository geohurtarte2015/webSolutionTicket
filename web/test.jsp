<%-- 
    Document   : test
    Created on : 4/05/2016, 03:03:01 AM
    Author     : Giovanni
--%>

<%@page import="pojo.Seguimiento"%>
<%@page import="dao.DaoSeguimiento"%>
<%@page import="pojo.Ticket"%>
<%@page import="dao.DaoTicket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        var para = document.createElement("p");
        var node = document.createTextNode("This is new.");
        para.appendChild(node);

        var element = document.getElementById("div1");
        var child = document.getElementById("p1");
        element.insertBefore(para,child);
        </script>
        
        
    </head>
    <body>
       
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Historial de seguimientos
                        </div>
                        <!-- .panel-heading -->
                        <div class="panel-body">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="collapsed" aria-expanded="false" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Seguimientos</a>
                                        </h4>
                                    </div>
                                    <div style="height: 0px;" aria-expanded="false" id="collapseOne" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            
                                            <table id="table_seguimiento" class="table table-striped table-bordered table-hover">         
                                    <thead>
                                    <tr>
                                    <th>Fecha</th>
                                    <th>Descripcion</th>                                   
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        DaoSeguimiento daoSeguimiento= new DaoSeguimiento();
                                        for(Seguimiento seguimiento: daoSeguimiento.listAll()){
                                    %>    
                                    <tr>
                                        <td id="idTicket" align="center"><%= seguimiento.getFecha() %></td>

                                        <td id="titulo"  align="center"><%= seguimiento.getDescripcion() %></td>

                                    </tr>
                                    <%}%>
                                    </tbody>  
                                    </table>
                                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                
    </body>
</html>
