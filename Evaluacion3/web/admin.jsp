<%-- 
    Document   : admin
    Created on : 20/07/2020, 06:07:33 PM
    Author     : mfaun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesion</title>
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
        <h1>Inicio de Sesion</h1>
        <form action="ControladorUsuario" method="post">
        <table>
            <tr>    
                <td>Usuario</td>
                <td><input type="text" name="usuario"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Iniciar Sesion"/></td>
            </tr>
        </table>
            <input type="hidden" name="accion" value="1"/>
        </form>
                <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        </center>
    </body>
</html>
