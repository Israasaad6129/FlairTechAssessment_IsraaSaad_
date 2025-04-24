package org.opensource.stepdefs;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opensource.pages.LoginPage;
import org.testng.Assert;

public class LoginPageStepDef {


        WebDriver driver;
        LoginPage loginPage;
        int initialCount;
        int finalCount;

        @Given("open OrangeHRM login page")
        public void open_login_page() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/");
            LoginPage loginpage = new LoginPage(driver);
        }

        @When("enter {string} as username and {string} as password")
        public void enter_credentials(String username, String password) {
            loginPage.login(username, password);
        }

        @Then("click on login button")
        public void click_login() {
            // Already clicked in login method
        }

        @Then("click on {string} tab")
        public void click_on_tab(String tabName) {
            loginPage.goToAdminTab();
        }

        @Then("get the number of records found")
        public void get_record_count() {
            initialCount = loginPage.getRecordCount();
        }

        @Then("click on {string} button")
        public void click_on_button(String buttonName) {
            if (buttonName.equals("Add")) {
                loginPage.clickAddButton();
            } else if (buttonName.equals("Save")) {
                loginPage.clickSaveButton();
            }
        }

        @Then("enter {string} as User Role and {string} as Employee Name and {string} as Status and {string} as Username")
        public void enter_user_data(String role, String empName, String status, String username) {
            loginPage.fillUserDetails(role, empName, status, username);
            loginPage.clickSaveButton();
        }

        @Then("the Record found should be increased by 1")
        public void validate_record_increment() {
            finalCount = loginPage.getRecordCount();
            Assert.assertEquals(finalCount, initialCount + 1);
        }

        @When("search with Username {string}")
        public void search_user(String username) {
            loginPage.searchUser(username);
        }

        @And("delete the found record")
        public void delete_user() {
            loginPage.deleteUser();
        }

        @Then("the Record found should be decreased by 1")
        public void validate_record_decrement() {
            int newCount = loginPage.getRecordCount();
            Assert.assertEquals(newCount, finalCount - 1);
            driver.quit();
        }
    }
