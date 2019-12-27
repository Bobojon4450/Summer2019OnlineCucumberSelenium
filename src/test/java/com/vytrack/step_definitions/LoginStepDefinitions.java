package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        /*System.out.println("I am on the login page");*/
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user logs in as store manager")
    public void user_logs_in_as_store_manager() {
        String userName = ConfigurationReader.getProperty("user_name");//returns username
        String password = ConfigurationReader.getProperty("password");//returns password
        loginPage.waitUntilLoaderMaskDisappear();
        loginPage.login(userName, password);
    }

    @Then("user verifies the {string} page subtitle is displayed")
    public void user_verifies_the_page_subtitle_is_displayed(String string) {
        loginPage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals(string, loginPage.getPageSubTitle()); //expected vs actual
        /*System.out.println("Verifying page subtitle: " + string);*/
    }

    @Then("user logs in as driver")
    public void user_logs_in_as_driver() {
        /*System.out.println("Login as driver");*/
    }

    @Then("user logs in as sales manager")
    public void user_logs_in_as_sales_manager() {
        /*System.out.println("Login as sales manager");*/
    }

    @Then("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String str, String str2) {
        System.out.println("Login with " + str + " password");
        System.out.println("Login with " + str2 + " username");
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        System.out.println("Verified that warning message is displayed: " + string);
    }

    @Then("user logs in as driver with following credentials")
    public void user_logs_in_as_driver_with_following_credentials(Map<String, String> dataTable) {
        System.out.println(dataTable);
        loginPage.login(dataTable.get("username"), dataTable.get("password"));

    }

}
