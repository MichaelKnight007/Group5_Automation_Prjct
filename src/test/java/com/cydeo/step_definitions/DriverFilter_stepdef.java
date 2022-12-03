package com.cydeo.step_definitions;


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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverFilter_stepdef {
    Login_Page loginPage = new Login_Page();
    Dash_Board_Page dashBoardPage = new Dash_Board_Page();
    AllCarsPage allCarsPage = new AllCarsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);


    @And("User clicks Filter Button")
    public void userClicksFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(allCarsPage.FiltersButton));
        allCarsPage.FiltersButton.click();

    }

    @Given("User select Driver option under ManageFilter dropdown")
    public void user_select_driver_option() {
        wait.until(ExpectedConditions.visibilityOf(allCarsPage.ManageFilterButton));
        allCarsPage.ManageFilterButton.click();
        allCarsPage.Drivercheckbox.click();
    }

    @Given("User clicks Driver All button")
    public void user_clicks_driver_all_button() {
        allCarsPage.DriverAllBtn.click();
    }

    @When("User clicks Contains dropdown")
    public void user_clicks_contains_dropdown() {
        allCarsPage.ContainsBtn.click();

    }

    @Then("User should see all options under Driver Filter Menu")
    public void user_should_see_all_options_under_driver_filter_menu() {
        List<String> ExpectedMethodnames = new ArrayList<>();
        ExpectedMethodnames.addAll(Arrays.asList("contains", "does not contain", "is equal to", "starts with",
                "ends with", "is any of", "is not any of", "is empty", "is not empty"));
        List<String> ActualMethotnames = new ArrayList<>();
        for (WebElement method : allCarsPage.AllMethods) {
            ActualMethotnames.add(method.getAttribute("innerText"));

        }
        Assert.assertEquals(ExpectedMethodnames, ActualMethotnames);
    }

    @And("User enters {string}")
    public void userEnters(String keyword) throws InterruptedException {
        Thread.sleep(2000);
        allCarsPage.searchBox.sendKeys(keyword);

    }

    @When("User selects contains method")
    public void userSelectsContainsMethod() {

        BrowserUtils.clickWithJS(allCarsPage.AllMethods.get(0));
        //  allCarsPage.AllMethods.get(0).click();
    }

    @And("User clicks update button")
    public void userClicksUpdateButton() {
        allCarsPage.updateButton.click();
    }

    @Then("Results should contain {string}")
    public void resultsShouldContain(String keyword) throws InterruptedException {
        allCarsPage.waitUntilLoaderScreenDisappear();
        wait.until(ExpectedConditions.visibilityOfAllElements(allCarsPage.Results));
        List<String> ExpectedResults = new ArrayList<>(List.of(keyword));
        System.out.println("ExpectedResults = " + ExpectedResults);
        List<String> ActualResults = new ArrayList<>();
        Thread.sleep(3000);
        for (WebElement result : allCarsPage.Results) {
            ActualResults.add(result.getAttribute("innerText"));
        }
        Thread.sleep(3000);
        for (String actualresult : ActualResults) {
            System.out.println(actualresult);
            Assert.assertTrue(actualresult.contains(keyword));
        }

    }

    @When("User selects does not contain method")
    public void userSelectsDoesNotContainMethod() {
        allCarsPage.AllMethods.get(1).click();
    }

    @Then("Results should not contain {string}")
    public void resultsShouldNotContain(String keyword) throws InterruptedException {
        Thread.sleep(3000);
        List<String> ActualResults = new ArrayList<>();
        for (WebElement result : allCarsPage.Results) {
            ActualResults.add(result.getAttribute("innerText"));
        }
        Thread.sleep(3000);
        for (String actualResult : ActualResults) {
            Assert.assertFalse(actualResult.contains(keyword));
        }
    }

    @When("User selects Starts with method")
    public void userSelectsStartsWithMethod() {
        allCarsPage.AllMethods.get(3).click();
    }

    @Then("Results should start with specified {string}")
    public void resultsShouldStartWithSpecified(String keyword) throws InterruptedException {
        Thread.sleep(3000);
        List<String> ActualResults = new ArrayList<>();
        for (WebElement actualresult : allCarsPage.Results) {
            ActualResults.add(actualresult.getAttribute("innerText"));
            System.out.println(actualresult);
        }
        Thread.sleep(3000);
        for (String actualResult : ActualResults) {
            System.out.println(actualResult);
            Assert.assertTrue(actualResult.startsWith(keyword));
        }


    }


    @When("User selectsEnds with method")
    public void userSelectsEndsWithMethod() {
        allCarsPage.AllMethods.get(4).click();
    }

    @Then("Results should end with specified {string}")
    public void resultsShouldEndWithSpecified(String keyword) throws InterruptedException {
        Thread.sleep(3000);
        List<String> ActualResults = new ArrayList<>();
        for (WebElement actualresult : allCarsPage.Results) {
            ActualResults.add(actualresult.getAttribute("innerText"));
        }
        Thread.sleep(3000);
        for (String actualResult : ActualResults) {
            Assert.assertTrue(actualResult.endsWith(keyword));
        }
    }


    @When("User selects Is Equal to method")
    public void userSelectsIsEqualToMethod() {
        allCarsPage.AllMethods.get(2).click();
    }


    @Then("Results should match specified {string}")
    public void resultsShouldMatchSpecified(String keyword) throws InterruptedException {
        Thread.sleep(3000);
        List<String> ActualResults = new ArrayList<>();
        for (WebElement actualresult : allCarsPage.Results) {
            ActualResults.add(actualresult.getAttribute("innerText"));
        }
        Thread.sleep(3000);
        for (String actualResult : ActualResults) {
            Assert.assertEquals(actualResult, keyword);
        }
    }


    @When("User selects {string}")
    public void userSelects(String Methodname) {
        allCarsPage.waitUntilLoaderScreenDisappear();
        allCarsPage.selectMethodname(Methodname);
    }

    @Then("Message should be {string}")
    public void messageShouldBe(String warningmessage) throws InterruptedException {
        allCarsPage.waitUntilLoaderScreenDisappear();
        String ExpectedMessage = warningmessage;
        Thread.sleep(5000);
        String ActualMessage = allCarsPage.warningMessage.getText();
        Assert.assertEquals(ExpectedMessage, ActualMessage);

    }



}
