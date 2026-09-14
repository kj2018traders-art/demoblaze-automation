package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    // ==============================
    // URLs
    // ==============================

    private final String HOME_URL = "https://www.demoblaze.com/";
    private final String CART_URL = "https://www.demoblaze.com/cart.html";

    // ==============================
    // Home Page Locators
    // ==============================

    private By productCards =
            By.cssSelector("#tbodyid .card");

    private By firstProduct =
            By.cssSelector("#tbodyid .card .card-title a");

    // ==============================
    // Cart Locators
    // ==============================

    private By cartLink =
            By.id("cartur");

    private By cartRows =
            By.cssSelector("#tbodyid tr");

    private By cartProductNames =
            By.cssSelector("#tbodyid tr td:nth-child(2)");

    private By cartProductPrices =
            By.cssSelector("#tbodyid tr td:nth-child(3)");

    private By deleteButtons =
            By.xpath("//tbody[@id='tbodyid']//a[text()='Delete']");

    private By totalPrice =
            By.id("totalp");

    private By placeOrderButton =
            By.xpath("//button[text()='Place Order']");

    // ==============================
    // Order Modal Locators
    // ==============================

    private By orderModal =
            By.id("orderModal");

    private By nameField =
            By.id("name");

    private By countryField =
            By.id("country");

    private By cityField =
            By.id("city");

    private By cardField =
            By.id("card");

    private By monthField =
            By.id("month");

    private By yearField =
            By.id("year");

    private By purchaseButton =
            By.xpath("//button[text()='Purchase']");

    private By closeButton =
            By.xpath("//div[@id='orderModal']//button[text()='Close']");


    // ==============================
    // Constructor
    // ==============================

    public CartPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }


    // ============================================================
    // HOME PAGE
    // ============================================================

    public void goToHomePage() {

        driver.get(HOME_URL);

        wait.until(
                ExpectedConditions.urlContains("demoblaze.com")
        );

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        productCards,
                        0
                )
        );

        System.out.println("Home page opened successfully.");
    }


    // ============================================================
    // ADD FIRST PRODUCT
    // ============================================================

    public String addFirstProductToCart() {

        goToHomePage();

        WebElement product =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                firstProduct
                        )
                );

        String productName =
                product.getText().trim();

        System.out.println(
                "Product selected: " + productName
        );

        product.click();

        wait.until(
                ExpectedConditions.urlContains("prod.html")
        );

        System.out.println(
                "Product details page opened."
        );

        // Add to cart button
        By addToCartButton =
                By.xpath("//a[text()='Add to cart']");

        WebElement addButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                addToCartButton
                        )
                );

        addButton.click();

        System.out.println(
                "Add to cart button clicked."
        );

        // Handle JavaScript alert
        try {

            Alert alert =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(5)
                    ).until(
                            ExpectedConditions.alertIsPresent()
                    );

            String alertText =
                    alert.getText();

            System.out.println(
                    "Add to cart alert: " + alertText
            );

            alert.accept();

        } catch (Exception e) {

            System.out.println(
                    "No add-to-cart alert appeared."
            );
        }

        return productName;
    }


    // ============================================================
    // OPEN CART
    // ============================================================

    public void openCart() {

        WebElement cart =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                cartLink
                        )
                );

        cart.click();

        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );

        System.out.println(
                "Cart page opened successfully."
        );
    }


    // ============================================================
    // OPEN CART DIRECTLY
    // ============================================================

    public void openCartDirectly() {

        driver.get(CART_URL);

        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );

        System.out.println(
                "Cart page opened directly."
        );
    }


    // ============================================================
    // GET CART PRODUCT COUNT
    // ============================================================

    public int getCartProductCount() {

        return driver.findElements(cartRows).size();
    }


    // ============================================================
    // GET PRODUCT NAMES
    // ============================================================

    public List<WebElement> getCartProductNames() {

        return driver.findElements(
                cartProductNames
        );
    }


    // ============================================================
    // GET PRODUCT PRICES
    // ============================================================

    public List<WebElement> getCartProductPrices() {

        return driver.findElements(
                cartProductPrices
        );
    }


    // ============================================================
    // GET TOTAL PRICE
    // ============================================================

    public int getTotalPrice() {

        try {

            WebElement total =
                    wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    totalPrice
                            )
                    );

            String totalText =
                    total.getText().trim();

            if (totalText.isEmpty()) {
                return 0;
            }

            return Integer.parseInt(totalText);

        } catch (Exception e) {

            return 0;
        }
    }


    // ============================================================
    // DELETE ONE PRODUCT
    // ============================================================

    public void deleteFirstProduct() {

        List<WebElement> buttons =
                driver.findElements(deleteButtons);

        if (buttons.size() > 0) {

            buttons.get(0).click();

            wait.until(
                    ExpectedConditions.numberOfElementsToBe(
                            cartRows,
                            Math.max(
                                    getCartProductCount() - 1,
                                    0
                            )
                    )
            );

            System.out.println(
                    "First product deleted."
            );

        } else {

            System.out.println(
                    "No product available to delete."
            );
        }
    }


    // ============================================================
    // DELETE ALL PRODUCTS
    // ============================================================

    public void deleteAllProducts() {

        while (getCartProductCount() > 0) {

            List<WebElement> buttons =
                    driver.findElements(deleteButtons);

            if (buttons.size() == 0) {
                break;
            }

            buttons.get(0).click();

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "All products deleted from cart."
        );
    }


    // ============================================================
    // PLACE ORDER
    // ============================================================

    public void clickPlaceOrder() {

        WebElement placeOrder =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                placeOrderButton
                        )
                );

        placeOrder.click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        orderModal
                )
        );

        System.out.println(
                "Place Order modal opened."
        );
    }


    // ============================================================
    // CHECK ORDER MODAL
    // ============================================================

    public boolean isOrderModalDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            orderModal
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    // ============================================================
    // ENTER ORDER DETAILS
    // ============================================================

    public void enterOrderDetails(
            String name,
            String country,
            String city,
            String card,
            String month,
            String year) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        nameField
                )
        ).sendKeys(name);

        driver.findElement(countryField)
                .sendKeys(country);

        driver.findElement(cityField)
                .sendKeys(city);

        driver.findElement(cardField)
                .sendKeys(card);

        driver.findElement(monthField)
                .sendKeys(month);

        driver.findElement(yearField)
                .sendKeys(year);

        System.out.println(
                "Order details entered."
        );
    }


    // ============================================================
    // CLEAR ORDER FIELDS
    // ============================================================

    public void clearOrderFields() {

        driver.findElement(nameField)
                .clear();

        driver.findElement(countryField)
                .clear();

        driver.findElement(cityField)
                .clear();

        driver.findElement(cardField)
                .clear();

        driver.findElement(monthField)
                .clear();

        driver.findElement(yearField)
                .clear();

        System.out.println(
                "All order fields cleared."
        );
    }


    // ============================================================
    // PURCHASE
    // ============================================================

    public void clickPurchase() {

        WebElement purchase =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                purchaseButton
                        )
                );

        purchase.click();

        System.out.println(
                "Purchase button clicked."
        );
    }


    // ============================================================
    // PURCHASE ALERT
    // ============================================================

    public boolean isPurchaseAlertPresent() {

        try {

            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(3)
            ).until(
                    ExpectedConditions.alertIsPresent()
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }


    // ============================================================
    // GET PURCHASE ALERT TEXT
    // ============================================================

    public String getPurchaseAlertText() {

        try {

            Alert alert =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(3)
                    ).until(
                            ExpectedConditions.alertIsPresent()
                    );

            String text =
                    alert.getText();

            alert.accept();

            return text;

        } catch (Exception e) {

            return "";
        }
    }


    // ============================================================
    // CLOSE ORDER MODAL
    // ============================================================

    public void closeOrderModal() {

        try {

            WebElement close =
                    wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    closeButton
                            )
                    );

            close.click();

            System.out.println(
                    "Order modal closed."
            );

        } catch (Exception e) {

            System.out.println(
                    "Order modal was already closed."
            );
        }
    }


    // ============================================================
    // WAIT FOR PURCHASE CONFIRMATION
    // ============================================================

    public boolean isPurchaseSuccessful() {

        try {

            By successMessage =
                    By.xpath(
                            "//div[contains(@class,'sweet-alert')]"
                    );

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            successMessage
                    )
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }


    // ============================================================
    // CLICK OK AFTER SUCCESS
    // ============================================================

    public void clickPurchaseSuccessOK() {

        try {

            By okButton =
                    By.xpath(
                            "//button[text()='OK']"
                    );

            WebElement ok =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(5)
                    ).until(
                            ExpectedConditions.elementToBeClickable(
                                    okButton
                            )
                    );

            ok.click();

            System.out.println(
                    "Purchase confirmation OK clicked."
            );

        } catch (Exception e) {

            System.out.println(
                    "Purchase confirmation OK not found."
            );
        }
    }


    // ============================================================
    // SCROLL TO CART
    // ============================================================

    public void scrollToCart() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight);"
        );
    }
}