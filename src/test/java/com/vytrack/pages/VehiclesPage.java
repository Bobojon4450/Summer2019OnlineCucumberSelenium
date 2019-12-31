package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage{

    @FindBy(css = "[title='Create Car']")
    public WebElement createACarElement;

    /**
     * Use this method to click on "Create Car" button
     * Method already contains waits to handle synchronization issues.
     */
    public void clickToCreateACar(){
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        BrowserUtils.waitForVisibility(createACarElement, 15);
        BrowserUtils.waitForClickability(createACarElement, 15);
        js.executeScript("arguments[0].click();", createACarElement);
        /*createACarElement.click();*/
    }
}