package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageElements.CategoryPageElements;

public class CategoryPage extends BaseTest {

	public void openWomenCategory() {
		logger.info("Open the Women category section");
		WebElement womenLink = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(CategoryPageElements.lnkWomenCategory)));
		womenLink.click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(CategoryPageElements.lnkWomenDress))).click();
	}

	public void openMenCategory() {
		logger.info("Open the Men category section");
		WebElement menLink = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(CategoryPageElements.lnkMenCategory)));
		menLink.click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(CategoryPageElements.lnkMenJeans))).click();
	}

	public void verifyCategoryProductsDisplayed() {
		logger.info("Verify category products are displayed");
		assertElementIsDisplayed(CategoryPageElements.hdrCategoryProducts);
	}

	public void openBrandProducts() {
		logger.info("Open brand products from brands list");
		WebElement brandLink = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(CategoryPageElements.lnkBrands)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", brandLink);
		brandLink.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver ->
				webDriver.getCurrentUrl().contains("brand_products") || driver.findElements(By.xpath(CategoryPageElements.hdrBrandProducts)).size() > 0);
		org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("brand_products") || driver.findElements(By.xpath(CategoryPageElements.hdrBrandProducts)).size() > 0,
				"Brand products page was not opened successfully.");
	}

}
