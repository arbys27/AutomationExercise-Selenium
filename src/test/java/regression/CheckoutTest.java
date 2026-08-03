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
import pageEvents.CheckoutPage;
import pageEvents.ProductPage;
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;

public class CheckoutTest extends BaseTest {

    String browser;

    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
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

    //-------------------------------------------------------
    // TC14
    //-------------------------------------------------------

    @Test(priority = 14)
    public void tc_14_Place_Order_Register_While_Checkout() {

        productPage.openProductsPage();

        productPage.addFirstVisibleProductToCartAndOpenCart();

        checkoutPage.proceedToCheckout();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        checkoutPage.clickRegisterLogin();

        Dictionary<String,String> user = buildUser();

        registerUser(user);

        cartPage.openCart();

        checkoutPage.proceedToCheckout();
        System.out.println("URL = " + driver.getCurrentUrl());
        System.out.println("TITLE = " + driver.getTitle());
        System.out.println(driver.findElement(org.openqa.selenium.By.tagName("body")).getText());

        checkoutPage.placeOrder("Automation Checkout");

        checkoutPage.enterPaymentDetails();

        checkoutPage.verifyOrderSuccess();

        registerPage.deleteAccount();

    }

    //-------------------------------------------------------
    // TC15
    //-------------------------------------------------------

    @Test(priority = 15)
    public void tc_15_Place_Order_Register_Before_Checkout() {

        Dictionary<String,String> user = buildUser();

        registerUser(user);

        productPage.openProductsPage();

        productPage.addFirstVisibleProductToCartAndOpenCart();

        checkoutPage.proceedToCheckout();

        checkoutPage.placeOrder("Automation Checkout");

        checkoutPage.enterPaymentDetails();

        checkoutPage.verifyOrderSuccess();

        registerPage.deleteAccount();

    }

    //-------------------------------------------------------
    // TC16
    //-------------------------------------------------------

    @Test(priority = 16)
    public void tc_16_Place_Order_Login_Before_Checkout() {

        Dictionary<String,String> user = buildUser();

        registerUser(user);

        loginPage.logout();

        loginPage.clickSignupLogin();

        loginPage.login(user);

        productPage.openProductsPage();

        productPage.addFirstVisibleProductToCartAndOpenCart();

        checkoutPage.proceedToCheckout();

        checkoutPage.placeOrder("Automation Checkout");

        checkoutPage.enterPaymentDetails();

        checkoutPage.verifyOrderSuccess();

        registerPage.deleteAccount();

    }

    //-------------------------------------------------------
    // TC23
    //-------------------------------------------------------

    @Test(priority = 23)
    public void tc_23_Verify_Address_Details() {

        Dictionary<String,String> user = buildUser();

        registerUser(user);

        productPage.openProductsPage();

        productPage.addFirstVisibleProductToCartAndOpenCart();

        checkoutPage.proceedToCheckout();

        checkoutPage.verifyDeliveryAddress();

        checkoutPage.verifyBillingAddress();

        registerPage.deleteAccount();

    }

    //-------------------------------------------------------
    // TC24
    //-------------------------------------------------------

    @Test(priority = 24)
    public void tc_24_Download_Invoice() {

        Dictionary<String,String> user = buildUser();

        registerUser(user);

        productPage.openProductsPage();

        productPage.addFirstVisibleProductToCartAndOpenCart();

        checkoutPage.proceedToCheckout();

        checkoutPage.placeOrder("Automation Checkout");

        checkoutPage.enterPaymentDetails();

        checkoutPage.downloadInvoice();

        registerPage.deleteAccount();

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        afterMethod(result,browser);
    }

    //-------------------------------------------------------

    private void registerUser(Dictionary<String,String> user){

        loginPage.clickSignupLogin();

        registerPage.startSignup(user);

        registerPage.completeRegistration(user);

        registerPage.continueToHome();

    }

    private Dictionary<String,String> buildUser(){

        Dictionary<String,String> user = new Hashtable<>();

        String unique = String.valueOf(generate4Digit());

        user.put("name","Ed");
        user.put("email","automation"+unique+"@test.com");
        user.put("password","Password"+unique);

        user.put("day","10");
        user.put("month","May");
        user.put("year","1995");

        user.put("firstName","Ed");
        user.put("lastName","Dela Cruz");
        user.put("company","Automation");

        user.put("address1","123 Test");
        user.put("address2","Unit 1");

        user.put("country","Canada");

        user.put("state","Ontario");
        user.put("city","Toronto");
        user.put("zipcode","12345");

        user.put("mobileNumber","09123456789");

        return user;
    }

}