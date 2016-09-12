package pageobject;

import common.Browser;
import controls.Button;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class MainPage extends BasePage {

    public MainPage(Browser browser) {
        super(browser);
    }

    @FindBy(how = How.CSS, using = ".btn.site-header-actions-btn.mr-2")
    public Button signInButton;
}
