import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.MobileDevicesPage;
import pages.YandexPage;
import pages.YandexMarketPage;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

/**
 * Created by rchepkunova on 14.10.2016.
 */
public class YandexMarketTest extends MainOperations{

    private YandexMarketPage yandexMarketPage;

    public YandexMarketTest() throws IOException {
        super();
    }

    @BeforeTest
    @Parameters("browserName")
    public void openBrowsers(String browserName) throws IOException{
        openBrowser(browserName);
        driver.get(testProperties.getProperty("siteUrl"));
        YandexPage yandexPage = PageFactory.initElements(driver, YandexPage.class);
        yandexMarketPage = yandexPage.goToMarketPage();
    }

    @AfterClass
    public void tearDown() throws Exception {
        quitBrowser();
    }

    @Test(priority = 1)
    public void goToCatalog(){
        assertNotNull(yandexMarketPage);
        assertTrue(yandexMarketPage.isCatalogOpened());
    }

    @Test (dependsOnMethods = { "goToCatalog" })
    public void goToMobileDevicesPage(){
        MobileDevicesPage mobileDevicesPage = yandexMarketPage.goToMobileDevices();
        assertNotNull(mobileDevicesPage);
    }

}
