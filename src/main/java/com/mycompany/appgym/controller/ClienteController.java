/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appgym.controller;

import com.mycompany.appgym.model.Cliente;
import com.mycompany.appgym.model.ClienteModel;
import com.mycompany.appgym.view.ClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JJAB
 */
public class ClienteController extends Validacion implements ActionListener {

    ClienteView clienteView;
    ClienteModel clienteModel;
    DefaultTableModel tableModel;
    List<Cliente> clientesList;

    public ClienteController(ClienteView clienteView, ClienteModel clienteModel) {
        super(clienteView);
        this.clienteView = clienteView;
        this.clienteModel = clienteModel;

        agregarEventos();

        //Clase Tabla
        creartabla(clienteModel);
        //Clase Tabla
        seleccionarllenarCampos();

        clienteView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                clienteModel.almacenar();
                System.out.println("close,close,close");
                System.exit(0);
            }
        });

    }

    private void agregarEventos() {
        clienteView.getBtnNuevo().addActionListener(this);
        clienteView.getBtnActualizar().addActionListener(this);
        clienteView.getBtnEliminar().addActionListener(this);
        clienteView.getBtnLimpiar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clienteView.getBtnNuevo()) {

            if (obtenerCliente() != null) {

                if (clienteModel.guardarClientes(obtenerCliente())) {

                    mensajeOK("Se guardo el registro con exito");
                    creartabla(clienteModel);
                    limpiar();
                } else {

                    mensajeError("La Cedula Ya Existe");
                }

            }

        }
        if (e.getSource() == clienteView.getBtnActualizar()) {

            if (obtenerCliente() != null) {

                if (clienteModel.editarCliente(obtenerCliente())) {

                    mensajeOK("Se actualizo el registro con exito");
                    creartabla(clienteModel);
                    limpiar();
                } else {

                    mensajeError("La Cedula no existe");
                }

            }

        }
        if (e.getSource() == clienteView.getBtnEliminar()) {

            if (obtenerCliente() != null) {

                if (clienteModel.eliminarCliente(obtenerCliente())) {

                    mensajeOK("Se elimino el registro con exito");
                    creartabla(clienteModel);
                    limpiar();

                } else {

                    mensajeError("La Cedula no existe");
                }

            }

        }
        if (e.getSource() == clienteView.getBtnLimpiar()) {
            limpiar();
        }
    }

    /*
     * Funcion para obtener los datos del
     * cliente de la visa y
     * validar campos correctos
     */
    private Cliente obtenerCliente() {

        if (CamposVacios()) {
            if (validarTelefono()) {
                if (validarCedula()) {
                    if (validarCorreo()) {
                        if (validarFechas()) {

                            return new Cliente()
                                    .setCedula(clienteView.getTxtCedula().getText())
                                    .setNombre(clienteView.getTxtNombres().getText())
                                    .setApellido(clienteView.getTxtApellido().getText())
                                    .setTelefono(clienteView.getTxtTelefono().getText())
                                    .setCorreo(clienteView.getTxtCorreo().getText())
                                    .setFechaIngreso(((JTextField) clienteView.getFechaIngreso().getDateEditor().getUiComponent()).getText())
                                    .setFechaSalida(((JTextField) clienteView.getFechaSalida().getDateEditor().getUiComponent()).getText());

                        } else {
                            mensajeError("Fechas Incorrectas");
                        }

                    } else {
                        mensajeError("Correo Incorrecto");
                    }
                } else {
                    mensajeError("Cedula Incorrecta");
                }
            } else {
                mensajeError("Telefono Incorrecto");
            }
        } else {
            mensajeError("Campos Vacios");
        }

        return null;

    }

    private void limpiar() {
        clienteView.getTxtCedula().setText("");
        clienteView.getTxtNombres().setText("");
        clienteView.getTxtApellido().setText("");
        clienteView.getTxtTelefono().setText("");
        clienteView.getTxtCorreo().setText("");
        clienteView.getFechaIngreso().setCalendar(null);

        clienteView.getFechaSalida().setCalendar(null);
    }

}
