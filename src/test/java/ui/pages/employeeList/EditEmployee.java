package ui.pages.employeeList;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditEmployee extends BasePage {
    public EditEmployee (WebDriver driver) { super(driver); }

    @FindBy(css = "#input-admin-employee-search input")
    private WebElement searchBarTextField;

    @FindBy(id = "button-detail-employee-0")
    private WebElement detailEmployeeDataButton;

    @FindBy(id = "edit-employee-button")
    private WebElement editEmployeeButton;

    @FindBy(id = "edit-employee-employee-role-input")
    private WebElement editEmployeeRoleTextField;

    @FindBy(id = "edit-employee-save-changes-button")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//*[normalize-space()='Success update employee']")
    private WebElement successEditEmployeeNotification;

    @FindBy(xpath = "//*[normalize-space()='Please fill required field']")
    private WebElement requirementFillFieldNotification;

    @FindBy(id = "activation-employee-button")
    private WebElement activationStatusButton;

    @FindBy(id = "activation-employee-confirm-button")
    private WebElement activationStatusConfirmStatusButton;

    @FindBy(xpath = "//*[normalize-space()='Inactive']")
    private WebElement inactiveSuccessStatus;

    @FindBy(xpath = "//*[normalize-space()='Active']")
    private WebElement activeSuccessStatus;

    public void editRoleEmployee(String employeeName, String editEmployeeRole){
        waitForElementToBeClickable(searchBarTextField);
        searchBarTextField.sendKeys(employeeName);

        waitForElementToBeClickable(detailEmployeeDataButton);
        detailEmployeeDataButton.click();

        waitForElementToBeClickable(editEmployeeButton);
        editEmployeeButton.click();

        editEmployeeRoleTextField.sendKeys((Keys.CONTROL + "a"));
        editEmployeeRoleTextField.sendKeys(Keys.DELETE);
        editEmployeeRoleTextField.sendKeys(editEmployeeRole);

        waitForElementToBeClickable(saveChangesButton);
        saveChangesButton.click();
    }

    public boolean isUserSuccessEditRoleEmployee() {
        try {
            waitForElementToBeVisible(successEditEmployeeNotification);
            return successEditEmployeeNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void editRoleEmployeeWithEmptyData(String employeeName){
        waitForElementToBeClickable(searchBarTextField);
        searchBarTextField.sendKeys((Keys.CONTROL + "a"));
        searchBarTextField.sendKeys(Keys.DELETE);
        searchBarTextField.sendKeys(employeeName);

        waitForElementToBeClickable(detailEmployeeDataButton);
        detailEmployeeDataButton.click();

        waitForElementToBeClickable(editEmployeeButton);
        editEmployeeButton.click();

        editEmployeeRoleTextField.sendKeys((Keys.CONTROL + "a"));
        editEmployeeRoleTextField.sendKeys(Keys.DELETE);

        waitForElementToBeClickable(saveChangesButton);
        saveChangesButton.click();
    }

    public boolean isUserFailEditRoleEmployee() {
        try {
            waitForElementToBeVisible(requirementFillFieldNotification);
            return requirementFillFieldNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void editActiveToInactiveStatusEmployee(String employeeName){
        waitForElementToBeClickable(searchBarTextField);
        searchBarTextField.sendKeys((Keys.CONTROL + "a"));
        searchBarTextField.sendKeys(Keys.DELETE);
        searchBarTextField.sendKeys(employeeName);

        waitForElementToBeClickable(detailEmployeeDataButton);
        detailEmployeeDataButton.click();

        waitForElementToBeClickable(activationStatusButton);
        activationStatusButton.click();

        waitForElementToBeClickable(activationStatusConfirmStatusButton);
        activationStatusConfirmStatusButton.click();
    }

    public boolean isUserSuccessInactiveStatusEmployee() {
        try {
            waitForElementToBeVisible(inactiveSuccessStatus);
            return inactiveSuccessStatus.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void editInactiveToActiveStatusEmployee(String employeeName){
        waitForElementToBeClickable(searchBarTextField);
        searchBarTextField.sendKeys((Keys.CONTROL + "a"));
        searchBarTextField.sendKeys(Keys.DELETE);
        searchBarTextField.sendKeys(employeeName);

        waitForElementToBeClickable(detailEmployeeDataButton);
        detailEmployeeDataButton.click();

        waitForElementToBeClickable(activationStatusButton);
        activationStatusButton.click();

        waitForElementToBeClickable(activationStatusConfirmStatusButton);
        activationStatusConfirmStatusButton.click();
    }

    public boolean isUserSuccessActiveStatusEmployee() {
        try {
            waitForElementToBeVisible(activeSuccessStatus);
            return activeSuccessStatus.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
