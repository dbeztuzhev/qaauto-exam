package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Search results Page Object class
 */
public class GoogleSearchResultsPage extends GoogleBasePage {
    @FindBy(xpath = "//div[@class='srg']/div")
    private List<WebElement> searchResultsList;

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    /**
     * Constructor of Search results Page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public GoogleSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsClickable(searchField, 10);
    }

    /**
     * Method to get a list of search results text from a list of web elements
     * @return - list of text elements from search results
     */
    public List<String> getSearchResultsText() {
        List<String> searchResultsText = new ArrayList();
        for (WebElement searchResult : searchResultsList) {
            String searchResultText = searchResult.getText();
            searchResultsText.add(searchResultText);
        }
        return searchResultsText;
        }

    /**
     * Method to check switching to the next Search results Page object
     * @param pageNumber - insert the number of page you was switching to
     * @return - true if page is switched, false if it is not switched
     */
    public boolean isResultsPageSwitched(int pageNumber) {
        return webDriver.findElement(By.xpath("//td[@class='cur'][text()='"+pageNumber+"']")).isDisplayed();
    }

    /**
     * Method to switch to a new Search results page
     * @param pageNumberToSwitch - insert the number of page you need to switch to
     * @return - Page object of new Search Results page
     */
    public GoogleSearchResultsPage switchToPage(int pageNumberToSwitch) {
        webDriver.findElement(By.xpath("//a[@aria-label='Page "+pageNumberToSwitch+"']")).click();
        return new GoogleSearchResultsPage(webDriver);
    }
}
