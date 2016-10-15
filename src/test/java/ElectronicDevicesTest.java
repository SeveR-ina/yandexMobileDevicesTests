import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ElectronicDevicesPage;
import pages.MobileDevicesPage;
import pages.YandexMarketPage;
import pages.YandexPage;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;

/**
 * Created by cherr on 15-Oct-16.
 */
public class ElectronicDevicesTest extends  MainOperations {
    private ElectronicDevicesPage electronicDevicesPage;

    public ElectronicDevicesTest() throws IOException {
        super();
    }

    @BeforeTest
    @Parameters("browserName")
    public void setUp(String browserName) throws IOException{
        openBrowser(browserName);
        driver.get(testProperties.getProperty("siteUrl"));
        YandexPage yandexPage = PageFactory.initElements(driver, YandexPage.class);
        YandexMarketPage yandexMarketPage = yandexPage.goToMarketPage();
        electronicDevicesPage = yandexMarketPage.isElectronicDevicesPageOpened();
    }

    @AfterClass
    public void tearDown() throws Exception {
        quitBrowser();
    }

    @Test(priority = 1)
    public void goToMobileDevicesPage(){
        MobileDevicesPage mobileDevicesPage = electronicDevicesPage.goToMobileDevices();
        assertNotNull(mobileDevicesPage);
    }

}
