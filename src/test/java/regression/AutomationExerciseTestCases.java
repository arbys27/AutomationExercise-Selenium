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
import pageEvents.homePageEvents;
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;

public class AutomationExerciseTestCases extends BaseTest {

	String browser;
	loginPageEvents loginPage = new loginPageEvents();
	registerPageEvents registerPage = new registerPageEvents();
	homePageEvents homePage = new homePageEvents();

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
	public void tc_01_Register_User() {
		Dictionary<String, String> userDetails = buildUserDetails();
		registerNewUser(userDetails);
		registerPage.validateRegistrationSuccess();
		registerPage.continueToHome();
		loginPage.validateLoggedIn();
		registerPage.deleteAccount();
		registerPage.validateAccountDeleted();
		registerPage.continueToHome();
	}

	@Test(priority = 2)
	public void tc_02_Login_User_with_correct_email_and_password() {
		Dictionary<String, String> userDetails = buildUserDetails();
		registerNewUser(userDetails);
		registerPage.continueToHome();
		loginPage.logout();
		loginPage.clickSignupLogin();
		loginPage.login(userDetails);
		loginPage.validateLoggedIn();
		registerPage.deleteAccount();
		registerPage.validateAccountDeleted();
		registerPage.continueToHome();
	}

	@Test(priority = 3)
	public void tc_03_Login_User_with_incorrect_email_and_password() {
		Dictionary<String, String> userDetails = buildUserDetails();
		registerNewUser(userDetails);
		registerPage.continueToHome();
		loginPage.logout();
		loginPage.clickSignupLogin();

		Dictionary<String, String> wrongCredentials = new Hashtable<>();
		wrongCredentials.put("email", userDetails.get("email").toString());
		wrongCredentials.put("password", userDetails.get("password").toString() + "wrong");

		loginPage.login(wrongCredentials);
		loginPage.validateIncorrectLoginError();
		loginPage.login(userDetails);
		loginPage.validateLoggedIn();
		registerPage.deleteAccount();
		registerPage.validateAccountDeleted();
		registerPage.continueToHome();
	}

	@Test(priority = 4)
	public void tc_04_Logout_User() {
		Dictionary<String, String> userDetails = buildUserDetails();
		registerNewUser(userDetails);
		registerPage.continueToHome();
		loginPage.logout();
		loginPage.validateLoginPage();
	}

	@Test(priority = 5)
	public void tc_05_Register_User_with_existing_email() {
		Dictionary<String, String> userDetails = buildUserDetails();
		registerNewUser(userDetails);
		registerPage.continueToHome();
		loginPage.logout();
		loginPage.clickSignupLogin();

		Dictionary<String, String> duplicateDetails = new Hashtable<>();
		duplicateDetails.put("name", "Another User");
		duplicateDetails.put("email", userDetails.get("email").toString());

		loginPage.startSignup(duplicateDetails);
		loginPage.validateExistingEmailError();
		loginPage.login(userDetails);
		loginPage.validateLoggedIn();
		registerPage.deleteAccount();
		registerPage.validateAccountDeleted();
		registerPage.continueToHome();
	}

	@Test(priority = 10)
	public void tc_10_Verify_Subscription_in_Home_Page() {
		homePage.validateHomePage();
		homePage.scrollToBottom();
		homePage.subscribeWithEmail(buildSubscriptionEmail());
		homePage.validateSubscriptionSuccess();
	}

	@Test(priority = 11)
	public void tc_11_Verify_Subscription_in_Cart_Page() {
		homePage.goToCart();
		homePage.validateCartPage();
		homePage.scrollToBottom();
		homePage.subscribeWithEmail(buildSubscriptionEmail());
		homePage.validateSubscriptionSuccess();
	}

	@Test(priority = 25)
	public void tc_25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality() {
		homePage.validateHomePage();
		homePage.scrollToBottom();
		homePage.clickScrollUpArrow();
		homePage.validateAtTop();
	}

	@Test(priority = 26)
	public void tc_26_Verify_Scroll_Up_without_Arrow_button_and_Scroll_Down_functionality() {
		homePage.validateHomePage();
		homePage.scrollToBottom();
		homePage.scrollUpWithoutArrow();
		homePage.validateAtTop();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		afterMethod(result, browser);
	}

	private void registerNewUser(Dictionary<String, String> userDetails) {
		loginPage.clickSignupLogin();
		loginPage.validateLoginPage();
		registerPage.startSignup(userDetails);
		registerPage.completeRegistration(userDetails);
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

	private String buildSubscriptionEmail() {
		return "subscription" + generate4Digit() + "@example.com";
	}

}