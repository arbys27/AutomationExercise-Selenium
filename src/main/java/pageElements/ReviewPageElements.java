package pageElements;

public interface ReviewPageElements {

    String btnProducts = "//a[@href='/products']";

    String btnViewProduct = "(//a[contains(@href,'/product_details/')])[1]";

    String txtName = "//input[@id='name']";

    String txtEmail = "//input[@id='email']";

    String txtReview = "//textarea[@id='review']";

    String btnSubmitReview = "//button[@id='button-review']";

    String successMessage = "//span[contains(text(),'Thank you for your review.')]";

}