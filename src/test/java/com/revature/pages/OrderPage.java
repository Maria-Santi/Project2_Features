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

    @FindBy(id = "ordersTable")
    public WebElement ordersTable;

    @FindBy(id = "tableOrders")
    public WebElement getOrdersTable;

    @FindBy(id = "fullfillButton")
    public WebElement fullfillButton;

    @FindBy(xpath ="/html/body/div/div[1]/div/table/tbody/tr[1]/td[4]/button")
    public WebElement firstOrderSelectButton;

    @FindBy(id ="detailsBody")
    public WebElement detailsBody;

    @FindBy(id = "logoutBtn")
    public WebElement logoutButton;

}