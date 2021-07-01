package com.revature.steps;


import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProfilePageSteps {

    @Given("Customer is on the Customer Profile Page")
    public void customer_is_on_the_Customer_Profile_Page() {
        BasicRunner.driver.get();
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 20);

        BasicRunner.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @When("I click on the Mood button")
    public void i_click_on_the_Mood_button() {
//        BasicRunner.ProfilePage.dropdownMood.click();
//        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 20);

    }






}
