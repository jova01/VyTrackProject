package com.vytrack.pages.activities;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage {

    public CalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css="a[title='Create Calendar event']")
    public WebElement createCalEventElement;

    @FindBy(css="#date_selector_oro_calendar_event_form_start-uid-5d3b5cd202209")
    public WebElement StartDateElement;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css="a[title='Grid Settings']")
    public WebElement gridSettingsElement;

    @FindBy(css="a[title='Reset']")
    public WebElement resetBtnElement;

    @FindBy(css = ".grid-header-cell__label")
    public List<WebElement> headers;


    public void selectGridSetting(String name, boolean yesOrNo){
        gridSettingsElement.click();
        String locator="//td//label[text()='"+name+"']/../following-sibling::td//input";

        WebElement gridOption=Driver.getDriver().findElement(By.xpath(locator));

        SeleniumUtils.waitPlease(2);
        if((yesOrNo == true && !gridOption.isSelected())  || (
                yesOrNo == false && gridOption.isSelected())){
            gridOption.click();
        }
        SeleniumUtils.waitPlease(2);
        gridSettingsElement.click();
    }

    public boolean verifyHeaderExists(String hearderName){
        for(WebElement tableHeaders: headers){
            if(tableHeaders.getText().equalsIgnoreCase(hearderName)){
                return true;
            }
        }
        return false;
    }


}