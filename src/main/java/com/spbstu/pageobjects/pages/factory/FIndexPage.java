package com.spbstu.pageobjects.pages.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dmitry on 04.04.2017.
 */
public class FIndexPage {

    @FindBy(css = "nav[role='navigation'] li[class*='uui-profile-menu']")
    WebElement profileMenu;

    @FindBy(id = "Login")
    WebElement login;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(css = "form button")
    WebElement submit;

    @FindBy(css = "[class='profile-photo'] span")
    WebElement currentUserName;

    public void login(String login, String password){
        profileMenu.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        submit.click();
    }

    public String getCurrentUserName() {
        return currentUserName.getText();
    }
}
