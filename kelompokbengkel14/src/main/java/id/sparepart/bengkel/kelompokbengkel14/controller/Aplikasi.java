/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.controller;

import id.sparepart.bengkel.kelompokbengkel14.model.Barang;
import id.sparepart.bengkel.kelompokbengkel14.model.Pemesanan;
import id.sparepart.bengkel.kelompokbengkel14.model.Restock;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BegalPapua
 */
public class Aplikasi {
    Database db;
    ArrayList<Barang> arb = new ArrayList();
    ArrayList<Pemesanan> p = new ArrayList();
    ArrayList<Restock> re = new ArrayList();
    
    Restock r;
    
    Barang b;
    Pemesanan pe;
    int idBarang;
    int idRestock;
    int idPemesanan;
    
    

    public Aplikasi() {
        db = new Database();
        db.connect();
        arb = db.getAllDataBarang();
    }
    
    //-----------------LOGIN----------------//
     public String cekLogin(String username, String password) {
        return db.getStatus(username, password);
    }
     
    //------------------APLIKASI BARANG---------------------//
     public int getIdBarang(int idBarang) {
        int i = 0;
        while (arb.get(i) != null && (idBarang != arb.get(i).getId_barang())) {
            i++;
        }
        if (arb.get(i) != null) {
            return arb.get(i).getId_barang();
        }
        return 0;
    }
     
    public String getNamaBarang(int idBarang) {
        int i = 0;
        while (arb.get(i) != null && (idBarang != arb.get(i).getId_barang())) {
            i++;
        }
        if (arb.get(i) != null) {
            return arb.get(i).getNama_barang();
        }
        return "";
    }
    
    public void setTableBarang(JTable table) {
        for (int i = 0; i < db.getAllDataBarang().size(); i++) {
            table.setValueAt(db.getAllDataBarang().get(i).getId_barang(), i, 0);
            table.setValueAt(db.getAllDataBarang().get(i).getNama_barang(), i, 1);
            table.setValueAt(db.getAllDataBarang().get(i).getHarga_barang(), i, 2);
            table.setValueAt(db.getAllDataBarang().get(i).getJumlah_barang(), i, 3);
            table.setValueAt(db.getAllDataBarang().get(i).getStatus(), i, 4);
        }
    }
    
    public void tambahBarang(int id, String nama, int jumlah, String status, int harga) {
        //generateId
        Barang brg = new Barang(getIdBarang(id), nama, jumlah, status, harga);
        db.saveBarang(brg);
    }
    
    public Barang DataBarang(int idBarang){
         ResultSet rs = db.getDataBarang(idBarang);
        if (!(rs == null)) {
            try {
                this.idBarang = rs.getInt("id_barang");
                b = new Barang(idBarang,
                        rs.getString("nama_barang"),
                        rs.getInt("jumlah_barang"),
                        rs.getString("status"),
                        rs.getInt("harga_barang"));
                return b;
            } catch (Exception e) {
                //e.printStackTrace();
                JOptionPane.showConfirmDialog(null, "" + e.getMessage(), "Tidak bisa mengambil data barang", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            return b;
        }
        return b;
    }
    
    public void UpdateDataBarang(int id, String nama, int jumlah, int harga){
        db.UpdateDataBarang(id, nama, jumlah , harga);
    }
    
    public void DeleteBarang(int idBarang){
        db.DeleteDataBarang(idBarang);
    }
   //------------------APLIKASI PEMESANAN------------------//
   public int getTotalHarga(int idPemesanan){
       int i = 0;
        while (p.get(i) != null && (idPemesanan != p.get(i).getId_pemesanan())) {
            i++;
        }
        if (p.get(i) != null) {
            return p.get(i).HitungTotal(idPemesanan);
        }
        return 0;
   }
   public void insertPemesanan(int idPemesanan, int idBarang, String tanggal, int jml, int total_harga) {
        if (db.cekBarangPemesanan(getIdBarang(idBarang))) {
            db.savePemesanan(idPemesanan, tanggal, jml, idBarang, getTotalHarga(idPemesanan)); 
        } else {
            JOptionPane.showConfirmDialog(null, "Pemesanan sudah ada", "Barang gagal dipesan", JOptionPane.WARNING_MESSAGE);
        }
    }
   
   public void setTablePemesanan(JTable table) {
        db.setUptablePemesanan(table);
   }
   
   
   //------------------APLIKASI RESTOCK--------------------//
   public int getJumlahBarang(int idRestock){
       int i = 0;
        while (re.get(i) != null && (idRestock != re.get(i).getIdRestock())) {
            i++;
        }
        if (re.get(i) != null) {
            return re.get(i).tambahJumlahBarang(idRestock).getJumlah_barang();
        }
        return 0;
   }
   public void insertRestock(int idRestock, String tanggal, int jumlahRestock, int idbarang, String namaBarang, int jumlahBarang) {
        if (db.cekBarangRestock(getIdBarang(idbarang))) {
            db.saveRestock(idRestock, tanggal, jumlahRestock, idbarang, getJumlahBarang(idRestock), getNamaBarang(idbarang)); 
        } else {
            JOptionPane.showConfirmDialog(null, "Pemesanan sudah ada", "Barang gagal dipesan", JOptionPane.WARNING_MESSAGE);
        }
    }
   
   public void setTableRestock(JTable table) {
        db.setUptableRestock(table);
   } 
   //-------------------------------------------------------------------//
   public void resetTable(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
            }
        }
    }
   
   public Restock DataRestock(int idBarang, int idRestock){
        ResultSet rs = db.getDataRestock(idRestock, idBarang);
        if (!(rs == null)) {
            try {
                this.idBarang = rs.getInt(2);
                this.idRestock = rs.getInt(1);
                r = new Restock(new Barang(getIdBarang(idBarang), 
                        rs.getString("nama_barang"),
                        rs.getInt("jumlah_barang"),
                        rs.getString("status"),
                        rs.getInt("harga_barang")), 
                        rs.getString("tanggal_restock"),
                        rs.getInt("id_restock"),
                        rs.getInt("jumlah_restock"));
                return r;
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "" + e.getMessage(), "Tidak bisa mengambil data restock", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            return r;
        }
        return r;
    }
   
   public Pemesanan DataPemesanan(int idBarang, int idPemesanan){
         ResultSet rs = db.getDataBarang(idBarang);
        if (!(rs == null)) {
            try {
                this.idBarang = rs.getInt(2);
                this.idPemesanan = rs.getInt(2);
                pe = new Pemesanan(new Barang(getIdBarang(idBarang), 
                        rs.getString("nama_barang"),
                        rs.getInt("jumlah_barang"),
                        rs.getString("status"),
                        rs.getInt("harga_barang")), 
                        rs.getInt("id_pemesanan"),
                        rs.getString("tanggal_pemesanan"),
                        rs.getInt("jumlahOrder"));
                return pe;
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "" + e.getMessage(), "Tidak bisa mengambil data mahasiswa", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            return pe;
        }
        return pe;
    }
    
    
    
}
