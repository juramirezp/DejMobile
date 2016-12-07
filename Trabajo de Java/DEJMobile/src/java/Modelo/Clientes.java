/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Cristian Zamora
 */
public class Clientes {
    private int numeracion, telefono, comuna;
    private String rut, clave, nombre, apelidoPat, apellidoMat, direccion;

    public Clientes(int numeracion, int telefono, String rut, String clave, String nombre, String apelidoPat, String apellidoMat, String direccion, int comuna) {
        this.numeracion = numeracion;
        this.telefono = telefono;
        this.rut = rut;
        this.clave = clave;
        this.nombre = nombre;
        this.apelidoPat = apelidoPat;
        this.apellidoMat = apellidoMat;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    public Clientes() {
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelidoPat() {
        return apelidoPat;
    }

    public void setApelidoPat(String apelidoPat) {
        this.apelidoPat = apelidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

    @Override
    public String toString() {
        return "Clientes{" + "numeracion=" + numeracion + ", telefono=" + telefono + ", rut=" + rut + ", clave=" + clave + ", nombre=" + nombre + ", apelidoPat=" + apelidoPat + ", apellidoMat=" + apellidoMat + ", direccion=" + direccion + ", comuna=" + comuna + '}';
    }
    
    
}
