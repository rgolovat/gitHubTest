package controls;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BasePage;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class TextEdit extends BaseControl {


    public TextEdit(Browser browser, By findBy) {
        super(browser, findBy);
    }

    @Override
    public WebElement getElement() {
        return super.getElement();
    }

    public void setStringValue(String text) {
        WebElement textEdit = getElement();
        textEdit.click();
        textEdit.sendKeys(text);
    }

    public String getValue() {
        return getElement().getText();
    }

}
