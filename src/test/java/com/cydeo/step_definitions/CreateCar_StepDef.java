package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CreateCar_StepDef {

    AllCarsPage allCarsPage=new AllCarsPage();

    @Then("Verify driver cannot see the button")
    public void driver_Cannot_See_Button() {
        try {
            System.out.println("Merhaba");
            Assert.assertFalse(allCarsPage.createCarBtn.isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Driver Cannot Create Car Test is Passed!");
        }
        /*finally {
            System.out.println("Forcefully Driver Cannot Create Car Test is Passed!");
        }*/
        System.out.println("Geçti mi?");

    }


    @But("that the sale manager and store manager can click Create Car button")
    public void verifyThatTheSaleManagerAndStoreManagerSeeButton() {

       Assert.assertTrue( allCarsPage.createCarBtn.isEnabled());

    }



}
