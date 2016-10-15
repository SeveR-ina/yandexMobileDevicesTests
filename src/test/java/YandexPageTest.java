import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.YandexPage;
import pages.YandexMarketPage;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Created by rchepkunova on 18.08.2016.
 */
public class YandexPageTest extends MainOperations {
    private YandexPage yandexPage;
    public YandexPageTest() throws IOException {
        super();
    }

    @BeforeTest
    @Parameters("browserName")
    public void setUp(String browserName) throws IOException{
        openBrowser(browserName);
        driver.get(testProperties.getProperty("siteUrl"));
        yandexPage = PageFactory.initElements(driver, YandexPage.class);
    }

    @AfterClass
    public void tearDown() throws Exception {
        quitBrowser();
    }

    @Test(priority = 1)
    public void  goToMarketPage() {
        assertTrue(yandexPage.isHomePageVisible());
        YandexMarketPage yandexMarketPage = yandexPage.goToMarketPage();
        assertNotNull(yandexMarketPage);
    }

}
