package com.spbstu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dmitry on 04.04.2017.
 */
public class HomePage {
    static private WebDriver driver;

    public static void setDriver(WebDriver driver) {
        HomePage.driver = driver;
    }

    public static void openLoginForm() {
        driver.findElement(By.cssSelector("li[class*='uui-profile-menu']")).click();
    }

    public static void setLogin(String login) {
        driver.findElement(By.id("Login")).sendKeys(login);
    }

    public static void setPassword(String password) {
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    public static void submitLoginForm() {
        driver.findElement(By.cssSelector("form button")).click();
    }


    public static void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public static String getUserName() {
        return driver.findElement(
                By.cssSelector("[class='profile-photo'] span"))
                .getText();
    }

    public static void login(String login, String password) {
        HomePage.openLoginForm();
        HomePage.setLogin(login);
        HomePage.setPassword(password);
        HomePage.submitLoginForm();
    }
}
