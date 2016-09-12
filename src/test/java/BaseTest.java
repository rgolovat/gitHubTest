import common.Browser;
import common.BrowserType;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;

/**
 * Created by rgolovatyi on 9/12/2016.
 */

@RunWith(Parameterized.class)
public class BaseTest {
    protected static Browser browser;


    public BaseTest(BrowserType browserType) {
        super();
        browser = new Browser(browserType);
    }

    @Parameterized.Parameters
    public static java.util.Collection browsersStrings(){
        return Arrays.asList(new Object[][]{
               // {BrowserType.CHROME},
                {BrowserType.FIREFOX},
                //{BrowserType.SAFARI},
//                {BrowserType.IE},
//                {BrowserType.PHANTOM},
//                {BrowserType.CHROME_REMOTE},
                //{BrowserType.FIREFOX_REMOTE},
                //{BrowserType.IE_REMOTE}

        });
    }

    @After
    public void after() {
        browser.close();
    }

}
