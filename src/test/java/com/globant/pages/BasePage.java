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

    /**
     * Constructor
     * @param pDriver
     */
    public BasePage(WebDriver pDriver){
        PageFactory.initElements(pDriver, this);

        webDriverWait = new WebDriverWait(pDriver, 20);
        driver = pDriver;
    }

    /**
     * Get the wait driver
     * @return DriverWait object
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * Get the driver
     * @return Driver object
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Method to quit the driver
     */
    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }

    /**
     * Wait an element to be visible
     * @param element WebElement object
     */
    public void waitElementVisibility(WebElement element){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait an element to be clickable
     * @param element Web element object
     */
    public void waitToBeClickable(WebElement element){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Click an element
     * @param element WebElement
     */
    public void clickElement(WebElement element){
        waitToBeClickable(element);
        element.click();
    }

    /**
     * Check is an element is displayed
     * @param element webElement
     * @return boolean
     */
    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    /**
     * Method to go backwards in the page you currently are
     */
    public void goPreviousPage(){
        driver.navigate().back();
    }
}
