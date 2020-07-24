<%-- 
    Document   : pedidoscorreo
    Created on : 20/07/2020, 08:49:06 PM
    Author     : mfaun
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.PedidoDAO"%>
<%@page import="modelos.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos por correo</title>
    </head>
    <body>
        <center>
            <h1> Lista de pedidos según correo ingresado </h1>
        <table border="1px">
            
            <tr>
                <td> ID </td>
                <td>
                    Correo 
                </td>
                <td>
                    Estado
                </td>
            </tr>
            <% ArrayList<Pedido> pedidos = new PedidoDAO().obtenerPedidosCorreo(request.getParameter("correo"));
               for(Pedido p: pedidos){               
                %>
            <tr>

                <td><%= p.getId() %></td>
                <td><%= p.getCorreo() %></td>
                <td><%= p.getEstado() %></td>
                </td>
            </tr>
            
            <% } %>

        </table>
            </center>   
    </body>
</html>
