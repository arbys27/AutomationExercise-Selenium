package regression;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.ReviewPage;

public class ReviewTest extends BaseTest {

    String browser;

    ReviewPage reviewPage = new ReviewPage();

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void prepareReport(@Optional("chrome") String browser) {

        this.browser = browser;

        beforeTestMethod(browser);

    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {

        initializeBrowser(browser, method);

    }

    @Test(priority = 21)
    public void tc_21_Add_Review_On_Product() {

        reviewPage.openFirstProduct();

        reviewPage.submitReview(
                "Ed",
                "ed@test.com",
                "Excellent product! Selenium automation test."
        );

        reviewPage.verifyReviewSubmitted();

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {

        afterMethod(result, browser);

    }

}