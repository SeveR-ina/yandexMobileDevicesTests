package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cherr on 15-Oct-16.
 */
public class SavedMobilePhonesPage extends BasePage{

    @FindBy(xpath = "//div[@class='rating rating_outline_yes hint i-bem hint_js_inited']")
    private WebElement rating;

    public SavedMobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public String getRaitingText(){
        waitForVisibilityOf(rating);
        if (rating.isDisplayed()) return rating.getText();
        return null;
    }
}
