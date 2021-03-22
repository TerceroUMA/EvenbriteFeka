<%-- 
    Document   : Registrarse
    Created on : 20-mar-2021, 19:27:50
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link href="./styles/forms.css" rel="stylesheet">
        <title> EvenbriteFeka </title>
        <link rel="icon" type="image/png" href="https://cdn.evbstatic.com/s3-build/perm_001/8a4e23/django/images/favicons/favicon-32x32.png" sizes="32x32">
        <link rel="icon" type="image/png" href="https://cdn.evbstatic.com/s3-build/perm_001/477279/django/images/favicons/favicon-194x194.png" sizes="194x194">
    </head>
    
    <%
        boolean registroCompletado = false;
        String mensaje = "";
        mensaje = (String) session.getAttribute("mensajeRegistro");
        if (mensaje != null) {
            registroCompletado = mensaje.equals("Has sido registrado con éxito!!!");    
            mensaje = "";
        }
        String manolo = "";
    %>
    
    <body style="height: 100%">
        <center>
            <h1 class="<%= registroCompletado ? "title" : "hidden title" %>"> <%= mensaje %> </h1>
        </center>
        
        <form action="ServletRegistrarse" method="POST" class="d-flex flex-column flex-wrap align-items-center justify-content-center" style="height: 100%">
            
            <input type="text" name="nombre" class="form-control size" placeholder="Nombre">

            <input type="text" name="primerApellido" class="form-control size" placeholder="Primer apellido">

            <input type="text" name="segundoApellido" class="form-control size" placeholder="Segundo apellido">

            <input type="text" name="domicilio" class="form-control size" placeholder="Domicilio">

            <input type="text" name="ciudad" class="form-control size" placeholder="Ciudad de residencia">

            <input type="number" name="edad" class="form-control size" placeholder="Edad">

            <select name="sexo" class="form-select size" aria-label="Default select example">
                <option selected>Elige tu sexo</option>
                <option value="hombre">Hombre</option>
                <option value="mujer">Mujer</option>
                <option value="otro">Otro</option>
            </select>
            
            <input type="email" name="correo" class="form-control size" placeholder="Correo">

            <input type="password" name="password" class="form-control size" placeholder="Contraseña">
            
            <input type="password" name="confPassword" class="form-control size" placeholder="Confirmar contraseña">
            
            <input class="btn btn-primary" type="submit">
            
        </form>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
