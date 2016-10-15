import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;

/**
 * Created by cherr on 15-Oct-16.
 */
public class SavedMobilePhonesTest extends MainOperations {
    private SavedMobilePhonesPage savedMobilePhonesPage;
    private AdvancedSearchPage advancedSearchPage;

    public SavedMobilePhonesTest() throws IOException {
        super();
    }

    @BeforeTest
    @Parameters("browserName")
    public void setUp(String browserName) throws IOException {
        openBrowser(browserName);
        driver.get(testProperties.getProperty("siteUrl"));
        YandexPage yandexPage = PageFactory.initElements(driver, YandexPage.class);
        YandexMarketPage yandexMarketPage = yandexPage.goToMarketPage();
        ElectronicDevicesPage electronicDevicesPage = yandexMarketPage.isElectronicDevicesPageOpened();
        MobileDevicesPage mobileDevicesPage = electronicDevicesPage.goToMobileDevices();
        advancedSearchPage = mobileDevicesPage.goToAdvancedSearchPage();
    }

    @AfterClass
    public void tearDown() throws Exception {
        quitBrowser();
    }
    @Test(priority = 1)
    public void saveMobilePhone(){
        advancedSearchPage.chooseSettings();
        assertNotNull(advancedSearchPage.isMobilePhoneSaved());
        advancedSearchPage.changeSort();
    }

    @Test(priority = 2)
    public void goToSavedMobilePhones(){
        savedMobilePhonesPage = advancedSearchPage.goToSavedMobilePhonesPage();
        assertNotNull(savedMobilePhonesPage);
    }
    @Test(priority = 3)
    public void printRatingOfMobilePhone() {
        String text = savedMobilePhonesPage.getRaitingText();
        assertNotNull(text);
        System.out.println("Mobile Phone Rating = " + text);
    }
}
