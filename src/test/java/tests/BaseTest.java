package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.GoogleSearchPage;

public class BaseTest {
    WebDriver browser;
    GoogleSearchPage googleSearchPage;

    @BeforeMethod
    public void beforeMethod(@Optional("firefox") String browserName) {
            System.setProperty("webdriver.gecko.driver","/Users/liubomyrned/Downloads/geckodriver");
            browser = new FirefoxDriver();
        browser.get("https://www.google.com/");
        googleSearchPage = new GoogleSearchPage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }
}