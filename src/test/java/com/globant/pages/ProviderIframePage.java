package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProviderIframePage extends BasePage{
    public ProviderIframePage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "header > button")
    private WebElement closeButtonProvider;

    public WebElement getCloseButtonProvider() {
        return closeButtonProvider;
    }
}
