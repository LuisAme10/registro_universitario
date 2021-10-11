<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Universitario"%>
<%
    ArrayList<Universitario> lista = (ArrayList<Universitario>) session.getAttribute("listuni");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Universitarios</h1>
        <a href="MainController?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Categoria</td>
                <td>confirmado</td>
                <td>fecha de inscripcion</td>
                <td></td>
                <td></td>

            </tr>
            <%
                if (lista != null) {
                    for (Universitario item : lista) {

            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getNombre() %></td>
                <td><%= item.getApellido() %></td>
                <td><%= item.getCategoria() %></td>
                <% if(item.getConfirmado()==1)
                     {
                    %>
                    <td><input type="checkbox" checked></td>
                    <%}else{
                        %>
                    <td><input type="checkbox" ></td>
                    <%
                        }
                        %>
                <td><%= item.getFecha1() %></td>
                <td><a href="MainController?op=editar&id=<%= item.getId() %>">Modificar</a> </td>
                <td><a  href="MainController?op=eliminar&id=<%= item.getId() %>"
                        onclick='return confirm("esta seguro de eliminar este registro ?"); ' >Eliminar</a></td>
            </tr>
            <%     }
                }
            %>
        </table>
    </body>
</html>
