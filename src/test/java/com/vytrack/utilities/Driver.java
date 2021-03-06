package com.vytrack.utilities;

/*
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    */
/*  You cannot create object of class, if constructor is private Driver obj = new Driver(); *//*

    private Driver() {
    }

    */
/* If switch statement complains on string parameter, change java version to 7+, better at least 8.
       File --> Project Structure --> Set Project language level to at least 8 or above.  *//*

    public static WebDriver getDriver() {
        */
/* If WebDriver object was not created yet *//*

        if (driver == null) {
            */
/*  create WebDriver object based on browser value from properties file *//*

            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    */
/* To configure chrome browser for tests *//*

                    driver = new ChromeDriver();
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    */
/* to configure chrome browser for tests *//*

                    ChromeOptions options = new ChromeOptions();
                    */
/* to run tests without interface, set to true *//*

                    options.setHeadless(true);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    */
/* if browser type is wrong, throw exception. No browser will be opened *//*

                    throw new RuntimeException("Wrong browser type!");
            }
        }
        */
/* if WebDriver object was created - you can use it *//*

        return driver;
    }

    public static void close() {
        */
/* if driver still exist *//*

        if (driver != null) {
            */
/* close all browsers *//*

            driver.quit();
            */
/* destroy driver object, ready for gc *//*

            driver = null;
        }
    }
}*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;


public class Driver {

    /**  These variables differ from their normal counterparts in that each thread
     *   that accesses one (via its get() or set() method) has its own, independently
     *   initialized copy of the variable (driver in our case).     */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /* This makes the class singleton */
    private Driver() {
    }

    public static WebDriver getDriver() {
        //if this thread doesn't have a web driver yet - create it and add to pool
        if (driverPool.get() == null) {
            System.out.println("TRYING TO CREATE DRIVER");
            // this line will tell which browser should open based on the value from properties file
            String browserParamFromEnv = System.getProperty("browser");
            String browser = browserParamFromEnv == null ? ConfigurationReader.getProperty("browser") : browserParamFromEnv;
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox_headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;
                case "remote_chrome":
                    try {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setCapability("platform", Platform.ANY);
                        /*driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions));*/
                        driverPool.set(new RemoteWebDriver(new URL("http://ec2-3-95-21-133.compute-1.amazonaws.com:4444/wd/hub"),
                                chromeOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote_firefox":
                    try {
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
                        driverPool.set(new RemoteWebDriver(new URL("http://ec2-3-95-21-133.compute-1.amazonaws.com:4444/wd/hub"), desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        //return corresponded to thread id webDriver object
        return driverPool.get();
    }

    public static void close() {
        driverPool.get().quit();
        driverPool.remove();
    }

}

//http://ec2-18-212-156-23.compute-1.amazonaws.com/4444/wd/hub
//http://ec2-54-166-190-92.compute-1.amazonaws.com:4444/wd/hub
//http://ec2-18-212-156-23.compute-1.amazonaws.com:4444/wd/hub

/*try {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("platform", Platform.ANY);
        *//*driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions));*//*
        driverPool.set(new RemoteWebDriver(new URL("http://ec2-3-95-21-133.compute-1.amazonaws.com:4444/wd/hub"), firefoxOptions));
        } catch (Exception e) {
        e.printStackTrace();
        }
*/

 /*     FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setCapability("platform", Platform.ANY);
                        driverPool.set(new RemoteWebDriver(new URL("http://ec2-3-95-21-133.compute-1.amazonaws.com:4444/wd/hub"), firefoxOptions));
        } catch (Exception e) {
        e.printStackTrace();
        }
*/