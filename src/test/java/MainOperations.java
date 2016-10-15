import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/**
 * Created by rchepkunova on 18.08.2016.
 */
abstract class MainOperations {
    WebDriver driver;
    Properties testProperties = new Properties();

    MainOperations() throws IOException {
        String propertiesPath = "src\\test\\resources\\test.properties";
        FileInputStream testPropertiesFile = new FileInputStream(propertiesPath);
        testProperties.load(testPropertiesFile);
    }

    void openBrowser(String browserName) throws IOException {
        if(browserName.equalsIgnoreCase("firefox")) {
            openFireFox();
        }
        else if (browserName.equalsIgnoreCase("chrome")){
            openChrome();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void openChrome() throws IOException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", testProperties.getProperty("chromeDir"));
        driver = new ChromeDriver(capabilities);
        System.out.println("Chrome Launched Successfully");
    }

    private void openFireFox() throws IOException{
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", testProperties.getProperty("geckoDir"));
        capabilities.setCapability("marionette", true);
        capabilities.setCapability("binary", "  firefoxDir");
        driver = new MarionetteDriver(capabilities);
        System.out.println("Firefox Launched Successfully");
    }

    void quitBrowser() throws Exception {
        driver.quit();
    }
}
