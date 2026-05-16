package ui.pages.programStudi;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProgramStudi extends BasePage {
    public EditProgramStudi (WebDriver driver) { super(driver); }

    @FindBy(xpath = "//button[contains(.,'Program Studi')]")
    private WebElement programStudiButton;

    @FindBy(xpath = "//input[@placeholder='Search program studi...']")
    private WebElement searchBarTextField;

    @FindBy(id = "detail-division-button")
    private WebElement detailProgramStudiButton;

    @FindBy(id = "edit-division-button")
    private WebElement editProgramStudiButton;

    @FindBy(id = "description")
    private WebElement inputProgramDescriptionTextField;

    @FindBy(id = "edit-division-confirm-button")
    private WebElement editProgramStudiConfirmationButton;

    @FindBy(xpath = "//*[normalize-space()='Quality Assurance for Artificial Intelligence']")
    private WebElement programStudiDescriptionDetailData;

    @FindBy(xpath = "//*[normalize-space()='Required']")
    private WebElement requirementFillFieldNotification;

    public void editProgramStudiDescription(
            String programStudiName,
            String editProgramStudiDescription){

        waitForElementToBeClickable(programStudiButton);
        programStudiButton.click();

        waitForElementToBeVisible(searchBarTextField);
        searchBarTextField.sendKeys(programStudiName);

        waitForElementToBeClickable(detailProgramStudiButton);
        detailProgramStudiButton.click();

        waitForElementToBeClickable(editProgramStudiButton);
        editProgramStudiButton.click();

        inputProgramDescriptionTextField.sendKeys((Keys.CONTROL + "a"));
        inputProgramDescriptionTextField.sendKeys(Keys.DELETE);
        inputProgramDescriptionTextField.sendKeys(editProgramStudiDescription);

        waitForElementToBeClickable(editProgramStudiConfirmationButton);
        editProgramStudiConfirmationButton.click();
    }

    public boolean isUserSuccessEditProgramStudiDescription() {
        try {
            waitForElementToBeVisible(programStudiDescriptionDetailData);
            return programStudiDescriptionDetailData.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void editProgramStudiWithEmptyDescription(String programStudiName){

        waitForElementToBeClickable(programStudiButton);
        programStudiButton.click();

        waitForElementToBeVisible(searchBarTextField);
        searchBarTextField.sendKeys(programStudiName);

        waitForElementToBeClickable(detailProgramStudiButton);
        detailProgramStudiButton.click();

        waitForElementToBeClickable(editProgramStudiButton);
        editProgramStudiButton.click();

        inputProgramDescriptionTextField.sendKeys((Keys.CONTROL + "a"));
        inputProgramDescriptionTextField.sendKeys(Keys.DELETE);

        waitForElementToBeClickable(editProgramStudiConfirmationButton);
        editProgramStudiConfirmationButton.click();
    }

    public boolean isUserFailEditProgramStudiWithEmptyDescription() {
        try {
            waitForElementToBeVisible(programStudiDescriptionDetailData);
            return programStudiDescriptionDetailData.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
