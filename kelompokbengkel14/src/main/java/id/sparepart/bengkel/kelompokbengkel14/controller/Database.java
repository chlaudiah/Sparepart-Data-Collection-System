/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.controller;

import id.sparepart.bengkel.kelompokbengkel14.model.Barang;
import id.sparepart.bengkel.kelompokbengkel14.model.Pemesanan;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author BegalPapua
 */
public class Database {
    private String server = "jdbc:mysql://localhost:3306/kelompokbengkel";
    private String dbuser = "root";
    private String dbpassword = "";
    private Statement statement = null;
    private Connection connection = null;
    private Component view;
    
    public Database() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Eror Driver", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void connect() {
        try {
            this.connection = DriverManager.getConnection(server, dbuser, dbpassword);
            this.statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Terjadi kesalahan saat konek", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //------------------------LOGIN--------------------//
    public String getStatus(String id, String password) {
        String status = null;
        try {
            String query = "select * from DataAdmin where id_admin= '" + id + "'";
            //JOptionPane.showConfirmDialog(null, query);
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                status = rs.getString("id_admin");
            }
            return status;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "eror get status", "Eror get status", JOptionPane.WARNING_MESSAGE);
        }
        return status;
    }
    
    //-------------------DATABASE UNTUK DATA BARANG-----------------//
    public void saveBarang(Barang b){
        try{
            String query1 = "insert into barang(id_barang,nama_barang,jumlah_barang,status,harga_barang) values"
                        + "(" + b.getId_barang() + "', "
                        + "'" + b.getNama_barang() + "', "
                        + "'" + b.getJumlah_barang() + "', "
                        + "'" + b.getStatus() + "', "
                        + "'" + b.getHarga_barang() +"')";
            statement.execute(query1);
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, "Data masih kosong atau ID Barang sudah ada", "Terjadi kesalahan saat insert data", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ArrayList<Barang> getAllDataBarang() {
        ResultSet rs;
        Barang b;
        ArrayList<Barang> arb = new ArrayList();
        try {
            String query = "select * from barang";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                b = new Barang(rs.getInt("id_barang"), 
                        rs.getString("nama_barang"), 
                        rs.getInt("jumlah_barang"),
                        rs.getString("status"),
                        rs.getInt("harga_barang"));
                arb.add(b);
            }
            return arb;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save barang");
        }
    }
    
     public ResultSet getDataBarang(int idBarang) {
        ResultSet rs = null;
        try {
            String query = "select * from barang where id_barang='"+ idBarang + "'";
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                rs = result;
            }
            return rs;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error get data barang", "Error get data", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
     public void UpdateDataBarang(int id, String nama, int jumlah, int harga) {
        try {
            String query = "update barang set nama_barang='" + nama + "',jumlah_barang='" + jumlah + "',harga_barang='" + harga + "' where id_barang='" + id + "'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error get data", "Error get data", JOptionPane.WARNING_MESSAGE);
        }
    }
     
     public void DeleteDataBarang(int id) {
        try {
            String query1 = "Delete from barang where ='" + id + "'";
            statement.execute(query1);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Data Terhapus", "Data Terhapus", JOptionPane.WARNING_MESSAGE);
        }
    }
     
    //------------------DATABASE UNTUK DATA PEMESANAN-------------------------------//
    public void savePemesanan(int id, String tanggal, int total, int idbarang, int total_harga) {
        try {
            String query = "insert into pemesanan(id_pemesanan,jumlahOrder,tanggal_pemesanan) values ('"
                    + id + "','" + total + "','" + tanggal + "')";
            String query2 = "insert into relasi_pemesanan_barang_admin(id_barang, total_harga) values ('" + idbarang + "'," + total_harga + "')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            statement.execute(query2, Statement.RETURN_GENERATED_KEYS);

            JOptionPane.showConfirmDialog(view, "Create Pemesanan berhasil dilakukan", "Succeed", JOptionPane.NO_OPTION);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Insert data Pemesanan gagal" + e.getMessage(), "Gagal insert", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean cekBarangPemesanan(int idBarang) {
        String query = "select * from relasi_pemesanan_barang_admin "
                + "join pemesanan using(idPemesanan) "
                + "join barang using (id_barang) "
                + "where barang.id_barang = '" + idBarang + "'";
        try {
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(view, e.getMessage(), "gagal load data", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
    
    public void setUptablePemesanan(JTable table) {
        try {
            String query = "select nama_admin, tanggal_pemesanan, jumlahOrder, nama_barang, total_harga from relasi_pemesanan_barang_admin "
                    + "								join pemesanan USING(ID_PEMESANAN) "
                    + "								join barang USING(ID_BARANG) "
                    + "								join DataAdmin USING(ID_ADMIN)";							
            ResultSet rs = statement.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                table.setValueAt(rs.getString("nama_admin"), i, 0);
                table.setValueAt(rs.getString("tanggal_pemesanan"), i, 1);
                table.setValueAt(rs.getString("jumlah_order"), i, 2);
                table.setValueAt(rs.getString("nama_barang"), i, 3);
                table.setValueAt(rs.getString("total_harga"), i, 4);
                i++;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Gagal load data pemesanan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ResultSet getDataPemesanan(int idPemesanan, int idBarang) {
        ResultSet rs = null;
        try {
            String query = "select * from relasi_pemesanan_barang_admin "
                    + " join pemesanan USING(id_pemesanan) "
                    + "join Barang USING(id_barang)"
                    + " where id_barang='" + idBarang + "'" + " and id_pemesanan='" + idPemesanan + "'";
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                rs = result;
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showConfirmDialog(null, "Error get data barang", "Error get data", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    //-------------------------DATABASE UNTUK DATA RESTOCK-------------------------------//
    public void saveRestock(int id, String tanggal, int jumlah, int idbarang, int jumlahBarang, String namaBarang) {
        try {
            String query = "insert into pemesanan(id_restock,tanggal_restock,jumlah_restock) values ('"
                    + id + "','" + tanggal + "','" + jumlah + "')";
            String query2 = "insert into relasi_restock_barang(idbarang) values ('" + idbarang + "')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            statement.execute(query2, Statement.RETURN_GENERATED_KEYS);

            JOptionPane.showConfirmDialog(view, "Create restock berhasil dilakukan", "Succeed", JOptionPane.NO_OPTION);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Insert data restock gagal" + e.getMessage(), "Gagal insert", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean cekBarangRestock(int idBarang) {
        String query = "select * from relasi_restock_barang "
                + "join restock using(id_restock) "
                + "join barang using (id_barang) "
                + "where barang.id_barang = '" + idBarang + "'";
        try {
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(view, e.getMessage(), "gagal load data", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
    
    public void setUptableRestock(JTable table) {
        try {
            String query = "select id_restock, tanggal_restock, jumlah_restock, nama_barang, jumlah_barang from relasi_pemesanan_barang_admin "
                    + "								join restock USING(id_restock) "
                    + "								join barang USING(ID_BARANG) ";														
            ResultSet rs = statement.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                table.setValueAt(rs.getString("id_restock"), i, 0);
                table.setValueAt(rs.getString("tanggal_restock"), i, 1);
                table.setValueAt(rs.getString("jumlah_restock"), i, 2);
                table.setValueAt(rs.getString("nama_barang"), i, 3);
                table.setValueAt(rs.getString("jumlah_barang"), i, 4);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Gagal load data restock", JOptionPane.WARNING_MESSAGE);
        }
    }
    
     public ResultSet getDataRestock(int idRestock, int idBarang) {
        ResultSet rs = null;
        try {
            String query = "select * from relasi_restock_barang "
                    + "join restock USING(id_restock) "
                    + "join barang USING(id_barang)"
                    + " where id_barang='" + idBarang + "'" + " and id_restock='" + idRestock + "'";
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                rs = result;
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showConfirmDialog(null, "Error get data barang", "Error get data", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
     
}
