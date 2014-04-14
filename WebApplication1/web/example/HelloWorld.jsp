<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title><s:text name="HelloWorld.message"/></title>
    </head>

    <body>
        <form action="" method="post">
            <center>
                <br><h3>Agregar Contacto </h3>
                Nombre
                <input type="text" name="nombre" size="20">
                <br>Direccion IP
                <input type="text" name="ip" size="20">
                <br>Puerto
                <input type="text" name="puerto" size="20">
                <br><input type="button" name="envio" value="Enviar">
            </center>
        </form>
    </body>
</html>

