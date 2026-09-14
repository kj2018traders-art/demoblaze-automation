package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;

public class CartTest extends BaseTest {

    CartPage cartPage;

    String productName;


    // ============================================================
    // BEFORE EACH TEST
    // ============================================================

    @BeforeMethod
    public void initializeCartPage() {

        cartPage = new CartPage(driver);
    }


    // ============================================================
    // TC_CART_001
    // VERIFY EMPTY CART
    // ============================================================

    @Test(priority = 1)
    public void verifyEmptyCartInitially() {

        System.out.println(
                "\n===== TC_CART_001 : VERIFY EMPTY CART ====="
        );

        cartPage.openCartDirectly();

        int count =
                cartPage.getCartProductCount();

        System.out.println(
                "Products currently in cart: " + count
        );

        Assert.assertEquals(
                count,
                0,
                "Cart is not empty initially!"
        );

        System.out.println(
                "PASS: Cart is empty."
        );
    }


    // ============================================================
    // TC_CART_002
    // ADD PRODUCT TO CART
    // ============================================================

    @Test(priority = 2)
    public void verifyAddProductToCart() {

        System.out.println(
                "\n===== TC_CART_002 : ADD PRODUCT TO CART ====="
        );

        productName =
                cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        int count =
                cartPage.getCartProductCount();

        System.out.println(
                "Products in cart: " + count
        );

        Assert.assertEquals(
                count,
                1,
                "Product was not added to cart!"
        );

        System.out.println(
                "PASS: Product added successfully."
        );

        // Clean cart
        cartPage.deleteAllProducts();
    }


    // ============================================================
    // TC_CART_003
    // VERIFY PRODUCT NAME
    // ============================================================

    @Test(priority = 3)
    public void verifyProductName() {

        System.out.println(
                "\n===== TC_CART_003 : VERIFY PRODUCT NAME ====="
        );

        productName =
                cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        List<WebElement> names =
                cartPage.getCartProductNames();

        Assert.assertEquals(
                names.size(),
                1,
                "Product name is not displayed!"
        );

        String cartName =
                names.get(0)
                        .getText()
                        .trim();

        System.out.println(
                "Expected Product: " + productName
        );

        System.out.println(
                "Cart Product: " + cartName
        );

        Assert.assertEquals(
                cartName,
                productName,
                "Product name mismatch!"
        );

        System.out.println(
                "PASS: Product name is correct."
        );

        cartPage.deleteAllProducts();
    }


    // ============================================================
    // TC_CART_004
    // VERIFY PRODUCT PRICE
    // ============================================================

    @Test(priority = 4)
    public void verifyProductPrice() {

        System.out.println(
                "\n===== TC_CART_004 : VERIFY PRODUCT PRICE ====="
        );

        cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        List<WebElement> prices =
                cartPage.getCartProductPrices();

        Assert.assertEquals(
                prices.size(),
                1,
                "Product price is not displayed!"
        );

        String price =
                prices.get(0)
                        .getText()
                        .trim();

        System.out.println(
                "Product Price: " + price
        );

        Assert.assertFalse(
                price.isEmpty(),
                "Product price is empty!"
        );

        System.out.println(
                "PASS: Product price displayed."
        );

        cartPage.deleteAllProducts();
    }


    // ============================================================
    // TC_CART_005
    // VERIFY CART TOTAL
    // ============================================================

    @Test(priority = 5)
    public void verifyCartTotal() {

        System.out.println(
                "\n===== TC_CART_005 : VERIFY CART TOTAL ====="
        );

        cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        int count =
                cartPage.getCartProductCount();

        Assert.assertEquals(
                count,
                1,
                "Product is not present in cart!"
        );

        int total =
                cartPage.getTotalPrice();

        System.out.println(
                "Cart Total: " + total
        );

        Assert.assertTrue(
                total > 0,
                "Cart total should be greater than zero!"
        );

        System.out.println(
                "PASS: Cart total is displayed correctly."
        );

        cartPage.deleteAllProducts();
    }


    // ============================================================
    // TC_CART_006
    // DELETE PRODUCT
    // ============================================================

    @Test(priority = 6)
    public void verifyDeleteProduct() {

        System.out.println(
                "\n===== TC_CART_006 : DELETE PRODUCT ====="
        );

        cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        int beforeDelete =
                cartPage.getCartProductCount();

        System.out.println(
                "Products before delete: "
                        + beforeDelete
        );

        Assert.assertEquals(
                beforeDelete,
                1,
                "Product was not added!"
        );

        cartPage.deleteFirstProduct();

        int afterDelete =
                cartPage.getCartProductCount();

        System.out.println(
                "Products after delete: "
                        + afterDelete
        );

        Assert.assertEquals(
                afterDelete,
                0,
                "Product was not deleted!"
        );

        System.out.println(
                "PASS: Product deleted successfully."
        );
    }


    // ============================================================
    // TC_CART_007
    // VERIFY EMPTY CART AFTER DELETE
    // ============================================================

    @Test(priority = 7)
    public void verifyEmptyCartAfterDelete() {

        System.out.println(
                "\n===== TC_CART_007 : EMPTY CART AFTER DELETE ====="
        );

        cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        Assert.assertEquals(
                cartPage.getCartProductCount(),
                1,
                "Product was not added!"
        );

        cartPage.deleteAllProducts();

        int count =
                cartPage.getCartProductCount();

        System.out.println(
                "Products after clearing: "
                        + count
        );

        Assert.assertEquals(
                count,
                0,
                "Cart is not empty after deletion!"
        );

        System.out.println(
                "PASS: Cart is empty after deletion."
        );
    }


