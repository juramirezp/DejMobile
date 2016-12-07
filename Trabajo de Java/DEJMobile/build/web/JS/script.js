/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    
    $('select').material_select();
    
   $('#registrar').click(function(){
      var ok=0;
      
      var rut=$('input[name="rut"]').val();
      var pass=$('input[name="pass"]').val();
      var pass2=$('input[name="pass2"]').val();
      var nombre=$('input[name="nombre"]').val();
      var apellidoPat=$('input[name="apellidoPat"]').val();
      var apellidoMat=$('input[name="apellidoMat"]').val();
      var direccion=$('input[name="direccion"]').val();
      var numeracion=$('input[name="numeracion"]').val();
      var telefono=$('input[name="telefono"]').val();
      
      if(Fn.validaRut(rut)){
            ok++;
            $('input[name="rut"]').css('border-color','green');   
      }else{
            $('input[name="rut"]').css('border-color','red');   
      }
      
      if(pass.length>5 && pass===pass2){
          ok++;
            $('input[name="pass"]').css('border-color','green');  
            $('input[name="pass2"]').css('border-color','green');  
      }else{
          $('input[name="pass"]').css('border-color','red');  
            $('input[name="pass2"]').css('border-color','red'); 
      }
      
      if(nombre.length>1){
            ok++;
            $('input[name="nombre"]').css('border-color','green');   
      }else{
            $('input[name="nombre"]').css('border-color','red');   
      }
      
      if(apellidoPat.length>1){
            ok++;
            $('input[name="apellidoPat"]').css('border-color','green');   
      }else{
            $('input[name="apellidoPat"]').css('border-color','red');   
      }
      
      if(apellidoMat.length>1){
            ok++;
            $('input[name="apellidoMat"]').css('border-color','green');   
      }else{
            $('input[name="apellidoMat"]').css('border-color','red');   
      }
      
      if(direccion.length>0){
            ok++;
            $('input[name="direccion"]').css('border-color','green');   
      }else{
            $('input[name="direccion"]').css('border-color','red');   
      }
      
      if(numeracion>0){
            ok++;
            $('input[name="numeracion"]').css('border-color','green');   
      }else{
            $('input[name="numeracion"]').css('border-color','red');   
      }
      
      if(telefono>9999999 && telefono<100000000){
            ok++;
            $('input[name="telefono"]').css('border-color','green');   
      }else{
            $('input[name="telefono"]').css('border-color','red');
      }
      console.log("cantidad de oks: "+ok);
      
      
      if(ok===8){
          $('#form-registro').submit();
      }
   });
   
   
   
   
   
  var Fn = {
            // Valida el rut con su cadena completa "XXXXXXXX-X"
            validaRut : function (rutCompleto) {
                    if (!/^[0-9]+-[0-9kK]{1}$/.test( rutCompleto ))
                            return false;
                    var tmp 	= rutCompleto.split('-');
                    var digv	= tmp[1]; 
                    var rut 	= tmp[0];
                    if ( digv == 'K' ) digv = 'k' ;
                    return (Fn.dv(rut) == digv );
            },
            dv : function(T){
                    var M=0,S=1;
                    for(;T;T=Math.floor(T/10))
                            S=(S+T%10*(9-M++%6))%11;
                    return S?S-1:'k';
            }
        }
        
        $('.volver').click(function(){
           window.history.back() 
        });
        
    
});


