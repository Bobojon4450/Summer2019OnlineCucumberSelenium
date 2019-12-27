package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = "@driver_with_data_table",//runs all tests //@smoke_test//@calendar_events
        //, ~@negative_test = runs all tests except @negative_test. Also can be (not @negative_test)
        //multiple tags could be used separeted with "or" tags = "@smoke or @vytrack"
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        }
)

public class CukesRunner {
}
