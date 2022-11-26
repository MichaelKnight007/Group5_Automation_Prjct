package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class deleteCar_StepDef {

    AllCarsPage allCarsPage = new AllCarsPage();

    @Then("User hover over the three dots at the end of each row")
    public void user_hover_over_the_three_dots_at_the_end_of_each_row() {
        allCarsPage.hoveroverthreedots();
    }

    @Then("Verify that user sees Delete button")
    public void verifyThatUserSeesButton() {
        Assert.assertTrue(allCarsPage.verifyDeleteButton());
    }

    @When("User clicks on the Delete icon")
    public void userClicksOnTheDeleteIcon() {
        allCarsPage.clickDeleteButton();
    }

    @Then("Verify that Delete Confirmation pop up displayed")
    public void verifyThatDeleteConfirmationPopUpDisplayed() {
        allCarsPage.verifyDeleteConfirmationPopUp();
    }
}
