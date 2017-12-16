/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.test.TambahBarang;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 * @author dhia
 */
public class TambahBarangContext {
    @Given("^stock keeper choose the menu of \"([^\"]*)\" on the system$")
    public void stock_keeper_choose_the_menu_of_on_the_system(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @Given("^Stock keeper will input new data items such as \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void stock_keeper_will_input_new_data_items_such_as(String arg1, String arg2, String arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @When("^stock keeper choose the menu of \"([^\"]*)\"$")
    public void stock_keeper_choose_the_menu_of(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @Then("^the successful response by displaying \"([^\"]*)\"$")
    public void the_successful_response_by_displaying(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @When("^show the notification \"([^\"]*)\"$")
    public void show_the_notification(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @Then("^the response failed by displaying \"([^\"]*)\"$")
    public void the_response_failed_by_displaying(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}
}
