package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends BasePage{

    public WatchPage(WebDriver pDriver) {
        super(pDriver);
    }

    public List<WebElement> getCarrouselAnchorTags() {
        return carrouselAnchorTags;
    }

    @FindBy(css = "ul > li.CarouselSlide > a")
    private List<WebElement> carrouselAnchorTags;

    public ProviderIframePage clickCarouselTag(WebElement element){
        waitToBeClickable(element);
        element.click();
        return new ProviderIframePage(getDriver());
    }
}
