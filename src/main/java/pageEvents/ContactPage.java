package pageEvents;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import base.BaseTest;
import pageElements.ContactPageElements;

public class ContactPage extends BaseTest {

    public void openContactPage() {

        logger.info("Open Contact Us page");

        click(ContactPageElements.btnContactUs);

        assertElementIsDisplayed(ContactPageElements.hdrGetInTouch);

    }

    public void submitContactForm(String name,
                              String email,
                              String subject,
                              String message,
                              String filePath) {

    logger.info("Fill Contact Us form");

    sendKeys(ContactPageElements.txtName, name);
    sendKeys(ContactPageElements.txtEmail, email);
    sendKeys(ContactPageElements.txtSubject, subject);
    sendKeys(ContactPageElements.txtMessage, message);

    File file = new File(filePath);

    System.out.println("Current Directory : " + System.getProperty("user.dir"));
    System.out.println("Input Path        : " + filePath);
    System.out.println("Absolute Path     : " + file.getAbsolutePath());
    System.out.println("File Exists?      : " + file.exists());

    if(!file.exists()) {
        throw new RuntimeException("UPLOAD FILE NOT FOUND: " + file.getAbsolutePath());
    }

    driver.findElement(By.xpath(ContactPageElements.fileUpload))
            .sendKeys(file.getAbsolutePath());

    click(ContactPageElements.btnSubmit);

    Alert alert = driver.switchTo().alert();
    alert.accept();
}

    public void verifyContactSuccess() {

        logger.info("Verify success message");

        assertElementIsDisplayed(ContactPageElements.successMessage);

    }

    public void returnHome() {

        click(ContactPageElements.btnHome);

    }

    public void openTestCasesPage() {

        logger.info("Open Test Cases page");

        click(ContactPageElements.btnTestCases);

    }

    public void verifyTestCasesPage() {

        logger.info("Verify Test Cases page");

        assertElementIsDisplayed(ContactPageElements.hdrTestCases);

    }

}