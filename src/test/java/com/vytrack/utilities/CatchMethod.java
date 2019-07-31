package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatchMethod {
    private static String loaderMaskLocator="div[class='loader-mask shown']";

    public static void waitUntilLoaderScreenDissapear(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(loaderMaskLocator))));



    }
}
