package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Class thar represent the HomePage extends from BasePage
 */
public class HomePage extends BasePage{

    /**
     * Constructor
     * @param pDriver WebDriver
     * @param url String
     */
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

    /**
     * Get the username text
     * @return WebElement
     */
    public WebElement getUsernameText() { return usernameText; }

    /**
     * Get the watch link Element
     * @return WebElement
     */
    public WebElement getWatchLink() { return watchLink; }

    /**
     * Get the logOut button element
     * @return WebElement
     */
    public WebElement getLogOutButton() { return logOutButton; }

    /**
     * Get tje logIn button check element
     * @return WebElement
     */
    public WebElement getLogInButtonCheck() { return logInButtonCheck; }

    /**
     * Hover an element an then click in login button
     * @return LogInFrame object and pass the driver
     */
    public LogInIframe clickLogIn(){
        actionHoverElement();
        waitToBeClickable(logInButton);
        logInButton.click();
        getDriver().switchTo().frame(iframeLogIn);
        return new LogInIframe(getDriver());
    }

    /**
     * Click in watch element and change to a new page
     * @return WatchPage object
     */
    public WatchPage clickWatchButton(){
        waitToBeClickable(watchLink);
        watchLink.click();
        return new WatchPage(getDriver());
    }

    /**
     * Hover over an element
     */
    public void actionHoverElement(){
        waitElementVisibility(hoverElement);
        actions.moveToElement(hoverElement).perform();
    }

}
