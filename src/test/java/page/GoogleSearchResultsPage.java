package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage extends GoogleBasePage {
    @FindBy(xpath = "//div[@class='srg']/div")
    private List<WebElement> searchResultsList;

    @FindBy(id = "lst-ib")
    private WebElement searchField;


    public GoogleSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsClickable(searchField, 10);
    }

    public List<String> getSearchResultsText() {
        List<String> searchResultsText = new ArrayList();
        for (WebElement searchResult : searchResultsList) {
            String searchResultText = searchResult.getText();
            searchResultsText.add(searchResultText);
        }
        return searchResultsText;
        }

    public boolean isResultsPageSwitched(int pageNumber) {
        return webDriver.findElement(By.xpath("//td[@class='cur'][text()='"+pageNumber+"']")).isDisplayed();
    }

    public GoogleSearchResultsPage switchToPage(int pageNumberToSwitch) {
        webDriver.findElement(By.xpath("//a[@aria-label='Page "+pageNumberToSwitch+"']")).click();
        return new GoogleSearchResultsPage(webDriver);
    }
}
