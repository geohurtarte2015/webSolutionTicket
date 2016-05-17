
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
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
                     "ajax": "ServletVerTicket",
                     "global" : false,
                     "lengthMenu": [[ 2, -1], [ 2,"All"]],
                     "dataType" : "json",
                      success : function(responseText) {
                      $('#example').dataTable( {
                      "data": responseText
                        });
                      }
                 } );
            } );
            
            
            $('#submit').click(function(event) {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...               
                var seguimientoVar = $('#descripcionSeguimiento').val();            
                $.get("ServletGuardarSeguimiento", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    descripcionSeguimiento : seguimientoVar,            
                    global : false,   
                    dataType : "json",
                    },function(responseText) {
                        $('#example').dataTable( {
                            "data": responseText
                            });
                     });
                        
            });
            
            
            $(document).ready(function() {
		$('#submit').click(function(event) {
			var nombreVar = $('#nombre').val();
			var apellidoVar = $('#apellido').val();
			var edadVar = $('#edad').val();
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.post('ActionServlet', {
				nombre : nombreVar,
				apellido: apellidoVar,
				edad: edadVar
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
          
          
          
            
        </script>
  
        
        

        <title>Data Table with Ajax</title>
    </head>
    
    
    
    <body>
        
        
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Modals
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Button trigger modal -->
                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                                Launch Demo Modal
                            </button>
                            <!-- Modal -->
                            <div style="display: none;" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                         <form role="form" id="infseguimiento">
                                          <div class="row">
                                                <div class='col-lg-4'>
                                                    <div class="form-group">
                                                        <div class="form-group">                                    
                                                            <textarea class="form-control" style="min-width: 100%; margin: 0px -391.672px 0px 0px; width: 562px; height: 138px;" rows="5" name="descripcionSeguimiento"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                          </div>
                                            
                                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                          <button  type="button" id="submit" class="btn btn-primary">Save changes</button>
                                         </form>     
                                         
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
                            <!-- /.modal -->
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                
         
               
                    
                    
                
                  
    </body>
</html>
