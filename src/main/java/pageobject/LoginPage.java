package pageobject;

import common.Browser;
import controls.Button;
import controls.TextEdit;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class LoginPage extends BasePage{

    public LoginPage(Browser browser) {
        super(browser);
    }

    @FindBy(how = How.ID, using = "login_field")
    public TextEdit loginField;

    @FindBy(how = How.ID, using = "password")
    public TextEdit password;

    @FindBy(how = How.CSS, using = ".btn.btn-primary.btn-block")
    public Button signIn;


}
