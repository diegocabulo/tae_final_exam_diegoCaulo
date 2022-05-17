package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class that represent the watch page extends BasePage
 */
public class WatchPage extends BasePage{
    /**
     * Constructor
     * @param pDriver WebDriver
     */
    public WatchPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Get all the anchor tags elements
     * @return List webElements
     */
    public List<WebElement> getCarrouselAnchorTags() {
        return carrouselAnchorTags;
    }

    @FindBy(css = "ul > li.CarouselSlide > a")
    private List<WebElement> carrouselAnchorTags;

    /**
     * Go to the provider page
     * @param element webElement
     * @return ProviderIframePage
     */
    public ProviderIframePage clickCarouselTag(WebElement element){
        waitToBeClickable(element);
        element.click();
        return new ProviderIframePage(getDriver());
    }
}
