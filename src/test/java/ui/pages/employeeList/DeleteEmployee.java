package ui.pages.employeeList;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteEmployee extends BasePage {
    public DeleteEmployee(WebDriver driver) { super(driver); }

    @FindBy(css = "#input-admin-employee-search input")
    private WebElement searchBarTextField;

    @FindBy(id = "button-detail-employee-0")
    private WebElement detailEmployeeDataButton;

    @FindBy(id = "delete-employee-button")
    private WebElement deleteEmployeeButton;

    @FindBy(id = "confirm-delete-button")
    private WebElement deleteEmployeeConfirmButton;

    @FindBy(xpath = "//button[contains(.,'Program Studi')]")
    private WebElement programStudiButton;

    public void deleteEmployee(String employeeName){
        searchBarTextField.sendKeys(employeeName);

        waitForElementToBeClickable(detailEmployeeDataButton);
        detailEmployeeDataButton.click();

        waitForElementToBeClickable(deleteEmployeeButton);
        deleteEmployeeButton.click();

        deleteEmployeeConfirmButton.click();
    }

    public boolean isUserSuccessDeleteEmployee() {
        try {
            waitForElementToBeVisible(programStudiButton);
            return programStudiButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
