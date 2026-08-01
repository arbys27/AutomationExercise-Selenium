package pageObjects;

public interface RegisterPage {

	String radMr = "//input[@id='id_gender1']";
	String radMrs = "//input[@id='id_gender2']";
	String txtPassword = "//input[@id='password']";
	String slcDays = "//select[@id='days']";
	String slcMonths = "//select[@id='months']";
	String slcYears = "//select[@id='years']";
	String chkNewsletter = "//input[@id='newsletter']";
	String chkOptin = "//input[@id='optin']";
	String txtFirstName = "//input[@id='first_name']";
	String txtLastName = "//input[@id='last_name']";
	String txtCompany = "//input[@id='company']";
	String txtAddress1 = "//input[@id='address1']";
	String txtAddress2 = "//input[@id='address2']";
	String slcCountry = "//select[@id='country']";
	String txtState = "//input[@id='state']";
	String txtCity = "//input[@id='city']";
	String txtZipcode = "//input[@id='zipcode']";
	String txtMobileNumber = "//input[@id='mobile_number']";
	String btnCreateAccount = "//button[@data-qa='create-account']";

}