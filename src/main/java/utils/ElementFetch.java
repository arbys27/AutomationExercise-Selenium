package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class ElementFetch {
	
	public WebElement getXPATHWebElement(String identifierValue) {
		return new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifierValue)));
	}
	
	public List<WebElement> getXPATHWebElements(String identifierValue) {
		new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(identifierValue), 0));
		return BaseTest.driver.findElements(By.xpath(identifierValue));
	}

}
