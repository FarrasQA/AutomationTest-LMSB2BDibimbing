package ui.pages.auth;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {
    public Login(WebDriver driver) { super(driver); }

    @FindBy(id = "input-username-or-email")
    private WebElement inputUsernameOrEmailTextField;

    @FindBy(id = "input-password")
    private WebElement inputpasswordTextField;

    @FindBy(id = "button-sign-in")
    private WebElement signinButton;

    @FindBy(id = "layout-desktop-menu-item-box-dashboard")
    private WebElement dashboardMenuButton;

    public void login(String username, String password){
        waitForElementToBeVisible(inputUsernameOrEmailTextField);
        inputUsernameOrEmailTextField.sendKeys(username);
        inputpasswordTextField.sendKeys(password);
        signinButton.click();
    }

    public boolean isUserSuccessLogin() {
        try {
            waitForElementToBeVisible(dashboardMenuButton);
            return dashboardMenuButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
