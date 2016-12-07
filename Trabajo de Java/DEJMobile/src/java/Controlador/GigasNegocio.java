package Controlador;

import DB.Conexion;
import Modelo.Gigas;
import Modelo.Minutos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian Zamora
 */
public class GigasNegocio implements GigasInterface{

    @Override
    public ArrayList<Gigas> consulta() {
        Connection c = Conexion.Con();
        ArrayList<Gigas> listaGigas = new ArrayList();
        String query = "select * from gigas";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Gigas g = new Gigas();
                g.setId(rs.getInt("id"));
                g.setCantidad(rs.getInt("cantidad"));
                g.setPrecio(rs.getInt("precio"));                
                listaGigas.add(g);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            listaGigas=null;
        }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
                listaGigas=null;
            }
        }
        return listaGigas;
    }
    
    @Override
    public Gigas BuscarGigas(int id){
        Connection c = Conexion.Con();
        String query = "select * from gigas where id=?";
        Gigas g = new Gigas();
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                g.setId(rs.getInt("id"));
                g.setCantidad(rs.getInt("cantidad"));
                g.setPrecio(rs.getInt("precio"));                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            g=null;
        }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
                g=null;
            }
        }
        return g;
    }
}
