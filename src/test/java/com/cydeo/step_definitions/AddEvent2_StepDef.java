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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddEvent2_StepDef {
    Login_Page loginPage = new Login_Page();
    Dash_Board_Page dashBoardPage = new Dash_Board_Page();
    AllCarsPage allCarsPage = new AllCarsPage();
    AddEvent2Page addEvent2Page = new AddEvent2Page();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),60);

    @And("User clicks any Vehicle Row under All Cars menu")
    public void userClicksAnyVehicleRowUnderAllCarsMenu() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        allCarsPage.clickFirstCar();
    }
    @Then("Verify that the user is on General Information page")
    public void verifyThatTheUserIsOnGeneralInformationPage() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(addEvent2Page.GeneralPage, 5);
        Assert.assertTrue(addEvent2Page.GeneralPage.isDisplayed());
    }
    @And("User clicks on Add Event button")
    public void userClicksOnAddEventButton() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(addEvent2Page.AddEventBtn));
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.AddEventBtn.click();
    }
    @Then("Verify that the user is on the Add Event page")
    public void verifyThatTheUserIsOnTheAddEventPage() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.sleep(2);
        Assert.assertTrue(addEvent2Page.AddEventPage.isDisplayed());
    }
    @When("User clicks blue radioButton")
    public void userClicksBlueRadioButton() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.BlueColorRadioBtn.click();
    }
    @And("User clicks green radioButton")
    public void userClicksGreenRadioButton() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.GreenColorRadioBtn.click();
    }
    @And("User clicks yellow radioButton")
    public void userClicksYellowRadioButton() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.YellowColorRadioBtn.click();
    }
    @And("User clicks red radioButton")
    public void userClicksRedRadioButton() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.RedColorRadioBtn.click();
    }
    @When("User clicks All-day event checkbox")
    public void userClicksAllDayEventCheckbox() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.AllDayEventCheckBox.click();
    }
    @Then("Verify that time field disappears")
    public void verifyThatTimeFieldDisappears() {
        Assert.assertTrue(addEvent2Page.TimeSelectorBox.isEnabled());
    }
    @When("User clicks Repeat checkbox")
    public void userClicksRepeatCheckbox() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.RepeatCheckBox.click();
    }
    @And("User clicks Repeats dropbox")
    public void userClicksRepeatsDropbox() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.RepeatsCheckBox.click();
    }
    @And("User select Daily recurrence")
    public void userSelectDailyRecurrence() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.DailyRecurrence.click();
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
        addEvent2Page.AfterBtn.click();
    }
    @And("User clicks By radioButton")
    public void userClicksByRadioButton() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.ByBtn.click();
    }
    @When("User enters required data in the Add Event Title")
    public void userEntersRequiredDataInTheAddEventTitle() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        addEvent2Page.AddEnventTitleBox.sendKeys("AddEvent2");
    }
    @And("User clicks Save button")
    public void userClicksSaveButton() {
        addEvent2Page.SaveButton.click();
        allCarsPage.waitUntilLoaderScreenDisappear();
    }
    @And("User clicks accordion toggle and events are seen")
    public void userClicksAccordionToggleAndEventsAreSeen() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(addEvent2Page.CommentLine.isDisplayed());
    }

    @Then("Verify that user sees Daily options")
    public void verifyThatUserSeesDailyOptions() {
        Select select = new Select(addEvent2Page.RepeatsCheckBox);
        List<WebElement> options = select.getOptions();
        String[] expected = {"Daily", "Weekly", "Monthly", "Yearly"};
        for(int i =0; i<options.size(); i++){
            String option = options.get(i).getText();
            Assert.assertEquals(option, expected[i]);
        }
    }
}
