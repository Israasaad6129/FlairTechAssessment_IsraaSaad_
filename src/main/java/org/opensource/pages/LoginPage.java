package org.opensource.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    private WebDriver driver;


    //By Locators
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By adminTab = By.xpath("//span[text()='Admin']");
    private final By recordCountText = By.xpath("//span[contains(text(),'Records Found')]");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");


    // Fields on add user page
    private final By userRoleDropdown = By.xpath("//label[text()='User Role']/following::div[1]");
    private final By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private final By statusDropdown = By.xpath("//label[text()='Status']/following::div[1]");
    private final By newUsernameInput = By.xpath("//label[text()='Username']/following::input[1]");
    private final By saveButton = By.xpath("//button[normalize-space()='Save']");

    private final By searchInput = By.xpath("//label[text()='Username']/following::input[1]");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By deleteButton = By.xpath("//i[@class='oxd-icon bi-trash']");
    private final By confirmDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");

    // Actions
    public void login(String username, String password)
    {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void goToAdminTab()
    {
        driver.findElement(adminTab).click();
    }

    public int getRecordCount()
    {
        String text = driver.findElement(recordCountText).getText(); // e.g. "Records Found: 35"
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public void clickAddButton()
    {
        driver.findElement(addButton).click();
    }

    public void fillUserDetails(String role, String empName, String status, String username)
    {
        driver.findElement(userRoleDropdown).click();
        driver.findElement(By.xpath("//span[text()='" + role + "']")).click();

        driver.findElement(employeeNameInput).sendKeys("Arthur thi Ghamboyan");

        driver.findElement(statusDropdown).click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();

        driver.findElement(newUsernameInput).sendKeys("Israa");
    }

    public void clickSaveButton()
    {
        driver.findElement(saveButton).click();
    }

    public void searchUser(String username)
    {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(username);
        driver.findElement(searchButton).click();
    }

    public void deleteUser()
    {
        driver.findElement(deleteButton).click();
        driver.findElement(confirmDeleteButton).click();
    }
}
