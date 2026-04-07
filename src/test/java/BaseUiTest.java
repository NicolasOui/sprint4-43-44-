import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage; // Импортируем наш единый класс
import pages.OrderPage;

public class BaseUiTest {
    protected WebDriver driver;
    protected String browser = System.getProperty("browser", "chrome");
    protected MainPage mainPage;
    protected OrderPage OrderPage;

    @Before
    public void startBrowser() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.get("https://qa-scooter.praktikum-services.ru/");

        mainPage = new MainPage(driver);
        OrderPage = new OrderPage(driver);
    }

    @After
   public void tearDown() {
        driver.quit();
    }
}