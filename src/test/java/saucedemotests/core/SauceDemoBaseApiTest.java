package saucedemotests.core;

import com.saucedemo.api.SauceProductsService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.core.BaseApiTest;

public class SauceDemoBaseApiTest extends BaseApiTest {
    protected SauceProductsService sauceProductsService;

    @BeforeEach
    public void beforeTests() {
        sauceProductsService = new SauceProductsService();
        System.out.println("Before each test: Initialized SauceProductsService.");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests: Setup global configurations.");
    }

    @AfterEach
    public void afterTest() {
        System.out.println("After each test: Clean up or log test results.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all tests: Teardown global resources.");
    }
}