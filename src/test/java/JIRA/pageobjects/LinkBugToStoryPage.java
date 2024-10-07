package JIRA.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkBugToStoryPage {
    private WebDriver driver;

    private By linkField = By.id("link-field");
    private By linkButton = By.id("link-button");

    public LinkBugToStoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void linkBugToStory(String bugId) {
        driver.findElement(linkField).sendKeys(bugId);
        driver.findElement(linkButton).click();
    }
}
