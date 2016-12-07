
<%-- 
    Document   : planes
    Created on : 02-12-2016, 19:13:33
    Author     : juramirezp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="CSS/style.css"/>

<jsp:useBean id="planes" class="Modelo.Planes" />
<jsp:setProperty name="planes" property="*" />
<jsp:useBean id="pl" class="Controlador.PlanesNegocio" />

<jsp:useBean id="usuario" scope="session" class="Modelo.Clientes" />
<jsp:setProperty name="usuario" property="*" />

<jsp:useBean id="comunas" class="Modelo.Comunas" />
<jsp:setProperty name="comunas" property="*" />
<jsp:useBean id="com" class="Controlador.ComunasNegocio" />

<jsp:useBean id="gigas" class="Modelo.Gigas" />
<jsp:setProperty name="gigas" property="*" />
<jsp:useBean id="gi" class="Controlador.GigasNegocio" />

<jsp:useBean id="minutos" class="Modelo.Minutos" />
<jsp:setProperty name="minutos" property="*" />
<jsp:useBean id="min" class="Controlador.MinutosNegocio" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planes</title>
    </head>
    <body>
        <c:if test="${usuario.nombre==null}" var="ses">
            <script>
                window.location.href = "./login.jsp";
            </script>
        </c:if>
        <div class="banner">
            <div id="menu">
                <div class="row">
                    <div class="col s2">
                        <a href="./menu.jsp">
                            <i class="material-icons">keyboard_arrow_left</i>
                        </a>
                    </div>
                    <div class="col s5">
                        <h1>Dej Mobile</h1>
                    </div>
                    <div class="col s5">
                        <h3>Planes</h3>
                    </div>
                </div>
            </div>
            <div class="datos-usuario">
                Bienvenido(a) <span class="nombreUsuario"> ${usuario.nombre} ${usuario.apelidoPat} ${usuario.apellidoMat}</span> | <a href="./CerrarServlet">Cerrar Sesión</a>
            </div>
        </div>
        <div class="row">
            <h4 class="col s10 offset-s1 center">Planes Registrados</h4>
            <div class="col s8 col offset-s2">
        <table border="1" class="striped">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Gigas</th>
                    <th>Minutos</th>
                    <th>Entrega de Chip</th>
                    <th>Teléfono</th>
                    <th>Comuna</th>
                    <th>Ingreso</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="planes" items="${pl.listar(usuario.rut)}">
                    <tr>
                        <td>${planes.id}</td>
                        <td>${gi.BuscarGigas(planes.gigas).cantidad}</td>
                        <td>${min.BuscarMinutos(planes.minutos).cantidad}</td>
                        <td>${planes.entrega}</td>
                        <td>${usuario.telefono}</td>
                        <td>${com.Buscar(usuario.comuna).nombre}</td>
                        <td>${planes.fecha}</td>
                        <td>$${planes.total}</td>
                    </tr>
                </c:forEach>
                    
            </tbody>
        </table>
                </div></div>
        <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
        <script src="JS/script.js"></script>
    </body>
</html>
