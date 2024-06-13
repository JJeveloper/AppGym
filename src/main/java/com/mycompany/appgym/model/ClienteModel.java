/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appgym.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JJAB
 */
public class ClienteModel implements Model {

    private String data;
    private List<Cliente> clientes;

    public ClienteModel() {
        clientes = new ArrayList<>();
        data = "data.txt";
    }

    @Override
    public List<Cliente> obtenerClientes() {
        List<Cliente> list = new ArrayList<>(clientes);
        return list;
    }

    @Override
    public boolean guardarClientes(Cliente c) {
        if (clientes.contains(c)) {
            return false;
        }
        clientes.add(c);
        return true;
    }

    @Override
    public boolean editarCliente(Cliente c) {
        int index = clientes.indexOf(c);
        if (index < 0) {
            return false;
        }
        clientes.set(index, c);
        return true;
    }

    @Override
    public boolean eliminarCliente(Cliente c) {
        int index = clientes.indexOf(c);
        if (index < 0) {
            return false;
        }
        clientes.remove(index);
        return true;
    }

    /**
     * Almacena los datos en disco
     */
    public void almacenar() {
        try {
            FileOutputStream fos = new FileOutputStream(data);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            oos.close();
            System.out.println("Datos guardados con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los datos almacenados en disco
     *
     * @return este objeto
     */
    public ClienteModel cargar() {
        try {
            FileInputStream fis = new FileInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(fis);
            clientes = (ArrayList<Cliente>) ois.readObject();
            ois.close();
            System.out.println("Datos cargados con exito");
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero de datos");
        } catch (IOException e) {
            System.err.println("Error de entrada / salida al cargar datos");
        } catch (ClassNotFoundException e) {
            System.err.println("El fichero no contiene datos correctos");
        }

        return this;
    }

}
