package com.sbpstu.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dmitry on 14.03.17.
 */
public class SimpleTest extends BaseTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"spbstu", Arrays.asList(
                        "1english.spbstu.ru/",
                        "https://vk.com/pgpuspb",
                        "1https://en.wikipedia.org/wiki/Peter_the_Great_St._Petersburg_Polytechnic_University")},
                {"itmo", Arrays.asList(
                        "en.ifmo.ru/",
                        "https://en.wikipedia.org/wiki/ITMO_University",
                        "1https://www.edx.org/school/itmox")}
        };
    }

    @Test(dataProvider = "data", dataProviderClass = SimpleTest.class)
    public void test1(String searchString, List<String> expected) {
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys(searchString + Keys.ENTER);
        List<String> actual = driver.findElements(By.xpath("//*[@id='res']//div[@class='g']//cite"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        expected.forEach((e) -> softAssert.assertTrue(actual.stream().anyMatch(ee -> ee.contains(e)),
                String.format("Element: %s is missing", e)));

        softAssert.assertAll();
//        Assert.assertTrue(elements.stream().anyMatch(e -> e.getText().contains(expected)));
    }


}
