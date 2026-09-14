package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.ProductCategoryPage;

public class ProductCategoryTest extends BaseTest {

    ProductCategoryPage productPage;

    // =====================================================
    // TC_CAT_001 - Verify Phones Category
    // =====================================================

    @Test(priority = 1)
    public void verifyPhonesCategory() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        productPage.clickPhonesCategory();

        int count =
                productPage.getProductCount();

        Assert.assertTrue(
                count > 0,
                "Phones category contains no products!"
        );

        System.out.println(
                "TC_CAT_001 - Phones category verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_002 - Verify Laptops Category
    // =====================================================

    @Test(priority = 2)
    public void verifyLaptopsCategory() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        productPage.clickLaptopsCategory();

        int count =
                productPage.getProductCount();

        Assert.assertTrue(
                count > 0,
                "Laptops category contains no products!"
        );

        System.out.println(
                "TC_CAT_002 - Laptops category verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_003 - Verify Monitors Category
    // =====================================================

    @Test(priority = 3)
    public void verifyMonitorsCategory() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        productPage.clickMonitorsCategory();

        int count =
                productPage.getProductCount();

        Assert.assertTrue(
                count > 0,
                "Monitors category contains no products!"
        );

        System.out.println(
                "TC_CAT_003 - Monitors category verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_004 - Verify Phones Products
    // =====================================================

    @Test(priority = 4)
    public void verifyPhonesProducts() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        productPage.clickPhonesCategory();

        int count =
                productPage.getProductCount();

        Assert.assertTrue(
                count > 0,
                "No Phones products displayed!"
        );

        productPage.printAllProductNames();

        System.out.println(
                "TC_CAT_004 - Phones products displayed: "
                        + count
        );
    }

    // =====================================================
    // TC_CAT_005 - Verify Laptop Products
    // =====================================================

    @Test(priority = 5)
    public void verifyLaptopProducts() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        productPage.clickLaptopsCategory();

        int count =
                productPage.getProductCount();

        Assert.assertTrue(
                count > 0,
                "No Laptop products displayed!"
        );

        productPage.printAllProductNames();

        System.out.println(
                "TC_CAT_005 - Laptop products displayed: "
                        + count
        );
    }

    // =====================================================
    // TC_CAT_006 - Verify Monitor Products
    // =====================================================

    @Test(priority = 6)
    public void verifyMonitorProducts() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        productPage.clickMonitorsCategory();

        int count =
                productPage.getProductCount();

        Assert.assertTrue(
                count > 0,
                "No Monitor products displayed!"
        );

        productPage.printAllProductNames();

        System.out.println(
                "TC_CAT_006 - Monitor products displayed: "
                        + count
        );
    }

    // =====================================================
    // TC_CAT_007 - Verify Product Names
    // =====================================================

    @Test(priority = 7)
    public void verifyProductNames() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        boolean result =
                productPage.areProductNamesDisplayed();

        Assert.assertTrue(
                result,
                "Product names are not displayed!"
        );

