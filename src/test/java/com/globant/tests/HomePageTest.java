package com.globant.tests;

import com.globant.data.Data;
import com.globant.pages.HomePage;
import com.globant.pages.LogInIframe;
import com.globant.pages.SignUpIframePage;
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
        signUpIframePage.clickSingUpButton();
        logger.info("Redirect to home page but already logged in");
    }

}
