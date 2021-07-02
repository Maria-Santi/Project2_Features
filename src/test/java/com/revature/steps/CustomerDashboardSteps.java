package com.revature.steps;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CustomerDashboardSteps {

    @Given("The Customer is on the customer dashboard")
    public void the_Customer_is_on_the_customer_dashboard() throws InterruptedException {
        BasicRunner.driver.get("https://project2frontend.s3.us-east-2.amazonaws.com/login.html");
        BasicRunner.loginPage.usernameInput.sendKeys("jordanP");
        BasicRunner.loginPage.passwordInput.sendKeys("Abc123");
        BasicRunner.loginPage.loginButton.click();
        //Thread.sleep(500);
    }

    //mood
    @When("The Customer chooses {string}")
    public void the_Customer_chooses(String string) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.customerDashboardPage.moodDropdown));
        BasicRunner.customerDashboardPage.moodDropdown.click();
        if (string.equals("Happy")) {
            BasicRunner.customerDashboardPage.happyButton.click();
        } else if (string.equals("Sad")) {
            BasicRunner.customerDashboardPage.sadButton.click();
        } else if (string.equals("Angry")) {
            BasicRunner.customerDashboardPage.angryButton.click();
        } else if (string.equals("Anxious")) {
            BasicRunner.customerDashboardPage.anxiousButton.click();
        } else if (string.equals("Sleepy")) {
            BasicRunner.customerDashboardPage.sleepyButton.click();
        }
    }

    @Then("An item should be added to the order")
    public void an_item_should_be_added_to_the_order() throws InterruptedException {
        Thread.sleep(500);
        List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.customerDashboardPage.ordersTableBody, By.tagName("tr")));
        Assert.assertTrue(tableRows.size() == 2);
    }

    //category
    @When("The Customer chooses a {string}")
    public void the_Customer_chooses_a(String string) {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.customerDashboardPage.categorySelect));
        Select dropdown = new Select(BasicRunner.customerDashboardPage.categorySelect);
        dropdown.selectByValue(string);
    }

    @Then("The menu is updated with {string} items")
    public void the_menu_is_updated_with_items(String string) throws InterruptedException {
        Thread.sleep(500);
        List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.customerDashboardPage.menuTableBody, By.tagName("tr")));
        if (string.equals("Cold Drinks")) {
            Assert.assertTrue(tableRows.size() == 9);
        } else if (string.equals("Hot Drinks")) {
            Assert.assertTrue(tableRows.size() == 6);
        } else if (string.equals("Food")) {
            Assert.assertTrue(tableRows.size() == 5);
        } else if (string.equals("Coffee Beans")) {
            Assert.assertTrue(tableRows.size() == 5);
        } else if (string.equals("Merch")) {
            Assert.assertTrue(tableRows.size() == 5);
        }

    }

    @When("The Customer adds an item from the menu")
    public void the_Customer_adds_an_item_from_the_menu() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.customerDashboardPage.firstMenuItemButton));
        List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.customerDashboardPage.ordersTableBody, By.tagName("tr")));
        BasicRunner.rowCount = tableRows.size();
        BasicRunner.customerDashboardPage.firstMenuItemButton.click();
    }

    @Then("The item appears in the order")
    public void the_item_appears_in_the_order() throws InterruptedException {
        Thread.sleep(500);
        List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.customerDashboardPage.ordersTableBody, By.tagName("tr")));
        Assert.assertTrue(tableRows.size() == BasicRunner.rowCount + 1);
    }

    @When("The Customer removes the item")
    public void the_Customer_removes_the_item() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.customerDashboardPage.firstOrderItemRemoveButton));
        BasicRunner.customerDashboardPage.firstOrderItemRemoveButton.click();
    }

    @Then("The item disappears from the order")
    public void the_item_disappears_from_the_order() throws InterruptedException {
        Thread.sleep(500);
        List<WebElement> tableRows = new WebDriverWait(BasicRunner.driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(BasicRunner.customerDashboardPage.ordersTableBody, By.tagName("tr")));
        Assert.assertTrue(tableRows.size() == BasicRunner.rowCount);
    }

    @When("The customer clicks the order button")
    public void the_customer_clicks_the_order_button() {
        BasicRunner.customerDashboardPage.submitButton.click();
    }

    @Then("The order is placed and the customer is logged out")
    public void the_order_is_placed_and_the_customer_is_logged_out() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        wait.until(ExpectedConditions.titleIs("Git Your Java Home Page"));
        Assert.assertEquals(BasicRunner.driver.getTitle(), "Git Your Java Home Page");
    }

    @When("The Customer increments the quantity of the item")
    public void the_Customer_increments_the_quantity_of_the_item() {
        BasicRunner.orderQuantity = Integer.parseInt(BasicRunner.customerDashboardPage.totalOrderQuantity.getAttribute("innerHTML"));
        BasicRunner.customerDashboardPage.firstOrderItemQuantityInput.sendKeys(Keys.ARROW_UP);
    }

    @Then("The total quantity is incremented")
    public void the_total_quantity_is_incremented() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(Integer.parseInt(BasicRunner.customerDashboardPage.totalOrderQuantity.getAttribute("innerHTML")), BasicRunner.orderQuantity + 1);
    }

    @When("The Customer clicks the logout button")
    public void the_Customer_clicks_the_logout_button() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.customerDashboardPage.logoutButton));
        BasicRunner.customerDashboardPage.logoutButton.click();
    }

    @Then("The customer is logged out")
    public void the_customer_is_logged_out() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 5);
        wait.until(ExpectedConditions.titleIs("Git Your Java Home Page"));
        Assert.assertEquals(BasicRunner.driver.getTitle(), "Git Your Java Home Page");
    }
}
