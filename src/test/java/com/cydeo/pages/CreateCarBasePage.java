package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
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

    @FindBy(xpath = "//div[text()='Manual']")
    public WebElement manuelTransmissonBtn;

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
    public WebElement vehicleMakeTeslaTex;

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


    public void clickCreateCarBtn() {

        AllCarsPage allCarsPage = new AllCarsPage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        allCarsPage.waitUntilLoaderScreenDisappear();

        js.executeScript("arguments[0].click();", allCarsPage.createCarLink);


    }

    public void createCar() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        allCarsPage.waitUntilLoaderScreenDisappear();


        createCarBasePage.licencePlateField.sendKeys("01 DR 805");
        createCarBasePage.tags_Employee.click();
        createCarBasePage.tags_JuniorField.click();
        createCarBasePage.tags_Sedan.click();
        createCarBasePage.driverField.sendKeys("Hasan Ali");
        createCarBasePage.chassisNumberField.sendKeys("1234565897");
        createCarBasePage.modelYearField.sendKeys("2005");
        createCarBasePage.lastOdometerField.sendKeys("15500");
        createCarBasePage.transmissionDropdown.click();
        createCarBasePage.manuelTransmissonBtn.click();
        createCarBasePage.fuelTypeBtn.click();
        createCarBasePage.gasolineBtn.click();

        createCarBasePage.saveAndCloseBtn.click();

    }

    public static void createCarNegativeTest() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.licencePlateField.sendKeys("38 DR 805");
        createCarBasePage.driverField.sendKeys("Mehmet");
        createCarBasePage.transmissionDropdown.click();
        createCarBasePage.manuelTransmissonBtn.click();
        createCarBasePage.saveAndCloseBtn.click();
    }

    public List<String> licencePlateFieldCheck() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        List<String> licencePlateFieldList = new ArrayList<>();

        String textLicensePlateField = "!!45/*DR 805";
        String textDriverField = "Ahmet!'!4646";
        String textChassisNumberField = "446ASDFG!'^+";
        String textModelYearField = "145265!'^+%asdf";
        String textLastOdometerField = "646fghj/&%";


        createCarBasePage.licencePlateField.sendKeys(textLicensePlateField);//(letters and digits)
        createCarBasePage.driverField.sendKeys(textDriverField); //(letters only)
        createCarBasePage.modelYearField.sendKeys(textModelYearField);
        createCarBasePage.lastOdometerField.sendKeys(textLastOdometerField);
        createCarBasePage.chassisNumberField.sendKeys(textChassisNumberField);//digits only)

        createCarBasePage.saveAndCloseBtn.click();
        allCarsPage.waitUntilLoaderScreenDisappear();

        String actualTextOfLicencePlateField = createCarBasePage.controlsLicensePlate.getText();
        String actualTextOfDrivetField = createCarBasePage.controlsDriver.getText();
        String actualTextOfChasisNumberField = createCarBasePage.controlsChasisNumber.getText();
        String actualTextOfModelYearField = createCarBasePage.controlsModelYear.getText();
        String actualTextOfLastOdometerField = createCarBasePage.controlsLastOdometer.getText();


        licencePlateFieldList.add(textLicensePlateField);//expected index 0
        licencePlateFieldList.add(actualTextOfLicencePlateField);//Actual index 1

        licencePlateFieldList.add(textDriverField);//expected index 2
        licencePlateFieldList.add(actualTextOfDrivetField);//Actual index 3

        licencePlateFieldList.add(textChassisNumberField);//expected index 4
        licencePlateFieldList.add(actualTextOfChasisNumberField);//Actual index 5

        licencePlateFieldList.add(textModelYearField);//expected index 6
        licencePlateFieldList.add(actualTextOfModelYearField);//Actual index 7

        licencePlateFieldList.add(textLastOdometerField);//expected index 8
        licencePlateFieldList.add(actualTextOfLastOdometerField);//Actual index 9



        return licencePlateFieldList;
    }

    public static List<String> driverFieldCheck() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        List<String> driverFieldList = new ArrayList<>();

        String text = "Ahmet5684646";
        createCarBasePage.driverField.sendKeys(text);//(letters only)
        String actualTextOfDriverField = createCarBasePage.driverField.getText();

        driverFieldList.add(text);//expected index 0
        driverFieldList.add(actualTextOfDriverField);//actual index 1

        return driverFieldList;
    }


    public static List<String> chassisNumberFieldCheck() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();
        List<String> chassisNumberFieldList = new ArrayList<>();


        String expectedChassisNumberFieldText = "12345AADDa!'^+%&";
        createCarBasePage.chassisNumberField.sendKeys(expectedChassisNumberFieldText); //only digits
        String actualTextOfChassisNumberField = createCarBasePage.chassisNumberField.getText();

        chassisNumberFieldList.add(expectedChassisNumberFieldText);//expected index 0
        chassisNumberFieldList.add(actualTextOfChassisNumberField);//actual index 1

        return chassisNumberFieldList;
    }


    public static List<String> modelYearFieldCheck() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();
        List<String> modelYearFieldList = new ArrayList<>();


        String expectedModelYearFieldText = "12345AADDa!'^+%&";
        createCarBasePage.modelYearField.sendKeys(expectedModelYearFieldText); //only digits, only year
        String actualTextOfModelYearField = createCarBasePage.modelYearField.getText();

        modelYearFieldList.add(expectedModelYearFieldText);//expected index 0
        modelYearFieldList.add(actualTextOfModelYearField);//actual index 1

        return modelYearFieldList;
    }


    public static List<String> lastOdometerFieldCheck() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();
        List<String> lastOdometerFieldList = new ArrayList<>();


        String expectedLastOdometerFieldText = "12345AADDa!'^+%&";
        createCarBasePage.lastOdometerField.sendKeys(expectedLastOdometerFieldText); //only digits
        String actualTextOfLastOdometerField = createCarBasePage.lastOdometerField.getText();

        lastOdometerFieldList.add(expectedLastOdometerFieldText);//expected index 0
        lastOdometerFieldList.add(actualTextOfLastOdometerField);//actual index 1

        return lastOdometerFieldList;
    }


    public static boolean tags_EmployeeTest() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.tags_Employee.click();//Clickable_multiple choices allowed
        boolean tags_EmployeeClicked = createCarBasePage.tags_Employee.isSelected();

        return tags_EmployeeClicked;
    }


    public static boolean tags_JuniorField() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.tags_JuniorField.click();//Clickable_multiple choices allowed
        boolean tags_JuniorClicked = createCarBasePage.tags_JuniorField.isSelected();

        return tags_JuniorClicked;
    }


    public static boolean manuelTransmissionBtnTest() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.transmissionDropdown.click();//select from dropdown
        createCarBasePage.manuelTransmissonBtn.click();//select from dropdown
        boolean manuelTransmissonBtnClicked = createCarBasePage.manuelTransmissonBtn.isSelected();

        return manuelTransmissonBtnClicked;
    }


    public static boolean gasolineBtnTest() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.fuelTypeBtn.click();//select from dropdown
        createCarBasePage.gasolineBtn.click();//select from dropdown
        boolean gasolineBtnlicked = createCarBasePage.gasolineBtn.isSelected();


        return gasolineBtnlicked;
    }

    public List<Boolean> vehicleModel_MakeClickableTest() {

        List<Boolean> vehicleModel_MakeClickableList = new ArrayList<>();
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        allCarsPage.waitUntilLoaderScreenDisappear();

        createCarBasePage.vehicleModelAddBtn.click();
        createCarBasePage.vehicleModelBMWAddBtn.click();

        BrowserUtils.sleep(2);
        createCarBasePage.selectBtn.click();

        createCarBasePage.vehicleModelAddBtn.click();
        createCarBasePage.vehicleModelMercedesAddBtn.click();
        BrowserUtils.sleep(2);
        createCarBasePage.selectBtn.click();


        createCarBasePage.vehicleMakeAddBtn.click();
        createCarBasePage.vehicleMakeTeslaAddBtn.click();
        BrowserUtils.sleep(2);
        createCarBasePage.selectBtn.click();

        createCarBasePage.vehicleMakeAddBtn.click();
        createCarBasePage.vehicleMakeTOpelAddBtn.click();
        BrowserUtils.sleep(2);
        createCarBasePage.selectBtn.click();


        createCarBasePage.BMWSelectBtn.click();
        createCarBasePage.MercedesSelectBtn.click();

        boolean isBMWSelected = createCarBasePage.BMWSelectBtn.isSelected();

        createCarBasePage.teslaSelectBtn.click();
        createCarBasePage.opelSelectBtn.click();

        boolean isTeslaSelected = createCarBasePage.teslaSelectBtn.isSelected();


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


    public static void locationFieldTest() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        List<String> locationFieldList = new ArrayList<>();
        String expectedlocationFieldText = "!'^+%&&&ASAS15616";
        createCarBasePage.locationField.sendKeys(expectedlocationFieldText);//letters and digits
        String locationFieldActualText = createCarBasePage.locationField.getText();

        locationFieldList.add(expectedlocationFieldText);
        locationFieldList.add(locationFieldActualText);


    }

    public static void checkingOptionalFieldsConditions() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.locationField.sendKeys("!'^+%&&&ASAS15616");//letters and digits
        String locationFieldActualText = createCarBasePage.locationField.getText();

        createCarBasePage.immatriculationDateField.click();//any date from calendar pop up
        createCarBasePage.immatriculationDateOption.click();
        boolean immatriculationDateIsSelected = createCarBasePage.immatriculationDateOption.isSelected();

        createCarBasePage.firstContractDateField.click();//any date from calendar pop up
        createCarBasePage.firstContractDateToday.click();
        boolean firstContractDateTodayIsSelected = createCarBasePage.firstContractDateToday.isSelected();

        createCarBasePage.catalogValueField.sendKeys("1322ndsladnl'!^+%&/(");//only digits
        String catalogValueFieldActualText = createCarBasePage.catalogValueField.getText();

        createCarBasePage.seatsNumberField.sendKeys("ASDFGH!'^+%45164");//only digits
        String seatsNumberFieldActualText = createCarBasePage.seatsNumberField.getText();

        createCarBasePage.doorsNumberField.sendKeys("146846ASDFGHJK!'^+%&/");//only digits
        String doorsNumberFieldActualText = createCarBasePage.doorsNumberField.getText();

        createCarBasePage.colorField.sendKeys("ASDFG!'^+464");//only letters
        String colorFieldActualText = createCarBasePage.colorField.getText();

        createCarBasePage.cO2EmissionsField.sendKeys();//only digits
        String cO2EmissionsFieldActualText = createCarBasePage.cO2EmissionsField.getText();

        createCarBasePage.horsepowerField.sendKeys("ADggy!'^+%&/75414");//only digits
        String horsepowerFieldActualText = createCarBasePage.horsepowerField.getText();

        createCarBasePage.horsepowerTaxationField.sendKeys();//only digits
        String horsepowerTaxationFieldActualText = createCarBasePage.horsepowerTaxationField.getText();

        createCarBasePage.powerField.sendKeys("ASDFGHJ!'^+%&/146462");//only digits
        String powerFieldActualText = createCarBasePage.powerField.getText();

    }


}
