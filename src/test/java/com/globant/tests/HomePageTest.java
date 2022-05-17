package com.globant.tests;

import com.globant.data.Data;
import com.globant.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test(description = "Log in Validation", priority = 1)
    public void validateLogIn(){
        HomePage homePage = getHomePage();
        logger.info("You are in the home page");
        LogInIframe logInIframe = homePage.clickLogIn();
        logger.info("You enter the log in iframe page");
        logger.info("Validate logo");
        Assert.assertTrue(logInIframe.isDisplayed(logInIframe.getLogoElement()));
        logger.info("Validate log in text");
        Assert.assertEquals(logInIframe.getLoginButton().getText(),"Log In");
        logger.info("Validate Sign up text");
        Assert.assertEquals(logInIframe.getSignUpButton().getText(),"Sign Up");
    }

    @Test(description = "Sign Up validation",dataProviderClass = Data.class, dataProvider = "user",priority = 2)
    public void validateSignUp(String email){
        logger.info("Initiate sign up validation test");
        LogInIframe logInIframe = new LogInIframe(driver.getDriver());
        SignUpIframePage signUpIframePage = logInIframe.clickSignUpIframe();
        logger.info("Enter sign up form");
        logger.info("Validate Title");
        Assert.assertEquals(signUpIframePage.getTitleSignUpForm().getText(),"Create Account");
        logger.info("Validate First name field");
        Assert.assertEquals(signUpIframePage.getFirstNameField().getAttribute("placeholder"),"First Name");
        logger.info("Validate Last name field");
        Assert.assertEquals(signUpIframePage.getLastNameField().getAttribute("placeholder"),"Last Name");
        logger.info("Validate Email address field");
        Assert.assertEquals(signUpIframePage.getEmailField().getAttribute("placeholder"),"Email Address");
        logger.info("Validate Password field");
        Assert.assertEquals(signUpIframePage.getNewPasswordField().getAttribute("placeholder"),"Password (case sensitive)");
        logger.info("Validate Sign up button text");
        Assert.assertEquals(signUpIframePage.getSignUpButton().getText(),"Sign Up");
        logger.info("Validate Close button displayed");
        Assert.assertTrue(signUpIframePage.isDisplayed(signUpIframePage.getCloseButtonSignUp()));
        signUpIframePage.fillFieldsSignUp(email);
        logger.info("Fill form");
        signUpIframePage.clickElement(signUpIframePage.getSignUpButton());
        logger.info("Redirect to home page but already logged in");
    }

    @Test(description = "Validate Carousel", priority = 3)
    public void validateCarousel(){
        HomePage homePage = getHomePage();
        logger.info("Your are in the home page");
        homePage.waitToBeClickable(homePage.getWatchLink());
        Assert.assertTrue(homePage.getWatchLink().getAttribute("href").contains("watch"));
        logger.info("Validate watch button");
        WatchPage watchPage = homePage.clickWatchButton();
        logger.info("You are in the Watch Page");
        Assert.assertTrue(watchPage.isDisplayed(watchPage.getCarrouselAnchorTags().get(0)));
        logger.info("Validate first carousel card is displayed");
        Assert.assertNotEquals(watchPage.getCarrouselAnchorTags().get(0).getAttribute("data-track-title"), "");
        logger.info("Validate the title of the first anchor tag exist");
        ProviderIframePage providerIframePage = watchPage.clickCarouselTag(watchPage.getCarrouselAnchorTags().get(1));
    }

    @Test(description = "Validate provider page and close", priority = 4)
    public void validateProviderPage(){
        logger.info("Initiate provider page test");
        ProviderIframePage providerIframePage = new ProviderIframePage(driver.getDriver());
        providerIframePage.waitToBeClickable(providerIframePage.getCloseButtonProvider());
        logger.info("Validate close button is displayed");
        Assert.assertTrue(providerIframePage.isDisplayed(providerIframePage.getCloseButtonProvider()));
        logger.info("Click on close button");
        providerIframePage.clickElement(providerIframePage.getCloseButtonProvider());
        logger.info("Go to home page");
        providerIframePage.goPreviousPage();
    }

    @Test(description = "Validate log out", priority = 5)
    public void validateLogOut(){
        logger.info("Initiate log out test");
        HomePage homePage = getHomePage();
        logger.info("Hover over the user icon");
        homePage.actionHoverElement();
        logger.info("Validate username text is displayed");
        Assert.assertTrue(homePage.getUsernameText().getText().contains("test"));
        logger.info("Click in logout button");
        homePage.clickElement(homePage.getLogOutButton());
        logger.info("Validate log out with log in text");
        homePage.waitToBeClickable(homePage.getLogInButtonCheck());
        Assert.assertTrue(homePage.isDisplayed(homePage.getLogInButtonCheck()));
        Assert.assertEquals(homePage.getLogInButtonCheck().getText(),"Log In");
    }

}
