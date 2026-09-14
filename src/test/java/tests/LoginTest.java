package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ExcelUtils;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    WebDriverWait wait;

    // =========================================================
    // REGISTER CUSTOMER BEFORE LOGIN
    // =========================================================

    @BeforeClass
    public void registerCustomerBeforeLogin() {

        String username = "customerOne_001";
        String password = "Customer@123";

        driver.get("https://www.demoblaze.com/");

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        System.out.println(
                "===== Registering Customer Before Login ====="
        );

        driver.findElement(By.id("signin2")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("signInModal")
                )
        );

        driver.findElement(
                By.id("sign-username")
        ).clear();

        driver.findElement(
                By.id("sign-username")
        ).sendKeys(username);

        driver.findElement(
                By.id("sign-password")
        ).clear();

        driver.findElement(
                By.id("sign-password")
        ).sendKeys(password);

        driver.findElement(
                By.xpath("//button[contains(text(),'Sign up')]")
        ).click();

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println(
                "Signup Alert: " + alertMessage
        );

        alert.accept();

        System.out.println(
                "===== Customer Registration Completed ====="
        );
    }

    // =========================================================
    // NAVIGATE TO HOME
    // =========================================================

    @BeforeMethod
    public void navigateToHome() {

        driver.get("https://www.demoblaze.com/");

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        System.out.println(
                "===== Navigated to Home Page ====="
        );
    }

    // =========================================================
    // TC_LG_001
    // VERIFY LOGIN LINK
    // =========================================================

    @Test(priority = 1)
    public void verifyLoginLink() {

        loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginLinkDisplayed(),
                "Login link is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isLoginLinkEnabled(),
                "Login link is not enabled!"
        );

        System.out.println(
                "TC_LG_001 - Login link verified successfully"
        );
    }

    // =========================================================
    // TC_LG_002
    // VERIFY LOGIN POPUP
    // =========================================================

    @Test(priority = 2)
    public void verifyLoginPopup() {

        loginPage = new LoginPage(driver);

        loginPage.clickLoginLink();

        Assert.assertTrue(
                loginPage.isLoginPopupDisplayed(),
                "Login popup is not displayed!"
        );

        System.out.println(
                "TC_LG_002 - Login popup displayed successfully"
        );
    }

    // =========================================================
    // TC_LG_003
    // VERIFY LOGIN FIELDS
    // =========================================================

    @Test(priority = 3)
    public void verifyLoginFields() {

        loginPage = new LoginPage(driver);

        loginPage.clickLoginLink();

        Assert.assertTrue(
                loginPage.isUsernameDisplayed(),
                "Username field is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isPasswordDisplayed(),
                "Password field is not displayed!"
        );

        System.out.println(
                "TC_LG_003 - Login fields verified successfully"
        );
    }

    // =========================================================
    // TC_LG_004
    // VERIFY LOGIN BUTTONS
    // =========================================================

    @Test(priority = 4)
    public void verifyLoginButtons() {

        loginPage = new LoginPage(driver);

        loginPage.clickLoginLink();

        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Login button is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isLoginButtonEnabled(),
                "Login button is not enabled!"
        );

        Assert.assertTrue(
                loginPage.isCloseButtonDisplayed(),
                "Close button is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isCloseButtonEnabled(),
                "Close button is not enabled!"
        );

        System.out.println(
                "TC_LG_004 - Login buttons verified successfully"
        );
    }

    // =========================================================
    // TC_LG_005
    // VERIFY PASSWORD MASKING
    // =========================================================

    @Test(priority = 5)
    public void verifyPasswordIsMasked() {

        loginPage = new LoginPage(driver);

        loginPage.clickLoginLink();

        String fieldType =
                loginPage.getPasswordFieldType();

        Assert.assertEquals(
                fieldType,
                "password",
                "Password field is not masked!"
        );

        System.out.println(
                "TC_LG_005 - Password field is masked successfully"
        );
    }

    // =========================================================
    // VALID LOGIN DATA FROM EXCEL
    // =========================================================

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData()
            throws IOException {

        String path =
                System.getProperty("user.dir")
                + "/src/test/resources/testdata/CustomerData.xlsx";

        ExcelUtils.loadExcel(
                path,
                "Sheet1"
        );

        int rows =
                ExcelUtils.getRowCount();

        Object[][] tempData =
                new Object[rows][2];

        int index = 0;

        for (int i = 1; i < rows; i++) {

            String username =
                    ExcelUtils.getCellData(i, 0);

            String password =
                    ExcelUtils.getCellData(i, 1);

            String type =
                    ExcelUtils.getCellData(i, 2);

            if (type.equalsIgnoreCase("Valid")) {

                tempData[index][0] = username;
                tempData[index][1] = password;

                index++;
            }
        }

        ExcelUtils.closeExcel();

        Object[][] data =
                new Object[index][2];

        for (int i = 0; i < index; i++) {

            data[i][0] = tempData[i][0];
            data[i][1] = tempData[i][1];
        }

        return data;
    }

    // =========================================================
    // TC_LG_006
    // VALID SIGN IN
    // =========================================================

    @Test(
            priority = 6,
            dataProvider = "validLoginData"
    )
    public void verifyValidSignIn(
            String username,
            String password) {

        loginPage = new LoginPage(driver);

        System.out.println(
                "======================================"
        );

        System.out.println(
                "===== Starting Sign In ====="
        );

        System.out.println(
                "Username: " + username
        );

        loginPage.clickLoginLink();

        Assert.assertTrue(
                loginPage.isLoginPopupDisplayed(),
                "Login popup is not displayed!"
        );

        loginPage.enterUsername(username);

        loginPage.enterPassword(password);

        loginPage.clickLoginButton();

        Assert.assertTrue(
                loginPage.isWelcomeMessageDisplayed(),
                "Welcome message is not displayed!"
        );

        String welcomeMessage =
                loginPage.getWelcomeMessage();

        System.out.println(
                "Welcome Message: " + welcomeMessage
        );

        Assert.assertTrue(
                welcomeMessage.contains(username),
                "Welcome message does not contain username!"
        );

        Assert.assertTrue(
                loginPage.isLogoutDisplayed(),
                "Logout button is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isLogoutEnabled(),
                "Logout button is not enabled!"
        );

        System.out.println(
                "Sign In successful for: " + username
        );

        System.out.println(
                "Welcome message verified successfully"
        );

        System.out.println(
                "Logout button verified successfully"
        );

        System.out.println(
                "======================================"
        );
    }

    // =========================================================
    // INVALID LOGIN DATA FROM EXCEL
    // =========================================================

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData()
            throws IOException {

        String path =
                System.getProperty("user.dir")
                + "/src/test/resources/testdata/CustomerData.xlsx";

        ExcelUtils.loadExcel(
                path,
                "Sheet1"
        );

        int rows =
                ExcelUtils.getRowCount();

        Object[][] tempData =
                new Object[rows][3];

        int index = 0;

        for (int i = 1; i < rows; i++) {

            String username =
                    ExcelUtils.getCellData(i, 0);

            String password =
                    ExcelUtils.getCellData(i, 1);

            String type =
                    ExcelUtils.getCellData(i, 2);

            if (!type.equalsIgnoreCase("Valid")) {

                tempData[index][0] = username;
                tempData[index][1] = password;
                tempData[index][2] = type;

                index++;
            }
        }

        ExcelUtils.closeExcel();

        Object[][] data =
                new Object[index][3];

        for (int i = 0; i < index; i++) {

            data[i][0] = tempData[i][0];
            data[i][1] = tempData[i][1];
            data[i][2] = tempData[i][2];
        }

        return data;
    }

    // =========================================================
    // TC_LG_007
    // INVALID LOGIN
    // =========================================================

    @Test(
            priority = 7,
            dataProvider = "invalidLoginData"
    )
    public void verifyInvalidSignIn(
            String username,
            String password,
            String testType) {

        loginPage = new LoginPage(driver);

        System.out.println(
                "======================================"
        );

        System.out.println(
                "Test Type: " + testType
        );

        System.out.println(
                "Username: " + username
        );

        System.out.println(
                "Password: " + password
        );

        loginPage.clickLoginLink();

        Assert.assertTrue(
                loginPage.isLoginPopupDisplayed(),
                "Login popup is not displayed!"
        );

        // Enter only when data is available
        if (username != null && !username.isEmpty()) {

            loginPage.enterUsername(username);
        }

        if (password != null && !password.isEmpty()) {

            loginPage.enterPassword(password);
        }

        loginPage.clickLoginButton();

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert alert =
                driver.switchTo().alert();

        String alertMessage =
                alert.getText();

        System.out.println(
                "Login Alert: " + alertMessage
        );

        Assert.assertFalse(
                alertMessage.isEmpty(),
                "Login alert message is empty!"
        );

        alert.accept();

        System.out.println(
                testType + " handled successfully"
        );

        System.out.println(
                "======================================"
        );
    }

    // =========================================================
    // TC_LG_008
    // SIGN OUT
    // =========================================================

    @Test(priority = 8)
    public void verifySignOut() throws IOException {

        loginPage = new LoginPage(driver);

        String path =
                System.getProperty("user.dir")
                + "/src/test/resources/testdata/CustomerData.xlsx";

        ExcelUtils.loadExcel(
                path,
                "Sheet1"
        );

        String username =
                ExcelUtils.getCellData(1, 0);

        String password =
                ExcelUtils.getCellData(1, 1);

        ExcelUtils.closeExcel();

        System.out.println(
                "======================================"
        );

        System.out.println(
                "===== Starting Sign In ====="
        );

        System.out.println(
                "Username: " + username
        );

        loginPage.login(
                username,
                password
        );

        Assert.assertTrue(
                loginPage.isWelcomeMessageDisplayed(),
                "Welcome message is not displayed!"
        );

        String welcomeMessage =
                loginPage.getWelcomeMessage();

        System.out.println(
                "Welcome Message: " + welcomeMessage
        );

        Assert.assertTrue(
                welcomeMessage.contains(username),
                "Welcome message does not contain username!"
        );

        Assert.assertTrue(
                loginPage.isLogoutDisplayed(),
                "Logout button is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isLogoutEnabled(),
                "Logout button is not enabled!"
        );

        // Click Logout
        loginPage.clickLogout();

        // Verify logged-out state
        Assert.assertTrue(
                loginPage.isLoginLinkDisplayed(),
                "Login link is not displayed after Sign Out!"
        );

        Assert.assertTrue(
                loginPage.isLoginLinkEnabled(),
                "Login link is not enabled after Sign Out!"
        );

        System.out.println(
                "Sign Out successful"
        );

        System.out.println(
                "User returned to logged-out state"
        );

        System.out.println(
                "======================================"
        );
    }

    // =========================================================
    // TC_LG_009
    // HOME PAGE TITLE
    // =========================================================

    @Test(priority = 9)
    public void verifyHomePageTitle() {

        String title = driver.getTitle();

        Assert.assertEquals(
                title,
                "STORE",
                "Home page title is incorrect!"
        );

        System.out.println(
                "TC_LG_009 - Home page title verified successfully"
        );
    }

    // =========================================================
    // TC_LG_010
    // HOME PAGE URL
    // =========================================================

    @Test(priority = 10)
    public void verifyHomePageURL() {

        String currentURL =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("demoblaze.com"),
                "User is not on Demoblaze home page!"
        );

        System.out.println(
                "TC_LG_010 - Home page URL verified successfully"
        );
    }

    // =========================================================
    // TC_LG_011
    // HOME NAVIGATION
    // =========================================================

    @Test(priority = 11)
    public void verifyHomeNavigation() {

        loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isHomeLinkDisplayed(),
                "Home link is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isHomeLinkEnabled(),
                "Home link is not enabled!"
        );

        System.out.println(
                "TC_LG_011 - Home navigation verified successfully"
        );
    }

    // =========================================================
    // TC_LG_012
    // SIGN UP LINK
    // =========================================================

    @Test(priority = 12)
    public void verifySignUpLink() {

        loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isSignUpLinkDisplayed(),
                "Sign Up link is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isSignUpLinkEnabled(),
                "Sign Up link is not enabled!"
        );

        System.out.println(
                "TC_LG_012 - Sign Up link verified successfully"
        );
    }

    // =========================================================
    // TC_LG_013
    // SIGN UP POPUP
    // =========================================================

    @Test(priority = 13)
    public void verifySignUpPopup() {

        loginPage = new LoginPage(driver);

        loginPage.clickSignUpLink();

        Assert.assertTrue(
                loginPage.isSignUpPopupDisplayed(),
                "Sign Up popup is not displayed!"
        );

        System.out.println(
                "TC_LG_013 - Sign Up popup verified successfully"
        );
    }

    // =========================================================
    // TC_LG_014
    // SIGN UP FIELDS
    // =========================================================

    @Test(priority = 14)
    public void verifySignUpFields() {

        loginPage = new LoginPage(driver);

        loginPage.clickSignUpLink();

        Assert.assertTrue(
                loginPage.isSignUpUsernameDisplayed(),
                "Sign Up username field is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isSignUpPasswordDisplayed(),
                "Sign Up password field is not displayed!"
        );

        System.out.println(
                "TC_LG_014 - Sign Up fields verified successfully"
        );
    }

    // =========================================================
    // TC_LG_015
    // SIGN UP CLOSE BUTTON
    // =========================================================

    @Test(priority = 15)
    public void verifySignUpCloseButton() {

        loginPage = new LoginPage(driver);

        loginPage.clickSignUpLink();

        Assert.assertTrue(
                loginPage.isSignUpCloseButtonDisplayed(),
                "Sign Up close button is not displayed!"
        );

        Assert.assertTrue(
                loginPage.isSignUpCloseButtonEnabled(),
                "Sign Up close button is not enabled!"
        );

        System.out.println(
                "TC_LG_015 - Sign Up close button verified successfully"
        );
    }

    // =========================================================
    // TC_LG_016
    // SIGN IN POPUP CLOSE
    // =========================================================

    @Test(priority = 16)
    public void verifyLoginPopupClose() {

        loginPage = new LoginPage(driver);

        loginPage.clickLoginLink();

        Assert.assertTrue(
                loginPage.isLoginPopupDisplayed(),
                "Login popup is not displayed!"
        );

        loginPage.clickLoginCloseButton();

        Assert.assertFalse(
                loginPage.isLoginPopupDisplayed(),
                "Login popup is still displayed after closing!"
        );

        System.out.println(
                "TC_LG_016 - Login popup close verified successfully"
        );
    }

    // =========================================================
    // TC_LG_017
    // SIGN OUT STATE
    // =========================================================

    @Test(priority = 17)
    public void verifySignOutState() throws IOException {

        loginPage = new LoginPage(driver);

        String path =
                System.getProperty("user.dir")
                + "/src/test/resources/testdata/CustomerData.xlsx";

        ExcelUtils.loadExcel(
                path,
                "Sheet1"
        );

        String username =
                ExcelUtils.getCellData(1, 0);

        String password =
                ExcelUtils.getCellData(1, 1);

        ExcelUtils.closeExcel();

        loginPage.login(
                username,
                password
        );

        Assert.assertTrue(
                loginPage.isLogoutDisplayed(),
                "Logout button is not displayed after login!"
        );

        loginPage.clickLogout();

        Assert.assertTrue(
                loginPage.isLoginLinkDisplayed(),
                "Login link is not displayed after logout!"
        );

        Assert.assertFalse(
                loginPage.isLogoutDisplayed(),
                "Logout button is still displayed after logout!"
        );

        System.out.println(
                "TC_LG_017 - Logged-out state verified successfully"
        );
    }

    // =========================================================
    // TC_LG_018
    // LOGOUT SUCCESS MESSAGE - BUG / ENHANCEMENT
    // =========================================================

    @Test(priority = 18)
    public void verifyLogoutSuccessMessage() throws IOException {

        loginPage = new LoginPage(driver);

        String path =
                System.getProperty("user.dir")
                + "/src/test/resources/testdata/CustomerData.xlsx";

        ExcelUtils.loadExcel(path, "Sheet1");

        String username =
                ExcelUtils.getCellData(1, 0);

        String password =
                ExcelUtils.getCellData(1, 1);

        ExcelUtils.closeExcel();

        loginPage.login(username, password);

        Assert.assertTrue(
                loginPage.isLogoutDisplayed(),
                "Logout button is not displayed!"
        );

        // Click Logout
        loginPage.clickLogout();

        // Take screenshot as bug evidence
        takeScreenshotWithTimestamp(
                "DEF_011_Logout_Success_Message_Not_Displayed"
        );

        // Verify logout success message
        Assert.assertTrue(
                loginPage.isLogoutSuccessMessageDisplayed(),
                "BUG: Logout success message is not displayed!"
        );
    }
}