/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appgym.controller;

import com.mycompany.appgym.model.ClienteModel;
import com.mycompany.appgym.view.ClienteView;
import javax.swing.JOptionPane;

/**
 *
 * @author JJAB
 */
public class Validacion extends Tabla {

    ClienteView clienteView;

    public Validacion(ClienteView clienteView) {
        super(clienteView);
        this.clienteView = clienteView;
    }

    protected boolean CamposVacios() {
        return !clienteView.getTxtCedula().getText().trim().isEmpty() && !clienteView.getTxtNombres().getText().trim().isEmpty()
                && !clienteView.getTxtApellido().getText().trim().isEmpty() && !clienteView.getTxtTelefono().getText().trim().isEmpty()
                && !clienteView.getTxtCorreo().getText().trim().isEmpty();
    }

    /*
     * Validacion Telefono
     * Los numeros de celular inician con 09
     * expresion regular que permite numeros de 0 hasta el 9
     * longitud de 10 numeros que corresponden a un numero de celular
     */
    protected boolean validarTelefono() {
        String telefono = clienteView.getTxtTelefono().getText().trim();

        if (telefono.matches("[0-9]+") && telefono.length() == 10) {

            if ("09".equals(telefono.substring(0, 2))) {
                return true;
            }
        }
        return false;
    }

    /*
     * Validacion Cedula
     * con expresion regular que permite numeros de 0 hasta el 9
     * longitud de 10 numeros que corresponden a una cedula
     */
    protected boolean validarCedula() {
        return clienteView.getTxtCedula().getText().matches("[0-9]+")
                && clienteView.getTxtCedula().getText().length() == 10;
    }

    /*
     * Validacion de correo electronico
     * con expresion regular
     * comprueba que la dirección de correo electrónico tenga un usuario
     * (parte antes de @), un dominio (parte después de @),
     * y un dominio de nivel superior (TLD) válido (como .com, .org, .es, etc.
     */
    protected boolean validarCorreo() {
        return clienteView.getTxtCorreo().getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:\\.[a-zA-Z]{2,})?$");
    }

    public boolean validarFechas() {
        return clienteView.getFechaIngreso().getDate() != null && clienteView.getFechaSalida().getDate() != null;
    }

    protected void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(clienteView, mensaje, "", JOptionPane.WARNING_MESSAGE);
    }

    
    protected void mensajeOK(String mensaje) {
        JOptionPane.showMessageDialog(clienteView, mensaje, "", JOptionPane.WARNING_MESSAGE);
    }

}
