package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleLandingPage;

public class GoogleBaseTest {
    WebDriver webDriver;
    GoogleLandingPage googleLandingPage;

    /**
     * Method to be executed before each test - opens browser and landing url
     * @param browserType - browser test to be executed in, open Test suits *xml documents to parametrize a value. Default value is placed in Optional annotation
     */
    @Parameters({"browserType"})
    @BeforeMethod
    public void beforeTest(@Optional("chrome") String browserType) {

        if ("firefox".equals(browserType.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();

        } else {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }

        webDriver.navigate().to("https://www.google.com/");
        googleLandingPage = new GoogleLandingPage(webDriver);
    }

    /**
     * Method to be executed after each test - closes browser
     */
    @AfterMethod
    public void after() {

        webDriver.close();
    }
}

