package com.stepdefs;

import com.spbstu.EpamSite;
import com.spbstu.helper.ResourceLoaderSTU;
import com.spbstu.pageobjectsfactory.entities.User;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

/**
 * Created by dmitry on 18.04.2017.
 */
public class MyStepdefs {
    @Given("^Login as \"([^\"]*)\"$")
    public void loginAs(String userID) throws Throwable {
        User user = ResourceLoaderSTU.getUser(userID);
        EpamSite.open();
        EpamSite.homePage.login(user);
    }

    @And("^Open Contact Form page$")
    public void openContactFormPage() throws Throwable {
        EpamSite.homePage.openContactForm();
    }

    @When("^Fill form with \"([^\"]*)\"$")
    public void fillFormWith(String entityID) throws Throwable {
        EpamSite.contactFormPage.fillContactForm("dima", "lebedev", "qa");
    }

    @And("^Submit Contact Form$")
    public void submitContactForm() throws Throwable {
        EpamSite.contactFormPage.submitContactForm();
    }

    @Then("^Result contains \"([^\"]*)\"$")
    public void resultContains(String arg0) throws Throwable {
        throw new NotImplementedException();
    }

    @When("^Fill Contact Form with data below$")
    public void fillContactFormWithDataBelow(DataTable dataTable) throws Throwable {
        throw new PendingException();
    }
}
