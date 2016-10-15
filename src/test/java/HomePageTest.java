import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.HomePage;
import pages.MarketMainPage;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Created by rchepkunova on 18.08.2016.
 */
public class HomePageTest extends MainOperations {
    private HomePage homePage = null;
    public HomePageTest() throws IOException {
        super();
    }

    @BeforeTest
    @Parameters("browserName")
    public void openBrowsers(String browserName) throws IOException{
        openBrowser(browserName);
        driver.get(testProperties.getProperty("siteUrl"));
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterClass
    public void tearDown() throws Exception {
         quitBrowser();
    }

    @Test(priority = 1)
    public void isHomePageVisibleTest() {
        assertTrue(homePage.isHomePageVisible());
    }

    @Test(dependsOnMethods = { "isHomePageVisibleTest" })
    public void goToMarketPage() {
        MarketMainPage marketMainPage = homePage.goToMarketPage();
        assertNotNull(marketMainPage);
    }

}
