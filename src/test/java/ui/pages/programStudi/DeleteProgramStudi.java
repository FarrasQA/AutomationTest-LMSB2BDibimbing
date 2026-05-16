package ui.pages.programStudi;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProgramStudi extends BasePage {
    public DeleteProgramStudi (WebDriver driver) { super(driver); }

    @FindBy(xpath = "//button[contains(.,'Program Studi')]")
    private WebElement programStudiButton;

    @FindBy(xpath = "//input[@placeholder='Search program studi...']")
    private WebElement searchBarTextField;

    @FindBy(id = "detail-division-button")
    private WebElement detailProgramStudiButton;

    @FindBy(id = "edit-division-button")
    private WebElement editProgramStudiButton;

    @FindBy(id = "delete-division-button")
    private WebElement deleteProgramStudiButton;

    @FindBy(id = "delete-division-confirm-button")
    private WebElement deleteProgramStudiConfirmationButton;

    @FindBy(xpath = "//*[normalize-space()='Success delete program studi']")
    private WebElement successDeleteEmployeeNotification;

    public void deleteProgramStudi(String programStudiName){
        programStudiButton.click();

        waitForElementToBeVisible(searchBarTextField);
        searchBarTextField.sendKeys(programStudiName);

        waitForElementToBeClickable(detailProgramStudiButton);
        detailProgramStudiButton.click();

        waitForElementToBeClickable(editProgramStudiButton);
        editProgramStudiButton.click();

        waitForElementToBeClickable(deleteProgramStudiButton);
        deleteProgramStudiButton.click();

        waitForElementToBeClickable(deleteProgramStudiConfirmationButton);
        deleteProgramStudiConfirmationButton.click();
    }

    public boolean isUserSuccessDeleteProgramStudi() {
        try {
            waitForElementToBeVisible(successDeleteEmployeeNotification);
            return successDeleteEmployeeNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
