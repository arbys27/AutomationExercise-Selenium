package regression;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.ProductPage;
import pageEvents.CartPage;
import pageEvents.CategoryPage;
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;

public class ProductTest extends BaseTest {

	String browser;
	ProductPage productPage = new ProductPage();
	CartPage cartPage = new CartPage();
	CategoryPage categoryPage = new CategoryPage();
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
	public void tc_08_Verify_All_Products_And_Product_Detail_Page() {
		productPage.openProductsPage();
		productPage.verifyAllProductsPage();
		productPage.openFirstProductDetail();
		productPage.verifyProductDetails();
	}

	@Test(priority = 2)
	public void tc_09_Search_Product() {
		productPage.openProductsPage();
		productPage.searchProduct("Blue Top");
		productPage.verifySearchResults("Blue Top");
	}

	@Test(priority = 3)
	public void tc_18_View_Category_Products() {
		categoryPage.openWomenCategory();
		categoryPage.verifyCategoryProductsDisplayed();
	}

	@Test(priority = 4)
	public void tc_19_View_And_Cart_Brand_Products() {
		productPage.openProductsPage();
		categoryPage.openBrandProducts();
	}

	@Test(priority = 5)
	public void tc_22_Add_to_Cart_From_Recommended_Items() {
		productPage.openHomePage();
		productPage.addRecommendedItemToCart();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		afterMethod(result, browser);
	}

}
