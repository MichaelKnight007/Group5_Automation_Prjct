package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GridSettingsPage extends BasePage {

    @FindBy(xpath = "//div[@class='column-manager-title'][text()='Grid Settings']/..")
    private WebElement gridSettingsDiv;

    @FindBy(css = "td.title-cell label")
    private List<WebElement> allGridSettingsOptions;

    @FindBy(xpath = "//tr//label//../..//input")
    private List<WebElement> allGridSettingsCheckboxes;

    @FindBy(css = "input[placeholder='Quick Search']")
    private WebElement quickSearchfield;


    //label[text()='Location']/../..//span[@title='Move column']


    public void isDisplayedGridSettings() {
        BrowserUtils.waitForVisibility(gridSettingsDiv, 2);
        Assert.assertTrue(gridSettingsDiv.isDisplayed());
    }

    public List<String> getAllGridSettingsOptions() {
        List<String> allOptionsString = new ArrayList<>();
        List<WebElement> allOptionsWE = this.allGridSettingsOptions;
        BrowserUtils.waitForVisibility(gridSettingsDiv, 2);

        for (int i = 0; i < allOptionsWE.size(); i++) {
            allOptionsString.add(allOptionsWE.get(i).getText());
        }

        return allOptionsString;
    }

    public void findCollumn(List<String> columns) {

        for (int i = 0; i < columns.size(); i++) {
            //clear the field in case it's not empty
            try {
                BrowserUtils.waitClickability(quickSearchfield, 2);
                quickSearchfield.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //search for a value
            BrowserUtils.sendKeysWithWait(quickSearchfield, columns.get(i), 1);

            //get all the results of the previous search into an arraylist
            List<WebElement> resultsWE = Driver.getDriver().findElements(By.cssSelector("td.title-cell label"));
            List<String> resultsString = new ArrayList<>();
            BrowserUtils.sleep(1);
            for (int j = 0; j < resultsWE.size(); j++) {
                if (resultsWE.get(j).isDisplayed()) {
                    resultsString.add(resultsWE.get(j).getText());
                }
            }

            //verify the results contain our keyword
            System.out.println("query.: " + columns.get(i));
            System.out.println("result: " + resultsString);
            for (int j = 0; j < resultsString.size(); j++) {
                Assert.assertTrue(resultsString.get(j).contains(columns.get(i)));
            }
        }
    }


    public void deselectAllColumns(){
        for (int i = 0; i < allGridSettingsCheckboxes.size(); i++) {
            BrowserUtils.sleep(1);
            if (allGridSettingsCheckboxes.get(i).isSelected()) {
                allGridSettingsCheckboxes.get(i).click();
            }
        }
    }

    public void clickColumn(List<String> allColumns){
        for (int i = 0; i < allColumns.size(); i++) {
            BrowserUtils.sleep(1);
            String columnName = allColumns.get(i);
            WebElement checkbox = Driver.getDriver().findElement(By.xpath("//label[text()='"+columnName+"']/../..//input"));
            checkbox.click();

            BrowserUtils.sleep(1);
            Assert.assertTrue(checkbox.isSelected());
        }
    }

    public void dragAndDrop(String column, int index){
        BrowserUtils.sleep(1);
        WebElement columnWE = Driver.getDriver().findElement(By.xpath("//label[text()='"+column+"']/../..//span"));
        WebElement target = Driver.getDriver().findElement(By.xpath("//tbody[@class='ui-sortable']//tr["+index+"]"));

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(columnWE).pause(Duration.ofMillis(500)).moveToElement(target).release().build().perform();
    }

    public void verifyColumnPosition(String column, int index){
        BrowserUtils.sleep(1);
        WebElement columnWE = Driver.getDriver().findElement(By.xpath("//tbody[@class='ui-sortable']//tr["+index+"]//label"));
        Assert.assertTrue(columnWE.getText().contains(column));
    }

    public List<String> getGridSettingsColumnOrder(){
        BrowserUtils.sleep(1);
        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//tbody[@class='ui-sortable']//label/../..//input"));
        List<String> allSelectedColumns = new ArrayList<>();

        for (int i = 0; i < allCheckBoxes.size(); i++) {
            BrowserUtils.sleep(1);
            if (allCheckBoxes.get(i).isSelected() ) {
                WebElement columnWE = Driver.getDriver().findElement(By.xpath("(//tbody[@class='ui-sortable']//label)["+(i+1)+"]"));
                allSelectedColumns.add(columnWE.getText());
            }
        }
        return allSelectedColumns;
    }
}
