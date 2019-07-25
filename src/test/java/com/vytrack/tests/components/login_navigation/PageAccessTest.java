package com.vytrack.tests.components.login_navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CatchMethod;
import utilities.TestBase;

public class PageAccessTest extends TestBase {

    @Test(description = "Verify that you can access Vehicle contracts page" ,priority = 1)
    public void storeManager(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameStoreManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        ac.moveToElement(driver.findElement(By.linkText(fleetTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(vehiclesContractsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        String expectedUrl="http://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);


    }
    @Test(description = "Verify that you can access Vehicle contracts page", priority = 2)
    public void salesManager(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        ac.moveToElement(driver.findElement(By.linkText(fleetTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(vehiclesContractsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        String expectedUrl="http://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);


    }

    @Test(description = "Verify that you cannot access Vehicle contracts page", priority = 3)
    public void driverManager(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameDriver);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        ac.moveToElement(driver.findElement(By.linkText(fleetTabLocator))).perform();
        ac.moveToElement(driver.findElement(By.linkText(vehiclesContractsModuleLocator))).click().perform();
        CatchMethod.waitUntilLoaderScreenDissapear(driver);

        WebElement message=driver.findElement(By.xpath("(//*[@class='message'])[2]"));

        Assert.assertTrue(message.isDisplayed());

    }
}
