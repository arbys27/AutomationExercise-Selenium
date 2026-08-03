package pageEvents;

import base.BaseTest;
import pageElements.ReviewPageElements;

public class ReviewPage extends BaseTest {

    public void openFirstProduct() {

        logger.info("Open Products page");

        click(ReviewPageElements.btnProducts);

        click(ReviewPageElements.btnViewProduct);

    }

    public void submitReview(String name,
                             String email,
                             String review) {

        logger.info("Submit product review");

        sendKeys(ReviewPageElements.txtName, name);

        sendKeys(ReviewPageElements.txtEmail, email);

        sendKeys(ReviewPageElements.txtReview, review);

        click(ReviewPageElements.btnSubmitReview);

    }

    public void verifyReviewSubmitted() {

        logger.info("Verify review success");

        assertElementIsDisplayed(ReviewPageElements.successMessage);

    }

}