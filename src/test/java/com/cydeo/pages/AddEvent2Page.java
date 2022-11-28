package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEvent2Page extends BasePage{

    public AddEvent2Page () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //AddEvent2Yasar
    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement GeneralPage;
    @FindBy(xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement AddEventBtn;
    @FindBy(xpath = "//*[@id='ui-id-2']")
    public WebElement AddEventPage;

    //AddEvent2Yasar
    @FindBy(xpath = "//*[@id='oro_calendar_event_form_allDay-uid-637dceec50c06']")
    public WebElement AllDayEventCheckBox;
    @FindBy(xpath = "//*[@id='time_selector_oro_calendar_event_form_start-uid-6380cc441156c']")
    public WebElement TimeSelectorBox;

    //AddEvent2Yasar
    @FindBy(xpath = "//*[@id='recurrence-repeat-view399']")
    public WebElement RepeatCheckBox;

    //AddEvent2Yasar
    @FindBy(xpath = "//*[@id='recurrence-repeats-view399']")
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
    @FindBy(xpath = "//*[@id=\"oro_calendar_event_form-uid-6380cc4413474\"]/fieldset/div[2]/div[2]/div[2]/div[7]/div[1]/label")
    public WebElement SummaryPart;
    @FindBy(xpath = "(//input[@type='radio'][1])[3]")
    public WebElement NeverBtn;
    @FindBy(xpath = "(//input[@class='recurrence-subview-control__number'][1])[2]")
    public WebElement OccurrenceBox;
    @FindBy(xpath = "(//input[@type='radio'][1])[4]")
    public WebElement AfterBtn;
    @FindBy(xpath = "(//input[@type='radio'][1])[5]")
    public WebElement ByBtn;
    @FindBy(xpath = "//*[@id='oro_calendar_event_form_title-uid-638050dbc6ac2']")
    public WebElement AddEnventTitleBox;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement SaveButton;
    @FindBy(xpath = "//div[.='AddEvent2']")
    public WebElement CommentLine;

}
