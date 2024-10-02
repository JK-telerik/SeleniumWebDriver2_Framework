package saucedemotests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import saucedemotests.core.SauceDemoBaseWebTest;
import saucedemotests.enums.TestData;

public class LoginTests extends SauceDemoBaseWebTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        loginPage.navigate();
        loginPage.submitLoginForm(TestData.STANDARD_USER_USERNAME.getValue(), TestData.STANDARD_USER_PASSWORD.getValue());
        inventoryPage.waitForPageTitle();
        Assertions.assertTrue(inventoryPage.getShoppingCartItemsNumber() >= 0, "Failed to navigate to the Inventory page after login.");
    }

    @Test
    public void userAuthenticationFails_when_invalidCredentialsProvided() {
        loginPage.navigate();
        loginPage.submitLoginForm(TestData.STANDARD_USER_USERNAME.getValue(), "wrong_password");
        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed for invalid login.");
    }

    @Test
    public void userAuthenticationFails_when_lockedOutUserTriesToLogin() {
        loginPage.navigate();
        loginPage.submitLoginForm(TestData.STANDARD_USER_LOCKED_OUT_USER.getValue(), TestData.STANDARD_USER_PASSWORD.getValue());
        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed for the locked-out user.");
    }
}