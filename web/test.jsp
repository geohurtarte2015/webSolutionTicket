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
        
    </head>
<body>
        <div class="container">
            <div class="row">
                <div class='col-lg-4'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker1'>
                            <input type='text' class="form-control" />
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                  $(function () {
                    $('#datetimepicker1').datetimepicker({
                        format: "DD-MM-YYYY hh:mm a"                      
                        });
                    });
                </script>
            </div>
        </div>

</body>
</html>
