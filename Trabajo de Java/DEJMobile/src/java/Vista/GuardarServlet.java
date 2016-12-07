/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PlanesNegocio;
import Modelo.Clientes;
import Modelo.Gigas;
import Modelo.Minutos;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juramirezp
 */
public class GuardarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession se = request.getSession();
        int total = Integer.parseInt(request.getSession().getAttribute("total").toString());
        String entrega = request.getSession().getAttribute("entrega").toString();
        Minutos m=(Minutos) se.getAttribute("minutos");
        Gigas g=(Gigas) se.getAttribute("gigas");
        System.out.println("basee--------------f,ñsdfñsdfñ");
        Clientes c=(Clientes) se.getAttribute("usuario");
        System.out.println("base2222");
        System.out.println(entrega);
        System.out.println(m.getCantidad());
        System.out.println(g.getCantidad());
        System.out.println(c.getDireccion());
        if(entrega.equals("true")){
            entrega=c.getDireccion()+" #"+c.getNumeracion();
            System.out.println("base3");
        }else{
            entrega="Retiro en Sucursal";
            System.out.println("base4");
        }
        Date fechaActual = new Date();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("dd-mm-yyyy");
        String fecha=formatoFecha.format(fechaActual)+" "+formatoHora.format(fechaActual);
        System.out.println(fecha);
        try{
            PlanesNegocio pn=new PlanesNegocio();
            int afectadas=pn.registrar(g.getId(), m.getId(), total, c.getRut(), entrega, fecha);
            if(afectadas>0){
                request.getRequestDispatcher("/planes.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/detalle.jsp").forward(request, response);
            }
        }catch (Exception e) {
            request.setAttribute("Error", "Error Desconocido");
            System.out.println("error try");
            request.getRequestDispatcher("/detalle.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
