package com.cydeo.step_definitions;

import com.cydeo.pages.AddEvent2Page;
import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.Dash_Board_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEvent2_StepDef {
    Login_Page loginPage = new Login_Page();
    Dash_Board_Page dashBoardPage = new Dash_Board_Page();
    AllCarsPage allCarsPage = new AllCarsPage();
    AddEvent2Page addEvent2Page = new AddEvent2Page();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),60);

    @When("User hover over Fleet menu")
    public void userHoverOverFleetMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(dashBoardPage.fleetDropdownBtn));
        BrowserUtils.hover(dashBoardPage.fleetDropdownBtn);
    }
    @And("User clicks Vehicles under Fleet menu")
    public void userClicksVehiclesUnderFleetMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(dashBoardPage.vehiclesLink));
        dashBoardPage.vehiclesLink.click();
    }
    @And("User clicks any Vehicle Row under All Cars menu")
    public void userClicksAnyVehicleRowUnderAllCarsMenu() {
        BrowserUtils.sleep(5);
        allCarsPage.anyRow.click();
    }
    @Then("Verify that the user is on General Information page")
    public void verifyThatTheUserIsOnGeneralInformationPage() {
        BrowserUtils.sleep(5);
        Assert.assertTrue(addEvent2Page.GeneralPage.isDisplayed());
    }
    @And("User clicks on Add Event button")
    public void userClicksOnAddEventButton() {
        BrowserUtils.sleep(5);
        addEvent2Page.AddEventBtn.click();
    }
    @Then("Verify that the user is on the Add Event page")
    public void verifyThatTheUserIsOnTheAddEventPage() {
        Assert.assertTrue(addEvent2Page.AddEventPage.isDisplayed());
    }
    @When("User clicks blue radioButton")
    public void userClicksBlueRadioButton() {
        BrowserUtils.sleep(5);
        addEvent2Page.BlueColorRadioBtn.click();
    }
    @And("User clicks green radioButton")
    public void userClicksGreenRadioButton() {
        BrowserUtils.sleep(5);
        addEvent2Page.GreenColorRadioBtn.click();
    }
    @And("User clicks yellow radioButton")
    public void userClicksYellowRadioButton() {
        BrowserUtils.sleep(5);
        addEvent2Page.YellowColorRadioBtn.click();
    }
    @And("User clicks red radioButton")
    public void userClicksRedRadioButton() {
        BrowserUtils.sleep(5);
        addEvent2Page.RedColorRadioBtn.click();
    }
    @When("User clicks All-day event checkbox")
    public void userClicksAllDayEventCheckbox() {
        addEvent2Page.AllDayEventCheckBox.click();
        BrowserUtils.sleep(5);
    }
    @Then("Verify that time field disappears")
    public void verifyThatTimeFieldDisappears() {
        Assert.assertFalse(addEvent2Page.TimeSelectorBox.isDisplayed());
    }
    @When("User clicks Repeat checkbox")
    public void userClicksRepeatCheckbox() {
        addEvent2Page.RepeatCheckBox.click();
        BrowserUtils.sleep(5);
    }
    @And("User clicks Repeats dropbox")
    public void userClicksRepeatsDropbox() {
        addEvent2Page.RepeatsCheckBox.click();
        BrowserUtils.sleep(5);
    }
    @And("User select Daily recurrence")
    public void userSelectDailyRecurrence() {
        addEvent2Page.DailyRecurrence.click();
        BrowserUtils.sleep(5);
    }
    @And("User select Weekly recurrence")
    public void userSelectWeeklyRecurrence() {
        addEvent2Page.WeeklyRecurrence.click();
        BrowserUtils.sleep(5);
    }
    @And("User select Monthly recurrence")
    public void userSelectMonthlyRecurrence() {
        addEvent2Page.MonthlyRecurrence.click();
        BrowserUtils.sleep(5);
    }
    @And("User select Yearly recurrence")
    public void userSelectYearlyRecurrence() {
        addEvent2Page.YearlyRecurrence.click();
        BrowserUtils.sleep(5);
    }
    @Then("Verify that the user sees Summary part")
    public void verifyThatTheUserSeesSummaryPart() {
        Assert.assertTrue(addEvent2Page.SummaryPart.isDisplayed());
    }
    @When("User clicks Never radioButton")
    public void userClicksNeverRadioButton() {
        addEvent2Page.NeverBtn.click();
    }
    @And("User clicks After radioButton")
    public void userClicksAfterRadioButton() {
        addEvent2Page.OccurrenceBox.sendKeys("2");
        BrowserUtils.sleep(3);
        addEvent2Page.AfterBtn.click();
        BrowserUtils.sleep(3);
    }
    @And("User clicks By radioButton")
    public void userClicksByRadioButton() {
        addEvent2Page.ByBtn.click();
        BrowserUtils.sleep(3);
    }
    @When("User enters required data in the Add Event Title")
    public void userEntersRequiredDataInTheAddEventTitle() {
        addEvent2Page.AddEnventTitleBox.sendKeys("AddEvent2");
        BrowserUtils.sleep(5);
    }
    @And("User clicks Save button")
    public void userClicksSaveButton() {
        addEvent2Page.SaveButton.click();
    }
    @And("User clicks accordion toggle and events are seen")
    public void userClicksAccordionToggleAndEventsAreSeen() {
        addEvent2Page.CommentLine.click();
        BrowserUtils.sleep(5);
    }
}
