package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class AllCarsPage extends BasePage {

    @FindBy(xpath = "//a[@class='action btn mode-icon-only']")
    public WebElement FiltersButton;
    @FindBy(xpath = "//button[@class='ui-multiselect ui-corner-all select-filter-widget']")
    public WebElement ManageFilterButton;
    @FindBy(xpath = "//select[@data-action='add-filter-select']")
    public WebElement manageFilterDropdown;
    @FindBy(xpath = "//input[@id=\'ui-multiselect-0-0-option-2\']")
    public WebElement Drivercheckbox;
    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement DriverAllBtn;
    @FindBy(xpath = "//button[@class='btn dropdown-toggle']")
    public WebElement ContainsBtn;
    @FindBy(xpath = "//a[@class='dropdown-item choice-value']")
    public List<WebElement> AllMethods;
    @FindBy(xpath = "//input[@name='value']")
    public WebElement searchBox;
    @FindBy(xpath = "//button[@class='btn btn-primary filter-update']")
    public WebElement updateButton;

    @FindBy(xpath = "//tbody[@class='grid-body']//tr//td[4]")
    public List<WebElement> DriverNames;


    @FindBy(xpath = "//div[@class='dropdown']//*[text()='...']")
    public WebElement threeDot;

    @FindBy(css = "li.launcher-item a[title='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//h3[text()='Delete Confirmation']")
    public WebElement deleteConfirmationText;

    @FindBy(css = "div.message")
    public WebElement message;

    @FindBy(xpath = "//a[.='Yes, Delete']")
    private WebElement yesDeleteBtn;

    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteCarButton;


    @FindBy(xpath = "//tr[@class='grid-row row-click-action'][5]")
    public WebElement anyRow;

    @FindBy(xpath = "//a[contains(@class,\"dropdown-item\")]")
    public List<WebElement> numbersForFilter;

    @FindBy(css = "tr.grid-row")
    public List<WebElement> countOfRow;

    @FindBy(xpath = "//a[@title='Create Car']")
    public List<WebElement> createCarBtn;

    @FindBy(xpath = "//a[@title=\"Reset\"]/i")
    public WebElement refreshButton;


    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gridSettings;

    @FindBy(xpath = "//div[.='Grid Settings']")
    public WebElement gridSettingsTitle;

    @FindBy(css = "li.launcher-item a[title='View']")
    public WebElement viewButton;


    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarLink;
    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement allCarsTitle;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement manageFiltersSearchInputBox;
    @FindBy(id = "ui-multiselect-0-0-option-6")
    public WebElement lastOdometerCheckbox;
    @FindBy(xpath = "//span[@class='filter-items']")
    public WebElement lastOdometerDropdownButton;
    @FindBy(xpath = "//div[@class='btn-group btn-block']//button")
    public WebElement lastOdometerFilterDropdownButton;

    @FindBy(xpath = "//div[@class='choice-filter number-range-filter']//ul[@class='dropdown-menu']")
    public WebElement lastOdometerFilterDropdownItems;

    @FindBy(xpath = "//a[.='between']")
    public WebElement betweenMethod;
    @FindBy(xpath = "//a[.='not between']")
    public WebElement notBetweenMethod;
    @FindBy(xpath = "//a[.='equals']")
    public WebElement equalsMethod;
    @FindBy(xpath = "//a[.='not equals']")
    public WebElement notEqualsMethod;
    @FindBy(xpath = "//a[.='more than']")
    public WebElement moreThanMethod;
    @FindBy(xpath = "//a[.='less than']")
    public WebElement lessThanMethod;
    @FindBy(xpath = "//a[.='equals or more than']")
    public WebElement eqOrMoreMethod;
    @FindBy(xpath = "//a[.='equals or less than']")
    public WebElement eqOrLessMethod;
    @FindBy(xpath = "//a[.='is empty']")
    public WebElement isEmptyMethod;
    @FindBy(xpath = "//a[.='less than']")
    public WebElement isNotEmptyethod;

    @FindBy(xpath = "//input[@name='value']")
    public WebElement lastOdoMFilterFirstInput;
    @FindBy(xpath = "//input[@name='value_end']")
    public WebElement lastOdoMFilterSecondInput;
    @FindBy(xpath = "//button[.='Update']")
    public WebElement lastOdoMFilterUpdateButton;

    @FindBy(xpath = "//span[.='No entities were found to match your search. Try modifying your search criteria...']")
    public WebElement noEntitiesWereFoundMessage;




    public List<String> lastResults(String name,List<String> actualList) {
        Driver.getDriver().findElement(By.xpath("//span[.= '" + name + "']")).click();
             waitUntilLoaderScreenDisappear();
        BrowserUtils.sleep(1);
        List<WebElement> elements= Driver.getDriver().findElements((By.xpath("//td[starts-with(@data-column-label,'" + name + "')]")));
        for (WebElement element : elements) {
            actualList.add(element.getAttribute("innerText"));
        }
        return actualList;
    }

    /*
    public List<String> initialResults(String name, List<String> expectedList) {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//td[starts-with(@data-column-label,'" + name + "')]"));
        for (WebElement element : elements) {
            expectedList.add(element.getAttribute("innerText"));
        }

        return expectedList;
    }
     */

    public void clickAnyRow() {
        //click any row with actions class
        BrowserUtils.clickWithMouseHoverAction(anyRow);

        //regular click method sometimes doesn't work
        //it works when we click twice
        //		for (int i = 0; i < 2; i++) {
        //			try {
        //				BrowserUtils.waitClickability(anyRow, 2);
        //				anyRow.click();
        //			} catch (Exception e) {
        //				e.printStackTrace();
        //			}
        //		}
    }

    public void clickFirstCar() {
        waitUntilLoaderScreenDisappear();
        countOfRow.get(4).click();
    }

    public void clickGridSettings() {
        BrowserUtils.waitClickability(gridSettings, 5);
        gridSettings.click();
    }


    public void verifyGridSettingsMenuDisplayed() {
        BrowserUtils.waitClickability(gridSettingsTitle, 5);
        Assert.assertTrue(gridSettingsTitle.isDisplayed());
    }


    public void hoveroverthreedots() {
        BrowserUtils.hoverOverThreeDots(threeDot);
    }

    public boolean verifyDeleteButton() {
        BrowserUtils.waitForVisibility(deleteButton, 5);
        return deleteButton.isDisplayed();
    }

    public void clickDeleteButton() {
        BrowserUtils.waitClickability(deleteButton, 5);
        deleteButton.click();
    }

    public void verifyDeleteConfirmationPopUp() {
        Assert.assertTrue(deleteConfirmationText.isDisplayed());
    }


    public void clickYesDelete() {
        BrowserUtils.waitForVisibility(yesDeleteBtn, 3);
        yesDeleteBtn.click();
    }


    public void verifyWarningMessageDriver(String userType, String messageText) {
        if (userType.equalsIgnoreCase("driver")) {
            String text = this.message.getText();
            Assert.assertTrue(message.isDisplayed());
            Assert.assertEquals(message.getText(), messageText);
        } else if (userType.equalsIgnoreCase("sales manager") || userType.equalsIgnoreCase("store manager")) {
            Assert.assertTrue(message.isDisplayed());
            Assert.assertEquals(message.getText(), messageText);
        }
    }

    public String getDriverName() {
        return countOfRow.get(0).getText();

    }

    public void clickDeleteInfo() {
        BrowserUtils.waitForVisibility(deleteCarButton, 5);
        deleteCarButton.click();
    }


    public void clickonviewicon() {
        viewButton.click();
    }




    public List<String> actualDropdownMethods(){

        List<String> dropdownMethods = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            WebElement dropdownItem = Driver.getDriver().findElement(By.xpath("(//a[@class='dropdown-item choice-value'])["+i+"]"));
            dropdownMethods.add(dropdownItem.getText());
        }

        return dropdownMethods;

    }

    public int number1;
    public int number2;

    public void enterNumValuesToBetweenMethod(String num1, String num2){
        lastOdoMFilterFirstInput.sendKeys(num1);
        lastOdoMFilterSecondInput.sendKeys(num2);
        number1 = Integer.parseInt(num1);
        number2 = Integer.parseInt(num2);
    }

    public int rowNumber(){

        int counter = 0;
        int i = 1;
        try{
            while( Driver.getDriver().findElement(By.xpath("(//tbody/tr)["+i+"]")).isDisplayed()  ){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter++;
                i++;
            }
        }catch(NoSuchElementException e){
        }
        return counter;
    }

    public List<Integer> getOdometerValues(){

        List<Integer> odometerValues = new ArrayList<>();

        try{
            for (int i = 1; i <= rowNumber(); i++) {
                WebElement lastOdometerCell = Driver.getDriver().findElement(By.xpath("(//td[@data-column-label='Last Odometer'])[" + i + "]"));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String numberAsString = lastOdometerCell.getText();
                Integer valueNum = Integer.parseInt(numberAsString.replaceAll("\\D",""));
                odometerValues.add(valueNum);
            }
        } catch(NoSuchElementException e){
        }
        return odometerValues;
    }

    public boolean isValuesBetween(){

        boolean isBetweenProvidedValues = false;

        System.out.println("Results between provided values: ");
        for (Integer eachOdometerValue : getOdometerValues()) {
            if (eachOdometerValue > number1 && eachOdometerValue <= number2){
                System.out.println(eachOdometerValue);
                isBetweenProvidedValues = true;
            }else {
                System.err.println("Actual Last Odometer value: "+eachOdometerValue);
                isBetweenProvidedValues = false;
            }
        }
        return isBetweenProvidedValues;
    }

    public void enterNumValueToMethod(String num1) {
        lastOdoMFilterFirstInput.sendKeys(num1);
        number1 = Integer.parseInt(num1);
    }

    public int isValuesEquals(){

        int actualValue = 0;

        System.out.println("Result for provided value: ");
        for (Integer eachOdometerValue : getOdometerValues()) {
            if (eachOdometerValue == number1){
                System.out.println(eachOdometerValue);
                actualValue = eachOdometerValue;
            } else {
                if (noEntitiesWereFoundMessage.isDisplayed()){
                    break;
                }
            }
        }
        return actualValue;
    }

    public void ifNoEntity(){
            //!(isValuesEquals() == number1) &&
        if (    noEntitiesWereFoundMessage.isDisplayed()){
            System.out.println("Notification Message Displayed: \n"+"No entities were found to match your search. Try modifying your search criteria...");
        }
    }

    public boolean isValuesMoreThan(){

        boolean isMoreThanProvidedValue = false;

        System.out.println("Results for provided values: ");
        for (Integer eachOdometerValue : getOdometerValues()) {
            if (eachOdometerValue > number1){
                System.out.println(eachOdometerValue);
                isMoreThanProvidedValue = true;
            }else {
                System.err.println("Actual Last Odometer value: "+eachOdometerValue);
                isMoreThanProvidedValue = false;
            }
        }
        return isMoreThanProvidedValue;
    }

    public boolean isValuesLessThan(){

        boolean isLessThanProvidedValue = false;

        System.out.println("Results for provided values: ");
        for (Integer eachOdometerValue : getOdometerValues()) {
            if (eachOdometerValue < number1){
                System.out.println(eachOdometerValue);
                isLessThanProvidedValue = true;
            }else {
                System.err.println("Actual Last Odometer value: "+eachOdometerValue);
                isLessThanProvidedValue = false;
            }
        }
        return isLessThanProvidedValue;
    }

    public boolean isValuesEmpty(){

        boolean isValuesEmpty = false;

        List<String> lastOdometerValues = new ArrayList<>();

        for (int i = 1; i <= rowNumber(); i++) {
            WebElement lastOdometerCell = Driver.getDriver().findElement(By.xpath("(//td[@data-column-label='Last Odometer'])[" + i + "]"));
            String text = lastOdometerCell.getText();
            lastOdometerValues.add(text);
        }

        for (String eachOdometerValue : lastOdometerValues) {
            if (eachOdometerValue.equals("")){
                isValuesEmpty = true;
            } else {
                System.out.println("Expected:"+"\"Empty\"");
                System.out.println("Actual:"+eachOdometerValue);
                isValuesEmpty = false;
                break;
            }
        }

        return isValuesEmpty;
    }

    public void selectMethod(String method){
        switch (method){
            case"Between":
                betweenMethod.click();
                break;
            case"Equals":
                equalsMethod.click();
                break;
            case"More Than":
                moreThanMethod.click();
                break;
            case"Less Than":
                lessThanMethod.click();
                break;
        }
    }

    public boolean doesNotAcceptNonNumerics(String str1){

        boolean notAcceptsNonNumeric = true;

        BrowserUtils.sleep(1);
        lastOdometerDropdownButton.click();
        String text1 = lastOdoMFilterFirstInput.getText();

        if (str1.equals(text1)){
            notAcceptsNonNumeric = false;
        }
        return notAcceptsNonNumeric;
    }

    /*

    public String value1;
    public String value2;

    public boolean hasNonNumericValues(){
        boolean hasNonDigit = false;
        for (int i = 0; i < value1.length(); i++) {
            if (!Character.isDigit(value1.charAt(i))){
                hasNonDigit = true;
                break;
            }
        }
        for (int i = 0; i < value2.length(); i++) {
            if (!Character.isDigit(value2.charAt(i))){
                hasNonDigit = true;
                break;
            }
        }
        return hasNonDigit;
    }
     */

    public void enterSecondValueForBetweenMethod(String string){
        if (lastOdometerFilterDropdownButton.getText().equalsIgnoreCase("between")){
            lastOdoMFilterSecondInput.sendKeys(string);
        }
    }
    @FindBy(xpath = "//tbody[@class='grid-body']//tr//td[4]")
    public List <WebElement> Results;
    @FindBy(xpath = "//span[.='No entities were found to match your search. Try modifying your search criteria...']")
    public WebElement warningMessage;

    public void selectMethodname(String Methodname) {

        if (Methodname.equalsIgnoreCase("Contains")) {
            AllMethods.get(0).click();

        } else if (Methodname.equalsIgnoreCase("Does Not Contain")) {
            AllMethods.get(1).click();
        } else if (Methodname.equalsIgnoreCase("Starts With")) {
            AllMethods.get(3).click();
        } else if (Methodname.equalsIgnoreCase("Ends With")) {
            AllMethods.get(4).click();
        } else if (Methodname.equalsIgnoreCase("is equal to")) {
            AllMethods.get(2).click();
        } else {
            System.out.println("İnvalid Methodname");
        }

    }

    }