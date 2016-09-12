import common.BrowserType;
import common.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.PageObjectFactory;
import pageobject.RepositoryPage;

import java.util.Random;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class GithubTest extends BaseTest{

    public GithubTest(BrowserType browserType) {
        super(browserType);
    }

    @Test
    public void loginTest(){

        browser.navigateToUrl(TestConfiguration.getProperty("github.url"));
        MainPage mainPage = PageObjectFactory.getPage(browser, MainPage.class);
        mainPage.signInButton.click();


        LoginPage loginPage = PageObjectFactory.getPage(browser, LoginPage.class);
        loginPage.loginField.setStringValue(TestConfiguration.getProperty("github.username"));
        loginPage.password.setStringValue(TestConfiguration.getProperty("github.password"));
        loginPage.signIn.click();

        RepositoryPage repositoryPage = PageObjectFactory.getPage(browser, RepositoryPage.class);
        repositoryPage.newRepository.click();

        Random random = new Random();
        String repositoryName = "Test"+ random.nextInt(100 - 5 + 1) + 3;
        repositoryPage.repositoryName.setStringValue(repositoryName);
        repositoryPage.createRepository.click();

        Assert.assertTrue("Not correct repository name, should be " + repositoryName  + "but is" + repositoryPage.newRepositoryName.getValue()  ,repositoryName.equals(repositoryPage.newRepositoryName.getValue()));



    }
}
