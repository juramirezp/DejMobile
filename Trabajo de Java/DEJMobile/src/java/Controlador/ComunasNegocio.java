/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Conexion;
import Modelo.Comunas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cristian Zamora
 */
public class ComunasNegocio implements ComunasInterface{

    @Override
    public ArrayList<Comunas> listaComunas() {
        Connection c = Conexion.Con();
        ArrayList<Comunas> listaComunas = new ArrayList();
        try {
            PreparedStatement ps = c.prepareStatement("select * from comunas");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Comunas com = new Comunas();
                com.setId(rs.getInt("id"));
                com.setNombre(rs.getString("nombre"));
                listaComunas.add(com);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            listaComunas=null;
       }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
                listaComunas=null;
            }
        }
      return listaComunas;
    }
    
    @Override
    public Comunas Buscar(int id){
        Connection c = Conexion.Con();
        Comunas com = new Comunas();
        try {
            PreparedStatement ps = c.prepareStatement("select * from comunas where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                com.setId(rs.getInt("id"));
                com.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            com=null;
       }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
                com=null;
            }
        }
      return com;
    }
}
