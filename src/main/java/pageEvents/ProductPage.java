package pageEvents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageElements.ProductPageElements;
import pageObjects.HomePage;
import utils.Constants;

public class ProductPage extends BaseTest {

	public void openProductsPage() {
		logger.info("Open the All Products page");
		click(ProductPageElements.btnProducts);
		assertElementIsDisplayed(ProductPageElements.hdrAllProducts);
	}

	public void verifyAllProductsPage() {
		logger.info("Verify products are listed on the page");
		assertElementIsDisplayed(ProductPageElements.hdrAllProducts);
		assertElementIsDisplayed(ProductPageElements.productCards);
	}

	public void openFirstProductDetail() {
		logger.info("Open the first product detail page");
		WebElement viewProduct = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(ProductPageElements.btnViewProduct)));
		viewProduct.click();
		assertElementIsDisplayed(ProductPageElements.lblProductName);
	}

	public void verifyProductDetails() {
		logger.info("Verify selected product detail information is visible");
		assertElementIsDisplayed(ProductPageElements.lblProductName);
		assertElementIsDisplayed(ProductPageElements.lblCategoryText);
		assertElementIsDisplayed(ProductPageElements.lblAvailability);
		assertElementIsDisplayed(ProductPageElements.lblCondition);
		assertElementIsDisplayed(ProductPageElements.lblBrand);
	}

	public void searchProduct(String productName) {
		logger.info("Search for product: " + productName);
		clear(ProductPageElements.txtSearch);
		sendKeys(ProductPageElements.txtSearch, productName);
		click(ProductPageElements.btnSearch);
		assertElementIsDisplayed(ProductPageElements.hdrSearchedProducts);
	}

	public void verifySearchResults(String productName) {
		logger.info("Validate the search results include the expected product");
		String pageText = driver.findElement(By.xpath("//body")).getText();
		org.testng.Assert.assertTrue(pageText.contains(productName), "Expected product was not found in search results.");
	}

	public void addFirstVisibleProductToCart() {

    logger.info("Add first visible product to cart");

    List<WebElement> cards = driver.findElements(By.cssSelector(".product-image-wrapper"));

    WebElement firstCard = cards.get(0);

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", firstCard);

    new Actions(driver)
            .moveToElement(firstCard)
            .pause(Duration.ofMillis(500))
            .perform();

    WebElement addButton = firstCard.findElements(
            By.xpath(".//a[contains(@class,'add-to-cart')]"))
            .stream()
            .filter(WebElement::isDisplayed)
            .findFirst()
            .orElseThrow();

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", addButton);

    System.out.println("First product added.");

    handleCartModal(false);
}

	public void addFirstVisibleProductToCartAndOpenCart() {

    logger.info("Add first product then open cart");

    List<WebElement> cards = driver.findElements(By.cssSelector(".product-image-wrapper"));

    WebElement firstCard = cards.get(0);

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", firstCard);

    new Actions(driver)
            .moveToElement(firstCard)
            .pause(Duration.ofMillis(500))
            .perform();

    WebElement addButton = firstCard.findElements(
            By.xpath(".//a[contains(@class,'add-to-cart')]"))
            .stream()
            .filter(WebElement::isDisplayed)
            .findFirst()
            .orElseThrow();

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", addButton);

    handleCartModal(true);
}

	public void addSecondVisibleProductToCart() {

    logger.info("Add second visible product to cart");

    List<WebElement> cards = driver.findElements(By.cssSelector(".product-image-wrapper"));

    if(cards.size() < 2){
        throw new AssertionError("Second product not found.");
    }

    WebElement secondCard = cards.get(1);

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", secondCard);

    new Actions(driver)
            .moveToElement(secondCard)
            .pause(Duration.ofMillis(500))
            .perform();

    WebElement addButton = secondCard.findElements(
            By.xpath(".//a[contains(@class,'add-to-cart')]"))
            .stream()
            .filter(WebElement::isDisplayed)
            .findFirst()
            .orElseThrow();

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", addButton);

    System.out.println("Second product added.");

    handleCartModal(false);
}

	public void setQuantityAndAddToCart(String quantity) {
		logger.info("Set quantity to " + quantity + " and add the product to the cart");
		clear(ProductPageElements.txtQuantity);
		sendKeys(ProductPageElements.txtQuantity, quantity);
		click(ProductPageElements.btnAddToCartDetail);
		handleCartModal(true);
	}

	public void addRecommendedItemToCart() {
		logger.info("Add a recommended item to the cart");
		List<WebElement> recommendedButtons = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(ProductPageElements.btnRecommendedAddToCart), 0));
		WebElement recommendedButton = recommendedButtons.stream()
				.filter(WebElement::isDisplayed)
				.findFirst()
				.orElseThrow(() -> new AssertionError("No recommended product add-to-cart button was visible."));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", recommendedButton);
		clickWithJavaScript(recommendedButton);
		handleCartModal(false);
	}

	public void openHomePage() {
		logger.info("Open the home page");
		driver.get(Constants.url);
		assertElementIsDisplayed(HomePage.hdrFeaturesItems);
	}

	private WebElement getFirstVisibleElement(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		for (WebElement element : elements) {
			if (element.isDisplayed()) {
				return element;
			}
		}
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	private void clickWithJavaScript(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	private void handleCartModal(boolean openCart) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    WebElement modal = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.id("cartModal")));

    if(openCart){

        WebElement viewCart =
                modal.findElement(By.xpath(".//a[contains(@href,'view_cart')]"));

        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].click();", viewCart);

    }else{

        WebElement continueBtn =
                modal.findElement(By.xpath(".//button[contains(text(),'Continue Shopping')]"));

        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].click();", continueBtn);

        wait.until(ExpectedConditions.invisibilityOf(modal));
    }
}

	private WebElement waitForVisibleElement(By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
