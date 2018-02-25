<%@page import="java.lang.Object"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="structuras.ListObject"%>
<%@page import="pojo.Analista"%>
<%@page import="pojo.Estado"%>
<%@page import="pojo.Impacto"%>
<%@page import="pojo.Servidor"%>
<%@page import="pojo.ServicioModulo"%>
<%@page import="pojo.Modulo"%>
<%@page import="pojo.Servicio"%>
<%@page import="pojo.Ticket"%>
<%@page import="dao.DaoTicket"%>

<!DOCTYPE html>
<%  
    ListObject listObject = new ListObject();
    int id = (Integer) session.getAttribute("id");
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
        
        <!-- Alert Bootbox -->
        <script src="bootbox/bootbox.min.js"></script> 
        
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
     var idAnalista;
     var idTicketUpdate;
     
     var transaccion;
     
         
      function appendModal(titleModal,title){
         var nameModal = "#myModal"+titleModal;
         nameNewModal="myModal"+title;
         lowerCaseTitle=title.toLowerCase();    
         $(nameModal).append('<div style="display: none;" class="modal fade" id="'+nameNewModal+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> <div class="modal-dialog"> <div class="modal-content"> <div class="modal-header"> <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> <h4 class="modal-title" id="myModalLabel">Agregar '+title+'</h4> </div><div class="modal-body"> <div class="panel panel-default"> <!-- /.panel-body --> <div class="panel-body"> <div class="row"> <div class="col-xs-6"> <div class="form-group"> <label>'+title+'</label> <input class="form-control" name="'+lowerCaseTitle+'NombreTxt" id="'+lowerCaseTitle+'NombreTxt" placeholder="Nombre"> </div> </div> </div>  <!-- /.Descripcion -->  <button id="cerrar'+title+'" type="button"  class="btn btn-default" data-dismiss="modal">Cerrar</button> <button id="guardar'+title+'" type="button"  class="btn btn-primary">Guardar</button>  <button type="button" class="btn btn-primary " id="myBtn'+title+'Show" >Crear</button> </div> <!-- /.dataTable -->  <div class="modal-footer">  <table id="table_'+lowerCaseTitle+'" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  </table>  </div>  </div> </div>  </div>  <!-- /.modal-content -->  </div>  <!-- /.modal-dialog -->  </div> ');
      }

      function appendText(title) {        
        div="#div"+title;  
        nameModal="myModal"+title;
        lowerCaseTitle=title.toLowerCase();     
        var varDiv = $('<div style="display: none;" class="modal fade" id="'+nameModal+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> <div class="modal-dialog"> <div class="modal-content"> <div class="modal-header"> <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> <h4 class="modal-title" id="myModalLabel">Agregar '+title+'</h4> </div><div class="modal-body"> <div class="panel panel-default"> <!-- /.panel-body --> <div class="panel-body"> <div class="row"> <div class="col-xs-6"> <div class="form-group"> <label>'+title+'</label> <input class="form-control" name="'+lowerCaseTitle+'NombreTxt" id="'+lowerCaseTitle+'NombreTxt" placeholder="Nombre"> </div> </div> </div>  <!-- /.Descripcion -->  <button type="button"  class="btn btn-default" data-dismiss="modal">Cerrar</button> <button id="guardar'+title+'" type="button"  class="btn btn-primary">Guardar</button>  <button type="button" class="btn btn-primary " id="myBtn'+title+'Show" >Crear</button> </div> <!-- /.dataTable -->  <div class="modal-footer">  <table id="table_'+lowerCaseTitle+'" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  </table>  </div>  </div> </div>  </div>  <!-- /.modal-content -->  </div>  <!-- /.modal-dialog -->  </div> ');

        $(div).append(varDiv);
      }     
      
      function appendText2(title,title2) {        
        div="#div"+title;  
        nameModal="myModal"+title;
        lowerCaseTitle=title.toLowerCase();
        lowerCaseTitle2=title2.toLowerCase();  
        var varDiv = $('<div style="display: none;" class="modal fade" id="'+nameModal+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> <div class="modal-dialog"> <div class="modal-content"> <div class="modal-header"> <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> <h4 class="modal-title" id="myModalLabel">Agregar '+title+'</h4> </div><div class="modal-body"> <div class="panel panel-default"> <!-- /.panel-body --> <div class="panel-body"> <div class="row"> <div class="col-xs-6"> <div class="form-group"> <label>'+title+'</label> <input class="form-control" name="'+lowerCaseTitle+'NombreTxt" id="'+lowerCaseTitle+'NombreTxt" placeholder="Nombre"> </div> </div>  <div class="col-xs-6"> <div class="form-group"> <label>'+title2+'</label> <input class="form-control" name="'+lowerCaseTitle2+'NombreTxt" id="'+lowerCaseTitle2+'NombreTxt" placeholder="Nombre"> </div> </div>   </div>  <!-- /.Descripcion -->  <button type="button"  class="btn btn-default" data-dismiss="modal">Cerrar</button> <button id="guardar'+title+'" type="button"  class="btn btn-primary">Guardar</button>  <button type="button" class="btn btn-primary " id="myBtn'+title+'Show" >Crear</button> </div> <!-- /.dataTable -->  <div class="modal-footer">  <table id="table_'+lowerCaseTitle+'" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  </table>  </div>  </div> </div>  </div>  <!-- /.modal-content -->  </div>  <!-- /.modal-dialog -->  </div> ');

        $(div).append(varDiv);
      } 
      
    
     
    $(document).ready(function() {
    
     appendText("Impacto");
     appendText("Estado");
     appendText("Modulo");
     appendText("Servicio");
     appendText("ServicioModulo");
     appendText("Servidor");
     appendText("Raiz");
     appendText("Grupo");
     appendText("InterfazAgencia")
     appendText("Agencia");
     appendModal("Agencia","Interfaz");
     
      
        
     //INICIALIZACION DEL DATA_TABLE SEGUIMIENTOS "table_seguimientos"
     var t= $('#table_seguimientos').DataTable( {
                    "ajax" : {
                        "url": "FindSeguimientos",
                        "type": "POST",
                        "data" : function(d){
                            d.ticket = ticket;
                            }
                    },
                    "global" : false,
                    "lengthMenu": [ 2, 5 ],
                    "dataType" : "json"
                 });
                 
       //INICIALIZACION DEL DATA_TABLE TICKET "table_ticket_show"
     var tableTicketShow= $('#table_ticket_show').DataTable( {
                    "ajax" : {
                        "url": "ShowTicket",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Ticket";
                            d.limitFields = "0";
                            }
                    },
                    "global" : false,
                    "lengthMenu": [[ 5, -1], [ 5,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "Titulo"},
                     {"title": "Analista"},
                     {"title": "Fecha"}
                    ],
                    "columnDefs": [ {
                        "targets": 4,
                        "data": null,
                        "defaultContent": "<center><a href='#dialog' id='editaricon'  data-toggle='modal' data-target='#myModal' data-backdrop='static' data-keyboard='false'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 5,
                        "data": null,
                        "defaultContent": "<center><a href='#dialog' id='seguimientosicon'  data-toggle='modal' data-target='#myModalSeguimiento' data-backdrop='static' data-keyboard='false'>"+                          
                                           "<img  src='img/pencil.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });     
     
     
     //INICIALIZACION DEL DATA_TABLE ANALISTA "table_analista
     var tableAnalista= $('#table_analista').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){
                            d.transaccion = "inicializar",
                            d.className = "Analista";
                            d.relationName = ["Descripcion"],
                            d.limitFields = "0";
                            }
                    },
                    "global" : false,
                    "lengthMenu": [ 5, 5 ],
                    "dataType" : "json",
                     "columns" : [
                     {"title": "Id"},
                     {"title": "Nombre"},                     
                     {"title": "Apellido"},
                     {"title": "Usuario"},
                     {"title": "Password"},
                     {"title": ""}                 
                    ],
                  "columnDefs": [ 
                        {
                        "targets": 5,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogAnalista2' id='EliminarAnalista'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    }); 
                    
     //INICIALIZACION DEL DATA_TABLE ESTADO "table_estado
     var tableEstado= $('#table_estado').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Estado";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "Estado"},                     
                     {"title": ""},
                     {"title": ""}
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogEstado' id='seleccionarEstado'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogEstado2' id='eliminarEstado'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
                    
     //INICIALIZACION DEL DATA_TABLE IMPACTO "table_impacto
     var tableImpacto= $('#table_impacto').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Impacto";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "Impacto"},                     
                     {"title": ""},
                     {"title": ""}
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogImpacto' id='seleccionarImpacto'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogImpacto2' id='eliminarImpacto'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
     
      //INICIALIZACION DEL DATA_TABLE MODULO "table_modulo
     var tableModulo= $('#table_modulo').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Modulo";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "Modulo"},                     
                     {"title": ""},
                     {"title": ""}
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogModulo' id='seleccionarModulo'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogModulo2' id='eliminarModulo'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
     
      //INICIALIZACION DEL DATA_TABLE SERVICIO "table_servicio
     var tableServicio= $('#table_servicio').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Servicio";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "Servicio"},                     
                     {"title": ""},
                     {"title": ""}
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogServicio' id='seleccionarServicio'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogServicio2' id='eliminarServicio'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
                    
      //INICIALIZACION DEL DATA_TABLE SERVIDOR "table_servidor
     var tableServidor= $('#table_servidor').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Servidor";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "Servidor"},                     
                     {"title": ""},
                     {"title": ""}
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogServidor' id='seleccionarServidor'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogServidor2' id='eliminarServidor'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
                    
     //INICIALIZACION DEL DATA_TABLE SERVICIO MODULO "table_serviciomodulo
     var tableServicioModulo= $('#table_serviciomodulo').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "ServicioModulo";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "ServicioModulo"},                     
                     {"title": ""},
                     {"title": ""}
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogServicioModulo' id='seleccionarServicioModulo'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogServicioModulo2' id='eliminarServicioModulo'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
     
     //INICIALIZACION DEL DATA_TABLE SERVICIO MODULO "table_raiz"
     var tableRaiz= $('#table_raiz').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Raiz";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "ServicioModulo"},                     
                     {"title": ""},
                     {"title": ""}
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogRaiz' id='seleccionarRaiz'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogRaiz2' id='eliminarRaiz'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
     
     //INICIALIZACION DEL DATA_TABLE SERVICIO MODULO "table_grupo"
     var tableGrupo= $('#table_grupo').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Grupo";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "ServicioGrupo"},                     
                     {"title": ""},
                     {"title": ""}
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogGrupo' id='seleccionarGrupo'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogGrupo2' id='eliminarGrupo'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
                    
     //INICIALIZACION DEL DATA_TABLE SERVICIO MODULO "table_agencia"
     var tableAgencia= $('#table_agencia').DataTable( {
                    "ajax" : {
                        "url": "Show",
                        "type": "GET",
                        "data" : function(d){                            
                            d.className = "Agencia";
                            d.limitFields = "0";
                            }
                    },                   
                    "global" : false,
                    "lengthMenu": [[ 2, -1], [ 2,"All"]],
                    "dataType" : "json",
                    "columns" : [
                     {"title": "Id"},
                     {"title": "Agencia"},                     
                     {"title": ""},
                     {"title": ""},
                     {"title": ""}
                     
                    ],
                    "columnDefs": [ {
                        "targets": 2,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogAgencia' id='seleccionarAgencia'>"+                          
                                           "<img  src='img/lupa.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                        {
                        "targets": 3,
                        "data": null,
                        "defaultContent": "<center><a href='#dialogAgencia2' id='eliminarAgencia'>"+                          
                                           "<img  src='img/eliminar.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        },
                         {
                        "targets": 4,
                        "data": null,
                        "defaultContent": "<center><a href='#dialog' id='seguimientosicon'  data-toggle='modal' data-target='#myModalInterfaz' data-backdrop='static' data-keyboard='false'>"+                          
                                           "<img  src='img/pencil.png' width='16' height='16'  border='0' />"+       
                                          "</a></center>"
                        }
                        ]
                    });
                    
      //Seleccion de Ticket   
     $('#table_ticket_show tbody').on( 'click','#editaricon', function () {
                   
                    var data = tableTicketShow.row( $(this).parents('tr') ).data();
                    idTicket=data[0];  
                    idTicketUpdate=idTicket;
                    
                    $.post("FindTicket",
                            {
                               id: idTicket
                           },
                           function(json){                                    
                                    $("#titulotxt").val(json.titulo);
                                    $("#serviciotxt").val(json.servicio);
                                    $("#modulotxt").val(json.modulo);
                                    $("#serviciomodulotxt").val(json.modulo);                                   
                                    $("#nombreservidortxt").val(json.servidor);                     
                                    $("#impactotxt").val(json.impacto);                                                           
                                    $("#fechainiciotxt").val(json.inicio);
                                    $("#fechafinaltxt").val(json.final);
                                    $("#estadotxt").val(json.estado);
                                    $("#descripciontxt").val(json.descripcion);
                                    $("#causatxt").val(json.causa);
                                    $("#soluciontxt").val(json.solucion);                     
                                    $("#myModal").modal();
                                });
                                    $("#guardarticket").hide(); 
                                    $("#editticket").show();
                                    $("#myBtnSeguimientoShow").hide();                    
               } ); 
        
     //Seleccion de Seguimiento relacionado al ticket   
     $('#table_ticket_show tbody').on( 'click','#seguimientosicon', function () {
           txtSeguimiento.value="";
           var data = tableTicketShow.row( $(this).parents('tr') ).data();
           ticket=data[0];  
                     
           //LIMPIA EL DATA_TABLE
            t.clear().draw();
           
           //recarga los datos nuevamente en el dataTable por ajax
           t.ajax.reload();      
           
                   // var data = tableTicketShow.row( $(this).parents('tr') ).data();
                    //idTicket=data[0];  
                                  
               } );  

     //Seleccion de Analista   
     $('#table_analista tbody').on( 'click','#seleccionarAnalista', function () {
                   
                    var dataAnalista = tableAnalista.row( $(this).parents('tr') ).data();
                    idAnalista=dataAnalista[0];  
                    AnalistaNombreTxt.value=dataAnalista[1];
                    AnalistaApellidoTxt.value=dataAnalista[2];
                    AnalistaUsuarioTxt.value=dataAnalista[3];
                    AnalistaPasswordTxt.value=dataAnalista[4];
                    
               } );  
     
     //Eliminacion de Analista
     $('#table_analista tbody').on( 'click','#EliminarAnalista', function () {  
          
            var dataExample = tableAnalista.row( $(this).parents('tr') ).data();
            var tableName = tableAnalista;
            id=dataExample[0];
            var array = [id];  
            var className = "Analista";
            var request = "Delete";
            var message = "Analista eliminado";
            requestAjax(array,className,request,message,tableName);
        } );     
      
     //Guardar Analista                 
     $("#guardarAnalista").click(function(){ 
                nombre=$('#txtnombre').val();
                apellido=$('#txtapellido').val();
                user=$('#txtuser').val();
                password=$('#txtpassword').val();
                grupoanalista=$('#grupoanalistatxt').val();
                
                var tableName = tableAnalista;
                var array = [nombre,apellido,user,password,grupoanalista];   
                var className = "Analista";
                var classNameRelation = "Grupo";
                var request = "Save";
                var message = "Analista guardado";
                requestAjax(array,className,request,message,tableName,classNameRelation);
                });
      

     //Guardar 
     $("#guardarServidor").click(function(){ 
            guardar("Servidor",tableServidor);
      });
     $("#guardarRaiz").click(function(){ 
            guardar("Raiz",tableRaiz);
      }); 
     $("#guardarServicioModulo").click(function(){ 
          guardar("ServicioModulo",tableServicioModulo)
        });  
     $("#guardarServicio").click(function(){ 
          guardar("Servicio",tableServicio)
        });  
     $("#guardarModulo").click(function(){ 
          guardar("Modulo",tableModulo)
        });  
     $("#guardarImpacto").click(function(){ 
          guardar("Impacto",tableImpacto)
        });    
     $("#guardarEstado").click(function(){ 
          guardar("Estado",tableEstado)
        });   
     $("#guardarGrupo").click(function(){ 
          guardar("Grupo",tableGrupo)
        });  
       $("#guardarAgencia").click(function(){ 
          guardar("Agencia",tableAgencia)
        });  
       
      
     //Eliminar
     $('#table_servidor tbody').on( 'click','#eliminarServidor', function () {                  
            var dataEliminar = tableServidor.row( $(this).parents('tr') ).data();
            eliminar("Servidor",tableServidor,dataEliminar);
        } );         
     $('#table_raiz tbody').on( 'click','#eliminarRaiz', function () {    
               var dataEliminar = tableRaiz.row( $(this).parents('tr') ).data();
            eliminar("Raiz",tableRaiz,dataEliminar);
        } );  
     $('#table_serviciomodulo tbody').on( 'click','#eliminarServicioModulo', function () {    
            var dataEliminar = tableServicioModulo.row( $(this).parents('tr') ).data();
            eliminar("ServicioModulo",tableServicioModulo,dataEliminar);
        } );     
     $('#table_servicio tbody').on( 'click','#eliminarServicio', function () {    
            var dataEliminar = tableServicio.row( $(this).parents('tr') ).data();
            eliminar("Servicio",tableServicio,dataEliminar);
        } ); 
     $('#table_modulo tbody').on( 'click','#eliminarModulo', function () {    
            var dataEliminar = tableModulo.row( $(this).parents('tr') ).data();
            eliminar("Modulo",tableModulo,dataEliminar)
        } );  
     $('#table_impacto tbody').on( 'click','#eliminarImpacto', function () {    
            var dataImpacto = tableImpacto.row( $(this).parents('tr') ).data();
            eliminar("Impacto",tableImpacto,dataImpacto);
        } );
     $('#table_estado tbody').on( 'click','#eliminarEstado', function () {    
            var dataEstado = tableEstado.row( $(this).parents('tr') ).data();
            eliminar("Estado",tableEstado,dataEstado);
        } ); 
     $('#table_grupo tbody').on( 'click','#eliminarGrupo', function () {    
            var dataGrupo = tableGrupo.row( $(this).parents('tr') ).data();
            eliminar("Grupo",tableGrupo,dataGrupo);
        } );
     $('#table_agencia tbody').on( 'click','#eliminarAgencia', function () {    
            var dataAgencia = tableAgencia.row( $(this).parents('tr') ).data();
            eliminar("Agencia",tableGrupo,dataAgencia);
        } );   
        
        
        
     //Seleccion   
     $('#table_servidor tbody').on( 'click','#seleccionarServidor', function () {
          var dataEliminar = tableServidor.row( $(this).parents('tr') ).data();
          seleccion("Servidor",tableServidor,dataEliminar,dataEliminar)
     } );     
     $('#table_raiz tbody').on( 'click','#seleccionarRaiz', function () {
           var dataEliminar = tableRaiz.row( $(this).parents('tr') ).data();
          seleccion("Raiz",tableRaiz,dataEliminar)
     } );
     $('#table_serviciomodulo tbody').on( 'click','#seleccionarServicioModulo', function () {
           var dataEliminar = tableServicioModulo.row( $(this).parents('tr') ).data();
          seleccion("Raiz",tableRaiz,dataEliminar)
     } );
     $('#table_servicio tbody').on( 'click','#seleccionarServicio', function () {
           var dataEliminar = tableServicio.row( $(this).parents('tr') ).data();
          seleccion("Servicio",tableServicio,dataEliminar);
     } );
     $('#table_modulo tbody').on( 'click','#seleccionarModulo', function () {
              var dataEliminar = tableModulo.row( $(this).parents('tr') ).data();
              seleccion("Modulo",tableModulo,dataEliminar);
               } );
     $('#table_impacto tbody').on( 'click','#seleccionarImpacto', function () {
              var dataEliminar = tableImpacto.row( $(this).parents('tr') ).data();
              seleccion("Impacto",tableImpacto,dataEliminar);
               } );
     $('#table_estado tbody').on( 'click','#seleccionarEstado', function () {
              var dataEliminar = tableEstado.row( $(this).parents('tr') ).data();
              seleccion("Estado",tableEstado,dataEliminar);
               } );
     $('#table_grupo tbody').on( 'click','#seleccionarGrupo', function () {
              var dataEliminar = tableGrupo.row( $(this).parents('tr') ).data();
              seleccion("Grupo",tableGrupo,dataEliminar);
               } );
      $('#table_agencia tbody').on( 'click','#seleccionarAgencia', function () {
              var dataEliminar = tableAgencia.row( $(this).parents('tr') ).data();
              seleccion("Agencia",tableAgencia,dataEliminar);
               } );
      
      
        
      function guardar(nameObject,tableObject){
          text="#"+nameObject.toLowerCase()+"NombreTxt";
          nameObjectGlobal=nameObject;
          tableBody="#table_"+nameObject.toLowerCase()+" tbody";  
            
          dataNombre=$(text).val();  
          var tableName = tableObject;
          var array = [dataNombre];
          var className = nameObjectGlobal;
          var request = "Save";
          var message = nameObject+" "+"guardado";
          requestAjax(array,className,request,message,tableName);
            
            
        }
        
      function eliminar(nameObject,tableObject,idArray){
            text="#"+nameObject.toLowerCase()+"NombreTxt";
            nameObjectGlobal=nameObject;
            tableBody="#table_"+nameObject.toLowerCase()+" tbody";  
            id=idArray[0];  
            var tableName = tableObject;
            var array = [id];
            var className = nameObject;
            var request = "Delete";
            var message = nameObject+" eliminado";
            requestAjax(array,className,request,message,tableName);
            
            
        }
      
      function seleccion(nameObject,tableObject,idArray){
            text="#"+nameObject.toLowerCase()+"NombreTxt";
            nameObjectGlobal=nameObject;   
                    idRaiz=idArray[0];  
                    $(text).val(idArray[1]);
        }
   
      
   
     //En la carga hecha en la ta seguimientos
      $('#table_seguimientos').on('click','td', function() {
        var data = t.row( $(this).parents('tr') ).data();
                    txtSeguimiento.value=data[2];
        });
      
     
      //LLAMADA DE CARGA POR AJAX DE SEGUIMIENTOS POR TICKET ID
     $('a[href="#dialog"]').click(function(){
         
           //Guardar lo que esta en el atributo name
           ticket = $(this).attr("name");
           
           //recarga los datos nuevamente en el dataTable por ajax
           t.ajax.reload();          
               
        });  
        
     //PARAMETROS POR AJAX PARA GUARDAR NUEVO SEGUIMIENTO     
     $("#guardarSeguimiento").click(function(){ 
           descripcionSeguimiento=$('#txtSeguimiento').val();
                 
                    $.ajax({
                    type: "GET",
                    url: "SaveSeguimiento",
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
                    url: "SaveTicket",
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
                       
                    },
                    success:
                     function(responseSave){                         
                            alert(responseSave);
                            tableTicketShow.ajax.reload();
                            
                        }
                    });
                });
     $("#editticket").click(function(){ 
         
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
                    url: "EditTicket",
                    global: false,
                    async : false,
                    data: { 
                        id: idTicketUpdate,
                        titulo: titulo,
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
                       
                    },
                    success:
                     function(responseSave){                         
                            alert(responseSave);
                            tableTicketShow.ajax.reload();
                            
                        }
                    });
                });
     
     //LIMPIAR CAMPO ANALISTAS
     $("#myBtnAnalistaShow").click(function(){ 
         
      AnalistaNombreTxt.value="";
      AnalistaApellidoTxt.value="";
      AnalistaUsuarioTxt.value="";
      AnalistaPasswordTxt.value="";
          
      });      
      
      function requestAjax(array,className,request,message,tableName,classNameRelation){
                    $.ajax({
                    type: "GET",
                    url: String(request),
                    global: false,
                    async : false,
                    data: {
                        array: array,
                        className:String(className),
                        classNameRelation:String(classNameRelation)
                    }
                    });
                    
                    tableName.ajax.reload();
                    bootbox.alert({
                    message: String(message),
                    size: 'small'
                    });
      }
     

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
                                    <a href="#" data-toggle="modal" data-target="#myModalEstado" data-backdrop="static" data-keyboard="false">Estados</a>
                                </li>
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModalImpacto" data-backdrop="static" data-keyboard="false">Impacto</a>
                                </li>
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModalModulo" data-backdrop="static" data-keyboard="false">Modulos</a>
                                </li>
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModalServicio" data-backdrop="static" data-keyboard="false">Servicios</a>
                                </li>
                                 <li>
                                    <a href="#" data-toggle="modal" data-target="#myModalServicioModulo" data-backdrop="static" data-keyboard="false">SubServicio</a>
                                </li>
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModalServidor" data-backdrop="static" data-keyboard="false">Servidores</a>
                                </li>
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModalRaiz" data-backdrop="static" data-keyboard="false">Raiz</a>
                                </li>
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModalGrupo" data-backdrop="static" data-keyboard="false">Grupo</a>
                                </li>
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModalAgencia" data-backdrop="static" data-keyboard="false">Agencia</a>
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
                
             <div class="panel panel-default">
                        <div class="panel-heading">
                            Gestión de Tickets
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                          
                            <br>
                            <h4>Crear nuevo Ticket</h4>
                            <p>
                                
                                <br>
                                <br>
                                <button type="button" class="btn btn-primary btn-lg btn-block" id="myBtnNewTicket">Nuevo Ticket</button>
                            </p>
                        </div>
                        <!-- /.panel-body -->
            </div>
             <div class="col-lg-12">
                     <div class="panel panel-default">
                        <div class="panel-heading">
                            Tickets
                        </div>
                                <div class="panel-body">
                                  <div class="table-responsive">
                                      
                        <table id="table_ticket_show" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                          
                                             <thead>
                                                <tr>
                                                <th>Id</th>
                                                <th>Titulo</th>
                                                <th>Analista</th>
                                                <th>Fecha</th>
                                                <th></th>
                                                <th></th>
                                                </tr>
                                             </thead>
                                             
                        </table>
                                </div>
                            </div> 
                        </div>
                        
                       
                <!-- /.panel-heading -->
                <div class="panel-body">
                <!-- Modal -->
                <!-- Modal Tickets -->
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
                                            <input class="form-control" id="titulotxt" maxlength="45" placeholder="Titulo">
                                    </div>
                                </div>
                            </div><!-- /.Titulo -->
                              
                            <div class="row">
                                
                                <div class="col-lg-4">
                                    <div class="form-groupModal title">
                                            <label>Servicio</label>
                                            <select id="serviciotxt" class="form-control">
                                                <option>seleccionar</option> 
                                                  <%                                                 
                                                    for(Object objectName: listObject.getListArrayObject(new Servicio(), "Servicio")){
                                                    List<Object> objectArray = (List<Object>)objectName;                                                   
                                                  %> 
                                         
                                                <option name="option" value=<%= objectArray.get(0) %>><%= objectArray.get(1) %>  </option>  
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
                                                    for(Object objectName: listObject.getListArrayObject(new Modulo(), "Modulo")){
                                                    List<Object> objectArray = (List<Object>)objectName;                                                   
                                                  %> 
                                          
                                                <option name="option" value=<%= objectArray.get(0) %>><%= objectArray.get(1) %>  </option>      
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
                                                    for(Object objectName: listObject.getListArrayObject(new ServicioModulo(), "ServicioModulo")){
                                                    List<Object> objectArray = (List<Object>)objectName;                                                   
                                                  %> 
                                            
                                                <option name="option" value=<%= objectArray.get(0) %>><%= objectArray.get(1) %>  </option>      
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
                                                    for(Object objectName: listObject.getListArrayObject(new Servidor(), "Servidor")){
                                                    List<Object> objectArray = (List<Object>)objectName;                                                   
                                                  %> 
                                          
                                                <option name="option" value=<%= objectArray.get(0) %>><%= objectArray.get(1) %>  </option>      
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
                                                    for(Object objectName: listObject.getListArrayObject(new Impacto(), "Impacto")){
                                                    List<Object> objectArray = (List<Object>)objectName;                                                   
                                                 %>  
                                       
                                                <option name="option" value=<%= objectArray.get(0) %>><%= objectArray.get(1) %>  </option>      
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
                                                    for(Object objectName: listObject.getListArrayObject(new Estado(), "Estado")){
                                                    List<Object> objectArray = (List<Object>)objectName;                                                   
                                                 %>  
                                       
                                                <option name="option" value=<%= objectArray.get(0) %>><%= objectArray.get(1) %>  </option>      
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
                                <button id="editticket" type="button" class="btn btn-primary">Modificar Ticket</button>
                                <button id="myBtnSeguimientoShow"  type="button" class="btn btn-primary " >Crear Seguimiento</button>
                            </div>
                     </div>
                                            
                    </div>      
                               
                        
                                <!-- /.modal-dialog -->
                            </div>
                                <!-- /.modal-dialog -->
                            
                                <!-- /.modal-dialog -->
                            
                                    </div>
                 <!-- /.modal-content -->
                 </div>
                 
                <!-- Modal Seguimientos -->                            
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
                                          <button type="button" id="guardarSeguimiento" class="btn btn-primary">Guardar Cambios</button>
                                              
                                         
                                        </div>
                                        <div class="modal-footer">
                                            
                                            <table id="table_seguimientos" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                          
                                            <thead>
                                                <tr>
                                                <th>id</th>
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
               
                <!-- Modal Analista -->
                 <div style="display: none;" class="modal fade" id="myModaAnalista" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
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
                                            <input class="form-control" name="txtnombre" id="txtnombre" placeholder="Nombre">
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div class="form-group">
                                            <label>Apellido</label>
                                            <input class="form-control" name="txtapellido" id="txtapellido" placeholder="Apellido">
                                    </div>
                                </div>
                            </div><!-- /.Nombre Apellido -->  
                            
                            <div class="row">                            
                                <div class="col-xs-6">
                                    <div class="form-group">
                                            <label>Usuario</label>
                                            <input class="form-control" name="txtuser" id="txtuser" placeholder="Usuario">
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div class="form-group">
                                            <label>Password</label>
                                            <input class="form-control" name="txtpassword" id="txtpassword" placeholder="Password">
                                    </div>
                                </div>
                            </div><!-- /.Usuario Contraseña -->  
                            <div class="row">
                                  <div class="col-xs-6">
                                       <div class="form-group">
                                          <label>Grupo</label>
                                             <select id="grupoanalistatxt" class="form-control">
                                                <option>Seleccionar</option>
                                                 <%                                                
                                                    for(Object objectName: listObject.getListArrayObject(new Estado(), "Grupo")){
                                                    List<Object> objectArray = (List<Object>)objectName;                                                   
                                                 %>  
                                       
                                                <option name="option" value=<%= objectArray.get(0) %>><%= objectArray.get(1) %>  </option>      
                                                <%}%>   
                                             </select>
                                        </div> <!-- /.Impacto -->  
                                   </div>
                             </div>
                             
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                <button id="guardarAnalista" type="button" class="btn btn-primary">Guardar</button>                             
                                <button type="button" class="btn btn-primary " id="myBtnAnalistaShow" >Crear Grupo</button>
                            </div>
                            <div class="modal-footer">
                                <table id="table_analista" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                          
                                             <thead>
                                                <tr>
                                                <th>Id</th>
                                                <th>Nombre</th>
                                                <th>Apellido</th>
                                                <th>Usuario</th>
                                                <th>Password</th>             
                                                <th></th>
                                                </tr>
                                             
                                </table>
                            </div>
                     </div>
                                            
                    </div>    
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                 </div>   
                 <!-- /.modal Analista-->
                 
                 <!-- Modal Estado -->
                 <div id="divEstado"></div> 
                 <!-- /.modal Estado-->
                 
                 <!-- Modal Impacto -->
                 <div id="divImpacto"></div> 
                 <!-- /.modal Impacto-->
                 
                 
                   <!-- Modal Modulos -->
                 <div id="divModulo"></div> 
                 <!-- /.modal Modulos-->
                 
                    <!-- Modal Servicio -->
                 <div id="divServicio"></div> 
                 <!-- /.modal Servicio-->
                 
                 
                    <!-- Modal Servidor -->
                 <div id="divServidor"></div> 
                 <!-- /.modal Servidor-->
                 
                 <!-- Modal ServicioModulo -->
                 <div id="divServicioModulo"></div> 
                 <!-- /.modal ServicioModulo-->
                 
                 <!-- Modal Raiz -->
                 <div id="divRaiz"></div> 
                 <!-- /.modal Raiz-->
                 
                 <!-- Modal Grupo -->
                 <div id="divGrupo"></div> 
                 <!-- /.modal Grupo-->
                 
                  <!-- Modal Agencia -->
                  <div id="divAgencia">
                 
                  </div> 
                 <!-- /.modal Agencia-->
                 
                 
             
             
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
                        $("#myBtnNewTicket").click(function(){
                            $("#myModal").modal();
                            $("#myBtnSeguimientoShow").hide();
                            $("#editticket").hide();                            
                            $("#titulotxt").val("");
                            $("#serviciotxt").val("");
                            $('#modulotxt option').eq("0").prop('selected', true);
                            $('#serviciomodulotxt option').eq("0").prop('selected', true);                                   
                            $('#nombreservidortxt option').eq("0").prop('selected', true);
                            $('#impactotxt option').eq("0").prop('selected', true);                                  
                            $("#fechainiciotxt").val("");
                            $("#fechafinaltxt").val("");
                            $('#estadotxt option').eq("0").prop('selected', true);                                    
                            $("#descripciontxt").val("");
                            $("#causatxt").val("");
                            $("#soluciontxt").val("");
                            $('#impactotxt option').eq("0").prop('selected', true);
                            $("#guardarticket").show();                          
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
                        $("#myBtnAnalistaHide").click(function(){
                            $("#myModaAnalista").modal("hide");
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
