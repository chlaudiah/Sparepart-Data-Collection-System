/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.test.TambahStock;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 * @author dhia
 */
public class TambahStockContext {
    @Given("^stock keeper will choose the menu of \"([^\"]*)\"$")
    public void stock_keeper_will_choose_the_menu_of(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @Given("^stock keeper change item's status to be \"([^\"]*)\"$")
    public void stock_keeper_change_item_s_status_to_be(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   //throw new PendingException();
}

    @Given("^stock keeper input quantity of item$")
    public void stock_keeper_input_quantity_of_item() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @Given("^stock keeper will get the notification$")
    public void stock_keeper_will_get_the_notification() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @When("^stock keeper choose \"([^\"]*)\" in the notification$")
    public void stock_keeper_choose_in_the_notification(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @Then("^successful response by displaying item's list$")
    public void successful_response_by_displaying_item_s_list() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

    @Then("^failed response by displaying the home page$")
    public void failed_response_by_displaying_the_home_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}
}
