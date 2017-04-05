package com.spbstu;

import com.spbstu.pageobjectsfactory.FactoryContactFormPage;
import com.spbstu.pageobjectsfactory.FactoryHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmitry on 04.04.2017.
 */
public class EpamSite {

    public static FactoryContactFormPage contactFormPage;
    public static FactoryHomePage homePage;
    private static WebDriver driver;

    public static void init(WebDriver driver){
        EpamSite.contactFormPage = PageFactory.initElements(driver, FactoryContactFormPage.class);
        EpamSite.homePage = PageFactory.initElements(driver, FactoryHomePage.class);
        EpamSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }
}
