package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class that represent the signup page
 */
public class SignUpIframePage extends BasePage{
    /**
     * Constructor
     * @param pDriver WebDriver
     */
    public SignUpIframePage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "#Title > span")
    private WebElement titleSignUpForm;

    @FindBy(id = "InputFirstName")
    private WebElement firstNameField;

    @FindBy(id = "InputLastName")
    private WebElement lastNameField;

    @FindBy(id = "InputEmail")
    private WebElement emailField;

    @FindBy(id = "password-new")
    private WebElement newPasswordField;

    @FindBy(id = "close")
    private WebElement closeButtonSignUp;

    @FindBy(id = "BtnSubmit")
    private WebElement signUpButton;

    /**
     * Get the title WebElement
     * @return webElement
     */
    public WebElement getTitleSignUpForm() {
        return titleSignUpForm;
    }

    /**
     * Get the First name WebElement
     * @return webElement
     */
    public WebElement getFirstNameField() {
        return firstNameField;
    }

    /**
     * Get the Lastname WebElement
     * @return webElement
     */
    public WebElement getLastNameField() {
        return lastNameField;
    }

    /**
     * Get the Email WebElement
     * @return webElement
     */
    public WebElement getEmailField() {
        return emailField;
    }

    /**
     * Get the Password webElement
     * @return webElement
     */
    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    /**
     * Get the Close button of the iframe
     * @return Close Button singUp
     */
    public WebElement getCloseButtonSignUp() {
        return closeButtonSignUp;
    }

    /**
     * get the sign up button element
     * @return webElement
     */
    public WebElement getSignUpButton() {
        return signUpButton;
    }

    /**
     * Method to fill the form with a email
     * @param email String
     */
    public void fillFieldsSignUp(String email){
        waitToBeClickable(firstNameField);
        firstNameField.sendKeys("test");
        waitToBeClickable(lastNameField);
        lastNameField.sendKeys("test");
        waitToBeClickable(emailField);
        emailField.sendKeys(email);
        waitToBeClickable(newPasswordField);
        newPasswordField.sendKeys("test12345*");
    }

}
