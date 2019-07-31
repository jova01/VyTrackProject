package com.vytrack.tests.components.activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vytrack.utilities.CatchMethod;
import com.vytrack.utilities.TestBase;

public class DataEndTime extends TestBase {

    String createCalendarEventMenu="[class='btn main-group btn-primary pull-right ']";
    String startDateLocator="input[id^='date_selector_oro_calendar_event_form_start']";
    String endDateLocator="input[id^='date_selector_oro_calendar_event_form_end']";
    String selectday30Locator="//tr[5]//td[3]";
    String todayButtonLocator="button[data-handler='today']";

    String startTimeLocator="input[id^='time_selector_oro_calendar_event_form_start']";
    String endTimeLocator="input[id^='time_selector_oro_calendar_event_form_end']";
    String time10PMLocator="/html/body/div[6]/ul/li[45]";
    String time11_30PM="/html/body/div[6]/ul/li[48]";


    @Test(description = "Date Time, End date auto adjust")
    public void test1(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameStoreManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        ac.moveToElement(driver.findElement(By.linkText(activitiesTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(calendarEventsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);


        driver.findElement(By.cssSelector(createCalendarEventMenu)).click();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        driver.findElement(By.cssSelector(startDateLocator)).click();
        driver.findElement(By.xpath(selectday30Locator)).click();
        String startDate1=driver.findElement(By.cssSelector(startDateLocator)).getAttribute("value");
        String endDate1=driver.findElement(By.cssSelector(endDateLocator)).getAttribute("value");

        driver.findElement(By.cssSelector(startDateLocator)).click();
        driver.findElement(By.cssSelector(todayButtonLocator)).click();
        String startDate2=driver.findElement(By.cssSelector(startDateLocator)).getAttribute("value");
        String endDate2=driver.findElement(By.cssSelector(endDateLocator)).getAttribute("value");

        Assert.assertEquals(startDate1,endDate1);
        Assert.assertEquals(startDate2,endDate2);

    }

    @Test
    public void test2(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameStoreManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        ac.moveToElement(driver.findElement(By.linkText(activitiesTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(calendarEventsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        driver.findElement(By.cssSelector(createCalendarEventMenu)).click();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        driver.findElement(By.cssSelector(startTimeLocator)).click();
        driver.findElement(By.xpath(time10PMLocator)).click();

        String startTime=driver.findElement(By.cssSelector(startTimeLocator)).getAttribute("value");
        String endTime=driver.findElement(By.cssSelector(endTimeLocator)).getAttribute("value");

        int start=Integer.parseInt(startTime.substring(0,startTime.indexOf(":")));
        int end=Integer.parseInt(endTime.substring(0,endTime.indexOf(":")));

        Assert.assertTrue(end-start==1);

    }

    @Test
    public void test3(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameStoreManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        ac.moveToElement(driver.findElement(By.linkText(activitiesTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(calendarEventsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        driver.findElement(By.cssSelector(createCalendarEventMenu)).click();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        driver.findElement(By.cssSelector(startTimeLocator)).click();
        driver.findElement(By.xpath(time11_30PM)).click();

        String startDate1=driver.findElement(By.cssSelector(startDateLocator)).getAttribute("value");
        String endDate1=driver.findElement(By.cssSelector(endDateLocator)).getAttribute("value");

        int startDate=Integer.parseInt(startDate1.substring(4,startDate1.indexOf(",")));
        int endDate=Integer.parseInt(endDate1.substring(4,startDate1.indexOf(",")));


        String expectedEndTime=driver.findElement(By.cssSelector(endTimeLocator)).getAttribute("value");
        String actualEndTime="12:30 AM";

        Assert.assertTrue(endDate-startDate==1);
        Assert.assertEquals(expectedEndTime,actualEndTime);


    }
}
