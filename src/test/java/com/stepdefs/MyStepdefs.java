package com.stepdefs;

import com.spbstu.helper.ResourceLoaderSTU;
import com.spbstu.pageobjectsfactory.entities.User;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by dmitry on 18.04.2017.
 */
public class MyStepdefs {
    @Given("^Login as \"([^\"]*)\"$")
    public void loginAs(String userID) throws Throwable {
        int a = 0 ;
        User user = ResourceLoaderSTU.getUser(userID);
    }

    @And("^Open Contact Form page$")
    public void openContactFormPage() throws Throwable {
    }

    @When("^Fill form with \"([^\"]*)\"$")
    public void fillFormWith(String entityID) throws Throwable {
    }

    @And("^Submit Contact Form$")
    public void submitContactForm() throws Throwable {
    }

    @Then("^Result contains \"([^\"]*)\"$")
    public void resultContains(String arg0) throws Throwable {
    }
}
