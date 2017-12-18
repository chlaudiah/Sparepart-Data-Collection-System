/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.controller;

import id.sparepart.bengkel.kelompokbengkel14.model.Barang;
import id.sparepart.bengkel.kelompokbengkel14.model.Restock;
import id.sparepart.bengkel.kelompokbengkel14.view.StockKeeper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author BegalPapua
 */
class ControllerStockKeeper implements ActionListener{
    Aplikasi model;
    StockKeeper view;

    public ControllerStockKeeper() {
        view = new StockKeeper();
        model = new Aplikasi();
        view.setVisible(true);
        view.setActionListener(this);
        model.setTableRestock(view.getTableRestock());
        model.setTableBarang(view.getTableBarang());
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        Barang b = new Barang();
        Restock re = new Restock();
        
        String nama = view.getTxNama();
        int harga = view.getTxHarga();
        int jumlah = view.getTextStock();
        String status = view.getTxStatus();
        int id = b.getId_barang();
        
        b = model.DataBarang(view.getTxSearch());
        re = model.DataRestock(view.getTxSearch(),model.idRestock);
        if(source.equals(view.getBtnSearch())){
            if(view.getTxSearch() == 0){
                 JOptionPane.showConfirmDialog(view,"Data Tidak Ditemukan","ID Barang Salah", JOptionPane.WARNING_MESSAGE);
            } else{
                view.setTxIdBarang(b.getId_barang());
                view.setTxStock(b.getJumlah_barang());
                view.setTxNama(b.getNama_barang());
                view.setTxStock(b.getJumlah_barang());
                view.setTxStatus(b.getStatus());
                view.setTxHarga(b.getHarga_barang());
                view.setTxAdd(re.getJumlahRestock());
            }
        } else if (source.equals(view.getBtnUpdate())){
            if(view.getTxIdBarang()==0 && view.getTxStock()==0){
                JOptionPane.showConfirmDialog(view,"Data Tidak ada", "Gagal Update",JOptionPane.WARNING_MESSAGE);
            } else{
                model.UpdateDataBarang(view.getTxIdBarang(), view.getTxNama(), (view.getTxStock() + view.getTxAdd()), view.getTxHarga());
                JOptionPane.showConfirmDialog(view, "Restock telah berhasil","Data TerUpdate",JOptionPane.WARNING_MESSAGE);
                model.setTableBarang(view.getTableBarang());
            }
        } else if(source.equals(view.getBtnDelete())){
            model.DeleteBarang(view.getTxIdBarang());
            model.setTableBarang(view.getTableBarang());
            view.setVisible(false);
            new ControllerKasir();
        } else if(source.equals(view.getBtnAdd())){
            if(( !nama.equals("") && harga!=0 && jumlah!=0 && status.equals(""))){
                JOptionPane.showConfirmDialog(view,"Input data berhasil", "Data telah ditambahkan",JOptionPane.WARNING_MESSAGE);
                model.tambahBarang(id, nama, jumlah, status, harga);
                view.reset();
            }
        } else{
            view.setVisible(false);
            new ControllerLogin();
        }
    }
    
}
