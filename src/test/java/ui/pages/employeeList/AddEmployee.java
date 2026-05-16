package ui.pages.employeeList;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee extends BasePage {
    public AddEmployee(WebDriver driver) { super(driver); }

    @FindBy(id = "button-add-employee")
    private WebElement addEmployeeButton;

    @FindBy(id = "name")
    private WebElement inputEmployeeNameTextField;

    @FindBy(id = "employeeId")
    private WebElement inputEmployeeIDTextField;

    @FindBy(id = "email")
    private WebElement inputEmployeeEmailTextField;

    @FindBy(id = "phoneNumber")
    private WebElement inputEmployeePhoneNumberTextField;

    @FindBy(id = "employeeRole")
    private WebElement inputEmployeeRoleTextField;

    @FindBy(id = "division")
    private WebElement programStudiDropdown;

    @FindBy(xpath = "//*[normalize-space()='QUALITY ASSURANCE']")
    private WebElement qualityAssuranceProgramStudiOption;

    @FindBy(id = "button-add-employee-submit")
    private WebElement addEmployeeSubmitButton;

    @FindBy(xpath = "//*[normalize-space()='Success create employee']")
    private WebElement successAddEmployeeNotification;

    @FindBy(xpath = "//*[normalize-space()='Harap isi field yang wajib diisi.']")
    private WebElement requirementFillFieldNotification;

    @FindBy(xpath = "//*[normalize-space()='The user with this email is already registered, please use another email']")
    private WebElement emailAlreadyRegisteredNotification;

    public void addEmployee
            (String employeeName,
             String employeeID,
             String employeeEmail,
             String employeePhoneNumber,
             String employeeRole) {
        addEmployeeButton.click();
        inputEmployeeNameTextField.sendKeys(employeeName);
        inputEmployeeIDTextField.sendKeys(employeeID);
        inputEmployeeEmailTextField.sendKeys(employeeEmail);
        inputEmployeePhoneNumberTextField.sendKeys(employeePhoneNumber);
        inputEmployeeRoleTextField.sendKeys(employeeRole);
        programStudiDropdown.click();

        waitForElementToBeClickable(qualityAssuranceProgramStudiOption);
        qualityAssuranceProgramStudiOption.click();

        addEmployeeSubmitButton.click();
    }

    public boolean isUserSuccessAddEmployee() {
        try {
            waitForElementToBeVisible(successAddEmployeeNotification);
            return successAddEmployeeNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addEmployeeWithEmptyData(){
        addEmployeeButton.click();
        addEmployeeSubmitButton.click();
    }

    public boolean isUserFailAddEmployeeWithEmptyData() {
        try {
            waitForElementToBeVisible(requirementFillFieldNotification);
            return requirementFillFieldNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addEmployeeWithDuplicateData
            (String employeeName,
             String employeeID,
             String employeeEmail,
             String employeePhoneNumber,
             String employeeRole) {
        addEmployeeButton.click();
        inputEmployeeNameTextField.sendKeys(employeeName);
        inputEmployeeIDTextField.sendKeys(employeeID);
        inputEmployeeEmailTextField.sendKeys(employeeEmail);
        inputEmployeePhoneNumberTextField.sendKeys(employeePhoneNumber);
        inputEmployeeRoleTextField.sendKeys(employeeRole);
        programStudiDropdown.click();

        waitForElementToBeClickable(qualityAssuranceProgramStudiOption);
        qualityAssuranceProgramStudiOption.click();

        addEmployeeSubmitButton.click();
    }

    public boolean isUserFailAddEmployeeWithDuplicateData() {
        try {
            waitForElementToBeVisible(emailAlreadyRegisteredNotification);
            return emailAlreadyRegisteredNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}