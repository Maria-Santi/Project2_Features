package com.revature.steps;


import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrderHomePageSteps {

    @Given("Customer is on the Customer Profile Page")
    public void customer_is_on_the_Customer_Profile_Page() {
        BasicRunner.driver.get("http://localhost:63342/Project2_FrontEnd/customerdashboard.html?_ijt=88rpv72c1hl4ba56bvmeiik3qe");
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 20);

        BasicRunner.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @When("I click on the Mood button")
    public void i_click_on_the_Mood_button() {
//        BasicRunner.orderPage.drop.click();
      //  WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 20);

    }






}
