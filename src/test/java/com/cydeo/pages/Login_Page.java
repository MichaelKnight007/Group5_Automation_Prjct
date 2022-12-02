package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sql.rowset.BaseRowSet;

public class Login_Page extends BasePage {

    // Locator of username field
    @FindBy(id = "prependedInput")
    public WebElement inputUsername;

    // Locator of password field
    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    // Locator of login button
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(xpath = "(//*[@href=\"/contact\"])[4]")
    private WebElement test;

    @FindBy(xpath = "//button[@title='close']")
    private WebElement addEventCloseBtn;
    //Methods
    public void goLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    public void loginAsDriver() {
        inputUsername.sendKeys(ConfigurationReader.getProperty("driverUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("driverPassword"));
        loginBtn.click();
    }

    public void loginAsSalesManager() {
        inputUsername.sendKeys(ConfigurationReader.getProperty("salesManagerUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("salesManagerPassword"));
        loginBtn.click();
    }

    public void loginAsStoreManager() {
        inputUsername.sendKeys(ConfigurationReader.getProperty("storeManagerUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("storeManagerPassword"));
        loginBtn.click();

        waitUntilLoaderScreenDisappear();
        // temporary solution to close the add event pop up
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
            wait.until(ExpectedConditions.invisibilityOf(addEventCloseBtn));
            addEventCloseBtn.click();
        } catch (Exception e) {
            System.out.println("Add Event Close is not present");
        }
    }

    public void loginAsUserType(String userType) {

        if (userType.equalsIgnoreCase("driver")) {
            loginAsDriver();
        } else if (userType.equalsIgnoreCase("sales manager")) {
            loginAsSalesManager();
        } else if (userType.equalsIgnoreCase("store manager")) {
            loginAsStoreManager();
        } else {
            System.out.println("Invalid user type");
        }
    }


}