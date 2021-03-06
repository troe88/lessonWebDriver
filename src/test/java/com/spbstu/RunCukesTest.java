package com.spbstu; /**
 * Created by dmitry on 18.04.2017.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/reports/html", "json:target/reports/mainReport.json"},
        features = {"src/test/resources/features"},
        glue = {"com.spbstu.stepdefs"}
)
public class RunCukesTest {

}
