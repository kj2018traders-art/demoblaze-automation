package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SignupPage;

public class SignupTest extends BaseTest {

    SignupPage signupPage;

    WebDriverWait wait;

    // =========================================================
    // Navigate to Home Page
    // =========================================================

    @BeforeMethod
    public void navigateToHome() {

        driver.get("https://www.demoblaze.com/");

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        signupPage = new SignupPage(driver);

        System.out.println(
                "===== Navigated to Home Page ====="
        );
    }

    // =========================================================
    //  Verify Sign Up Link
    // =========================================================

    @Test(priority = 1)
    public void verifySignupLink() {

        signupPage.clickSignupLink();

        Assert.assertTrue(
                signupPage.isSignupPopupDisplayed(),
                "Sign Up popup is not displayed!"
        );

        System.out.println(
                "Sign Up link verified successfully"
        );
    }

    // =========================================================
    //  Verify Sign Up Popup
    // =========================================================

    @Test(priority = 2)
    public void verifySignupPopup() {

        signupPage.clickSignupLink();

        Assert.assertTrue(
                signupPage.isSignupPopupDisplayed(),
                "Sign Up popup is not displayed!"
        );

        System.out.println(
                "Sign Up popup displayed successfully"
        );
    }

    // =========================================================
    //  Verify Sign Up Fields
    // =========================================================

    @Test(priority = 3)
    public void verifySignupFields() {

        signupPage.clickSignupLink();

        Assert.assertTrue(
                signupPage.isSignupPopupDisplayed(),
                "Sign Up popup is not displayed!"
        );

        Assert.assertTrue(
                signupPage.isUsernameFieldDisplayed(),
                "Username field is not displayed!"
        );

        Assert.assertTrue(
                signupPage.isPasswordFieldDisplayed(),
                "Password field is not displayed!"
        );

        System.out.println(
                "Sign Up fields verified successfully"
        );
    }

    // =========================================================
    //  Data Driven Customer Registration
    // =========================================================

    @DataProvider(name = "customerData")
    public Object[][] customerData() {

        String timestamp =
                String.valueOf(System.currentTimeMillis());

        return new Object[][] {

            {
                "customerOne_" + timestamp,
                "Customer@123"
            },

            {
                "customerTwo_" + timestamp,
                "Customer@456"
            },

            {
                "customerThree_" + timestamp,
                "Customer@789"
            }
        };
    }

    @Test(priority = 4,dataProvider = "customerData")
    public void verifyCustomerRegistration( String username,String password) {

        System.out.println( "===== Starting Customer Registration =====");

        System.out.println( "Username : " + username);

        System.out.println( "Password : " + password);

        String alertMessage =
                signupPage.signup(
                        username,
                        password
                );

        System.out.println(
                "Signup Alert : " + alertMessage
        );

        Assert.assertTrue(
                alertMessage.toLowerCase().contains("sign up")
                ||
                alertMessage.toLowerCase().contains("successful"),
                "Unexpected signup alert: "
                        + alertMessage
        );

        System.out.println(
                "Customer registered successfully: "
                        + username
        );

        System.out.println(
                "=========================================="
        );
    }

    // =========================================================
    // Empty Username
    // =========================================================

    @Test(priority = 5)
    public void verifySignupWithEmptyUsername() {

        signupPage.clickSignupLink();

        Assert.assertTrue(
                signupPage.isSignupPopupDisplayed()
        );

        signupPage.enterPassword("Test@123");

        signupPage.clickSignupButton();

        String alertMessage =
                signupPage.getAlertMessage();

        System.out.println(
                "Empty username alert: "
                        + alertMessage
        );

        signupPage.acceptAlert();

        Assert.assertTrue(
                alertMessage.contains("Username")
                        ||
                alertMessage.contains("Password"),
                "Unexpected alert: "
                        + alertMessage
        );
    }

    // =========================================================
    //  Empty Password
    // =========================================================

    @Test(priority = 6)
    public void verifySignupWithEmptyPassword() {

        signupPage.clickSignupLink();

        Assert.assertTrue(
                signupPage.isSignupPopupDisplayed()
        );

        signupPage.enterUsername("TestUser123");

        signupPage.clickSignupButton();

        String alertMessage =
                signupPage.getAlertMessage();

        System.out.println(
                "Empty password alert: "
                        + alertMessage
        );

        signupPage.acceptAlert();

        Assert.assertTrue(
                alertMessage.contains("Username")
                        ||
                alertMessage.contains("Password"),
                "Unexpected alert: "
                        + alertMessage
        );
    }

    // =========================================================
    //  Verify Password Is Masked
    // =========================================================

    @Test(priority = 7)
    public void verifyPasswordIsMasked() {

        signupPage.clickSignupLink();

        Assert.assertTrue(
                signupPage.isSignupPopupDisplayed()
        );

        String fieldType =
                signupPage.getPasswordFieldType();

        Assert.assertEquals(
                fieldType,
                "password",
                "Password field is not masked!"
        );

        System.out.println(
                "Password field is masked successfully"
        );
    }

    // =========================================================
    //  Verify Duplicate Username
    // =========================================================

    @Test(priority = 8)
    public void verifyDuplicateUsername() {

        String username = "customerOne_";
        String password = "Customer@123";

        String alertMessage =
                signupPage.signup(
                        username,
                        password
                );

        System.out.println(
                "Duplicate Username Alert: "
                        + alertMessage
        );

        Assert.assertTrue(
                alertMessage.toLowerCase()
                        .contains("already exist"),
                "Duplicate username was not detected!"
        );
    }
    @Test(priority = 9)
    public void verifySignupCloseButton() {

        System.out.println("===== Verify Sign Up Close Button =====");

        signupPage.clickSignupLink();

        Assert.assertTrue(
                signupPage.isSignupPopupDisplayed(),
                "Sign Up popup is not displayed!"
        );

        signupPage.clickSignupCloseButton();

        Assert.assertTrue(
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                        By.id("signInModal")
                )),
                "Sign Up popup did not close!"
        );

        System.out.println("Sign Up popup closed successfully");
    }
}