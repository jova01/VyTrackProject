package com.vytrack.tests.smoke_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vytrack.utilities.CatchMethod;
import com.vytrack.utilities.TestBase;

public class MenuOptionsTest extends TestBase {


    @Test
    public void vehicleTest(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameDriver);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);

        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        ac.moveToElement(driver.findElement(By.linkText(fleetTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(vehiclesModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String vehiclesTitle= (String) js.executeScript("return document.title");
        String vehiclesTitleName="Car - Entities - System - Car - Entities - System";
        String carsPageExpectedName="All Cars";
        String carsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();


        ac.moveToElement(driver.findElement(By.linkText(customersTabLcoator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(accountsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String accountsTitle=(String) js.executeScript("return document.title");
        String accountTitleName="Accounts - Customers";
        String accountsPageExpectedName="Accounts";
        String accountsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();


        ac.moveToElement(driver.findElement(By.linkText(customersTabLcoator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(contactsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String contactsTitle=(String) js.executeScript("return document.title");
        String contactsTitleName="Contacts - Customers";
        String contactsPageExpectedName="Contacts";
        String contactsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();


        ac.moveToElement(driver.findElement(By.linkText(activitiesTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(calendarEventsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String calendarEventsTitle=(String) js.executeScript("return document.title");
        String calendarEventsTitleName="Calendar Events - Activities";
        String calendarEventsPageExpectedName="Calendar Events";
        String calendarEventsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();

        Assert.assertEquals(vehiclesTitle,vehiclesTitleName);
        Assert.assertNotEquals(carsPageExpectedName,carsPageActualName);
        Assert.assertEquals(accountsTitle,accountTitleName);
        Assert.assertEquals(accountsPageExpectedName,accountsPageActualName);
        Assert.assertEquals(contactsTitle,contactsTitleName);
        Assert.assertEquals(contactsPageExpectedName, contactsPageActualName);
        Assert.assertEquals(calendarEventsTitle,calendarEventsTitleName);
        Assert.assertEquals(calendarEventsPageExpectedName,calendarEventsPageActualName);
    }

    @Test
    public void vehicleTest2(){

        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameStoreManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);

        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        driver.findElement(By.linkText(dashboardTabLocator)).click();
        driver.findElement(By.linkText(dashboardModuleLocator)).click();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String dashboardTitle= (String) js.executeScript("return document.title");
        String dashboardTitleName="Dashboard - Dashboards";
        String dashboardPageExpectedName="Dashboard";
        String dashboardPageActualName=driver.findElement(By.className(pageNameLocator)).getText();


        ac.moveToElement(driver.findElement(By.linkText(fleetTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(vehiclesModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String vehiclesTitle= (String) js.executeScript("return document.title");
        String vehiclesTitleName="All - Car - Entities - System - Car - Entities - System";
        String carsPageExpectedName="All Cars";
        String carsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();

        ac.moveToElement(driver.findElement(By.linkText(customersTabLcoator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(accountsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String accountsTitle=(String) js.executeScript("return document.title");
        String accountTitleName="All - Accounts - Customers";
        String accountsPageExpectedName="All Accounts";
        String accountsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();

        ac.moveToElement(driver.findElement(By.linkText(customersTabLcoator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(contactsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String contactsTitle=(String) js.executeScript("return document.title");
        String contactsTitleName="All - Contacts - Customers";
        String contactsPageExpectedName="All Contacts";
        String contactsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();

        ac.moveToElement(driver.findElement(By.linkText(salesTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(opportunitiesModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String oppotunitiesTitle=(String) js.executeScript("return document.title");
        String oppotunitiesTitleName="Open Opportunities - Opportunities - Sales";
        String oppotunitiesPageExpectedName="Open Opportunities";
        String oppotunitiesPageActualName=driver.findElement(By.className(pageNameLocator)).getText();

        ac.moveToElement(driver.findElement(By.linkText(activitiesTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(callsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String callsTitle=(String) js.executeScript("return document.title");
        String callsTitleName="All - Calls - Activities";
        String callsPageExpectedName="All Calls";
        String callsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();



        driver.findElement(By.className(pageNameLocator)).click();
        ac.moveToElement(driver.findElement(By.linkText(activitiesTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(calendarEventsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String calendarEventsTitle=(String) js.executeScript("return document.title");
        String calendarEventsTitleName="All - Calendar Events - Activities";
        String calendarEventsPageExpectedName="All Calendar Events";
        String calendarEventsPageActualName=driver.findElement(By.className(pageNameLocator)).getText();

        Assert.assertEquals(dashboardTitle,dashboardTitleName);
        Assert.assertEquals(dashboardPageExpectedName,dashboardPageActualName);
        Assert.assertEquals(vehiclesTitle,vehiclesTitleName);
        Assert.assertEquals(carsPageExpectedName,carsPageActualName);
        Assert.assertEquals(accountsTitle,accountTitleName);
        Assert.assertEquals(accountsPageExpectedName,accountsPageActualName);
        Assert.assertEquals(contactsTitle,contactsTitleName);
        Assert.assertEquals(contactsPageExpectedName, contactsPageActualName);
        Assert.assertEquals(oppotunitiesTitle,oppotunitiesTitleName);
        Assert.assertEquals(oppotunitiesPageExpectedName,oppotunitiesPageActualName);
        Assert.assertEquals(callsTitle,callsTitleName);
        Assert.assertEquals(callsPageExpectedName,callsPageActualName);
        Assert.assertEquals(calendarEventsTitle,calendarEventsTitleName);
        Assert.assertEquals(calendarEventsPageExpectedName,calendarEventsPageActualName);

    }


}
