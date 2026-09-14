package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactPage;

public class ContactTest extends BaseTest {

    ContactPage contactPage;
    WebDriverWait wait;


    // =====================================================
    // SETUP
    // =====================================================

    @BeforeMethod
    public void navigateToHome() {

        driver.get("https://www.demoblaze.com/");

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        contactPage = new ContactPage(driver);

        System.out.println(
                "===== Navigated to Home Page ====="
        );
    }


    // =====================================================
    // CT_001 - VERIFY CONTACT LINK
    // =====================================================

    @Test(priority = 1)
    public void verifyContactLink() {

        Assert.assertTrue(
                contactPage.isContactLinkDisplayed(),
                "Contact link is not displayed!"
        );

        Assert.assertTrue(
                contactPage.isContactLinkEnabled(),
                "Contact link is not enabled!"
        );

        System.out.println(
                "CT_001 - Contact link verified"
        );
    }


    // =====================================================
    // CT_002 - VERIFY CONTACT POPUP
    // =====================================================

    @Test(priority = 2)
    public void verifyContactPopup() {

        contactPage.clickContactLink();

        Assert.assertTrue(
                contactPage.isContactPopupDisplayed(),
                "Contact popup is not displayed!"
        );

        System.out.println(
                "CT_002 - Contact popup verified"
        );
    }


    // =====================================================
    // CT_003 - VERIFY ALL FIELDS
    // =====================================================

    @Test(priority = 3)
    public void verifyAllContactFields() {

        contactPage.clickContactLink();

        Assert.assertTrue(
                contactPage.isEmailFieldDisplayed(),
                "Email field not displayed!"
        );

        Assert.assertTrue(
                contactPage.isEmailFieldEnabled(),
                "Email field not enabled!"
        );

        Assert.assertTrue(
                contactPage.isNameFieldDisplayed(),
                "Name field not displayed!"
        );

        Assert.assertTrue(
                contactPage.isNameFieldEnabled(),
                "Name field not enabled!"
        );

        Assert.assertTrue(
                contactPage.isMessageFieldDisplayed(),
                "Message field not displayed!"
        );

        Assert.assertTrue(
                contactPage.isMessageFieldEnabled(),
                "Message field not enabled!"
        );

        System.out.println(
                "CT_003 - All Contact fields verified"
        );
    }


    // =====================================================
    // CT_004 - VALID DATA
    // =====================================================

    @Test(priority = 4)
    public void verifyValidContactMessage() {

        contactPage.clickContactLink();

        contactPage.fillContactForm(
                "customer@gmail.com",
                "Customer One",
                "This is a valid contact message."
        );

        contactPage.clickSendMessage();

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println(
                "Valid Contact Alert: " + alertMessage
        );

        alert.accept();

        Assert.assertTrue(
                alertMessage.toLowerCase().contains("thanks"),
                "Valid contact message was not accepted!"
        );
    }


    // =====================================================
    // IMPORTANT INDIVIDUAL EMAIL VALIDATION
    // =====================================================

    @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmails() {

        return new Object[][] {

            {"abc"},
            {"abc@"},
            {"@gmail.com"},
            {"abc@gmail"},
            {"abc gmail.com"},
            {"12345"},
            {"abc#gmail.com"},
            {"abc@gmail..com"}

        };
    }


    @Test(
            priority = 5,
            dataProvider = "invalidEmails"
    )
    public void verifyInvalidEmailValidation(
            String email) {

        contactPage.clickContactLink();

        contactPage.fillContactForm(
                email,
                "Customer One",
                "Testing email validation."
        );

        contactPage.clickSendMessage();

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println(
                "Email: " + email
        );

        System.out.println(
                "Alert: " + alertMessage
        );

        /*
         * Accept alert before assertion.
         * This prevents UnhandledAlertException.
         */

        alert.accept();

        /*
         * EXPECTED:
         * Invalid email should be rejected.
         *
         * CURRENT APPLICATION:
         * Invalid email is accepted and
         * "Thanks for the message!!" is displayed.
         */

        if (alertMessage.toLowerCase().contains("thanks")) {

            takeScreenshotWithTimestamp(
                    "DEF_CT_001_Invalid_Email_" + email
            );
        }

        Assert.assertFalse(
                alertMessage.toLowerCase().contains("thanks"),
                "BUG: Application accepted invalid email: "
                        + email
        );
    }


    // =====================================================
    // NAME VALIDATION
    // =====================================================

    @DataProvider(name = "invalidNames")
    public Object[][] invalidNames() {

        return new Object[][] {

            {"12345"},
            {"@#$%"},
            {"Customer@123"}

        };
    }


    @Test(
            priority = 6,
            dataProvider = "invalidNames"
    )
    public void verifyInvalidNameValidation(
            String name) {

        contactPage.clickContactLink();

        contactPage.fillContactForm(
                "customer@gmail.com",
                name,
                "Testing name validation."
        );

        contactPage.clickSendMessage();

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println(
                "Name: " + name
        );

        System.out.println(
                "Alert: " + alertMessage
        );

        alert.accept();

        /*
         * This test documents the expected validation.
         * If the application accepts these names,
         * the test will fail.
         */

        if (alertMessage.toLowerCase().contains("thanks")) {

            takeScreenshotWithTimestamp(
                    "DEF_CT_003_Invalid_Name_" + name
            );
        }

        Assert.assertFalse(
                alertMessage.toLowerCase().contains("thanks"),
                "Application accepted invalid name: "
                        + name
        );
    }


