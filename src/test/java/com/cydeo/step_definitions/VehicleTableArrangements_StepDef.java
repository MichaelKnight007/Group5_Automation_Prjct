package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VehicleTableArrangements_StepDef {
    @Given("user is on the vehicles page for arrangement")
    public void user_is_on_the_vehicles_page_for_arrangement() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));

    }
    @When("user clicks View Per Page button")
    public void user_clicks_view_per_page_button() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }
    @And("user sees {int}{int}{int}{int} numbers")
    public void userSeesNumbers(int arg0, int arg1, int arg2, int arg3) {
    }

    @When("user clicks any of them")
    public void user_clicks_any_of_them() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }
    @Then("user should see same number of vehicle on the page with the chosen one")
    public void user_should_see_same_number_of_vehicle_on_the_page_with_the_chosen_one() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }

}
