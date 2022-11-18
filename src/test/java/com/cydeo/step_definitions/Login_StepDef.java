package com.cydeo.step_definitions;

import com.cydeo.pages.Dash_Board_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.pages.Quick_Launch_Page;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.BrokenBarrierException;

public class Login_StepDef {

    Login_Page loginPage = new Login_Page();
    Dash_Board_Page dashBoardPage = new Dash_Board_Page();
    Quick_Launch_Page quickLaunchPage = new Quick_Launch_Page();

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
        loginPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(pageTitle, loginPage.getHomePageName());
    }


    @And("User goes to Vehicles")
    public void userGoesToVehicles() {
        dashBoardPage.goToVehicles();
    }

    @Then("Verify that the user is on {string} module")
    public void verifyThatTheUserIsOnModule(String arg0) {
        loginPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(arg0, loginPage.getModuleName());
    }
}