    // =====================================================
    // MESSAGE VALIDATION
    // =====================================================

    @DataProvider(name = "invalidMessages")
    public Object[][] invalidMessages() {

        return new Object[][] {

            {""},
            {"   "}

        };
    }


    @Test(
            priority = 7,
            dataProvider = "invalidMessages"
    )
    public void verifyInvalidMessageValidation(
            String message) {

        contactPage.clickContactLink();

        contactPage.fillContactForm(
                "customer@gmail.com",
                "Customer One",
                message
        );

        contactPage.clickSendMessage();

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println(
                "Message: [" + message + "]"
        );

        System.out.println(
                "Alert: " + alertMessage
        );

        alert.accept();

        /*
         * EXPECTED:
         * Empty/blank message should be rejected.
         *
         * CURRENT APPLICATION:
         * Empty message is accepted.
         */

        if (alertMessage.toLowerCase().contains("thanks")) {

            takeScreenshotWithTimestamp(
                    "DEF_CT_002_Empty_Message"
            );
        }

        Assert.assertFalse(
                alertMessage.toLowerCase().contains("thanks"),
                "BUG: Application accepted empty/blank message!"
        );
    }


    // =====================================================
    // CORE 15 COMBINATIONS
    // =====================================================

    @DataProvider(name = "contactCombinations")
    public Object[][] contactCombinations() {

        return new Object[][] {

            // 1 - All valid
            {
                "customer@gmail.com",
                "Customer One",
                "This is a valid message.",
                "CT_011_All_Valid"
            },

            // 2 - Empty email
            {
                "",
                "Customer One",
                "This is a valid message.",
                "CT_012_Empty_Email"
            },

            // 3 - Empty name
            {
                "customer@gmail.com",
                "",
                "This is a valid message.",
                "CT_013_Empty_Name"
            },

            // 4 - Empty message
            {
                "customer@gmail.com",
                "Customer One",
                "",
                "CT_014_Empty_Message"
            },

            // 5 - Empty email + empty name
            {
                "",
                "",
                "This is a valid message.",
                "CT_015_Empty_Email_Name"
            },

            // 6 - Empty email + empty message
            {
                "",
                "Customer One",
                "",
                "CT_016_Empty_Email_Message"
            },

            // 7 - Empty name + empty message
            {
                "customer@gmail.com",
                "",
                "",
                "CT_017_Empty_Name_Message"
            },

            // 8 - All empty
            {
                "",
                "",
                "",
                "CT_018_All_Empty"
            },

            // 9 - Invalid email
            {
                "abc",
                "Customer One",
                "This is a valid message.",
                "CT_019_Invalid_Email"
            },

            // 10 - Invalid name
            {
                "customer@gmail.com",
                "12345",
                "This is a valid message.",
                "CT_020_Invalid_Name"
            },

            // 11 - Invalid message
            {
                "customer@gmail.com",
                "Customer One",
                "@#$%",
                "CT_021_Invalid_Message"
            },

            // 12 - Invalid email + empty message
            {
                "abc",
                "Customer One",
                "",
                "CT_022_Invalid_Email_Empty_Message"
            },

            // 13 - Invalid email + empty name
            {
                "abc",
                "",
                "This is a valid message.",
                "CT_023_Invalid_Email_Empty_Name"
            },

            // 14 - Invalid name + empty message
            {
                "customer@gmail.com",
                "12345",
                "",
                "CT_024_Invalid_Name_Empty_Message"
            },

            // 15 - Invalid email + empty name + empty message
            {
                "abc",
                "",
                "",
                "CT_025_Invalid_Email_Empty_Name_Message"
            }
        };
    }


    // =====================================================
    // EXECUTE CORE 15
    // =====================================================

    @Test(
            priority = 8,
            dataProvider = "contactCombinations"
    )
    public void verifyContactCombination(
            String email,
            String name,
            String message,
            String testCaseId) {

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Running: " + testCaseId
        );

        System.out.println(
                "Email   : [" + email + "]"
        );

        System.out.println(
                "Name    : [" + name + "]"
        );

        System.out.println(
                "Message : [" + message + "]"
        );

        contactPage.clickContactLink();

        contactPage.fillContactForm(
                email,
                name,
                message
        );

        contactPage.clickSendMessage();

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println(
                "Actual Alert: " + alertMessage
        );

        alert.accept();

        /*
         * Only the first combination is expected
         * to succeed.
         *
         * All other combinations contain missing
         * or invalid data and should NOT succeed.
         */

        boolean success =
                alertMessage
                        .toLowerCase()
                        .contains("thanks");

        if (testCaseId.equals("CT_011_All_Valid")) {

            Assert.assertTrue(
                    success,
                    "Valid data was not accepted!"
            );

        } else {

            if (success) {

                takeScreenshotWithTimestamp(
                        "DEF_" + testCaseId
                );
            }

            Assert.assertFalse(
                    success,
                    "BUG: Invalid/Incomplete combination accepted! "
                            + testCaseId
            );
        }
    }


    // =====================================================
    // CT_026 - CLOSE CONTACT POPUP
    // =====================================================

    @Test(priority = 9)
    public void verifyContactCloseButton() {

        contactPage.clickContactLink();

        contactPage.clickCloseButton();

        System.out.println(
                "CT_026 - Contact Close button verified"
        );
    }
}