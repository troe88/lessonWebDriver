package com.spbstu.webdriver;

import com.spbstu.pageobjects.Site;
import com.spbstu.pageobjects.pages.simple.ContactFormPage;
import com.spbstu.pageobjects.pages.simple.IndexPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dmitry on 04.04.2017.
 */
public class PageObjectsFactoryTest extends TestBase {
    @Test
    public void loginTest() {
        Site.openIndexPage();
        Site.indexPage.login("epam", "1234");

        String actual = Site.indexPage.getCurrentUserName();
        String expected = "PITER CHAILOVSKII";
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());
    }

//    @Test
//    public void submitContactFormTest() {
//        IndexPage.open();
//        IndexPage.login("epam", "1234");
//        ContactFormPage.open();
//        ContactFormPage.fillContactForm("name", "lastName", "description");
//        ContactFormPage.submitContactForm();
//
//        HashMap<String, String> actual = Arrays.stream(ContactFormPage.getResults().split("\n")).skip(2).collect(
//                HashMap<String, String>::new,
//                (m, c) -> {
//                    String[] row = c.split(":");
//                    m.put(row[0].replaceAll("\\s+", "").toLowerCase(), row[1].replaceAll("\\s+", ""));
//                },
//                (m, u) -> {
//                });
//        Assert.assertEquals(actual.get("name"), "name");
//        Assert.assertEquals(actual.get("lastname"), "lastName");
//        Assert.assertEquals(actual.get("description"), "description");
//    }
}
