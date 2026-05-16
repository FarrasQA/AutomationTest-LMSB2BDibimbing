package ui.pages.employeeList;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEmployee extends BasePage {
    public SearchEmployee(WebDriver driver) { super(driver); }

    @FindBy(css = "#input-admin-employee-search input")
    private WebElement searchBarTextField;

    @FindBy(xpath = "//*[normalize-space()='Joy Happy']")
    private WebElement searchResultColumnByName;

    @FindBy(xpath = "//*[normalize-space()='5511']")
    private WebElement searchResultColumnByID;

    @FindBy(xpath = "//*[normalize-space()='joyhappy5511@gmail.com']")
    private WebElement searchResultColumnByEmail;

    public void searchEmployeeByName(String employeeName){
        waitForElementToBeClickable(searchBarTextField);
        searchBarTextField.sendKeys((Keys.CONTROL + "a"));
        searchBarTextField.sendKeys(Keys.DELETE);
        searchBarTextField.sendKeys(employeeName);
    }

    public boolean isUserSuccesssearchEmployeeByName() {
        try {
            waitForElementToBeVisible(searchResultColumnByID);
            return searchResultColumnByID.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void searchEmployeeByID(String employeeID){
        waitForElementToBeClickable(searchBarTextField);
        searchBarTextField.sendKeys((Keys.CONTROL + "a"));
        searchBarTextField.sendKeys(Keys.DELETE);
        searchBarTextField.sendKeys(employeeID);
    }

    public boolean isUserSuccesssearchEmployeeByID() {
        try {
            waitForElementToBeVisible(searchResultColumnByID);
            return searchResultColumnByID.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void searchEmployeeByEmail(String employeeEmail){
        waitForElementToBeClickable(searchBarTextField);
        searchBarTextField.sendKeys((Keys.CONTROL + "a"));
        searchBarTextField.sendKeys(Keys.DELETE);
        searchBarTextField.sendKeys(employeeEmail);
    }

    public boolean isUserSuccesssearchEmployeeByEmail() {
        try {
            waitForElementToBeVisible(searchResultColumnByEmail);
            return searchResultColumnByEmail.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}