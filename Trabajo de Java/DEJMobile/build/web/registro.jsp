<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : registro
    Created on : 26-11-2016, 18:59:58
    Author     : Cristian Zamora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="CSS/style.css"/>

<jsp:useBean id="comunas" class="Controlador.ComunasNegocio" />
<jsp:setProperty name="comunas" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
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
                        <h3>Registro</h3>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <form action="./RegistroServlet" id="form-registro">
            <h4 class="col s10 offset-s1 center">Formulario de Registro</h4>
            
            <div class="col s4 col offset-s2">
                
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Rut
                            <input id="rut" type="text" class="validate" name="rut" placeholder="Rut">
                            <span class="msjInput">Formato: xxxxxxxx-x</span>
                          </div>
                    </div>   
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Nombre
                            <input id="nombre" type="text" class="validate" name="nombre" placeholder="Nombre">
                          </div>
                    </div>     
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Apellido Paterno
                            <input id="apellidoPat" type="text" class="validate" name="apellidoPat" placeholder="Apellido Paterno">
                          </div>
                    </div>  
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Apellido Materno
                            <input id="apellidoMat" type="text" class="validate" name="apellidoMat" placeholder="Apellido Materno">
                          </div>
                    </div>  
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Teléfono
                            <input id="telefono" type="number" class="validate" name="telefono" placeholder="Teléfono">
                            <span class="msjInput">8 digitos</span>
                          </div>
                    </div>  
                
            </div>
            
            
            <div class="col s4 ">
                
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Contraseña
                            <input id="pass" type="password" class="validate" name="pass" placeholder="Contraseña">
                            <span class="msjInput">Min. 5 caracteres</span>
                          </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Confirmar Contraseña
                            <input id="pass2" type="password" class="validate" name="pass2" placeholder="Confirmar Contraseña">
                          </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Dirección
                            <input id="pass2" type="text" class="validate" name="direccion" placeholder="Dirección">
                          </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Numeración
                            <input id="numeracion" type="number" class="validate" name="numeracion" placeholder="Numeración">
                          </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Comuna
                            <select name="comuna">
                                <c:forEach var="comunas" items="${comunas.listaComunas()}">
                                    <option value="${comunas.getId()}">${comunas.getNombre()}</option>
                                </c:forEach>    
                            </select>
                        </div>
                    </div>
                
                
                
            </div>
                <div class="row">
                    <div class=" col s4 offset-s4 center">
                        <input type="button" class="waves-effect waves-light btn" id="registrar" value="Enviar">
                    </div>  
                </div>
            </form>
                    
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
        </script>
        
        
    </body>
</html>
