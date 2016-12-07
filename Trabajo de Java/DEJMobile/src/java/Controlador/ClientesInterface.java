/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clientes;

/**
 *
 * @author Cristian Zamora
 */
public interface ClientesInterface {
    public Clientes Validar(String rut, String pass);
    public int Registrar(String rut, String pass,String nombre, String apellidoPat, String apellidoMat, String direccion, int numeracion, int comuna, int telefono);
}
