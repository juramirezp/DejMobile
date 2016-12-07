/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Conexion;
import Modelo.Minutos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cristian Zamora
 */
public class MinutosNegocio implements MinutosInterface {

    @Override
    public ArrayList<Minutos> Consulta() {
        Connection c = Conexion.Con();
        ArrayList<Minutos> listaMinutos = new ArrayList();
        String query = "select * from minutos";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Minutos m = new Minutos();
                m.setId(rs.getInt("id"));
                m.setCantidad(rs.getInt("cantidad"));
                m.setPrecio(rs.getInt("precio"));                
                listaMinutos.add(m);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            listaMinutos=null;
        }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
                listaMinutos=null;
            }
        }
        return listaMinutos;
    }
    
    @Override
    public Minutos BuscarMinutos(int id){
        Connection c = Conexion.Con();
        Minutos m=new Minutos();
        String query = "select * from minutos where id=?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                m.setId(rs.getInt("id"));
                m.setCantidad(rs.getInt("cantidad"));
                m.setPrecio(rs.getInt("precio"));                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            m=null;
        }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
                m=null;
            }
        }
        return m;
    }
    
}
