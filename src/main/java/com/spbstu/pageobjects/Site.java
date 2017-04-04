package com.spbstu.pageobjects;

import com.spbstu.pageobjects.pages.factory.FContactFormPage;
import com.spbstu.pageobjects.pages.factory.FIndexPage;
import com.spbstu.pageobjects.pages.simple.ContactFormPage;
import com.spbstu.pageobjects.pages.simple.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmitry on 04.04.2017.
 */
public class Site {
    private static WebDriver driver;

    public static FIndexPage indexPage;
    public static FContactFormPage contactFormPage;


    public static void init(WebDriver driver){
        Site.driver = driver;
        Site.indexPage = PageFactory.initElements(driver, FIndexPage.class);
        Site.contactFormPage = PageFactory.initElements(driver, FContactFormPage.class);
    }

    public static void openIndexPage() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }
}
