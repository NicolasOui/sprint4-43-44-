import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


public class BaseUiTest {
    protected WebDriver driver;



    protected String browser = System.getProperty("browser", "chrome");

    protected MainPageAccordeon mainPageAccordeon;
    protected MainPageOrderForm mainPageOrderForm;
    protected MainPageTopOrderButton mainPageTopOrderButton;
    protected MainPageLogoSamokat mainPageLogoSamokat;
    protected MainPageLogoYandex mainPageLogoYandex;
    protected MainPageOrderFormNegativeHistory mainPageOrderFormNegativeHistory;

    @Before
    public void startBrowser() {

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.get("https://qa-scooter.praktikum-services.ru/");





        mainPageAccordeon = new MainPageAccordeon(driver);
        mainPageOrderForm = new MainPageOrderForm(driver);
        mainPageTopOrderButton = new MainPageTopOrderButton(driver);
        mainPageLogoSamokat = new MainPageLogoSamokat(driver);
        mainPageLogoYandex = new MainPageLogoYandex(driver);
        mainPageOrderFormNegativeHistory = new MainPageOrderFormNegativeHistory(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

