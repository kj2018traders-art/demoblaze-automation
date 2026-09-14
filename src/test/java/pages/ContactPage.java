package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ==============================
    // LOCATORS
    // ==============================

    private By contactLink =
            By.xpath("//a[contains(text(),'Contact')]");

    private By contactModal =
            By.id("exampleModal");

    private By emailField =
            By.id("recipient-email");

    private By nameField =
            By.id("recipient-name");

    private By messageField =
            By.id("message-text");

    private By sendMessageButton =
            By.xpath("//button[contains(text(),'Send message')]");

    private By closeButton =
            By.xpath("//div[@id='exampleModal']//button[contains(text(),'Close')]");


    // ==============================
    // CONSTRUCTOR
    // ==============================

    public ContactPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }


    // ==============================
    // CONTACT LINK
    // ==============================

    public void clickContactLink() {

        wait.until(
                ExpectedConditions.elementToBeClickable(contactLink)
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(contactModal)
        );
    }


    public boolean isContactLinkDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            contactLink
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isContactLinkEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            contactLink
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    // ==============================
    // POPUP
    // ==============================

    public boolean isContactPopupDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            contactModal
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    // ==============================
    // EMAIL
    // ==============================

    public boolean isEmailFieldDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            emailField
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isEmailFieldEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            emailField
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void enterEmail(String email) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        emailField
                )
        );

        element.clear();

        if (email != null) {
            element.sendKeys(email);
        }
    }


    // ==============================
    // NAME
    // ==============================

    public boolean isNameFieldDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            nameField
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isNameFieldEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            nameField
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void enterName(String name) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        nameField
                )
        );

        element.clear();

        if (name != null) {
            element.sendKeys(name);
        }
    }


    // ==============================
    // MESSAGE
    // ==============================

    public boolean isMessageFieldDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            messageField
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isMessageFieldEnabled() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            messageField
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }


    public void enterMessage(String message) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        messageField
                )
        );

        element.clear();

        if (message != null) {
            element.sendKeys(message);
        }
    }


    // ==============================
    // SEND MESSAGE
    // ==============================

    public void clickSendMessage() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        sendMessageButton
                )
        ).click();
    }


    // ==============================
    // CLOSE
    // ==============================

    public void clickCloseButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        closeButton
                )
        ).click();
    }


    // ==============================
    // COMPLETE FORM
    // ==============================

    public void fillContactForm(
            String email,
            String name,
            String message) {

        enterEmail(email);
        enterName(name);
        enterMessage(message);
    }
}