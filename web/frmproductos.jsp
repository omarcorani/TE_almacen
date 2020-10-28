<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${productos.id == 0}">Nuevo</c:if>
            <c:if test="${productos.id != 0}">Editar</c:if>
            productos
        </h1>
            <form action="inicio" method="post">
                <input type="hidden" name="id" value="${productos.id}" />
            <table>
                <tr>
                    <td>Nombre Producto:</td>
                    <td><input type="text" name="nombre_producto" value="${productos.nombre_producto}" /></td>
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><input type="number" name="precio" value="${productos.precio}" /></td>
                </tr>
                <tr>
                    <td>Stock:</td>
                    <td><input type="number" name="stock" value="${productos.stock}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
            </form>
    </body>
</html>
