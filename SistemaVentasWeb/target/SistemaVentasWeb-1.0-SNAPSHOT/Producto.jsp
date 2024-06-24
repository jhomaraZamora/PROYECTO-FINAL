<%-- 
    Document   : Producto
    Created on : 11 jun. de 2024, 12:17:57
    Author     : JHOMARA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <form action="Controlador?menu=Producto" method="POST">
                                <div class="form-group">
                                    <label for="txtNombres">Nombre Producto: </label>
                                    <input type="text" name="txtNombres" id="txtNombres" class="form-control" required="" value="${producto.getNombres()}" />
                                </div>
                                
                                <div class="form-group">
                                    <label for="txtPrecio">Precio: </label>
                                    <input type="number" name="txtPrecio" id="txtPrecio" class="form-control" required="" value="${producto.getPrecio()}" />
                                </div>
                                
                                <div class="form-group">
                                    <label for="txtStock">Stock: </label>
                                    <input type="number" name="txtStock" id="txtStock" class="form-control" required="" value="${producto.getStock()}" />
                                </div>
                                
                                <div class="form-group">
                                    <label for="txtEstado">Estado: </label>
                                    <input type="text" name="txtEstado" id="txtEstado" class="form-control" required="" value="${producto.getEstado()}" />
                                </div>

                                <input type="submit" name="accion" value="Agregar" class="btn btn-info" />
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success" />
                            </form>
                        </div>
                    </div>
                </div>

                <div class="card col-md-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>NOMBRES</th>
                                <th>PRECIO</th>
                                <th>STOCK</th>
                                <th>ESTADO</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="em" items="${productos}">
                                <tr>
                                    <td>${em.getId()}</td>
                                    <td>${em.getNombres()}</td>
                                    <td>${em.getPrecio()}</td>
                                    <td>${em.getStock()}</td>
                                    <td>${em.getEstado()}</td>
                                    <td>
                                        <div class="btn-group" role="group" aria-label="Basic example">
                                            <a class="btn btn-warning"
                                               href="Controlador?menu=Producto&accion=Editar&id=${em.getId()}">Editar</a>
                                            <a class="btn btn-danger"
                                               href="Controlador?menu=Producto&accion=Eliminar&id=${em.getId()}">Eliminar</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

    </body>

</html>
