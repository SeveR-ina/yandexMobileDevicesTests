package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cherr on 15-Oct-16.
 */
public class MobileDevicesPage extends BasePage {
    @FindBy(css = "li[data-name=\"catalog\"]")
    private WebElement catalog;

    public MobileDevicesPage(WebDriver driver) {
        super(driver);
    }

}
