package pageElements;

public interface CheckoutPageElements {

    String btnCart = "//a[@href='/view_cart']";
    String btnProceedToCheckout =
    "//a[contains(@class,'check_out') or contains(text(),'Proceed To Checkout')]";

    String btnRegisterLogin = "//u[normalize-space()='Register / Login']";

    String txtComment = "//textarea[@name='message']";

    String btnPlaceOrder = "//a[@href='/payment']";

    String txtNameOnCard = "//input[@name='name_on_card']";
    String txtCardNumber = "//input[@name='card_number']";
    String txtCVC = "//input[@name='cvc']";
    String txtExpiryMonth = "//input[@name='expiry_month']";
    String txtExpiryYear = "//input[@name='expiry_year']";

    String btnPay = "//button[@id='submit']";

    String successMessage = "//*[contains(text(),'Your order has been placed successfully') or contains(text(),'Congratulations')]";

    String btnDownloadInvoice =
            "//a[contains(text(),'Download Invoice')]";

    String lblDeliveryAddress =
            "//ul[@id='address_delivery']";

    String lblBillingAddress =
            "//ul[@id='address_invoice']";

}