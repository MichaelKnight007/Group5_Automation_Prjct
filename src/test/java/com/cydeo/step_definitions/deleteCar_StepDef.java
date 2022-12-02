package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class deleteCar_StepDef {

    AllCarsPage allCarsPage = new AllCarsPage();
    public String plateNumber;

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

    @When("The user clicks on Yes-Delete btn")
    public void theUserClicksOnYesDeleteBtn() {
        allCarsPage.clickYesDelete();
    }

    @Then("{string} gets {string} message")
    public void getsMessage(String arg0, String arg1) {
        allCarsPage.verifyWarningMessageDriver(arg0, arg1);
    }

    @And("The user saves {string} of the car")
    public void theUserSavesOfTheCar() {

    }

    @And("The deleted car is also removed from the table")
    public void theDeletedCarIsAlsoRemovedFromTheTable() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        Assert.assertNotEquals(plateNumber, allCarsPage.getDriverName());
    }

    @And("The user saves License Plate of the car")
    public void theUserSavesLicensePlateOfTheCar() {
        plateNumber = allCarsPage.getDriverName();
    }

    @When("User clicks on the Delete button")
    public void userClicksOnTheDeleteButton() {
        allCarsPage.clickDeleteInfo();
    }
}
