package com.revature.runners;

import com.revature.pages.ProfilePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "com.revature.steps")

public class BasicRunner {

    public static WebDriver driver = null;
    public static ProfilePage profilePage = null;


    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        profilePage = new ProfilePage(driver);

     //   BasicRunner.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void teardown(){
  //      BasicRunner.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }


}

