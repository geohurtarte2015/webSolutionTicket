<%@page import="pojo.Seguimiento"%>
<%@page import="dao.DaoSeguimiento"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>
    
    <!-- Bootstrap DateTimePicker -->
     <link rel="stylesheet" type="text/css" media="screen" href="plantilla/bower_components/bootstrap/dist/css/bootstrap.min.css" />
     <link href="bootdate/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
     <script type="text/javascript" src="plantilla/js/jquery-1.9.1.min.js"></script>
     <script type="text/javascript" src="plantilla/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
     <script src="plantilla/js/moment.js"></script>
     <script src="bootdate/src/js/bootstrap-datetimepicker.js"></script>
 

    <!-- MetisMenu CSS -->
    <link href="plantilla/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="plantilla/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="plantilla/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                <a class="navbar-brand" href="index.html">SB Admin v2.0</a>
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
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="panels-wells.html">Panels and Wells</a>
                                </li>
                                <li>
                                    <a href="buttons.html">Buttons</a>
                                </li>
                                <li>
                                    <a href="notifications.html">Notifications</a>
                                </li>
                                <li>
                                    <a href="typography.html">Typography</a>
                                </li>
                                <li>
                                    <a href="icons.html"> Icons</a>
                                </li>
                                <li>
                                    <a href="grid.html">Grid</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li class="active">
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a class="active" href="blank.html">Blank Page</a>
                                </li>
                                <li>
                                    <a href="login.html">Login Page</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"></h1>
                        
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Mantenimiento de Tickets</div>                        
                        <!-- /.panel-body -->
                        <div class="panel-body">
                            
                            <div class="row">                            
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Titulo del Ticket</label>
                                            <input class="form-control" placeholder="Titulo">
                                    </div> 
                                </div>
                            </div><!-- /.Titulo -->
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Servicio</label>
                                            <select class="form-control">
                                                <option>seleccionar</option>
                                                <option>Banca para Ti</option>
                                                <option>Banca Empresarial Antigua</option>
                                                <option>Banca Empresarial Nueva</option>
                                                <option>Remesas</option>
                                                <option>Agente</option>
                                            </select>
                                        </div> 
                                    
                                </div>     
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Modulo</label>
                                            <select class="form-control">
                                                <option>seleccionar</option>
                                                <option>Notificacion Mensajitos</option>
                                                <option>Transferencia a Terceros</option>
                                                <option>Banca Empresarial Nueva</option>
                                                <option>Remesas</option>
                                                <option>Bancacel</option>
                                            </select>
                                        </div> <!-- /.Modulo -->
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Servicio Modulo</label>
                                            <select class="form-control">
                                                <option>seleccionar</option>
                                                <option>Remesas MoneyGram</option>
                                                <option>Remesas Intermex</option>
                                                <option>Remesas Uniteller</option>
                                                <option>Remesas Ria</option>
                                                <option>Remesas Vigo</option>
                                            </select>
                                        </div> <!-- /.Servicio Modulo -->                                
                                </div>
                            </div> <!-- /.Modulos Servicios -->
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Nombre Servidor</label>
                                            <select class="form-control">
                                                <option>seleccionar</option>
                                                <option>Malinas</option>
                                                <option>Anton</option>
                                                <option>Paphos</option>
                                                <option>Palanga</option>
                                                <option>Asker</option>
                                            </select>
                                        </div> <!-- /.Servidor -->  
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group">
                                            <label>Impacto</label>
                                            <select class="form-control">
                                                <option>Seleccionar</option>
                                                <option>Alto</option>
                                                <option>Medio</option>
                                                <option>Bajo</option>
                                            </select>
                                        </div> <!-- /.Impacto -->  
                                </div>
                                
                            </div><!-- /.Impacto en Servidor -->
                            <div class="row">
                                <div class='col-lg-4'>
                                    <div class="form-group">
                                        <label>Fecha Inicio del Evento</label>
                                        <div class='input-group date' id='fechainicio'>                                            
                                            <input type='text' class="form-control" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class='col-lg-4'>
                                    <div class="form-group">
                                        <label>Fecha Final del Evento</label>
                                        <div class='input-group date' id='fechafinal'>                                            
                                            <input type='text' class="form-control" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>   
                             </div><!-- /.Fecha Inicio y Final eventos -->
                            <div class="row">
                                <div class='col-lg-4'>
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label for="comment">Descripción</label>
                                            <textarea class="form-control" rows="5" id="descripcion"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class='col-lg-4'>
                                    <div class="form-group">                                        
                                        <label for="comment">Causa</label>
                                            <textarea class="form-control" rows="5" id="causa"></textarea>
                                    </div>
                                </div>
                                 <div class='col-lg-4'>
                                    <div class="form-group">                                     
                                        <label for="comment">Solución</label>
                                            <textarea class="form-control" rows="5" id="solucion"></textarea>
                                    </div>
                                </div>  
                             </div><!-- /.Descripcion, solucion y causa --> 
                            <div class="row">
                                    
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="collapsed" aria-expanded="false" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Seguimiento de Eventos</a>
                                        </h4>
                                    </div>
                                    <div style="height: 0px;" aria-expanded="false" id="collapseOne" class="panel-collapse collapse">
                                        <div class="panel-body">
                                                <table id="table_ticket" class="table table-striped table-bordered table-hover">         
                                    <thead>
                                    <tr>
                                    <th>Fecha</th>
                                    <th>Descripción
                                    </th>                                  
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
                        </div>
                        
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- DateTimePicker Bootstrap -->
    <script type="text/javascript">
                  $(function () {
                    $('#fechainicio').datetimepicker({
                        format: "DD-MM-YYYY hh:mm a"                      
                        });
                    });
                    
                   $(function () {
                    $('#fechafinal').datetimepicker({
                        format: "DD-MM-YYYY hh:mm a"                      
                        });
                    });
   </script>

</body>

</html>
