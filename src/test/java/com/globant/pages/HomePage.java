package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.get(url);
    }

    private final Actions actions = new Actions(getDriver());

    @FindBy(id = "global-user-trigger")
    private WebElement hoverElement;

    @FindBy(css = "#global-header a[tref='/members/v3_1/login']")
    private WebElement logInButton;

    @FindBy(css = "#global-header ul.account-management > li:nth-child(9) > a")
    private WebElement logOutButton;

    @FindBy(css = "iframe[name ='oneid-iframe']")
    private WebElement iframeLogIn;


    public WebElement getLogOutButton() {
        return logOutButton;
    }


    public LogInIframe clickLogIn(){
        actionHoverElement();
        waitToBeClickable(logInButton);
        logInButton.click();
        getDriver().switchTo().frame(iframeLogIn);
        return new LogInIframe(getDriver());
    }

    public void clickLogOut(){
        waitToBeClickable(logOutButton);
        logOutButton.click();
    }


    public boolean checkLogOut(){
        actionHoverElement();
        waitToBeClickable(logOutButton);
        return logOutButton.getText().equals("Log Out");
    }

    public void actionHoverElement(){
        waitElementVisibility(hoverElement);
        actions.moveToElement(hoverElement).perform();
    }

}
