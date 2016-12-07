/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Conexion;
import Modelo.Planes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cristian Zamora
 */
public class PlanesNegocio implements PlanesInterface{

    @Override
    public ArrayList<Planes> listar( String rut) {
        Connection c = Conexion.Con();
        ArrayList<Planes> listaPlanes = new ArrayList();
        String query = "select * from planes where rut=?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Planes p = new Planes();
                p.setId(rs.getInt("id"));
                p.setRut(rs.getString("rut"));
                p.setGigas(rs.getInt("gigas"));
                p.setMinutos(rs.getInt("minutos"));
                p.setEntrega(rs.getString("entrega"));
                p.setTotal(rs.getInt("total"));
                p.setFecha(rs.getString("fecha"));
                listaPlanes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            listaPlanes=null;
        }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
                listaPlanes=null;
            }
        }
        return listaPlanes;
    }

    @Override
    public int registrar( int gigas, int minutos, int total, String rut, String entrega, String fecha) {
        Connection c = Conexion.Con();
        int afectadas=0;
        
        try {
            System.out.println(rut);
            System.out.println(gigas);
            System.out.println(minutos);
            System.out.println(total);
            System.out.println(entrega);
            System.out.println(fecha);
            PreparedStatement ps=c.prepareStatement("INSERT INTO planes(rut, gigas, minutos, total, entrega, fecha) VALUES (?,?,?,?,?,?)");
            ps.setString(1, rut);
            ps.setInt(2, gigas);
            ps.setInt(3, minutos);
            ps.setInt(4, total);
            ps.setString(5, entrega);
            ps.setString(6, fecha);
            //ResultSet rs=ps.executeQuery();
            afectadas=ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
            }
        }
        return afectadas;
    }
    
}
