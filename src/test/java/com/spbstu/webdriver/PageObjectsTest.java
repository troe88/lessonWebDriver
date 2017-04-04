package com.spbstu.webdriver;

import com.spbstu.pageobjects.pages.simple.ContactFormPage;
import com.spbstu.pageobjects.pages.simple.IndexPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dmitry on 04.04.2017.
 */
public class PageObjectsTest extends TestBase {
    @Test
    public void loginTest() {
        IndexPage.open();
        IndexPage.openLoginForm();
        IndexPage.setLogin("epam");
        IndexPage.setUserPassword("1234");
        IndexPage.submitLoginForm();

        String actual = IndexPage.getCurrentUserName();
        String expected = "PITER CHAILOVSKII";

        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());
    }

    @Test
    public void submitContactFormTest() {
        IndexPage.open();
        IndexPage.login("epam", "1234");
        ContactFormPage.open();
        ContactFormPage.fillContactForm("name", "lastName", "description");
        ContactFormPage.submitContactForm();

        HashMap<String, String> actual = Arrays.stream(ContactFormPage.getResults().split("\n")).skip(2)
                .collect(
                        HashMap<String, String>::new,
                        (m, s) -> {
                            String[] row = s.split(":");
                            m.put(row[0].replaceAll("\\s+", "").toLowerCase(), row[1].replaceAll("\\s+", ""));
                        },
                        (m, u) -> {
                        });
        Assert.assertEquals(actual.get("name"), "name");
        Assert.assertEquals(actual.get("lastname"), "lastName");
        Assert.assertEquals(actual.get("description"), "description");
    }
}
