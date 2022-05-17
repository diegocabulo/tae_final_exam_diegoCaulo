package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpIframePage extends BasePage{

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

    public WebElement getTitleSignUpForm() {
        return titleSignUpForm;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    public WebElement getCloseButtonSignUp() {
        return closeButtonSignUp;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

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
