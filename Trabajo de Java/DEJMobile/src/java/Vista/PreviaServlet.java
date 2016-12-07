/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GigasNegocio;
import Controlador.MinutosNegocio;
import Modelo.Clientes;
import Modelo.Gigas;
import Modelo.Minutos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juramirezp
 */
public class PreviaServlet extends HttpServlet {

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
        
        int minutos = Integer.parseInt(request.getParameter("minutos"));
        int gigas = Integer.parseInt(request.getParameter("gigas"));
        String entrega= request.getParameter("entrega");
        
        
            try {
                MinutosNegocio min=new MinutosNegocio();
                Minutos m=min.BuscarMinutos(minutos);
                
                GigasNegocio gig=new GigasNegocio();
                Gigas g=gig.BuscarGigas(gigas);
                
                int total=g.getPrecio()+m.getPrecio();
                
                if(total>0){
                    request.getSession().setAttribute("minutos", m);
                    request.getSession().setAttribute("gigas", g);
                    request.getSession().setAttribute("total", total);
                    if(entrega!=null){
                        request.getSession().setAttribute("entrega", true);
                    }else{
                        request.getSession().setAttribute("entrega", false);
                    }
                    request.getRequestDispatcher("/detalle.jsp").forward(request, response);
                }
                else {
                    request.setAttribute("Error", "Error en los datos Ingresados");
                    System.out.println("error if");
                    request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("Error", "Error Desconocido");
                System.out.println("error try");
                request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
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
