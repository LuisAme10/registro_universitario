<%@page import="com.emergentes.modelo.Universitario"%>
<%
    Universitario item =(Universitario) request.getAttribute("miUniversitario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <h1><%= (item.getId() ==0)? "Nuevo registro": "Editar registro"%></h1>
        <form action="MainController" method="post">
            <input type="hidden"  name="id" value="<%= item.getId() %>" />
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%= item.getNombre() %>" ></td>
                </tr>
              
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="<%= item.getApellido() %>" ></td>
                </tr>
              
                <tr>
                    <td>categoria</td>
                    <td><input type="radio" name="categoria" value="junior" value="<%= item.getCategoria()%>" >junior</td>
                    <td><input type="radio" name="categoria" value="semi-senior" value="<%= item.getCategoria() %>" >semi-senior</td>
                    <td><input type="radio" name="categoria" value="senior" value="<%= item.getCategoria() %>" >senior</td>
                </tr>
                
                <tr>
                    <td>Confirmado</td>
                    <td><input type="radio" name="confirmado"  value="1" value="<%= item.getConfirmado() %>"  >confirmado</td>
                    <td><input type="radio" name="confirmado"  value="0" value="<%= item.getConfirmado() %>"  >no confirmado</td>
                </tr>
                
                <tr>
                    <td>fecha de inscripcion</td>
                    <td><input type="date" name="fecha1" value="<%= item.getFecha1() %>" ></td>
                </tr>
                <tr>
                    <td><input type="submit" value="enviar"></td>
                </tr>     
            </table>      
        </form>
    </body>
</html>
