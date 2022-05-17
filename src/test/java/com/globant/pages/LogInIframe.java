package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInIframe extends BasePage{
    public LogInIframe(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "input[type='email']")
    private WebElement userNameInputField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInputField;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;

    @FindBy(id = "cancel-account")
    private WebElement deleteAccountLink;

    @FindBy(css = "button.btn.btn-primary.ng-isolate-scope")
    private WebElement confirmCommonButton;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButton;

    @FindBy(id = "logo")
    private WebElement logoElement;


    public WebElement getLogoElement() { return logoElement; }

    public WebElement getSignUpButton() { return signUpButton; }

    public WebElement getLoginButton() { return loginButton; }


    public SignUpIframePage clickSignUpIframe(){
        waitToBeClickable(signUpButton);
        signUpButton.click();
        return new SignUpIframePage(getDriver());
    }

}
