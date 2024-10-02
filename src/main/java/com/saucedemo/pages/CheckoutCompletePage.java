package com.saucedemo.pages;

import org.openqa.selenium.By;

public class CheckoutCompletePage extends BaseSauceDemoPage {
    private final By confirmationMessageLocator = By.xpath("//h2[text()='Thank you for your order!']");

    public CheckoutCompletePage() {
        super("/checkout-complete.html");
    }

    public boolean isOrderCompleted() {
        return driver().findElements(confirmationMessageLocator).size() > 0;
    }
}
