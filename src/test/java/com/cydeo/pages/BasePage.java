package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    Transmuda_Login_Page transmuda_Login_Page = new Transmuda_Login_Page();

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void login(String username, String password) {

        transmuda_Login_Page.inputUsername.sendKeys(username);
        transmuda_Login_Page.inputPassword.sendKeys(password);
        transmuda_Login_Page.loginBtn.click();
    }
}