package pageObjects;

public interface LoginPage {

	String hdrLoginToYourAccount = "//h2[normalize-space()='Login to your account']";
	String hdrNewUserSignup = "//h2[normalize-space()='New User Signup!']";
	String txtSignupName = "//input[@data-qa='signup-name']";
	String txtSignupEmail = "//input[@data-qa='signup-email']";
	String btnSignup = "//button[@data-qa='signup-button']";
	String txtLoginEmail = "//input[@data-qa='login-email']";
	String txtLoginPassword = "//input[@data-qa='login-password']";
	String btnLogin = "//button[@data-qa='login-button']";

}