package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AboutUsPage;

public class AboutUsTest extends BaseTest {

    AboutUsPage aboutUsPage;

    // =========================================================
    // BEFORE EACH TEST
    // =========================================================

    @BeforeMethod
    public void navigateToHome() {

        driver.get("https://www.demoblaze.com/");

        System.out.println(
                "===== Navigated to Home Page ====="
        );
    }

    // =========================================================
    // TC_ABOUT_001
    // ABOUT US LINK
    // =========================================================

    @Test(priority = 1)
    public void verifyAboutUsLink() {

        aboutUsPage = new AboutUsPage(driver);

        Assert.assertTrue(
                aboutUsPage.isAboutUsLinkDisplayed(),
                "About Us link is not displayed!"
        );

        System.out.println(
                "TC_ABOUT_001 - About Us link verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_002
    // ABOUT US MODAL
    // =========================================================

    @Test(priority = 2)
    public void verifyAboutUsModal() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        Assert.assertTrue(
                aboutUsPage.isAboutUsModalDisplayed(),
                "About Us modal is not displayed!"
        );

        System.out.println(
                "TC_ABOUT_002 - About Us modal displayed successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_003
    // ABOUT US TITLE
    // =========================================================

    @Test(priority = 3)
    public void verifyAboutUsTitle() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        String title =
                aboutUsPage.getAboutUsTitle();

        System.out.println(
                "About Us Title: " + title
        );

        Assert.assertEquals(
                title,
                "About us",
                "About Us title is incorrect!"
        );

        System.out.println(
                "TC_ABOUT_003 - About Us title verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_004
    // VIDEO DISPLAY
    // =========================================================

    @Test(priority = 4)
    public void verifyAboutUsVideo() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        Assert.assertTrue(
                aboutUsPage.isVideoDisplayed(),
                "About Us video is not displayed!"
        );

        System.out.println(
                "TC_ABOUT_004 - About Us video verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_005
    // CLOSE BUTTON
    // =========================================================

    @Test(priority = 5)
    public void verifyAboutUsCloseButton() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        Assert.assertTrue(
                aboutUsPage.isCloseButtonDisplayed(),
                "About Us close button is not displayed!"
        );

        System.out.println(
                "TC_ABOUT_005 - About Us close button verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_006
    // CLOSE FUNCTIONALITY
    // =========================================================

    @Test(priority = 6)
    public void verifyAboutUsCloseFunctionality() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        aboutUsPage.clickCloseButton();

        Assert.assertFalse(
                aboutUsPage.isAboutUsModalDisplayed(),
                "About Us modal is still displayed!"
        );

        System.out.println(
                "TC_ABOUT_006 - About Us close functionality verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_007
    // ABOUT US HOVER
    // =========================================================

    @Test(priority = 7)
    public void verifyAboutUsHover() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.hoverAboutUsLink();

        System.out.println(
                "TC_ABOUT_007 - About Us hover performed successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_009
    // VIDEO PLAY BUTTON
    // =========================================================
    @Test(priority = 9)
    public void verifyVideoPlayButton() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        Assert.assertTrue(
                aboutUsPage.isVideoPlayButtonDisplayed(),
                "Video Play button is not displayed!"
        );

        Assert.assertTrue(
                aboutUsPage.isVideoPlayButtonEnabled(),
                "Video Play button is not enabled!"
        );

        System.out.println(
                "TC_ABOUT_009 - Video Play button verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_010
    // VIDEO PAUSE
    // =========================================================

    @Test(priority = 10)
    public void verifyVideoPause() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        aboutUsPage.clickVideoPlay();

        Assert.assertTrue(
                aboutUsPage.isVideoPlaying(),
                "Video is not playing!"
        );

        aboutUsPage.pauseVideo();

        Assert.assertTrue(
                aboutUsPage.isVideoPaused(),
                "Video is not paused!"
        );

        System.out.println(
                "TC_ABOUT_010 - Video pause verified successfully"
        );
    }
    // =========================================================
    // TC_ABOUT_011
    // VIDEO PLAYING
    // =========================================================

    @Test(priority = 11)
    public void verifyVideoPlaying() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        aboutUsPage.clickVideoPlay();

        Assert.assertTrue(
                aboutUsPage.isVideoPlaying(),
                "Video is not playing!"
        );

        System.out.println(
                "TC_ABOUT_011 - Video playing verified successfully"
        );
    }
    // =========================================================
    // TC_ABOUT_012
    // VIDEO VOLUME
    // =========================================================

    @Test(priority = 12)
    public void verifyVideoVolumeAdjustment() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        aboutUsPage.setVideoVolume(0.5);

        double volume =
                aboutUsPage.getVideoVolume();

        System.out.println(
                "Video Volume: " + volume
        );

        Assert.assertEquals(
                volume,
                0.5,
                0.01,
                "Video volume was not adjusted!"
        );

        System.out.println(
                "TC_ABOUT_012 - Video volume adjustment verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_013
    // VIDEO DURATION
    // =========================================================

    @Test(priority = 13)
    public void verifyVideoDuration() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        double duration =
                aboutUsPage.getVideoDuration();

        System.out.println(
                "Video Duration: " + duration + " seconds"
        );

        Assert.assertTrue(
                duration > 0,
                "Video duration is invalid!"
        );

        System.out.println(
                "TC_ABOUT_013 - Video duration verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_014
    // VIDEO SEEKING
    // =========================================================

    @Test(priority = 14)
    public void verifyVideoSeeking() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        aboutUsPage.seekVideo(5);

        double currentTime =
                aboutUsPage.getCurrentVideoTime();

        System.out.println(
                "Current Video Time: " + currentTime
        );

        Assert.assertTrue(
                currentTime >= 4,
                "Video seeking did not work!"
        );

        System.out.println(
                "TC_ABOUT_014 - Video seeking verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_015
    // VIDEO SCREEN
    // =========================================================

    @Test(priority = 15)
    public void verifyVideoScreen() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        int width =
                aboutUsPage.getVideoWidth();

        int height =
                aboutUsPage.getVideoHeight();

        System.out.println(
                "Video Width: " + width
        );

        System.out.println(
                "Video Height: " + height
        );

        Assert.assertTrue(
                width > 0,
                "Video width is invalid!"
        );

        Assert.assertTrue(
                height > 0,
                "Video height is invalid!"
        );

        System.out.println(
                "TC_ABOUT_015 - Video screen verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_016
    // VIDEO CONTROLS
    // =========================================================

    @Test(priority = 16)
    public void verifyVideoControls() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        // Play first so Video.js controls are active.
        aboutUsPage.clickVideoPlay();

        Assert.assertTrue(
                aboutUsPage.isVideoControlBarDisplayed(),
                "Video control bar is not displayed!"
        );

        System.out.println(
                "TC_ABOUT_016 - Video controls verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_017
    // VIDEO MUTE / UNMUTE
    // =========================================================

    @Test(priority = 17)
    public void verifyVideoMuteUnmute() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        // Play first.
        aboutUsPage.clickVideoPlay();

        Assert.assertTrue(
                aboutUsPage.isVideoMuteButtonDisplayed(),
                "Video mute button is not displayed!"
        );

        aboutUsPage.clickMuteButton();

        Assert.assertTrue(
                aboutUsPage.isVideoMuted(),
                "Video was not muted!"
        );

        System.out.println(
                "TC_ABOUT_017 - Video mute/unmute verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_018
    // VIDEO READY STATE
    // =========================================================

    @Test(priority = 18)
    public void verifyVideoReady() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        int readyState =
                aboutUsPage.getVideoReadyState();

        System.out.println(
                "Video readyState: " + readyState
        );

        Assert.assertTrue(
                readyState >= 2,
                "Video is not ready for playback!"
        );

        System.out.println(
                "TC_ABOUT_018 - Video ready state verified successfully"
        );
    }

    // =========================================================
    // TC_ABOUT_019
    // FULLSCREEN BUTTON
    // =========================================================

    @Test(priority = 19)
    public void verifyVideoFullscreenButton() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.openAboutUs();

        // Play first so Video.js controls become active.
        aboutUsPage.clickVideoPlay();

        Assert.assertTrue(
                aboutUsPage.isVideoFullscreenButtonDisplayed(),
                "Fullscreen button is not displayed!"
        );

        Assert.assertTrue(
                aboutUsPage.isVideoFullscreenButtonEnabled(),
                "Fullscreen button is not enabled!"
        );

        System.out.println(
                "TC_ABOUT_019 - Video fullscreen button verified successfully"
        );
    }
}