package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleTableArrangements_StepDef {

    AllCarsPage allCarsPage = new AllCarsPage();
    @When("user clicks View Per Page button")
    public void user_clicks_view_per_page_button() {
        allCarsPage.ContainsBtn.click();
    }
    @And("user clicks {string} which are shown")
    public void userClicksWhichAreShown(String expected) {

        By element = By.xpath("(//ul[@class='dropdown-menu pull-right'])[2]//a[normalize-space(text())='" + expected + "']");

        Driver.getDriver().findElement(element).click();

        allCarsPage.waitUntilLoaderScreenDisappear();
      }
    @Then("Verify that {int} on the page is same with the number user clicks")
    public void verifyThatActualNumberOnThePageIsSameWithTheNumberUserClicks(int actual) {
        Assert.assertEquals("This time worked",allCarsPage.countOfRow.size(),actual);
    }
}
