<%@page import="pojo.Seguimiento"%>
<%@page import="dao.DaoSeguimiento"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
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
       
        
        <script type="text/javascript" charset="utf-8">
                $(document).ready(function() {
                 $('#example').DataTable( {
                     "ajax": "ServletVerTicket"
                 } );
             } );
            </script>
        
    </head>
<body>
        <div class="container">
            <div class="row">
                <div class='col-lg-4'>
                   
                        <div class="panel-heading">
                            Modals
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Button trigger modal -->
                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" data-backdrop="static" data-keyboard="false">
                                Launch Demo Modal
                            </button>
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
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                <button type="button" class="btn btn-primary">Guardar Ticket</button>
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
                                                            <textarea class="form-control" style="min-width: 100%; margin: 0px -391.672px 0px 0px; width: 562px; height: 138px;" rows="5" id="descripcionSeguimiento"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                          </div>
                                            
                                          <button type="button" class="btn btn-default" id="myBtnSeguimientoHide2">Close</button>
                                          <button type="button" class="btn btn-primary">Save changes</button>
                                              
                                         
                                        </div>
                                        <div class="modal-footer">
                                            
                                            <table id="example2" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                          
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
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                        </div>
                        <!-- .panel-body -->
                    
                </div>
              
            </div>
        
  <script type="text/javascript">
            
                    $(document).ready(function() {
                    $('#example2').DataTable( {
                     "ajax": "ServletVerTicket"
                    });
                    });
             
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
