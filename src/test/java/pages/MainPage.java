package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public abstract class MainPage {
        protected WebDriver browser;

        public MainPage(WebDriver browser) {

        }

        public MainPage() {

        }

        public String getCurrentPageTitle () {
            return browser.getTitle();
        }
        public String getCurrentPageUrl () {
            return browser.getCurrentUrl();
        }
        public abstract boolean isLoaded ();

        public abstract GoogleSearchPage search(String searchTerm);
    }