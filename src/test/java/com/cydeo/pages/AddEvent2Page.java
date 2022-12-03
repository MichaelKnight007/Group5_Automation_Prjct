package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AddEvent2Page extends BasePage{

    public AddEvent2Page () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //AddEvent2Yasar
    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement GeneralPage;
    @FindBy(xpath = "//a[@title=\"Add an event to this record\"]")
    public WebElement AddEventBtn;
    @FindBy(xpath = "//span[.='Add Event']")
    public WebElement AddEventPage;

    //AddEvent2Yasar
    @FindBy(xpath = "(//*[@type='checkbox'])[2]")
    public WebElement AllDayEventCheckBox;
    @FindBy(xpath = "//*[@placeholder='time']")
    public WebElement TimeSelectorBox;

    //AddEvent2Yasar
    @FindBy(xpath = "(//*[@type='checkbox'])[3]")
    public WebElement RepeatCheckBox;

    //AddEvent2Yasar
    @FindBy(xpath = " //select[@data-name='recurrence-repeats']")
    public WebElement RepeatsCheckBox;

    //AddEvent2Yasar
    @FindBy(xpath = "//span[@title='#5484ED']")
    public WebElement BlueColorRadioBtn;

    //AddEvent2Yasar
    @FindBy(xpath = "//span[@title='#51B749']")
    public WebElement GreenColorRadioBtn;

    //AddEvent2Yasar
    @FindBy(xpath = "//span[@title='#FBD75B']")
    public WebElement YellowColorRadioBtn;

    //AddEvent2Yasar
    @FindBy(xpath = "//span[@title='#DC2127']")
    public WebElement RedColorRadioBtn;

    //AddEvent2Yasar
    @FindBy(xpath = "//div[@data-name='recurrence-daily']")
    public WebElement DailyRecurrence;

    //AddEvent2Yasar
    @FindBy(xpath = "//div[@data-name='recurrence-weekly']")
    public WebElement WeeklyRecurrence;

    //AddEvent2Yasar
    @FindBy(xpath = "//div[@data-name='recurrence-monthly']")
    public WebElement MonthlyRecurrence;
    //AddEvent2Yasar
    @FindBy(xpath = "//div[@data-name='recurrence-yearly']")
    public WebElement YearlyRecurrence;
    @FindBy(xpath = "//div[@data-name='recurrence-summary']")
    public WebElement SummaryPart;
    @FindBy(xpath = "(//input[@type='radio'][1])[3]")
    public WebElement NeverBtn;
    @FindBy(xpath = "//input[@data-related-field='occurrences']")
    public WebElement OccurrenceBox;
    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement AfterBtn;
    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement ByBtn;
    @FindBy(xpath = "//input[@data-name=\"field__title\"]")
    public WebElement AddEnventTitleBox;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement SaveButton;
    @FindBy(xpath = "//strong[.='AddEvent2']")
    public WebElement CommentLine;


    // Enes AddEvent
    @FindBy(xpath = "//*[@class='required']/em[.=\"*\"]/..")
    public List<WebElement> compulsoryFields;

    @FindBy(xpath = "//span[.=\"This value should not be blank.\"]")
    public WebElement errorMessage;
    public List<String> getCompulsoryFields(){
        return compulsoryFields.stream().map(item -> item.getText().substring(0, item.getText().length()-1)).collect(Collectors.toList());
    }

    public void fillField(String fieldName){
        waitUntilLoaderScreenDisappear();
        Driver.getDriver().findElement(By.xpath("//input[@data-name=\"field__"+fieldName+"\"]")).sendKeys("Test");
        SaveButton.click();
    }

    //Enes AddEvent
}
