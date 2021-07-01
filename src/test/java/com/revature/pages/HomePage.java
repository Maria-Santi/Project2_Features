package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/nav/div/ul/li[1]/a")
    public WebElement createAccount;

    @FindBy(xpath = "/html/body/nav/div/ul/li[2]/a")
    public WebElement login;

}
