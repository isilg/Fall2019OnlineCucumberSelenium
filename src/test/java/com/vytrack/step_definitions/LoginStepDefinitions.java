package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        BrowserUtilities.waitForPageToLoad(10); //add wait to help synchronization
        BrowserUtilities.wait(2);
        String URL = ConfigurationReader.getProperty("qa3");
        Driver.getDriver().get(URL);
    }

    @When("user logs in as a sales manager")
    public void user_logs_in_as_a_sales_manager() {
        System.out.println("Login as sales manager");
        BrowserUtilities.waitForPageToLoad(10); //add wait to help synchronization
        BrowserUtilities.wait(2);
        loginPage.login("salesmanager110", "UserUser123");
    }

    @When("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
       loginPage.login("storemanager85", "UserUser123");
    }

    @Then("user should verify that title is Dashboard")
    public void user_should_verify_that_title_is_Dashboard() {
        System.out.println("Verify that title is Dashboard");
        BrowserUtilities.waitForPageToLoad(10); //add wait to help synchronization
        BrowserUtilities.wait(2);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
    }

    @When("user logs in as a driver")
    public void user_logs_in_as_a_driver() {
        System.out.println("Login as a driver");
        BrowserUtilities.waitForPageToLoad(10); //add wait to help synchronization
        BrowserUtilities.wait(2);
        loginPage.login("user19", "UserUser123");
    }
}
