package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductDetailsPage;

public class ProductDetailsTest extends BaseTest {

    ProductDetailsPage productDetails;

    @BeforeMethod
    public void setupProductDetails() {

        driver.get("https://www.demoblaze.com/");

        productDetails = new ProductDetailsPage(driver);

        System.out.println("======================================");
        System.out.println("===== Product Details Test Setup =====");
        System.out.println("======================================");
    }

    // ==========================================
    // TC_PD_001
    // Verify product can be opened
    // ==========================================

    @Test
    public void verifyProductCanBeOpened() {

        productDetails.openFirstProduct();

        Assert.assertTrue(
                productDetails.isProductNameDisplayed(),
                "Product name is not displayed.");

        System.out.println(
                "TC_PD_001 - Product opened successfully");
    }

    // ==========================================
    // TC_PD_002
    // Verify product name
    // ==========================================

    @Test
    public void verifyProductName() {

        productDetails.openFirstProduct();

        String productName =
                productDetails.getProductName();

        System.out.println(
                "Product Name: " + productName);

        Assert.assertFalse(
                productName.isEmpty(),
                "Product name is empty.");

        System.out.println(
                "TC_PD_002 - Product name verified successfully");
    }

    // ==========================================
    // TC_PD_003
    // Verify product price
    // ==========================================

    @Test
    public void verifyProductPrice() {

        productDetails.openFirstProduct();

        String price =
                productDetails.getProductPrice();

        System.out.println(
                "Product Price: " + price);

        Assert.assertFalse(
                price.isEmpty(),
                "Product price is empty.");

        System.out.println(
                "TC_PD_003 - Product price verified successfully");
    }

    // ==========================================
    // TC_PD_004
    // Verify product description
    // ==========================================

    @Test
    public void verifyProductDescription() {

        productDetails.openFirstProduct();

        boolean displayed =
                productDetails.isProductDescriptionDisplayed();

        System.out.println(
                "Description displayed: " + displayed);

        Assert.assertTrue(
                displayed,
                "Product description is not displayed.");

        System.out.println(
                "TC_PD_004 - Product description verified successfully");
    }

    // ==========================================
    // TC_PD_005
    // Verify product image
    // ==========================================

    @Test
    public void verifyProductImage() {

        productDetails.openFirstProduct();

        boolean displayed =
                productDetails.isProductImageDisplayed();

        System.out.println(
                "Product image displayed: " + displayed);

        Assert.assertTrue(
                displayed,
                "Product image is not displayed.");

        System.out.println(
                "TC_PD_005 - Product image verified successfully");
    }

    // ==========================================
    // TC_PD_006
    // Check whether product has multiple images
    // ==========================================

    @Test
    public void verifyMultipleProductImages() {

        productDetails.openFirstProduct();

        int imageCount =
                productDetails.getProductImageCount();

        System.out.println("======================================");
        System.out.println("===== PRODUCT IMAGE CHECK =====");
        System.out.println("======================================");

        System.out.println(
                "Product Image Count: " + imageCount);

        productDetails.printProductImages();

        if (imageCount > 1) {

            System.out.println(
                    "Multiple images available for the product.");

        } else {

            System.out.println(
                    "Only one image available for the product.");
        }

        System.out.println("======================================");

        /*
         * IMPORTANT:
         *
         * This is an observation test.
         * We do not fail the test simply because
         * the product has only one image.
         */

        Assert.assertTrue(
                imageCount >= 1,
                "Product does not have a valid image.");

        System.out.println(
                "TC_PD_006 - Product image availability verified");
    }

    // ==========================================
    // TC_PD_007
    // Verify Add To Cart button
    // ==========================================

    @Test
    public void verifyAddToCartButton() {

        productDetails.openFirstProduct();

        productDetails.clickAddToCart();

        String alertText =
                productDetails.getAddToCartAlertText();

        System.out.println(
                "Alert message: " + alertText);

        Assert.assertTrue(
                alertText.toLowerCase().contains("added"),
                "Add to cart confirmation not displayed.");

        productDetails.acceptAddToCartAlert();

        System.out.println(
                "TC_PD_007 - Add to cart verified successfully");
    }

    // ==========================================
    // TC_PD_008
    // Verify product page title
    // ==========================================

    @Test
    public void verifyProductPageTitle() {

        productDetails.openFirstProduct();

        String title =
                productDetails.getPageTitle();

        System.out.println(
                "Page Title: " + title);

        Assert.assertFalse(
                title.isEmpty(),
                "Page title is empty.");

        System.out.println(
                "TC_PD_008 - Product page title verified successfully");
    }

    // ==========================================
    // TC_PD_009
    // Verify product URL
    // ==========================================

    @Test
    public void verifyProductPageUrl() {

        productDetails.openFirstProduct();

        String url =
                productDetails.getCurrentUrl();

        System.out.println(
                "Product URL: " + url);

        Assert.assertTrue(
                url.contains("prod.html"),
                "Product details URL is not correct.");

        System.out.println(
                "TC_PD_009 - Product URL verified successfully");
    }

    // ==========================================
    // TC_PD_010
    // Verify Home navigation
    // ==========================================

    @Test
    public void verifyHomeNavigation() {

        productDetails.openFirstProduct();

        productDetails.clickHome();

        String url =
                productDetails.getCurrentUrl();

        System.out.println(
                "After Home URL: " + url);

        Assert.assertTrue(
                url.contains("demoblaze.com"),
                "Home navigation failed.");

        System.out.println(
                "TC_PD_010 - Home navigation verified successfully");
    }
 // ==========================================
 // TC_PD_011
 // Verify Product Name is Clickable
 // ==========================================

 @Test
 public void verifyProductNameClickable() {

     System.out.println("======================================");
     System.out.println("TC_PD_011 - Product Name Clickable");
     System.out.println("======================================");

     boolean clickable =
             productDetails.isFirstProductNameClickable();

     System.out.println(
             "Product Name Clickable: " + clickable);

     Assert.assertTrue(
             clickable,
             "Product name is not clickable.");

     productDetails.clickFirstProductName();

     String productName =
             productDetails.getProductName();

     System.out.println(
             "Opened Product: " + productName);

     Assert.assertFalse(
             productName.isEmpty(),
             "Product details page was not opened.");

     System.out.println(
             "TC_PD_011 - Product name clickable verified successfully");

     System.out.println("======================================");
 }
//==========================================
//TC_PD_012
//Verify Product Image is Clickable
//==========================================

 @Test
 public void verifyProductImageClickable() {

	 System.out.println("======================================");
	 System.out.println("TC_PD_012 - Product Image Clickable");
	 System.out.println("======================================");

	 boolean clickable =
			 productDetails.isFirstProductImageClickable();

	 System.out.println(
          "Product Image Clickable: " + clickable);

	 Assert.assertTrue(
          clickable,
          "Product image is not clickable.");

	 productDetails.clickFirstProductImage();

	 String productName =
          productDetails.getProductName();

	 System.out.println(
          "Opened Product: " + productName);

	 Assert.assertFalse(
          productName.isEmpty(),
          "Product details page was not opened after clicking image.");

	 System.out.println(
          "TC_PD_012 - Product image clickable verified successfully");

	 System.out.println("======================================");
 }
}