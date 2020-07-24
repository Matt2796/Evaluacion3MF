<%-- 
    Document   : index
    Created on : 20/07/2020, 02:52:15 PM
    Author     : mfaun
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductoDAO"%>
<%@page import="modelos.Producto"%>
<%@page import="modelos.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
    <center>
        <h2>Menu de navegacion</h2>
        <menu>
            <a href="admin.jsp">
            <menuitem >Iniciar sesion como admin</menuitem>
            </a> |
            <a href="index.jsp">
            <menuitem > Comprar productos </menuitem>
            </a>
        </menu>
        <table border="1px">
            <form action="ControladorPedido" >
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Precio</td>
            </tr>
            <% ArrayList<Producto> productos = new ProductoDAO().obtenerProductos();
               for(Producto p: productos){               
                %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getNombre() %></td>
                <td><%= p.getPrecio() %></td>
                <td><input type="checkbox" id="myCheck" onclick=""></td>
            </tr>
            <% } %>
             <tr>
                 <td>Ingrese correo <br> para registrar pedido </td>
                 <td> <input type="text" name="correo"/>  </td>
                <td><input type="submit" value="Iniciar Sesion"/></td>
            </tr>
            <input type="hidden" name="accion" value="1"/>
            </form>
            </table>
            <br>
            <br>
            <table border="1px">
            <tr>
            <form action="pedidoscorreo.jsp?correo=">
                <td> Ingrese correo para <br> buscar pedido: </td>
                <td> <input type="text" name="correo"/> </td>
                <td><input type="submit" value="Iniciar Sesion"/></td>
                <form>
            </tr>
            </table>
                        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%};%>
    </body>
</center>
</html>
