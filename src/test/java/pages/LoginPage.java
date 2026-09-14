package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================================================
    // LOCATORS
    // =========================================================

    // ---------------- HOME PAGE ----------------

    private By homeLink = By.xpath("//a[contains(text(),'Home')]");

    private By loginLink = By.id("login2");

    private By signUpLink = By.id("signin2");

    private By logoutButton = By.id("logout2");


    // ---------------- LOGIN POPUP ----------------

    private By loginModal = By.id("logInModal");

    private By usernameField = By.id("loginusername");

    private By passwordField = By.id("loginpassword");

    private By loginButton =
            By.xpath("//div[@id='logInModal']//button[text()='Log in']");

    private By closeButton =
            By.xpath(
                    "//div[@id='logInModal']//button[contains(text(),'Close')]"
            );


    // ---------------- WELCOME MESSAGE ----------------

    private By welcomeMessage = By.id("nameofuser");


    // ---------------- SIGN UP POPUP ----------------

    private By signUpModal = By.id("signInModal");

    private By signUpUsername =
            By.id("sign-username");

    private By signUpPassword =
            By.id("sign-password");

    private By signUpButton =
            By.xpath(
                    "//div[@id='signInModal']//button[contains(text(),'Sign up')]"
            );

    private By signUpCloseButton =
            By.xpath(
                    "//div[@id='signInModal']//button[contains(text(),'Close')]"
            );


    // ---------------- LOGOUT SUCCESS MESSAGE ----------------

    /*
     * Demoblaze currently does not display a dedicated
     * logout-success confirmation message.
     *
     * This locator is kept for the defect/enhancement test.
     *
     * Update this locator if the application later introduces
     * an actual logout confirmation element.
     */

    private By logoutSuccessMessage =
            By.xpath(
                    "//*[contains(text(),'Logout successful') " +
                    "or contains(text(),'Logged out successfully') " +
                    "or contains(text(),'Logout successful!')]"
            );


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }


    // =========================================================
    // HOME LINK
    // =========================================================

    public boolean isHomeLinkDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            homeLink
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isHomeLinkEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            homeLink
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void clickHomeLink() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        homeLink
                )
        ).click();
    }


    // =========================================================
    // LOGIN LINK
    // =========================================================

    public boolean isLoginLinkDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loginLink
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isLoginLinkEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loginLink
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void clickLoginLink() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginLink
                )
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginModal
                )
        );
    }


    // =========================================================
    // LOGIN POPUP
    // =========================================================

    public boolean isLoginPopupDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loginModal
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    // =========================================================
    // USERNAME FIELD
    // =========================================================

    public boolean isUsernameDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            usernameField
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public void enterUsername(String username) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                usernameField
                        )
                );

        element.clear();

        if (username != null && !username.isEmpty()) {

            element.sendKeys(username);
        }
    }


    // =========================================================
    // PASSWORD FIELD
    // =========================================================

    public boolean isPasswordDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            passwordField
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public void enterPassword(String password) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                passwordField
                        )
                );

        element.clear();

        if (password != null && !password.isEmpty()) {

            element.sendKeys(password);
        }
    }


    // =========================================================
    // PASSWORD MASKING
    // =========================================================

    public String getPasswordFieldType() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                passwordField
                        )
                );

        return element.getAttribute("type");
    }


    // =========================================================
    // LOGIN BUTTON
    // =========================================================

    public boolean isLoginButtonDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loginButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isLoginButtonEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loginButton
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void clickLoginButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton
                )
        ).click();
    }


    // =========================================================
    // LOGIN CLOSE BUTTON
    // =========================================================

    public boolean isCloseButtonDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            closeButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isCloseButtonEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            closeButton
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void clickLoginCloseButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        closeButton
                )
        ).click();

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        loginModal
                )
        );
    }


    // =========================================================
    // WELCOME MESSAGE
    // =========================================================

    public boolean isWelcomeMessageDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            welcomeMessage
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public String getWelcomeMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        welcomeMessage
                )
        ).getText();
    }


    // =========================================================
    // LOGOUT
    // =========================================================

    public boolean isLogoutDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            logoutButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isLogoutEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            logoutButton
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void clickLogout() {

        System.out.println(
                "===== Clicking Logout ====="
        );

        WebDriverWait logoutWait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(15)
                );

        boolean clicked = false;

        for (int attempt = 1; attempt <= 3; attempt++) {

            try {

                System.out.println(
                        "Logout click attempt: " + attempt
                );

                /*
                 * IMPORTANT:
                 * Find the element again on every attempt.
                 * This prevents StaleElementReferenceException.
                 */

                WebElement logout =
                        logoutWait.until(
                                ExpectedConditions.refreshed(
                                        ExpectedConditions.elementToBeClickable(
                                                logoutButton
                                        )
                                )
                        );

                logout.click();

                clicked = true;

                break;

            } catch (
                    org.openqa.selenium.StaleElementReferenceException e
            ) {

                System.out.println(
                        "Logout element became stale. Retrying..."
                );

            }
        }

        if (!clicked) {

            throw new RuntimeException(
                    "Unable to click Logout after 3 attempts."
            );
        }

        /*
         * Wait until logout disappears.
         */

        logoutWait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        logoutButton
                )
        );

        /*
         * Wait until Login appears again.
         */

        logoutWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginLink
                )
        );

        System.out.println(
                "===== Logout completed successfully ====="
        );
    }


    // =========================================================
    // SIGN UP LINK
    // =========================================================

    public boolean isSignUpLinkDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpLink
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isSignUpLinkEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpLink
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void clickSignUpLink() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        signUpLink
                )
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        signUpModal
                )
        );
    }


    // =========================================================
    // SIGN UP POPUP
    // =========================================================

    public boolean isSignUpPopupDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpModal
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    // =========================================================
    // SIGN UP USERNAME
    // =========================================================

    public boolean isSignUpUsernameDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpUsername
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    // =========================================================
    // SIGN UP PASSWORD
    // =========================================================

    public boolean isSignUpPasswordDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpPassword
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    // =========================================================
    // SIGN UP BUTTON
    // =========================================================

    public boolean isSignUpButtonDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isSignUpButtonEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpButton
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    // =========================================================
    // SIGN UP CLOSE BUTTON
    // =========================================================

    public boolean isSignUpCloseButtonDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpCloseButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isSignUpCloseButtonEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            signUpCloseButton
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void clickSignUpCloseButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        signUpCloseButton
                )
        ).click();

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        signUpModal
                )
        );
    }


    // =========================================================
    // LOGOUT SUCCESS MESSAGE
    // =========================================================

    public boolean isLogoutSuccessMessageDisplayed() {

        /*
         * This method is intentionally used for the
         * known bug/enhancement:
         *
         * "Application does not display a success message
         * after successful logout."
         */

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            logoutSuccessMessage
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    // =========================================================
    // COMPLETE LOGIN
    // =========================================================

    public void login(
            String username,
            String password
    ) {

        clickLoginLink();

        enterUsername(username);

        enterPassword(password);

        clickLoginButton();
    }
}