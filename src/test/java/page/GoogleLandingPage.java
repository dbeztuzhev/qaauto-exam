package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Landing Page Object class
 */
public class GoogleLandingPage extends GoogleBasePage {
    @FindBy(id = "lst-ib")
    private WebElement searchField;

    /**
     * Constructor of Landing page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public GoogleLandingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsClickable(searchField, 10);
    }

    /**
     * Method to check the loading of Landing page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return searchField.isDisplayed();
    }

    /**
     * Method to search for any search term
     * @param searchTerm - insert term you want to search for
     * @return - new object of Search results page class
     */
    public GoogleSearchResultsPage startSearch(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new GoogleSearchResultsPage(webDriver);
    }
}
