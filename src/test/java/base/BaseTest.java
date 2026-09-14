package base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public void setup() {

        System.out.println("===== BROWSER SETUP START =====");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );

        driver.get("https://www.demoblaze.com/");

        // =====================================================
        // VALIDATIONS
        // =====================================================

        Assert.assertNotNull(
                driver,
                "Driver is not initialized!"
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println(
                "Current URL: " + currentUrl
        );

        Assert.assertTrue(
                currentUrl.contains("demoblaze"),
                "URL is incorrect!"
        );

        String title = driver.getTitle();

        System.out.println(
                "Page Title: " + title
        );

        Assert.assertEquals(
                title,
                "STORE",
                "Title mismatch!"
        );

        System.out.println(
                "===== BROWSER SETUP COMPLETED ====="
        );
    }


    // =========================================================
    // SCREENSHOT METHOD
    // =========================================================

    public void takeScreenshot(String screenshotName) {

        try {

            TakesScreenshot screenshot =
                    (TakesScreenshot) driver;

            File source =
                    screenshot.getScreenshotAs(
                            OutputType.FILE
                    );

            // Screenshot folder
            File destinationFolder =
                    new File(
                            System.getProperty("user.dir")
                            + "/screenshots"
                    );

            // Create folder if it doesn't exist
            if (!destinationFolder.exists()) {

                destinationFolder.mkdirs();
            }

            File destination =
                    new File(
                            destinationFolder,
                            screenshotName + ".png"
                    );

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved: "
                    + destination.getAbsolutePath()
            );

        } catch (IOException e) {

            System.out.println(
                    "Failed to take screenshot: "
                    + e.getMessage()
            );
        }
    }


    // =========================================================
    // SCREENSHOT WITH TIMESTAMP
    // =========================================================

    public void takeScreenshotWithTimestamp(
            String screenshotName) {

        try {

            TakesScreenshot screenshot =
                    (TakesScreenshot) driver;

            File source =
                    screenshot.getScreenshotAs(
                            OutputType.FILE
                    );

            File destinationFolder =
                    new File(
                            System.getProperty("user.dir")
                            + "/screenshots"
                    );

            if (!destinationFolder.exists()) {

                destinationFolder.mkdirs();
            }

            String timestamp =
                    new java.text.SimpleDateFormat(
                            "yyyyMMdd_HHmmss"
                    ).format(
                            new java.util.Date()
                    );

            File destination =
                    new File(
                            destinationFolder,
                            screenshotName
                            + "_"
                            + timestamp
                            + ".png"
                    );

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved: "
                    + destination.getAbsolutePath()
            );

        } catch (IOException e) {

            System.out.println(
                    "Failed to take screenshot: "
                    + e.getMessage()
            );
        }
    }


    // =========================================================
    // TEARDOWN
    // =========================================================

    @AfterClass
    public void tearDown() {

        System.out.println(
                "===== TEST COMPLETED - CLOSING BROWSER ====="
        );

        if (driver != null) {

            driver.quit();
        }
    }
}