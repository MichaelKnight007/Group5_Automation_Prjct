package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    //wait for an element to be clickable (with web element)
    public static void waitClickability(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wait for an element to be clickable (with By locator)
    public static void waitClickability(By locator, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickWithTryCatch(By locator){
        waitClickability(locator,5);
        try {
            Driver.getDriver().findElement(locator).click();
        } catch (Exception e) {
            e.printStackTrace();
            BrowserUtils.sleep(1);
            Driver.getDriver().findElement(locator).click();
        }
    }

    public static void clickWithTryCatch(WebElement element){
        waitClickability(element,5);
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            BrowserUtils.sleep(1);
            element.click();
        }
    }

    /*
    This method will accept int (in seconds) and executes Thread.sleep for given duration.
     */
    public static void sleep(int seconds) {

        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }


    /*
    TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {

//4. Create a logic to switch to the tab where "expectedInUrl".com is open
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();// We can get all the window handles as String

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if ((Driver.getDriver().getCurrentUrl()).contains("expectedInUrl")) {
                break;
            }
        }

        //5. Assert: Title contains “expectedInUrl”
        String actualInTitle = Driver.getDriver().getTitle();


        //Assert.assertEquals(actualInTitle,expectedInTitle,"Title Test is FAILED!!!"); will give fail,
        // because actual title is not same, it's longer.

        Assert.assertTrue(actualInTitle.contains(expectedInTitle));
    }


    /*
    This method accepts String and gets expectedTitle and sserts if it's true
     */
    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    /*
    Creating a utility method for ExplicitWait so that we don't have repeat the lines
     */
    public static void waitforInvisibilityOf(WebElement webElement) {

        //4- Wait until “loading bar disappears” (ExplicitWait)
        //4.1 Create wait object

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        // We turn off the implicitlyWait that we called from Driver class before the Expilicit Wait.
        // So that we prevent the unexpected wait time issue.

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //4.2 create the condition for wait
        wait.until(ExpectedConditions.invisibilityOf(webElement));
        //  Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      /*

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        If we worry about the synchronization, we may use implicitlyWait again.
        and if we don't want to write all these lines again and again,
        we may create a method in BrowserUtil class.
        We may not generally require it.

       */
    }

    /**
     * This method will accept a String as expected value and verify if the current url contains the expected value.
     *
     * @param expectedInUrl
     */
    public static void verifyUrlContains(String expectedInUrl) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }

    /**
     * This method will accept a dropDown as a Web Element ...
     *
     * @param dropdownElement
     * @return
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElements = select.getOptions();

        //Create a list of string to pass all the actual web element options' srting into that list
        //List of all ACTUAL month <options> as a String
        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElements) {

            actualOptionsAsString.add(each.getText());
        }

        return actualOptionsAsString;

    }

    /**
     * This method will accept a group of radio buttons as a List of WebElements
     * It will loop through the list and click to the radio button with provided attribute value.
     *
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {

        for (WebElement eachRadioButton : radioButtons) {

            if (eachRadioButton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                eachRadioButton.click();
            }

        }
    }

    /**
     * Switches to new window by exact title. Returns to original window if target file not found
     *
     * @param targetTitle
     */
    public static void switchToWindows(String targetTitle) {

        String origin = Driver.getDriver().getWindowHandle();

        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);

            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * r the mouse to given element
     *
     * @param element on which to hover
     */
    public static void hover(WebElement element) {

        Actions action = new Actions(Driver.getDriver());

        action.moveToElement(element).perform();


    }

    public static void clickWithMouseHoverAction(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).pause(500).click(element).build().perform();
    }
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void hoverOverThreeDots(WebElement threeDots) {
        Actions actions = new Actions(Driver.getDriver());


        try {
            for (int i = 0; i < 2; i++) {
                actions.moveToElement(threeDots).pause(1000).build().perform();
                BrowserUtils.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void waitForVisibility(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

}
