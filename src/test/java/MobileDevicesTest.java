import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by cherr on 15-Oct-16.
 */
public class MobileDevicesTest extends MainOperations {
    private MobileDevicesPage mobileDevicesPage;

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
        ElectronicDevicesPage electronicDevicesPage = yandexMarketPage.isElectronicDevicesPageOpened();
        mobileDevicesPage = electronicDevicesPage.goToMobileDevices();
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
