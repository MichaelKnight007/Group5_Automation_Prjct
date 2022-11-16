package com.cydeo.step_definitions;

import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDef {

    Login_Page loginPage = new Login_Page();

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.goLoginPage();
    }
    @When("{string} logs in")
    public void logs_in_on(String userType) {
        loginPage.loginAsUserType(userType);
    }

    @When("User logs in as a {string}")
    public void user_logs_in_as_a(String userType) {
        loginPage.loginAsUserType(userType);
    }
    @Then("Verify that the user is on {string} page")
    public void verify_that_the_user_is_on_page(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(pageTitle, loginPage.getPageName());
    }


}
