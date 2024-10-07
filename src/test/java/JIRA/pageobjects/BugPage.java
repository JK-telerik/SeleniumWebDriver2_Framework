package JIRA.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugPage {
    private WebDriver driver;
    private By titleField = By.id("bug-title");
    private By descriptionField = By.id("bug-description");
    private By createButton = By.id("create-bug");

    public BugPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createBug(String title, String description) {
        driver.findElement(titleField).sendKeys(title);
        driver.findElement(descriptionField).sendKeys(description);
        driver.findElement(createButton).click();
    }

}
