package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.Dash_Board_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.Driver;
import com.sun.jna.win32.DLLCallback;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LastOdometerFilter_StepDef {

    Login_Page loginPage = new Login_Page();
    Dash_Board_Page dashboardPage = new Dash_Board_Page();
    AllCarsPage allCarsPage = new AllCarsPage();


    // Background:

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.goLoginPage();
    }

    @Given("user logged in as {string}")
    public void user_logged_in_as_a_salesmanager101(String userType) {
        loginPage.loginAsUserType(userType);
    }

    @Given("user is on the D- {string} page")
    public void user_is_on_the_dashboard_page(String page) {
        Assert.assertEquals(page, Driver.getDriver().getTitle());
    }

    @Given("user select vehicles under the fleet menu")
    public void user_select_vehicles_under_the_fleet_menu() {
        dashboardPage.fleetDropdownBtn.click();
        dashboardPage.vehiclesLink.click();
    }

    @Given("user is on the {string} page")
    public void user_is_on_the_vehicle_page(String page) {

        Assert.assertEquals(page, allCarsPage.allCarsTitle.getText());
    }

    @Given("user click on the filter button")
    public void user_click_on_the_filter_button() {
        allCarsPage.FiltersButton.click();
    }

    @Given("user click on the Manage Filters button")
    public void user_click_on_the_manage_filters_button() {
        allCarsPage.manageFilterDropdown.click();
    }

    @Given("user enter {string} in the input")
    public void user_type_in_the_input(String string) {
        allCarsPage.manageFiltersSearchInputBox.sendKeys(string);
    }

    @Given("user click last odometer checkbox")
    public void user_click_last_odometer_checkbox() {
        allCarsPage.lastOdometerCheckbox.click();
    }

    @Given("user click on the last odometer dropbox")
    public void user_click_on_the_last_odometer_dropbox() {
        allCarsPage.lastOdometerDropdownButton.click();
    }

    @Given("user click the dropdown")
    public void user_click_the_dropdown() {
        allCarsPage.lastOdometerFilterDropdownItems.click();
    }


    // #AC-1:

    @Then("filter should have methods below")
    public void filter_should_have_methods_below() {


    }


    //-----------------
    // #AC-2:

    @When("user select between method")
    public void user_select_between_method() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enter numeric values {string} and {string}")
    public void user_enter_numeric_values_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user click the update button")
    public void user_click_the_update_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("results should be between the specified values")
    public void results_should_be_between_the_specified_values() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //-----------------
    // #AC-3:

    @When("user select equals method")
    public void user_select_equals_method() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enter numeric value {string}")
    public void user_enter_numeric_value(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results should match specified value")
    public void results_should_match_specified_value() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    ///-----------------
    // #AC-4:

    @When("user select more than method")
    public void user_select_more_than_method() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results should be more than the specified value")
    public void results_should_be_more_than_the_specified_value() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //-----------------
    // #AC-5:

    @When("user select less than method")
    public void user_select_less_than_method() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results should be less than the specified value")
    public void results_should_be_less_than_the_specified_value() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    //-----------------
    // #AC-6:

    @When("user select is empty method")
    public void user_select_is_empty_method() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("only empty values should be displayed")
    public void only_empty_values_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    //-----------------
    // #AC-7:

    @When("user select {string} method")
    public void user_select_method_method(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enter {string} into input")
    public void user_enter_into_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enter {string} into second input")
    public void user_enter_second_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("method should not accept non-numeric values")
    public void method_should_not_accept_non_numeric_values() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }






}
