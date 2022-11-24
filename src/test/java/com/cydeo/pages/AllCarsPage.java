package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public List<String> initialResults(String name, List<String> expectedList) {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//td[starts-with(@data-column-label,'" + name + "')]"));
        for (WebElement element : elements) {
            expectedList.add(element.getAttribute("innerText"));
        }

        return expectedList;
    }

    public List<String> lastResults(String name,List<String> actualList) {
        Driver.getDriver().findElement(By.xpath("//span[.= '" + name + "']")).click();
        BrowserUtils.sleep(1);
        List<WebElement> elements= Driver.getDriver().findElements((By.xpath("//td[starts-with(@data-column-label,'" + name + "')]")));
        for (WebElement element : elements) {
            actualList.add(element.getAttribute("innerText"));
        }
        return actualList;
    }


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


}

