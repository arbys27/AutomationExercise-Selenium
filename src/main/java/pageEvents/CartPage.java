package pageEvents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageElements.CartPageElements;
import pageObjects.HomePage;

public class CartPage extends BaseTest {

	public void openCart() {
		logger.info("Open the shopping cart page");
		click(HomePage.linkCart);
		assertElementIsDisplayed(CartPageElements.lblShoppingCart);
	}

	public void verifyCartHasProducts(int expectedCount) {

    logger.info("Verify the cart contains " + expectedCount + " product(s)");

    // Wait until at least one product appears in the cart
    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                    By.xpath(CartPageElements.cartRows), 0));

    List<WebElement> rows = driver.findElements(By.xpath(CartPageElements.cartRows));

    System.out.println("========== CART DEBUG ==========");
    System.out.println("Rows Found: " + rows.size());

    for (WebElement row : rows) {
        System.out.println("----------------------");
        System.out.println(row.getText());
    }

    System.out.println("===============================");

    org.testng.Assert.assertTrue(
            rows.size() >= expectedCount,
            "Expected at least " + expectedCount + " row(s) in the cart, but found " + rows.size());
}

	public void verifyProductQuantity(String expectedQuantity) {

    logger.info("Verify the quantity in the cart is " + expectedQuantity);

    WebElement quantityField = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(CartPageElements.txtQuantityInCart)));

    org.testng.Assert.assertEquals(
            quantityField.getText().trim(),
            expectedQuantity,
            "The cart quantity did not match the expected value.");
}

	public void removeFirstProduct() {
		logger.info("Remove the first product from the cart");
		WebElement removeLink = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(CartPageElements.btnRemoveProduct)));
		removeLink.click();
	}

	public void verifyCartEmpty() {
		logger.info("Verify the cart is empty after removing the product");
		assertElementIsDisplayed(CartPageElements.txtCartEmpty);
	}

}
