package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
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
    public void user_verifies_the_page_subtitle_is_displayed(String pageSubTitle) {
        loginPage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals(pageSubTitle, loginPage.pageSubTitle.getText()); /* expected vs actual */
        Assert.assertTrue(loginPage.pageSubTitle.isDisplayed());
    }

    @Then("user logs in as driver")
    public void user_logs_in_as_driver() {
        String driver_user_name = ConfigurationReader.getProperty("driver.username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.waitUntilLoaderMaskDisappear();
        loginPage.login(driver_user_name, password);
    }

    @Then("user logs in as sales manager")
    public void user_logs_in_as_sales_manager() {
        String sales_manager = ConfigurationReader.getProperty("sales_manager");
        String password = ConfigurationReader.getProperty("password");
        loginPage.waitUntilLoaderMaskDisappear();
        loginPage.login(sales_manager, password);
    }

    @Then("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String str, String str2) {
        loginPage.login(str, str2);
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        Assert.assertTrue(loginPage.warningMessage.isDisplayed());
        System.out.println("Verified that warning message is displayed: " + string);
    }

    @Then("user logs in as driver with following credentials")
    public void user_logs_in_as_driver_with_following_credentials(Map<String, String> dataTable) {
        System.out.println(dataTable);
        loginPage.login(dataTable.get("username"), dataTable.get("password"));

    }

    @Then("user logs in as {string}")
    public void user_logs_in_as(String string) {
        loginPage.login(string);
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String title) {
        BrowserUtils.waitForPageTitle(title);
        Assert.assertEquals("Title is incorrect", title, Driver.getDriver().getTitle());
    }

/*    //document.getElements(By.name('full_name')[0].setAttribute('value','My name')
    @Test()
    public void test4() {
        Driver.getDriver().get("http://practice.cybertekschool.com/sign_up");
        WebElement name = Driver.getDriver().findElement(By.name("full_name"));
        WebElement email = Driver.getDriver().findElement(By.name("email"));
        WebElement submitButton=Driver.getDriver().findElement(By.name("wooden_spoon"));
        BrowserUtils.wait(2);
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        //setAttribute is same as sendKeys
        js.executeScript("arguments[0].setAttribute('value', 'John Doe')", name);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'Johnsemail@email.com')", email);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()", submitButton);
        BrowserUtils.wait(2);
    }*/
}
