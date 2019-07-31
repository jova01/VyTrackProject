package com.vytrack.pages.login_navigation;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver= Driver.getDriver();

    @FindBy(id="prependedInput")
    public WebElement usernameElement;

    @FindBy(name="_password")
    public WebElement passwordElement;

    @FindBy(id="_submit")
    public WebElement loginButtonElement;

    @FindBy(className="custom-checkbox__icon")
    public WebElement rememberMeElement;

    @FindBy(partialLinkText = "Forgot your password")
    public WebElement forgotPasswordElement;

    @FindBy(tagName = "h2")
    public WebElement titleElement;

    @FindBy(css="[class='alert alert-error'] > div")
    public WebElement errorMessageElement;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }


    public void login(String username, String password){
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }


    public void clickRememberMe(){
        if(!rememberMeElement.isSelected()){
            rememberMeElement.click();
        }
    }

}
