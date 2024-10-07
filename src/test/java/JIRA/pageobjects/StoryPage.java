package JIRA.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoryPage {
    private WebDriver driver;

    // Define locators
    private By titleField = By.id("title");
    private By descriptionField = By.id("description");
    private By createButton = By.id("create");
    private By successMessage = By.id("success-message");
    private By errorMessage = By.id("error-message");

    public StoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createStory(String title, String description) {
        waitForElementToBeVisible(titleField);
        driver.findElement(titleField).sendKeys(title);

        waitForElementToBeVisible(descriptionField);
        driver.findElement(descriptionField).sendKeys(description);

        waitForElementToBeClickable(createButton);
        driver.findElement(createButton).click();
    }

    public boolean isStoryCreatedSuccessfully() {
        try {
            waitForElementToBeVisible(successMessage);
            WebElement message = driver.findElement(successMessage);
            return message.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            waitForElementToBeVisible(errorMessage);
            WebElement message = driver.findElement(errorMessage);
            return message.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}