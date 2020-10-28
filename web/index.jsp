<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos</h1>
        
        <p><a href="inicio?action=add">Nuevo</a></p>
        
        <table border = "1">
            <tr>
                <th>Id</th>
                <th>Nombre Producto</th>
                <th>Precio</th>
                <th>Stock</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${productos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre_producto}</td>
                    <td>${item.precio}</td>
                    <td>${item.stock}</td>
                    <td><a href="inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta Seguro'))">Eliminar</a></td>
         
                           
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
