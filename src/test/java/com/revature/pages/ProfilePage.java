package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
//
//    @FindBy(id ="drop" )
//    public WebElement drop;

}
