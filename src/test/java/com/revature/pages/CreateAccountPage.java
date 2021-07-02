package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver){
        this.driver =  driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fnInput")
    public WebElement firstName;

    @FindBy(id = "lnInput")
    public WebElement lastName;

    @FindBy(id = "usernameInput")
    public WebElement username;

    @FindBy(id = "passwordInput")
    public WebElement password;

    @FindBy(id = "login")
    public WebElement loginButton;

}
