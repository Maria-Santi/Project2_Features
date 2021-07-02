package com.revature.steps;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageSteps {

    @Given("The User is on the Home Page")
    public void the_User_is_on_the_Home_Page() {
        BasicRunner.driver.get("https://project2frontend.s3.us-east-2.amazonaws.com/homepage.html");
    }

    @When("The User clicks on the login link")
    public void the_User_clicks_on_the_login_link() {
        BasicRunner.homePage.login.click();
    }

    @Then("The User should be on the Login Page")
    public void the_User_should_be_on_the_Login_Page() {
        String title = BasicRunner.driver.getTitle();
        Assert.assertEquals(title, "Login");
    }

    @When("The User clicks on the create account link")
    public void the_User_clicks_on_the_create_account_link() {
        BasicRunner.homePage.createAccount.click();
    }

    @Then("The User should be on the Create Account Page")
    public void the_User_should_be_on_the_Create_Account_Page() {
        String title = BasicRunner.driver.getTitle();
        Assert.assertEquals(title, "Create Account");
    }

}
