package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by cherr on 15-Oct-16.
 */
public class AdvancedSearchPage extends BasePage {
    @FindBy(id = "glf-pricefrom-var")
    private WebElement priceToInput;

    @FindBy(xpath = "//span[@class='title__content' and contains(text(), 'Диагональ экрана, \"')]")
    private WebElement spanDiagonal;

    @FindBy(xpath = "//a[@class='link link_theme_major n-filter-sorter__link i-bem link_js_inited' and contains(text(), 'по новизне')]")
    private WebElement sortByNew;

    @FindBy(xpath = "//span[@class='header2-menu__text' and contains(text(), 'Отложенные')]")
    private WebElement savedMobilePhones;

    @FindBy(id = "glf-2142557926-from")
    private WebElement diagonalFromInput;

    @FindBy(id = "glf-1801946-1871375")
    private WebElement appleMobilePhonesCheckBox;

    @FindBy(id = "glf-1801946-1871447")
    private WebElement samsungMobilePhonesCheckBox;

    @FindBy(id = "glf-1801946-1871499")
    private WebElement lgMobilePhonesCheckBox;

    @FindBy(id = "glf-1801946-1871023")
    private WebElement sonyMobilePhonesCheckBox;

    @FindBy(id = "glf-1801946-11756910")
    private WebElement htcMobilePhonesCheckBox;

    @FindAll({@FindBy(xpath = "//span[@class='n-product-toolbar__item-label n-product-toolbar__item-label_activated_no' and contains(text(), 'Отложить')]")})
    private List<WebElement> saveThisPhoneList;

    //@FindBy(css = "div[class='n-filter-panel-aside__apply']")
    //private WebElement applyButton;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public void chooseSettings() {
        printIntoField("20000", priceToInput);
        scrollDownPage();
        System.out.println("lala" + spanDiagonal.getAttribute("Диагональ экрана, \""));
        waitForVisibilityOf(spanDiagonal);
        if (spanDiagonal.isDisplayed())
        {
            spanDiagonal.click();
            printIntoField("3", diagonalFromInput);
        }

        chooseMobileCompanies();
    }

    private void scrollDownPage(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,750)", "");
    }

    private void scrollUpPage(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, -750)", "");
    }

    private void printIntoField(String text, WebElement input){
        waitForVisibilityOf(input);
        input.click();
        input.clear();
        input.sendKeys(text);
    }

    private void chooseMobileCompanies(){
        appleMobilePhonesCheckBox.click();
        samsungMobilePhonesCheckBox.click();
        lgMobilePhonesCheckBox.click();
        sonyMobilePhonesCheckBox.click();
        htcMobilePhonesCheckBox.click();
    }

    public boolean isMobilePhoneSaved() {
        scrollUpPage();
        for (WebElement element : saveThisPhoneList) {
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
            if (savedMobilePhones.getText().equals("1")) return true;
            break;
        }
       return false;
    }

    public SavedMobilePhonesPage goToSavedMobilePhonesPage(){
        savedMobilePhones.click();
        return PageFactory.initElements(driver, SavedMobilePhonesPage.class);
    }
}
