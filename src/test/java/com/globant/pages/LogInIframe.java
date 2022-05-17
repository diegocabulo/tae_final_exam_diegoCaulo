package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class that represent the logIn iframe extends from BasePage
 */
public class LogInIframe extends BasePage{

    /**
     * Constructor
     * @param pDriver WebDriver
     */
    public LogInIframe(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButton;

    @FindBy(id = "logo")
    private WebElement logoElement;

    /**
     * Get the logo element
     * @return webElement
     */
    public WebElement getLogoElement() { return logoElement; }

    /**
     * Ge the SignUp button element
     * @return webElement
     */
    public WebElement getSignUpButton() { return signUpButton; }

    /**
     * Get LogInButton element
     * @return webElement
     */
    public WebElement getLoginButton() { return loginButton; }

    /**
     * Click signup button an change the view
     * @return  SignUpFramePage object
     */
    public SignUpIframePage clickSignUpIframe(){
        waitToBeClickable(signUpButton);
        signUpButton.click();
        return new SignUpIframePage(getDriver());
    }

}
