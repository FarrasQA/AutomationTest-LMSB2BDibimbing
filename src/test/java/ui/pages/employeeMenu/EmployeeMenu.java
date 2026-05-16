package ui.pages.employeeMenu;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeMenu extends BasePage {
    public EmployeeMenu (WebDriver driver) { super(driver); }

    @FindBy(id = "layout-desktop-menu-item-box-employee")
    private WebElement employeeMenuButton;

    @FindBy(xpath = "//button[contains(.,'Employee List')]")
    private WebElement employeeListButton;

    @FindBy(xpath = "//p[normalize-space()='Manage Employee List']")
    private WebElement manageEmployeeListText;

    public void manageEmployeeData(){
        waitForElementToBeClickable(employeeMenuButton);
        employeeMenuButton.click();

        waitForElementToBeClickable(employeeListButton);
        employeeListButton.click();
    }

    public boolean isUserSuccessManageEmployeeData() {
        try {
            waitForElementToBeVisible(manageEmployeeListText);
            return manageEmployeeListText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
