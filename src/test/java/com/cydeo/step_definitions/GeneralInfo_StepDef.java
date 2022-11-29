package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.GeneralInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GeneralInfo_StepDef {
    AllCarsPage allCarsPage = new AllCarsPage();
    GeneralInfoPage generalInfoPage = new GeneralInfoPage();
    public String info;
    public List<String> allCarInfoFromRow;
    public List<String> allCarInfoFromGeneralInfo;
    @When("The user clicks on any row on the VehicleTable page")
    public void the_user_clicks_on_any_row_on_the_vehicle_table_page() {
        allCarsPage.clickFirstCar();

    }

    @Then("The user is on the General Information page")
    public void the_user_is_on_the_general_information_page() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals("General Information", generalInfoPage.GeneralInfoTitle.getText());

    }
    @Then("User hover over the three dots at the end of each row")
    public void user_hover_over_the_three_dots_at_the_end_of_each_row() {
        allCarsPage.hoveroverthreedots();
    }

    @And("user clicks on Eye \\(View) icon")
    public void userClicksOnEyeViewIcon() {
        allCarsPage.clickonviewicon();
    }

    @Then("The user can see {string}, {string} and {string} buttons")
    public void theUserCanSeeAndButtons(String btn1,String btn2, String btn3) {
        generalInfoPage.isVisibleEditDeleteAddEvent(btn1, btn2, btn3);
    }

    @Then("The user can't see {string}, {string} and {string} buttons")
    public void theUserCanTSeeAndButtons(String btn1, String btn2, String btn3) {
        generalInfoPage.isNotVisibleEditDeleteAddEvent(btn1, btn2, btn3);
    }

    @When("The user saves car info of any row randomly")
    public void theUserSavesCarInfoOfAnyRowRandomly() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        allCarInfoFromRow = generalInfoPage.getCarInfoFromRow();
    }



    @Then("All the car info must be the same as in the General Info page")
    public void allTheCarInfoMustBeTheSameAsInTheGeneralInfoPage() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        allCarInfoFromGeneralInfo = generalInfoPage.getCarInfoAsList();

        System.out.println("car info from row.........: " + allCarInfoFromRow);
        System.out.println("car info from general info: " + allCarInfoFromGeneralInfo);

        Assert.assertEquals(allCarInfoFromGeneralInfo, allCarInfoFromRow);
    }

    @And("The user clicks on the same row on the VehicleTable pagea")
    public void theUserClicksOnTheSameRowOnTheVehicleTablePagea() {
        allCarsPage.clickFirstCar();

    }
}

