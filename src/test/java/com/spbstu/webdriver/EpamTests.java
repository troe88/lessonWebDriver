package com.spbstu.webdriver;

import com.spbstu.pageobjects.ContactFormPage;
import com.spbstu.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitry on 04.04.2017.
 */
public class EpamTests extends BaseTest {

    @Test
    public void loginTest() {
        HomePage.open();
        HomePage.openLoginForm();
        HomePage.setLogin("epam");
        HomePage.setPassword("1234");
        HomePage.submitLoginForm();

        String actualName = HomePage.getUserName();
        String expectedName = "Piter Chailovskii".toUpperCase();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void contactFormTest() {
        HomePage.open();
        HomePage.login("epam", "1234");
        ContactFormPage.open();
        ContactFormPage.fillContactForm("dima", "lebedev", "qa");
        ContactFormPage.submitContactForm();

        HashMap<String, String> actual = Arrays.stream(ContactFormPage.getResult().split("\n")).skip(2)
                .collect(() -> new HashMap<String, String>(),
                        (m, s) -> {
                            String[] row = s.split(":");
                            m.put(row[0].toLowerCase().replaceAll("\\s+", ""), row[1].trim());
                        }, (m1, m2) -> {
                        });

        Assert.assertEquals(actual.get("name"), "dima");
        Assert.assertEquals(actual.get("lastname"), "lebedev");
        Assert.assertEquals(actual.get("description"), "qa");
    }
}
