/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Conexion;
import Modelo.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cristian Zamora
 */
public class ClientesNegocio implements ClientesInterface {

    @Override
    public Clientes Validar(String rut, String pass) {
        Connection c = Conexion.Con();
        Clientes cli = cli=new Clientes();
        String query = "select * from clientes where rut = ? and clave = ?";
        try {
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, rut);
            ps.setString(2, pass);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                cli.setRut(rs.getString("rut"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApelidoPat(rs.getString("apellidoPat"));
                cli.setApellidoMat(rs.getString("apellidoMat"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setNumeracion(rs.getInt("numeracion"));
                cli.setComuna(rs.getInt("comuna"));
                cli.setTelefono(rs.getInt("telefono"));
                cli.setClave(rs.getString("clave"));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            cli = null;
        }
        finally{
            try {
                c.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex);
                cli = null;
            }
        }
        return cli;
    }

    @Override
    public int Registrar(String rut, String pass, String nombre, String apellidoPat, String apellidoMat, String direccion, int numeracion, int comuna, int telefono) {
        Connection c = Conexion.Con();
        int afectadas=0;
        try {
            PreparedStatement ps=c.prepareStatement("INSERT INTO clientes(rut, nombre, apellidoPat, apellidoMat, direccion, numeracion, comuna, telefono, clave) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, rut);
            ps.setString(2, nombre);
            ps.setString(3, apellidoPat);
            ps.setString(4, apellidoMat);
            ps.setString(5, direccion);
            ps.setInt(6, numeracion);
            ps.setInt(7, comuna);
            ps.setInt(8, telefono);
            ps.setString(9, pass);
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
