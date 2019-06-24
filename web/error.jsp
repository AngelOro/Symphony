<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="misEstilos.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error en la Aplicación</title>
    </head>
    <body>
        <h1 >Ufff que pena no sirves para programar</h1>
        
        
        <%
            String mensage = (String) request.getAttribute("mensage");
            if (mensage != null) {
                out.print("El mensaje de error es: ");
                out.print(mensage + "<br/>" );
            }
            String trazaPila = (String) request.getAttribute("trazaPila");
            if (trazaPila != null) {
                out.print("La traza de la pila es: " + "<br/>");
                out.print(trazaPila);
            }
        %>


    <center>
    </center>
   
</body>
</html>
