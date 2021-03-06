package com.revature.runners;

import com.revature.pages.CreateAccountPage;
import com.revature.pages.CustomerDashboardPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.OrderPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "com.revature.steps")

public class BasicRunner {

    public static WebDriver driver = null;
    public static LoginPage loginPage = null;
    public static CreateAccountPage createAccountPage = null;
    public static HomePage homePage = null;
    public static CustomerDashboardPage customerDashboardPage = null;
    public static OrderPage orderPage = null;
    public static int rowCount = 0;
    public static int orderQuantity = 0;

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        loginPage = new LoginPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        homePage = new HomePage(driver);
        customerDashboardPage = new CustomerDashboardPage(driver);
        orderPage = new OrderPage(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }


}

