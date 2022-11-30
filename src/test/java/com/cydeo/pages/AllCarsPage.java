package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarLink;


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

    public void clickFirstCar(){
        BrowserUtils.sleep(5);
        countOfRow.get(0).click();
        BrowserUtils.sleep(3);
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

}

