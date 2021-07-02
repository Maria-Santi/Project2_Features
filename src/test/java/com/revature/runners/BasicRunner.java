package com.revature.runners;

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
    public static OrderPage orderPage = null;
    public static int rowCount = 0;

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);


        loginPage = new LoginPage(driver);
        orderPage = new OrderPage(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }


}

