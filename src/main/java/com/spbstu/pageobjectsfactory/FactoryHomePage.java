package com.spbstu.pageobjectsfactory;

import com.spbstu.pageobjectsfactory.entities.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dmitry on 04.04.2017.
 */
public class FactoryHomePage {
    @FindBy(id = "Login")
    WebElement login;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(css = "form button")
    WebElement submit;

    @FindBy(css = "li[class*='uui-profile-menu']")
    WebElement profileMenu;

    @FindBy(css = "[class='profile-photo'] span")
    WebElement userName;

    @FindBy(xpath = "(//*[@class='sidebar-menu'] //a[@href='page1.htm'])[1]")
    WebElement contactFormLink;

    public void login(User user){
        profileMenu.click();
        this.login.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword());
        submit.click();
    }

    public String getUserName(){
        return userName.getText();
    }

    public void openContactForm(){
        contactFormLink.click();
    }
}
