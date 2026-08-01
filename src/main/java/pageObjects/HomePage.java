package pageObjects;

public interface HomePage {

	String linkSignupLogin = "//a[@href='/login' and normalize-space()='Signup / Login']";
	String linkCart = "//a[@href='/view_cart' and normalize-space()='Cart']";
	String linkLogout = "//a[@href='/logout' and normalize-space()='Logout']";
	String linkDeleteAccount = "//a[@href='/delete_account' and normalize-space()='Delete Account']";
	String txtLoggedInAs = "//li[contains(normalize-space(), 'Logged in as')]";
	String hdrFeaturesItems = "//h2[normalize-space()='Features Items']";
	String hdrSubscription = "//h2[normalize-space()='Subscription']";
	String txtSubscriptionEmail = "//input[@id='susbscribe_email']";
	String btnSubscribe = "//button[@id='subscribe']";
	String divSubscriptionSuccess = "//div[@id='success-subscribe']";
	String btnScrollUp = "//a[@id='scrollUp']";
	String lblShoppingCart = "//li[normalize-space()='Shopping Cart']";
	String hdrAccountCreated = "//h2[normalize-space()='Account Created!']";
	String hdrAccountDeleted = "//h2[normalize-space()='Account Deleted!']";
	String btnContinue = "//a[@data-qa='continue-button']";

}