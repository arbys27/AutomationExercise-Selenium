package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageElements.CheckoutPageElements;

public class CheckoutPage extends BaseTest {

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openCart() {

        logger.info("Open Cart");

        click(CheckoutPageElements.btnCart);
    }

    public void proceedToCheckout() {

        logger.info("Proceed to Checkout");

        getWait().until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(CheckoutPageElements.btnProceedToCheckout)))
                .click();
    }

    public void clickRegisterLogin() {

        logger.info("Click Register/Login");

        WebElement registerLogin = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='checkoutModal']//u[contains(text(),'Register / Login')]")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", registerLogin);
    }

    public void placeOrder(String comment) {

        logger.info("Place Order");

        sendKeys(CheckoutPageElements.txtComment, comment);

        click(CheckoutPageElements.btnPlaceOrder);
    }

    public void enterPaymentDetails() {

        logger.info("Enter Payment Details");

        sendKeys(CheckoutPageElements.txtNameOnCard, "Ed");

        sendKeys(CheckoutPageElements.txtCardNumber, "4111111111111111");

        sendKeys(CheckoutPageElements.txtCVC, "123");

        sendKeys(CheckoutPageElements.txtExpiryMonth, "12");

        sendKeys(CheckoutPageElements.txtExpiryYear, "2030");

        click(CheckoutPageElements.btnPay);
    }

    public void verifyOrderSuccess() {

        logger.info("Verify Order Success");

        assertElementIsDisplayed(CheckoutPageElements.successMessage);
    }

    public void downloadInvoice() {

        logger.info("Download Invoice");

        click(CheckoutPageElements.btnDownloadInvoice);
    }

    public void verifyDeliveryAddress() {

        logger.info("Verify Delivery Address");

        assertElementIsDisplayed(CheckoutPageElements.lblDeliveryAddress);
    }

    public void verifyBillingAddress() {

        logger.info("Verify Billing Address");

        assertElementIsDisplayed(CheckoutPageElements.lblBillingAddress);
    }

}