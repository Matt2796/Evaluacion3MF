<%-- 
    Document   : modpedido
    Created on : 20/07/2020, 07:34:46 PM
    Author     : mfaun
--%>

<%@page import="modelos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.PedidoDAO"%>
<%@page import="modelos.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
                <% if(session.getAttribute("admin")!= null){
             Usuario u = (Usuario) session.getAttribute("admin");
            }else{response.sendRedirect("index.jsp?msj=Acceso Denegado");}%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar pedidos</title>
    </head>
    <body>
    <center>
            <h2> Cerrar Sesion </h2>  
            <a href="Salir"><input type="button" value="Cerrar Sesion"/></a>
            <menu>
            <a href="producto.jsp">
            <menuitem >Crud productos</menuitem>
            </a> | 
            <a href="modpedido.jsp">
            <menuitem >Cambiar estado de pedidos</menuitem>
            </a>
        </menu>
               <h2> Pedidos registrados </h2>
        <table border="1px">
            <tr>
                <td>ID</td>
                <td>Correo</td>
                <td>Estado</td>
                <td>Opciones de estado</td>
            </tr>
            <% ArrayList<Pedido> pedidos = new PedidoDAO().obtenerPedidos();
               for(Pedido p: pedidos){               
                %>
                <form action="ControladorPedido" method="post">
            <tr>
                <td ><input type="text" readonly="true" name="id" value="<%= p.getId() %>"</td>
                <td><%= p.getCorreo() %></td>
                <td><%= p.getEstado() %></td>
                <td>
                    <input type="submit" value="Pendiente" name="accion"/>

                    <input type="submit" value="Rechazado" name="accion"/>
                    <input type="submit" value="Aceptado" name="accion"/>
                </td>
            </tr>
             </form>
            <% } %>

        </table>
        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
        
    </center>
    </body>
</html>