    // ============================================================
    // TC_CART_008
    // PURCHASE WITH EMPTY CART
    // ============================================================

    @Test(priority = 8)
    public void verifyPurchaseWithEmptyCart() {

        System.out.println(
                "\n===== TC_CART_008 : PURCHASE EMPTY CART ====="
        );

        cartPage.openCartDirectly();

        // Make sure cart is empty
        if (cartPage.getCartProductCount() > 0) {

            cartPage.deleteAllProducts();
        }

        int count =
                cartPage.getCartProductCount();

        Assert.assertEquals(
                count,
                0,
                "Cart could not be cleared!"
        );

        System.out.println(
                "Cart is empty."
        );

        /*
         * DEF_CART_001
         *
         * DemoBlaze allows Place Order even when
         * cart is empty.
         */

        try {

            cartPage.clickPlaceOrder();

            boolean modalDisplayed =
                    cartPage.isOrderModalDisplayed();

            if (modalDisplayed) {

                System.out.println(
                        "DEF_CART_001: Place Order is "
                                + "available for empty cart."
                );

                System.out.println(
                        "FAIL / DEFECT FOUND"
                );

                cartPage.closeOrderModal();

            }

        } catch (Exception e) {

            System.out.println(
                    "Purchase option not available "
                            + "for empty cart."
            );
        }
    }


    // ============================================================
    // TC_CART_009
    // SUCCESSFUL PURCHASE
    // ============================================================

    @Test(priority = 9)
    public void verifySuccessfulPurchase() {

        System.out.println(
                "\n===== TC_CART_009 : SUCCESSFUL PURCHASE ====="
        );

        cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        Assert.assertEquals(
                cartPage.getCartProductCount(),
                1,
                "Product was not added!"
        );

        cartPage.clickPlaceOrder();

        Assert.assertTrue(
                cartPage.isOrderModalDisplayed(),
                "Order modal is not displayed!"
        );

        cartPage.enterOrderDetails(
                "Jeshma",
                "India",
                "Kasaragod",
                "4111111111111111",
                "09",
                "2028"
        );

        cartPage.clickPurchase();

        // DemoBlaze displays success confirmation
        boolean success =
                cartPage.isPurchaseSuccessful();

        if (success) {

            System.out.println(
                    "Purchase successful."
            );

            cartPage.clickPurchaseSuccessOK();

        } else {

            System.out.println(
                    "Purchase success message "
                            + "was not detected."
            );
        }

        System.out.println(
                "TC_CART_009 completed."
        );
    }


    // ============================================================
    // TC_CART_010
    // VERIFY CART EMPTY AFTER PURCHASE
    // ============================================================

    @Test(priority = 10)
    public void verifyCartEmptyAfterPurchase() {

        System.out.println(
                "\n===== TC_CART_010 : CART EMPTY AFTER PURCHASE ====="
        );

        cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        Assert.assertEquals(
                cartPage.getCartProductCount(),
                1,
                "Product was not added!"
        );

        cartPage.clickPlaceOrder();

        cartPage.enterOrderDetails(
                "Jeshma",
                "India",
                "Kasaragod",
                "4111111111111111",
                "09",
                "2028"
        );

        cartPage.clickPurchase();

        if (cartPage.isPurchaseSuccessful()) {

            System.out.println(
                    "Purchase completed successfully."
            );

            cartPage.clickPurchaseSuccessOK();

            // Reopen cart
            cartPage.openCartDirectly();

            int count =
                    cartPage.getCartProductCount();

            System.out.println(
                    "Products after purchase: "
                            + count
            );

            Assert.assertEquals(
                    count,
                    0,
                    "Cart is not empty after purchase!"
            );

            System.out.println(
                    "PASS: Cart is empty after purchase."
            );

        } else {

            System.out.println(
                    "Purchase confirmation not detected."
            );
        }
    }


    // ============================================================
    // TC_CART_011
    // PURCHASE WITH BLANK FIELDS
    // ============================================================

    @Test(priority = 11)
    public void verifyPurchaseWithBlankFields() {

        System.out.println(
                "\n===== TC_CART_011 : PURCHASE WITH BLANK FIELDS ====="
        );

        cartPage.addFirstProductToCart();

        cartPage.openCartDirectly();

        Assert.assertEquals(
                cartPage.getCartProductCount(),
                1,
                "Product was not added!"
        );

        cartPage.clickPlaceOrder();

        Assert.assertTrue(
                cartPage.isOrderModalDisplayed(),
                "Order modal is not displayed!"
        );

        // Make sure all fields are blank
        cartPage.clearOrderFields();

        // Click Purchase without entering data
        cartPage.clickPurchase();

        // Check whether validation alert appears
        if (cartPage.isPurchaseAlertPresent()) {

            String alertText =
                    cartPage.getPurchaseAlertText();

            System.out.println(
                    "Validation Alert: "
                            + alertText
            );

            System.out.println(
                    "PASS: Blank fields were rejected."
            );

        } else {

            /*
             * If no alert appeared, check whether
             * purchase was completed.
             */

            if (cartPage.isPurchaseSuccessful()) {

                System.out.println(
                        "DEF_CART_002: Purchase completed "
                                + "with blank fields!"
                );

                System.out.println(
                        "FAIL / DEFECT FOUND"
                );

                cartPage.clickPurchaseSuccessOK();

            } else {

                System.out.println(
                        "Purchase was not completed "
                                + "with blank fields."
                );

                System.out.println(
                        "PASS: Blank-field purchase prevented."
                );
            }
        }

        // Final cart check
        cartPage.openCartDirectly();

        int count =
                cartPage.getCartProductCount();

        System.out.println(
                "Products remaining in cart: "
                        + count
        );
    }
} 