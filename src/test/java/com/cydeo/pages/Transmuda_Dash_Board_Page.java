package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Transmuda_Dash_Board_Page {
    public Transmuda_Dash_Board_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //Locator of "Dashboard" text
    @FindBy(className = "oro-subtitle")
    public WebElement dashboardText;

    //Locator of "Fleet Dropdown" button
    @FindBy (xpath = "//i[@class='fa-asterisk menu-icon'][1]")
    public WebElement fleetDropdownBtn;


    //Locator of "Vehicles Dropdown Link" button
    @FindBy (xpath = "//span[.='Vehicles']")
    public WebElement vehiclesLink;


}




