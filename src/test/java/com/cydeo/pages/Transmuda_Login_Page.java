package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Transmuda_Login_Page {
    public Transmuda_Login_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Locator of username field
    @FindBy(id = "prependedInput")
    public WebElement inputUsername;


    // Locator of password field
    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;



    // Locator of login button
    @FindBy(id = "_submit")
    public WebElement loginBtn;




}
