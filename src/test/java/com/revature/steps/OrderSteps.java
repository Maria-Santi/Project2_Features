package com.revature.steps;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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


    @When("The Employee select the order table")
    public void the_Employee_select_the_order_table() {
        BasicRunner.orderPage.ordersTable.click();


    }

    @When("The Employee click an order from the order table")
    public void the_Employee_click_an_order_from_the_order_table() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.orderPage.firstOrderSelectButton));
        BasicRunner.orderPage.firstOrderSelectButton.click();


    }

    @Then("The Employee can view the details of the order")
    public void the_Employee_can_view_the_details_of_the_order() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.orderPage.detailsBody, By.tagName("tr")));
        Assert.assertTrue(tableRows.size()>=1);


    }







}
