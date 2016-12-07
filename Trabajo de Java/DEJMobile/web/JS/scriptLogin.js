/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
   $('#btnLogin').click(function(){
            var ok=0;
      
            var rut=$('input[name="rut"]').val();
            var pass=$('input[name="clave"]').val();
            alert(ok);
            console.log("cantidad de oks: "+ok);
            if(rut.length<1){
                $('input[name="rut"]').css('border-color','red');
            }else{
                $('input[name="rut"]').css('border-color','green');
                ok++;
                console.log("login :"+ok);
            }
            
            if(pass.length<1){
                $('input[name="clave"]').css('border-color','red');
            }else{
                $('input[name="clave"]').css('border-color','green');
                ok++;
                console.log("login :"+ok);
            }
            
            console.log("login :"+ok);
            
            if(ok===2){
                $('#formLogin').submit();
            }
       }); 
});

