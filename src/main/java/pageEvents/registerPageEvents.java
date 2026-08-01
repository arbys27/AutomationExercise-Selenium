package pageEvents;

import java.util.Dictionary;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class registerPageEvents extends BaseTest {

	public void completeRegistration(Dictionary<String, String> userDetails) {
		logger.info("Fill up account information");
		click(RegisterPage.radMr);

		clear(RegisterPage.txtPassword);
		sendKeys(RegisterPage.txtPassword, userDetails.get("password").toString());

		selectElementByVisibleText(RegisterPage.slcDays, userDetails.get("day").toString());
		selectElementByVisibleText(RegisterPage.slcMonths, userDetails.get("month").toString());
		selectElementByVisibleText(RegisterPage.slcYears, userDetails.get("year").toString());

		click(RegisterPage.chkNewsletter);
		click(RegisterPage.chkOptin);

		logger.info("Fill up address information");
		clear(RegisterPage.txtFirstName);
		sendKeys(RegisterPage.txtFirstName, userDetails.get("firstName").toString());

		clear(RegisterPage.txtLastName);
		sendKeys(RegisterPage.txtLastName, userDetails.get("lastName").toString());

		clear(RegisterPage.txtCompany);
		sendKeys(RegisterPage.txtCompany, userDetails.get("company").toString());

		clear(RegisterPage.txtAddress1);
		sendKeys(RegisterPage.txtAddress1, userDetails.get("address1").toString());

		clear(RegisterPage.txtAddress2);
		sendKeys(RegisterPage.txtAddress2, userDetails.get("address2").toString());

		selectElementByVisibleText(RegisterPage.slcCountry, userDetails.get("country").toString());

		clear(RegisterPage.txtState);
		sendKeys(RegisterPage.txtState, userDetails.get("state").toString());

		clear(RegisterPage.txtCity);
		sendKeys(RegisterPage.txtCity, userDetails.get("city").toString());

		clear(RegisterPage.txtZipcode);
		sendKeys(RegisterPage.txtZipcode, userDetails.get("zipcode").toString());

		clear(RegisterPage.txtMobileNumber);
		sendKeys(RegisterPage.txtMobileNumber, userDetails.get("mobileNumber").toString());

		click(RegisterPage.btnCreateAccount);
	}

	public void validateAccountCreated() {
		logger.info("Validate account created screen");
		assertElementIsDisplayed(HomePage.hdrAccountCreated);
	}

	public void continueToHome() {
		logger.info("Continue to home page");
		click(HomePage.btnContinue);
	}

	public void deleteAccount() {
		logger.info("Delete created account");
		click(HomePage.linkDeleteAccount);
	}

	public void validateAccountDeleted() {
		logger.info("Validate account deleted screen");
		assertElementIsDisplayed(HomePage.hdrAccountDeleted);
	}

	public void startSignup(Dictionary<String, String> userDetails) {
		logger.info("Fill up signup name and email");
		clear(LoginPage.txtSignupName);
		sendKeys(LoginPage.txtSignupName, userDetails.get("name").toString());

		clear(LoginPage.txtSignupEmail);
		sendKeys(LoginPage.txtSignupEmail, userDetails.get("email").toString());

		click(LoginPage.btnSignup);
	}

	public void validateRegistrationSuccess() {
		logger.info("Validate registration success banner");
		assertElementIsDisplayed(HomePage.hdrAccountCreated);
	}

}
