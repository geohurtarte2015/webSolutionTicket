<%@page import="pojo.Analista"%>
<%@page import="dao.DaoAnalista"%>
<%@page import="pojo.Estado"%>
<%@page import="dao.DaoEstado"%>
<%@page import="pojo.Impacto"%>
<%@page import="dao.DaoImpacto"%>
<%@page import="pojo.Servidor"%>
<%@page import="dao.DaoServidor"%>
<%@page import="pojo.ServicioModulo"%>
<%@page import="dao.DaoServicioModulo"%>
<%@page import="pojo.Modulo"%>
<%@page import="dao.DaoModulo"%>
<%@page import="pojo.Servicio"%>
<%@page import="dao.DaoServicio"%>
<%@page import="pojo.Ticket"%>
<%@page import="dao.DaoTicket"%>
<!DOCTYPE html>
<%  
    int id = (int) session.getAttribute("id");  
    String usuario = (String) session.getAttribute("user");    
    String nombre = (String) session.getAttribute("nombre");
    String apellido = (String) session.getAttribute("apellido");
%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Web Solution Ticket 1.0</title>
    
       
    
        <link rel="stylesheet" type="text/css" media="screen" href="plantilla/bower_components/bootstrap/dist/css/bootstrap.min.css" />
        <link href="bootdate/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
        
        
        <script type="text/javascript" src="plantilla/js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="plantilla/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="plantilla/js/moment.js"></script>
	<script src="bootdate/src/js/bootstrap-datetimepicker.js"></script>  
        
         
        <!-- DataTables JavaScript -->
        <script src="plantilla/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
        <script src="plantilla/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
        
        <!-- DataTables CSS -->
        <link href="plantilla/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet"> 
    
        <!-- Bootstrap Core CSS -->
        <link href="plantilla/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="plantilla/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="plantilla/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="plantilla/dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="plantilla/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        

        <!-- Metis Menu Plugin JavaScript -->
        <script src="plantilla/bower_components/metisMenu/dist/metisMenu.min.js"></script>

        <!-- DataTables JavaScript -->
        <script src="plantilla/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
        <script src="plantilla/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="plantilla/dist/js/sb-admin-2.js"></script>

       <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
       <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
       <!--[if lt IE 9]>
           <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
           <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
       <![endif]-->
    <script>
     var ticket;
     var valAnalista = $('#idAnalista').html();
     
     
    $(document).ready(function() {
        
     //INICIALIZACION DEL DATA_TABLE SEGUIMIENTOS "example"
     var t= $('#example').DataTable( {
                    "ajax" : {
                        "url": "ServletVerTicket",
                        "type": "POST",
                        "data" : function(d){
                            d.ticket = ticket;
                            }
                    },
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json"
                 });
    

      //LLAMADA DE CARGA POR AJAX DE SEGUIMIENTOS POR TICKET ID
     $('a[href="#dialog"]').click(function(){
         
           ticket = $(this).attr("name");
           
           //LIMPIA EL DATA_TABLE
            t.clear().draw();
           
           //recarga los datos nuevamente en el dataTable por ajax
           t.ajax.reload();          
            /*
         $.ajax({
                   type: "GET",
                    url: "ServletVerSeguimientos",                    
                    global: false,
                    async : false,
                    dataType : "json",
                    data: {
                            idTicket: idTicket
                            },
                    success : function(json) {
                        //se carga la nueva informacion
                        t.clear().draw();   //LIMPIA LA TABLA                
                        t.rows.add(json);   //AGREGA LA INFORMACION DE RESULTADO JSON
                        t.columns.adjust().draw(); //DIBUJA LA TABLA DE NUEVO 
                      }
                });
  */    
        });  
      
      
     //PARAMETROS POR AJAX PARA GUARDAR NUEVO SEGUIMIENTO     
     $("#submit").click(function(){ 
           descripcionSeguimiento=$('#txtSeguimiento').val();
                 
                    $.ajax({
                    type: "GET",
                    url: "ServletGuardarSeguimiento",
                    global: false,
                    async : false,
                    data: {
                        descripcionSeguimiento: descripcionSeguimiento,
                        ticket: ticket
                    }
                    });
                    
                    //recarga los datos nuevamente en el dataTable por ajax
                     t.ajax.reload();
                     alert("Seguimiento Guardado");
                });
                
      //INICIALIZACION DEL DATA_TABLE TICKETS  "table_ticket"
      var tableTicket= $('#table_ticket').DataTable({           

             "bFilter": false,
              "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
                    if ( aData[0] == "10" )
                    {
                        $('td', nRow).css('background-color', '#d9534f');
                    }
                    else if ( aData[0] == "2" )
                    {
                        $('td', nRow).css('background-color', '#f0ad4e');
                    }
                }
                
        });             
      
      //PARAMETROS POR AJAX PARA GUARDAR NUEVO TICKET     
     $("#guardarticket").click(function(){ 
         
           titulo=$('#titulotxt').val();

           servicio=$('select[id=serviciotxt]').val();
           modulo=$('select[id=modulotxt]').val();
           servicioModulo=$('select[id=serviciomodulotxt]').val();           
           nombreServidor=$('select[id=nombreservidortxt]').val();           
           impacto=$('select[id=impactotxt]').val();
           estado=$('select[id=estadotxt]').val();       
           analista =<%=String.valueOf(id)%>;   
           fechaInicio=$('#fechainiciotxt').val();
           fechaFin=$('#fechafinaltxt').val();
           descripcion=$('#descripciontxt').val();
           causa=$('#causatxt').val();
           solucion=$('#soluciontxt').val();
                 
                    $.ajax({
                    type: "GET",
                    url: "ServletGuardarTicket",
                    global: false,
                    async : false,
                    data: { titulo: titulo,
                        servicio: servicio,
                        modulo: modulo,
                        servicioModulo: servicioModulo,
                        nombreServidor: nombreServidor,
                        impacto: impacto,
                        fechaInicio: fechaInicio,
                        fechaFin: fechaFin,
                        descripcion: descripcion,
                        causa: causa,
                        solucion: solucion,
                        estado: estado,
                        analista: analista
                       
                    }
                    });
                    
                    //recarga los datos nuevamente en el dataTable por ajax
                     alert("Ticket Guardado");
                });
               
   });
    
    </script>

