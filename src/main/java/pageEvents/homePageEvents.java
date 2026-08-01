package pageEvents;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.HomePage;

public class homePageEvents extends BaseTest {

	public void goToCart() {
		logger.info("Open Cart page");
		click(HomePage.linkCart);
	}

	public void validateHomePage() {
		logger.info("Validate Home page sections");
		assertElementIsDisplayed(HomePage.hdrFeaturesItems);
		assertElementIsDisplayed(HomePage.hdrSubscription);
	}

	public void validateCartPage() {
		logger.info("Validate Cart page is displayed");
		assertElementIsDisplayed(HomePage.lblShoppingCart);
	}

	public void subscribeWithEmail(String email) {
		logger.info("Subscribe with email: " + email);
		clear(HomePage.txtSubscriptionEmail);
		sendKeys(HomePage.txtSubscriptionEmail, email);
		click(HomePage.btnSubscribe);
	}

	public void validateSubscriptionSuccess() {
		logger.info("Validate subscription success message");
		String message = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('success-subscribe').textContent.trim();");
		assertTrue(message.contains("You have been successfully subscribed!"),
				"Subscription success message was not found.");
	}

	public void scrollToBottom() {
		logger.info("Scroll down to footer");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void clickScrollUpArrow() {
		logger.info("Click scroll up arrow");
		((JavascriptExecutor) driver).executeScript("document.getElementById('scrollUp').click();");
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(page ->
				((Number) ((JavascriptExecutor) page).executeScript("return window.scrollY;")).longValue() == 0L);
	}

	public void scrollUpWithoutArrow() {
		logger.info("Scroll up using JavaScript");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}

	public void validateAtTop() {
		long scrollPosition = ((Number) ((JavascriptExecutor) driver).executeScript("return window.scrollY;")).longValue();
		assertEquals(scrollPosition, 0L, "Page was not scrolled back to the top.");
	}

}