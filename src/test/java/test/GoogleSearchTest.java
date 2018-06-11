package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleLandingPage;
import page.GoogleSearchResultsPage;

import java.util.List;

/**
 * Search Test Object class
 */
public class GoogleSearchTest extends GoogleBaseTest {
    public String searchTerm;
    List<String> searchResultsText;

    /**
     * Method for Google search test
     * Check that 10 results are displayed on first and second pages and each result contains search term
     * String searchTerm can be parametrized for different search term
     */
    @Test
    public void googleSearchTest() {
        searchTerm = "Selenium";
        Assert.assertTrue(googleLandingPage.isPageLoaded(), "Google Landing page is not loaded");
        GoogleSearchResultsPage googleSearchResultsPageOne = googleLandingPage.startSearch(searchTerm);
        Assert.assertTrue(googleSearchResultsPageOne.isResultsPageSwitched(1), "Google search results page one is not loaded");
        searchResultsText = googleSearchResultsPageOne.getSearchResultsText();
        Assert.assertEquals(searchResultsText.size(), 10, "Search results amount is wrong.");
        for (String searchResultText : searchResultsText) {
            Assert.assertTrue(searchResultText.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm "+ searchTerm+"was not found in: \n"+searchResultText);
        }
        GoogleSearchResultsPage googleSearchResultsPageTwo = googleSearchResultsPageOne.switchToPage(2);
        Assert.assertTrue(googleSearchResultsPageTwo.isResultsPageSwitched(2), "Google search results page two is not loaded");
        searchResultsText = googleSearchResultsPageTwo.getSearchResultsText();
        Assert.assertEquals(searchResultsText.size(), 10, "Search results amount is wrong.");
        for (String searchResultText : searchResultsText) {
            Assert.assertTrue(searchResultText.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm "+ searchTerm+"was not found in: \n"+searchResultText);
        }
    }
}
