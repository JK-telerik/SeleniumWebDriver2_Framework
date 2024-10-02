package saucedemotests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saucedemotests.core.SauceDemoBaseWebTest;
import saucedemotests.enums.TestData;

public class ProductsTests extends SauceDemoBaseWebTest {
    public final String BACKPACK_TITLE = "Sauce Labs Backpack";
    public final String SHIRT_TITLE = "Sauce Labs Bolt T-Shirt";

    @BeforeEach
    public void beforeTest() {
        loginPage.navigate();
        loginPage.submitLoginForm(TestData.STANDARD_USER_USERNAME.getValue(), TestData.STANDARD_USER_PASSWORD.getValue());
        inventoryPage.waitForPageTitle();
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart() {
        inventoryPage.addProductsByTitle(BACKPACK_TITLE, SHIRT_TITLE);
        inventoryPage.clickShoppingCartLink();
        Assertions.assertEquals(2, shoppingCartPage.getShoppingCartItems().size(), "Shopping cart item count does not match expected.");
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
        inventoryPage.addProductsByTitle(BACKPACK_TITLE);
        inventoryPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckout();

        checkoutYourInformationPage.fillShippingDetails("Zhaneta", "Krasteva", "1000");
        checkoutYourInformationPage.clickContinue();

        Assertions.assertEquals(1, checkoutOverviewPage.getShoppingCartItems().size(), "Cart item count does not match after checkout.");
        String totalLabel = checkoutOverviewPage.getTotalLabelText();
        Assertions.assertTrue(totalLabel.contains("$"), "Total label does not contain a dollar sign.");
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        inventoryPage.addProductsByTitle(BACKPACK_TITLE, SHIRT_TITLE);
        inventoryPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckout();

        checkoutYourInformationPage.fillShippingDetails("Zhaneta", "Krasteva", "1000");
        checkoutYourInformationPage.clickContinue();

        checkoutOverviewPage.clickFinish();

        Assertions.assertTrue(checkoutCompletePage.isOrderCompleted(), "Order was not completed successfully.");
    }
}