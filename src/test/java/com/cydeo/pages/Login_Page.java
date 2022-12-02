package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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


    }

    public void closeAddEventPage() {
        waitUntilLoaderScreenDisappear();
        // temporary solution to close the add event pop up
        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            addEventCloseBtn.click();
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.out.println("Add Event Close is not present");
        }
    }

    public void loginAsUserType(String userType) {

        if (userType.equalsIgnoreCase("driver")) {
            loginAsDriver();
            closeAddEventPage();
        } else if (userType.equalsIgnoreCase("sales manager")) {
            loginAsSalesManager();
            closeAddEventPage();
        } else if (userType.equalsIgnoreCase("store manager")) {
            loginAsStoreManager();
            closeAddEventPage();
        } else {
            System.out.println("Invalid user type");
        }
    }


}