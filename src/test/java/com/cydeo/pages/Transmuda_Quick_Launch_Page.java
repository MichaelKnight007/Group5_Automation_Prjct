package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Transmuda_Quick_Launch_Page {


    public Transmuda_Quick_Launch_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //Locator of "Quick Launchpad" Text
    @FindBy (xpath = "//h1[.='Quick Launchpad']")
    public WebElement quickLaunchpad;


    //Locator of "Fleet Dropdown" button
    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetDropdown;


    //Locator of "Vehicle Dropdown Link" button
    @FindBy (xpath = "//span[.='Vehicles']")
    public WebElement vehiclesBtn;


}
