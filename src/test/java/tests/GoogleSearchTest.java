package tests;

import org.junit.Test;
import org.testng.Assert;
import pages.GoogleSearchResultPage;
import pages.GoogleSearchResultSecondPage;

import java.util.List;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void successfulSearchTest() {
        String searchTerm = "Selenium";

        Assert.assertTrue(googleSearchPage.isLoaded(),"Google search page is not loaded.");

        GoogleSearchResultPage googleSearchResultPage = googleSearchPage.search("Selenium");
        Assert.assertTrue(googleSearchResultPage.isLoaded(),"Google search result page is not loaded.");
        Assert.assertEquals(googleSearchResultPage.getSearchResultsCount(), 10, "Search result count is wrong for the first page.");

        List<String> searchResultsForFirstPage = googleSearchResultPage.getSearchResultsList();

        for (String searchResult: searchResultsForFirstPage) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "searchTerm "+searchTerm+" not found in: \n" +searchResult);
        }

        GoogleSearchResultSecondPage googleSecondSearchResultPage = googleSearchResultPage.clickOnSecondPageButton();
        Assert.assertTrue(googleSecondSearchResultPage.isLoaded(),"Second Google search page is not loaded.");
        Assert.assertEquals(googleSecondSearchResultPage.getSearchResultsCount(), 10, "Search result count is wrong for the second page.");

        List <String> searchResultsForSecondPage = googleSecondSearchResultPage.getSearchResultsList();

        for (String searchResult: searchResultsForSecondPage) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "searchTerm "+searchTerm+" not found in: \n" +searchResult);
        }
    }
}