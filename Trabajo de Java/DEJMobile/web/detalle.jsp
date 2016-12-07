
<%-- 
    Document   : detalle
    Created on : 02-12-2016, 13:08:24
    Author     : juramirezp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="CSS/style.css"/>
<jsp:useBean id="minutos" scope="session" class="Modelo.Minutos" />
<jsp:setProperty name="minutos" property="*"/>
<jsp:useBean id="usuario" scope="session" class="Modelo.Clientes" />
<jsp:setProperty name="usuario" property="*" />
<jsp:useBean id="gig" scope="session" class="Modelo.Gigas" />
<jsp:setProperty name="gigas" property="*" />

<%
    HttpSession se = request.getSession();
    String total = se.getAttribute("total").toString();
    String entrega = se.getAttribute("entrega").toString();
    if(entrega.equals("true")){
        entrega="Entrega del Chip en Domicilio";
    }else{
        entrega="Entrega del Chip en Sucursal";
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle de Solicitud</title>
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
                        <i class="material-icons volver">keyboard_arrow_left</i>
                    </div>
                    <div class="col s5">
                        <h1>Dej Mobile</h1>
                    </div>
                    <div class="col s5">
                        <h3>Detalle</h3>
                    </div>
                </div>
            </div>
            <div class="datos-usuario">
                Bienvenido(a) <span class="nombreUsuario"> ${usuario.nombre} ${usuario.apelidoPat} ${usuario.apellidoMat}</span> | <a href="./CerrarServlet">Cerrar Sesión</a>
            </div>
        </div>
            
            <div class="row">
            
            <div class="col s4 col offset-s4">
                
            <h4 class="col s10 offset-s1 center">Detalles de la Solicitud</h4>
            <form action="./GuardarServlet" method="POST">
                <div class="col s6 offset-s3">
                <table class="striped" id="tablaDetalles" align="center" style="padding-top:3em;">
                    
                    <tr>
                        <td><span class="detalle1">${gigas.cantidad} Gigas</span></td>
                    </tr>
                    <tr>
                        <td><span class="detalle1">${minutos.cantidad} Minutos</span></td>
                    </tr>
                    <tr>
                        <td><span class="detalle1"><%=entrega%></span></td>
                    </tr>
                    <tr>
                        <td><span class="detalle2">Total: $<%=total%> Mensuales</span></td>
                    </tr>
                    
                </table>
                        </div>
                    
                    <div class="row">
                        <div class="col s10 offset-s1" style="margin-top:3em;">
                        <input type="submit" class="waves-effect waves-light btn col s6 offset-s3" id="paso1" value="Solicitar Plan">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
        <script src="JS/script.js"></script>
        <script>
            $(document).ready(function() {
                $('select').material_select();
              });
              function goBack() {
                window.history.back();
            }
        </script>
    </body>
</html>
