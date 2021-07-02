package com.revature.steps;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginSteps {
    @Given("The User is on the Login Page")
    public void the_User_is_on_the_Login_Page() {
        BasicRunner.driver.get("https://project2frontend.s3.us-east-2.amazonaws.com/login.html");
    }

    @When("The User types {string} into the username bar")
    public void the_User_types_into_the_username_bar(String string) {
        BasicRunner.loginPage.usernameInput.sendKeys(string);
    }

    @When("The User types {string} into the password bar")
    public void the_User_types_into_the_password_bar(String string) {
        BasicRunner.loginPage.passwordInput.sendKeys(string);
    }

    @When("The User clicks the login button")
    public void the_User_clicks_the_login_button() {
        BasicRunner.loginPage.loginButton.click();
    }

    @When("The User clicks the login button and accepts the alert")
    public void the_User_clicks_the_login_button_and_accepts_the_alert() {
        BasicRunner.loginPage.loginButton.click();
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Then("The title should be {string}")
    public void the_title_should_be(String string) {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver,30);
        wait.until(ExpectedConditions.titleIs(string));
        String title = BasicRunner.driver.getTitle();
        Assert.assertEquals(title, string);
    }

}
