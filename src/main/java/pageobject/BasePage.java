package pageobject;

import common.Browser;
import org.openqa.selenium.By;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class BasePage {
    protected Browser browser;

    protected By by;

    public BasePage(Browser browser) {
        this.browser = browser;
    }
}
