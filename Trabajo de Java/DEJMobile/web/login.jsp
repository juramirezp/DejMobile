
<%-- 
    Document   : login
    Created on : 26-11-2016, 18:51:24
    Author     : Cristian Zamora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="CSS/style.css"/>

<jsp:useBean id="usuario" scope="session" class="Modelo.Clientes" />
<jsp:setProperty name="usuario" property="*" />

<%
    HttpSession se = request.getSession();
    String error="";
    if(se.getAttribute("error")!=null){
        error = se.getAttribute("error").toString();
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="banner">
            <div id="menu">
                <div class="row">
                    <div class="col s2">
                        
                    </div>
                    <div class="col s5">
                        <h1>Dej Mobile</h1>
                    </div>
                    <div class="col s5">
                        
                    </div>
                </div>
            </div>
            
        </div>
        
        <div class="row">
            
            <div class="col s4 col offset-s4">
                
            <h4 class="col s10 offset-s1 center">Bienvenido</h4>
                <form action="./LoginServlet" method="POST" id="formLogin">
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Rut
                            <input id="rut" type="text" class="validate" name="rut" placeholder="Rut">
                          </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            Contraseña
                            <input id="clave" type="password" class="validate" name="clave" placeholder="Contraseña">
                            
                          </div>
                    </div>
                    <div class="row">
                        <div class="col s6 offset-s3 center">
                        <input type="button" class="waves-effect waves-light btn " id="btnLogin" value="Ingresar">
                        </div>
                    </div>
                    <div class="row">
                        <a href="registro.jsp" class="col s6 offset-s3 center">Registrate</a>
                    </div>
                    <%
                        if(error.equals("1")){
                            out.println("<blockquote>La información ingresada es incorrecta. Favor verificar.</blockquote> ");
                        }
                    %>
                      
                </form>
            </div>
        </div>
        <script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
        <script>
        $(document).ready(function(){
   $('#btnLogin').click(function(){
            var ok=0;
      
            var rut=$('input[name="rut"]').val();
            var pass=$('input[name="clave"]').val();
            if(rut.length<1){
                $('input[name="rut"]').css('border-color','red');
            }else{
                $('input[name="rut"]').css('border-color','green');
                ok++;
            }
            
            if(pass.length<1){
                $('input[name="clave"]').css('border-color','red');
            }else{
                $('input[name="clave"]').css('border-color','green');
                ok++;
            }
            
            if(ok===2){
                $('#formLogin').submit();
            }
       }); 
});


            </script>
    </body>
</html>
