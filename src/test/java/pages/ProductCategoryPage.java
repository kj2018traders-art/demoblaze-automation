package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCategoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =====================================================
    // URL
    // =====================================================

    private final String HOME_URL = "https://www.demoblaze.com/";

    // =====================================================
    // CATEGORY LOCATORS
    // =====================================================

    private By phonesCategory =
            By.xpath("//a[@class='list-group-item' and normalize-space()='Phones']");

    private By laptopsCategory =
            By.xpath("//a[@class='list-group-item' and normalize-space()='Laptops']");

    private By monitorsCategory =
            By.xpath("//a[@class='list-group-item' and normalize-space()='Monitors']");

    // =====================================================
    // PRODUCT LOCATORS
    // =====================================================

    private By productContainer =
            By.id("tbodyid");

    private By productCards =
            By.cssSelector("#tbodyid .card");

    private By productNames =
            By.cssSelector("#tbodyid .card .card-title");

    private By productPrices =
            By.cssSelector("#tbodyid .card h5");

    private By productImages =
            By.cssSelector("#tbodyid .card img");

    private By firstProduct =
            By.cssSelector("#tbodyid .card .card-title a");

    // =====================================================
    // PAGINATION
    // =====================================================

    private By nextButton =
            By.id("next2");

    private By previousButton =
            By.id("prev2");

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public ProductCategoryPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    // =====================================================
    // HOME PAGE
    // =====================================================

    public void goToHomePage() {

        driver.get(HOME_URL);

        waitForProductGrid();

        System.out.println("======================================");
        System.out.println("===== Navigated to Home Page =====");
        System.out.println("======================================");
    }

    // =====================================================
    // WAIT FOR PRODUCT GRID
    // =====================================================

    private void waitForProductGrid() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(productContainer)
        );

        wait.until(driver -> {

            try {

                return driver.findElements(productCards).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });
    }

    // =====================================================
    // CATEGORY - PHONES
    // =====================================================

    public void clickPhonesCategory() {

        clickCategory(phonesCategory);

        System.out.println("Phones category selected");
    }

    // =====================================================
    // CATEGORY - LAPTOPS
    // =====================================================

    public void clickLaptopsCategory() {

        clickCategory(laptopsCategory);

        System.out.println("Laptops category selected");
    }

    // =====================================================
    // CATEGORY - MONITORS
    // =====================================================

    public void clickMonitorsCategory() {

        clickCategory(monitorsCategory);

        System.out.println("Monitors category selected");
    }

    // =====================================================
    // COMMON CATEGORY METHOD
    // =====================================================

    private void clickCategory(By categoryLocator) {

        WebElement category =
                wait.until(
                        ExpectedConditions.elementToBeClickable(categoryLocator)
                );

        category.click();

        wait.until(driver -> {

            try {

                return driver.findElements(productCards).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        sleep(1000);
    }

    // =====================================================
    // PRODUCT COUNT
    // =====================================================

    public int getProductCount() {

        waitForProductGrid();

        return driver.findElements(productCards).size();
    }

    // =====================================================
    // PRODUCT NAMES
    // =====================================================

    public List<String> getProductNames() {

        waitForProductGrid();

        List<String> names = new ArrayList<>();

        int retry = 0;

        while (retry < 3) {

            try {

                List<WebElement> elements =
                        driver.findElements(productNames);

                for (WebElement element : elements) {

                    String name =
                            element.getText().trim();

                    if (!name.isEmpty()) {

                        names.add(name);
                    }
                }

                return names;

            } catch (StaleElementReferenceException e) {

                retry++;

                sleep(500);
            }
        }

        return names;
    }

    // =====================================================
    // PRINT PRODUCT NAMES
    // =====================================================

    public void printAllProductNames() {

        List<String> names =
                getProductNames();

        System.out.println("========== PRODUCT NAMES ==========");

        for (String name : names) {

            System.out.println(name);
        }

        System.out.println("==================================");
    }

    // =====================================================
    // VERIFY PRODUCT NAMES
    // =====================================================

    public boolean areProductNamesDisplayed() {

        List<String> names =
                getProductNames();

        if (names.isEmpty()) {

            return false;
        }

        for (String name : names) {

            if (name == null ||
                    name.trim().isEmpty()) {

                return false;
            }
        }

        return true;
    }

    // =====================================================
    // PRODUCT PRICES
    // =====================================================

    public List<String> getProductPrices() {

        waitForProductGrid();

        List<String> prices =
                new ArrayList<>();

        int retry = 0;

        while (retry < 3) {

            try {

                List<WebElement> elements =
                        driver.findElements(productPrices);

                for (WebElement element : elements) {

                    String price =
                            element.getText().trim();

                    if (!price.isEmpty()) {

                        prices.add(price);
                    }
                }

                return prices;

            } catch (StaleElementReferenceException e) {

                retry++;

                sleep(500);
            }
        }

        return prices;
    }

    // =====================================================
    // PRINT PRODUCT PRICES
    // =====================================================

    public void printAllProductPrices() {

        List<String> prices =
                getProductPrices();

        System.out.println("========== PRODUCT PRICES ==========");

        for (String price : prices) {

            System.out.println(price);
        }

        System.out.println("====================================");
    }

    // =====================================================
    // VERIFY PRODUCT PRICES
    // =====================================================

    public boolean areProductPricesDisplayed() {

        List<String> prices =
                getProductPrices();

        if (prices.isEmpty()) {

            return false;
        }

        for (String price : prices) {

            if (!price.matches("\\$\\d+")) {

                return false;
            }
        }

        return true;
    }

    // =====================================================
    // PRODUCT IMAGES
    // =====================================================

    public List<WebElement> getProductImages() {

        waitForProductGrid();

        return driver.findElements(productImages);
    }

    // =====================================================
    // VERIFY PRODUCT IMAGES
    // =====================================================

    public boolean areProductImagesDisplayed() {

        waitForProductGrid();

        int retry = 0;

        while (retry < 3) {

            try {

                List<WebElement> images =
                        driver.findElements(productImages);

                if (images.isEmpty()) {

                    return false;
                }

                for (WebElement image : images) {

                    Boolean loaded =
                            (Boolean)
                            ((JavascriptExecutor) driver)
                            .executeScript(
                                    "return arguments[0].complete && " +
                                    "arguments[0].naturalWidth > 0;",
                                    image
                            );

                    if (!Boolean.TRUE.equals(loaded)) {

                        sleep(1000);

                        retry++;

                        break;
                    }

                    if (!image.isDisplayed()) {

                        return false;
                    }
                }

                if (retry == 0 ||
                        retry >= 3) {

                    return retry == 0;
                }

            } catch (StaleElementReferenceException e) {

                retry++;

                sleep(500);
            }
        }

        return false;
    }

    // =====================================================
    // IMAGE COUNT
    // =====================================================

    public int getProductImageCount() {

        waitForProductGrid();

        return driver.findElements(productImages).size();
    }

    // =====================================================
    // NAME COUNT
    // =====================================================

    public int getProductNameCount() {

        return getProductNames().size();
    }

    // =====================================================
    // PRICE COUNT
    // =====================================================

    public int getProductPriceCount() {

        return getProductPrices().size();
    }

    // =====================================================
    // OPEN FIRST PRODUCT
    // =====================================================

    public String openFirstProduct() {

        waitForProductGrid();

        WebElement product =
                wait.until(
                        ExpectedConditions.elementToBeClickable(firstProduct)
                );

        String productName =
                product.getText().trim();

        product.click();

        wait.until(
                ExpectedConditions.urlContains("prod.html")
        );

        return productName;
    }

    // =====================================================
    // NEXT BUTTON DISPLAYED
    // =====================================================

    public boolean isNextButtonDisplayed() {

        try {

            return driver.findElement(nextButton)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =====================================================
    // CLICK NEXT
    // =====================================================

    public void clickNext() {

        WebElement next =
                wait.until(
                        ExpectedConditions.elementToBeClickable(nextButton)
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        next
                );

        sleep(1500);

        waitForProductGrid();
    }

    // =====================================================
    // CLICK PREVIOUS
    // =====================================================

    public void clickPrevious() {

        WebElement previous =
                wait.until(
                        ExpectedConditions.elementToBeClickable(previousButton)
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        previous
                );

        sleep(1500);

        waitForProductGrid();
    }

    // =====================================================
    // VERIFY NEXT PAGINATION
    // =====================================================

    public boolean verifyNextPagination() {

        goToHomePage();

        int beforeCount =
                getProductCount();

        List<String> beforeNames =
                getProductNames();

        clickNext();

        int afterCount =
                getProductCount();

        List<String> afterNames =
                getProductNames();

        System.out.println(
                "Before Next Product Count: "
                        + beforeCount
        );

        System.out.println(
                "After Next Product Count: "
                        + afterCount
        );

        /*
         * Correct Demoblaze behavior:
         * Next changes the product listing.
         * URL remains the same.
         */

        return beforeCount > 0
                && afterCount > 0
                && !beforeNames.equals(afterNames);
    }

    // =====================================================
    // VERIFY PREVIOUS PAGINATION
    // =====================================================

    public boolean verifyPreviousPagination() {

        goToHomePage();

        List<String> firstPageNames =
                getProductNames();

        clickNext();

        List<String> secondPageNames =
                getProductNames();

        clickPrevious();

        List<String> returnedNames =
                getProductNames();

        System.out.println(
                "First Page Products: "
                        + firstPageNames.size()
        );

        System.out.println(
                "Second Page Products: "
                        + secondPageNames.size()
        );

        System.out.println(
                "Returned Page Products: "
                        + returnedNames.size()
        );

        /*
         * Correct behavior:
         * Previous should return to first page.
         */

        return !firstPageNames.equals(secondPageNames)
                && firstPageNames.equals(returnedNames);
    }

    // =====================================================
    // CATEGORY SWITCHING
    // =====================================================

    public int getPhonesCount() {

        goToHomePage();

        clickPhonesCategory();

        return getProductCount();
    }

    public int getLaptopsCount() {

        goToHomePage();

        clickLaptopsCategory();

        return getProductCount();
    }

    public int getMonitorsCount() {

        goToHomePage();

        clickMonitorsCategory();

        return getProductCount();
    }

    // =====================================================
    // DEF_CAT_001
    // PRODUCT CARD HOVER EFFECT
    // =====================================================

    public boolean verifyProductCardHoverEffect() {

        waitForProductGrid();

        List<WebElement> cards =
                driver.findElements(productCards);

        if (cards.isEmpty()) {

            return false;
        }

        WebElement card =
                cards.get(0);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        String beforeTransform =
                (String) js.executeScript(
                        "return window.getComputedStyle(arguments[0]).transform;",
                        card
                );

        String beforeShadow =
                (String) js.executeScript(
                        "return window.getComputedStyle(arguments[0]).boxShadow;",
                        card
                );

        Actions actions =
                new Actions(driver);

        actions.moveToElement(card).perform();

        sleep(1000);

        String afterTransform =
                (String) js.executeScript(
                        "return window.getComputedStyle(arguments[0]).transform;",
                        card
                );

        String afterShadow =
                (String) js.executeScript(
                        "return window.getComputedStyle(arguments[0]).boxShadow;",
                        card
                );

        System.out.println(
                "Before Transform: "
                        + beforeTransform
        );

        System.out.println(
                "After Transform: "
                        + afterTransform
        );

        System.out.println(
                "Before Shadow: "
                        + beforeShadow
        );

        System.out.println(
                "After Shadow: "
                        + afterShadow
        );

        return !beforeTransform.equals(afterTransform)
                || !beforeShadow.equals(afterShadow);
    }

    // =====================================================
    // DEF_CAT_002
    // SEARCH FUNCTIONALITY
    // =====================================================

    public boolean isSearchFunctionalityAvailable() {

        /*
         * Demoblaze currently does not provide
         * a search field or search button.
         */

        By searchInput =
                By.id("search");

        By searchButton =
                By.xpath(
                        "//button[contains(translate(normalize-space(.),"
                        + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
                        + "'abcdefghijklmnopqrstuvwxyz'),'search')]"
                );

        boolean searchField =
                !driver.findElements(searchInput).isEmpty();

        boolean searchBtn =
                !driver.findElements(searchButton).isEmpty();

        System.out.println(
                "Search Field Available: "
                        + searchField
        );

        System.out.println(
                "Search Button Available: "
                        + searchBtn
        );

        return searchField && searchBtn;
    }

    // =====================================================
    // TC_CAT_015
    // SELECTED CATEGORY HIGHLIGHT
    // =====================================================

    public boolean verifySelectedCategoryHighlighted(
            String categoryName) {

        System.out.println(
                "======================================"
        );

        System.out.println(
                "TC_CAT_015 - Selected Category Highlight"
        );

        System.out.println(
                "======================================"
        );

        By categoryLocator =
                By.xpath(
                        "//a[@class='list-group-item' "
                        + "and normalize-space()='"
                        + categoryName
                        + "']"
                );

        WebElement category =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                categoryLocator
                        )
                );

        category.click();

        sleep(1000);

        /*
         * Important:
         * Demoblaze does NOT add an "active" or
         * "selected" class to the selected category.
         *
         * Therefore this test identifies the defect.
         */

        String className =
                category.getAttribute("class");

        String style =
                category.getAttribute("style");

        System.out.println(
                "Selected Category: "
                        + categoryName
        );

        System.out.println(
                "Class: "
                        + className
        );

        System.out.println(
                "Style: "
                        + style
        );

        boolean highlighted =
                (className != null &&
                (className.contains("active")
                || className.contains("selected")))
                ||
                (style != null &&
                !style.trim().isEmpty());

        System.out.println(
                "Category Highlighted: "
                        + highlighted
        );

        System.out.println(
                "======================================"
        );

        return highlighted;
    }

    // =====================================================
    // SCROLLING
    // =====================================================

    public boolean verifyScrollingDownAndUp() {

        goToHomePage();

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        long initialPosition =
                ((Number) js.executeScript(
                        "return window.pageYOffset;"
                )).longValue();

        System.out.println(
                "Initial Scroll Position: "
                        + initialPosition
        );

        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight);"
        );

        sleep(1000);

        long bottomPosition =
                ((Number) js.executeScript(
                        "return window.pageYOffset;"
                )).longValue();

        long pageHeight =
                ((Number) js.executeScript(
                        "return document.body.scrollHeight;"
                )).longValue();

        long windowHeight =
                ((Number) js.executeScript(
                        "return window.innerHeight;"
                )).longValue();

        System.out.println(
                "Bottom Scroll Position: "
                        + bottomPosition
        );

        System.out.println(
                "Page Height: "
                        + pageHeight
        );

        System.out.println(
                "Window Height: "
                        + windowHeight
        );

        boolean scrolledDown =
                bottomPosition > initialPosition;

        js.executeScript(
                "window.scrollTo(0, 0);"
        );

        sleep(1000);

        long topPosition =
                ((Number) js.executeScript(
                        "return window.pageYOffset;"
                )).longValue();

        System.out.println(
                "Top Scroll Position: "
                        + topPosition
        );

        boolean scrolledUp =
                topPosition == 0;

        return scrolledDown && scrolledUp;
    }

    // =====================================================
    // UTILITY
    // =====================================================

    private void sleep(long milliseconds) {

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}