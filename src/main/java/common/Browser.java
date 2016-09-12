package common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class Browser {

    private WebDriver webDriver;
    public EventFiringWebDriver driver;



    public Browser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("chromedriver.exe").getPath());
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                setupEventListener();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource("chromedriver.exe").getPath());
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                setupEventListener();
                break;

        }

    }


    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }



    public EventFiringWebDriver getWebDriver() {
        return driver;
    }


    public void close() {
        driver.close();
        webDriver.quit();
    }

    private void setupEventListener(){
        driver = new EventFiringWebDriver(webDriver);
        EventListener eventListener = new EventListener();
        driver.register(eventListener);
    }

}
