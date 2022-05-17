package com.globant.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class that represents the base page, common methods
 * @author diego.cabulo@globant.com
 */
public class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver pDriver){
        PageFactory.initElements(pDriver, this);

        webDriverWait = new WebDriverWait(pDriver, 20);
        driver = pDriver;
    }


    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }

    public void waitElementVisibility(WebElement element){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToBeClickable(WebElement element){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement element){
        waitToBeClickable(element);
        element.click();
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void goPreviousPage(){
        driver.navigate().back();
    }
}
