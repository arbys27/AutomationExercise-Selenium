package pageEvents;

import java.util.Dictionary;
import java.time.Duration;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPageEvents extends BaseTest {

	public void clickSignupLogin() {
		logger.info("Click Signup / Login tab");
		click(HomePage.linkSignupLogin);
	}

	public void validateLoginPage() {
		logger.info("Validate login page is displayed");
		assertElementIsDisplayed(LoginPage.hdrLoginToYourAccount);
		assertElementIsDisplayed(LoginPage.hdrNewUserSignup);
	}

	public void startSignup(Dictionary<String, String> userDetails) {
		logger.info("Fill up signup name and email");
		clear(LoginPage.txtSignupName);
		sendKeys(LoginPage.txtSignupName, userDetails.get("name").toString());

		clear(LoginPage.txtSignupEmail);
		sendKeys(LoginPage.txtSignupEmail, userDetails.get("email").toString());

		click(LoginPage.btnSignup);
	}

	public void login(Dictionary<String, String> userDetails) {
		logger.info("Fill up login email and password");
		clear(LoginPage.txtLoginEmail);
		sendKeys(LoginPage.txtLoginEmail, userDetails.get("email").toString());

		clear(LoginPage.txtLoginPassword);
		sendKeys(LoginPage.txtLoginPassword, userDetails.get("password").toString());

		click(LoginPage.btnLogin);
	}

	public void validateIncorrectLoginError() {
		logger.info("Validate incorrect login error message");
		assertElementIsDisplayed("//p[normalize-space()='Your email or password is incorrect!']");
	}

	public void validateExistingEmailError() {
		logger.info("Validate existing email error message");
		assertElementIsDisplayed("//p[normalize-space()='Email Address already exist!']");
	}

	public void validateLoggedIn() {
		logger.info("Validate user is logged in");
		assertElementIsDisplayed(HomePage.linkLogout);
		assertElementIsDisplayed(HomePage.linkDeleteAccount);
	}

	public void logout() {
		logger.info("Click Logout tab");
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePage.linkLogout)));
		click(HomePage.linkLogout);
	}

}
