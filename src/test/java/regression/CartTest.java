package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.CartPage;
import pageEvents.ProductPage;
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;

public class CartTest extends BaseTest {

	String browser;
	ProductPage productPage = new ProductPage();
	CartPage cartPage = new CartPage();
	loginPageEvents loginPage = new loginPageEvents();
	registerPageEvents registerPage = new registerPageEvents();

	@BeforeTest(alwaysRun = true)
	@Parameters({"browser"})
	public void prepareReport(@Optional("chrome") String browser) {
		this.browser = browser;
		beforeTestMethod(browser);
	}

	@BeforeMethod(alwaysRun = true)
	public void setup(Method testMethod) {
		initializeBrowser(browser, testMethod);
	}

	@Test(priority = 1)
	public void tc_12_Add_Products_In_Cart() {
		productPage.openProductsPage();
		productPage.addFirstVisibleProductToCart();
		productPage.addSecondVisibleProductToCart();
		cartPage.openCart();
		cartPage.verifyCartHasProducts(2);
	}

	@Test(priority = 2)
	public void tc_13_Verify_Product_Quantity_In_Cart() {
		productPage.openProductsPage();
		productPage.openFirstProductDetail();
		productPage.setQuantityAndAddToCart("4");
		cartPage.verifyProductQuantity("4");
	}

	@Test(priority = 3)
	public void tc_17_Remove_Products_From_Cart() {
		productPage.openProductsPage();
		productPage.addFirstVisibleProductToCartAndOpenCart();
		cartPage.removeFirstProduct();
		cartPage.verifyCartEmpty();
	}

	@Test(priority = 4)
	public void tc_20_Search_Products_And_Verify_Cart_After_Login() {
		productPage.openProductsPage();
		productPage.searchProduct("Blue Top");
		productPage.addFirstVisibleProductToCartAndOpenCart();
		Dictionary<String, String> userDetails = buildUserDetails();
		loginPage.clickSignupLogin();
		loginPage.validateLoginPage();
		registerPage.startSignup(userDetails);
		registerPage.completeRegistration(userDetails);
		registerPage.validateAccountCreated();
		registerPage.continueToHome();
		cartPage.openCart();
		cartPage.verifyCartHasProducts(1);
		registerPage.deleteAccount();
		registerPage.validateAccountDeleted();
		registerPage.continueToHome();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		afterMethod(result, browser);
	}

	private Dictionary<String, String> buildUserDetails() {
		Dictionary<String, String> userDetails = new Hashtable<>();
		String uniqueValue = String.valueOf(generate4Digit());
		userDetails.put("name", "Ed");
		userDetails.put("email", "autotest" + uniqueValue + "@example.com");
		userDetails.put("password", "Password" + uniqueValue);
		userDetails.put("day", "10");
		userDetails.put("month", "May");
		userDetails.put("year", "1995");
		userDetails.put("firstName", "Ed");
		userDetails.put("lastName", "Dela Cruz");
		userDetails.put("company", "Test Company");
		userDetails.put("address1", "123 Test Way");
		userDetails.put("address2", "Unit 4");
		userDetails.put("country", "Canada");
		userDetails.put("state", "Ontario");
		userDetails.put("city", "Toronto");
		userDetails.put("zipcode", "M5V1A1");
		userDetails.put("mobileNumber", "09121234567");
		return userDetails;
	}

}
