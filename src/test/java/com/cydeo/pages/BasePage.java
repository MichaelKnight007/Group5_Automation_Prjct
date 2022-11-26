package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Locators
    @FindBy(xpath = "(//div[@class='loader-frame'])[last()]")
    protected WebElement loaderMask;

    //Methods

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //returns the title of the page
    public String getPageTitle(){
        BrowserUtils.sleep(3);
        return Driver.getDriver().getTitle();
    }
    public String getHomePageName() {
        return Driver.getDriver().findElement(By.xpath("(//h1)[2]")).getText();
    }

    public String getModuleName() {
       return Driver.getDriver().findElement(By.className("oro-subtitle")).getText();
    }

    //navigate to any given module and subModule
    public void navigateToModule(String moduleName, String subModuleName) { //Fleet - Vehicles
        By moduleLocator = By.xpath("//span[text()[normalize-space() = '" + moduleName + "']]");
        BrowserUtils.clickWithTryCatch(moduleLocator);

        By subModuleLocator = By.xpath("//span[text()[normalize-space() = '" + subModuleName + "']]");
        BrowserUtils.clickWithTryCatch(subModuleLocator);
    }

    //navigate to any given module and subModule and subModule of subModule
    public void navigateToModule(String moduleName, String subModuleName, String subSubModuleName) {
        BrowserUtils.sleep(1);
        WebElement module = Driver.getDriver().findElement(By.xpath("//span[text()[normalize-space() = '" + moduleName + "']]"));
        module.click();

        BrowserUtils.sleep(1);
        WebElement subModule = Driver.getDriver().findElement(By.xpath("//span[text()[normalize-space() = '" + subModuleName + "']]"));
        subModule.click();

        BrowserUtils.sleep(1);
        WebElement subSubModule = Driver.getDriver().findElement(By.xpath("//span[text()[normalize-space() = '" + subSubModuleName + "']]"));
        subSubModule.click();
    }

}