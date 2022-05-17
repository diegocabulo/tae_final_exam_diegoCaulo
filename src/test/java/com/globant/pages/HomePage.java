package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


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

    @FindBy(css = "li.pillar.watch > a")
    private WebElement watchLink;

    @FindBy(css = "li.display-user > span")
    private WebElement usernameText;

    @FindBy(css = "#sideLogin-left-rail > button.button-alt.med")
    private WebElement logInButtonCheck;

    public WebElement getUsernameText() { return usernameText; }

    public WebElement getWatchLink() { return watchLink; }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public WebElement getLogInButton() { return logInButton; }

    public WebElement getLogInButtonCheck() { return logInButtonCheck; }


    public LogInIframe clickLogIn(){
        actionHoverElement();
        waitToBeClickable(logInButton);
        logInButton.click();
        getDriver().switchTo().frame(iframeLogIn);
        return new LogInIframe(getDriver());
    }

    public WatchPage clickWatchButton(){
        waitToBeClickable(watchLink);
        watchLink.click();
        return new WatchPage(getDriver());
    }


    public void actionHoverElement(){
        waitElementVisibility(hoverElement);
        actions.moveToElement(hoverElement).perform();
    }

}
