package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GoogleBasePage {
    protected WebDriver webDriver;

    public GoogleBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Method to expand loading page time by waiting for element to be visible
     * @param webElement - element expected to load
     * @param timeOutInSeconds - period of time to wait for element loading
     * @return - loaded element
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

}
