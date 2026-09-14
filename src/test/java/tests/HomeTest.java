package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomeTest extends BaseTest {

    HomePage homePage;


    // ==============================
    // Navigate to Home Page
    // ==============================

    @BeforeMethod
    public void navigateToHome() {

        driver.get("https://www.demoblaze.com/");

        homePage = new HomePage(driver);

        System.out.println("===== Navigated to Home Page =====");
    }


    // ==============================
    //  Verify Home Page
    // ==============================

    @Test
    public void verifyHomePageDisplayed() {

        String title = driver.getTitle();

        Assert.assertEquals(title,"STORE","Home page title is incorrect!");

        System.out.println( " Home page displayed successfully");
    }


    // ==============================
    //  Verify Home Page URL
    // ==============================

    @Test
    public void verifyHomePageURL() {

        String url = driver.getCurrentUrl();

        Assert.assertTrue(url.contains("demoblaze.com"),
                "Home page URL is incorrect!");

        System.out.println("Home page URL verified successfully");
    }


    // ==============================
    // Verify Logo
    // ==============================

    @Test
    public void verifyApplicationLogo() {

        Assert.assertTrue( homePage.isLogoDisplayed(), "DemoBlaze logo is not displayed!");

        System.out.println("Logo displayed successfully");
    }


    // ==============================
    // Verify Home Link
    // ==============================

    @Test
    public void verifyHomeLink() {

        Assert.assertTrue(homePage.isHomeLinkDisplayed(),"Home link is not displayed!");

        System.out.println(" Home link verified successfully");
    }


    // ==============================
    // Verify Contact Link
    // ==============================

    @Test
    public void verifyContactLink() {

        Assert.assertTrue(homePage.isContactLinkDisplayed(),"Contact link is not displayed!");

        System.out.println("Contact link verified successfully");
    }


    // ==============================
    //  Verify About Us Link
    // ==============================

    @Test
    public void verifyAboutUsLink() {

        Assert.assertTrue(homePage.isAboutUsLinkDisplayed(),"About Us link is not displayed!");

        System.out.println("About Us link verified successfully");
    }


    // ==============================
    // Verify Cart Link
    // ==============================

    @Test
    public void verifyCartLink() {

        Assert.assertTrue(homePage.isCartLinkDisplayed(),"Cart link is not displayed!");

        System.out.println(" Cart link verified successfully");
    }


    // ==============================
    // Verify Login Link
    // ==============================

    @Test
    public void verifyLoginLink() {

        Assert.assertTrue(homePage.isLoginLinkDisplayed(), "Login link is not displayed!");

        System.out.println("Login link verified successfully");
    }


    // ==============================
    //  Verify Sign Up Link
    // ==============================

    @Test
    public void verifySignupLink() {

        Assert.assertTrue(homePage.isSignupLinkDisplayed(),"Sign Up link is not displayed!");

        System.out.println("Sign Up link verified successfully");
    }


    // ==============================
    //  Verify Categories
    // ==============================

    @Test
    public void verifyCategoriesSection() {

        Assert.assertTrue(homePage.areCategoriesDisplayed(),"Categories are not displayed!");

        System.out.println("Categories verified successfully");
    }


    // ==============================
    // Verify Phones
    // ==============================

    @Test
    public void verifyPhonesCategory() {

        Assert.assertTrue(homePage.isPhonesCategoryDisplayed(),"Phones category is not displayed!");

        System.out.println("Phones category verified successfully");
    }


    // ==============================
    //  Verify Laptops
    // ==============================

    @Test
    public void verifyLaptopsCategory() {

        Assert.assertTrue(
                homePage.isLaptopsCategoryDisplayed(),
                "Laptops category is not displayed!");

        System.out.println(" Laptops category verified successfully");
    }


    // ==============================
    // Verify Monitors
    // ==============================

    @Test
    public void verifyMonitorsCategory() {

        Assert.assertTrue(
                homePage.isMonitorsCategoryDisplayed(),
                "Monitors category is not displayed!");

        System.out.println("Monitors category verified successfully");
    }


    // ==============================
    // Verify Products
    // ==============================

    @Test
    public void verifyProductsDisplayed() {

        int productCount = homePage.getProductCount();

        Assert.assertTrue( productCount > 0,
                "No products are displayed!");

        System.out.println("Products displayed: " + productCount);
    }


    // ==============================
    // Verify Product Names
    // ==============================

    @Test
    public void verifyProductNamesDisplayed() {

        int productNameCount =homePage.getProductNameCount();

        Assert.assertTrue(
                productNameCount > 0,
                "Product names are not displayed!");

        System.out.println(" Product names displayed: "+ productNameCount);
    }


    // ==============================
    // Verify Product Prices
    // ==============================

    @Test
    public void verifyProductPricesDisplayed() {

        int priceCount = homePage.getProductPriceCount();

        Assert.assertTrue(
                priceCount > 0,
                "Product prices are not displayed!");

        System.out.println(" Product prices displayed: "+ priceCount);
    }


    // ==============================
    // Verify Product Images
    // ==============================

    @Test
    public void verifyProductImagesDisplayed() {

        int imageCount = homePage.getProductImageCount();

        Assert.assertTrue(
                imageCount > 0, "Product images are not displayed!" );

        System.out.println( "Product images displayed: " + imageCount );
    }


    // ==============================
    //  Verify Next Button
    // ==============================

    @Test
    public void verifyNextButton() {

        Assert.assertTrue(
                homePage.isNextButtonDisplayed(),
                "Next button is not displayed!");

        System.out.println("Next button verified successfully" );
    }


    // ==============================
    //  Verify Previous Button
    // ==============================

    @Test
    public void verifyPreviousButton() {

        Assert.assertTrue(
                homePage.isPreviousButtonDisplayed(),
                "Previous button is not displayed!");

        System.out.println( "TPrevious button verified successfully");
    }


    // ==============================
    //  Verify Product Can Be Opened
    // ==============================

    @Test
    public void verifyProductCanBeOpened() {

        String productName = homePage.openFirstProduct();

        Assert.assertFalse(
                productName.isEmpty(),
                "Product name is empty!");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("prod.html"),
                "Product details page was not opened!");

        System.out.println( " Product opened successfully: " + productName );
    }
    @Test
    public void verifySliderDisplayed() {

        Assert.assertTrue(
                homePage.isSliderDisplayed(),
                "Slider is not displayed!");

        System.out.println("Slider displayed successfully");
    }


    @Test
    public void verifySliderImagesDisplayed() {

        int imageCount = homePage.getSliderImageCount();

        Assert.assertTrue(
                imageCount > 0,
                "Slider images are not displayed!");

        System.out.println( "Slider images displayed: " + imageCount);
    }


    @Test
    public void verifySliderNextButton() {

        Assert.assertTrue(
                homePage.isSliderNextButtonDisplayed(),
                "Slider Next button is not displayed!" );

        System.out.println(" Slider Next button verified successfully" );
    }


    @Test
    public void verifySliderPreviousButton() {

        Assert.assertTrue(
                homePage.isSliderPreviousButtonDisplayed(),
                "Slider Previous button is not displayed!" );

        System.out.println( " Slider Previous button verified successfully" );
    }


    @Test
    public void verifySliderNextFunctionality() {

        Assert.assertTrue(
                homePage.isSliderDisplayed(),
                "Slider is not displayed!" );

        homePage.clickSliderNext();

        System.out.println(" Slider Next button clicked successfully");
    }


    @Test
    public void verifySliderPreviousFunctionality() {

        Assert.assertTrue(
                homePage.isSliderDisplayed(),
                "Slider is not displayed!");

        homePage.clickSliderPrevious();

        System.out.println( "Slider Previous button clicked successfully");
    }
    @Test
    public void verifyFooterDisplayed() {

        Assert.assertTrue(
                homePage.isFooterDisplayed(),
                "Footer is not displayed!");

        System.out.println("Footer displayed successfully");
    }


    @Test
    public void verifyFooterAboutUs() {

        Assert.assertTrue(
                homePage.isFooterAboutUsDisplayed(),
                "About Us section is not displayed!");

        System.out.println(" Footer About Us verified successfully");
    }


    @Test
    public void verifyFooterGetInTouch() {

        Assert.assertTrue(
                homePage.isFooterGetInTouchDisplayed(),
                "Get in Touch section is not displayed!" );

        System.out.println("Footer Get in Touch verified successfully");
    }


    @Test
    public void verifyFooterAddress() {

        Assert.assertTrue(
                homePage.isFooterAddressDisplayed(),
                "Footer Address is not displayed!");

        System.out.println(" Footer Address verified successfully");
    }


    @Test
    public void verifyFooterPhone() {

        Assert.assertTrue(
                homePage.isFooterPhoneDisplayed(),
                "Footer Phone is not displayed!");

        System.out.println(" Footer Phone verified successfully");
    }


    @Test
    public void verifyFooterEmail() {

        Assert.assertTrue(
                homePage.isFooterEmailDisplayed(),
                "Footer Email is not displayed!");

        System.out.println("Footer Email verified successfully");
    }


    @Test
    public void verifyFooterCopyright() {

        Assert.assertTrue(
                homePage.isFooterCopyrightDisplayed(),
                "Footer Copyright is not displayed!");

        System.out.println("Footer Copyright verified successfully");
    }
 // =========================================================
 // HOVER - HOME PAGE NAVIGATION
 // =========================================================

 @Test
 public void verifyHomeLinkHover() {

     Assert.assertTrue(
             homePage.isHomeLinkDisplayed(),
             "Home link is not displayed!"
     );

     homePage.hoverOverHomeLink();

     System.out.println(
             "HOME - Home link hover performed successfully"
     );
 }


 @Test
 public void verifyContactLinkHover() {

     Assert.assertTrue(
             homePage.isContactLinkDisplayed(),
             "Contact link is not displayed!"
     );

     homePage.hoverOverContactLink();

     System.out.println(
             "HOME - Contact link hover performed successfully"
     );
 }


 @Test
 public void verifyAboutUsLinkHover() {

     Assert.assertTrue(
             homePage.isAboutUsLinkDisplayed(),
             "About Us link is not displayed!"
     );

     homePage.hoverOverAboutUsLink();

     System.out.println(
             "HOME - About Us link hover performed successfully"
     );
 }


 @Test
 public void verifyCartLinkHover() {

     Assert.assertTrue(
             homePage.isCartLinkDisplayed(),
             "Cart link is not displayed!"
     );

     homePage.hoverOverCartLink();

     System.out.println(
             "HOME - Cart link hover performed successfully"
     );
 }


 @Test
 public void verifyLoginLinkHover() {

     Assert.assertTrue(
             homePage.isLoginLinkDisplayed(),
             "Login link is not displayed!"
     );

     homePage.hoverOverLoginLink();

     System.out.println(
             "HOME - Login link hover performed successfully"
     );
 }


 @Test
 public void verifySignupLinkHover() {

     Assert.assertTrue(
             homePage.isSignupLinkDisplayed(),
             "Sign Up link is not displayed!"
     );

     homePage.hoverOverSignupLink();

     System.out.println(
             "HOME - Sign Up link hover performed successfully"
     );
 }


 // =========================================================
 // HOVER - CATEGORIES
 // =========================================================

 @Test
 public void verifyPhonesCategoryHover() {

     Assert.assertTrue(
             homePage.isPhonesCategoryDisplayed(),
             "Phones category is not displayed!"
     );

     homePage.hoverOverPhonesCategory();

     System.out.println(
             "HOME - Phones category hover performed successfully"
     );
 }


 @Test
 public void verifyLaptopsCategoryHover() {

     Assert.assertTrue(
             homePage.isLaptopsCategoryDisplayed(),
             "Laptops category is not displayed!"
     );

     homePage.hoverOverLaptopsCategory();

     System.out.println(
             "HOME - Laptops category hover performed successfully"
     );
 }


 @Test
 public void verifyMonitorsCategoryHover() {

     Assert.assertTrue(
             homePage.isMonitorsCategoryDisplayed(),
             "Monitors category is not displayed!"
     );

     homePage.hoverOverMonitorsCategory();

     System.out.println(
             "HOME - Monitors category hover performed successfully"
     );
 }


 // =========================================================
 // HOVER - PRODUCTS
 // =========================================================

 @Test
 public void verifyFirstProductHover() {

     Assert.assertTrue(
             homePage.getProductCount() > 0,
             "No products are displayed!"
     );

     homePage.hoverOverFirstProduct();

     System.out.println(
             "HOME - First product hover performed successfully"
     );
 }


 @Test
 public void verifyFirstProductImageHover() {

     Assert.assertTrue(
             homePage.getProductImageCount() > 0,
             "Product images are not displayed!"
     );

     homePage.hoverOverFirstProductImage();

     System.out.println(
             "HOME - First product image hover performed successfully"
     );
 }


 // =========================================================
 // HOVER - SLIDER
 // =========================================================

 @Test
 public void verifySliderHover() {

     Assert.assertTrue(
             homePage.isSliderDisplayed(),
             "Slider is not displayed!"
     );

     homePage.hoverOverSlider();

     System.out.println(
             "HOME - Slider hover performed successfully"
     );
 }


 @Test
 public void verifySliderNextButtonHover() {

     Assert.assertTrue(
             homePage.isSliderNextButtonDisplayed(),
             "Slider Next button is not displayed!"
     );

     homePage.hoverOverSliderNextButton();

     System.out.println(
             "HOME - Slider Next button hover performed successfully"
     );
 }


 @Test
 public void verifySliderPreviousButtonHover() {

     Assert.assertTrue(
             homePage.isSliderPreviousButtonDisplayed(),
             "Slider Previous button is not displayed!"
     );

     homePage.hoverOverSliderPreviousButton();

     System.out.println(
             "HOME - Slider Previous button hover performed successfully"
     );
 }
}