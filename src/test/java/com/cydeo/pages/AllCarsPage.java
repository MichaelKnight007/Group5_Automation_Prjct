package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AllCarsPage extends BasePage {

    Login_Page loginPage = new Login_Page();

    public AllCarsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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






    }

