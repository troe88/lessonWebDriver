package com.sbpstu.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitry on 14.03.17.
 */
public class BaseTest {

    WebDriver driver;

    SoftAssert softAssert;

    @BeforeMethod
    public void beforeMethod(Method method){
        softAssert = new SoftAssert();
        System.out.println(String.format("Before method: %s", method.getName()));
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult){
        System.out.println(String.format("After method: %s, status: %s", testResult.getName(), testResult.isSuccess()));
    }


    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-GB");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void afterSute(){
        driver.close();
    }

}