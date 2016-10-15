package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rchepkunova on 15.10.2016.
 */
public class YandexMarketPage extends  BasePage{
    @FindBy(css = "li[data-department='Электроника']")
    private WebElement electronicDevicesLink;

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    public ElectronicDevicesPage isElectronicDevicesPageOpened(){
        waitForVisibilityOf(electronicDevicesLink, 30);
        electronicDevicesLink.click();
        return PageFactory.initElements(driver, ElectronicDevicesPage.class);
    }



}
