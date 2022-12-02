package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GeneralInfoPage extends BasePage {
    @FindBy(css = "div.items.list-box.list-shaped div.list-item strong")
    private List<WebElement> allEvents;

    @FindBy(xpath = "//span[.='General Information']")
    public WebElement GeneralInfoTitle;

    @FindBy(css = ".responsive-cell.responsive-cell-no-blocks")
    public WebElement allCarInfo;
    @FindBy(xpath = "//tr[@class='grid-row row-click-action'][5]//td")
    private List<WebElement> carInfoOfAnyRow;

    @FindBy(css = "div.control-label")
    private List<WebElement> infoCar;

    public String  getInfo() {
        return allCarInfo.getText();
    }
    public void isVisibleEditDeleteAddEvent(String btn1, String btn2, String btn3) {
        WebElement btn1WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn1+"']"));
        WebElement btn2WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn2+"']"));
        WebElement btn3WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn3+"']"));
        BrowserUtils.sleep(1);

        Assert.assertTrue(btn1WE.isDisplayed());
        Assert.assertTrue(btn2WE.isDisplayed());
        Assert.assertTrue(btn3WE.isDisplayed());
    }

    public void isNotVisibleEditDeleteAddEvent(String btn1, String btn2, String btn3) {
        WebElement btn1WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn1+"']"));
        WebElement btn2WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn2+"']"));
        WebElement btn3WE = Driver.getDriver().findElement(By.xpath("//*[normalize-space(text()) = '"+btn3+"']"));
        BrowserUtils.sleep(1);

        Assert.assertFalse(btn1WE.isDisplayed());
        Assert.assertFalse(btn2WE.isDisplayed());
        Assert.assertFalse(btn3WE.isDisplayed());
    }

    public List<String> getCarInfoFromRow() {
        List<String> allInfoString = new ArrayList<>();
        List<WebElement> allInfoWE = this.carInfoOfAnyRow;
        BrowserUtils.sleep(1);

        //don't include the first and last values because it's not relevant
        for (int i = 2; i < allInfoWE.size() - 1; i++) {
            if (allInfoWE.get(i).getText().contains(",")) {
                allInfoString.add(allInfoWE.get(i).getText().replace(",", ""));
                continue;
            }
            allInfoString.add(allInfoWE.get(i).getText());
        }

        return allInfoString;
    }

    public List<String> getCarInfoAsList(){
        List<WebElement> allCarInfoWE = this.infoCar;
        List<String> allCarInfoString = new ArrayList<>();
        BrowserUtils.sleep(2);
        //don't include the last three value cause they are irrelevant
        for (int i = 2; i < allCarInfoWE.size()-3; i++) {
            if (allCarInfoWE.get(i).getText().contains(",")) {
                allCarInfoString.add(allCarInfoWE.get(i).getText().replace(",",""));
                continue;
            }
            allCarInfoString.add(allCarInfoWE.get(i).getText());
        }

        return allCarInfoString;
    }
}
