package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleLandingPage;
import page.GoogleSearchResultsPage;

import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {
    public String searchTerm;
    List<String> searchResultsText;

    @Test
    public void googleSearchTest() {
        searchTerm = "Selenium";
        Assert.assertTrue(googleLandingPage.isPageLoaded(), "Google Landing page is not loaded");
        GoogleSearchResultsPage googleSearchResultsPageOne = googleLandingPage.startSearch(searchTerm);
        Assert.assertTrue(googleSearchResultsPageOne.isResultsPageSwitched(1), "Google search results page one is not loaded");
        searchResultsText = googleSearchResultsPageOne.getSearchResultsText();
        checkSearchResultsText();
        GoogleSearchResultsPage googleSearchResultsPageTwo = googleSearchResultsPageOne.switchToPage(2);
        Assert.assertTrue(googleSearchResultsPageTwo.isResultsPageSwitched(2), "Google search results page two is not loaded");
        searchResultsText = googleSearchResultsPageTwo.getSearchResultsText();
        checkSearchResultsText();
    }
    public void checkSearchResultsText() {
        Assert.assertEquals(searchResultsText.size(), 10, "Search results amount is wrong.");
        for (String searchResultText : searchResultsText) {
            Assert.assertTrue(searchResultText.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm "+ searchTerm+"was not found in: \n"+searchResultText);
        }
    }
}
