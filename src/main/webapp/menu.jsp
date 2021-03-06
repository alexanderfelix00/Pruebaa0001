<%-- 
    Document   : menu
    Created on : 13/11/2019, 11:30:04 PM
    Author     : alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://bootswatch.com/4/lumen/bootstrap.min.css">
        
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <span class="navbar-brand">CRUD AJAX</span>
        </nav>
        <div class="container mt-5">
            <div class="row">
                <div class="col-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="form">
                                <input type="hidden" id="id">
                                <div class="form-group">
                                    <input type="text" id="nombre" class="form-control" placeholder="Nombre">
                                </div>
                                
                                <div class="form-group">
                                    <input type="number" id="cantidad" class="form-control" placeholder="Cantidad">
                                </div>
                                <div class="form-group">
                                    <input type="text" id="precio" class="form-control" placeholder="Precio">
                                </div>
                                <button class="btn btn-primary btn-block" id="guardar">
                                    GUARDAR
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="table-responsive">
                        <table class="table table-hover table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th>#</th>
                                    <th>NOMBRE</th>
                                    <th>CANTIDAD</th>
                                    <th>ACCIONES</th>
                                     <th>#</th>
                                    <th>NOMBRE</th>
                                    <th>CANTIDAD</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody id="tbody-list">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="JS/menu.js" type="text/javascript"></script>
    </body>
</html>
