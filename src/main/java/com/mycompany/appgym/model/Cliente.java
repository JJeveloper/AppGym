/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appgym.model;

import java.io.Serializable;

/**
 *
 * @author JJAB
 */
public class Cliente implements Serializable {

    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String fechaIngreso;
    private String fechaSalida;

    public String getCedula() {
        return cedula;
    }

    public Cliente setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Cliente setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public Cliente setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public Cliente setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public Cliente setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public Cliente setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        return this.cedula.equals(((Cliente) o).cedula);
    }

    @Override
    public int hashCode() {
        return cedula.hashCode();
    }

}
