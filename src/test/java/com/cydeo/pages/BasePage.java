package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public String getPageName() {
       return Driver.getDriver().findElement(By.xpath("(//h1)[2]")).getText();
    }

    //navigate to any given module and subModule
    public void navigateToModule(String moduleName, String subModuleName) { //Fleet - Vehicles
        BrowserUtils.sleep(1);
        WebElement module = Driver.getDriver().findElement(By.xpath("//span[text()[normalize-space() = '" + moduleName + "']]"));
        module.click();

        BrowserUtils.sleep(1);
        WebElement subModule = Driver.getDriver().findElement(By.xpath("//span[text()[normalize-space() = '" + subModuleName + "']]"));
        subModule.click();
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