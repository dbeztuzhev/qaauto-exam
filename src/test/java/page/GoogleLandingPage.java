package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleLandingPage extends GoogleBasePage {
    @FindBy(id = "lst-ib")
    private WebElement searchField;

    public GoogleLandingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsClickable(searchField, 10);
    }

    public boolean isPageLoaded() {
        return searchField.isDisplayed();
    }


    public GoogleSearchResultsPage startSearch(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new GoogleSearchResultsPage(webDriver);
    }
}
