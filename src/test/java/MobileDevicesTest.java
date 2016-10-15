import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AdvancedSearchPage;
import pages.MobileDevicesPage;
import pages.YandexMarketPage;
import pages.YandexPage;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * Created by cherr on 15-Oct-16.
 */
public class MobileDevicesTest extends MainOperations {
    MobileDevicesPage mobileDevicesPage;

    public MobileDevicesTest() throws IOException {
        super();
    }

    @BeforeTest
    @Parameters("browserName")
    public void setUp(String browserName) throws IOException{
        openBrowser(browserName);
        driver.get(testProperties.getProperty("siteUrl"));
        YandexPage yandexPage = PageFactory.initElements(driver, YandexPage.class);
        YandexMarketPage yandexMarketPage = yandexPage.goToMarketPage();
        yandexMarketPage.goToMobileDevices();
        mobileDevicesPage = yandexMarketPage.goToMobileDevices();
    }

    @AfterClass
    public void tearDown() throws Exception {
        quitBrowser();
    }

    @Test(priority = 1)
    public void goToAdvancedSearchPage(){
        AdvancedSearchPage advancedSearchPage = mobileDevicesPage.goToAdvancedSearchPage();
        assertNotNull(advancedSearchPage);
    }
}
