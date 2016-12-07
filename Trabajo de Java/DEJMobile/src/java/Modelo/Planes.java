/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Cristian Zamora
 */
public class Planes {
    private int id, gigas, minutos, total;
    private String rut;
    private String entrega;
    private String fecha;

    public Planes() {
    }

    public Planes(int id, int gigas, int minutos, int total, String rut, String entrega, String fecha) {
        this.id = id;
        this.gigas = gigas;
        this.minutos = minutos;
        this.total = total;
        this.rut = rut;
        this.entrega = entrega;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGigas() {
        return gigas;
    }

    public void setGigas(int gigas) {
        this.gigas = gigas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
