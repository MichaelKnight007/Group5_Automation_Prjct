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

import java.util.ArrayList;
import java.util.List;

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
        Assert.assertEquals( allCarsPage.countOfRow.size(), actual);
    }

    @Then("User should see {int} on the View Per Page dropdown button by default")
    public void userShouldSeeOnTheViewPerPageDropdownButtonByDefault(int expectedResult) {
        Assert.assertEquals(expectedResult, Integer.parseInt(allCarsPage.ContainsBtn.getAttribute("innerText")));
    }

    @Then("Verify that View Per Page dropdown includes below options")
    public void verifyThatViewPerPageDropdownIncludesBelowOptions(List<Integer> expectedNumbers) {
        List<Integer> actualNumbers = new ArrayList<>();
        for (WebElement webElement : allCarsPage.numbersForFilter) {
            actualNumbers.add(Integer.parseInt(webElement.getAttribute("innerText")));
        }
        System.out.println(expectedNumbers);
        System.out.println(actualNumbers);
        Assert.assertEquals(expectedNumbers, actualNumbers);
    }

    @When("user filters the page by clicking {string}")
    public void user_filters_the_page_by_clicking(String filter) {
        allCarsPage.ContainsBtn.click();
        By element = By.xpath("(//ul[@class='dropdown-menu pull-right'])[2]//a[normalize-space(text())='" + filter + "']");

        Driver.getDriver().findElement(element).click();

        allCarsPage.waitUntilLoaderScreenDisappear();

    }

    @And("user clicks refresh button")
    public void userClicksRefreshButton() {
        allCarsPage.refreshButton.click();
        allCarsPage.waitUntilLoaderScreenDisappear();
    }

    @Then("Verify that sorts and filters are removed")
    public void verifyThatSortsAndFiltersAreRemoved() {
        Assert.assertEquals(25,allCarsPage.countOfRow.size());
    }


}
