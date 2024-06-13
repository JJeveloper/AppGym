/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appgym.controller;

import com.mycompany.appgym.model.Cliente;
import com.mycompany.appgym.model.ClienteModel;
import com.mycompany.appgym.view.ClienteView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JJAB
 */
public class Tabla {

    private DefaultTableModel tableModel;
    private List<Cliente> clientesList;
    private ClienteView clienteView;

    public Tabla(ClienteView clienteView) {
        this.clienteView = clienteView;
    }

    /*
     * Funcion para crear el modelo de la tabla
     * y llenarla con los elementos del modelo
     */
    protected void creartabla(ClienteModel clienteModel) {

        String[] titulos = new String[]{"Cedula", "Nombre", "Apellido", "telefono", "correo", "ingreso", "final"};
        tableModel = new DefaultTableModel(titulos, 0);

        clienteView.getTblDatos().setModel(tableModel);

        clientesList = clienteModel.obtenerClientes();

        for (Cliente c : clientesList) {
            tableModel.addRow(new Object[]{c.getCedula(), c.getNombre(),
                c.getApellido(), c.getTelefono(), c.getCorreo(),
                c.getFechaIngreso(), c.getFechaSalida()});
        }

    }


    /*
     * Funcion para llenar los campos JTextField
     * con los datos de la tabla al momento    
     * de dar click en una fila
     */
    protected void seleccionarllenarCampos() {

        clienteView.getTblDatos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JTable target = (JTable) e.getSource();
                clienteView.getTxtCedula().setText(clienteView.getTblDatos().getModel().getValueAt(target.getSelectedRow(), 0).toString());
                clienteView.getTxtNombres().setText(clienteView.getTblDatos().getModel().getValueAt(target.getSelectedRow(), 1).toString());
                clienteView.getTxtApellido().setText(clienteView.getTblDatos().getModel().getValueAt(target.getSelectedRow(), 2).toString());
                clienteView.getTxtTelefono().setText(clienteView.getTblDatos().getModel().getValueAt(target.getSelectedRow(), 3).toString());
                clienteView.getTxtCorreo().setText(clienteView.getTblDatos().getModel().getValueAt(target.getSelectedRow(), 4).toString());

                try {
                    java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String) clienteView.getTblDatos().getModel().getValueAt(target.getSelectedRow(), 5));
                    clienteView.getFechaIngreso().setDate(date1);

                    java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) clienteView.getTblDatos().getModel().getValueAt(target.getSelectedRow(), 6));
                    clienteView.getFechaSalida().setDate(date2);

                } catch (ParseException pe) {
                    System.out.println("No se puede pasar la fecha");
                }

            }
        });

    }

}
