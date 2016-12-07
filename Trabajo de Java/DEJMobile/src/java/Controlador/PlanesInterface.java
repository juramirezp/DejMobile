/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Planes;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cristian Zamora
 */
public interface PlanesInterface {
    public ArrayList<Planes> listar(String rut);
    public int registrar( int gigas, int minutos, int total, String rut, String entrega, String fecha);
}
