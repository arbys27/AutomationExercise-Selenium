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
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;

public class RegisterTest extends BaseTest {

	String browser;
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

	@Test
	public void tc_01_RegisterAccount() {
		Dictionary<String, String> userDetails = buildUserDetails();

		loginPage.clickSignupLogin();
		loginPage.validateLoginPage();
		registerPage.startSignup(userDetails);
		registerPage.completeRegistration(userDetails);
		registerPage.validateAccountCreated();
		registerPage.continueToHome();
		loginPage.validateLoggedIn();
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