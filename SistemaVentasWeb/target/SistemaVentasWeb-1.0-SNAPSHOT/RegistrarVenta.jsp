<%-- 
    Document   : RegistrarVenta
    Created on : 11 jun. de 2024, 12:18:49
    Author     : JHOMARA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Registrar venta</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 mb-2">
                    <img src="img/logo.png" alt="logo" width="80"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5 parte01">
                    <div class="card">
                        <div class="card-body">
                            <form action="Controlador?menu=NuevaVenta" method="POST">
                                <div class="form-group">
                                    <label>Datos del Cliente</label> 
                                </div>

                                <div class="form-group d-flex">

                                    <div class="col-sm-6 d-flex">
                                        <div class="input-group">
                                            <input type="text" name="codigocliente" value="${c.getCi()}" class="form-control" placeholder="Codigo" />
                                            <div class="input-group-prepend">
                                                <button type="submit" name="accion" value="BuscarCliente" class="btn btn-primary">Buscar</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="nombrescliente" value="${c.getNombres()}" class="form-control" readonly="" />
                                    </div> 
                                </div>

                                <div class="form-group">
                                    <label>Datos Producto</label> 
                                </div>

                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <div class="input-group">
                                            <input type="text" name="codigoproducto" class="form-control" value="${producto.getId()}" placeholder="Codigo" />
                                            <div class="input-group-prepend">
                                                <button type="submit" name="accion" value="BuscarProducto" class="btn btn-primary">Buscar</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="nomproducto" value="${producto.getNombres()}" class="form-control" readonly="" />
                                    </div> 
                                </div>

                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="Bs./ 0.00" readonly="" />
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="number" name="cant" value="1" class="form-control" />
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="text" name="stock" value="${producto.getStock()}" placeholder="stock" class="form-control" readonly="" />
                                    </div>
                                </div>

                                <div class="form-group d-flex">
                                    <div class="col-sm-12">
                                        <button type="submit" name="accion" value="Agregar" class="btn btn-primary"> Agregar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="card col-md-7">

                    <div class="form-group row mt-2">
                        <label for="NroSerie" class="col-sm-2 col-form-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nro de Serie</label>
                        <div class="col-sm-10">
                            <input type="text" name="NroSerie" id="NroSerie" value="${nserie}" class="form-control" readonly=""/>
                        </div>
                    </div>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>NRO</th>
                                <th>CODIGO</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>
                                <th>CANTIDAD</th>
                                <th>SUBTOTAL</th>
                                <th class="accion">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td>
                                        <a class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Eliminar&id=${list.getItem()}">
                                            <i class="fa-solid fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <div class="card-footer d-flex" >
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger" />
                        </div>

                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="Bs/. ${totalPagar}" class="form-control" readonly />
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
