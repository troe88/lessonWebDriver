package com.spbstu.webdriver;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.testng.ITestResult.FAILURE;

/**
 * Created by dmitry on 14.03.17.
 */
public class TestBase {

    SoftAssert softAssert;

    WebDriver driver;

    @BeforeMethod()
    public void beforeMethod(Method method) {
        softAssert = new SoftAssert();
        System.out.println(String.format("Before %s method.", method.getName()));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-GB");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod()
    public void afterMethod(ITestResult testResult) {
        System.out.println(String.format("Test method %s has been finished successfully: %s", testResult.getName(), testResult.isSuccess()));
//        driver.close();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

    }

    @AfterSuite(alwaysRun = true)
    public void afterSute() {

    }

}
