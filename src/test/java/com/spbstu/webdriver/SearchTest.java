package com.spbstu.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dmitry on 21.03.2017.
 */
public class SearchTest extends TestBase {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"spbstu", Arrays.asList(
                        "www.spbstu-eng.ru/",
                        "english.spbstu.ru/",
                        "https://vk.com/pgpuspb",
                        "https://en.wikipedia.org/wiki/Peter_the_Great_St._Petersburg_Polytechnic_University"
                )},
                {"itmo", Arrays.asList(
                        "1en.ifmo.ru/",
                        "https://www.edx.org/school/itmox",
                        "https://en.wikipedia.org/wiki/ITMO_University",
                        "QWE"
                )}
        };
    }

//    @Test(dataProvider = "data")
    @Test(dataProvider = "data", dataProviderClass = SearchTest.class, groups = "search")
    public void search(String searchString, List<String> expectedList) {
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys(searchString + Keys.ENTER);
        List<String> actual = driver.findElements(By.xpath("//*[@id='res']//div[@class='g']//cite")).stream().map(WebElement::getText).collect(Collectors.toList());
        expectedList.forEach((e) -> {
            softAssert.assertTrue(actual.stream().anyMatch((q) -> q.contains(e)), String.format("Missing element: %s", e));
        });
        softAssert.assertAll();
    }
}
