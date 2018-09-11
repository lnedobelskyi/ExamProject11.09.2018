package tests;


import org.junit.Assert;
import org.junit.Test;
import pages.GoogleSearchPage;

import java.util.List;

public class SearchTest extends BaseTest {

        @Test
        public void basicSearchTest() {
            String searchTerm = "Selenium";

            GoogleSearchPage googleSearchPage = mainPage.search(searchTerm);
            Assert.assertTrue("Search page is not loaded.",
                    googleSearchPage.isLoaded());
            Assert.assertEquals(String.valueOf(googleSearchPage.getSearchResultsCount()), 10,
                    "Search results count is wrong.");

            List<String> searchResults = googleSearchPage.getSearchResultsList();

            for (String searchResult: searchResults){
                Assert.assertTrue("searchTerm "+searchTerm+" not found in:\n"+searchResult,
                        searchResult.toLowerCase().contains(searchTerm.toLowerCase()));
            }
        }
    }