package controls;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class BaseControl {
    public Browser browser;

    public By findBy;


    protected BaseControl(Browser browser, By findBy) {
        this.browser = browser;
        this.findBy = findBy;
    }

    public WebElement getElement() {
       return browser.getWebDriver().findElement(findBy);
    }
}
