package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class GoogleSearchPage extends MainPage {
    @FindBy(xpath = "//[@name='q']")
    private WebElement searchResultsTotal;
    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;
    public GoogleSearchPage(WebDriver browser) {
        super();
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    public boolean isLoaded() {
        return searchResultsTotal.isDisplayed()
                && getCurrentPageTitle().contains("selenium - Пошук Google")
                && getCurrentPageUrl().contains("cO6XW8-6BuOe0gLTorrICQ&q=selenium&oq=Silenium&gs_l");
    }
    public int getSearchResultsCount() {
        return searchResults.size();
    }

    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults ){
            ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultsList.add(searchResult.getText());
        }
        return searchResultsList;

    }
}