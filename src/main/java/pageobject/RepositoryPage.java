package pageobject;

import common.Browser;
import controls.Button;
import controls.TextEdit;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class RepositoryPage extends MainPage {

    public RepositoryPage(Browser browser) {
        super(browser);
    }

    @FindBy(how = How.CSS, using = ".btn-sm")
    public Button newRepository;

    @FindBy(how = How.ID, using = "repository_name")
    public TextEdit repositoryName;

    @FindBy(how = How.CSS, using = ".first-in-line")
    public Button createRepository;

    @FindBy(how = How.XPATH, using = "//strong/a")
    public TextEdit newRepositoryName;
}
