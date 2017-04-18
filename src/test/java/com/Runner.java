package com;

/**
 * Created by dmitry on 18.04.2017.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/features"},
        glue = {"com.stepdefs"}
)
public class Runner {

}
