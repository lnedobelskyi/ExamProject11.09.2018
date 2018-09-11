package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import pages.GoogleSearchPage;
import pages.MainPage;

public class BaseTest {
    WebDriver browser;
    MainPage mainPage;

    @BeforeMethod
    public void beforeMethod(@Optional("firefox") String browserName) {
        System.setProperty("webdriver.gecko.driver", "/Users/liubomyrned/Downloads/geckodriver");
        browser = new FirefoxDriver();

        browser.get("https://www.linkedin.com/");
        mainPage = new MainPage (browser) {

            public boolean isLoaded() {
                return false;
            }

            public GoogleSearchPage search(String searchTerm) {
                return null;
            }

            @AfterMethod
            public void afterMethod() {
                browser.close();
            }
        }
    }
}