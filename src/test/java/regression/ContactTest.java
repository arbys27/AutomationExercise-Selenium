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
import pageEvents.ContactPage;

public class ContactTest extends BaseTest {

    String browser;

    ContactPage contactPage = new ContactPage();

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

    @Test(priority = 6)
    public void tc_06_Contact_Us_Form() {

        contactPage.openContactPage();

        contactPage.submitContactForm(
                "Ed",
                "ed@test.com",
                "Automation Testing",
                "This is an automated contact form test.",
                "src/test/resources/sample.txt"
        );

        contactPage.verifyContactSuccess();

        contactPage.returnHome();

    }

    @Test(priority = 7)
    public void tc_07_Verify_Test_Cases_Page() {

        contactPage.openTestCasesPage();

        contactPage.verifyTestCasesPage();

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {

        afterMethod(result, browser);

    }

}