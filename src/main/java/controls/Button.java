package controls;

import common.Browser;
import org.openqa.selenium.By;


/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class Button extends BaseControl {

    public Button(Browser browser, By findBy) {
        super(browser, findBy);
    }

    public void click(){
       getElement().click();
    }
}
