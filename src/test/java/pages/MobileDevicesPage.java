package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cherr on 15-Oct-16.
 */
public class MobileDevicesPage extends BasePage {
    @FindBy(css = "a[class=\"black\"]")
    private WebElement advancedSearch;

    public MobileDevicesPage(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchPage goToAdvancedSearchPage(){
        advancedSearch.click();
        return PageFactory.initElements(driver, AdvancedSearchPage.class);
    }
}
