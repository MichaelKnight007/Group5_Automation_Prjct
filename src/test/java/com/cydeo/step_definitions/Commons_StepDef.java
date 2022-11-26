package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.Dash_Board_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Commons_StepDef {

    Login_Page loginPage = new Login_Page();
    Dash_Board_Page dashBoardPage = new Dash_Board_Page();
    AllCarsPage allCarsPage = new AllCarsPage();

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.goLoginPage();
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

    @And("User goes to {string} module and {string} sub-module")
    public void userGoesToModuleAndSubModule(String module, String subModule) {
        loginPage.waitUntilLoaderScreenDisappear();
        dashBoardPage.navigateToModule(module, subModule);
    }

    @Then("Verify that the user is on {string} module")
    public void verifyThatTheUserIsOnModule(String arg0) {
        loginPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(arg0, loginPage.getModuleName());
    }

    @And("User selects a car")
    public void userSelectsACar() {
        BrowserUtils.sleep(5);
        allCarsPage.clickFirstRow();
    }

}
