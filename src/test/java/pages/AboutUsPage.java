package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public AboutUsPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        this.js = (JavascriptExecutor) driver;
    }

    // =========================================================
    // NAVIGATION
    // =========================================================

    private By aboutUsLink = By.xpath(
            "//a[contains(normalize-space(),'About us')]"
    );

    private By aboutUsModal = By.id("videoModal");

    private By aboutUsTitle = By.xpath(
            "//div[@id='videoModal']//h5"
    );

    private By closeButton = By.xpath(
            "//div[@id='videoModal']//button[contains(text(),'Close')]"
    );

    // =========================================================
    // VIDEO
    // =========================================================

    private By videoPlayer = By.id("example-video");

    private By actualVideo = By.cssSelector(
            "#example-video video"
    );

    // Video.js Play button
    private By playButton = By.cssSelector(
            "#example-video .vjs-play-control"
    );

    // Video.js Mute button
    private By muteButton = By.cssSelector(
            "#example-video .vjs-mute-control"
    );

    // Video.js Fullscreen button
    private By fullscreenButton = By.cssSelector(
            "#example-video .vjs-fullscreen-control"
    );

    // Video.js control bar
    private By controlBar = By.cssSelector(
            "#example-video .vjs-control-bar"
    );

    // =========================================================
    // OPEN ABOUT US
    // =========================================================

    public void openAboutUs() {

        wait.until(
                ExpectedConditions.elementToBeClickable(aboutUsLink)
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        aboutUsModal
                )
        );
    }

    // =========================================================
    // ABOUT US LINK
    // =========================================================

    public boolean isAboutUsLinkDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            aboutUsLink
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // MODAL
    // =========================================================

    public boolean isAboutUsModalDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            aboutUsModal
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // TITLE
    // =========================================================

    public String getAboutUsTitle() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        aboutUsTitle
                )
        ).getText();
    }

    // =========================================================
    // VIDEO DISPLAY
    // =========================================================

    public boolean isVideoDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            actualVideo
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // HOVER VIDEO
    // =========================================================

    private void hoverVideoPlayer() {

        WebElement player = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        videoPlayer
                )
        );

        new Actions(driver)
                .moveToElement(player)
                .perform();

        // Video.js controls become visible after mouse movement.
        try {

            Thread.sleep(500);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }

    // =========================================================
    // PLAY BUTTON
    // =========================================================

    public boolean isVideoPlayButtonDisplayed() {

        try {

            hoverVideoPlayer();

            WebElement button = wait.until(
                    ExpectedConditions.presenceOfElementLocated(playButton)
            );

            return button.isDisplayed()
                    || button.isEnabled();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isVideoPlayButtonEnabled() {

        try {

            hoverVideoPlayer();

            WebElement button = wait.until(
                    ExpectedConditions.presenceOfElementLocated(playButton)
            );

            Boolean disabled = (Boolean) js.executeScript(
                    "return arguments[0].disabled;",
                    button
            );

            return Boolean.FALSE.equals(disabled);

        } catch (Exception e) {

            return false;
        }
    }

    public void clickVideoPlay() {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(actualVideo)
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                video
        );

        js.executeScript(
                "arguments[0].muted = true;" +
                "arguments[0].play();",
                video
        );

        wait.until(driver -> {
            try {
                Boolean paused = (Boolean) js.executeScript(
                        "return arguments[0].paused;",
                        video
                );

                Boolean ended = (Boolean) js.executeScript(
                        "return arguments[0].ended;",
                        video
                );

                return Boolean.FALSE.equals(paused)
                        && Boolean.FALSE.equals(ended);

            } catch (Exception e) {
                return false;
            }
        });
    }
    // =========================================================
    // VIDEO PLAYING
    // =========================================================

    public boolean isVideoPlaying() {

        try {

            WebElement video = wait.until(
                    ExpectedConditions.presenceOfElementLocated(actualVideo)
            );

            Boolean playing = (Boolean) js.executeScript(
                    "return !arguments[0].paused && " +
                    "!arguments[0].ended && " +
                    "arguments[0].readyState >= 2;",
                    video
            );

            return Boolean.TRUE.equals(playing);

        } catch (Exception e) {

            return false;
        }
    }
    // =========================================================
    // VIDEO PAUSE
    // =========================================================

    public void pauseVideo() {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        js.executeScript(
                "arguments[0].pause();",
                video
        );
    }

    public boolean isVideoPaused() {

        try {

            WebElement video = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            actualVideo
                    )
            );

            Boolean paused = (Boolean) js.executeScript(
                    "return arguments[0].paused;",
                    video
            );

            return Boolean.TRUE.equals(paused);

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VIDEO CONTROL BAR
    // =========================================================

    public boolean isVideoControlBarDisplayed() {

        try {

            hoverVideoPlayer();

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            controlBar
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // MUTE / UNMUTE
    // =========================================================

    public boolean isVideoMuteButtonDisplayed() {

        try {

            hoverVideoPlayer();

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            muteButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public void clickMuteButton() {

        hoverVideoPlayer();

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(actualVideo)
        );

        js.executeScript(
                "arguments[0].muted = true;",
                video
        );

        wait.until(driver -> {
            try {
                Boolean muted = (Boolean) js.executeScript(
                        "return arguments[0].muted;",
                        video
                );

                return Boolean.TRUE.equals(muted);

            } catch (Exception e) {
                return false;
            }
        });
    }

    public boolean isVideoMuted() {

        try {

            WebElement video = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            actualVideo
                    )
            );

            Boolean muted = (Boolean) js.executeScript(
                    "return arguments[0].muted;",
                    video
            );

            return Boolean.TRUE.equals(muted);

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // FULLSCREEN
    // =========================================================

    public boolean isVideoFullscreenButtonDisplayed() {

        try {

            hoverVideoPlayer();

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            fullscreenButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isVideoFullscreenButtonEnabled() {

        try {

            hoverVideoPlayer();

            return wait.until(
                    ExpectedConditions.elementToBeClickable(
                            fullscreenButton
                    )
            ).isEnabled();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VIDEO READY STATE
    // =========================================================

    public int getVideoReadyState() {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        Long readyState = (Long) js.executeScript(
                "return arguments[0].readyState;",
                video
        );

        return readyState.intValue();
    }

    // =========================================================
    // VIDEO DURATION
    // =========================================================

    public double getVideoDuration() {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        Number duration = (Number) js.executeScript(
                "return arguments[0].duration;",
                video
        );

        return duration.doubleValue();
    }

    // =========================================================
    // VIDEO VOLUME
    // =========================================================

    public void setVideoVolume(double volume) {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        js.executeScript(
                "arguments[0].volume = arguments[1];",
                video,
                volume
        );
    }

    public double getVideoVolume() {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        Number volume = (Number) js.executeScript(
                "return arguments[0].volume;",
                video
        );

        return volume.doubleValue();
    }

    // =========================================================
    // VIDEO SEEKING
    // =========================================================

    public void seekVideo(double seconds) {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        js.executeScript(
                "arguments[0].currentTime = arguments[1];",
                video,
                seconds
        );
    }

    public double getCurrentVideoTime() {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        Number currentTime = (Number) js.executeScript(
                "return arguments[0].currentTime;",
                video
        );

        return currentTime.doubleValue();
    }

    // =========================================================
    // VIDEO SCREEN SIZE
    // =========================================================

    public int getVideoWidth() {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        Number width = (Number) js.executeScript(
                "return arguments[0].videoWidth;",
                video
        );

        return width.intValue();
    }

    public int getVideoHeight() {

        WebElement video = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        actualVideo
                )
        );

        Number height = (Number) js.executeScript(
                "return arguments[0].videoHeight;",
                video
        );

        return height.intValue();
    }

    // =========================================================
    // CLOSE BUTTON
    // =========================================================

    public boolean isCloseButtonDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            closeButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public void clickCloseButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        closeButton
                )
        ).click();

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        aboutUsModal
                )
        );
    }

    // =========================================================
    // ABOUT US HOVER
    // =========================================================

    public void hoverAboutUsLink() {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        aboutUsLink
                )
        );

        new Actions(driver)
                .moveToElement(element)
                .perform();
    }
}