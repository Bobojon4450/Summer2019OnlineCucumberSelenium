package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarEventsPage extends BasePage{

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "span[class='grid-header-cell__label']")
    public List<WebElement> columnNames;

    @FindBy(css = "button[class*='btn dropdown-toggle']")
    public WebElement viewPerPageToggle;

    @FindBy(css = "[class*='btn-group'] [class='dropdown-menu pull-right'] li")
    public List<WebElement> viewPerPageOptions;


    public void clickToCreateCalendarEvent() {
        BrowserUtils.waitForVisibility(createCalendarEvent, 5);
        BrowserUtils.waitForClickability(createCalendarEvent, 5);
        createCalendarEvent.click();
    }

    public List<String> getColumnNames() {
        return BrowserUtils.getListOfString(columnNames);
    }

    public List<String> getViewPerPageOptions(){
        BrowserUtils.waitForVisibility(viewPerPageToggle, 10);
        BrowserUtils.clickWithWait(viewPerPageToggle);
        return BrowserUtils.getListOfString(viewPerPageOptions);
    }




    //label[contains(text(),'View per page:')]/..//button

   // button[class*='btn dropdown-toggle'] -> class* means class that has btn dropdown-toggle.
   // This is used when class has spaces

   // [class*='btn-group'] [class='dropdown-menu pull-right'] li
}