/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14;

import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class LoginAdmin {
    private String idAdmin;
    private String namaAdmin;
    private String password;
    private ArrayList<LoginAdmin> daftarAdmin;
    public int gen;

    public LoginAdmin(String namaAdmin, String password) {
        this.namaAdmin = namaAdmin;
        this.password = password;
        this.daftarAdmin = new ArrayList();
    }
    
    public void inputDataAdmin(){
        daftarAdmin.add(new LoginAdmin(idAdmin,password));
    }
    

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public String getPassword() {
        return password;
    }

    public String getIdAdmin() {
        gen++;
        return namaAdmin+"_"+gen;
    }
    
    public boolean cekIdAdmin(){
        if(getIdAdmin().equals(daftarAdmin)){
            return true;
        }
        else
            return false;
    }
    
    
    public boolean cekPasswordAdmin(){
        if(getPassword().equals(daftarAdmin)){
            return true;
        }
        else
            return false;
    }
    
    public void tampilkanPesan(){
        if(cekIdAdmin() == true && cekPasswordAdmin() == true){
            System.out.println("Anda berhasil login sebagai admin");
        }
        else if(cekIdAdmin() == true && cekPasswordAdmin() == false){
            System.out.println("Password anda salah");
        }
        else if(cekIdAdmin() == false && cekPasswordAdmin() == true){
            System.out.println("Username anda salah");
        }
        else
            System.out.println("Password dan username anda salah");
    }
}
