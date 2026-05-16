package ui.pages.programStudi;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProgramStudi extends BasePage {
    public SearchProgramStudi (WebDriver driver) { super(driver); }

    @FindBy(xpath = "//button[contains(.,'Program Studi')]")
    private WebElement programStudiButton;

    @FindBy(xpath = "//input[@placeholder='Search program studi...']")
    private WebElement searchBarTextField;

    @FindBy(xpath = "//*[normalize-space()='Quality Assurance AI']")
    private WebElement searchResultColumn;

    public void searchProgramStudi(String programStudiName){
        programStudiButton.click();

        waitForElementToBeVisible(searchBarTextField);
        searchBarTextField.sendKeys(programStudiName);
    }

    public boolean isUserSuccesssearchProgramStudi() {
        try {
            waitForElementToBeVisible(searchResultColumn);
            return searchResultColumn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
