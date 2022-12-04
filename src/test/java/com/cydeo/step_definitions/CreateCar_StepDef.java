package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.CreateCarBasePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class CreateCar_StepDef {

    AllCarsPage allCarsPage = new AllCarsPage();
    CreateCarBasePage createCarBasePage = new CreateCarBasePage();

    @Then("Verify driver cannot see the button")
    public void driver_Cannot_See_Button() {

        int sizeOfBtn = allCarsPage.createCarBtn.size();

        Assert.assertEquals(0, sizeOfBtn);

    }


    @Then("that the sale manager and store manager can click Create Car button")
    public void verifyThatTheSaleManagerAndStoreManagerSeeButton() {

        Assert.assertTrue(allCarsPage.createCarBtn.get(0).isEnabled());

    }


    @And("User goes to Create Car page")
    public void userGoesToCreateCarPage()  {

        createCarBasePage.clickCreateCarBtn();

    }


    @Then("User creates a car by filling compulsory fields")
    public void userCreatesACarByFillingCompulsoryFields() {

        createCarBasePage.createCar();
        String entitySavedMessageText = createCarBasePage.entitySavedMessage.getText();
        Assert.assertEquals("Entity saved",entitySavedMessageText);

    }


    @Then("User cannot create a car without filling compulsory fields")
    public void userCannotCreateACarWithoutFillingCompulsoryFields() {
        CreateCarBasePage.createCarNegativeTest();
        String entitySavedMessageText = createCarBasePage.entitySavedMessage.getText();
        Assert.assertNotEquals("Entity saved",entitySavedMessageText);
    }


    @Then("User enters Compulsory fields without complying with the conditions")
    public void userEntersInvalidDataToTheCompulsoryFields() {

        List<String> textList = createCarBasePage.compulsoryFieldsCheck();

        // LicencePlateField Assertion
        Assert.assertNotEquals(textList.get(0), textList.get(1));
        System.out.println("License Plate Field Test FAILED!!! ");

        // DriverField Assertion
        Assert.assertNotEquals(textList.get(2), textList.get(3));
        System.out.println("Driver Field Field Test FAILED!!! ");

        // Chassis Number Field Assertion
        Assert.assertEquals("This value should contain only numbers.",textList.get(5));
        System.out.println("Chassis Number Field Test PASSED! ");

        // Model Year Field Assertion
        Assert.assertNotEquals(textList.get(6),textList.get(7));
        System.out.println("Model Year Field Test FAILED!!! ");

        // Tags_Employee Assertion
        createCarBasePage.tags_EmployeeTest();
        boolean tags_EmployeeClicked = createCarBasePage.tags_Employee.isSelected();
        Assert.assertTrue(tags_EmployeeClicked);

        // Tags_JuniorField Assertion
        createCarBasePage.tags_JuniorField();
        boolean tags_JuniorFieldClicked = createCarBasePage.tags_JuniorField.isSelected();
        Assert.assertTrue(tags_JuniorFieldClicked);


        // Manuel Transmission Btn Assertion

        WebElement webElement = createCarBasePage.manuelTransmissionBtnTest();
        Assert.assertEquals(webElement.getAttribute("innerText"),"Manual");

       // Diesel Btn Assertion
        WebElement webElement1 = createCarBasePage.gasolineBtnTest();
        Assert.assertEquals(webElement1.getAttribute("innerText"),"Gasoline");

        // Last Odometer Field Assertion
        Assert.assertNotEquals("This value should contain only numbers.",textList.get(9));
        System.out.println("Last Odometer Field Test PASSED! ");

    }


    @Then("User can select ‘Vehicle Model’ and ‘Vehicle Make’ from the list")
    public void userCanSelectVehicleModelAndVehicleMakeFromTheList() {

        List<Boolean> areVehicle_Model_Make_DoubleSelected=createCarBasePage.vehicleModel_MakeClickableTest();

       Assert.assertFalse(areVehicle_Model_Make_DoubleSelected.get(0));
       Assert.assertFalse(areVehicle_Model_Make_DoubleSelected.get(1));


    }

    @Then("User can see newly created car in ’Fleet-Vehicle’ table")
    public void userCanSeeNewlyCreatedCarInFleetVehicleTable() {

        createCarBasePage.see_Newly_Created_Car_In_Fleet_Vehicle_Table();
        createCarBasePage.licencePlateHeader.click();
        BrowserUtils.sleep(2);
        String createdCarText=createCarBasePage.carCreated.getText();
        Assert.assertEquals("01 DR 805",createdCarText);


    }

    @Then("User enters Optional fields without complying with the conditions")
    public void userEntersOptionalFieldsWithoutComplyingWithTheConditions() {

        List<String> textList = createCarBasePage.optionalFieldsCheck();


        // SeatsNumber Field Assertion
        Assert.assertNotEquals(textList.get(4), textList.get(5));
        System.out.println("Seats Number Assertion NORMALLY \"PASSES\":");

        // DoorsNumber Field Assertion
        Assert.assertNotEquals(textList.get(6), textList.get(7));
        System.out.println("Doors Number Assertion NORMALLY \"PASSES\":");

        // CO_2 Emission Field Assertion
        Assert.assertEquals(textList.get(10), textList.get(11));
        System.out.println("CO_2 Assertion NORMALLY \"PASSES\":");

        // Horse Power Field Assertion
        Assert.assertNotEquals(textList.get(12), textList.get(13));
        System.out.println("Horsepower Assertion NORMALLY \"PASSES\":");

        // Power Field Assertion
        Assert.assertNotEquals(textList.get(16), textList.get(17));
        System.out.println("Power Assertion NORMALLY \"PASSES\"");

        // Horse Power Taxation Field Assertion
        Assert.assertEquals(textList.get(14), textList.get(15));
        System.out.println("Horsepower Taxation Assertion NORMALLY \"PASSES\":");

        // Location Field Assertion
        BrowserUtils.sleep(3);
        Assert.assertEquals("", textList.get(1));
        System.out.println("Location Assertion NORMALLY \"FAILS\":");

        // Catalog Value Field Assertion
        Assert.assertEquals(textList.get(2), textList.get(3));
        System.out.println("Catalog Value Assertion NORMALLY \"FAILS\":");

        // Color Field Assertion
        System.out.println("Color Assertion NORMALLY \"FAILS\":");
        BrowserUtils.sleep(2);
        Assert.assertEquals(textList.get(8), textList.get(9));

        BrowserUtils.sleep(3);

    }
}

