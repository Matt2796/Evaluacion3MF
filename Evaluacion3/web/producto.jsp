<%-- 
    Document   : producto
    Created on : 20/07/2020, 06:42:25 PM
    Author     : mfaun
--%>

<%@page import="modelos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductoDAO"%>
<%@page import="modelos.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
                    <% if(session.getAttribute("admin")!= null){
             Usuario u = (Usuario) session.getAttribute("admin");
            }else{response.sendRedirect("index.jsp?msj=Acceso Denegado");}%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud productos</title>
    </head>
    <body>
    <center>
        <h2> Cerrar Sesion </h2>    
         <a href="Salir"><input type="button" value="Cerrar Sesion"/></a>
        <h2>Menu de navegacion</h2>
        <menu>
            <a href="producto.jsp">
            <menuitem >Crud productos</menuitem>
            </a> | 
            <a href="modpedido.jsp">
            <menuitem >Cambiar estado de pedidos</menuitem>
            </a>
        </menu>
        <h2> Registrar nuevo producto </h2>
                <form action="ControladorProducto" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="number" name="id"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="number" name="precio"></td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Registrar"/></td>
                <input type="hidden" name="accion" value="1"/>
                </tr>
            </table>
        </form>
                        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
   
        <h2> Productos registrados </h2>
        <table border="1px">
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
            </tr>
            <% } %>
        </table>
    </body>
</center>
</html>
