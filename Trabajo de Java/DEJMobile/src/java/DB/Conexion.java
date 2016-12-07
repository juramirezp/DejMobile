/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.Conexion.Con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cristian Zamora
 */
public class Conexion {
        
    public static Connection Con(){
        String driver = "com.mysql.jdbc.Driver";
        String url ="jdbc:mysql://localhost/dejm"; //Nombre de la Base de Datos
        Connection c = null;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
        return c;
    }
}
