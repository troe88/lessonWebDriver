package com.spbstu.pageobjectsfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dmitry on 04.04.2017.
 */
public class FactoryContactFormPage {

    @FindBy(id = "Name")
    WebElement name;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Description")
    WebElement description;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submit;

    @FindBy(xpath = "(//*[@id='mCSB_2_container'] //section)[2]")
    WebElement result;

    public void fillContactForm(String name, String lastName, String description){
        this.name.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.description.sendKeys(description);
    }

    public void submitContactForm(){
        this.submit.click();
    }

    public void getResult(){
        this.result.getText();
    }

}
