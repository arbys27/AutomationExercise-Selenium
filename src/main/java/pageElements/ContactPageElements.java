package pageElements;

public interface ContactPageElements {

    // Navigation
    String btnContactUs = "//a[@href='/contact_us']";
    String btnTestCases = "//a[@href='/test_cases']";

    // Contact Page
    String hdrGetInTouch = "//h2[text()='Get In Touch']";

    // Form
    String txtName = "//input[@data-qa='name']";
    String txtEmail = "//input[@data-qa='email']";
    String txtSubject = "//input[@data-qa='subject']";
    String txtMessage = "//textarea[@data-qa='message']";

    // Upload
    String fileUpload = "//input[@name='upload_file']";

    // Submit
    String btnSubmit = "//input[@data-qa='submit-button']";

    // Success
    String successMessage =
            "//div[contains(@class,'status') and contains(text(),'Success')]";

    // Home
    String btnHome = "//a[contains(text(),'Home')]";

    // Test Cases
    String hdrTestCases = "//b[text()='Test Cases']";

}