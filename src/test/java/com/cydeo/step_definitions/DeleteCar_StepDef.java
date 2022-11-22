package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.Dash_Board_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteCar_StepDef {

    Login_Page loginPage=new Login_Page();
    AllCarsPage allCarsPage=new AllCarsPage();

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);

    @When("User hover over three dots at the end of each row")
    public void user_hover_over_three_dots_at_the_end_of_each_row() {
        wait.until(ExpectedConditions.elementToBeClickable(allCarsPage.threeDotsEndOfRow));
        BrowserUtils.hover(allCarsPage.threeDotsEndOfRow);
        BrowserUtils.sleep(2);
    }
    @Then("Verify that user can see delete button")
    public void verify_that_user_can_see_delete_button() {
        wait.until(ExpectedConditions.elementToBeClickable(allCarsPage.deleteButton));
        Assert.assertTrue(allCarsPage.deleteButton.isDisplayed());
    }
}


