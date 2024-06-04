/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appgym.controller;

import com.mycompany.appgym.view.ClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JJAB
 */
public class ClienteController implements ActionListener{
    
    ClienteView clienteView;

    public ClienteController(ClienteView clienteView) {
        this.clienteView = clienteView;
    }
    
    private void agregarEventos(){
        clienteView.getBtnNuevo().addActionListener(this);
        clienteView.getBtnActualizar().addActionListener(this);
        clienteView.getBtnEliminar().addActionListener(this);
        clienteView.getBtnLimpiar().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== clienteView.getBtnNuevo()) {
            
        }
        if (e.getSource()== clienteView.getBtnActualizar()) {
            
        }
        if (e.getSource()== clienteView.getBtnEliminar()) {
            
        }
        if (e.getSource()== clienteView.getBtnLimpiar()) {
            
        }
    }
    
}
