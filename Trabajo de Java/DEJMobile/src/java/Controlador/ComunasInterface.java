/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comunas;
import java.util.ArrayList;

/**
 *
 * @author Cristian Zamora
 */
public interface ComunasInterface {
    public ArrayList<Comunas> listaComunas();
    public Comunas Buscar(int id);
}
