/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.controller;

import id.sparepart.bengkel.kelompokbengkel14.model.Barang;
import id.sparepart.bengkel.kelompokbengkel14.model.Pemesanan;
import id.sparepart.bengkel.kelompokbengkel14.model.Restock;
import id.sparepart.bengkel.kelompokbengkel14.view.Kasir;
import id.sparepart.bengkel.kelompokbengkel14.view.StockKeeper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author BegalPapua
 */
class ControllerKasir implements ActionListener{
    Aplikasi model;
    Kasir view;
    
    public ControllerKasir() {
        view = new Kasir();
        model = new Aplikasi();
        view.setVisible(true);
        view.setActionListener(this);
        model.setTableRestock(view.getTablePemesanan());
        model.setTableBarang(view.getTableBarang());
    }

    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        Barang b = new Barang();
        Pemesanan psn = new Pemesanan();
        
        String tanggal = view.getTxTgl();
        int totalOrder = view.getTxJmlhBarang();
        int totalHarga = view.getTxTtlByr();
        int idBarang = model.idBarang;
           
        b = model.DataBarang(view.getTxtSearch());
        psn = model.DataPemesanan(view.getTxtSearch(),model.idPemesanan);
    } 
}
