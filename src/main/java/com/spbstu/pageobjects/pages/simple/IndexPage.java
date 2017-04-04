package com.spbstu.pageobjects.pages.simple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dmitry on 04.04.2017.
 */
public class IndexPage {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        IndexPage.driver = driver;
    }

    public static void openLoginForm() {
        driver.findElement(By.cssSelector("nav[role='navigation'] li[class*='uui-profile-menu']")).click();
    }


    public static void setLogin(String userName) {
        driver.findElement(By.id("Login")).sendKeys(userName);
    }

    public static void setUserPassword(String password) {
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    public static void submitLoginForm() {
        driver.findElement(By.cssSelector("form button")).click();
    }

    public static String getCurrentUserName() {
        return driver.findElement(By.cssSelector("[class='profile-photo'] span")).getText();
    }

    public static void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public static void login(String login, String password) {
        openLoginForm();
        setLogin(login);
        setUserPassword(password);
        submitLoginForm();
    }
}
