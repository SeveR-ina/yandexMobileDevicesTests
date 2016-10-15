package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rchepkunova on 18.08.2016.
 */
public class YandexPage extends BasePage {

    @FindBy(css = "a[data-id=\"market\"]")
    private WebElement marketLink;

    public YandexPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageVisible() {
        waitForVisibilityOf(marketLink, 20);
        return marketLink.isDisplayed();
    }

    public YandexMarketPage goToMarketPage(){
        marketLink.click();
        return PageFactory.initElements(driver, YandexMarketPage.class);
    }

}
