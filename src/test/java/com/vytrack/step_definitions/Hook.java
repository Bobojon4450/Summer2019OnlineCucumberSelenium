package com.vytrack.step_definitions;


import com.vytrack.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {

    @Before
    public void setUp(){
        Driver.getDriver().manage().window().maximize();
        System.out.println("\tTest setUp");
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("\tTest Successfully Failed");
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", "Failed scenario screenshots");
        }else {
            System.out.println("\tTest completed");
        }
        Driver.close();
    }

}
