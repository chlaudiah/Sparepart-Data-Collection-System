/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.test.Login;

import cucumber.api.java.After;
import cucumber.api.java.bm.Maka;
import cucumber.api.java.id.Dengan;
import cucumber.api.java.id.Ketika;
import id.sparepart.bengkel.kelompokbengkel14.LoginAdmin;
import junit.framework.Assert;

/**
 *
 * @author BegalPapua
 */
public class LoginContext {
    private LoginAdmin admin;
    
    @After
    public void reset(){
        admin = null;
    }
    
    @Dengan("^Data admin yang dimasukkan dan data admin tersedia dalam data yang telah ada di sistem$")
    public void data_admin_yang_dimasukkan_dan_data_admin_tersedia_dalam_data_yang_telah_ada_di_sistem() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Ketika("^Memasukkan data admin dengan \"([^\"]*)\" dan \"([^\"]*)\"$")
    public void memasukkan_data_admin_dengan_dan(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Maka("^respon sukses dengan pesan \"([^\"]*)\"$")
    public void respon_sukses_dengan_pesan(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Dengan("^Data admin yang dimasukkan dan username admin tidak tersedia dalam data yang telah ada di sistem$")
    public void data_admin_yang_dimasukkan_dan_username_admin_tidak_tersedia_dalam_data_yang_telah_ada_di_sistem() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Maka("^respon gagal dengan pesan \"([^\"]*)\"$")
    public void respon_gagal_dengan_pesan(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Dengan("^Data admin yang dimasukkan dan password admin tidak tersedia dalam data yang telah ada di sistem$")
    public void data_admin_yang_dimasukkan_dan_password_admin_tidak_tersedia_dalam_data_yang_telah_ada_di_sistem() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Dengan("^data admin yang dimasukkan dan data admin tidak tersedia dalam data yang telah ada di sistem$")
    public void data_admin_yang_dimasukkan_dan_data_admin_tidak_tersedia_dalam_data_yang_telah_ada_di_sistem() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

}
