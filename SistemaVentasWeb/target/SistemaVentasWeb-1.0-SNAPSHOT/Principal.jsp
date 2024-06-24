<%-- 
    Document   : Principal
    Created on : 25 may. de 2024, 00:48:35
    Author     : JHOMARA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://adminlte.io/themes/v3/dist/css/adminlte.min.css?v=3.2.0"/>
        <title>Principal</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <a class="navbar-brand" href="#">
                <img src="img/logo.png" alt="" width="40"/>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a  style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Inicio&accion=Listar" target="myFrame">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a  style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light"  href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light"  href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
                    </li>
                </ul>
            </div>

        </ul>
        <div class="dropdown">
            <button style="border:none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${ usuario.getNombres() }
            </button>
            <div class="dropdown-menu text-center">
                <a class="dropdown-item" href="#">
                    <img src="img/user.png" alt="Usuario" width="60">
                </a>
                <a class="dropdown-item" href="#">${ usuario.getUser() }</a>
                <a class="dropdown-item" href="#">usuario@gmail.com</a>
                <div class="dropdown-divider"></div>
                <form action="Validar" method="POST">
                    <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                </form>
            </div>
        </div> 
    </nav>
    <div class="container-fluid mt-3" id="fondo">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0">Inicio</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                    </ol>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-6">

                <div class="small-box bg-success">
                    <div class="inner">
                        <h3>${cantidadProductos}</h3>
                        <p>Productos Registrados</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-stats-bars"></i>
                    </div>
                    <a href="Controlador?menu=Producto&accion=Listar" target="myFrame" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                </div>
            </div>  
            <div class="col-lg-3 col-6">

                <div class="small-box bg-warning">
                    <div class="inner">
                        <h3>${cantidadEmpleados}</h3>
                        <p>Empleados Registrados</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-person-add"></i>
                    </div>
                    <a href="Controlador?menu=Empleado&accion=Listar" target="myFrame" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <div class="col-lg-3 col-6">

                <div class="small-box bg-danger">
                    <div class="inner">
                        <h3>${cantidadClientes}</h3>
                        <p>Clientes Registrados</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-pie-graph"></i>
                    </div>
                    <a href="Controlador?menu=Cliente&accion=Listar" target="myFrame" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <div class="col-lg-3 col-6">

                <div class="small-box bg-info">
                    <div class="inner">
                        <h3>${cantidadVentas}</h3>
                        <p>Cantidad Ventas</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-bag"></i>
                    </div>
                    <a href="Controlador?menu=NuevaVenta&accion=default" target="myFrame" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                </div>
            </div>
        </div>
    </div>

    <div class="m-4" style="height: 550px;">
        <iframe id="contentFrame" name="myFrame" style="height: 100%;width: 100%; border: none;"></iframe>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script>
        // Script para mostrar/ocultar el fondo basado en el contenido del iframe
        document.getElementById('contentFrame').addEventListener('load', function () {
            var iframe = document.getElementById('contentFrame');
            var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;
            var fondo = document.getElementById('fondo');

            if (iframeDoc.body.innerHTML.trim().length > 0) {
                fondo.style.display = 'none';
            } else {
                fondo.style.display = 'block';
            }
        });
    </script>
</body>
</html>
