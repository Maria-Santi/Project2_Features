package com.revature.steps;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class OrderSteps {

    @Given("The Employee is on the Order Management Page")
    public void the_Employee_is_on_the_Order_Management_Page() {
        BasicRunner.driver.get("https://project2frontend.s3.us-east-2.amazonaws.com/employeedashboard.html");
    }

    @When("The Employee click an order from the order table")
    public void the_Employee_click_an_order_from_the_order_table() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.orderPage.firstOrderSelectButton));
        BasicRunner.orderPage.firstOrderSelectButton.click();
    }

    @Then("The Employee can view the details of the order")
    public void the_Employee_can_view_the_details_of_the_order() {
        List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.orderPage.detailsBody, By.tagName("tr")));
        Assert.assertTrue(tableRows.size()>=1);
    }

    @When("The Employee clicks the fulfill order button")
    public void the_Employee_clicks_the_fulfill_order_button() {
        List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.orderPage.getOrdersTable, By.tagName("tr")));
        BasicRunner.rowCount = tableRows.size();
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.orderPage.fullfillButton));
        BasicRunner.orderPage.fullfillButton.click();
    }

    @Then("The Order is fulfilled and removed from the order table")
    public void the_Order_is_fulfilled_and_removed_from_the_order_table() throws InterruptedException {
        Thread.sleep(3000);
        int size;
        try {
            List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 3).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.orderPage.getOrdersTable, By.tagName("tr")));
            size = tableRows.size();
        } catch (TimeoutException e) {
            size = 0;
        }

        Assert.assertTrue(size == BasicRunner.rowCount - 1);
    }

    @When("The Employee clicks on the logout button")
    public void the_Employee_clicks_on_the_logout_button() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.orderPage.logoutButton));
        BasicRunner.orderPage.logoutButton.click();
    }

    @Then("The Employee is logged out and redirected to the Homepage")
    public void the_Employee_is_logged_out_and_redirected_to_the_Homepage() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        wait.until(ExpectedConditions.titleIs("Git Your Java Home Page"));
        Assert.assertEquals(BasicRunner.driver.getTitle(), "Git Your Java Home Page");
    }
}
