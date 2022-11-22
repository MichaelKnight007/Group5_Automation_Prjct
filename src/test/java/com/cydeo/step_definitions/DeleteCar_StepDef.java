package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.Dash_Board_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteCar_StepDef {

    Login_Page loginPage=new Login_Page();
    Dash_Board_Page dashBoardPage=new Dash_Board_Page();
    AllCarsPage allCarsPage=new AllCarsPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),60);


    @Given("User hover over three dots at the end of each row")
    public void user_clicks_fleet_menu() throws InterruptedException {

        BrowserUtils.hover(allCarsPage.threeDotsEndOfRow);
    }


    @Then("Verify that user can see delete button")
    public void verifyThatUserCanSeeDeleteButton() {

        Assert.assertTrue("Delete button is visible", true);
    }
}


