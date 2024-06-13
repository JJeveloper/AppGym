/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appgym.model;

import java.util.List;

/**
 *
 * @author JJAB
 */
public interface  Model {

    public abstract boolean guardarClientes(Cliente c);

    public abstract List<Cliente> obtenerClientes();

    public abstract boolean editarCliente(Cliente c);

    public abstract boolean eliminarCliente(Cliente c);

}
