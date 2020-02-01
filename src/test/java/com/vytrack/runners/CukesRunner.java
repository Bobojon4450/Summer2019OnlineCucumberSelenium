package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = "@smoke_test",
        plugin = {"html:target/default-cucumber-reports",
                  "json:target/cucumber.json",
                  "rerun:target/rerun.txt"
         /*        type: location            */
        }
)

public class CukesRunner {
}

/* tags = runs all tests,@login_with_credentials_ddt, @login_with_role, @smoke_test, @calendar_events, @driver_with_data_table, @calendar_events,@create_new_car */
/* ~@negative_test = runs all tests except @negative_test. Also can be (not @negative_test) */
/* multiple tags could be used separated with "or" tags = "@smoke or @vytrack" */