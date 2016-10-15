package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rchepkunova on 14.10.2016.
 */
public class YandexMarketPage extends  BasePage{
    @FindBy(css = "li[data-name=\"catalog\"]")
    private WebElement catalog;
    @FindBy(xpath = "//a[@class='link catalog-simple__list-item' and contains(text(), 'Мобильные телефоны')]")
    private WebElement mobileDevicesLink;
   private final By mobileDevicesLinkBy = By.xpath("//a[@class='link catalog-simple__list-item' and contains(text(), 'Мобильные телефоны')]");

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isCatalogOpened(){
        waitForVisibilityOf(catalog);
        catalog.click();
        waitForVisibilityOfElementLocated(mobileDevicesLinkBy, 20);
        if (mobileDevicesLink.isDisplayed()) return true;
        return false;
    }

    public MobileDevicesPage goToMobileDevices(){
        mobileDevicesLink.click();
        return PageFactory.initElements(driver, MobileDevicesPage.class);
    }

}
