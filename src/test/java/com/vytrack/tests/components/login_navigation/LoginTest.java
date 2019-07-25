package com.vytrack.tests.components.login_navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CatchMethod;
import utilities.TestBase;

public class LoginTest extends TestBase {




    @Test (description = "Positive Login scenarios", priority = 1)
    public void positiveLogin(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameStoreManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String dashboardPageExpectedName="Dashboard";
        String dashboardPageActualName=driver.findElement(By.className(pageNameLocator)).getText();
        String actualStoreManager=driver.findElement(By.linkText("Pearl Wuckert")).getText();
        driver.findElement(By.linkText("Pearl Wuckert")).click();
        driver.findElement(By.cssSelector(logoutButton)).click();


        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String dashboardPage2ExpectedName="Dashboard";
        String dashboardPage2ActualName=driver.findElement(By.className(pageNameLocator)).getText();
        String actualSalesManager=driver.findElement(By.linkText("Mariela Koch")).getText();
        driver.findElement(By.linkText("Mariela Koch")).click();
        driver.findElement(By.cssSelector(logoutButton)).click();

        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameDriver);
        driver.findElement(By.id(passwordIDLocator)).sendKeys(password, Keys.ENTER);
        CatchMethod.waitUntilLoaderScreenDissapear(driver);
        String launchPageExpectedName="Quick Launchpad";
        String launchPageActualName=driver.findElement(By.className(pageNameLocator)).getText();
        String actualDriver=driver.findElement(By.linkText("Monte Marquardt")).getText();

        Assert.assertTrue(!actualStoreManager.isEmpty());
        Assert.assertEquals(dashboardPageExpectedName,dashboardPageActualName);
        Assert.assertNotEquals(actualSalesManager , actualStoreManager);
        Assert.assertEquals(dashboardPage2ExpectedName,dashboardPage2ActualName);
        Assert.assertNotEquals(actualDriver, actualSalesManager);
        Assert.assertEquals(launchPageExpectedName,launchPageActualName);

    }

    @Test (description = "Negative Login scenarios", priority = 2)
    public void negativeLogin(){
        driver.findElement(By.id(loginIDLocator)).sendKeys(usernameStoreManager);
        driver.findElement(By.id(passwordIDLocator)).sendKeys("Wrong Password", Keys.ENTER);

        WebElement message=driver.findElement(By.cssSelector("div[class='alert alert-error']"));

        String expectedPageTitle="Login";
        String actualPageTitle=(String) js.executeScript("return document.title");

        String expectedUrl="http://qa2.vytrack.com/user/login";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        Assert.assertEquals(expectedUrl,actualUrl);

    }

}
