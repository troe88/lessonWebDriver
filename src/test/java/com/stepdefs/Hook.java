package com.stepdefs;

import com.spbstu.EpamSite;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmitry on 18.04.2017.
 */
public class Hook {

    WebDriver driver;

    @Before
    public void before(Scenario scenario){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-GB");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        EpamSite.init(driver);
}

    @After
    public void after(Scenario scenario){

    }
}
