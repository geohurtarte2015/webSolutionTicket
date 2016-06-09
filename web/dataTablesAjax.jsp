
<%@page import="pojo.Analista"%>
<%@page import="dao.DaoAnalista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
	
	<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.8.3.min.js"></script>
        
        
        <!-- Bootstrap Core CSS -->
        <link href="plantilla/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="plantilla/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="plantilla/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="plantilla/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

        <!-- jQuery -->
        <script src="plantilla/bower_components/jquery/dist/jquery.min.js"></script> 
        
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        
         <!-- DataTables JavaScript -->
        <script src="plantilla/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
        
        
        <%                          
                        DaoAnalista daoAnalista = new DaoAnalista();
                        Analista analista = new Analista();
                        analista = daoAnalista.getByIdObject(1);
                    %>
                    
                    
                    <p><%= analista.getNombre()+" "+analista.getApellido() %></p>

    </body>
</html>
