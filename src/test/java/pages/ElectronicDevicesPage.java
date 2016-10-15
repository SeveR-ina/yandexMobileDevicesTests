package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cherr on 15-Oct-16.
 */
public class ElectronicDevicesPage extends BasePage {


    @FindBy(xpath = "//a[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited' and contains(text(), 'Мобильные телефоны')]")
    private WebElement mobileDevicesLink;
    //private final By mobileDevicesLinkBy = By.xpath("//a[@class='link catalog-simple__list-item' and contains(text(), 'Мобильные телефоны')]");


    public ElectronicDevicesPage(WebDriver driver) {
        super(driver);
    }


    public MobileDevicesPage goToMobileDevices(){
        mobileDevicesLink.click();
        return PageFactory.initElements(driver, MobileDevicesPage.class);
    }
}
