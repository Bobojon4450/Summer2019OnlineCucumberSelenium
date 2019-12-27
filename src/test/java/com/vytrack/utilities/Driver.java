package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    /*  You cannot create object of class, if constructor is private Driver obj = new Driver(); */
    private Driver() {
    }

    /* If switch statement complains on string parameter, change java version to 7+, better at least 8.
       File --> Project Structure --> Set Project language level to at least 8 or above.  */
    public static WebDriver getDriver() {
        /* If WebDriver object was not created yet */
        if (driver == null) {
            /*  create WebDriver object based on browser value from properties file */
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    /* To configure chrome browser for tests */
                    driver = new ChromeDriver();
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    /* to configure chrome browser for tests */
                    ChromeOptions options = new ChromeOptions();
                    /* to run tests without interface, set to true */
                    options.setHeadless(true);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    /* if browser type is wrong, throw exception. No browser will be opened */
                    throw new RuntimeException("Wrong browser type!");
            }
        }
        /* if WebDriver object was created - you can use it */
        return driver;
    }

    public static void close() {
        /* if driver still exist */
        if (driver != null) {
            /* close all browsers */
            driver.quit();
            /* destroy driver object, ready for gc */
            driver = null;
        }
    }
}