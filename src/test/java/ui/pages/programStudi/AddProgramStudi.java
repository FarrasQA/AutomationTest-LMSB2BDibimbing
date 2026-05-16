package ui.pages.programStudi;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProgramStudi extends BasePage {
    public AddProgramStudi(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//button[contains(.,'Program Studi')]")
    private WebElement programStudiButton;

    @FindBy(id = "add-division-button")
    private WebElement addProgramStudiButton;

    @FindBy(id = "name")
    private WebElement inputProgramNameTextField;

    @FindBy(id = "description")
    private WebElement inputProgramDescriptionTextField;

    @FindBy(id = "add-division-confirm-button")
    private WebElement addProgramStudiConfirmButton;

    @FindBy(xpath = "//*[normalize-space()='Success create program studi']")
    private WebElement successAddEmployeeNotification;

    @FindBy(xpath = "//*[normalize-space()='Required']")
    private WebElement requirementFillFieldNotification;

    public void addProgramStudi(String programStudiName, String programStudiDescription){
        waitForElementToBeClickable(programStudiButton);
        programStudiButton.click();

        waitForElementToBeClickable(addProgramStudiButton);
        addProgramStudiButton.click();

        inputProgramNameTextField.sendKeys(programStudiName);
        inputProgramDescriptionTextField.sendKeys(programStudiDescription);

        waitForElementToBeClickable(addProgramStudiConfirmButton);
        addProgramStudiConfirmButton.click();
    }

    public boolean isUserSuccessAddProgramStudi() {
        try {
            waitForElementToBeVisible(successAddEmployeeNotification);
            return successAddEmployeeNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addProgramStudiWithEmptyData(){
        waitForElementToBeClickable(programStudiButton);
        programStudiButton.click();

        waitForElementToBeClickable(addProgramStudiButton);
        addProgramStudiButton.click();

        waitForElementToBeClickable(addProgramStudiConfirmButton);
        addProgramStudiConfirmButton.click();
    }

    public boolean isUserFailAddProgramStudiWithEmptyData() {
        try {
            waitForElementToBeVisible(requirementFillFieldNotification);
            return requirementFillFieldNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
