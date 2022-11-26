package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.GeneralInfoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class GeneralInfo_StepDef {
    AllCarsPage allCarsPage = new AllCarsPage();
    GeneralInfoPage generalInfoPage = new GeneralInfoPage();
    @When("The user clicks on any row on the VehicleTable page")
    public void the_user_clicks_on_any_row_on_the_vehicle_table_page() {
        allCarsPage.clickFirstCar();

    }

    @Then("The user is on the General Information page")
    public void the_user_is_on_the_general_information_page() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals("General Information", generalInfoPage.GeneralInfoTitle.getText());



    }
}