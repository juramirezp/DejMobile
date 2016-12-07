<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : solicitud
    Created on : 26-11-2016, 20:14:01
    Author     : Cristian Zamora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="CSS/style.css"/>
<jsp:useBean id="gigas" class="Controlador.GigasNegocio" />
<jsp:setProperty name="gigas" property="*" />
<jsp:useBean id="minutos" class="Controlador.MinutosNegocio" />
<jsp:setProperty name="minutos" property="*" />
<jsp:useBean id="usuario" scope="session" class="Modelo.Clientes" />
<jsp:setProperty name="usuario" property="*" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Solicitud</title>
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
                        <h3>Solicitud</h3>
                    </div>
                </div>
            </div>
            <div class="datos-usuario">
                Bienvenido(a) <span class="nombreUsuario"> ${usuario.nombre} ${usuario.apelidoPat} ${usuario.apellidoMat}</span> | <a href="./CerrarServlet">Cerrar Sesión</a>
            </div>
        </div>
        
        <div class="row">
            
            <div class="col s4 col offset-s4">
                
            <h4 class="col s10 offset-s1 center">Ingreso de Solicitud</h4>
            <form action="./PreviaServlet" method="POST" id="formLogin">
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Cuota de Navegación
                            <select name="gigas">
                                <c:forEach var="gigas" items="${gigas.consulta()}">
                                    <option value="${gigas.getId()}">${gigas.getCantidad()} Gigas</option>
                                </c:forEach>   
                            </select>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Cantidad de Minutos
                            <c:forEach var="minutos" items="${minutos.Consulta()}">
                                <p>
                                    <input class="with-gap" name="minutos" id="${minutos.getId()}" type="radio" checked value="${minutos.getId()}"/>
                                    <label for="${minutos.getId()}">${minutos.getCantidad()}</label>
                                  </p>
                            </c:forEach>
                          </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            
                            <p>
                                <input type="checkbox" id="ent" name="entrega" />
                                <label for="ent">Entrega del Chip en domicilio</label>
                            </p>
                          </div>
                    </div>
                        
                        
                    <div class="row">
                        <input type="submit" class="waves-effect waves-light btn col s6 offset-s3" id="paso1" value="Continuar">
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
