package ui.pages.employeeList;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterByAngkatan extends BasePage {
    public FilterByAngkatan (WebDriver driver) { super(driver);}

    @FindBy(xpath = "//button[contains(normalize-space(),'Angkatan')]")
    private WebElement filterByAngkatanDropdown;

    @FindBy(xpath = "//button[contains(normalize-space(),'All Angkatan')]")
    private WebElement filterAllAngkatanOption;

    @FindBy(xpath = "//*[normalize-space()='2024 Ganjil']")
    private WebElement filter2024GanjilOption;

    @FindBy(id = "button-detail-employee-0")
    private WebElement detailEmployeeData2024GanjilButton;

    @FindBy(xpath = "//p[normalize-space()='Angkatan']/following-sibling::p")
    private WebElement detailEmployeeData2024GanjilText;

    @FindBy(xpath = "//*[normalize-space()='2024 Genap']")
    private WebElement filter2024GenapOption;

    @FindBy(id = "button-detail-employee-0")
    private WebElement detailEmployeeData2024GenapButton;

    @FindBy(xpath = "//p[normalize-space()='Angkatan']/following-sibling::p")
    private WebElement detailEmployeeData2024GenapText;

    @FindBy(xpath = "//*[normalize-space()='2025 Ganjil']")
    private WebElement filter2025GanjilOption;

    @FindBy(id = "button-detail-employee-0")
    private WebElement detailEmployeeData2025GanjilButton;

    @FindBy(xpath = "//p[normalize-space()='Angkatan']/following-sibling::p")
    private WebElement detailEmployeeData2025GanjilText;

    @FindBy(xpath = "//*[normalize-space()='2025 Genap']")
    private WebElement filter2025GenapOption;

    @FindBy(id = "button-detail-employee-0")
    private WebElement detailEmployeeData2025GenapButton;

    @FindBy(xpath = "//p[normalize-space()='Angkatan']/following-sibling::p")
    private WebElement detailEmployeeData2025GenapText;

    public void filterAllAngkatan(){
        waitForElementToBeClickable(filterByAngkatanDropdown);
        filterByAngkatanDropdown.click();

        waitForElementToBeClickable(filterAllAngkatanOption);
        filterAllAngkatanOption.click();
    }

    public void filterAngkatan2024Ganjil(){
        waitForElementToBeClickable(filterByAngkatanDropdown);
        filterByAngkatanDropdown.click();

        waitForElementToBeClickable(filter2024GanjilOption);
        filter2024GanjilOption.click();

        waitForElementToBeClickable(detailEmployeeData2024GanjilButton);
        detailEmployeeData2024GanjilButton.click();
    }

    public boolean isUserSuccessFilterEmployee2024Ganjil() {
        try {;
            waitForElementToBeVisible(detailEmployeeData2024GanjilText);
            return detailEmployeeData2024GanjilText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void filterAngkatan2024Genap(){
        waitForElementToBeClickable(filterByAngkatanDropdown);
        filterByAngkatanDropdown.click();

        waitForElementToBeClickable(filter2024GenapOption);
        filter2024GenapOption.click();

        waitForElementToBeClickable(detailEmployeeData2024GenapButton);
        detailEmployeeData2024GenapButton.click();
    }

    public boolean isUserSuccessFilterEmployee2024Genap() {
        try {
            waitForElementToBeVisible(detailEmployeeData2024GenapText);
            return detailEmployeeData2024GenapText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void filterAngkatan2025Ganjil(){
        waitForElementToBeClickable(filterByAngkatanDropdown);
        filterByAngkatanDropdown.click();

        waitForElementToBeClickable(filter2025GanjilOption);
        filter2025GanjilOption.click();

        waitForElementToBeClickable(detailEmployeeData2024GenapButton);
        detailEmployeeData2025GanjilButton.click();
    }

    public boolean isUserSuccessFilterEmployee2025Ganjil() {
        try {
            waitForElementToBeVisible(detailEmployeeData2025GanjilText);
            return detailEmployeeData2025GanjilText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void filterAngkatan2025Genap(){
        waitForElementToBeClickable(filterByAngkatanDropdown);
        filterByAngkatanDropdown.click();

        waitForElementToBeClickable(filter2025GenapOption);
        filter2025GenapOption.click();

        waitForElementToBeClickable(detailEmployeeData2024GenapButton);
        detailEmployeeData2025GenapButton.click();
    }

    public boolean isUserSuccessFilterEmployee2025Genap() {
        try {
            waitForElementToBeVisible(detailEmployeeData2025GenapText);
            return detailEmployeeData2025GenapText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
