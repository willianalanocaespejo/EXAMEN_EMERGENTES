<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Vacuna"%>
<%@page import="com.emergentes.modelo.GestorVacuna"%>
<%
    if (session.getAttribute("agenda") == null)
    {
        GestorVacuna objeto1 = new GestorVacuna();
       
       
        objeto1.insertarVacuna(new Vacuna(1,"HUACHO ORTON",60,1.7 ,"Si"));
        
        session.setAttribute("agenda", objeto1);
    }

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL - Vacunas</title>
    </head>
    <body>
        <p>
        
            <H1>PRIMER PARCIAL TEM-742 <br>
                NOMBRE:WILLIAN ALANOCA ESPEJO <br>
                CEDULA:9199444 LP</H1> <br>
           
            
          
        </p>
        <h1>REGISTRO DE VACUNAS</h1>
        
        <a href="Controller?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Peso</th>
                <th>Talla</th>
                <th>Vacuna</th>               
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.agenda.getLista()}">    
            <tr>
                <th>${item.id}</th>
                <th>${item.nombre}</th>
                <th>${item.peso}</th>
                <th>${item.talla}</th>
                <th>${item.vacuna}</th>
                
                <th><a href="Controller?op=modificar&id=${item.id}">Editar</a></th>
                <th><a href="Controller?op=eliminar&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a></th>
            </tr>                           
            </c:forEach>        
        </table>
       
    </body>
</html>
