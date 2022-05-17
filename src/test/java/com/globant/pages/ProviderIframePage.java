package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class that represent the providerIframePage extends from basePage
 */
public class ProviderIframePage extends BasePage{
    /**
     * Constructor
     * @param pDriver WebDriver
     */
    public ProviderIframePage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "header > button")
    private WebElement closeButtonProvider;

    /**
     * get the close button provider
     * @return webElement
     */
    public WebElement getCloseButtonProvider() {
        return closeButtonProvider;
    }
}
