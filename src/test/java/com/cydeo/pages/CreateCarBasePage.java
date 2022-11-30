package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CreateCarBasePage {

    AllCarsPage allCarsPage=new AllCarsPage();
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

    @FindBy(xpath = "//button[.='Today']")
    public WebElement firstContractDateToday;

    @FindBy(name = "custom_entity_type[CatalogValue]")
    public WebElement catalogValueField;

    @FindBy(name = "custom_entity_type[SeatsNumber]")
    public WebElement seatsNumberField;

    @FindBy(name = "custom_entity_type[DoorsNumber]")
    public WebElement doorsNumberField;

    @FindBy(name = "custom_entity_type[Color]")
    public WebElement colorField;

    @FindBy(xpath = "(//span[.='Choose a value...'])[1]")
    public WebElement transmissionDropdown;

    @FindBy(xpath = "//div[.='Manual']")
    public WebElement manuelTransmissonBtn;

    @FindBy(xpath = "(//a[@href='javascript:void(0)'])[2]")
    public WebElement fuelTypeBtn;

    @FindBy(xpath = "//div[.='Gasoline']")
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

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement vehicleMakeAddBtn;

    @FindBy(xpath = "//div[.='Entity saved']")
    public WebElement entitySavedMessage;


    public void clickCreateCarBtn()  {

        AllCarsPage allCarsPage = new AllCarsPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        allCarsPage.waitUntilLoaderScreenDisappear();

        js.executeScript("arguments[0].click();", allCarsPage.createCarLink);


    }

    public void createCar() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        allCarsPage.waitUntilLoaderScreenDisappear();




        createCarBasePage.licencePlateField.sendKeys("45 DR 805");
        createCarBasePage.tags_Employee.click();
        createCarBasePage.tags_JuniorField.click();
        createCarBasePage.tags_Sedan.click();
        createCarBasePage.driverField.sendKeys("Ahmet");
        createCarBasePage.chassisNumberField.sendKeys("1234565897");
        createCarBasePage.modelYearField.sendKeys("2005");
        createCarBasePage.lastOdometerField.sendKeys("20565");
        createCarBasePage.transmissionDropdown.click();
        createCarBasePage.manuelTransmissonBtn.click();
        createCarBasePage.fuelTypeBtn.click();
        createCarBasePage.gasolineBtn.click();


        createCarBasePage.saveAndCloseBtn.click();

    }

    public static void createCarNegativeTest() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.licencePlateField.sendKeys("45 DR 805");
        createCarBasePage.driverField.sendKeys("Ahmet");
        createCarBasePage.transmissionDropdown.click();
        createCarBasePage.manuelTransmissonBtn.click();
        createCarBasePage.saveAndCloseBtn.click();
    }

    public static List<String> licencePlateFieldCheck() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        List<String> licencePlateFieldList = new ArrayList<>();

        String text = "!!45/*DR 805";
        createCarBasePage.licencePlateField.sendKeys(text);//(letters and digits)
        String actualTextOfLicencePlateField = createCarBasePage.licencePlateField.getText();

        licencePlateFieldList.add(text);//expected index 0
        licencePlateFieldList.add(actualTextOfLicencePlateField);//actual index 1

        return licencePlateFieldList;
    }

    public static List<String> driverFieldCheck() {
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        List<String> driverFieldList = new ArrayList<>();

        String text = "Ahmet5684646";
        createCarBasePage.driverField.sendKeys(text);//(letters and digits)
        String actualTextOfDriverField = createCarBasePage.driverField.getText();

        driverFieldList.add(text);//expected index 0
        driverFieldList.add(actualTextOfDriverField);//actual index 1

        return driverFieldList;
    }


    public static List<String> chassisNumberFieldCheck() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();
        List<String> chassisNumberFieldList = new ArrayList<>();


        String expectedchassisNumberFieldText = "12345AADDa!'^+%&";
        createCarBasePage.chassisNumberField.sendKeys(expectedchassisNumberFieldText); //only digits
        String actualTextOfChassisNumberField = createCarBasePage.chassisNumberField.getText();

        chassisNumberFieldList.add(expectedchassisNumberFieldText);//expected index 0
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

    public static List<Boolean> vehicleModel_MakeClickableTest() {

        List<Boolean> vehicleModel_MakeClickableList = new ArrayList<>();
        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.vehicleModelAddBtn.click();
        createCarBasePage.vehicleMakeAddBtn.click();

        boolean vehicleModelClickable = createCarBasePage.vehicleModelAddBtn.isSelected();
        boolean vehicleMakeClickable = createCarBasePage.vehicleMakeAddBtn.isSelected();

        vehicleModel_MakeClickableList.add(vehicleModelClickable);
        vehicleModel_MakeClickableList.add(vehicleMakeClickable);

        return vehicleModel_MakeClickableList;

    }

    public static void checkingCompulsoryFieldsConditions() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        /*List<String> deneme=new ArrayList<>();

        String text="!!45/*DR 805";
        createCarBasePage.licencePlateField.sendKeys(text);//(letters and digits)
        String actualTextOflicencePlateField = createCarBasePage.licencePlateField.getText();
        deneme.add(actualTextOflicencePlateField);*/

       /* createCarBasePage.tags_Employee.click();//Clickable_multiple choices allowed
        boolean tags_EmployeeClicked = createCarBasePage.tags_Employee.isSelected();*/

        /*createCarBasePage.tags_JuniorField.click();//Clickable_multiple choices allowed
        boolean tags_JuniorFieldClicked = createCarBasePage.tags_JuniorField.isSelected();*/

       /* createCarBasePage.driverField.sendKeys("Ahmet5684646");//only letters
        String actualTextOfDriverField = createCarBasePage.driverField.getText();*/

        /*createCarBasePage.chassisNumberField.sendKeys("12345AADDa!'^+%&"); //only digits
        String actualTextOfChassisNumberField = createCarBasePage.chassisNumberField.getText();*/

        /*createCarBasePage.modelYearField.sendKeys("Hey 123549964"); //only digits, only year
        String actualTextOfModelYearField = createCarBasePage.modelYearField.getText();*/

       /* createCarBasePage.lastOdometerField.sendKeys("20565gfsgfd!'^+'^%&"); //only digits
        String actualTextOfLastOdometerField = createCarBasePage.lastOdometerField.getText();*/

        /*createCarBasePage.transmissionDropdown.click();//select from dropdown
        createCarBasePage.manuelTransmissonBtn.click();//select from dropdown
        boolean manuelTransmissonBtnClicked = createCarBasePage.manuelTransmissonBtn.isSelected();*/

        /*createCarBasePage.fuelTypeBtn.click();//select from dropdown
        createCarBasePage.dieselBtn.click();//select from dropdown
        boolean dieselBtnlicked = createCarBasePage.dieselBtn.isSelected();*/
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
