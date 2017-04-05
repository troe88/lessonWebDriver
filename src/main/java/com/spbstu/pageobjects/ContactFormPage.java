package com.spbstu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dmitry on 04.04.2017.
 */
public class ContactFormPage {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ContactFormPage.driver = driver;
    }

    public static void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/page1.htm");
    }

    public static void fillContactForm(String name, String lastName, String description) {
        driver.findElement(By.id("Name")).sendKeys(name);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Description")).sendKeys(description);
    }

    public static void submitContactForm() {
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }


    public static String getResult() {
        return driver.findElement(By.xpath("(//*[@id='mCSB_2_container'] //section)[2]")).getText();
    }
}
