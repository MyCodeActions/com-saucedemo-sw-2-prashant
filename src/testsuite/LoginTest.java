package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test in the ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials()
 * Enter “standard_user” for the username
 * Enter “secret_sauce” for the password
 * Click on the ‘Login’ button
 * Verify the text “Products”
 * 2. verifyThatSixProductsAreDisplayedOnPage()
 * Enter “standard_user” for the username
 * Enter “secret_sauce” for the password
 * Click on the ‘Login’ button
 * Verify that six products are displayed on page
 */

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();

        String expectedText = "Products";
        String actualText = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();

        int actualProductCount = driver.findElements(By.className("inventory_item")).size();
        int expectedProductCount = 6;
        Assert.assertEquals(actualProductCount, expectedProductCount);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
