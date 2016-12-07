/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ClientesNegocio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author juramirezp
 */
public class RegistroServlet extends HttpServlet {

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
        
        String rut = request.getParameter("rut");
        String pass = request.getParameter("pass");
        String nombre = request.getParameter("nombre");
        String apellidoPat = request.getParameter("apellidoPat");
        String apellidoMat = request.getParameter("apellidoMat");
        String direccion = request.getParameter("direccion");
        String numeracion = request.getParameter("numeracion");
        int comuna = Integer.parseInt(request.getParameter("comuna"));
        String telefono = request.getParameter("telefono");
        //Encriptacion de la contraseña
        String passE=DigestUtils.md5Hex(pass);
        System.out.println("pass normal: "+pass);
        System.out.println("pass Encrip: "+passE);
    
            try {
                ClientesNegocio c=new ClientesNegocio();
                int afectadas =c.Registrar(rut, passE, nombre, apellidoPat, apellidoMat, direccion, Integer.parseInt(numeracion), comuna, Integer.parseInt(telefono));
                if(afectadas>0){
                    request.getSession().setAttribute("registro", 1);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
                else {
                    request.setAttribute("Error", "Error en los datos Ingresados");
                    System.out.println("error2");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("Error", "Error Desconocido");
                System.out.println("error3");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
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
