package com.spbstu.webdriver;

import com.spbstu.EpamSite;
import org.testng.annotations.Test;

/**
 * Created by dmitry on 04.04.2017.
 */
public class FactoryTests extends BaseTest {

    @Test
    public void contactFormTest(){
        EpamSite.open();
        EpamSite.homePage.login("epam", "1234");
        EpamSite.homePage.openContactForm();
        EpamSite.contactFormPage.fillContactForm("dima", "lebedev", "qa");
        EpamSite.contactFormPage.submitContactForm();

        // assert
    }

}
