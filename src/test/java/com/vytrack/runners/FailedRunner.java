package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/vytrack/step_definitions",
        plugin = {"html:target/rerun-default-cucumber-reports"}
)

public class FailedRunner {
}


/* plugin = {"html:target/default-cucumber-reports",
             "json:target/cucumber.json"
}*/

/*no need for tags since we know what to run
  no need for dryRun since no reason to generate test snippets.*/