        System.out.println(
                "TC_CAT_007 - Product names verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_008 - Verify Product Prices
    // =====================================================

    @Test(priority = 8)
    public void verifyProductPrices() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        boolean result =
                productPage.areProductPricesDisplayed();

        Assert.assertTrue(
                result,
                "Product prices are not displayed!"
        );

        productPage.printAllProductPrices();

        System.out.println(
                "TC_CAT_008 - Product prices verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_009 - Verify Product Images
    // =====================================================

    @Test(priority = 9)
    public void verifyProductImages() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        boolean result =
                productPage.areProductImagesDisplayed();

        Assert.assertTrue(
                result,
                "Product images are not displayed!"
        );

        System.out.println(
                "TC_CAT_009 - Product images verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_010 - Verify Product Name Count
    // =====================================================

    @Test(priority = 10)
    public void verifyProductNameCount() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        int productCount =
                productPage.getProductCount();

        int nameCount =
                productPage.getProductNameCount();

        System.out.println(
                "Product count = "
                        + productCount
        );

        System.out.println(
                "Product name count = "
                        + nameCount
        );

        Assert.assertEquals(
                nameCount,
                productCount,
                "Product name count does not match product count!"
        );

        System.out.println(
                "TC_CAT_010 - Product name count verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_011 - Verify Product Price Count
    // =====================================================

    @Test(priority = 11)
    public void verifyProductPriceCount() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        int productCount =
                productPage.getProductCount();

        int priceCount =
                productPage.getProductPriceCount();

        System.out.println(
                "Product count = "
                        + productCount
        );

        System.out.println(
                "Product price count = "
                        + priceCount
        );

        Assert.assertEquals(
                priceCount,
                productCount,
                "Product price count does not match product count!"
        );

        System.out.println(
                "TC_CAT_011 - Product price count verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_012 - Verify Product Image Count
    // =====================================================

    @Test(priority = 12)
    public void verifyProductImageCount() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        int productCount =
                productPage.getProductCount();

        int imageCount =
                productPage.getProductImageCount();

        System.out.println(
                "Product count = "
                        + productCount
        );

        System.out.println(
                "Product image count = "
                        + imageCount
        );

        Assert.assertEquals(
                imageCount,
                productCount,
                "Product image count does not match product count!"
        );

        System.out.println(
                "TC_CAT_012 - Product image count verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_013 - Verify Category Switching
    // =====================================================

    @Test(priority = 13)
    public void verifyCategorySwitching() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        productPage.clickPhonesCategory();

        int phonesCount =
                productPage.getProductCount();

        productPage.clickLaptopsCategory();

        int laptopsCount =
                productPage.getProductCount();

        productPage.clickMonitorsCategory();

        int monitorsCount =
                productPage.getProductCount();

        System.out.println(
                "Phones product count: "
                        + phonesCount
        );

        System.out.println(
                "Laptops product count: "
                        + laptopsCount
        );

        System.out.println(
                "Monitors product count: "
                        + monitorsCount
        );

        Assert.assertTrue(
                phonesCount > 0,
                "Phones category did not load!"
        );

        Assert.assertTrue(
                laptopsCount > 0,
                "Laptops category did not load!"
        );

        Assert.assertTrue(
                monitorsCount > 0,
                "Monitors category did not load!"
        );

        System.out.println(
                "TC_CAT_013 - Category switching verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_014 - Open First Product
    // =====================================================

    @Test(priority = 14)
    public void verifyOpenFirstProduct() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        String productName =
                productPage.openFirstProduct();

        Assert.assertFalse(
                productName.isEmpty(),
                "Product name is empty!"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("prod.html"),
                "Product page was not opened!"
        );

        System.out.println(
                "TC_CAT_014 - Product opened successfully: "
                        + productName
        );
    }

    // =====================================================
    // TC_CAT_015 - Selected Category Highlight
    // =====================================================

    @Test(priority = 15)
    public void verifySelectedCategoryHighlighted() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        boolean highlighted =
                productPage
                        .verifySelectedCategoryHighlighted("Phones");

        /*
         * This is intentionally an assertion for the defect.
         * Demoblaze does not visually highlight the selected
         * category.
         */

        Assert.assertTrue(
                highlighted,
                "DEF_CAT_004: Selected product category is not highlighted!"
        );

        System.out.println(
                "TC_CAT_015 - Selected category highlighted successfully"
        );
    }

    // =====================================================
    // DEF_CAT_001 - Product Card Hover Effect
    // =====================================================

    @Test(priority = 16)
    public void verifyProductCardHoverEffect() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        boolean hoverEffect =
                productPage.verifyProductCardHoverEffect();

        System.out.println(
                "Hover Effect Available: "
                        + hoverEffect
        );

        Assert.assertTrue(
                hoverEffect,
                "DEF_CAT_001: Product cards have no hover effect!"
        );
    }

    // =====================================================
    // DEF_CAT_002 - Search Functionality
    // =====================================================

    @Test(priority = 17)
    public void verifySearchFunctionality() {

        productPage =
                new ProductCategoryPage(driver);

        productPage.goToHomePage();

        boolean searchAvailable =
                productPage.isSearchFunctionalityAvailable();

        System.out.println(
                "Search Available: "
                        + searchAvailable
        );

        Assert.assertTrue(
                searchAvailable,
                "DEF_CAT_002: Search functionality is not available!"
        );
    }

    // =====================================================
    // TC_CAT_018 - Next Pagination
    // =====================================================

    @Test(priority = 18)
    public void verifyNextNavigation() {

        productPage =
                new ProductCategoryPage(driver);

        boolean result =
                productPage.verifyNextPagination();

        Assert.assertTrue(
                result,
                "Next button did not change the product listing!"
        );

        System.out.println(
                "TC_CAT_018 - Next pagination verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_019 - Previous Pagination
    // =====================================================

    @Test(priority = 19)
    public void verifyPreviousNavigation() {

        productPage =
                new ProductCategoryPage(driver);

        boolean result =
                productPage.verifyPreviousPagination();

        Assert.assertTrue(
                result,
                "Previous button did not return to the previous listing!"
        );

        System.out.println(
                "TC_CAT_019 - Previous pagination verified successfully"
        );
    }

    // =====================================================
    // TC_CAT_020 - Mouse Scrolling
    // =====================================================

    @Test(priority = 20)
    public void verifyMouseScrolling() {

        productPage =
                new ProductCategoryPage(driver);

        boolean result =
                productPage.verifyScrollingDownAndUp();

        Assert.assertTrue(
                result,
                "Mouse scrolling down/up is not working!"
        );

        System.out.println(
                "TC_CAT_020 - Mouse scrolling verified successfully"
        );
    }
}