package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public HomePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        actions = new Actions(driver);
    }

    // =========================================================
    // LOCATORS
    // =========================================================

    // ==============================
    // Navigation
    // ==============================

    private By logo = By.id("nava");

    private By homeLink = By.xpath(
            "//a[contains(@class,'nav-link') and contains(.,'Home')]"
    );

    private By contactLink = By.xpath(
            "//a[contains(normalize-space(),'Contact')]"
    );

    private By aboutUsLink = By.xpath(
            "//a[contains(normalize-space(),'About us')]"
    );

    private By cartLink = By.id("cartur");

    private By loginLink = By.id("login2");

    private By signupLink = By.id("signin2");


    // ==============================
    // Categories
    // ==============================

    private By phonesCategory = By.xpath(
            "//a[contains(text(),'Phones')]"
    );

    private By laptopsCategory = By.xpath(
            "//a[contains(text(),'Laptops')]"
    );

    private By monitorsCategory = By.xpath(
            "//a[contains(text(),'Monitors')]"
    );


    // ==============================
    // Products
    // ==============================

    private By products = By.xpath(
            "//div[@id='tbodyid']//div[contains(@class,'card')]"
    );

    private By productNames = By.xpath(
            "//div[@id='tbodyid']//div[contains(@class,'card')]//h4/a"
    );

    private By productPrices = By.xpath(
            "//div[@id='tbodyid']//div[contains(@class,'card')]//h5"
    );

    private By productImages = By.xpath(
            "//div[@id='tbodyid']//div[contains(@class,'card')]//img"
    );


    // ==============================
    // Pagination
    // ==============================

    private By nextButton = By.id("next2");

    private By previousButton = By.id("prev2");


    // ==============================
    // Slider
    // ==============================

    private By slider = By.id("carouselExampleIndicators");

    private By sliderImages = By.cssSelector(
            "#carouselExampleIndicators .carousel-item img"
    );

    private By sliderNextButton = By.cssSelector(
            "#carouselExampleIndicators .carousel-control-next"
    );

    private By sliderPreviousButton = By.cssSelector(
            "#carouselExampleIndicators .carousel-control-prev"
    );


    // ==============================
    // Footer
    // ==============================

    private By footer = By.id("fotcont");

    private By footerAboutUs = By.xpath(
            "//*[@id='fotcont']//*[contains(normalize-space(),'About Us')]"
    );

    private By footerGetInTouch = By.xpath(
            "//*[@id='fotcont']//*[contains(normalize-space(),'Get in Touch')]"
    );

    private By footerAddress = By.xpath(
            "//*[@id='fotcont']//*[contains(normalize-space(),'Address')]"
    );

    private By footerPhone = By.xpath(
            "//*[@id='fotcont']//*[contains(normalize-space(),'Phone')]"
    );

    private By footerEmail = By.xpath(
            "//*[@id='fotcont']//*[contains(normalize-space(),'Email')]"
    );

    private By footerCopyright = By.xpath(
            "/html/body/footer/p"
    );


    // =========================================================
    // NAVIGATION METHODS
    // =========================================================

    public boolean isLogoDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(logo)
        ).isDisplayed();
    }


    public boolean isHomeLinkDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(homeLink)
        ).isDisplayed();
    }


    public boolean isHomeLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(homeLink)
        ).isEnabled();
    }


    public boolean isContactLinkDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(contactLink)
        ).isDisplayed();
    }


    public boolean isContactLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(contactLink)
        ).isEnabled();
    }


    public boolean isAboutUsLinkDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(aboutUsLink)
        ).isDisplayed();
    }


    public boolean isAboutUsLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(aboutUsLink)
        ).isEnabled();
    }


    public boolean isCartLinkDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartLink)
        ).isDisplayed();
    }


    public boolean isCartLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartLink)
        ).isEnabled();
    }


    public boolean isLoginLinkDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginLink)
        ).isDisplayed();
    }


    public boolean isLoginLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginLink)
        ).isEnabled();
    }


    public boolean isSignupLinkDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(signupLink)
        ).isDisplayed();
    }


    public boolean isSignupLinkEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(signupLink)
        ).isEnabled();
    }


    // =========================================================
    // HOVER - NAVIGATION
    // =========================================================

    public void hoverOverHomeLink() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(homeLink)
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverContactLink() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(contactLink)
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverAboutUsLink() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(aboutUsLink)
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverCartLink() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(cartLink)
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverLoginLink() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(loginLink)
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverSignupLink() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(signupLink)
                );

        actions.moveToElement(element).perform();
    }


    // =========================================================
    // CATEGORIES
    // =========================================================

    public boolean areCategoriesDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        phonesCategory
                )
        ).isDisplayed()

        && wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        laptopsCategory
                )
        ).isDisplayed()

        && wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        monitorsCategory
                )
        ).isDisplayed();
    }


    public boolean isPhonesCategoryDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        phonesCategory
                )
        ).isDisplayed();
    }


    public boolean isLaptopsCategoryDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        laptopsCategory
                )
        ).isDisplayed();
    }


    public boolean isMonitorsCategoryDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        monitorsCategory
                )
        ).isDisplayed();
    }


    // =========================================================
    // HOVER - CATEGORIES
    // =========================================================

    public void hoverOverPhonesCategory() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                phonesCategory
                        )
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverLaptopsCategory() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                laptopsCategory
                        )
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverMonitorsCategory() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                monitorsCategory
                        )
                );

        actions.moveToElement(element).perform();
    }


    // =========================================================
    // PRODUCTS
    // =========================================================

    public int getProductCount() {

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        products,
                        0
                )
        );

        List<WebElement> productList =
                driver.findElements(products);

        return productList.size();
    }


    public int getProductNameCount() {

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        productNames,
                        0
                )
        );

        return driver.findElements(productNames).size();
    }


    public int getProductPriceCount() {

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        productPrices,
                        0
                )
        );

        return driver.findElements(productPrices).size();
    }


    public int getProductImageCount() {

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        productImages,
                        0
                )
        );

        return driver.findElements(productImages).size();
    }


    // =========================================================
    // HOVER - PRODUCTS
    // =========================================================

    public void hoverOverFirstProduct() {

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        productNames,
                        0
                )
        );

        WebElement product =
                driver.findElement(
                        By.xpath(
                                "(//div[@id='tbodyid']//div[contains(@class,'card')]//h4/a)[1]"
                        )
                );

        actions.moveToElement(product).perform();
    }


    public void hoverOverFirstProductImage() {

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        productImages,
                        0
                )
        );

        WebElement image =
                driver.findElement(
                        By.xpath(
                                "(//div[@id='tbodyid']//div[contains(@class,'card')]//img)[1]"
                        )
                );

        actions.moveToElement(image).perform();
    }


    // =========================================================
    // PAGINATION
    // =========================================================

    public boolean isNextButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(nextButton)
        ).isDisplayed();
    }


    public boolean isPreviousButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(previousButton)
        ).isDisplayed();
    }


    // =========================================================
    // OPEN FIRST PRODUCT
    // =========================================================

    public String openFirstProduct() {

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        productNames,
                        0
                )
        );

        WebElement product =
                driver.findElement(
                        By.xpath(
                                "(//div[@id='tbodyid']//div[contains(@class,'card')]//h4/a)[1]"
                        )
                );

        String productName = product.getText();

        product.click();

        wait.until(
                ExpectedConditions.urlContains("prod.html")
        );

        return productName;
    }


    // =========================================================
    // SLIDER
    // =========================================================

    public boolean isSliderDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(slider)
        ).isDisplayed();
    }


    public int getSliderImageCount() {

        return driver.findElements(sliderImages).size();
    }


    public boolean isSliderNextButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        sliderNextButton
                )
        ).isDisplayed();
    }


    public boolean isSliderPreviousButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        sliderPreviousButton
                )
        ).isDisplayed();
    }


    public void clickSliderNext() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        sliderNextButton
                )
        ).click();
    }


    public void clickSliderPrevious() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        sliderPreviousButton
                )
        ).click();
    }


    // =========================================================
    // HOVER - SLIDER
    // =========================================================

    public void hoverOverSlider() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(slider)
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverSliderNextButton() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                sliderNextButton
                        )
                );

        actions.moveToElement(element).perform();
    }


    public void hoverOverSliderPreviousButton() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                sliderPreviousButton
                        )
                );

        actions.moveToElement(element).perform();
    }


    // =========================================================
    // FOOTER
    // =========================================================

    public boolean isFooterDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(footer)
        ).isDisplayed();
    }


    public boolean isFooterAboutUsDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        footerAboutUs
                )
        ).isDisplayed();
    }


    public boolean isFooterGetInTouchDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        footerGetInTouch
                )
        ).isDisplayed();
    }


    public boolean isFooterAddressDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        footerAddress
                )
        ).isDisplayed();
    }


    public boolean isFooterPhoneDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        footerPhone
                )
        ).isDisplayed();
    }


    public boolean isFooterEmailDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        footerEmail
                )
        ).isDisplayed();
    }


    public boolean isFooterCopyrightDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        footerCopyright
                )
        ).isDisplayed();
    }
}