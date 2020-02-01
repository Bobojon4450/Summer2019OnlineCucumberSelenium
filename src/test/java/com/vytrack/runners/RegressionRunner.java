package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/activities",
                "src/test/resources/features/fleet",
                "src/test/resources/features/Login.feature"
        },
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        plugin = {"html:target/default-cucumber-reports",
                  "json:target/cucumber.json",
                  "rerun:target/rerun.txt"
        } /* It wont generate cucumber report, since we disable the plugin in the pom.xml file */
)

public class RegressionRunner {
}
