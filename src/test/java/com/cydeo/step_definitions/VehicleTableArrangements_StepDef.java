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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleTableArrangements_StepDef {

AllCarsPage allCarsPage=new AllCarsPage();
    @FindBy(xpath = "//a[contains(@data-size,\"50\")=\"50\"]")
    public WebElement justOneOption;

    @When("user clicks View Per Page button")
    public void user_clicks_view_per_page_button() {
        allCarsPage.ContainsBtn.click();
        BrowserUtils.sleep(4);
    }


    @When("user clicks {int} which are shown")
    public void user_clicks_which_are_shown(Integer expected) {


        for (WebElement webElement : allCarsPage.numbersForFilter) {
            System.out.println("webElement.getAttribute(\"innerText\") = " + webElement.getAttribute("innerText"));
            if (Integer.parseInt(webElement.getAttribute("innerText").trim())==expected){


                System.out.println("These links are correctly located");
            }
            justOneOption.click();
            BrowserUtils.sleep(4);



        }

    }


}
