
<%-- 
    Document   : menu
    Created on : 26-11-2016, 20:12:26
    Author     : Cristian Zamora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="CSS/style.css"/>
<jsp:useBean id="usuario" scope="session" class="Modelo.Clientes" />
<jsp:setProperty name="usuario" property="*" />



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú</title>
    </head>
    <c:if test="${usuario.nombre==null}" var="ses">
        <script>
            window.location.href = "./login.jsp";
        </script>
    </c:if>
    <body>
        <div class="banner">
            <div id="menu">
                <div class="row">
                    <div class="col s2">
                        <i class="material-icons volver">keyboard_arrow_left</i>
                    </div>
                    <div class="col s5">
                        <h1>Dej Mobile</h1>
                    </div>
                    <div class="col s5">
                        <h3>Menú</h3>
                    </div>
                </div>
            </div>
            
            <div class="datos-usuario">
                Bienvenido(a) <span class="nombreUsuario"> ${usuario.nombre} ${usuario.apelidoPat} ${usuario.apellidoMat}</span> | <a href="./CerrarServlet">Cerrar Sesión</a>
            </div>
        </div>
        
        <div class="row opciones-menu">
            <div class="col s2 offset-s4 center">
                <a href="solicitud.jsp">
                    <div class="row">
                        <i class="material-icons teal-text text-darken-4">add</i>
                    </div>
                    <div class="row">
                        <h5 class="teal-text text-darken-4">Solicitar Nuevo Plan</h5>
                    </div>
                </a>
            </div>
            <div class="col s2 center">
                <a href="planes.jsp">
                    <div class="row">
                        <i class="material-icons teal-text text-darken-4">sort</i>
                    </div>
                    <div class="row">
                        <h5 class="teal-text text-darken-4">Ver Planes Vigentes</h5>
                    </div>
                </a>
            </div>
        </div>
        
        <script  src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
            integrity="sha256-/SIrNqv8h6QGKDuNoLGA4iret+kyesCkHGzVUUV0shc="
            crossorigin="anonymous"></script>
        <script src="JS/script.js"></script>
    </body>
</html>
