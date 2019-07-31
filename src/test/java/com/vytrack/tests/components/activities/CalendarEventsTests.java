package com.vytrack.tests.components.activities;

import com.vytrack.pages.activities.CalendarEventsPage;
import com.vytrack.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarEventsTests extends TestBase {

    @Test
    public void verifyTitleColumn(){
        CalendarEventsPage calendarPage=new CalendarEventsPage();
        String username= ConfigurationReader.getProperty("usernamestore");
        String password=ConfigurationReader.getProperty("password");
        loginPage.login(username,password);

        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        VYTrackUtils.navigateToModule("Activities","Calendar Events");
        CatchMethod.waitUntilLoaderScreenDissapear(driver);


        calendarPage.selectGridSetting("Title", false);

        Assert.assertFalse(calendarPage.verifyHeaderExists("Title"));


        calendarPage.selectGridSetting("Title",true);

        Assert.assertTrue(calendarPage.verifyHeaderExists("Title"));




    }
}
