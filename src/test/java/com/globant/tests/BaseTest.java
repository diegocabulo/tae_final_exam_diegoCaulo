package com.globant.tests;

import com.globant.Driver;
import com.globant.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static Driver driver;
    private HomePage homePage;

    public Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeTest
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url){
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver(), url);
    }

    public HomePage getHomePage(){
        return homePage;
    }

    @AfterTest
    public void afterTest(){
        logger.info("Finish the Test");
        homePage.dispose();
    }
}
