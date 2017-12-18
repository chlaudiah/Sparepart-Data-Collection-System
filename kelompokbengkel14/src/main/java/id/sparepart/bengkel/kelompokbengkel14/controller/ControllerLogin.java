/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import id.sparepart.bengkel.kelompokbengkel14.view.Login;
import javax.swing.JOptionPane;
/**
 *
 * @author BegalPapua
 */
public class ControllerLogin implements ActionListener{
    Aplikasi model;
    Login view;
    
    public ControllerLogin() {
        view = new Login();
        model = new Aplikasi();
        view.setVisible(true);
        view.setActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       String username = view.getTxUsername().getText();
       String password = view.getTxPassword().getText();
       try {
            if (!(model.cekLogin(username, password)==null)) {

                if (model.cekLogin(username, password).equals("Admin1")) {
                    JOptionPane.showConfirmDialog(view, "Terdaftar sebagai "+model.cekLogin(username, password), "Login Sukses", JOptionPane.WARNING_MESSAGE);
                    new ControllerKasir();
                    view.setVisible(false);
                }else if(model.cekLogin(username, password).equals("Admin2")){
                    JOptionPane.showConfirmDialog(view,"terdaftar sebagai "+model.cekLogin(username, password),"Login Sukses",JOptionPane.WARNING_MESSAGE);
                    new ControllerStockKeeper();
                    view.setVisible(false);
                } 
            } else {
                JOptionPane.showConfirmDialog(view, "Anda belum terdaftar", "Login Gagal", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
             e.printStackTrace();//penting
            JOptionPane.showConfirmDialog(view, ""+e.getMessage(), ""+e.getMessage(), JOptionPane.WARNING_MESSAGE);
        }
        view.reset();

    }
}
