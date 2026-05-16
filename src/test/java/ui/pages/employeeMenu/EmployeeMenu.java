package ui.pages.employeeMenu;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeMenu extends BasePage {

    public EmployeeMenu(WebDriver driver) { super(driver); }

    @FindBy(id = "layout-desktop-menu-item-box-employee")
    private WebElement employeeMenuButton;

    @FindBy(xpath = "//button[contains(.,'Employee List')]")
    private WebElement employeeListButton;

    @FindBy(xpath = "//p[normalize-space()='Manage Employee List']")
    private WebElement manageEmployeeListText;

    private final By chakraModal =
            By.cssSelector(".chakra-modal__content-container");

    public void manageEmployeeData() {

        waitUntilOverlayDisappear();

        clickWithRetry(employeeMenuButton);

        waitUntilOverlayDisappear();

        clickWithRetry(employeeListButton);
    }

    public boolean isUserSuccessManageEmployeeData() {
        try {
            waitForElementToBeVisible(manageEmployeeListText);
            return manageEmployeeListText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void waitUntilOverlayDisappear() {
        try {
            waitForInvisibility(chakraModal);
        } catch (Exception ignored) {

        }
    }

    private void clickWithRetry(WebElement element) {

        int maxRetry = 3;

        for (int i = 0; i < maxRetry; i++) {

            try {

                waitForElementToBeClickable(element);

                scrollToElement(element);

                element.click();

                return;

            } catch (StaleElementReferenceException e) {

                if (i == maxRetry - 1) {
                    throw e;
                }
            }
        }
    }
}
