package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboardPage {

    private WebDriver driver;

    public CustomerDashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dropdownMood")
    public WebElement moodDropdown;

    @FindBy(id = "Happy")
    public WebElement happyButton;

    @FindBy(id = "Sad")
    public WebElement sadButton;

    @FindBy(id = "Angry")
    public WebElement angryButton;

    @FindBy(id = "Anxious")
    public WebElement anxiousButton;

    @FindBy(id = "Sleepy")
    public WebElement sleepyButton;

    @FindBy(id = "ordersTableBody")
    public WebElement ordersTableBody;

    @FindBy(id = "submitBtn")
    public WebElement submitButton;

    @FindBy(id = "categorySelect")
    public WebElement categorySelect;

    @FindBy(id = "menuTableBody")
    public WebElement menuTableBody;

    @FindBy(xpath = "/html/body/div/div[3]/div[2]/table/tbody/tr[1]/td[4]/button")
    public WebElement firstMenuItemButton;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[4]/button")
    public WebElement firstOrderItemRemoveButton;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[2]/td[2]")
    public WebElement totalOrderQuantity;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[2]/input")
    public WebElement firstOrderItemQuantityInput;

    @FindBy(id = "logoutBtn")
    public WebElement logoutButton;
}
