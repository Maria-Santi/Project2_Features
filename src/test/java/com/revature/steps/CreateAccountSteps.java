package com.revature.steps;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateAccountSteps {


    @Given("The Customer is on the Create Account Page")
    public void the_Customer_is_on_the_Create_Account_Page() {
        BasicRunner.driver.get("https://project2frontend.s3.us-east-2.amazonaws.com/createaccount.html");
    }

    @When("The Customer types {string} into the first name bar")
    public void the_Customer_types_into_the_first_name_bar(String string) {
        BasicRunner.createAccountPage.firstName.sendKeys(string);
    }

    @When("The Customer types {string} into the last name bar")
    public void the_Customer_types_into_the_last_name_bar(String string) {
        BasicRunner.createAccountPage.lastName.sendKeys(string);
    }

    @When("The Customer types {string} into the username bar")
    public void the_Customer_types_into_the_username_bar(String string) {
        BasicRunner.createAccountPage.username.sendKeys(string);
    }

    @When("The Customer types {string} into the password bar")
    public void the_Customer_types_into_the_password_bar(String string) {
        BasicRunner.createAccountPage.password.sendKeys(string);
    }

    @When("The Customer clicks the login button")
    public void the_Customer_clicks_the_login_button() {
        BasicRunner.createAccountPage.loginButton.click();
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Then("The Customer should still be on the Create Account Page")
    public void the_Customer_should_still_be_on_the_Create_Account_Page() {
        String title = BasicRunner.driver.getTitle();
        Assert.assertEquals(title, "Create Account");
    }

}
