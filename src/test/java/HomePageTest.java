import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.MarketMainPage;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Created by rchepkunova on 18.08.2016.
 */
public class HomePageTest extends MainOperations {


    public HomePageTest() throws IOException {
        super(true);
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
