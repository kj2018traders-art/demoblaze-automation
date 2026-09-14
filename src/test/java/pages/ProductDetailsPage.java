package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // =========================
    // LOCATORS
    // =========================

    // Home page product cards
    private By productCards =
            By.cssSelector("#tbodyid .card");

    private By firstProduct =
            By.cssSelector("#tbodyid .card h4.card-title a");

    // Product details
    private By productTitle =
            By.cssSelector("#tbodyid .name");

    private By productPrice =
            By.cssSelector("#tbodyid .price-container");

    private By productDescription =
            By.id("more-information");

    // Product image
    private By productMainImage =
            By.cssSelector("#imgp img");

    // All images inside product image section
    private By productImages =
            By.cssSelector("#imgp img");

    // Add to cart
    private By addToCartButton =
            By.cssSelector(".btn.btn-success.btn-lg");

    // Home
    private By homeLink =
            By.xpath("//a[contains(normalize-space(),'Home')]");

    // =========================
    // OPEN FIRST PRODUCT
    // =========================

    public void openFirstProduct() {

        wait.until(ExpectedConditions.presenceOfElementLocated(productCards));

        List<WebElement> cards = driver.findElements(productCards);

        System.out.println("Product cards found: " + cards.size());

        if (cards.isEmpty()) {
            throw new RuntimeException("No product cards found on Home page.");
        }

        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(firstProduct));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                product);

        wait.until(ExpectedConditions.elementToBeClickable(product));

        product.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(productTitle));

        System.out.println("First product opened successfully.");
    }

    // =========================
    // PRODUCT NAME
    // =========================

    public String getProductName() {

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(productTitle));

        return title.getText().trim();
    }

    public boolean isProductNameDisplayed() {

        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(productTitle))
                    .isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    // =========================
    // PRODUCT PRICE
    // =========================

    public String getProductPrice() {

        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(productPrice));

        return price.getText().trim();
    }

    public boolean isProductPriceDisplayed() {

        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(productPrice))
                    .isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    // =========================
    // PRODUCT DESCRIPTION
    // =========================

    public String getProductDescription() {

        WebElement description = wait.until(
                ExpectedConditions.visibilityOfElementLocated(productDescription));

        return description.getText().trim();
    }

    public boolean isProductDescriptionDisplayed() {

        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(productDescription))
                    .isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    // =========================
    // PRODUCT IMAGE
    // =========================

    public boolean isProductImageDisplayed() {

        try {

            WebElement image = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(productMainImage));

            return image.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    // =========================
    // IMAGE COUNT
    // =========================

    public int getProductImageCount() {

        wait.until(ExpectedConditions.presenceOfElementLocated(productMainImage));

        List<WebElement> images = driver.findElements(productImages);

        return images.size();
    }

    /*
     * Checks whether the SAME PRODUCT has more than one image.
     */
    public boolean hasMultipleProductImages() {

        int imageCount = getProductImageCount();

        System.out.println("Product image count: " + imageCount);

        return imageCount > 1;
    }

    // =========================
    // IMAGE DETAILS
    // =========================

    public void printProductImages() {

        List<WebElement> images = driver.findElements(productImages);

        System.out.println("========== PRODUCT IMAGES ==========");

        System.out.println("Total images: " + images.size());

        for (int i = 0; i < images.size(); i++) {

            WebElement image = images.get(i);

            System.out.println(
                    "Image " + (i + 1) +
                    " displayed: " + image.isDisplayed());

            System.out.println(
                    "Image " + (i + 1) +
                    " src: " + image.getAttribute("src"));
        }

        System.out.println("====================================");
    }

    // =========================
    // ADD TO CART
    // =========================

    public void clickAddToCart() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(addToCartButton));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                button);

        button.click();
    }

    // =========================
    // ADD TO CART ALERT
    // =========================

    public String getAddToCartAlertText() {

        wait.until(ExpectedConditions.alertIsPresent());

        return driver.switchTo().alert().getText();
    }

    public void acceptAddToCartAlert() {

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }

    // =========================
    // HOME
    // =========================

    public void clickHome() {

        WebElement home = wait.until(
                ExpectedConditions.elementToBeClickable(homeLink));

        home.click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(productCards));
    }

    // =========================
    // URL
    // =========================

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    // =========================
    // PAGE TITLE
    // =========================

    public String getPageTitle() {

        return driver.getTitle();
    }
 // ==========================================
 // PRODUCT NAME CLICKABLE
 // ==========================================

 public boolean isFirstProductNameClickable() {

     try {

         WebElement productName = wait.until(
                 ExpectedConditions.presenceOfElementLocated(firstProduct));

         return productName.isDisplayed()
                 && productName.isEnabled();

     } catch (Exception e) {

         return false;
     }
 }


 // ==========================================
 // CLICK PRODUCT NAME
 // ==========================================

 public void clickFirstProductName() {

     WebElement productName = wait.until(
             ExpectedConditions.elementToBeClickable(firstProduct));

     ((JavascriptExecutor) driver).executeScript(
             "arguments[0].scrollIntoView({block:'center'});",
             productName);

     productName.click();

     wait.until(
             ExpectedConditions.presenceOfElementLocated(productTitle));
 }


 // ==========================================
 // PRODUCT IMAGE CLICKABLE
 // ==========================================

 private By firstProductImage =
         By.cssSelector("#tbodyid .card .card-img-top");


 public boolean isFirstProductImageClickable() {

     try {

         WebElement image = wait.until(
                 ExpectedConditions.presenceOfElementLocated(firstProductImage));

         return image.isDisplayed()
                 && image.isEnabled();

     } catch (Exception e) {

         return false;
     }
 }


 // ==========================================
 // CLICK PRODUCT IMAGE
 // ==========================================

 public void clickFirstProductImage() {

     WebElement image = wait.until(
             ExpectedConditions.presenceOfElementLocated(firstProductImage));

     ((JavascriptExecutor) driver).executeScript(
             "arguments[0].scrollIntoView({block:'center'});",
             image);

     image.click();

     wait.until(
             ExpectedConditions.presenceOfElementLocated(productTitle));
 }
}