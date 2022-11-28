package com.cydeo.step_definitions;


import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.Dash_Board_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
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
    public void resultsShouldContain(String keyword) {
        allCarsPage.waitUntilLoaderScreenDisappear();
        wait.until(ExpectedConditions.visibilityOfAllElements(allCarsPage.Results));
        String ExpectedResult = keyword;
        String ActualResult = allCarsPage.Result.getAttribute("innerText");
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
        List<String> ExpectedResults = new ArrayList<>(List.of(keyword));
        System.out.println("ExpectedResults = " + ExpectedResults);
        List<String> ActualResults = new ArrayList<>();
        for (WebElement result : allCarsPage.Results) {
            ActualResults.add(result.getAttribute("innerText"));
            for (int i = 0; i < allCarsPage.Results.size(); i++) {
                ActualResults.add(allCarsPage.Results.get(i).getAttribute("innerText"));
            }
            for (String actualresult : ActualResults) {
                System.out.println(actualresult);
                Assert.assertTrue(actualresult.contains(keyword));
            }
        }

    }

    @When("User selects does not contain method")
    public void userSelectsDoesNotContainMethod() {
        allCarsPage.AllMethods.get(1).click();
    }

    @Then("Results should not contain {string}")
    public void resultsShouldNotContain(String keyword) {
        List<String> ActualResults = new ArrayList<>();
        for (WebElement result : allCarsPage.Results) {
            ActualResults.add(result.getAttribute("innerText"));
        }

        for (String actualresult : ActualResults) {
            if (actualresult.contains(keyword)) {
                System.out.println("TEST FAİLED");
            } else {
                System.out.println("TEST PASSED");
            }
        }
    }

    @When("User selects Starts with method")
    public void userSelectsStartsWithMethod() {
        allCarsPage.AllMethods.get(3).click();
    }

    @Then("Results should start with specified {string}")
    public void resultsShouldStartWithSpecified(String keyword) {
        List<String> ActualResults = new ArrayList<>();
        for (WebElement actualresult : allCarsPage.Results) {
            ActualResults.add(actualresult.getAttribute("innerText"));
        }
        for (String actualResult : ActualResults) {
            if (actualResult.startsWith(keyword)) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAİLED");
            }
        }


    }


    @When("User selectsEnds with method")
    public void userSelectsEndsWithMethod() {
        allCarsPage.AllMethods.get(4).click();
    }

    @Then("Results should end with specified {string}")
    public void resultsShouldEndWithSpecified(String keyword) {
        List<String> ActualResults = new ArrayList<>();
        for (WebElement actualresult : allCarsPage.Results) {
            ActualResults.add(actualresult.getAttribute("innerText"));
        }
        for (String actualResult : ActualResults) {
            if (actualResult.endsWith(keyword)) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAİLED");
            }
        }
    }


    @When("User selects Is Equal to method")
    public void userSelectsIsEqualToMethod() {
        allCarsPage.AllMethods.get(2).click();
    }


    @Then("Results should match specified {string}")
    public void resultsShouldMatchSpecified(String keyword) {
        List<String> ActualResults = new ArrayList<>();
        for (WebElement actualresult : allCarsPage.Results) {
            ActualResults.add(actualresult.getAttribute("innerText"));
        }
        for (String actualResult : ActualResults) {
            if (actualResult.equals(keyword)) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAİLED");
            }
        }
    }


    @When("User selects {string}")
    public void userSelects(String Methodname) {
        allCarsPage.waitUntilLoaderScreenDisappear();
        allCarsPage.selectMethodname(Methodname);
    }

    @Then("Message should be {string}")
    public void messageShouldBe(String warningmessage) {
        allCarsPage.waitUntilLoaderScreenDisappear();
        String ExpectedMessage = warningmessage;
        String ActualMessage = allCarsPage.warningMessage.getText();
        Assert.assertEquals(ExpectedMessage, ActualMessage);

    }


}
