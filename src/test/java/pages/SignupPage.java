package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================================================
    // Locators
    // =========================================================

    private By signupLink = By.id("signin2");

    private By signupModal = By.id("signInModal");

    private By usernameField = By.id("sign-username");

    private By passwordField = By.id("sign-password");

    private By signupButton = By.xpath(
            "//button[contains(text(),'Sign up')]" );
  
    private By signupCloseButton =
            By.xpath("//div[@id='signInModal']//button[@class='close']");

    // =========================================================
    // Constructor
    // =========================================================

    public SignupPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    // =========================================================
    // Open Sign Up Popup
    // =========================================================

    public void clickSignupLink() {

        wait.until(
                ExpectedConditions.elementToBeClickable(signupLink)
        ).click();
    }

    // =========================================================
    // Verify Sign Up Popup
    // =========================================================

    public boolean isSignupPopupDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        signupModal
                )
        ).isDisplayed();
    }

    // =========================================================
    // Verify Username Field
    // =========================================================

    public boolean isUsernameFieldDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameField
                )
        ).isDisplayed();
    }

    // =========================================================
    // Verify Password Field
    // =========================================================

    public boolean isPasswordFieldDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordField
                )
        ).isDisplayed();
    }

    // =========================================================
    // Enter Username
    // =========================================================

    public void enterUsername(String username) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameField
                )
        ).sendKeys(username);
    }

    // =========================================================
    // Enter Password
    // =========================================================

    public void enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordField
                )
        ).sendKeys(password);
    }

    // =========================================================
    // Click Sign Up Button
    // =========================================================

    public void clickSignupButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        signupButton
                )
        ).click();
    }

    public void clickSignupCloseButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        signupCloseButton))
                .click();
    }

   
    // =========================================================
    // Get Alert Message
    // =========================================================

    public String getAlertMessage() {

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        return driver.switchTo()
                .alert()
                .getText();
    }

    // =========================================================
    // Accept Alert
    // =========================================================

    public void acceptAlert() {

        driver.switchTo()
                .alert()
                .accept();
    }

    // =========================================================
    // Get Password Field Type
    // =========================================================

    public String getPasswordFieldType() {

        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordField
                )
        );

        return password.getAttribute("type");
    }

    // =========================================================
    // Complete Signup
    // =========================================================

    public String signup(String username, String password) {

        clickSignupLink();

        isSignupPopupDisplayed();

        enterUsername(username);

        enterPassword(password);

        clickSignupButton();

        String alertMessage = getAlertMessage();

        acceptAlert();

        return alertMessage;
    }
   
}