</head>

<body>



    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Web Solution Ticket v1.0</a>
                <a class="navbar-brand"><%=usuario%></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="CerrarSesion"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Estadisticas<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Estadisticas Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i>Reportes</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-sitemap fa-fw"></i>Campos<span class="fa arrow"></span></a></a>
                              <ul class="nav nav-second-level">
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModaAnalista" data-backdrop="static" data-keyboard="false">Analista</a>
                                </li>  
                                <li>
                                    <a href="flot.html">Raiz</a>
                                </li>
                                <li>
                                    <a href="morris.html">Estados</a>
                                </li>
                                <li>
                                    <a href="morris.html">Impacto</a>
                                </li>
                                <li>
                                    <a href="morris.html">Modulos</a>
                                </li>
                                <li>
                                    <a href="morris.html">Servicios</a>
                                </li>
                                 <li>
                                    <a href="morris.html">SubServicio</a>
                                </li>
                                <li>
                                    <a href="morris.html">Servidores</a>
                                </li>
                              </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tickets Generales</h1>
                    
                    <h4  class="page-header">Analista: <%= nombre+" "+apellido %> </h4>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">26</div>
                                    <div>Todos los Tickets</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Mostrar</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">12</div>
                                    <div>Pend. hoy</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Mostrar</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">124</div>
                                    <div>Pend. mayor a 1 dia</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Mostrar</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">13</div>
                                    <div>Pend. mayor a 2 dias</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Mostrar</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            
            
            <div class="row">
                <div class="col-lg-12">
                     <div class="panel panel-default">
                        <div class="panel-heading">
                            Tickets
                        </div>
                                <div class="panel-body">
                                  <div class="table-responsive">
                                    <table id="table_ticket" class="table table-striped table-bordered table-hover">         
                                    <thead>
                                    <tr>
                                    <th>Id</th>
                                    <th>Titulo</th>
                                    <th>Analista</th>
                                    <th>Causa</th>
                                    <th>Fecha</th>
                                    <th></th>
                                    <th></th>
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

                                        <td id="analista"  align="center"><%= ticket.getAnalista().getNombre() %></td>

                                        <td id="causa"  align="center"><%= ticket.getCausa() %></td>

                                        <td id="fecha"  align="center"><%= ticket.getFecha() %></td>
                                        
                                        <td   id="editar" style="width: 25px; text-align: center;">
                                        <a href="ServletVerTicket?idTicket=<%= ticket.getId()%>" data-toggle="modal" data-target="#myModal">
                                        <img  src="img/pencil.png" width="16" height="16"  border="0" />       
                                        </a>                            
                                        </td>
                                        <td   id="test" style="width: 25px; text-align: center;">
                                        <a href="#dialog" name="<%= ticket.getId()%>"  id="linkFunction" data-toggle="modal" data-target="#myModal" data-backdrop="static" data-keyboard="false">
                                          
                                        <img  src="img/lupa.png" width="16" height="16"  border="0" />       
                                        </a>                            
                                        </td>
                                       

                                    </tr>
                                    <%}%>
                                    </tbody>  
                                    </table>
                                </div>
                            </div> 
                        </div>
                        
                       
                <!-- /.panel-heading -->
                <div class="panel-body">
                <!-- Modal -->
                 <div style="display: none;" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                 <div class="modal-dialog modal-lg">
                   <div class="modal-content">
                        <div class="modal-header">                                           
                            <h4 class="modal-title" id="myModalLabel">Mantenimiento Ticket</h4>
                        </div>
                        <div class="modal-body">
                                          
                     <div class="panel panel-default">
                                     
                          <!-- /.panel-body -->
                          <div class="panel-body">
                            
                            <div class="row">                            
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Titulo del Ticket</label>
                                            <input class="form-control" id="titulotxt" placeholder="Titulo">
                                    </div>
                                </div>
                            </div><!-- /.Titulo -->
                              
                            <div class="row">
                                
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Servicio</label>
                                            <select id="serviciotxt" class="form-control">
                                                <option>seleccionar</option> 
                                                <%
                                                    DaoServicio daoServicio= new DaoServicio();
                                                    for(Servicio servicio: daoServicio.listAll()){
                                                %>  
                                                <option name="option" value=<%= servicio.getIdServicioModulo() %>> <%= servicio.getDescripcion() %></option>  
                                                <%}%> 
                                            </select>
                                        </div> 
                                  
                                </div>   
                                
                                 
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Modulo</label>
                                            <select id="modulotxt" class="form-control">
                                                <option>seleccionar</option> 
                                                 <%
                                                    DaoModulo daoModulo= new DaoModulo();
                                                    for(Modulo modulo: daoModulo.listAll()){
                                                  %>
                                                <option value=<%= modulo.getIdModulo() %>> <%= modulo.getDescripcion() %></option>      
                                                 <%}%> 
                                            </select>
                                        </div> <!-- /.Modulo -->
                                </div>
                               
                                
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Servicio Modulo</label>
                                            <select id="serviciomodulotxt" class="form-control">
                                                <option>seleccionar</option> 
                                                <%
                                                    DaoServicioModulo daoServicioModulo= new DaoServicioModulo();
                                                    for(ServicioModulo servicioModulo: daoServicioModulo.listAll()){
                                                %>  
                                                <option name="option" value=<%= servicioModulo.getIdServicioModulo() %>><%= servicioModulo.getDescripcion() %></option>
                                                <%}%> 
                                            </select>
                                        </div> <!-- /.Servicio Modulo -->                                
                                </div>
                                            
                            </div> <!-- /.Modulos Servicios -->
                            <div class="row">
                                
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Nombre Servidor</label>
                                            <select id="nombreservidortxt" class="form-control">
                                                <option>seleccionar</option>
                                                <%
                                                    DaoServidor daoServidor= new DaoServidor();
                                                    for(Servidor servidor: daoServidor.listAll()){
                                                %>
                                                <option value=<%= servidor.getIdServidor() %>><%= servidor.getDescripcion() %></option>                                               
                                                 <%}%> 
                                            </select>
                                        </div> <!-- /.Servidor -->  
                                </div>
                                 
                                 
                              <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Impacto</label>
                                            <select id="impactotxt" class="form-control">
                                                <option>Seleccionar</option>
                                                <%
                                                    DaoImpacto daoImpacto= new DaoImpacto();
                                                    for(Impacto impacto: daoImpacto.listAll()){
                                                %> 
                                                <option value=<%= impacto.getIdImpacto() %>> <%= impacto.getDescripcion() %></option>  
                                                <%}%>
                                            </select>
                                        </div> <!-- /.Impacto -->  
                                </div>
                                  
                            </div><!-- /.Impacto en Servidor -->
                            <div class="row">
                                <div class='col-lg-4'>
                                    <div class="form-group">
                                        <label>Fecha Inicio del Evento</label>
                                        <div class='input-group date' id='fechainicio'>                                            
                                            <input type='text' id="fechainiciotxt" class="form-control" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class='col-lg-4'>
                                    <div class="form-group">
                                        <label>Fecha Final del Evento</label>
                                        <div class='input-group date'  id='fechafinal'>                                            
                                            <input id="fechafinaltxt" type='text' class="form-control" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div> 
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Estado</label>
                                            <select id="estadotxt" class="form-control">
                                                <option>Seleccionar</option>
                                                <%
                                                    DaoEstado daoEstado= new DaoEstado();
                                                    for(Estado estado: daoEstado.listAll()){
                                                %> 
                                                <option value=<%= estado.getIdEstado() %>> <%= estado.getDescripcion() %></option>  
                                                <%}%>
                                            </select>
                                        </div> <!-- /.Impacto -->  
                                </div>
                             </div><!-- /.Fecha Inicio y Final eventos -->
                             
                            <div class="row">
                                <div class='col-lg-4'>
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label for="comment">Descripción</label>
                                            <textarea class="form-control" rows="5" id="descripciontxt"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class='col-lg-4'>
                                    <div class="form-group">                                        
                                        <label for="comment">Causa</label>
                                            <textarea class="form-control" rows="5" id="causatxt"></textarea>
                                    </div>
                                </div>
                                 <div class='col-lg-4'>
                                    <div class="form-group">                                     
                                        <label for="comment">Solución</label>
                                            <textarea class="form-control" rows="5" id="soluciontxt"></textarea>
                                    </div>
                                </div>  
                             </div><!-- /.Descripcion, solucion y causa --> 
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                <button id="guardarticket" type="button" class="btn btn-primary">Guardar Ticket</button>
                                <button type="button" class="btn btn-primary">Modificar Ticket</button>
                                <button type="button" class="btn btn-primary " id="myBtnSeguimientoShow" >Crear Seguimiento</button>
                            </div>
                     </div>
                                            
                    </div>      
                               
                        <div style="display: none;" class="modal fade" id="myModalSeguimiento" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" id="myBtnSeguimientoHide" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                    
                                          <div class="row">
                                                <div class='col-lg-4'>
                                                    <div class="form-group">
                                                        <div class="form-group">                                    
                                                            <textarea class="form-control" style="min-width: 100%; margin: 0px -391.672px 0px 0px; width: 562px; height: 138px;" rows="5" id="txtSeguimiento"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                          </div>
                                            
                                          <button type="button" class="btn btn-default" id="myBtnSeguimientoHide2">Close</button>
                                          <button type="button" id="submit" class="btn btn-primary">Save changes</button>
                                              
                                         
                                        </div>
                                        <div class="modal-footer">
                                            
                                            <table id="example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                          
                                            <thead>
                                                <tr>
                                                <th>id</th>
                                                <th>descripcion</th>
                                                <th>fecha</th>      
                                                </tr>
                                            </thead>
                                            
                                            </table>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                                <!-- /.modal-dialog -->
                            </div>
                                <!-- /.modal-dialog -->
                            
                                <!-- /.modal-dialog -->
                            
                                    </div>
                 <!-- /.modal-content -->
                 </div>
                 
                 <div style="display: none;" class="modal fade" id="myModaAnalista" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" id="myBtnAnalistaHide" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">Agregar Analista</h4>
                                        </div>
                                        
                                   
                                        
                        <div class="modal-body">
                                          
                        <div class="panel panel-default">
                                     
                          <!-- /.panel-body -->
                          <div class="panel-body">
                            
                            <div class="row">                            
                                <div class="col-xs-6">
                                    <div class="form-group">
                                            <label>Nombre</label>
                                            <input class="form-control" name="AnalistaNombreTxt" id="AnalistaNombreTxt" placeholder="Nombre">
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div class="form-group">
                                            <label>Apellido</label>
                                            <input class="form-control" name="ApellidoAnalistaTxt" id="ApellidoAnalistaTxt" placeholder="Apellido">
                                    </div>
                                </div>
                            </div><!-- /.Nombre Apellido -->  
                            
                            <div class="row">                            
                                <div class="col-xs-6">
                                    <div class="form-group">
                                            <label>Usuario</label>
                                            <input class="form-control" name="AnalistaUsuarioTxt" id="AnalistaUsuarioTxt" placeholder="Usuario">
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div class="form-group">
                                            <label>Password</label>
                                            <input class="form-control" name="ApellidoUsuarioTxt" id="ApellidoPasswordTxt" placeholder="Password">
                                    </div>
                                </div>
                            </div><!-- /.Usuario Contraseña -->  
                             
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                <button id="guardartAnalista" type="button" class="btn btn-primary">Guardar</button>
                                <button type="button" class="btn btn-primary">Modificar</button>
                                <button type="button" class="btn btn-primary " id="myBtnAnalistaShow" >Crear</button>
                            </div>
                            <div class="modal-footer">
                                <table id="tableAnalista" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                          
                                            <thead>
                                                <tr>
                                                <th>id</th>
                                                <th>descripcion</th>
                                                <th>fecha</th>      
                                                </tr>
                                            </thead>
                                            
                                </table>
                            </div>
                     </div>
                                            
                    </div>    
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                 </div>   
                 <!-- /.modal -->
             
                </div>
                        <!-- /.panel-body -->
                    </div>            
                 
                </div>
            
            </div>
 
            
            
            </div>
            <!-- /.row -->
     

  <script type="text/javascript">
             
                    $(function () {
                    $('#fechainicio').datetimepicker({
                        format: "DD-MM-YYYY hh:mm:ss a"                      
                        });
                    });
                    
                    $(function () {
                    $('#fechafinal').datetimepicker({
                        format: "DD-MM-YYYY hh:mm:ss a"                      
                        });
                    });
                    
                    $(document).ready(function(){
                        $("#myBtnSeguimientoShow").click(function(){
                            
                            $("#myModalSeguimiento").modal();
                          
                        });
                    });
                    
                    $(document).ready(function(){
                        $("#myBtnAnalistaShow").click(function(){
                            
                            $("#myModalAnalista").modal();
                          
                        });
                    });
                    
                    $(document).ready(function(){
                        $("#myBtnSeguimientoHide").click(function(){
                            $("#myModalSeguimiento").modal("hide");
                        });
                    });
                    
                    $(document).ready(function(){
                        $("#myBtnSeguimientoHide2").click(function(){
                            $("#myModalSeguimiento").modal("hide");
                        });
                    });
                   
   </script>   

</body>

</html>
