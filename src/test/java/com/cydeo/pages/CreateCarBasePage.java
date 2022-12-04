package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CreateCarBasePage {

    AllCarsPage allCarsPage = new AllCarsPage();

    public CreateCarBasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='btn-group pull-right']/button")
    public WebElement saveAndCloseBtn;

    @FindBy(name = "custom_entity_type[LicensePlate]")
    public WebElement licencePlateField;

    @FindBy(xpath = "(//input[@name=\"custom_entity_type[Tags][]\"])[1]")
    public WebElement tags_JuniorField;

    @FindBy(xpath = "(//input[@name=\"custom_entity_type[Tags][]\"])[3]")
    public WebElement tags_Employee;

    @FindBy(xpath = "(//input[@name=\"custom_entity_type[Tags][]\"])[6]")
    public WebElement tags_Sedan;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverField;

    @FindBy(name = "custom_entity_type[Location]")
    public WebElement locationField;

    @FindBy(name = "custom_entity_type[ChassisNumber]")
    public WebElement chassisNumberField;

    @FindBy(name = "custom_entity_type[ModelYear]")
    public WebElement modelYearField;

    @FindBy(name = "custom_entity_type[LastOdometer]")
    public WebElement lastOdometerField;

    @FindBy(name = "date_selector_custom_entity_type_ImmatriculationDate-uid-6385e61ab278e")
    public WebElement immatriculationDateField;

    @FindBy(xpath = "(//a[@class='ui-state-default'])[24]")
    public WebElement immatriculationDateOption;

    @FindBy(name = "date_selector_custom_entity_type_FirstContractDate-uid-6385e61ab28c9")
    public WebElement firstContractDateField;

    @FindBy(xpath = "//button[text()='Today']")
    public WebElement firstContractDateToday;

    @FindBy(name = "custom_entity_type[CatalogValue]")
    public WebElement catalogValueField;

    @FindBy(name = "custom_entity_type[SeatsNumber]")
    public WebElement seatsNumberField;

    @FindBy(name = "custom_entity_type[DoorsNumber]")
    public WebElement doorsNumberField;

    @FindBy(name = "custom_entity_type[Color]")
    public WebElement colorField;

    @FindBy(xpath = "(//span[text()='Choose a value...'])[1]")
    public WebElement transmissionDropdown;

    // @FindBy(xpath = "//div[text()='Manual']")
    // @FindBy(xpath = "(//div[@class='select2-result-label'])[1]")
    @FindBy(xpath = "(//ul[@class='select2-results']/li)[1]")
    public WebElement manuelTransmissionBtn;

    @FindBy(xpath = "(//a[@href='javascript:void(0)'])[2]")
    public WebElement fuelTypeBtn;

    @FindBy(xpath = "//div[text()='Gasoline']")
    public WebElement gasolineBtn;

    @FindBy(name = "custom_entity_type[CO2Emissions]")
    public WebElement cO2EmissionsField;

    @FindBy(name = "custom_entity_type[Horsepower]")
    public WebElement horsepowerField;

    @FindBy(name = "custom_entity_type[HorsepowerTaxation]")
    public WebElement horsepowerTaxationField;

    @FindBy(name = "custom_entity_type[Power]")
    public WebElement powerField;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement vehicleModelAddBtn;

    @FindBy(xpath = "//td[text()='BMW']")
    public WebElement vehicleModelBMWAddBtn;

    @FindBy(xpath = "//button[text()='Select']")
    public WebElement selectBtn;

    @FindBy(xpath = "//a[text()='BMW ']")
    public WebElement vehicleModelBMWText;

    @FindBy(xpath = "(//input[@class='default-selector'])[1]")
    public WebElement BMWSelectBtn;

    @FindBy(xpath = "(//input[@class='default-selector'])[2]")
    public WebElement MercedesSelectBtn;

    @FindBy(xpath = "//td[text()='Mercedes']")
    public WebElement vehicleModelMercedesAddBtn;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement vehicleMakeAddBtn;

    @FindBy(xpath = "//td[text()='Tesla']")
    public WebElement vehicleMakeTeslaAddBtn;

    @FindBy(xpath = "//a[text()='Tesla ']")
    public WebElement vehicleMakeTeslaText;

    @FindBy(xpath = "//td[text()='Opel']")
    public WebElement vehicleMakeTOpelAddBtn;

    @FindBy(xpath = "(//input[@class='default-selector'])[3]")
    public WebElement teslaSelectBtn;

    @FindBy(xpath = "(//input[@class='default-selector'])[4]")
    public WebElement opelSelectBtn;

    @FindBy(xpath = "//div[text()='Entity saved']")
    public WebElement entitySavedMessage;

    @FindBy(xpath = "//span[text()='License Plate']")
    public WebElement licencePlateHeader;

    @FindBy(xpath = "(//td[@data-column-label='License Plate'])[3]")
    public WebElement carCreated;

    @FindBy(xpath = "(//div[@class='controls']/div)[1]")
    public WebElement controlsLicensePlate;

    @FindBy(xpath = "(//div[@class='controls']/div)[3]")
    public WebElement controlsDriver;

    @FindBy(xpath = "(//div[@class='controls']/div)[5]")
    public WebElement controlsChasisNumber;

    @FindBy(xpath = "(//div[@class='controls']/div)[6]")
    public WebElement controlsModelYear;

    @FindBy(xpath = "(//div[@class='controls']/div)[7]")
    public WebElement controlsLastOdometer;

    @FindBy(xpath = "(//div[@class='controls']/div)[4]")
    public WebElement controlsLocation;

    @FindBy(xpath = "(//div[@class='controls']/div)[10]")
    public WebElement controlsCatalogValue;

    @FindBy(xpath = "(//div[@class='controls']/div)[11]")
    public WebElement controlsSeatNumber;

    @FindBy(xpath = "(//div[@class='controls']/div)[12]")
    public WebElement controlsDoorNumber;

    @FindBy(xpath = "(//div[@class='controls']/div)[13]")
    public WebElement controlsColor;

    @FindBy(xpath = "(//div[@class='controls']/div)[16]")
    public WebElement controlsCO_2_Emisson;

    @FindBy(xpath = "(//div[@class='controls']/div)[17]")
    public WebElement controlsHorsePower;

    @FindBy(xpath = "(//div[@class='controls']/div)[18]")
    public WebElement controlsHorsePowerTaxation;

    @FindBy(xpath = "(//div[@class='controls']/div)[19]")
    public WebElement controlsPower;

    @FindBy(xpath = "(//span[text()='This value is not valid.'])[1]")
    public WebElement warningMessage_CatalogValue;

    @FindBy(xpath = "(//span[text()='This value is not valid.'])[2]")
    public WebElement warningMessage_CO_2Emissions;

    @FindBy(xpath = "(//span[text()='This value is not valid.'])[3]")
    public WebElement warningMessage_Horsepower_Taxation;

    @FindBy(xpath = "(//span[text()='This value should contain only numbers.'])[1]")
    public WebElement warningMessage_ChassisNumber;

    @FindBy(xpath = "(//span[text()='This value should contain only numbers.'])[2]")
    public WebElement warningMessage_LastOdometer;


    public void clickCreateCarBtn() {

        AllCarsPage allCarsPage = new AllCarsPage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        allCarsPage.waitUntilLoaderScreenDisappear();

        js.executeScript("arguments[0].click();", allCarsPage.createCarLink);


    }

    public void createCar() {

        allCarsPage.waitUntilLoaderScreenDisappear();

        licencePlateField.sendKeys("01 DR 805");
        tags_Employee.click();
        tags_JuniorField.click();
        tags_Sedan.click();
        driverField.sendKeys("Hasan Ali");
        chassisNumberField.sendKeys("1234565897");
        modelYearField.sendKeys("2005");
        lastOdometerField.sendKeys("15500");
        transmissionDropdown.click();
        manuelTransmissionBtn.click();
        fuelTypeBtn.click();
        gasolineBtn.click();

        saveAndCloseBtn.click();
    }

    public static void createCarNegativeTest() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.licencePlateField.sendKeys("38 DR 805");
        createCarBasePage.driverField.sendKeys("Mehmet");
        createCarBasePage.transmissionDropdown.click();
        createCarBasePage.manuelTransmissionBtn.click();
        createCarBasePage.saveAndCloseBtn.click();
    }

    public List<String> compulsoryFieldsCheck() {

        List<String> compulsoryFieldCheckList = new ArrayList<>();

        String textLicensePlateField = "!!45/*DR 805";
        String textDriverField = "Ahmet!'!4646";
        String textChassisNumberField = "446ASDFG!'^+";
        String textModelYearField = "145265!'^+%asdf";
        String textLastOdometerField = "646e+fghj/&%";


        licencePlateField.sendKeys(textLicensePlateField);//(letters and digits)
        driverField.sendKeys(textDriverField); //(letters only)
        modelYearField.sendKeys(textModelYearField);
        lastOdometerField.sendKeys(textLastOdometerField);//digits only)
        chassisNumberField.sendKeys(textChassisNumberField);//digits only)

        saveAndCloseBtn.click();
        allCarsPage.waitUntilLoaderScreenDisappear();

        String actualTextOfLicencePlateField = licencePlateField.getAttribute("innerText");
        String actualTextOfDrivetField = driverField.getText();
        String actualTextOfChasisNumberField = warningMessage_ChassisNumber.getText();
        String actualTextOfModelYearField = modelYearField.getText();
        String actualTextOfLastOdometerField = warningMessage_LastOdometer.getText();


        compulsoryFieldCheckList.add(textLicensePlateField);//expected index 0
        compulsoryFieldCheckList.add(actualTextOfLicencePlateField);//Actual index 1

        compulsoryFieldCheckList.add(textDriverField);//expected index 2
        compulsoryFieldCheckList.add(actualTextOfDrivetField);//Actual index 3

        compulsoryFieldCheckList.add(textChassisNumberField);//expected index 4
        compulsoryFieldCheckList.add(actualTextOfChasisNumberField);//Actual index 5

        compulsoryFieldCheckList.add(textModelYearField);//expected index 6
        compulsoryFieldCheckList.add(actualTextOfModelYearField);//Actual index 7

        compulsoryFieldCheckList.add(textLastOdometerField);//expected index 8
        compulsoryFieldCheckList.add(actualTextOfLastOdometerField);//Actual index 9

        return compulsoryFieldCheckList;
    }


    public List<String> optionalFieldsCheck() {

        List<String> optionlaFieldCheckList = new ArrayList<>();

        String textLocationField = "!!05/*DR/*-785";
        String textCatalogValue = "Mehmet!'!7896";
        String textSeatNumber = "446ASDFG!'^+";
        String textDoorsNumber = "145265!'^+%asdf";
        String textOfColor = "323fghjAF/&%";
        String textOfCO_2_Emission = "6564fghj/&%";
        String textOfHorsePower = "5987fghj/&%";
        String textHorsePowerTaxation = "6987fghj/&%";
        String textPower = "6746fghj/&%";

        locationField.sendKeys(textLocationField);//Letters and digits
        catalogValueField.sendKeys(textCatalogValue);//(only digits)
        seatsNumberField.sendKeys(textSeatNumber);//(only digits)
        doorsNumberField.sendKeys(textDoorsNumber);//(only digits)
        colorField.sendKeys(textOfColor); // only letters
        cO2EmissionsField.sendKeys(textOfCO_2_Emission);//(only digits)
        horsepowerField.sendKeys(textOfHorsePower);//(only digits)
        horsepowerTaxationField.sendKeys(textHorsePowerTaxation);//(only digits)
        powerField.sendKeys(textPower);//(only digits)

        BrowserUtils.sleep(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", saveAndCloseBtn);

        // createCarBasePage.saveAndCloseBtn.click();
        allCarsPage.waitUntilLoaderScreenDisappear();

        // String locationFieldActualText = createCarBasePage.locationField.getAttribute("innerText");//Not Equals
        String locationFieldActualText = locationField.getText();
        String warningMessageCatalogValueText = warningMessage_CatalogValue.getText();// Not Equals
        String seatsNumberActualText = seatsNumberField.getText();// Not equals
        String doorsNumberActualText = doorsNumberField.getText();//Not equals
        String colorActualText = colorField.getText();// Not equals
        String warningMessage_co_2EmissionsText = warningMessage_CO_2Emissions.getText(); //Not equals
        String horsePowerActualText = horsepowerField.getText(); // Not equals
        String warningMessage_horsepower_taxationText = warningMessage_Horsepower_Taxation.getText(); // Not equals
        String powerActualText = powerField.getText(); //Not equals

        optionlaFieldCheckList.add(textLocationField);//Index 0
        optionlaFieldCheckList.add(locationFieldActualText);//Index 1

        optionlaFieldCheckList.add("This value is not valid.");//Index 3
        optionlaFieldCheckList.add(warningMessageCatalogValueText);//Index 4

        optionlaFieldCheckList.add(textSeatNumber);//Index 5
        optionlaFieldCheckList.add(seatsNumberActualText);//Index 6

        optionlaFieldCheckList.add(textDoorsNumber);//Index 7
        optionlaFieldCheckList.add(doorsNumberActualText);//Index 8

        optionlaFieldCheckList.add(textOfColor);//Index 9
        optionlaFieldCheckList.add(colorActualText);//Index 10

        optionlaFieldCheckList.add("This value is not valid.");//Index 11
        optionlaFieldCheckList.add(warningMessage_co_2EmissionsText);//Index 12

        optionlaFieldCheckList.add(textOfHorsePower);//Index 13
        optionlaFieldCheckList.add(horsePowerActualText);//Index 14

        optionlaFieldCheckList.add("This value is not valid.");//Index 15
        optionlaFieldCheckList.add(warningMessage_horsepower_taxationText);//Index 16

        optionlaFieldCheckList.add(textPower);//Index 17
        optionlaFieldCheckList.add(powerActualText);//Index 18

        return optionlaFieldCheckList;
    }

    public boolean tags_EmployeeTest() {

        tags_Employee.click();//Clickable_multiple choices allowed
        boolean tags_EmployeeClicked = tags_Employee.isSelected();

        return tags_EmployeeClicked;
    }


    public boolean tags_JuniorField() {

        tags_JuniorField.click();//Clickable_multiple choices allowed
        boolean tags_JuniorClicked = tags_JuniorField.isSelected();

        return tags_JuniorClicked;
    }


    public WebElement manuelTransmissionBtnTest() {

        transmissionDropdown.click();//select from dropdown
        manuelTransmissionBtn.click();

        BrowserUtils.sleep(1);

        By by=By.xpath("(//span[@class='select2-chosen'])[1]");
        WebElement element = Driver.getDriver().findElement(by);
        return element;
    }


    public WebElement gasolineBtnTest() {

        fuelTypeBtn.click();//select from dropdown
        gasolineBtn.click();//select from dropdown
        By by=By.xpath("(//span[@class='select2-chosen'])[2]");
        WebElement element = Driver.getDriver().findElement(by);
        return element;
    }

    public List<Boolean> vehicleModel_MakeClickableTest() {

        List<Boolean> vehicleModel_MakeClickableList = new ArrayList<>();

        allCarsPage.waitUntilLoaderScreenDisappear();

        vehicleModelAddBtn.click();
        vehicleModelBMWAddBtn.click();

        BrowserUtils.sleep(2);
        selectBtn.click();

        vehicleModelAddBtn.click();
        vehicleModelMercedesAddBtn.click();
        BrowserUtils.sleep(2);
        selectBtn.click();

        vehicleMakeAddBtn.click();
        vehicleMakeTeslaAddBtn.click();
        BrowserUtils.sleep(2);
        selectBtn.click();

        vehicleMakeAddBtn.click();
        vehicleMakeTOpelAddBtn.click();
        BrowserUtils.sleep(2);
        selectBtn.click();

        BMWSelectBtn.click();
        MercedesSelectBtn.click();

        boolean isBMWSelected = BMWSelectBtn.isSelected();

        teslaSelectBtn.click();
        opelSelectBtn.click();

        boolean isTeslaSelected = teslaSelectBtn.isSelected();

        vehicleModel_MakeClickableList.add(isBMWSelected);
        vehicleModel_MakeClickableList.add(isTeslaSelected);

        return vehicleModel_MakeClickableList;

    }

    public String see_Newly_Created_Car_In_Fleet_Vehicle_Table() {
        Dash_Board_Page dash_board_page = new Dash_Board_Page();
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        dash_board_page.fleetDropdownBtn.click();
        dash_board_page.vehiclesLink.click();

        String createdCarText = createCarBasePage.carCreated.getText();

        return createdCarText;
    }


  /*  public void checkingOptionalFieldsConditions() {


       locationField.sendKeys("!'^+%&&&ASAS15616");//letters and digits
        String locationFieldActualText = locationField.getText();

        immatriculationDateField.click();//any date from calendar pop up
        immatriculationDateOption.click();
        boolean immatriculationDateIsSelected = immatriculationDateOption.isSelected();

       firstContractDateField.click();//any date from calendar pop up
       firstContractDateToday.click();
        boolean firstContractDateTodayIsSelected = firstContractDateToday.isSelected();

        catalogValueField.sendKeys("1322ndsladnl'!^+%&/(");//only digits
        String catalogValueFieldActualText = catalogValueField.getText();

       seatsNumberField.sendKeys("ASDFGH!'^+%45164");//only digits
        String seatsNumberFieldActualText = seatsNumberField.getText();

        doorsNumberField.sendKeys("146846ASDFGHJK!'^+%&/");//only digits
        String doorsNumberFieldActualText = doorsNumberField.getText();

        colorField.sendKeys("ASDFG!'^+464");//only letters
        String colorFieldActualText = colorField.getText();

        cO2EmissionsField.sendKeys();//only digits
        String cO2EmissionsFieldActualText = cO2EmissionsField.getText();

        horsepowerField.sendKeys("ADggy!'^+%&/75414");//only digits
        String horsepowerFieldActualText = horsepowerField.getText();

        horsepowerTaxationField.sendKeys();//only digits
        String horsepowerTaxationFieldActualText = horsepowerTaxationField.getText();

       powerField.sendKeys("ASDFGHJ!'^+%&/146462");//only digits
        String powerFieldActualText = powerField.getText();

    }*/

     /*  public void locationFieldTest() {

        List<String> locationFieldList = new ArrayList<>();
        String expectedlocationFieldText = "!'^+%&&&ASAS15616";
        locationField.sendKeys(expectedlocationFieldText);//letters and digits
        String locationFieldActualText = locationField.getText();

        locationFieldList.add(expectedlocationFieldText);
        locationFieldList.add(locationFieldActualText);

    }*/

   /* public List<String> driverFieldCheck() {

        List<String> driverFieldList = new ArrayList<>();

        String text = "Ahmet5684646";
        driverField.sendKeys(text);//(letters only)
        String actualTextOfDriverField = driverField.getText();

        driverFieldList.add(text);//expected index 0
        driverFieldList.add(actualTextOfDriverField);//actual index 1

        return driverFieldList;
    }*/


   /* public List<String> chassisNumberFieldCheck() {

        List<String> chassisNumberFieldList = new ArrayList<>();


        String expectedChassisNumberFieldText = "12345AADDa!'^+%&";
       chassisNumberField.sendKeys(expectedChassisNumberFieldText); //only digits
        String actualTextOfChassisNumberField = chassisNumberField.getText();

        chassisNumberFieldList.add(expectedChassisNumberFieldText);//expected index 0
        chassisNumberFieldList.add(actualTextOfChassisNumberField);//actual index 1

        return chassisNumberFieldList;
    }*/


    /*public List<String> modelYearFieldCheck() {


        List<String> modelYearFieldList = new ArrayList<>();


        String expectedModelYearFieldText = "12345AADDa!'^+%&";
        modelYearField.sendKeys(expectedModelYearFieldText); //only digits, only year
        String actualTextOfModelYearField = modelYearField.getText();

        modelYearFieldList.add(expectedModelYearFieldText);//expected index 0
        modelYearFieldList.add(actualTextOfModelYearField);//actual index 1

        return modelYearFieldList;
    }*/


   /* public List<String> lastOdometerFieldCheck() {


        List<String> lastOdometerFieldList = new ArrayList<>();


        String expectedLastOdometerFieldText = "12345AADDa!'^+%&";
       lastOdometerField.sendKeys(expectedLastOdometerFieldText); //only digits
        String actualTextOfLastOdometerField = lastOdometerField.getText();

        lastOdometerFieldList.add(expectedLastOdometerFieldText);//expected index 0
        lastOdometerFieldList.add(actualTextOfLastOdometerField);//actual index 1

        return lastOdometerFieldList;
    }*/



}
