/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Gigas;
import java.util.ArrayList;

/**
 *
 * @author Cristian Zamora
 */
public interface GigasInterface {
    public ArrayList<Gigas> consulta();
    public Gigas BuscarGigas(int id);
}
