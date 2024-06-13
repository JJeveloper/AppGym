/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.appgym;

import com.mycompany.appgym.controller.ClienteController;
import com.mycompany.appgym.model.ClienteModel;
import com.mycompany.appgym.view.ClienteView;

/**
 *
 * @author JJAB
 */
public class AppGym {

    public static void main(String[] args) {
        
        ClienteModel clienteModel = new ClienteModel().cargar();

        ClienteView clienteView = new ClienteView();
        clienteView.setVisible(true);
        clienteView.setLocationRelativeTo(null);

        

        ClienteController clienteController = new ClienteController(clienteView, clienteModel);

    }
}
